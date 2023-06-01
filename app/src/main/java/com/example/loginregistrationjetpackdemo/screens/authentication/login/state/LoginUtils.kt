package com.example.loginregistrationjetpackdemo.screens.authentication.login.state

import com.example.loginregistrationjetpackdemo.R
import com.example.loginregistrationjetpackdemo.common.state.ErrorState


val emailOrMobileEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_email_mobile
)

val passwordEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_password
)