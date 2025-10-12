package com.kmp.dardev.league.app.template.domain.model

data class SignInData(
    val email: String,
    val password: String
)


// Add isPrivate value
data class SignUpData(
    val email: String,
    val password: String,
    val repeatPassword: String
)