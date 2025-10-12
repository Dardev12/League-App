package com.kmp.dardev.league.app.template.cache.session

import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class SessionCache(
    private val sharedPreferences: SharedPreferences,
) : ISessionCache {
    private val moshi =
        Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    private val adapter = moshi.adapter(Session::class.java)

    override fun saveSession(session: Session) {
        sharedPreferences
            .edit()
            .putString("session", adapter.toJson(session))
            .apply()
    }

    override fun getActiveSession(): Session? {
        val json = sharedPreferences.getString("session", null) ?: return null
        return adapter.fromJson(json)
    }

    override fun clearSession() {
        sharedPreferences.edit().remove("session").apply()
    }

    override fun saveOnboarding(hasSeenOnboarding: Boolean) {
        sharedPreferences
            .edit()
            .putBoolean("onboarding", hasSeenOnboarding)
            .apply()
    }

    override fun getOnboarding(): Boolean = sharedPreferences.getBoolean("onboarding", false)
}
