package com.company.applicationname.app

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.multidex.MultiDex
import androidx.work.Configuration
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import com.company.applicationname.app.di.modules.AppModule
import com.company.applicationname.app.di.modules.DaggerAppComponent
import com.company.applicationname.app.di.modules.NetModule
import com.company.applicationname.app.job.CategorySyncWork
import javax.inject.Inject


class Application : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)

        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule(BuildConfig.URL))
            .build().inject(this)


          val categorySyncWork =
              OneTimeWorkRequest.Builder(CategorySyncWork::class.java).addTag(CategorySyncWork.TAG).build()
          WorkManager.initialize(this, Configuration.Builder().build())
          var operation = WorkManager.getInstance()?.enqueue(categorySyncWork)



    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}