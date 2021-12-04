package com.eorlov.intellias.presentation.searchWord

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.eorlov.domain.R
import com.eorlov.domain.databinding.FragmentSearchWordBinding
import com.eorlov.intellias.presentation.base.BaseFragment
import com.eorlov.intellias.presentation.entities.WordInfo
import com.eorlov.intellias.presentation.ext.clickWithDebounce
import com.eorlov.intellias.presentation.ext.hideKeyboard
import com.eorlov.intellias.presentation.searchWord.adapter.WordMeaningsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchWordFragment :
    BaseFragment<FragmentSearchWordBinding>(FragmentSearchWordBinding::inflate) {

    private val viewModel: SearchWordViewModel by viewModels()
    private val wordAdapter by lazy(LazyThreadSafetyMode.NONE) {
        WordMeaningsAdapter()
    }

    override fun initialize() {
        initRecycler()
    }

    override fun setListeners() {
        binding.root.setOnClickListener {
            it.hideKeyboard()
        }

        binding.buttonSearch.clickWithDebounce {
            findWord()
        }

        binding.textInputEditTextSearchField.setOnEditorActionListener { _, _, _ ->
            findWord()
            false
        }
    }

    override fun setObservers() {
        viewModel.run {
            meaningsListLiveData.observe(viewLifecycleOwner) {
                view?.hideKeyboard()
                wordAdapter.submitList(it.meanings.toMutableList())
                binding.run {
                    textViewMeanings.text = getMeaningsText(it)
                    textViewWord.text = getWordText(it)
                    textViewPhonetic.text = getPhonetic(it)
                }
            }
            loadingLiveData.observe(viewLifecycleOwner) {isLoading ->
                if(isLoading) lockUI()
                else unlockUI()
            }
            errorLiveData.observe(viewLifecycleOwner) {
                val result = if(it.isNotEmpty()) it else getString(R.string.not_found_word_message)
                Toast.makeText(requireContext(), result, Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun lockUI() {
        super.lockUI()
        binding.progressBarLoading.visibility = View.VISIBLE
    }

    override fun unlockUI() {
        super.unlockUI()
        binding.progressBarLoading.visibility = View.GONE
    }

    private fun initRecycler() {
        binding.recyclerViewMeanings.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = wordAdapter
        }
    }

    private fun findWord() {
        val word = binding.textInputEditTextSearchField.text.toString()
        viewModel.getWord(word)
    }

    private fun getPhonetic(it: WordInfo) =
        "Phonetic: ${it.phonetic}"

    private fun getWordText(it: WordInfo) =
        "Word: ${it.word}"

    private fun getMeaningsText(it: WordInfo) =
        if (it.meanings.isNotEmpty()) context?.getString(R.string.meanings)
        else ""
}