package com.example.knownyc.presentation.parks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// TODO: Project 2

@Composable
fun NycParkCard(
    name: String,
//    painter: Painter,
    modifier: Modifier = Modifier,
    onClick: () -> Unit ={}
) {
    val shape = RoundedCornerShape(8.dp)
    val height: Dp = 148.dp
    Card(
        modifier = modifier
            .padding(6.dp)
            .shadow(
                elevation = 6.dp,
                spotColor = MaterialTheme.colorScheme.surfaceTint
            )
            .requiredHeight(height)
            .clickable() {
                onClick()
            }
    ) {
        Box(modifier = modifier
            .fillMaxSize()
        ) {
            Text(
                text = name,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth(0.8f)
            )
        }
    }
}

@Preview
@Composable
fun NycParkCardPreview() {
    NycParkCard(
        name = "The Bronx"
    )
}