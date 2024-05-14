package com.example.licenta.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
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

@Composable
fun SignUpScreen(navController: NavController){
    Surface(modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background) {
        Column(modifier= Modifier
            .fillMaxSize()//30
            .padding(top = 30.dp)){

            NormalTextComponent(value = "SIGN UP")
            Column(modifier= Modifier
                .fillMaxWidth().wrapContentHeight()
                .padding(top=6.dp)) {

                MyTextFieldName("Enter your Name")
                MyTextFieldEmail("Type your email address")
                MyTextFieldPassword(labelText = "Type your password")
                MyTextFieldPassword(labelText = "Retype your password")
            }
            Row(modifier = Modifier

                .wrapContentSize()//start=20.dp
                .padding(start = 10.dp, top = 14.dp),
                horizontalArrangement = Arrangement.Start) {
                alreadyHaveAnAccount(navController=navController)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(modifier= Modifier
                .fillMaxWidth()
                .wrapContentHeight(),onClick = {
                navController.navigate("SignInScreen")

            },
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.sign_up_button))) {
                Text(text="Sign Up", fontSize = 17.sp,color= Color.White)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun showScreen(){
    SignUpScreen(rememberNavController())
}