package com.example.knownyc.domain.models

// TODO: Project 2
// This is the model used by the presentation layer

data class NycPark(
    val name: String,
    val location: String,
    val waterfront: Boolean,
    val url: String,
)
