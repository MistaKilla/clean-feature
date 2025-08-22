package ru.barru.clean_feature_example

import android.app.Application
import android.content.Context
import org.koin.core.Koin
import ru.barru.common_koin.ComponentFactory
import ru.barru.common_koin.KoinProvider

class App : Application(), KoinProvider {

    override lateinit var koin: Koin
        private set

    override fun onCreate() {
        super.onCreate()
        koin = initKoin()
    }

    private fun initKoin() = Koin().apply {
        loadModules(modules)
        declare(this@App as Application)
        declare(this@App as Context)
        declare(ComponentFactory(this))
        createEagerInstances()
    }

}