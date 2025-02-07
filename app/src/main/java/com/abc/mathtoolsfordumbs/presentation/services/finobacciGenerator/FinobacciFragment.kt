package com.abc.mathtoolsfordumbs.presentation.services.finobacciGenerator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.abc.mathtoolsfordumbs.R
import com.abc.mathtoolsfordumbs.databinding.FragmentFinobacciBinding
import com.abc.mathtoolsfordumbs.presentation.services.finobacciGenerator.vm.FinobacciViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FinobacciFragment : Fragment() {

    private var _binding: FragmentFinobacciBinding? = null
    private val binding get() = _binding!!

    val viewModel by viewModels<FinobacciViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFinobacciBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.numberEt.requestFocus()

        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.calculateBtn.setOnClickListener {
            val number = binding.numberEt.text.toString().toIntOrNull()
            if (number != null) {
                val fibonacciNumbers = viewModel.generateFinobacciSquence(number)
                showResult(fibonacciNumbers.joinToString(", "))
            } else {
                showResult(null)
            }
        }

        binding.closeCardIv.setOnClickListener {
            binding.resultCardCv.visibility = View.GONE
        }

    }

    fun showResult(result: String?) {
        if (result != null) {
            binding.resultTv.text = result
            binding.resultCardCv.visibility = View.VISIBLE
        } else {
            binding.resultTv.text = getString(R.string.raqamni_kiriting)
            binding.resultCardCv.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}