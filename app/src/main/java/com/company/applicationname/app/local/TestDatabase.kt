package com.company.applicationname.app.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.company.applicationname.app.domain.Category
import com.company.applicationname.app.local.dao.CategoryDao


@Database(entities = arrayOf( Category::class), version = 1)
abstract class TestDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}