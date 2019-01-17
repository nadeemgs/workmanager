package com.company.applicationname.app.di;

import androidx.lifecycle.ViewModel;
import dagger.MapKey;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@MapKey
@interface ViewModelKey {
    Class<? extends ViewModel> value();
}