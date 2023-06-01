package com.example.loginregistrationjetpackdemo.screens.dashboard.state

import com.example.loginregistrationjetpackdemo.R
import com.example.loginregistrationjetpackdemo.common.state.ErrorState

val commentEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.dashboard_comment_empty_error
)