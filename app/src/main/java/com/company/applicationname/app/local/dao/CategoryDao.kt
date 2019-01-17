package com.company.applicationname.app.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.company.applicationname.app.domain.Category

import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface CategoryDao {

    @Query("SELECT * FROM categories WHERE pmId = :pmId")
    fun getCategoryById(pmId: Long): Flowable<Category>


    @Query("SELECT * FROM categories")
    fun getAllCategory(): List<Category>

    @Query("SELECT * FROM categories ORDER BY pmId limit :limit offset :offset")
    fun queryCategories(limit: Int, offset: Int): Single<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertcategory(category: Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCategories(category: List<Category>)

    @Query("DELETE FROM categories")
    fun deleteAllCategories()
}