package com.abc.mathtoolsfordumbs.presentation.services.ekubEkuk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.abc.mathtoolsfordumbs.R
import com.abc.mathtoolsfordumbs.databinding.FragmentEkubEkukFinderBinding
import com.abc.mathtoolsfordumbs.presentation.services.ekubEkuk.adapter.NumbersAdapter
import com.abc.mathtoolsfordumbs.presentation.services.ekubEkuk.vm.EkubEkukViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EkubEkukFinderFragment : Fragment() {

    private var _binding: FragmentEkubEkukFinderBinding? = null
    private val binding get() = _binding!!

    private lateinit var numbersAdapter: NumbersAdapter

    val viewModel : EkubEkukViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEkubEkukFinderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val type = arguments?.getString("title")

        if(type == "EKUB") {
            binding.titleTv.text = getString(R.string.ekub_ni_topish_uchun_raqamlarni_kiring_va_hisoblashni_bosing)
        } else if(type == "EKUK") {
            binding.titleTv.text = getString(R.string.ekuk_ni_topish_uchun_raqamlarni_kiring_va_hisoblashni_bosing)
        }

        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }

        numbersAdapter = NumbersAdapter()
        binding.numbersListRv.adapter = numbersAdapter

        binding.addNumberBtn.setOnClickListener {
            numbersAdapter.addNumber(0)
        }

        binding.calculateBtn.setOnClickListener {
            val numbers = numbersAdapter.getNumbers()
            if (numbers.isNotEmpty() && numbers.size >= 2 && numbers.all { it != 0 } ) {
                if(type == "EKUB"){
                    val ekub = viewModel.getEkub(numbers)
                    showResult(ekub)
                } else if (type == "EKUK"){
                    val ekuk = viewModel.getEkuk(numbers)
                    showResult(ekuk)
                }
            }  else {
                binding.resultTv.text =
                    getString(R.string.ekub_yoki_ekuk_ni_topish_uchun_kamida_2_ta_raqam_kiriting)
                binding.resultCardCv.visibility = View.VISIBLE
            }
        }

        binding.closeCardIv.setOnClickListener {
            binding.resultCardCv.visibility = View.GONE
        }
    }
    fun showResult(result: Int) {
        binding.resultCardCv.visibility = View.VISIBLE
        binding.resultTv.text = getString(R.string.javob, result.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}