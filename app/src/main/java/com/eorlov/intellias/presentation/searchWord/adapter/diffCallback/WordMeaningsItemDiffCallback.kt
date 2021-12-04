package com.eorlov.intellias.presentation.searchWord.adapter.diffCallback

import androidx.recyclerview.widget.DiffUtil
import com.eorlov.intellias.presentation.entities.MeaningInfo

class WordMeaningsItemDiffCallback : DiffUtil.ItemCallback<MeaningInfo>() {
    override fun areItemsTheSame(oldItem: MeaningInfo, newItem: MeaningInfo): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: MeaningInfo, newItem: MeaningInfo): Boolean =
        oldItem == newItem
}