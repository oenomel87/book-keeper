package io.oenomel.keeperserver.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping("", "/")
    fun index(): ResponseEntity<String> {
        return ResponseEntity.ok().build()
    }
}
