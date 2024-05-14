package com.example.licenta.responsive

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(

val spacerAboveFitness:Dp=0.dp,
val spacerBelowFitness:Dp=0.dp,
val image1Height:Dp = 0.dp,
val spacerAboveMBody:Dp=0.dp,
val spacerBelowMBody:Dp=0.dp,
val textSpace:Dp = 0.dp,
val spacerAboveButton:Dp = 0.dp
////////////////////////////SIGN UP/////////////////////////////////


)
val CompactSmallDimens=Dimens(

    spacerAboveFitness=1.dp,
    spacerBelowFitness=1.dp,
    image1Height = 200.dp,
    spacerAboveMBody=4.dp,
    spacerBelowMBody=4.dp,
    textSpace = 3.dp,
    spacerAboveButton=4.dp
    ////////////////////////////SIGN UP/////////////////////////////////

)
val CompactMediumDimens=Dimens(
    spacerAboveFitness=18.dp,
    spacerBelowFitness=15.dp,
    image1Height = 370.dp,
    spacerAboveMBody=60.dp,
    spacerBelowMBody=15.dp,
    textSpace = 10.dp,//
    spacerAboveButton=20.dp
////////////////////////////SIGN UP/////////////////////////////////




)
val CompactDimens=Dimens(

    spacerAboveFitness=1.dp,
    spacerBelowFitness=1.dp,
    image1Height = 200.dp,
    spacerAboveMBody=4.dp,
    spacerBelowMBody=4.dp,
    textSpace = 3.dp,
    spacerAboveButton=200.dp
)
/////////////////////
val MediumDimens=Dimens(
/*    spacerAboveFitness=5.dp,
    spacerBelowFitness=20.dp,
    image1Height = 200.dp,
    spacerAboveMBody=15.dp,
    spacerBelowMBody=12.dp,
    textSpace = 8.dp,
    spacerAboveButton=30.dp*/

)
val ExpandedDimens=Dimens(
   /* small1=15.dp,
    small2=20.dp,
    small3=25.dp,
    medium1=35.dp,
    medium2=30.dp,
    medium3=45.dp,
    large=130.dp,
    logoSize=72.dp*/

)
