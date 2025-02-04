package com.abc.mathtoolsfordumbs.utils

import android.app.Activity
import android.content.Intent

object Utils {
    fun share(activity: Activity) {
        val message = """
        📚 Matematik yordamchi ilovasi 📚
        
        Ushbu ilova boshlang‘ich va o‘rta darajadagi matematiklar uchun foydali vosita!  
        Siz sonning tub yoki tub emasligini tekshirishingiz, EKUB va EKUKni topishingiz hamda boshqa ko‘plab matematik vositalardan foydalanishingiz mumkin.  

        Yuklab olish uchun: https://t.me/mathtoolsforlazies
    """.trimIndent()

        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = "text/plain"
        }
        activity.startActivity(
            Intent.createChooser(
                shareIntent,
                "Matematik yordamchi ilovasini ulashing!"
            )
        )
    }
}