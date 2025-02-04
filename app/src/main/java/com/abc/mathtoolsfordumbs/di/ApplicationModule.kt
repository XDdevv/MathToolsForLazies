package com.abc.mathtoolsfordumbs.di

import android.content.Context
import com.abc.mathtoolsfordumbs.app.Application
import com.abc.mathtoolsfordumbs.data.repository.AlgorithmsRepositoryImpl
import com.abc.mathtoolsfordumbs.data.repository.HomeRepositoryImpl
import com.abc.mathtoolsfordumbs.domain.repository.AlgorithmsRepository
import com.abc.mathtoolsfordumbs.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationModule {

    @Binds
    @Singleton
    abstract fun bindHomeRepo(impl: HomeRepositoryImpl): HomeRepository

    @Binds
    @Singleton
    abstract fun bindAlgorithmsRepo(impl: AlgorithmsRepositoryImpl): AlgorithmsRepository

    companion object {

        @Provides
        fun provideContext(@ApplicationContext application: Application): Context {
            return application.applicationContext
        }


    }
}