package kr.ac.kumoh.s2025111122.w26w11_thymeleaf_java.controller;

import kr.ac.kumoh.s2025111122.w26w11_thymeleaf_java.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SongController {
    private final SongService service;

    @GetMapping("/songs/random")
    public String getRandomSong(Model model) {
        model.addAttribute("song", service.getRandomSong().orElse(null));
        return "random";
    }
}
