package com.abc.mathtoolsfordumbs.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.abc.mathtoolsfordumbs.R
import com.abc.mathtoolsfordumbs.databinding.FragmentHomeBinding
import com.abc.mathtoolsfordumbs.presentation.home.adapter.OptionsAdapter
import com.abc.mathtoolsfordumbs.presentation.home.vm.HomeViewModel
import com.abc.mathtoolsfordumbs.utils.MyNavOption.setOption
import com.abc.mathtoolsfordumbs.utils.Utils.share
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import com.abc.mathtoolsfordumbs.utils.Resource

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    val viewModel: HomeViewModel by viewModels()

    private lateinit var adapter: OptionsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = OptionsAdapter {
            findNavController().navigate(it.fragmentId, null, setOption())
        }

        binding.listRv.adapter = adapter

        binding.shareBtn.setOnClickListener {
            share(requireActivity())
        }

        observeDataFromVM()
    }

    private fun observeDataFromVM() {
        lifecycleScope.launch {
            viewModel.optionsState.collect { state ->
                when (state) {
                    is Resource.Error -> {
                        Toast.makeText(context, "Xatolik : ${state.message}", Toast.LENGTH_SHORT)
                            .show()
                    }

                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        val data = state.data
                        data?.let { adapter.submitList(it) }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}