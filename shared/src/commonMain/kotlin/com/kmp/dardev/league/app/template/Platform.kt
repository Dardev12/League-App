package com.kmp.dardev.league.app.template

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform