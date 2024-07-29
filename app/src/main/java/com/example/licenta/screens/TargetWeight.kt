package com.example.licenta.screens


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.licenta.ProfileViewModel
import com.example.licenta.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun targetWeight(navController: NavController, scrollState: ScrollState, profileViewModel: ProfileViewModel) {

    var targetWeig by remember { mutableStateOf(profileViewModel.targetWeight.value ?: "") }
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Scaffold() {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        focusManager.clearFocus()
                        keyboardController?.hide()
                    })
                },
            color = MaterialTheme.colorScheme.background,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp, top = 33.dp)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { navController.popBackStack() }
                            .align(Alignment.CenterVertically)
                    )

                    Text(
                        text = "Greutate Tinta",
                        color = colorResource(id = R.color.training_titile),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentSize(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))

                Divider(
                    color = Color.Red,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .size(15.dp),
                    thickness = 0.1.dp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(180.dp))
                    Text(
                        text = "Greutatea Tinta",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 25.sp
                        ),
                        modifier = Modifier.padding(end = 16.dp, start = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(90.dp))
                    OutlinedTextField(
                        value =targetWeig,
                        onValueChange = { targetWeig = it },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .focusRequester(focusRequester)
                            .onFocusChanged { focusState ->
                                if (!focusState.isFocused) {
                                    keyboardController?.hide()
                                }
                            },
                        keyboardOptions = KeyboardOptions.Default.copy(autoCorrect = true),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                focusManager.clearFocus()
                                keyboardController?.hide()
                            }
                        )
                    )
                    Spacer(modifier = Modifier.height(90.dp))
                    Button(
                        onClick = {
                            modificaGreutateaTinta(profileViewModel,targetWeig)
                        },
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(22.dp))
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Text(text = "EDITATI", color = Color.White)
                    }
                }
            }
        }
    }
}
fun modificaGreutateaTinta(profileViewModel: ProfileViewModel, greutate: String) {
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val uid = profileViewModel.uid.value
    if (uid != null) {
        val userRef: DatabaseReference = database.getReference("users/$uid/informatii/Greutate_Tinta")
        userRef.setValue(greutate).addOnSuccessListener {
            Log.d("modificaNume", "Numele a fost modificat cu succes în baza de date")
        }.addOnFailureListener { exception ->
            Log.e("modificaNume", "Eroare la modificarea numelui: ${exception.message}")
        }
    } else {
        Log.e("modificaNume", "UID este null")
    }
    profileViewModel.updateTargetWeight(greutate)
}
@Preview(showBackground = true)
@Composable
fun targetWeightPreview() {
    targetWeight(navController = rememberNavController(), scrollState = rememberScrollState(), viewModel())
}