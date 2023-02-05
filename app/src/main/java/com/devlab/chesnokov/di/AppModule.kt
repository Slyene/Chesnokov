package com.devlab.chesnokov.di

import android.app.Application
import androidx.room.Room
import com.devlab.chesnokov.feature_fims.data.data_source.FilmDatabase
import com.devlab.chesnokov.feature_fims.data.repository.FilmRepositoryImpl
import com.devlab.chesnokov.feature_fims.domain.repository.FilmRepository
import com.devlab.chesnokov.feature_fims.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDataBase(app: Application): FilmDatabase {
        return Room.databaseBuilder(
            app,
            FilmDatabase::class.java,
            FilmDatabase.DATABASE_NAME,
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: FilmDatabase): FilmRepository {
        return FilmRepositoryImpl(db.filmDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: FilmRepository): FilmUseCases {
        return FilmUseCases(
            getFilms = GetFilms(repository),
            changeFavoriteStatus = ChangeFavoriteStatus(repository),
            getFavoriteFilms = GetFavoriteFilms(repository),
            getFilmById = GetFilmById(repository),
        )
    }
}