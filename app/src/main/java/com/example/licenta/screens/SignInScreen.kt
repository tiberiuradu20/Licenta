package com.example.licenta.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.licenta.ProfileViewModel
import com.example.licenta.R
import com.example.licenta.composables.MyTextFieldEmail
import com.example.licenta.composables.MyTextFieldName
import com.example.licenta.composables.MyTextFieldPassword
import com.example.licenta.composables.NormalTextComponent
import com.example.licenta.composables.alreadyHaveAnAccount
import com.example.licenta.composables.passwordForgotten
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

@Composable
fun SignInScreen(navController: NavController,profileViewModel: ProfileViewModel){
    var email=""
    var parola=""
    var success by remember { mutableStateOf(false)}
    val snackbarHostState = remember { SnackbarHostState() }
    Surface(modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background) {
        Column(modifier= Modifier
            .wrapContentSize()
            .padding(bottom = 300.dp)){
            NormalTextComponent(value = "SIGN IN")
            Column(modifier= Modifier
                .wrapContentSize()
                .padding(top = 6.dp)) {
                email = MyTextFieldEmail("Type your email address",fara=true)
                parola = MyTextFieldPassword(labelText = "Type your password",fara=true)
                Row(modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 20.dp, top = 25.dp)){

                    passwordForgotten(email)

                }
            }
            Button(onClick = {
                userAuthentification(email=email,password=parola,navController,profileViewModel)
            },
                modifier= Modifier
                    .padding(top = 13.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.sign_up_button))) {
                Text(text="Sign In", fontSize = 20.sp,color= Color.White)
            }

        }
    }
}
fun userAuthentification(email: String, password: String,navController: NavController,profileViewModel: ProfileViewModel) {
    var uid = " "
    if (email.isBlank() || password.isBlank()) { return }

    val auth: FirebaseAuth = Firebase.auth
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success
                Log.d("Utilizator Autentificat", "Success")
                 uid = task.result?.user?.uid!!
                if (uid != null) {
                    profileViewModel.userId(uid)
                    profileViewModel.setamDateleUtilizatorului()
                    Log.d("UID","$uid")
                    navController.navigate("Training")
                }
            } else {
                // Sign in failed
                val errorMessage = task.exception?.message ?: "Authentication failed"
                Log.d("Utilizator Autentificat", "Failure: $errorMessage")
            }
        }
}
@Preview(showBackground = true)
@Composable
fun showScreenSignIn(){
    SignInScreen(rememberNavController(), ProfileViewModel())
}