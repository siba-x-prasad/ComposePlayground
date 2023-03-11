package com.swasi.composeplayground.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.swasi.composeplayground.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton // Tell Dagger-Hilt to create a singleton accessible everywhere in ApplicationCompenent (i.e. everywhere in the application)
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "userDatabase"
    ).addMigrations(MIGRATION_1_2)
        .build() // The reason we can construct a database for the repo

    @Singleton
    @Provides
    fun provideYourDao(db: AppDatabase) =
        db.userDao()

    private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Since we didn't alter the table, there's nothing else to do here.
            database.execSQL(
                "ALTER TABLE user "
                        + " ADD COLUMN last_update INTEGER"
            )
        }
    }

    val MIGRATION_2_3: Migration = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Since we didn't alter the table, there's nothing else to do here.
        }
    }

}