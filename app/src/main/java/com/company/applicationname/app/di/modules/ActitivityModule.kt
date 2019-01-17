package com.company.applicationname.app.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.company.applicationname.app.MainActivity

@Module
abstract class ActitivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainAcitivty(): MainActivity
}