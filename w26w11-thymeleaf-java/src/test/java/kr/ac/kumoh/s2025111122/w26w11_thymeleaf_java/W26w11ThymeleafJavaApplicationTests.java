package kr.ac.kumoh.s2025111122.w26w11_thymeleaf_java;

import kr.ac.kumoh.s2025111122.w26w11_thymeleaf_java.model.Song;
import kr.ac.kumoh.s2025111122.w26w11_thymeleaf_java.repository.SongRepository;
import kr.ac.kumoh.s2025111122.w26w11_thymeleaf_java.service.SongService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class W26w11ThymeleafJavaApplicationTests {
    @Autowired
    private SongService service;

    @Test
    void contextLoads() {
        assertEquals(4, service.findAllSongs().size());
        assertEquals("소란스러운 비밀", service.findSongById(4).orElseThrow().title());
        assertTrue(service.findSongById(-1).isEmpty());
        assertTrue(service.findAllSongs().contains(service.getRandomSong().orElseThrow()));
    }

    @Test
    void emptyRepositoryReturnsNoRecommendation() {
        SongRepository emptyRepository = new SongRepository() {
            public List<Song> findAll() {
                return List.of();
            }

            public Optional<Song> findById(int id) {
                return Optional.empty();
            }
        };
        assertTrue(new SongService(emptyRepository).getRandomSong().isEmpty());
    }
}
