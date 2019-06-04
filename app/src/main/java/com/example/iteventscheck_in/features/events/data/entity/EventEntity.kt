package com.example.iteventscheck_in.features.events.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EventEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val city: String,
    val description: String,
    val date: String,
    @ColumnInfo(name = "card_image") val cardImage: String
)