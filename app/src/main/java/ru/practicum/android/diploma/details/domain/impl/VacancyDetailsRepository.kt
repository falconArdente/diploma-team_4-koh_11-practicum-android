package ru.practicum.android.diploma.details.domain.impl

import kotlinx.coroutines.flow.Flow
import ru.practicum.android.diploma.details.domain.model.VacancyDetails
import ru.practicum.android.diploma.utils.Resource

interface VacancyDetailsRepository {
    suspend fun getVacancyById(id: String): Flow<Resource<VacancyDetails>>
}
