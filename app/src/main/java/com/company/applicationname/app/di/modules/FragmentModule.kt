package com.company.applicationname.app.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.company.applicationname.app.ui.fragment.*

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    internal abstract fun contributesCategoryFragment(): CategoryFragment

}