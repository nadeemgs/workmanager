package com.company.applicationname.app.remote

import com.company.applicationname.app.domain.Category
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoryAPI {

    @GET("categories/")
    fun listCategories(): Observable<List<Category>>

    @GET("categories/{id}/")
    fun getCategory(@Path("id") id: Long): Observable<Category>


}