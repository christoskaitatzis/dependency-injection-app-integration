package com.project.draftapplicationdi.dependency_injection.component


import com.project.draftapplicationdi.dependency_injection.module.AndroidModule
import com.project.draftapplicationdi.dependency_injection.module.ApplicationModule
import com.project.draftapplicationdi.dependency_injection.module.HttpModule
import com.project.draftapplicationdi.dependency_injection.module.RxThreadModule
import com.project.draftapplicationdi.view.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HttpModule::class, ApplicationModule::class, AndroidModule::class, RxThreadModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
}