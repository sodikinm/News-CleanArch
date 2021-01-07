package com.laam.core.di

import android.content.Context
import androidx.room.Room
import com.laam.core.data.source.local.room.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by luthfiarifin on 1/7/2021.
 */
@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): NewsDatabase = Room.databaseBuilder(
        context,
        NewsDatabase::class.java,
        NewsDatabase.DB_NAME
    ).fallbackToDestructiveMigration().build()
}