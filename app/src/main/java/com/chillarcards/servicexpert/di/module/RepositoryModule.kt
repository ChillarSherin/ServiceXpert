package com.chillarcards.servicexpert.di.module

import com.chillarcards.servicexpert.data.api.ApiHelper
import com.chillarcards.servicexpert.data.api.ApiHelperImpl
import com.chillarcards.servicexpert.data.repository.AuthRepository
import com.chillarcards.servicexpert.data.repository.InnerRepository
import org.koin.dsl.module

/**
 * @Author: Sherin Jaison
 * @Date: 01-11-2023
 * Chillar
 */
val repoModule = module {
    single {
        AuthRepository(get())
    }
    single {
        InnerRepository(get())
    }
    single<ApiHelper> {
        return@single ApiHelperImpl(get())
    }
}