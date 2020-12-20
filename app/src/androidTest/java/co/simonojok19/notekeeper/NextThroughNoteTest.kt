package co.simonojok19.notekeeper

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
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

    }
}