package com.devlab.chesnokov.feature_fims.data.data_source

import android.provider.ContactsContract
import androidx.room.*
import com.devlab.chesnokov.feature_fims.domain.model.Film
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {

    @Query("SELECT * FROM film")
    fun getFilms(): Flow<List<Film>>

    @Query("SELECT * FROM film WHERE isFavorite = 'TRUE'")
    fun getFavoriteFilms(): Flow<List<Film>>

    @Query("SELECT * FROM film WHERE filmId = :id")
    suspend fun getFilmById(id: Int): Film?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(note: Film)

    @Delete
    suspend fun deleteFilm(note: Film)
}