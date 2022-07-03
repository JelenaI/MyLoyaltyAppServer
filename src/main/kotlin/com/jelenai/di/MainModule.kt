package com.jelenai.di

import com.jelenai.data.repository.pharmacy.PharmacyRepository
import com.jelenai.data.repository.pharmacy.PharmacyRepositoryImpl
import com.jelenai.data.repository.user.UserRepository
import com.jelenai.data.repository.user.UserRepositoryImpl
import com.jelenai.service.PharmacyService
import com.jelenai.service.UserService
import com.jelenai.util.Constants
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        val client = KMongo.createClient().coroutine
        client.getDatabase(Constants.DATABASE_NAME)
    }
    single<UserRepository> {
        UserRepositoryImpl(get())
    }
    single {
        UserService(get())
    }
    single<PharmacyRepository> {
        PharmacyRepositoryImpl(get())
    }
    single {
        PharmacyService(get())
    }
}