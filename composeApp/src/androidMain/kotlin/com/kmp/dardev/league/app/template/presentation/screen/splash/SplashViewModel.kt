package com.kmp.dardev.league.app.template.presentation.screen.splash

import androidx.lifecycle.ViewModel
import com.kmp.dardev.league.app.template.cache.session.ISessionCache

class SplashViewModel(
    private val sessionCache: ISessionCache,
) : ViewModel() {
    fun verifyTokenConnexionExist(): Boolean {
        val session = sessionCache.getActiveSession()
        return session != null
    }

    fun verifyOnBoardingIsCheck(): Boolean = sessionCache.getOnboarding()
}
