package ru.practicum.android.diploma.filter.domain.impl

import ru.practicum.android.diploma.filter.domain.model.AreaDetailsFilterItem
import ru.practicum.android.diploma.filter.domain.model.FilterGeneral
import ru.practicum.android.diploma.filter.domain.model.IndustryDetailsFilterItem

interface FilterStorageRepository {
    // сохранение параметров для финального фильтра на базовом экране с кнопкой "Применить".
    // После нажатия на кнопку "Применить" сохраненный фильтр потом используется для поиска с фильтром
    fun saveAllFilterParameters(filter: FilterGeneral)

    // получение параметров финального фильтра для экрана поиска
    fun getAllFilterParameters(): FilterGeneral

    // получение параметров для промежуточных фильтров (отрасль/ регион) на экранах с RecyclerView
    // и базового экрана с кнопкой "применить" до нажатия на эту кнопку
    fun getAllSavedParameters(): FilterGeneral

    // сброс параметров для финального фильтра на базовом экране с кнопкой "Применить"
    fun clearAllFilterParameters()

    // проверка для экрана поиска, сохранено ли что-то в финальном фильтре на базовом экране
    fun isFilterActive(): Boolean

    // сохранение параметра региона для параметров промежуточного фильтра на экранах выбора отрасли/региона/места работы
    fun saveArea(area: AreaDetailsFilterItem)

    // сохранение параметра страны для параметров промежуточного фильтра на экранах выбора отрасли/региона/места работы
    fun saveCountry(country: AreaDetailsFilterItem)

    // сохранение параметра отрасли для параметров промежуточного фильтра на экранах выбора отрасли/региона/места работы
    fun saveIndustry(industry: IndustryDetailsFilterItem)

    // сохранение параметра зп для на экране базового фильтра (если "применить" не было нажато)
    fun saveExpectedSalary(salaryAmount: String)

    // сохранение флага "не показывать без зп" на экране базового фильтра (если "применить" не было нажато)
    fun saveHideNoSalaryItems(hideNoSalaryItems: Boolean)

}
