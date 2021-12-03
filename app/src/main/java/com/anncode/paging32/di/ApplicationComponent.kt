package com.anncode.paging32.di

import com.anncode.paging32.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by anahi.salgado on 02-Dec-21.
 */
@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class, RepositoryModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}
