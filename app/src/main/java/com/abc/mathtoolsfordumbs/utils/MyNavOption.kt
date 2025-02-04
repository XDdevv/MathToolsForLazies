package com.abc.mathtoolsfordumbs.utils

import androidx.navigation.NavOptions
import com.abc.mathtoolsfordumbs.R

object MyNavOption {

    fun setOption(fragment: Int): NavOptions {
        return NavOptions.Builder()
            .setEnterAnim(R.anim.fadein)
            .setExitAnim(R.anim.fadeout)
            .setPopEnterAnim(R.anim.fadein)
            .setPopExitAnim(R.anim.fadeout)
            .setPopUpTo(fragment, true)
            .build()
    }

    fun setOption(): NavOptions {
        return NavOptions.Builder()
            .setEnterAnim(R.anim.fadein)
            .setExitAnim(R.anim.fadeout)
            .setPopEnterAnim(R.anim.fadein)
            .setPopExitAnim(R.anim.fadeout)
            .build()
    }


}