package com.example.knownyc.presentation.parks

import com.example.knownyc.commons.AppError
import com.example.knownyc.domain.models.NycPark

// TODO: Project 2

data class NycParksUIState(
    val isLoading: Boolean = false,
    val parks: List<NycPark> = emptyList(),
    val error: AppError? = null,
)
