package com.company.applicationname.app.repo

import com.company.applicationname.app.domain.Category
import com.company.applicationname.app.local.dao.CategoryDao
import com.company.applicationname.app.remote.CategoryAPI
import io.reactivex.Observable
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    val categoryDao: CategoryDao,
    val categoryAPI: CategoryAPI
) {


    fun getCategoriesFromApi(): Observable<List<Category>> {


        return categoryAPI.listCategories()
            .doOnNext {
                for (item in it) {
                    if (item != null) {
                        categoryDao.insertcategory(item)
                    }
                }
            }
    }

    fun getCategoreisFromDb(limit: Int, offset: Int): Observable<List<Category>> {

        this.getCategoriesFromApi()
        return categoryDao.queryCategories(limit, offset)
            .toObservable()
    }


    fun addAllCategories(categories: List<Category>) {
        categoryDao.insertAllCategories(categories)
    }




    fun getAllCategories() : List<Category>{
       return categoryDao.getAllCategory()
    }

}