package com.example.customtrackingapp.components

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Paint.Align
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.customtrackingapp.ui.theme.CustomTrackingAppTheme
import java.util.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun DatePickerWithDate(
    name: String = "Date"
){
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
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "${name}: ${year.value}-${month.value+1}-${day.value}")
        IconButton(onClick = {datePicker.show()}) {
            Icon(
                Icons.Default.DateRange,
                "hi"
            )
        }
    }
}

//TODO: Fix time to display in h:mm 12-hour format
//TODO: Maybe get spinner time input instead of clock input
@Composable
fun TimePickerWithTime(
    name: String = "Time"
){
    val context = LocalContext.current
    val cal = Calendar.getInstance()

    val hour = remember { mutableStateOf(cal.get(Calendar.HOUR_OF_DAY))}
    val minute = remember { mutableStateOf(cal.get(Calendar.MINUTE))}

    val timePicker = TimePickerDialog(
        context,
        { _: TimePicker, h: Int, m: Int ->
            hour.value = h
            minute.value = m
        }, hour.value, minute.value, false
    )
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "${name}: ${hour.value}:${minute.value+1}")
        IconButton(onClick = {timePicker.show()}) {
            Icon(
                //TODO: Get better icon
                Icons.Default.List,
                "hi"
            )
        }
    }
}

@Composable
fun LocationTextEntry(){
    var location by remember { mutableStateOf("")}
    Row(verticalAlignment = Alignment.CenterVertically){
        Text(text = "Location:")
        TextField(value = location, onValueChange = {location = it})
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    CustomTrackingAppTheme {
        LocationTextEntry()
    }
}