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

    fun testFindSimilarNotes() {
        // Prepare
        val course = DataManager.courses["android_async"]!!
        val noteTitle = "This is a test note"
        val noteText1 = "This is the body of my test note"
        val noteText2 = "This is the body of my second test note"

        // Act
        val index1 = DataManager.addNote(course, noteTitle, noteText1)
        val index2 = DataManager.addNote(course, noteTitle, noteText2)

        val note1 = DataManager.findNote(course, noteTitle, noteText1)
        val foundIndex1 = DataManager.notes.indexOf(note1)

        val note2 = DataManager.findNote(course, noteTitle, noteText2)
        val foundIndex2 = DataManager.notes.indexOf(note2)

        // Assert
        Assert.assertEquals(index1, foundIndex1)
        Assert.assertEquals(index2, foundIndex2)
    }


}