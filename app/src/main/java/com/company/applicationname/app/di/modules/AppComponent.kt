package com.company.applicationname.app.di.modules

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import com.company.applicationname.app.Application
import com.company.applicationname.app.di.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AndroidInjectionModule::class, ActitivityModule::class, AppModule::class,
        NetModule::class, AndroidSupportInjectionModule::class, FragmentModule::class, ViewModelModule::class
    )
)
interface AppComponent {
    fun inject(app: Application)
}