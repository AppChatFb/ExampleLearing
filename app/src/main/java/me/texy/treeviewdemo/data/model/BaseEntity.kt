package me.texy.treeviewdemo.data.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

abstract class BaseEntity {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getLastUpdatedLocalDateTime(lastUpdate: Date): LocalDateTime {
        return Instant.ofEpochMilli(lastUpdate.time)
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime().minusHours(1)
    }
}