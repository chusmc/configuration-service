package com.metapack.configuration.graphql

import com.github.pgutkowski.kgraphql.KGraphQL
import com.metapack.configuration.storage.DmCarrierDefinition
import com.metapack.configuration.storage.LogisticServiceProvider
import com.metapack.configuration.storage.MpmCarrierDefinition
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import java.util.*

class ConfigurationSchema (
    private val logisticServiceProviderDao: UUIDEntityClass<LogisticServiceProvider>) : KoinComponent {

    val schema = KGraphQL.schema {
        val dmCarrierDefinitionDao: UUIDEntityClass<DmCarrierDefinition> by inject()
        val mpmCarrierDefinitionDao: UUIDEntityClass<MpmCarrierDefinition> by inject()


        stringScalar<UUID> {
            serialize = { uuid -> uuid.toString() }
            deserialize = { uuidString -> UUID.fromString(uuidString) }
        }

        query("logisticServiceProvider") {
            resolver { id: UUID -> logisticServiceProviderDao.findById(id) }
        }

        query("dmCarrierDefinition") {
            resolver { id: UUID -> dmCarrierDefinitionDao.findById(id) }
        }

        query("mpmCarrierDefinition") {
            resolver { id: UUID -> mpmCarrierDefinitionDao.findById(id) }
        }

        type<DmCarrierDefinition> {
            description = "A Dm Carrier definition"
        }

        type<MpmCarrierDefinition> {
            description = "A Mpm Carrier definition"
        }

        type<LogisticServiceProvider> {
            description = "A Logistics service provider"
        }
    }

}
