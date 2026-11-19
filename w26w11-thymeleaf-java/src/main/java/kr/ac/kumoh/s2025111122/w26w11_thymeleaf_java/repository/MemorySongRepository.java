package kr.ac.kumoh.s2025111122.w26w11_thymeleaf_java.repository;

import kr.ac.kumoh.s2025111122.w26w11_thymeleaf_java.model.Song;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class MemorySongRepository implements SongRepository {
    private final List<Song> songs = List.of(
        new Song(1, "Cosmic Echo", "NEBULA"),
        new Song(2, "Neon Fever", "SPARK"),
        new Song(3, "Velvet Bitter", "LUNA"),
        new Song(4, "소란스러운 비밀", "Windy")
    );

    @Override
    public List<Song> findAll() {
        return List.copyOf(songs);
    }

    @Override
    public Optional<Song> findById(int id) {
        return songs.stream()
            .filter(song -> song.id() == id)
            .findFirst();
    }
}
