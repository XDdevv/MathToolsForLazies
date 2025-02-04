package com.abc.mathtoolsfordumbs.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard() {
    val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val view = requireActivity().currentFocus ?: View(requireContext())
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}