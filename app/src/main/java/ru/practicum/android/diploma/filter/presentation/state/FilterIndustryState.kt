package ru.practicum.android.diploma.filter.presentation.state

import ru.practicum.android.diploma.filter.presentation.model.IndustryWithCheck

sealed class FilterIndustryState {
    data class LoadedList(val industry: List<IndustryWithCheck>) : FilterIndustryState()
    data object Loading : FilterIndustryState()
    data object Error : FilterIndustryState()
    data object NoInternetConnection : FilterIndustryState()
    data object Filtered : FilterIndustryState()
    data class EmptyList(val isEmpty: Boolean = true) : FilterIndustryState()
    data class SavedFilter(val isSaved: Boolean = true) : FilterIndustryState()
    data class ApplyVisible(val isVisible: Boolean) : FilterIndustryState()
}
