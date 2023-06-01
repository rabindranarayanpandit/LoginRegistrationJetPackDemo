package com.example.loginregistrationjetpackdemo.screens.dashboard

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.loginregistrationjetpackdemo.common.state.ErrorState
import com.example.loginregistrationjetpackdemo.screens.dashboard.state.DashboardCommentState
import com.example.loginregistrationjetpackdemo.screens.dashboard.state.DashboardCommentUIEvent
import com.example.loginregistrationjetpackdemo.screens.dashboard.state.DashboardErrorState
import com.example.loginregistrationjetpackdemo.screens.dashboard.state.commentEmptyErrorState

class DashboardViewModel : ViewModel() {
    var dashBoardCommentState = mutableStateOf(DashboardCommentState())
    private set

    fun onUiEvent(dashboardCommentUIEvent: DashboardCommentUIEvent){

        when(dashboardCommentUIEvent) {
            is DashboardCommentUIEvent.postComments -> {
                dashBoardCommentState.value = dashBoardCommentState.value.copy(
                    commentState = dashboardCommentUIEvent.inputValue,
                    errorState = dashBoardCommentState.value.errorState.copy(
                        commentErrorState =
                        if (dashboardCommentUIEvent.inputValue.trim().isEmpty()){
                            commentEmptyErrorState
                        }else {
                            // Valid state
                            ErrorState()
                        }
                    )
                )
            }
            is DashboardCommentUIEvent.Post -> {
                val inputsValidated = validateInputs()
                if (inputsValidated) {
                    // TODO Trigger registration in authentication flow
                    dashBoardCommentState.value =
                        dashBoardCommentState.value.copy(isPostedCommentSuccessful = true)
                }
            }
        }
    }

    private fun validateInputs(): Boolean {
        val comment = dashBoardCommentState.value.commentState.trim()
        return when {
            //Mobile Number Empty
            comment.isEmpty() -> {
                dashBoardCommentState.value = dashBoardCommentState.value.copy(
                    errorState = DashboardErrorState(
                        commentErrorState = commentEmptyErrorState
                    )
                )
                false
            } // No errors
            else -> {
                // Set default error state
                dashBoardCommentState.value =
                    dashBoardCommentState.value.copy(errorState = DashboardErrorState())
                true
            }
        }
    }
}

