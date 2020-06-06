package com.aproperfox.quicktabs.di

import com.aproperfox.quicktabs.db.AppDatabase
import com.aproperfox.quicktabs.db.ProjectDao
import dagger.Module
import dagger.Provides

@Module
object AppModule {
    @Provides
    @JvmStatic
    fun provideAppDB(): AppDatabase {
        return AppDatabase.get()
    }

    @Provides
    @JvmStatic
    fun provideProjectDao(appDatabase: AppDatabase): ProjectDao = appDatabase.projectDao()
}