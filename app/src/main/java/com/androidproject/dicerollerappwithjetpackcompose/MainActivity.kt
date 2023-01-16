package com.androidproject.dicerollerappwithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidproject.dicerollerappwithjetpackcompose.ui.theme.DiceRollerAppWithJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerAppWithJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DiceRollerAppWithImageAndButton(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(align = Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun DiceRollerAppWithImageAndButton(
    modifier: Modifier,
) {
    var result by remember {
        mutableStateOf(1)
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        val image = when (result) {
            1 -> painterResource(id = R.drawable.dice_1)
            2 -> painterResource(id = R.drawable.dice_2)
            3 -> painterResource(id = R.drawable.dice_3)
            4 -> painterResource(id = R.drawable.dice_4)
            5 -> painterResource(id = R.drawable.dice_5)
            else -> painterResource(id = R.drawable.dice_6)
        }
        Image(painter = image, contentDescription = "Number 1")
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(text = "Click Here")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    DiceRollerAppWithJetpackComposeTheme {
        DiceRollerAppWithImageAndButton(
            Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center),
        )
    }
}