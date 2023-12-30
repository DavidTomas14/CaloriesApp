package com.davidtomas.caloriesapp.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.davidtomas.core.data.preferences.DefaultPreferences
import com.davidtomas.core.domain.preferences.Preferences
import com.davidtomas.core.domain.use_case.FilterOutDigitsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        app: Application
    ): SharedPreferences {
        return app.getSharedPreferences("shared_pref", MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): Preferences {
        return DefaultPreferences(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideFilterOutDigitsUseCase(): FilterOutDigitsUseCase {
        return FilterOutDigitsUseCase()
    }
}