package com.kmp.dardev.league.app.template.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.google.android.play.core.review.ReviewManagerFactory
import java.util.Calendar

class ReviewManager(
    private val context: Context,
    private val activity: Activity,
) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("RatingPrefs", Context.MODE_PRIVATE)

    private val installationDateKey = "installation_date"

    fun checkAndShowRatingDialog() {
        val installationDate = sharedPreferences.getLong(installationDateKey, 0)

        if (installationDate == 0L) {
            // Première installation, enregistrez la date d'installation
            val currentDate = Calendar.getInstance().timeInMillis
            sharedPreferences.edit().putLong(installationDateKey, currentDate).apply()
        } else {
            // Vérifier si 3 jours se sont écoulés depuis l'installation
            val currentDate = Calendar.getInstance().timeInMillis
            val threeDaysInMillis = 3 * 24 * 60 * 60 * 1000 // 3 jours en millisecondes

            if (currentDate - installationDate >= threeDaysInMillis) {
                // Affichez le dialogue de notation ici
                showFeedbackDialog(context, activity)
            }
        }
    }

    private fun showFeedbackDialog(
        context: Context,
        activity: Activity,
    ) {
        val manager = ReviewManagerFactory.create(context)

        manager.requestReviewFlow().addOnCompleteListener {
            if (it.isSuccessful) {
                manager.launchReviewFlow(activity, it.result)
            }
        }
    }
}
