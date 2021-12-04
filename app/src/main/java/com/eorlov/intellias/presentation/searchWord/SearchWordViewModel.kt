package com.eorlov.intellias.presentation.searchWord

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eorlov.intellias.domain.common.Result
import com.eorlov.intellias.domain.usecases.GetNewWordUseCaseFromDatabase
import com.eorlov.intellias.domain.usecases.GetNewWordUseCaseFromDictionary
import com.eorlov.intellias.domain.usecases.SaveNewWordUseCase
import com.eorlov.intellias.presentation.entities.WordInfo
import com.eorlov.intellias.presentation.mappers.WordInfoMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchWordViewModel @Inject constructor(
    private val getNewWordUseCaseFromDictionary: GetNewWordUseCaseFromDictionary,
    private val saveNewWordUseCase: SaveNewWordUseCase,
    private val getNewWordUseCaseFromDatabase: GetNewWordUseCaseFromDatabase,
    private val mapper: WordInfoMapper
) : ViewModel() {

    val meaningsListLiveData = MutableLiveData<WordInfo>()
    val loadingLiveData = MutableLiveData(false)
    val errorLiveData = MutableLiveData<String>()

    fun getWord(word: String) {
        viewModelScope.launch {
            loadingLiveData.postValue(true)

            val wordFromDatabase = getNewWordUseCaseFromDatabase.invoke(word)

            if (wordFromDatabase != null) {
                meaningsListLiveData.postValue(mapper.fromWordToWordInfo(wordFromDatabase))
            } else {
                when (val wordResult = getNewWordUseCaseFromDictionary.invoke(word)) {
                    is Result.Success -> {
                        meaningsListLiveData.postValue(mapper.fromWordToWordInfo(wordResult.data))
                        saveNewWordUseCase.invoke(wordResult.data)
                    }
                    is Result.Error -> {
                        errorLiveData.postValue(wordResult.exception.message)
                    }
                    else -> {
                    }
                }
            }
            loadingLiveData.postValue(false)
        }
    }
}
