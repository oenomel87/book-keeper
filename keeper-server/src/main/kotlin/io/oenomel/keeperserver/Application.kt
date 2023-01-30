package io.oenomel.keeperserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KeeperServerApplication

fun main(args: Array<String>) {
    runApplication<KeeperServerApplication>(*args)
}
