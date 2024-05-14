package com.example.licenta.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.licenta.R
import com.example.licenta.composables.MyTextFieldEmail
import com.example.licenta.composables.MyTextFieldName
import com.example.licenta.composables.MyTextFieldPassword
import com.example.licenta.composables.NormalTextComponent
import com.example.licenta.composables.alreadyHaveAnAccount
import com.example.licenta.composables.passwordForgotten

@Composable
fun SignInScreen(navController: NavController){
    Surface(modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background) {
        Column(modifier= Modifier
            .wrapContentSize()
            .padding(bottom = 300.dp)){
            NormalTextComponent(value = "SIGN IN")
            Column(modifier= Modifier
                .wrapContentSize()
                .padding(top = 6.dp)) {
                MyTextFieldEmail("Type your email address",fara=true)
                MyTextFieldPassword(labelText = "Type your password",fara=true)
                Row(modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 20.dp, top = 25.dp)){

                        passwordForgotten()

                }
            }
            Button(onClick = {
                  navController.navigate("Training")
                  //  navController.popBackStack()
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
@Preview(showBackground = true)
@Composable
fun showScreenSignIn(){
    SignInScreen(rememberNavController())
}
