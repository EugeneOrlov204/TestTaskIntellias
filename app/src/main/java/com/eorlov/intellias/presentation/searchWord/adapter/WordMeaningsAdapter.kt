package com.eorlov.intellias.presentation.searchWord.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.eorlov.domain.databinding.LayoutWordMeaningItemBinding
import com.eorlov.intellias.presentation.entities.Meaning
import com.eorlov.intellias.presentation.searchWord.adapter.diffCallback.WordMeaningsItemDiffCallback
import com.eorlov.intellias.presentation.searchWord.adapter.viewHolder.WordMeaningsViewHolder

class WordMeaningsAdapter() : ListAdapter<Meaning, WordMeaningsViewHolder>(
    WordMeaningsItemDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordMeaningsViewHolder {
        return WordMeaningsViewHolder(
            LayoutWordMeaningItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: WordMeaningsViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }
}