package ru.practicum.android.diploma.utils

import android.util.Log
import java.util.Currency
import java.util.Locale
import java.util.TreeMap

private const val CURRENCY_REFETENCE_MAP_EXCEPION_MESSAGE =
    "Can not create currency object due the following exception:"
private const val CURRENCY_ERROR_TAG = "CUR"
private const val CURRENCY_RUR = "RUR"
private const val CURRENCY_RUB = "RUB"
private const val CURRENCY_BYR = "BYR"
private const val CURRENCY_BYN = "BYN"
private const val CURRENCY_USD = "RUB"

object CurrencySymbol {
    private val currencyLocaleMap = TreeMap<Currency, Locale>() { c1: Currency, c2: Currency ->
        c1.currencyCode.compareTo(c2.currencyCode)
    }

    init {
        for (locale in Locale.getAvailableLocales()) {
            try {
                val currency = Currency.getInstance(locale);
                currencyLocaleMap[currency] = locale;
            } catch (e: Exception) {
                Log.d(CURRENCY_ERROR_TAG, "$CURRENCY_REFETENCE_MAP_EXCEPION_MESSAGE ${e.message}")
            }
        }
    }

    fun getCurrencySymbol(currencyCode: String?): String {
        Log.e("BLR", "${currencyLocaleMap.toString()}")
        if (currencyCode != null) {
            val currency = Currency.getInstance(currencyCode)
            return try {
                when (currencyCode) {
                    CURRENCY_RUR -> Currency.getInstance(CURRENCY_RUB).symbol
                    CURRENCY_BYR -> Currency.getInstance(CURRENCY_BYN).symbol
                    CURRENCY_USD -> Currency.getInstance(CURRENCY_USD).symbol
                    else -> currency.getSymbol(currencyLocaleMap[currency])
                }
            } catch (e: NullPointerException) {
                return currencyCode
            }
        } else return ""
    }
}