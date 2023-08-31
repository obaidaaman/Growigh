package com.example.growgh.Model

data class User(

    val name: String,
    val email: String,
    val uid: String,
    val password : String

){
    constructor() : this("", "", "","")
}
