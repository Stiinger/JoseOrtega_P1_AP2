package edu.ucne.joseortega_p1_ap2.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.joseortega_p1_ap2.data.local.dao.Dao
import edu.ucne.joseortega_p1_ap2.data.local.database.JoseOrtegaP1Db
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideContext(@ApplicationContext appContext: Context) = appContext

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context) =
        Room.databaseBuilder(
            appContext,
            JoseOrtegaP1Db::class.java,
            "JoseOrtegaP1Db.db"
        ).fallbackToDestructiveMigration()
            .build()
}