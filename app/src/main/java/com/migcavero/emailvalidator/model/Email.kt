package com.migcavero.emailvalidator.model

data class Email(val status: Int, val email: String, val domain: String, val mx: Boolean, val disposable: Boolean, val alias: Boolean)