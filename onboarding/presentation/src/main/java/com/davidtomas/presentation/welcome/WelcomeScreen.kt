package com.davidtomas.presentation.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.davidtomas.core.R
import com.davidtomas.core_ui.LocalSpacing
import com.davidtomas.presentation.components.ActionButton

@Composable
fun WelcomeScreen(
    onNextButtonClick: () -> Unit,
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(spacing.spaceMedium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.welcome_text),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = { onNextButtonClick() },
            isEnabled = true,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}