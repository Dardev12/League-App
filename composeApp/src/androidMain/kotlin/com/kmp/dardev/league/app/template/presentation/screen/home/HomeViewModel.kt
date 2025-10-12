package com.kmp.dardev.league.app.template.presentation.screen.home

import android.os.Bundle
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kmp.dardev.league.app.template.cache.session.ISessionCache
import com.kmp.dardev.league.app.template.service.analytics.AnalyticsHelper

class HomeViewModel(
    private val sessionCache: ISessionCache,
    private val analyticsHelper: AnalyticsHelper,
) : ViewModel() {
    var userId: MutableState<String> = mutableStateOf("")

    fun getUserID(): String = sessionCache.getActiveSession()?.dataSession?.currentUserGuid ?: ""

    fun analyticsEvent(
        eventName: String,
        params: Bundle? = null,
    ) {
        analyticsHelper.logEvent(eventName, params)
    }

    fun analyticsSetUserId(userId: String) {
        analyticsHelper.setUserId(userId)
    }
}
