package com.example.knownyc.data.mappers

import com.example.knownyc.data.models.NycParksResponse
import com.example.knownyc.domain.models.NycPark

// TODO: Project 2

suspend fun parksMapper(
    nycParksList: List<NycParksResponse>
): List<NycPark> {
    val parks = mutableListOf<NycPark>()

    for (i in nycParksList.indices) {
        val parkRes = nycParksList[i]

        val park = NycPark(
            name = parkRes.signname,
            location = parkRes.location,
            waterfront = parkRes.waterfront!!,
            url = parkRes.url
        )

        parks.add(park)
    }


    return parks
}