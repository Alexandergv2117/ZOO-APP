package com.example.zoo.di

import android.content.Context
import androidx.room.Room
import com.example.zoo.data.DB.ZooDB
import com.example.zoo.utils.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideFrRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ZooDB::class.java, Const.DB_NAME).build()

    @Singleton
    @Provides
    fun provideSpecietypeDao(db: ZooDB) = db.getSpecieTypeDao()
}