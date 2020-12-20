package co.simonojok19.notekeeper

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.*
import androidx.test.filters.LargeTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class CreateNewNoteTest {

    @get:Rule
    val noteListActivity = ActivityScenarioRule(NoteListActivity::class.java)

    @Test
    fun createNewNote() {
        // Prepare
        val course = DataManager.courses["android_async"]
        val noteTitle = "Test note title"
        val noteText = "This is the body of our test note"

        // Act
        val fabViewInteraction = onView(withId(R.id.fab))
        fabViewInteraction.perform(click())

        val spinnerInteraction = onView(withId(R.id.spinnerCourses));
        spinnerInteraction.perform(click())

        val dataInteraction = onData(allOf(instanceOf(CourseInfo::class.java), equalTo(course)))
        dataInteraction.perform(click())

        val noteTitleViewInteraction = onView(withId(R.id.textNoteTitle))
        noteTitleViewInteraction.perform(typeText(noteTitle))

        val noteTextViewInteraction = onView(withId(R.id.textNoteText))
        noteTextViewInteraction.perform(typeText(noteText))


        Espresso.closeSoftKeyboard()



        Espresso.pressBack()



        // Assert
        val newNote = DataManager.notes.last()
        assertEquals(course, newNote.course)
        assertEquals(noteTitle, newNote.title)
        assertEquals(noteText, newNote.text)


    }
}