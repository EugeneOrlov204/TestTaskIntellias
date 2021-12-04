package com.eorlov.intellias.presentation.searchWord.adapter.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.eorlov.domain.databinding.LayoutWordMeaningItemBinding
import com.eorlov.intellias.presentation.entities.MeaningInfo

class WordMeaningsViewHolder(
    private val binding: LayoutWordMeaningItemBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindTo(meaningInfo: MeaningInfo) {
        binding.textViewDefinition.text = meaningInfo.definitionInfos[0].definition
        binding.textViewPartOfSpeech.text = meaningInfo.partOfSpeech
    }
}