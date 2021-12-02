package com.eorlov.intellias.presentation.searchWord

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eorlov.domain.entities.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchWordViewModel @Inject constructor(

) : ViewModel() {
    fun addWord(newWord: Word) {
        viewModelScope.launch(Dispatchers.IO) {
//            interactors.addNewWordUseCase(newWord)
        }
    }
}
