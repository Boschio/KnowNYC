package com.example.knownyc.domain.repositories

import com.example.knownyc.commons.AppError
import com.example.knownyc.commons.Either
import com.example.knownyc.domain.models.NycPark

interface NycParksRepository {

    // TODO: Project 2
    suspend fun getNycParks(borough: String): Either<AppError, List<NycPark>>
}