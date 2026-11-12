package kr.ac.kumoh.s2025111122.controller.service

import kr.ac.kumoh.s2025111122.controller.repository.SongRepository
import org.springframework.stereotype.Service

@Service
class SongService(
    private val repository: SongRepository
) {
    fun findAllSongs() = repository.findAll()
}
