package com.example.licenta.dataClasses

data class training(
 val img:Int,
 val titlu:String,
 val serii:String,
 val repetiti:String,
 val video:Int,
 val instructiuni:String="Rezervat"
)
{
 constructor() : this(0, "", "", "", 0, "Rezervat")
}
