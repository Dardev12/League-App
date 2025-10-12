package com.kmp.dardev.league.app.template.di

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.kmp.dardev.league.app.template.cache.session.ISessionCache
import com.kmp.dardev.league.app.template.cache.worker.RefreshSessionWorker
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class KoinWorkerFactory :
    WorkerFactory(),
    KoinComponent {
    private val sessionCache: ISessionCache by inject()

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters,
    ): ListenableWorker? =
        when (workerClassName) {
            RefreshSessionWorker::class.java.name -> {
                RefreshSessionWorker(appContext, workerParameters, sessionCache)
            }
            else -> null
        }
}
