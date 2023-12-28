package com.davidtomas.presentation.nutrient_goal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.davidtomas.core.R
import com.davidtomas.core.util.UiEvent
import com.davidtomas.core_ui.LocalSpacing
import com.davidtomas.presentation.components.ActionButton
import com.davidtomas.presentation.components.UnitTextField

@Composable
fun NutrientGoalScreen(
    scaffoldState: ScaffoldState,
    onNextButtonClick: () -> Unit,
    viewModel: NutrientGoalViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Success -> onNextButtonClick()
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                }

                else -> Unit
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.what_are_your_nutrient_goals),
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                UnitTextField(
                    value = viewModel.state.carbsRatio,
                    onValueChange = { viewModel.onEvent(NutrientGoalEvent.OnCarbRatioEnter(it)) },
                    unit = stringResource(id = R.string.percent_carbs)
                )
            }
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                UnitTextField(
                    value = viewModel.state.carbsRatio,
                    onValueChange = { viewModel.onEvent(NutrientGoalEvent.OnProteinRatioEnter(it)) },
                    unit = stringResource(id = R.string.percent_proteins)
                )
            }
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                UnitTextField(
                    value = viewModel.state.carbsRatio,
                    onValueChange = { viewModel.onEvent(NutrientGoalEvent.OnFatRatioEnter(it)) },
                    unit = stringResource(id = R.string.percent_fats)
                )
            }
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = { viewModel.onEvent(NutrientGoalEvent.OnNextClick) },
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}