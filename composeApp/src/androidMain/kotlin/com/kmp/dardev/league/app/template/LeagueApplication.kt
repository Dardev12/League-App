package com.kmp.dardev.league.app.template

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager
import com.kmp.dardev.league.app.template.di.KoinWorkerFactory
import com.kmp.dardev.league.app.template.di.androidModule
import com.kmp.dardev.league.app.template.di.appModule
import com.kmp.dardev.league.app.template.di.platformModule
import io.nodle.sdk.android.Nodle
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LeagueApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Nodle.init(this)
        startKoin {
            androidContext(this@LeagueApplication)
            androidLogger()
            modules(appModule() + platformModule() + androidModule)
        }
        // Places.initializeWithNewPlacesApiEnabled(this, "")

        WorkManager.initialize(
            this,
            Configuration
                .Builder()
                .setWorkerFactory(KoinWorkerFactory())
                .build(),
        )
    }
}
