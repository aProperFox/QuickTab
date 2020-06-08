package com.aproperfox.quicktabs.models

import java.lang.IllegalArgumentException

sealed class Tuning(
    open val name: String,
    open val sixthString: Note,
    open val fifthString: Note,
    open val fourthString: Note,
    open val thirdString: Note,
    open val secondString: Note,
    open val firstString: Note
) {
    data class Custom(
        override val name: String,
        override val sixthString: Note,
        override val fifthString: Note,
        override val fourthString: Note,
        override val thirdString: Note,
        override val secondString: Note,
        override val firstString: Note
    ) : Tuning(name, sixthString, fifthString, fourthString, thirdString, secondString, firstString)

    object Standard : Tuning("Standard", Note.E, Note.A, Note.D, Note.G, Note.B, Note.E)
    object DropD : Tuning("DropD", Note.D, Note.A, Note.D, Note.G, Note.B, Note.E)
    object Dadgad : Tuning("DADGAD", Note.D, Note.A, Note.D, Note.G, Note.A, Note.D)
    object Iris : Tuning("Iris", Note.B, Note.D, Note.D, Note.D, Note.D, Note.D)
    object Riot : Tuning("Riot", Note.G, Note.A, Note.B, Note.D, Note.E, Note.G)
    object HazeyJane : Tuning("Hazey Jane", Note.C, Note.G, Note.C, Note.F, Note.C, Note.E)
    object Fernando : Tuning("Fernando", Note.D, Note.G, Note.D, Note.G, Note.A, Note.D)
    object OpenA : Tuning("OpenA", Note.E, Note.A, Note.CSharp, Note.E, Note.A, Note.E)
    object OpenB : Tuning("OpenB", Note.B, Note.FSharp, Note.B, Note.FSharp, Note.B, Note.DSharp)
    object OpenC : Tuning("OpenC", Note.C, Note.G, Note.C, Note.G, Note.C, Note.E)
    object OpenD : Tuning("OpenD", Note.D, Note.A, Note.D, Note.FSharp, Note.A, Note.D)
    object OpenE : Tuning("OpenE", Note.E, Note.B, Note.E, Note.GSharp, Note.B, Note.E)
    object OpenF : Tuning("OpenF", Note.C, Note.F, Note.C, Note.F, Note.A, Note.F)
    object OpenG : Tuning("OpenG", Note.D, Note.G, Note.D, Note.G, Note.B, Note.D)

    val notes: Array<Note>
        get() = arrayOf(
            sixthString,
            fifthString,
            fourthString,
            thirdString,
            secondString,
            firstString
        )

    override fun toString(): String {
        val notesString = notes.joinToString(
            separator = ", ",
            prefix = "(",
            postfix = ")",
            transform = Note::value
        )
        return "$name $notesString"
    }
}

enum class Note(val value: String) {
    A("A"),
    ASharp("A#/Bb"),
    B("B"),
    C("C"),
    CSharp("C#/Db"),
    D("D"),
    DSharp("D#/Eb"),
    E("E"),
    F("F"),
    FSharp("F#/Gb"),
    G("G"),
    GSharp("G#/Ab");

    companion object {
        @JvmStatic
        fun getFromString(note: String): Note {
            return values().find { it.value == note }
                ?: throw IllegalArgumentException("Value '$note' is not a valid note")
        }
    }
}