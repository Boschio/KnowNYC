package com.example.knownyc.data.mappers

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import com.example.knownyc.commons.AppError
import com.example.knownyc.commons.TAG
import java.io.IOException

// map Exception to AppError messages

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
fun Throwable.toError(): AppError {
    Log.d(TAG, "mapping Exception: $this")
    val error = when (this) {
        is retrofit2.HttpException -> "Unknown response"
        is IOException -> "Network error"
        else -> "Unknown error"

    }
    return AppError(error, throwable = this)
}