package co.simonojok19.notekeeper

import junit.framework.TestCase

class DataManagerTest : TestCase() {

    fun testAddNote() {
        val course = DataManager.courses["android_async"]!!
        val noteTitle = "This is a test note"
        val noteText = "This is the body of my test note"

        val index = DataManager.addNote(course, noteTitle, noteText)

        val note = DataManager.notes[index]
    }
}