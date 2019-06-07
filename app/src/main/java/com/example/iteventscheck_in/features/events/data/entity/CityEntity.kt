package com.example.iteventscheck_in.features.events.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = EventEntity::class, parentColumns = ["id"], childColumns = ["event_id"])])
class CityEntity(
    @PrimaryKey
    @ColumnInfo(name = "event_id")
    val eventId: Int,
    val nameRus: String,
    //val nameEng: String,
    //val icon: String,
    //val isActiv: Boolean,

    val cityId: Int
)