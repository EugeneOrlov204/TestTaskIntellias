package com.eorlov.intellias.presentation.searchWord.adapter.diffCallback

import androidx.recyclerview.widget.DiffUtil
import com.eorlov.intellias.presentation.entities.Meaning

class WordMeaningsItemDiffCallback : DiffUtil.ItemCallback<Meaning>() {
    override fun areItemsTheSame(oldItem: Meaning, newItem: Meaning): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Meaning, newItem: Meaning): Boolean =
        oldItem == newItem
}