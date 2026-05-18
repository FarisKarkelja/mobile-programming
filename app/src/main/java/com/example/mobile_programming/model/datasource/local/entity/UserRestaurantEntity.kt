package com.example.mobile_programming.model.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "user_favorites",
    foreignKeys = [
        ForeignKey(
            entity = RestaurantEntity::class,
            parentColumns = ["id"],
            childColumns = ["restaurant_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        ),
    ],
    indices = [Index(value = ["user_id"]), Index(value = ["restaurant_id"])]
)
data class UserRestaurantEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "restaurant_id")
    val restaurantId: Long,
    @ColumnInfo(name = "user_id")
    val userId: Long
)