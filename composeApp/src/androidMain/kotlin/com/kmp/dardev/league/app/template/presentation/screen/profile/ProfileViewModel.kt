package com.kmp.dardev.league.app.template.presentation.screen.profile

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmp.dardev.league.app.template.cache.clearSessionAndCancelWork
import com.kmp.dardev.league.app.template.cache.session.ISessionCache
import com.kmp.dardev.league.app.template.domain.use_cases.dao.UserUseCasesDAO
import com.kmp.dardev.league.app.template.service.analytics.AnalyticsHelper
import com.kmp.dardev.league.app.template.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val sessionCache: ISessionCache,
    private val userUseCasesDAO: UserUseCasesDAO,
    private val analyticsHelper: AnalyticsHelper,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private var job: Job? = null
    private val _userId: MutableStateFlow<String?> = MutableStateFlow(null)
    val userId: StateFlow<String?> = _userId

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val idUser = savedStateHandle.get<String>(Constants.PROFIL_USERID_ARGUMENT_KEY)
            _userId.value = idUser
        }
    }

    fun getActiveUserId(): String = sessionCache.getActiveSession()?.dataSession?.currentUserGuid ?: ""

    fun analyticsEvent(
        eventName: String,
        params: Bundle? = null,
    ) {
        analyticsHelper.logEvent(eventName, params)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun automateWorker(context: Context) {
        clearSessionAndCancelWork(sessionCache, context)
    }
}
