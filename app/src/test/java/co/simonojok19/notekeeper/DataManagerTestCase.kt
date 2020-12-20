package co.simonojok19.notekeeper

import junit.framework.TestCase
import org.junit.Assert

class DataManagerTestCase : TestCase() {

    public override fun setUp() {
        super.setUp()
    }

    public override fun tearDown() {}

    fun testGetCourses() {}

    fun testGetNotes() {}

    fun testAddNote() {
        // Prepare
        val course = DataManager.courses["android_async"]!!
        val noteTitle = "This is a test note"
        val noteText = "This is the body of my test note"

        // Act
        val index = DataManager.addNote(course, noteTitle, noteText)

        val note = DataManager.notes[index]

        // Assert
        Assert.assertEquals(course, note.course)
        Assert.assertEquals(noteText, note.text)
        Assert.assertEquals(noteTitle, note.title)
    }


}