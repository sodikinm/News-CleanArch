package com.laam.news_cleanarch.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.laam.news_cleanarch.core.data.source.local.entity.NewsFavoriteEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by luthfiarifin on 1/16/2021.
 */
@Dao
interface NewsFavoriteDao {

    @Query("SELECT * FROM ${NewsDatabase.NEWS_FAVORITE_TABLE_NAME}")
    fun getAllNewsFavorite(): Flow<List<NewsFavoriteEntity>>

    @Query("SELECT * FROM ${NewsDatabase.NEWS_FAVORITE_TABLE_NAME} WHERE url = :url")
    fun getNewsFavorite(url: String): Flow<NewsFavoriteEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsFavorite(newsEntity: NewsFavoriteEntity): Long

    @Query("DELETE FROM ${NewsDatabase.NEWS_FAVORITE_TABLE_NAME} WHERE url = :url")
    suspend fun deleteNewsFavorite(url: String): Int
}