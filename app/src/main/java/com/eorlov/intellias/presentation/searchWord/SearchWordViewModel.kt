package com.eorlov.intellias.presentation.searchWord

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eorlov.intellias.domain.common.Result
import com.eorlov.intellias.domain.usecases.GetNewWordUseCase
import com.eorlov.intellias.presentation.entities.WordInfo
import com.eorlov.intellias.presentation.mappers.WordInfoMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchWordViewModel @Inject constructor(
    private val getNewWordUseCase: GetNewWordUseCase,
    private val mapper: WordInfoMapper
) : ViewModel() {

    val meaningsListLiveData = MutableLiveData<WordInfo>()
    val loadingLiveData = MutableLiveData(true)
    val errorLiveData = MutableLiveData<String>()

    fun getWord(word: String) {
        viewModelScope.launch {
            when (val wordResult = getNewWordUseCase.invoke(word)) {
                is Result.Success -> {
                    meaningsListLiveData.postValue(
                        mapper.fromWordToWordInfo(wordResult.data)
                    )
                    loadingLiveData.postValue(false)
                }
                is Result.Error -> {
                    loadingLiveData.postValue(false)
                    errorLiveData.postValue(wordResult.exception.message)
                }
                else -> {
                    println("Something went wrong!")
                }
            }
        }
    }
}
