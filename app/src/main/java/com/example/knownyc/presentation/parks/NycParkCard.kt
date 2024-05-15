package com.example.knownyc.presentation.parks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.knownyc.R

// TODO: Project 2

@Composable
fun NycParkCard(
    name: String,
    location: String,
    parksLogo: Painter,
    isWaterfront: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit ={}
) {
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
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color(220, 231, 200))
                .padding(10.dp)
        ) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .border(width = 2.dp, color = Color(76, 102, 43))
            ) {
                val waterfrontLogo = if (isWaterfront) {
                    R.drawable.waves_24px
                } else {
                    null
                }
                if (waterfrontLogo != null) {
                    Image(
                        painter = painterResource(id = waterfrontLogo),
                        contentDescription = "Waterfront",
                        modifier
                            .align(Alignment.TopEnd)
                            .padding(10.dp),
                        colorFilter = ColorFilter.tint(Color(76, 102, 143))
                    )
                }
                Row(
                    modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                ){
                    Image(
                        painter = parksLogo,
                        contentDescription = "NYC Parks Logo",
                        modifier
                            .fillMaxWidth(0.3f)
                    )
                    Column(
                        modifier
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(
                            text = truncateString(name, 23),
                            textAlign = TextAlign.Left,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = modifier
                                .fillMaxWidth()
                        )
                        Text(
                            text = truncateString(location, 28),
                            textAlign = TextAlign.Left,
                            fontSize = 16.sp,
                            modifier = modifier
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

private fun truncateString(input: String, maxLength: Int): String {
    return if (input.length > maxLength) {
        input.substring(0, maxLength) + " ..."
    } else {
        input
    }
}

@Preview
@Composable
fun NycParkCardPreview() {
    NycParkCard(
        name = "The Bronxasdfasdfasdfasdfasdfasdfasdf",
        location = "Testing an Address, TESTINGINGINGN",
        parksLogo = painterResource(id = R.drawable.nyc_parks_logo),
        isWaterfront = false,
    )
}