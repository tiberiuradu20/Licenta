package com.example.licenta.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.licenta.R
import com.example.licenta.dateDeTest.Antrenament

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun progressScreen(navController: NavController, scrollState: ScrollState) {
    Scaffold(
        bottomBar = { BottomMenu.BottomNavigationBar(navController = navController) }
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier

                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_progress),
                        contentDescription = "Icon Left",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )

                    Text(
                        text = "PROGRESS",
                        color = colorResource(id = R.color.training_titile),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                            fontStyle = FontStyle.Normal
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentSize(Alignment.Center)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_progress),
                        contentDescription = "Icon Right",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Divider(
                    color = Color.Red,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(horizontal = 3.dp),
                    thickness = 0.3.dp // Adjust padding to ensure the line starts and ends with the icons
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 30.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp, start = 12.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Box(
                            modifier = Modifier
                                .size(width = 150.dp, height = 140.dp)
                                .background(Color.LightGray),
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 9.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Duration(min)",
                                    style = TextStyle(
                                        fontSize = 15.sp
                                    )
                                )
                                Text(
                                    text = "0",
                                    style = TextStyle(
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "in total",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "This Week",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    ),
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                                Divider(
                                    color = Color.Red,
                                    modifier = Modifier
                                        .wrapContentSize()
                                        .height(2.dp)
                                        .width(8.dp),
                                    thickness = 0.3.dp // Adjust padding to ensure the line starts and ends with the icons
                                )

                            }
                        }
                        Box(
                            modifier = Modifier
                                .size(width = 150.dp, height = 140.dp)
                                .background(Color.LightGray),
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 9.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Weight (kg)",
                                    style = TextStyle(
                                        fontSize = 15.sp
                                    )
                                )
                                Text(
                                    text = "75.0",
                                    style = TextStyle(
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "Today",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    ),
                                    modifier = Modifier.padding(bottom = 20.dp)
                                )

                                Divider(
                                    color = Color.Red,
                                    modifier = Modifier
                                        .wrapContentSize()
                                        .height(0.8.dp)
                                        .width(129.dp),
                                    thickness = 0.1.dp // Adjust padding to ensure the line starts and ends with the icons
                                )
                                Text(
                                    text = "Last 30 days",
                                    modifier = Modifier.padding(
                                        top = 5.dp,
                                        bottom = 5.dp
                                    ),
                                    style= TextStyle(fontSize=12.sp,
                                        fontWeight = FontWeight.Normal)

                                )
                                Divider(
                                    color = Color.Red,
                                    modifier = Modifier
                                        .wrapContentSize()
                                        .height(2.dp)
                                        .width(8.dp),
                                    thickness = 0.3.dp // Adjust padding to ensure the line starts and ends with the icons
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 70.dp, start = 12.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Box(
                            modifier = Modifier
                                .size(width = 150.dp, height = 200.dp)
                                .background(Color.LightGray),
                        ) {
                            Column(
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(top = 9.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(),
                                    horizontalArrangement = Arrangement.SpaceAround
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.steps),
                                        contentDescription = null,
                                        modifier = Modifier.padding(bottom = 12.dp).size(width=18.dp,height=27.dp)
                                    )

                                    Text(
                                        text = "Step Tracker",
                                        style = TextStyle(
                                            fontSize = 15.sp
                                        ),
                                        modifier=Modifier.padding(top=5.dp)
                                    )

                                    Image(
                                        painter = painterResource(id = R.drawable.steps),
                                        contentDescription = null,
                                        modifier = Modifier.padding(bottom = 12.dp).size(width=18.dp,height=27.dp)
                                    )
                                }

                                Image(
                                    painter = painterResource(id = R.drawable.mantrack),
                                    contentDescription = null,
                                    modifier = Modifier.wrapContentSize().size(width=60.dp,height=70.dp).padding(top=0.dp)
                                )
                                Text(
                                    text = "0",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    ),
                                    modifier=Modifier.padding(top=5.dp)
                                )
                                Text(
                                    text = "/8000",
                                    style = TextStyle(
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                )

                            }
                        }
                        Box(
                            modifier = Modifier
                                .background(Color.LightGray)
                                .size(width=150.dp,height=200.dp),
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 9.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(),
                                    horizontalArrangement = Arrangement.SpaceAround
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.water),
                                        contentDescription = null,
                                        modifier = Modifier.padding(bottom = 12.dp).size(width=18.dp,height=27.dp)
                                    )

                                    Text(
                                        text = "Water Tracker",
                                        style = TextStyle(
                                            fontSize = 15.sp
                                        ),
                                        modifier=Modifier.padding(top=5.dp)
                                    )

                                    Image(
                                        painter = painterResource(id = R.drawable.water),
                                        contentDescription = null,
                                        modifier = Modifier.padding(bottom = 12.dp).size(width=18.dp,height=27.dp)
                                    )
                                }

                                Image(
                                    painter = painterResource(id = R.drawable.water),
                                    contentDescription = null,
                                    modifier = Modifier.wrapContentSize().size(width=60.dp,height=70.dp).padding(top=0.dp)
                                )
                                Text(
                                    text = "0",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    ),
                                    modifier=Modifier.padding(top=5.dp)
                                )
                                Text(
                                    text = "/8 cups",
                                    style = TextStyle(
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                )


                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun previewScreen(){
    progressScreen(navController = rememberNavController(), scrollState = rememberScrollState() )
}