package com.kmp.dardev.league.app.template.cache.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.kmp.dardev.league.app.template.cache.session.ISessionCache
import com.kmp.dardev.league.app.template.cache.session.Session
import com.kmp.dardev.league.app.template.domain.model.TokenConnexion

class RefreshSessionWorker(
    context: Context,
    workerParams: WorkerParameters,
    private val sessionCache: ISessionCache,
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {
        val session = sessionCache.getActiveSession()
        return if (session != null) {
            refreshSession(session)
            Result.success()
        } else {
            Result.failure()
        }
    }

    private suspend fun refreshSession(session: Session) {
        val token = session.dataSession.jwtToken
        val userId = session.dataSession.currentUserGuid

        val sessionRefresh = "test"
        val newSession =
            sessionRefresh?.let {
                Session(
                    "",
                    TokenConnexion("", ""),
                )
            }

        if (newSession != null) {
            sessionCache.saveSession(newSession)
        }
    }
}
