package io.oenomel.keeperserver.exception

class NotFoundException : RuntimeException {

    constructor(): super()

    constructor(message: String): super(message)
}
