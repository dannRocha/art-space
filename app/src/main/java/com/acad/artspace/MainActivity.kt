package com.acad.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acad.artspace.ui.theme.ArtSpaceTheme
import kotlin.math.abs

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace() {
    val arts = listOf(
        Art(image = R.drawable.dog_caramelo, title = "Dog", artist = "Unknow"),
        Art(image = R.drawable.black_cat, title = "Cat", artist = "Unknow"),
        Art(image = R.drawable.owl, title = "Owl", artist = "Unknow")
    )

    var currentArt by remember { mutableStateOf(0) }

    val art = arts[currentArt]

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(
                modifier = Modifier

                    .border(2.dp, Color.DarkGray)
            ) {
                Image(painter = painterResource(art.image),
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(12.dp))
        Row(
            modifier = Modifier
                .padding(bottom = 16.dp, top = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .shadow(elevation = 3.dp, shape = RectangleShape, true)
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = art.title,
                    fontSize = 24.sp
                )
                Text(
                    text = art.artist,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    currentArt--
                    if(currentArt < 0)
                        currentArt = arts.size - 1
                },
            ) {
                Text(
                    text = stringResource(R.string.previous),
                    textAlign =TextAlign.Center,
                    modifier = Modifier.width(100.dp)
                )
            }

            Button(
                onClick = {
                    currentArt = abs(++currentArt % arts.size)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
            ) {

                Text(
                    text = stringResource(R.string.next),
                    textAlign =TextAlign.Center,
                    modifier = Modifier.width(100.dp)
                )
            }
        }
    }
}

data class Art (val image: Int, val title: String, val artist: String)

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme{
        ArtSpace()
    }
}
