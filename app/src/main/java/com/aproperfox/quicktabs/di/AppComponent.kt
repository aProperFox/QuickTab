package com.aproperfox.quicktabs.di

import com.aproperfox.quicktabs.MainActivity
import com.aproperfox.quicktabs.views.ChordBuilderFragment
import com.aproperfox.quicktabs.views.NewProjectDialog
import com.aproperfox.quicktabs.views.ProjectsFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: ProjectsFragment)
    fun inject(fragment: ChordBuilderFragment)
    fun inject(fragment: NewProjectDialog)
}