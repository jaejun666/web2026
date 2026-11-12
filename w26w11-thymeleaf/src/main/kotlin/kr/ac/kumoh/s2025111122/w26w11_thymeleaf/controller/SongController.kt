package kr.ac.kumoh.s2025111122.w26w11_thymeleaf.controller

import kr.ac.kumoh.s2025111122.w26w11_thymeleaf.service.SongService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SongController(
    private val service: SongService
) {
    @GetMapping("/songs/random")
    fun getRandomSong(model: Model): String {
        model.addAttribute("song", service.getRandomSong())
        return "random"
    }
}
