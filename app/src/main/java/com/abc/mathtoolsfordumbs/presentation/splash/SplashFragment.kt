package com.abc.mathtoolsfordumbs.presentation.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.abc.mathtoolsfordumbs.R
import com.abc.mathtoolsfordumbs.databinding.FragmentSplashBinding
import com.abc.mathtoolsfordumbs.utils.MyNavOption.setOption

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showTextWithAnimation()
    }

    private fun showTextWithAnimation() {
        val animationDuration =  1500L
        val text = getString(R.string.math_utils_for_lazies)
        val textLength = text.length
        var currentPosition = 0
        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                if (currentPosition < textLength) {
                    val newText = text.substring(0, currentPosition + 1)
                    binding.titleTv.text = newText
                    currentPosition++
                    handler.postDelayed(this, animationDuration / textLength)
            }
                else {
                    binding.titleTv.visibility = View.VISIBLE
                    findNavController().navigate(R.id.homeFragment, null, setOption(R.id.splashFragment))
                }
            }
        }
        handler.postDelayed(runnable, animationDuration)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}