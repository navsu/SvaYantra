package com.memandis.svayantra

import android.app.Application
import com.memandis.svayantra.core.dispatchers.dispatchersModule
import com.memandis.svayantra.di.dbModule
import com.memandis.svayantra.di.networkModule
import com.memandis.svayantra.ui.dashboard.dashboardVMModule
import com.memandis.svayantra.ui.home.homeVMModule
import com.memandis.svayantra.usecase.svayantra.svayantraUseCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SvaYantraApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(androidContext = this@SvaYantraApp)

            modules(
                dbModule,
                networkModule,
                dispatchersModule,
                svayantraUseCaseModule,
                dashboardVMModule,
                homeVMModule
            )
        }
    }
}
