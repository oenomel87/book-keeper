package io.oenomel.stream.exception

class NotFoundException : RuntimeException {

    constructor(): super()

    constructor(message: String): super(message)
}
