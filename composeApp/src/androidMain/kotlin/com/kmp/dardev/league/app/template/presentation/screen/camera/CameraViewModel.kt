package com.kmp.dardev.league.app.template.presentation.screen.camera

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmp.dardev.league.app.template.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CameraViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _descriptionData: MutableStateFlow<String?> = MutableStateFlow(null)
    val descriptionData: StateFlow<String?> = _descriptionData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val description = savedStateHandle.get<String>(Constants.DESCRIPTION_POST_ARGUMENT_KEY)
            _descriptionData.value = description
        }
    }
}
