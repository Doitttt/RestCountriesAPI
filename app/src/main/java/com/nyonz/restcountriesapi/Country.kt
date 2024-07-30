package com.nyonz.restcountriesapi

data class Country(
    val name: Name,
    val tld: List<String>?,
    val cca2: String?,
    val ccn3: String?,
    val cca3: String?,
    val capital: List<String>?,
    val region: String?,
    val population: Int?,
    val flags: Flags?
)

data class Name(
    val common: String?,
    val official: String?
)

data class Flags(
    val png: String?,
    val svg: String?
)
