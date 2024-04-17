package com.sarichev.lombard.di

import android.app.Application
import com.sarichev.lombard.LoanApplication
import com.sarichev.lombard.di.annotations.ApplicationScope
import com.sarichev.lombard.di.module.DataModule
import com.sarichev.lombard.di.module.NavigationModule
import com.sarichev.lombard.di.module.RoutersModule
import com.sarichev.lombard.di.module.ScreensModule
import com.sarichev.lombard.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [DataModule::class,
        ViewModelModule::class,
        NavigationModule::class,
        RoutersModule::class,
        AndroidSupportInjectionModule::class,
        ScreensModule::class]
)
@ApplicationScope
interface LoanApplicationComponent {

    fun inject(app: LoanApplication)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): LoanApplicationComponent
    }

}