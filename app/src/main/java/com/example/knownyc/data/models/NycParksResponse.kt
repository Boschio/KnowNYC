package com.example.knownyc.data.models

import kotlinx.serialization.Serializable

// TODO: Project 2
// This model represents the data from a database

@Serializable
data class NycParksResponse(
    val signname: String,
    val location: String,
    val waterfront: Boolean? = false,
    val url: String = "",
    )
