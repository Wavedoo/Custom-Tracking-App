package com.example.customtrackingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customtrackingapp.components.DatePickerWithDate
import com.example.customtrackingapp.ui.theme.CustomTrackingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomTrackingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    TestScreen()
                }

            }
        }
    }
}

@Composable
fun TestScreen(){
    DatePickerWithDate()
}
@Composable
fun MainScreen(){
    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.title),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(R.string.track_button_text))
        }
    }
}
@Composable
fun BowelMovementInput(){

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CustomTrackingAppTheme {
        Text("hi")
    }
}