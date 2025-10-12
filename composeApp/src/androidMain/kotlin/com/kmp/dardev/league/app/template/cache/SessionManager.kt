package com.kmp.dardev.league.app.template.cache

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.kmp.dardev.league.app.template.cache.session.ISessionCache
import com.kmp.dardev.league.app.template.cache.worker.RefreshSessionWorker
import java.util.concurrent.TimeUnit

@RequiresApi(Build.VERSION_CODES.O)
fun scheduleSessionRefresh(
    sessionCache: ISessionCache,
    context: Context,
) {
    val session = sessionCache.getActiveSession()

    if (session != null) {
        val refreshWorkRequest =
            PeriodicWorkRequestBuilder<RefreshSessionWorker>(
                24,
                TimeUnit.HOURS,
            ).build()

        WorkManager
            .getInstance(context)
            .enqueueUniquePeriodicWork(
                "RefreshSessionWork",
                ExistingPeriodicWorkPolicy.UPDATE,
                refreshWorkRequest,
            )
    }
}

fun clearSessionAndCancelWork(
    sessionCache: ISessionCache,
    context: Context,
) {
    sessionCache.clearSession()
    WorkManager.getInstance(context).cancelUniqueWork("RefreshSessionWork")
}
