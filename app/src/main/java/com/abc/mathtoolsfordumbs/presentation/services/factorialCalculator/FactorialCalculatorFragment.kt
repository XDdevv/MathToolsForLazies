package com.abc.mathtoolsfordumbs.presentation.services.factorialCalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.abc.mathtoolsfordumbs.R
import com.abc.mathtoolsfordumbs.databinding.FragmentFactorialCalculatorBinding
import com.abc.mathtoolsfordumbs.presentation.services.factorialCalculator.vm.FactorialCalculatorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FactorialCalculatorFragment : Fragment() {

    private var _binding: FragmentFactorialCalculatorBinding? = null
    private val binding get() = _binding!!

    val viewModel by viewModels<FactorialCalculatorViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFactorialCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.numberEt.requestFocus()

        binding.calculateBtn.setOnClickListener {
            val number = binding.numberEt.text.toString().toIntOrNull()
            if (number != null) {
                val factorial = viewModel.calculateFactorial(number)
                showResult(factorial.toString())
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
            binding.resultCardCv.visibility = View.VISIBLE
            binding.resultTv.text = getString(R.string.javob, result)
        } else {
            binding.resultCardCv.visibility = View.VISIBLE
            binding.resultTv.text = getString(R.string.raqamni_kiriting)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}