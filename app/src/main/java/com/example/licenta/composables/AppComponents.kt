package com.example.licenta.composables


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentColor
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.SnackbarHostState

import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCut
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PanoramaFishEye
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.licenta.R
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.round

@Composable
fun NormalTextComponent(value:String,modifier: Modifier= Modifier){
    Text(text=value,
        color= colorResource(id = R.color.sign_up),
        modifier= Modifier
            .fillMaxWidth()
            .heightIn(80.dp)
            .padding(bottom = 1.dp),//20
        style= TextStyle(
            fontSize = 20.sp,///25
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal/*se poate seta si shadow*/
        ),
        textAlign= TextAlign.Center
    )

}
@Composable
fun MyTextFieldName(labelText:String,modifier: Modifier=Modifier,fara:Boolean=false){
    val localFocusManager= LocalFocusManager.current
    var textState by remember{
        mutableStateOf<String>("")
    }
    val isValid = textState.length > 3

    OutlinedTextField(
        value = textState,
        onValueChange = { textState = it },
        label = { Text(text=labelText) }, // Label displayed above the text field
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .wrapContentHeight()
            .fillMaxWidth(),
        textStyle = TextStyle(fontSize = 14.sp),
        isError = !isValid, // Show error indicator when input is not valid
        singleLine = true, // Single-line input
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue, // Border color when the field is focused
            unfocusedBorderColor = Color.Gray, // Border color when the field is not focused
            errorBorderColor = Color.Red // Border color when the input is not valid
        ),
        shape = RoundedCornerShape(11.dp),
        keyboardOptions = KeyboardOptions.Default,
        leadingIcon = {
            Icon( imageVector = Icons.Filled.Person,
                contentDescription = null,
                modifier=Modifier.padding(end=5.dp)

            )
        }
    )
    if(!fara) {
        if (!isValid) {
            Text(
                text = "Name must be at least 4 characters",
                color = Color.Red,
               fontSize=14.sp,
                modifier = Modifier.padding(start = 20.dp, top = 20.dp)
            )
        }
    }
}
@Composable
fun MyTextFieldEmail(labelText: String, modifier: Modifier = Modifier,fara:Boolean=false):String {
    val textState = remember { mutableStateOf("") }

    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    val isValid = textState.value.matches(emailPattern.toRegex())///validare email

    OutlinedTextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        label = { Text(labelText) },
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .wrapContentHeight()
            .fillMaxWidth(), // Adjust height if necessary
        isError = !isValid,
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Gray,
            errorBorderColor = Color.Red
        ),
        shape = RoundedCornerShape(8.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Email",
                modifier = Modifier.padding(end = 5.dp)
            )
        }
    )
  if(fara!=true) {
      if (!isValid) {
          Text(
              text = "Enter a valid email address",
              color = Color.Red,
              fontSize=14.sp,
              modifier = Modifier.padding(start = 20.dp, top = 20.dp)
          )
      }
  }
    return textState.value
}
@Composable
fun MyTextFieldPassword(labelText: String, modifier: Modifier = Modifier,fara:Boolean=false):String {
    val password = remember { mutableStateOf("") }

    val passwordVisible = remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password.value,
        onValueChange = { password.value = it },
        label = {Text(labelText)},
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .wrapContentHeight()
            .fillMaxWidth(), // Adjust height to your preference
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Gray,
            errorBorderColor = Color.Red
        ),
        isError = password.value.length < 6,
        shape = RoundedCornerShape(8.dp),
        leadingIcon={Icon(Icons.Filled.Lock,contentDescription = null) },
        trailingIcon={
         val iconImage=if(passwordVisible.value){
             Icons.Filled.Visibility
         } else{
             Icons.Filled.VisibilityOff
         }

        IconButton(onClick = { passwordVisible.value=!passwordVisible.value }) {
             if(!passwordVisible.value)
                Icon(iconImage,contentDescription = null)
            else
                Icon(iconImage,contentDescription = null)
        }
    },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None
        else PasswordVisualTransformation()
    )
    if(!fara) {
        if (password.value.length < 6) {
            Text(
                text = "Password must be at least 6 characters",
                color = Color.Red,
                fontSize=14.sp,
                modifier = Modifier.padding(start = 20.dp, top = 20.dp)
            )
        }
    }
    return password.value
}
@Composable
fun alreadyHaveAnAccount(modifier: Modifier = Modifier,navController: NavController) {
    var text by remember {
        mutableStateOf("Neatins")
    }

    val annotatedText = buildAnnotatedString {//16sp
        withStyle(style = SpanStyle(fontSize = 16.sp, color = Color.Black)) {
            append("Have you already got an account?  ")
        }

        // Attach a string annotation for the clickable part of the text
        pushStringAnnotation(tag = "URL", annotation = "signin")
        withStyle(style = SpanStyle(fontSize = 16.sp,fontWeight = FontWeight.SemiBold)) {
            append("Sign in")
        }

    }

    ClickableText(
        text = annotatedText,
        modifier=Modifier.fillMaxWidth(),
        onClick = { offset ->
            // We check if there is an annotation attached to the text at the clicked position
            annotatedText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    // If yes, we log the value of the annotation which in this case is a URL
                  navController.navigate("SignInScreen")

                }
        },
       // style = TextStyle(color = LocalContentColor.current, fontSize = 18.sp) // Apply overall text styling here
    )
}
@Composable
fun passwordForgotten(email:String){
    val initialString="Have you forgotten your password? "
    val finalString="Click Here"

    val annotatedString= buildAnnotatedString {
       withStyle(style= SpanStyle(fontSize = 14.sp)){
           append(initialString)
       }
        pushStringAnnotation(tag="URL", annotation = "Click Here")
      withStyle(style=SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold)){
          append(finalString)
      }
    }
    ClickableText(text = annotatedString, onClick ={offset->
        annotatedString.getStringAnnotations(offset,offset).firstOrNull()!!.let{

            Log.d("password","Stay calm and try to remember the password")
            resetPassword(email)
        }

    } )
}
fun resetPassword(email: String) {
    if (email.isBlank()) {return}

    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    auth.sendPasswordResetEmail(email)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Email de resetare a parolei trimis cu succes
                Log.d("Resetare Parolă", "Email de resetare a parolei trimis cu succes catre $email")

            } else {
                // Trimiterea emailului de resetare a parolei a eșuat
                val errorMessage = task.exception?.message ?: "Failed to send reset email"

                Log.d("Resetare Parolă", "Eroare: $errorMessage")
            }
        }
}
@Composable
fun calendarComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SUN",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(100.dp)
                .padding(top = 16.dp)
                .background(Color.LightGray, CircleShape)
        ) {
            Text(
                text = "30",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

