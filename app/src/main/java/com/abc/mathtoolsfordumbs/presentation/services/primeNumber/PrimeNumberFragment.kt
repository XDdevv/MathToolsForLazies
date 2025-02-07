package com.abc.mathtoolsfordumbs.presentation.services.primeNumber

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.abc.mathtoolsfordumbs.R
import com.abc.mathtoolsfordumbs.databinding.FragmentPrimeNumberBinding
import com.abc.mathtoolsfordumbs.databinding.FragmentSplashBinding
import com.abc.mathtoolsfordumbs.presentation.services.primeNumber.vm.PrimeNumberViewModel
import com.abc.mathtoolsfordumbs.utils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PrimeNumberFragment : Fragment() {

    private var _binding: FragmentPrimeNumberBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PrimeNumberViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPrimeNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.numberEt.requestFocus()

        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.closeCardIv.setOnClickListener {
            binding.resultCardCv.visibility = View.GONE
        }

        binding.checkBtn.setOnClickListener {
            val number = binding.numberEt.text.toString().toIntOrNull()
            if (number != null) {
                val isPrime = checkPrimeNumber(number)
                showResult(isPrime)
            } else {
                binding.resultTv.text = getString(R.string.raqamni_kiriting)
                binding.resultCardCv.visibility = View.VISIBLE
            }
        }
    }

    fun checkPrimeNumber(number: Int): Boolean {
        return viewModel.checkPrimeNumber(number)
    }

    fun showResult(isPrime: Boolean) {
        binding.resultCardCv.visibility = View.VISIBLE
        binding.resultTv.text =
            if (isPrime) getString(R.string.raqam_tub) else getString(R.string.raqam_tub_emas)
        binding.numberEt.text.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}