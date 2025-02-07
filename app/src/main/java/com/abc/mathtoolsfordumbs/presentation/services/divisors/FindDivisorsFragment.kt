package com.abc.mathtoolsfordumbs.presentation.services.divisors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.abc.mathtoolsfordumbs.R
import com.abc.mathtoolsfordumbs.databinding.FragmentFindDivisorsBinding
import com.abc.mathtoolsfordumbs.presentation.services.divisors.vm.FindDivisorsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FindDivisorsFragment : Fragment() {

    private var _binding: FragmentFindDivisorsBinding? = null
    private val binding get() = _binding!!

    val viewModel by viewModels<FindDivisorsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFindDivisorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.closeCardIv.setOnClickListener {
            binding.resultCardCv.visibility = View.GONE
        }

        binding.calculateBtn.setOnClickListener {
            val number = binding.numberEt.text.toString().toIntOrNull()
            if (number != null) {
                val divisors = viewModel.findDivisors(number)
                showResult(divisors)
            } else {
                binding.resultTv.text = getString(R.string.raqamni_kiriting)
                binding.resultCardCv.visibility = View.VISIBLE
            }
        }
    }

    private fun showResult(result: String) {
        binding.resultCardCv.visibility = View.VISIBLE
        binding.resultTv.text = getString(R.string.javob, result.toString())
        binding.numberEt.text.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}