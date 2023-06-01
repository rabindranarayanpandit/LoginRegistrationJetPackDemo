package com.example.loginregistrationjetpackdemo.screens.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginregistrationjetpackdemo.screens.dashboard.state.DashboardCommentUIEvent
import com.example.loginregistrationjetpackdemo.ui.theme.LoginRegistrationJetPackDemoTheme

@Composable
fun DashboardScreen(dashboardViewModel: DashboardViewModel= viewModel()
) {

    val dashboardCommentState by remember {
        dashboardViewModel.dashBoardCommentState
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        DashboardInput(dashboardState = dashboardCommentState,
            onCommentChange = { inputString ->
                dashboardViewModel.onUiEvent(
                    dashboardCommentUIEvent = DashboardCommentUIEvent.postComments(
                        inputValue = inputString
                    )
                )
            }, onPostComment = {
               dashboardViewModel.onUiEvent(dashboardCommentUIEvent = DashboardCommentUIEvent.Post)
            }
        )
        //TitleText(text = stringResource(id = R.string.dashboard_title_welcome_user))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDashBoardScreen() {
    LoginRegistrationJetPackDemoTheme {
        DashboardScreen()
    }
}
