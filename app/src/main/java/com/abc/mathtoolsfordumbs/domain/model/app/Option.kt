package com.abc.mathtoolsfordumbs.domain.model.app

import android.os.Bundle

data class Option(
    val title: String,
    val fragmentId: Int,
    val bundle: Bundle? = null
)
