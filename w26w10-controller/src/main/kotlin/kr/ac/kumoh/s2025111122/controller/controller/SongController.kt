package kr.ac.kumoh.s2025111122.controller.controller

import kr.ac.kumoh.s2025111122.controller.service.SongService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SongController(
    private val service: SongService
) {

    @GetMapping("/songs")
    fun getSongs() = service.findAllSongs()
}
