package co.simonojok19.notekeeper

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4::class)
@LargeTest
class NextThroughNoteTest {

    @get:Rule
    val noteListActivity: ActivityScenarioRule<NoteListActivity> = ActivityScenarioRule<NoteListActivity>(NoteListActivity::class.java)

    @Test
    fun nextThroughNotes() {
        // Prepare


        // Act
        val listViewDataInteraction = onData(allOf(instanceOf(NoteInfo::class.java), equalTo(DataManager.notes[0])))
        listViewDataInteraction.perform(click())
        for (index in 0..DataManager.notes.lastIndex) {
            val note = DataManager.notes[index]

            // Assert
            onView(withId(R.id.spinnerCourses))
                .check(matches(withSpinnerText(note.course?.title)))

            onView(withId(R.id.textNoteTitle))
                .check(matches(withText(note.title)))

            onView(withId(R.id.textNoteText))
                .check(matches(withText(note.text)))

            if(index != DataManager.notes.lastIndex) {
                onView(allOf(withId(R.id.action_next), isEnabled()))
                    .perform(click())
            }

        }

        // Assert
        onView(withId(R.id.action_next))
            .check(matches(not(isEnabled())))
    }
}