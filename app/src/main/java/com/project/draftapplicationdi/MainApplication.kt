package com.project.draftapplicationdi

import android.app.Application
import com.project.draftapplicationdi.dependency_injection.component.AppComponent
import com.project.draftapplicationdi.dependency_injection.component.DaggerAppComponent
import com.project.draftapplicationdi.dependency_injection.module.ApplicationModule
import com.project.draftapplicationdi.dependency_injection.module.HttpModule


open class MainApplication : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        createComponent()
    }

    protected open fun createComponent() {
        component = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this))
            .httpModule(HttpModule())
            .build()
    }
}