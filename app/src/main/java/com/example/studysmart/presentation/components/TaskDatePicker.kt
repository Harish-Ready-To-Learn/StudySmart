package com.example.studysmart.presentation.components

import android.annotation.SuppressLint
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import java.time.LocalDate

@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDatePicker(
    state: DatePickerState,
    isOpen: Boolean,
    confirmButtonText: String = "OK",
    dismissButtonText: String = "Cancel",
    onDismissRequest: () -> Unit,
    onConfirmClick: () -> Unit,
) {
    if (isOpen) {
        DatePickerDialog(
            onDismissRequest = { onDismissRequest() },
            confirmButton = {
                TextButton(onClick = { onConfirmClick() }) {
                    Text(text = confirmButtonText)
                } },
            dismissButton = {
                TextButton(onClick = { onDismissRequest() }) {
                    Text(text = dismissButtonText)
                }
            },
            content = {
                DatePicker(
                    state = state,
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDatePicker(){
//   TaskDatePicker()
}