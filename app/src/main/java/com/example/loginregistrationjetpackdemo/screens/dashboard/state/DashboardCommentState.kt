package com.example.loginregistrationjetpackdemo.screens.dashboard.state

import com.example.loginregistrationjetpackdemo.common.state.ErrorState

data class DashboardCommentState (
    val commentState:String = "",
    val isPostedCommentSuccessful: Boolean = false,
    val errorState:DashboardErrorState = DashboardErrorState()
)

data class DashboardErrorState(
    val commentErrorState: ErrorState = ErrorState()
)