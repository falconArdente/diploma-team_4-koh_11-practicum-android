package ru.practicum.android.diploma.filter.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.practicum.android.diploma.filter.domain.api.CountryFilterInteractor
import ru.practicum.android.diploma.filter.domain.model.Area
import ru.practicum.android.diploma.filter.domain.model.AreaDetailsFilterItem
import ru.practicum.android.diploma.filter.domain.model.CountryFilter
import ru.practicum.android.diploma.filter.presentation.state.AreaFilterState
import ru.practicum.android.diploma.utils.Resource

class CountryFilterViewModel(private val countryFilterInteractor: CountryFilterInteractor) : ViewModel() {
    private val _stateLiveDataCountry = MutableLiveData<AreaFilterState>(AreaFilterState.Loading)
    val stateLiveDataCountry: LiveData<AreaFilterState> = _stateLiveDataCountry

    init {
        viewModelScope.launch {
            countryFilterInteractor.getCountries().collect {
                processSearchCountriesListRequest(it)
            }
        }
    }

    private fun processSearchCountriesListRequest(searchCountriesResult: Resource<List<Area>>) {
        if (searchCountriesResult.data != null) {
            val countryFilterState = AreaFilterState.AreaContent(searchCountriesResult.data)
            _stateLiveDataCountry.value = countryFilterState
        } else {
            _stateLiveDataCountry.value = AreaFilterState.Error(searchCountriesResult.message!!)
        }
    }

    fun saveCountryChoiceToFilter(country: AreaDetailsFilterItem) {
        countryFilterInteractor.saveCountry(
            CountryFilter(countryId = country.areaId, countryName = country.areaName)
        )
        val savedCountry = countryFilterInteractor.getAllSavedParameters()?.countryName
        Log.e("TEST7", "$savedCountry")
    }
}