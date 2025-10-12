package com.kmp.dardev.league.app.template.cache.session

interface ISessionCache {
    fun saveSession(session: Session)

    fun getActiveSession(): Session?

    fun clearSession()

    fun saveOnboarding(hasSeenOnboarding: Boolean)

    fun getOnboarding(): Boolean
}
