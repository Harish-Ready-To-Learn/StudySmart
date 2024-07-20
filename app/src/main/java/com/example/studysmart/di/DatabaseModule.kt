package com.example.studysmart.di

import android.app.Application
import androidx.room.Room
import com.example.studysmart.data.local.AppDataBase
import com.example.studysmart.data.local.SessionDao
import com.example.studysmart.data.local.SubjectDao
import com.example.studysmart.data.local.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        application: Application
    ): AppDataBase {
        return Room
            .databaseBuilder(
                application,
                AppDataBase::class.java,
                "studysmart.db"
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideSubjectDao(dataBase: AppDataBase): SubjectDao {
        return dataBase.subjectDao()
    }

    @Provides
    @Singleton
    fun provideTaskDao(dataBase: AppDataBase): TaskDao {
        return dataBase.taskDao()
    }

    @Provides
    @Singleton
    fun provideSessionDao(dataBase: AppDataBase): SessionDao {
        return dataBase.sessionDao()
    }
}