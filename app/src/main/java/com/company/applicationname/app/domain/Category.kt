package com.company.applicationname.app.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "categories")
data class Category(
    @PrimaryKey
    @ColumnInfo(name = "pmId")
    var pmId: Long = 0,
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "defaultColor")
    var defaultColor: String? = "",
    @ColumnInfo(name = "parentCategory")
    var parentCategory: Long = 0,
    @ColumnInfo(name = "upperCategory")
    var upperCategory: Long = 0
)


