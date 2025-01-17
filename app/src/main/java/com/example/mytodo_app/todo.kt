package com.example.mytodo_app

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.time.Instant

@Entity
data class todo(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var createdAt: java.util.Date
)

