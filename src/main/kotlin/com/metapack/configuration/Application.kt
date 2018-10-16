package com.metapack.configuration

import com.metapack.configuration.storage.*
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.server.netty.DevelopmentEngine
import org.koin.ktor.ext.installKoin


@Suppress("unused")
fun Application.main() {

    installKoin(listOf(storageModule))

    install(Routing) {
        get("/") {
            call.respondText("Hello, Lucas!", ContentType.Text.Html)
        }
    }
}


fun main(args: Array<String>) {
    DevelopmentEngine.main(args)
}