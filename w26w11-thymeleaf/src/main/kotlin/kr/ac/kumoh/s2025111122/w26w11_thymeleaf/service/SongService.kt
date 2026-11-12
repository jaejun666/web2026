package kr.ac.kumoh.s2025111122.w26w11_thymeleaf.service

import kr.ac.kumoh.s2025111122.w26w11_thymeleaf.repository.SongRepository
import org.springframework.stereotype.Service

@Service
class SongService(
    private val repository: SongRepository
) {
    /** 저장된 노래 목록을 반환합니다. */
    fun findAllSongs() = repository.findAll()

    /** ID와 일치하는 노래를 반환합니다. */
    fun findSongById(id: Int) = repository.findById(id)

    /** 저장된 노래 중 한 곡을 무작위로 고릅니다. 목록이 비어 있으면 null을 반환합니다. */
    fun getRandomSong() = repository.findAll().randomOrNull()
}
