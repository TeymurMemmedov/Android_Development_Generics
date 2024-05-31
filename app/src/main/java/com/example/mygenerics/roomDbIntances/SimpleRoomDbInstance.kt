package com.example.mygenerics.roomDbIntances

import android.content.Context


//Dont forget change dao,entity,database names
@Database(entities = [Entity1::class.java,Entity2::class.java], version = 1)
abstract class SimpleRoomDbInstance : RoomDatabase() {
    abstract fun anyDao(): AnyDao

    companion object {
        @Volatile
        private var INSTANCE: SimpleRoomDbInstance? = null
        fun getInstance(context: Context, ): SimpleRoomDbInstance {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SimpleRoomDbInstance::class.java,
                    "any.db"
                )
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

    }
}