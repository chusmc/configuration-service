package com.metapack.configuration.graphql

import com.metapack.configuration.storage.DmCarrierDefinition
import com.metapack.configuration.storage.LogisticServiceProvider
import com.metapack.configuration.storage.MpmCarrierDefinition


class Schema(
    private val dmCarrierDefinition: DmCarrierDefinition,
    private val mpmCarrierDefinition: MpmCarrierDefinition,
    private val logisticServiceProvider: LogisticServiceProvider) {



}
