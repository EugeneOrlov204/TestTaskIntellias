package com.eorlov.intellias.presentation.searchWord

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.eorlov.domain.databinding.FragmentSearchWordBinding
import com.eorlov.intellias.presentation.base.BaseFragment
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
            val word = binding.textInputEditTextSearchField.text.toString()
            viewModel.getWord(word)
        }
    }

    override fun setObservers() {
        viewModel.run {
            meaningsListLiveData.observe(viewLifecycleOwner) {
                wordAdapter.submitList(it.meanings.toMutableList())
            }
            loadingLiveData.observe(viewLifecycleOwner) {

            }
            errorLiveData.observe(viewLifecycleOwner) {

            }
        }
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
}