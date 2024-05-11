package com.example.knownyc.data.remote.repositories

import com.example.knownyc.commons.AppError
import com.example.knownyc.commons.Either
import com.example.knownyc.data.mappers.parksMapper
import com.example.knownyc.domain.models.NycPark
import com.example.knownyc.domain.repositories.NycParksRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NycParksRepositoryImpl @Inject constructor(
    private val apiService: NycOpenDataApiService
) : NycParksRepository {

    // TODO: Project 2
    private suspend fun getAndMapData(borough: String): List<NycPark> {
        val res = apiService.getNycParks(borough)
        return parksMapper(res)
    }
    override suspend fun getNycParks(borough: String): Either<AppError, List<NycPark>> {
        return try {
            val res = getAndMapData(borough)
            val parks = res.map { it }
            Either.Data(parks)
        } catch(e: HttpException) {
            Either.Error(AppError("HTTP Error: ${e.code()}"))
        } catch (e: IOException) {
            Either.Error(AppError("Network Error: ${e.message}"))
        } catch (e: Exception) {
            Either.Error(AppError("Unknown Error: ${e.message}"))

        }
    }
}