package kr.ac.kumoh.s2025111122.w26w11_thymeleaf.repository

import kr.ac.kumoh.s2025111122.w26w11_thymeleaf.model.Song

interface SongRepository {
    fun findAll(): List<Song>
    fun findById(id: Int): Song?
}
