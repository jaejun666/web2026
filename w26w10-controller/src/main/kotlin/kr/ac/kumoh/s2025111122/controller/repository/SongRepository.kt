package kr.ac.kumoh.s2025111122.controller.repository

import kr.ac.kumoh.s2025111122.controller.model.Song

interface SongRepository {
    fun findAll(): List<Song>
}