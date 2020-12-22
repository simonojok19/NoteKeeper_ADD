package com.jwhh.notekeeper

import android.support.test.espresso.Espresso
import android.support.test.espresso.ViewAction
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.DrawerActions
import android.support.test.espresso.contrib.NavigationViewActions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @JvmField
    @Rule
    val itemsActivity = ActivityTestRule(ItemsActivity::class.java)

    @Test
    fun selectNoteAfterNavigationDrawerChange() {
        Espresso.onView(ViewMatchers.withId(R.id.drawer_layout))
                .perform(DrawerActions.open())

        Espresso.onView(ViewMatchers.withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_courses))

        val coursePosition = 0
        Espresso.onView(ViewMatchers.withId(R.id.listItems))
                .perform(
                        RecyclerViewActions.actionOnItemAtPosition<CourseRecyclerAdapter.ViewHolder>(
                                coursePosition,
                                ViewActions.click()
                        )
                )

        Espresso.onView(ViewMatchers.withId(R.id.drawer_layout))
                .perform(DrawerActions.open())

        Espresso.onView(ViewMatchers.withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_notes))

        val notePosition = 0

        Espresso.onView(ViewMatchers.withId(R.id.listItems))
                .perform(
                        RecyclerViewActions.actionOnItemAtPosition<NoteRecyclerAdapter.ViewHolder>(
                                notePosition,
                                ViewActions.click()
                        )
                )

        val note = DataManager.notes[notePosition]
        Espresso.onView(ViewMatchers.withId(R.id.spinnerCourses))
                .check(ViewAssertions.matches(ViewMatchers.withSpinnerText(CoreMatchers.containsString(note.course?.title))))

        Espresso.onView(ViewMatchers.withId(R.id.textNoteTitle))
                .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString(note.title))))

        Espresso.onView(ViewMatchers.withId(R.id.textNoteText))
                .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString(note.text))))
    }

}