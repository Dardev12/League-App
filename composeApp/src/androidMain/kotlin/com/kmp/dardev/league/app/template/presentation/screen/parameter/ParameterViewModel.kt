package com.kmp.dardev.league.app.template.presentation.screen.parameter

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.kmp.dardev.league.app.template.cache.session.ISessionCache
import com.kmp.dardev.league.app.template.service.analytics.AnalyticsHelper
import java.util.*

class ParameterViewModel(
    private val sessionCache: ISessionCache,
    private val analyticsHelper: AnalyticsHelper,
) : ViewModel() {
    fun getUserID(): String = sessionCache.getActiveSession()?.dataSession?.currentUserGuid ?: ""

    fun analyticsEvent(
        eventName: String,
        params: Bundle? = null,
    ) {
        analyticsHelper.logEvent(eventName, params)
    }
}
