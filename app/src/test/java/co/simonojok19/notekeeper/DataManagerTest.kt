package co.simonojok19.notekeeper

import org.junit.Test

import org.junit.Assert.*


class DataManagerTest {

    @Test
    fun testAddNote() {
        // Prepare
        val course = DataManager.courses["android_async"]!!
        val noteTitle = "This is a test note"
        val noteText = "This is the body of my test note"

        // Act
        val index = DataManager.addNote(course, noteTitle, noteText)

        val note = DataManager.notes[index]

        // Assert
        assertEquals(course, note.course)
        assertEquals(noteText, note.text)
        assertEquals(noteTitle, note.title)
    }
}