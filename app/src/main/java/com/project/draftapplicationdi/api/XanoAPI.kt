package com.project.draftapplicationdi.api

import com.project.draftapplicationdi.model.Technology
import io.reactivex.Observable
import retrofit2.http.GET

interface XanoAPI {

    @GET("technologies")
    fun getTechnologies(): Observable<List<Technology>>
}