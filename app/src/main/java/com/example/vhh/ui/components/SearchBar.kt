package com.example.vhh.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

@Composable
fun SearchBar (
    modifier: Modifier = Modifier,
    loading: Boolean = false,
    hint: String = "Search",
    onSearch: (String) -> Unit = {}
){
    Column {
        val searchQueryState = rememberSaveable { mutableStateOf("")  }
        val keyboardController = LocalSoftwareKeyboardController.current
        val valid = remember(searchQueryState.value) {
            searchQueryState.value.trim().isNotEmpty()
        }
InputField(value = searchQueryState,
    label = "Find Doctors near you",
    enabled = true,
    keyboardActions = KeyboardActions{
        if (!valid) return@KeyboardActions
    onSearch(searchQueryState.value.trim())
    searchQueryState.value = ""
        keyboardController?.hide()
    },
)
}
}

@Composable
fun InputField(
    value: MutableState<String>,
    label: String,
    enabled: Boolean,
    keyboardActions: KeyboardActions
) {


}
