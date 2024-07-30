    package com.nyonz.restcountriesapi

    import retrofit2.Call
    import retrofit2.http.GET

    interface RestCountriesApi {
        @GET("v3.1/all")
        fun getAllCountries(): Call<List<Country>>
    }
