package com.example.vhh.ui.data.db


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.vhh.ui.data.db.doas.ListingDao
import com.example.vhh.ui.data.db.doas.UserDao
import com.example.vhh.ui.data.db.models.Listing
import com.example.vhh.ui.data.db.models.User
import com.example.vhh.ui.data.db.models.typeConverters.Converters


@Database(
    entities = [
        User::class,
        Listing::class
    ],
//    autoMigrations = [
//        /**
//         * Migration from version 8 to version 10
//         *
//         */
//        AutoMigration (from = 9, to = 10)
//    ],
    version = 11, // Updated version to 10
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class DB : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun listingDao(): ListingDao
}