package com.example.myapplication

import android.app.Application
import com.example.myapplication.db.roomModule
import com.example.myapplication.rest.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@DemoApplication)
            // declare modules
            modules(appModule)

            modules(roomModule)
            modules(retrofitModule)

            modules(exampleRepositoryModule)
        }
    }
}

val appModule = module {
    // ViewModel for Detail View
    viewModel { MainViewModel(get()) }
}