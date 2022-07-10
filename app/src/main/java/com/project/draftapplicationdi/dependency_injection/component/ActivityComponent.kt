package com.project.draftapplicationdi.dependency_injection.component

import com.project.draftapplicationdi.dependency_injection.PerActivity
import com.project.draftapplicationdi.dependency_injection.module.ActivityModule
import dagger.Component

@PerActivity
@Component(modules = [ActivityModule::class])
interface ActivityComponent
