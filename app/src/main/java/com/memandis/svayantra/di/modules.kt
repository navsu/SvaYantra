package com.memandis.svayantra.di

import androidx.room.Room
import com.memandis.svayantra.core.dispatchers.AppCoroutineDispatchers
import com.memandis.svayantra.db.SvaYantraControllerDB
import com.memandis.svayantra.localrepo.svayantra.SvaYantraLocalRepo
import com.memandis.svayantra.localrepo.svayantra.SvaYantraLocalRepoImpl
import com.memandis.svayantra.remoterepo.svayantra.SvaYantraAPIService
import com.memandis.svayantra.remoterepo.svayantra.SvaYantraRemoteRepo
import com.memandis.svayantra.remoterepo.svayantra.SvaYantraRemoteRepoImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import java.util.Date
import kotlinx.coroutines.asExecutor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// @Module
// object ApiModule {
//
//    private var scheme: String = ""
//        set(url) {
//            field = HttpUrl.parse(url)!!.scheme()
//        }
//
//
//    private var host: String = ""
//        set(url) {
//            field = HttpUrl.parse(url)!!.host()
//        }
//
// }

val dbModule = module {
    single {
        val transactionQueryExecutor = get<AppCoroutineDispatchers>().io.asExecutor()
        Room
            .databaseBuilder(
                androidApplication(),
                SvaYantraControllerDB::class.java,
                SvaYantraControllerDB.DB_NAME
            )
            .setQueryExecutor(transactionQueryExecutor)
            .setTransactionExecutor(transactionQueryExecutor)
            .fallbackToDestructiveMigration()
            .build()
    }

    single<SvaYantraLocalRepo> {
        SvaYantraLocalRepoImpl(svayantraControllerDao = get<SvaYantraControllerDB>().svayantraControllerDAO())
    }
}

// val apiModule = module {
//    private var scheme: String = ""
//    single {
//
//        set(url) {
//            field = HttpUrl.parse(url)!!.scheme()
//        }
//
//
//        private var host: String = ""
//        set(url) {
//            field = HttpUrl.parse(url)!!.host()
//        }
//
//    }
//
// }

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    single { Moshi.Builder().add(Date::class.java, Rfc3339DateJsonAdapter()).build() }

    single {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .client(get())
            .baseUrl("http://localhost/")
            .build()
    }

    single<SvaYantraRemoteRepo> {
        SvaYantraRemoteRepoImpl(
            svayantraAPIServce = get<Retrofit>().create(SvaYantraAPIService::class.java)
        )
    }
}
