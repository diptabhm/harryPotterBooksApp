package com.example.wellnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wellnessapp.ui.theme.WellnessAppTheme
import model.Books
import model.data

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WellnessAppTheme {
                // A surface container using the 'background' color from the theme
                list()
            }
        }
    }
}

@Composable
fun list()
{
    Scaffold(modifier = Modifier.fillMaxWidth(),topBar = {
        Topbar()
    }
    ) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background))
        {
            items(Books)
            {
                WellnessCard(data = it)
            }
        }
    }
}

@Composable
fun WellnessCard(data: data)
{
    Spacer(modifier = Modifier.height(15.dp))
    Card(modifier = Modifier
        .fillMaxWidth()
        .clip(MaterialTheme.shapes.large)
        .height(250.dp)
        .padding(10.dp)
        .background(color = MaterialTheme.colors.background),
        elevation = 4.dp
    )
    {
        Column(modifier = Modifier.background(color = MaterialTheme.colors.surface))
        {
            Text(text = stringResource(id = data.bookNo),
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.h1)
            Spacer(modifier = Modifier.height(2.dp))
            Row(Modifier.padding(start = 16.dp, bottom = 16.dp))
            {
                Image(
                    painter = painterResource(
                        id = data.image
                    ),
                    contentDescription = null
                )
                Column() {
                    Text(
                        text = stringResource(id = data.bookName),
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                            .weight(1f), style = MaterialTheme.typography.body1
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
                }
            }
    }
}

@Composable
fun Topbar()
{
    Box(modifier = Modifier
        .fillMaxWidth()
        .size(60.dp)
        .background(MaterialTheme.colors.secondary),
        contentAlignment = Alignment.Center)
    {
        Text(text = stringResource(id = R.string.app_name), style = MaterialTheme.typography.h5)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    WellnessAppTheme {
    }
}