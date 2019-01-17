package com.company.applicationname.app.di.modules

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import com.company.applicationname.app.local.TestDatabase
import com.company.applicationname.app.local.dao.CategoryDao
import com.company.applicationname.app.ui.fragment.CategoryFragment
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideTestDatabase(app: Application): TestDatabase = Room.databaseBuilder(
        app,
        TestDatabase::class.java, "testDatabase"
    ).fallbackToDestructiveMigration().build()


    @Provides
    @Singleton
    fun provideCategoryDao(database: TestDatabase): CategoryDao = database.categoryDao()

    @Provides
    @Singleton
    fun providesCategoryFragment(): CategoryFragment {
        return CategoryFragment.newInstance("param1", "param2")
    }


}