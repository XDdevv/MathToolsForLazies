package com.abc.mathtoolsfordumbs.presentation.services.factorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.abc.mathtoolsfordumbs.R
import com.abc.mathtoolsfordumbs.databinding.FragmentFactorizationNumberBinding
import com.abc.mathtoolsfordumbs.presentation.services.factorization.vm.FactorizationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FactorizationNumberFragment : Fragment() {

    private var _binding: FragmentFactorizationNumberBinding? = null
    private val binding get() = _binding!!

    val viewModel: FactorizationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFactorizationNumberBinding.inflate(inflater, container, false)
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

        binding.calculateBtn.setOnClickListener {
            val number = binding.numberEt.text.toString().toIntOrNull()
            if (number != null) {
                val result = viewModel.factorizeNumber(number)
                showResult(result.toString())
            } else {
                binding.resultTv.text = getString(R.string.raqamni_kiriting)
                binding.resultCardCv.visibility = View.VISIBLE
            }
        }


    }

    fun showResult(result: String) {
        binding.resultCardCv.visibility = View.VISIBLE
        binding.resultTv.text = getString(R.string.javob, result)
        binding.numberEt.text.clear()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}