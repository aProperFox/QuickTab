package com.aproperfox.quicktabs.db

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.aproperfox.quicktabs.models.Note
import com.aproperfox.quicktabs.models.Tuning

@TypeConverters
class Converters {
    @TypeConverter
    fun tuningToDBString(tuning: Tuning): String {
        val notes = tuning.notes.joinToString(separator = ",", prefix = "|")
        return "${tuning.name}$notes"
    }

    @TypeConverter
    fun stringToTuning(string: String): Tuning {
        val (name: String, rawNotes: String) = string.split("|")
        val notes: List<Note> = rawNotes.split(",").map { Note.getFromString(it) }
        return Tuning.Custom(name, notes[0], notes[1], notes[2], notes[3], notes[4], notes[5])
    }
}