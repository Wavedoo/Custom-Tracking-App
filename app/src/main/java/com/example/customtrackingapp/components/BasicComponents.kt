package com.example.customtrackingapp.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.customtrackingapp.ui.theme.CustomTrackingAppTheme
import java.util.*

@Composable
fun DatePickerWithDate(){
    val context = LocalContext.current
    val cal = Calendar.getInstance()

    val year = remember { mutableStateOf(cal.get(Calendar.YEAR))}
    val month = remember { mutableStateOf(cal.get(Calendar.MONTH))}
    val day = remember { mutableStateOf(cal.get(Calendar.DAY_OF_MONTH))}

    val datePicker = DatePickerDialog(
        context,
        { _: DatePicker, y: Int, m: Int, d: Int ->
            year.value = y
            month.value = m
            day.value = d
        }, year.value, month.value, day.value
    )
    Row(
        //TODO: Align the date with the button
    ){
        Text(text = "Date: ${year.value}-${month.value+1}-${day.value}")
        IconButton(onClick = {datePicker.show()}) {
            Icon(
                Icons.Default.DateRange,
                "hi"
            )
        }
    }
}

//TODO: Add Time Picker component next

@Preview(showBackground = true)
@Composable
private fun Preview(){
    CustomTrackingAppTheme {
        DatePickerWithDate()
    }
}