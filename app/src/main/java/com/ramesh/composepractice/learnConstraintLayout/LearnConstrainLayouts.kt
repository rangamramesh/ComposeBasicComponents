package com.ramesh.composepractice.learnConstraintLayout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun LearnConstrainLayouts() {
    ConstraintLayout {
        val (redButton, blueButton, greenButton, blackButton) = createRefs()

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Red),
            modifier = Modifier.constrainAs(redButton) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text(text = "Red", fontSize = 20.sp)
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier.constrainAs(blueButton) {
                top.linkTo(redButton.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text(text = "Blue", fontSize = 20.sp)
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Green),
            modifier = Modifier.constrainAs(greenButton) {
                top.linkTo(blueButton.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text(text = "Green", fontSize = 20.sp)
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Black),
            modifier = Modifier.constrainAs(blackButton) {
                top.linkTo(greenButton.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text(text = "Black", fontSize = 20.sp)
        }
    }
}

@Composable
fun LearnConstrainLayoutsWithChains() {
    ConstraintLayout {
        val (redButton, blueButton, greenButton, blackButton) = createRefs()

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Red),
            modifier = Modifier.constrainAs(redButton) {}) {
            Text(text = "Red", fontSize = 20.sp)
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier.constrainAs(blueButton) {}) {
            Text(text = "Blue", fontSize = 20.sp)
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Green),
            modifier = Modifier.constrainAs(greenButton) { }) {
            Text(text = "Green", fontSize = 20.sp)
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Black),
            modifier = Modifier.constrainAs(blackButton) {}) {
            Text(text = "Black", fontSize = 20.sp)
        }
//Test1
//        createHorizontalChain(redButton, blueButton, greenButton, blackButton)
//Test2
//        createVerticalChain(redButton, blueButton, greenButton, blackButton)
//Test3
//        createVerticalChain(redButton, blueButton)
//        createVerticalChain(greenButton, blackButton)
//        createHorizontalChain(redButton, greenButton)
//        createHorizontalChain(blueButton, blackButton)
    }
}


@Composable
fun LearnConstrainLayoutsWithGuideLine() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (redButton, blueButton, greenButton, blackButton) = createRefs()
        val guideline1 = createGuidelineFromBottom(fraction = 0.05f)
        val guideline2 = createGuidelineFromTop(fraction = 0.05f)
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Red),
            modifier = Modifier.constrainAs(redButton) {
                top.linkTo(guideline2)
            }) {
            Text(text = "Red", fontSize = 20.sp)
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier.constrainAs(blueButton) {
                top.linkTo(guideline2)
            }) {
            Text(text = "Blue", fontSize = 20.sp)
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Green),
            modifier = Modifier.constrainAs(greenButton) {
                bottom.linkTo(guideline1)
            }) {
            Text(text = "Green", fontSize = 20.sp)
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Black),
            modifier = Modifier.constrainAs(blackButton) {
                bottom.linkTo(guideline1)
            }) {
            Text(text = "Black", fontSize = 20.sp)
        }
        createHorizontalChain(redButton, blueButton, chainStyle = ChainStyle.SpreadInside)
        createHorizontalChain(greenButton, blackButton, chainStyle = ChainStyle.SpreadInside)

    }
}


@Preview
@Composable
fun PreviewLearnConstraintLayout() {
    LearnConstrainLayoutsWithGuideLine()
}