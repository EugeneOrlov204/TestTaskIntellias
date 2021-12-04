package com.eorlov.intellias.presentation.searchWord.adapter.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.eorlov.domain.databinding.LayoutWordMeaningItemBinding
import com.eorlov.intellias.presentation.entities.Meaning

class WordMeaningsViewHolder(
    private val binding: LayoutWordMeaningItemBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindTo(meaning: Meaning) {
        binding.textViewDefinition.text = meaning.definitions[0].definition
        binding.textViewPartOfSpeech.text = meaning.partOfSpeech
    }
}