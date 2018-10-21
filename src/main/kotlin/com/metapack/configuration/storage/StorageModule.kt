package com.metapack.configuration.storage

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.dsl.module.module

val storageModule = module {

    single {
        val db = Database.connect("jdbc:h2:mem:regular", "org.h2.Driver")
        SchemaUtils.create(DmCarrierDefinitions, MpmCarrierDefinitions, LogisticServiceProviders)

        db
    }

}