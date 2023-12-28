package com.davidtomas.presentation.height

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidtomas.core.domain.preferences.Preferences
import com.davidtomas.core.domain.use_case.FilterOutDigitsUseCase
import com.davidtomas.core.util.UiEvent
import com.davidtomas.core.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeightViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigitsUseCase: FilterOutDigitsUseCase
) : ViewModel() {

    var selectedHeight by mutableStateOf("150")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onHeightChanged(height: String) {
        if (height.length <= 3) {
            selectedHeight = filterOutDigitsUseCase(height)
        }
    }

    fun onNextClick() {
        viewModelScope.launch {
            val heightNumber = selectedHeight.toIntOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UiEvent.ShowSnackBar(
                        UiText.StringResource(com.davidtomas.core.R.string.error_height_cant_be_empty)
                    )
                )
                return@launch
            }
            preferences.saveHeight(heightNumber)
            _uiEvent.send(UiEvent.Success)
        }
    }
}