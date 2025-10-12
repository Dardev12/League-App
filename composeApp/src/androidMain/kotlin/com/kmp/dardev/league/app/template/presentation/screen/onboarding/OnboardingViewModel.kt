package com.kmp.dardev.league.app.template.presentation.screen.onboarding

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.kmp.dardev.league.app.template.cache.session.ISessionCache
import com.kmp.dardev.league.app.template.service.analytics.AnalyticsHelper

class OnboardingViewModel(
    private val sessionCache: ISessionCache,
    private val analyticsHelper: AnalyticsHelper,
) : ViewModel() {
    fun onBoardingNavigationValidate() {
        sessionCache.saveOnboarding(true)
    }

    fun analyticsEvent(
        eventName: String,
        params: Bundle? = null,
    ) {
        analyticsHelper.logEvent(eventName, params)
    }
}
