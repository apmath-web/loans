package com.apmath.loans.com.apmath.loans.infrastructure

import io.ktor.application.Application
import org.koin.dsl.module
import org.koin.experimental.builder.single
import org.koin.experimental.builder.singleBy
import org.koin.ktor.ext.inject

/**
 * Service Manager for services
 *
 * To define interface, add
 * ```
 * singleBy<SomeServiceInterface, SomeService>()
 * ```
 * and then val in class
 * ```
 * val serviceSome by app.inject<SomeServiceInterface>()
 * ```
 */
class ServiceManager(app: Application) {
    val serviceHello by app.inject<HelloServiceInterface>()

    companion object {
        private var instance: ServiceManager? = null

        /**
         * Returns instance of [ServiceManager]
         *
         * Must use [init] before getting instance of [ServiceManager]
         */
        fun getInstance(): ServiceManager {
            if (instance == null)
                throw NullPointerException("Must use ServiceManager.init(this@module) in Application.module first")
            else
                return instance!!
        }

        /**
         * Must be used before getting instance
         * @param application Application.module from Ktor
         */
        fun init(application: Application) {
            instance = ServiceManager(application)
        }

        /**
         * Modules in which services connect to their interfaces
         */
        val serviceManagerModule = module {
            singleBy<HelloServiceInterface, HelloService>()
            single<HelloRepository>()
        }
    }
}

//Temporary for example

interface HelloServiceInterface {
    fun sayHello(): String
}

class HelloService(private val helloRepository: HelloRepository) : HelloServiceInterface {
    override fun sayHello() = "Hello ${helloRepository.getHello()}"
}

class HelloRepository {
    fun getHello(): String = "Ktor & Koin"
}
