package com.project.draftapplicationdi.dependency_injection.module

import android.app.Activity
import android.content.Context
import com.project.draftapplicationdi.dependency_injection.ActivityContext
import com.project.draftapplicationdi.dependency_injection.PerActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @PerActivity
    @Provides
    @ActivityContext
    fun provideContext(): Context = activity
}
