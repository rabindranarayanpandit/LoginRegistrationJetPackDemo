package com.example.loginregistrationjetpackdemo.screens.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.loginregistrationjetpackdemo.R
import com.example.loginregistrationjetpackdemo.common.customcomposableview.NormalButton
import com.example.loginregistrationjetpackdemo.common.customcomposableview.PostCommentField
import com.example.loginregistrationjetpackdemo.screens.dashboard.state.DashboardCommentState
import com.example.loginregistrationjetpackdemo.ui.theme.AppTheme

@Composable
fun DashboardInput(
    dashboardState:DashboardCommentState,
    onCommentChange:(String) -> Unit,
    onPostComment: () -> Unit
){
    Column(modifier = Modifier.fillMaxWidth())
    {
        PostCommentField(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 250.dp)
                .padding(16.dp),
            value = dashboardState.commentState,
            onValueChange = onCommentChange,
            label = stringResource(id = R.string.dashboard_comment),
            isError = dashboardState.errorState.commentErrorState.hasError,
            errorText = stringResource(id = dashboardState.errorState.commentErrorState.errorMessageStringResource))
    }

    NormalButton(
        modifier = Modifier.padding(top = AppTheme.dimens.paddingExtraLarge),
        text = stringResource(id = R.string.dashboard_post_button_text),
        onClick = onPostComment
    )
}