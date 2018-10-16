package com.metapack.configuration.storage

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.UUIDTable
import java.util.*

object DmCarrierDefinitions : UUIDTable() {
    val uri = varchar("uri", 50)
    val carrierId = integer("carrierId")
    val name = varchar("name", 50)
    val carrierCode = varchar("name", 50)

    val logisticsServiceProvider = reference("logisticsServiceProvider", LogisticServiceProviders)
}

class DmCarrierDefinition(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<DmCarrierDefinition>(DmCarrierDefinitions)

    var uri by DmCarrierDefinitions.uri
    var carrierId by DmCarrierDefinitions.carrierId
    var name by DmCarrierDefinitions.name
    var carrierCode by DmCarrierDefinitions.carrierCode

    var logisticServiceProvider by LogisticServiceProvider referencedOn DmCarrierDefinitions.logisticsServiceProvider
}

object MpmCarrierDefinitions : UUIDTable() {
    val uri = varchar("uri", 50)
    val carrierId = integer("carrierId")
    val name = varchar("name", 50)
    val carrierCode = varchar("name", 50)

    val logisticsServiceProvider = reference("logisticsServiceProvider", LogisticServiceProviders)
}

class MpmCarrierDefinition(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<MpmCarrierDefinition>(DmCarrierDefinitions)

    var uri by MpmCarrierDefinitions.uri
    var carrierId by MpmCarrierDefinitions.carrierId
    var name by MpmCarrierDefinitions.name
    var carrierCode by MpmCarrierDefinitions.carrierCode

    var logisticServiceProvider by LogisticServiceProvider referencedOn MpmCarrierDefinitions.logisticsServiceProvider
}


object LogisticServiceProviders : UUIDTable() {
    val uri = varchar("uri", 50)
    val name = varchar("name", 50)
}

class LogisticServiceProvider(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<LogisticServiceProvider>(LogisticServiceProviders)

    var uri by LogisticServiceProviders.uri
    var name by LogisticServiceProviders.name

    val dmCarrierDefinitions by DmCarrierDefinition referrersOn DmCarrierDefinitions.logisticsServiceProvider
    val mpmCarrierDefinitions by MpmCarrierDefinition referrersOn MpmCarrierDefinitions.logisticsServiceProvider
}


