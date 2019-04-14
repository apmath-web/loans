package com.apmath.loans.com.apmath.loans.infrastructure

import io.ktor.application.Application
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy
import org.koin.ktor.ext.inject

class ServiceManager(app: Application) {
    val serviceHello by app.inject<HelloServiceInterface>()

    companion object {
        private var instance: ServiceManager? = null

        fun getInstance(): ServiceManager {
            if (instance == null)
                throw NullPointerException("Must use ServiceManager.init(this@module) in Application.module first")
            else
                return instance!!
        }

        fun init(application: Application) {
            instance = ServiceManager(application)
        }

        val serviceManagerModule = module {
            singleBy<HelloServiceInterface, HelloService>()
        }
    }
}

//Temporary for example

interface HelloServiceInterface {
    fun sayHello(): String
}

class HelloService : HelloServiceInterface {
    override fun sayHello() = "Hello Ktor & Koin!"
}
