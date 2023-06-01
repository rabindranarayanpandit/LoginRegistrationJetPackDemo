package com.example.loginregistrationjetpackdemo.screens.dashboard.state

import com.jodhpurtechies.composelogin.ui.screens.unauthenticated.registration.state.RegistrationUiEvent

sealed class DashboardCommentUIEvent {
    data class postComments(val inputValue: String) : DashboardCommentUIEvent()
    object Post : DashboardCommentUIEvent()
}