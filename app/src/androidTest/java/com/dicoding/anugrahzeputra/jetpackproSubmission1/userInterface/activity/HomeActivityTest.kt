package com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.dicoding.anugrahzeputra.jetpackproSubmission1.R
import com.dicoding.anugrahzeputra.jetpackproSubmission1.utility.DummyData
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    private val listDummyMovie = DummyData.dataMovie()
    private val listDummyTvShow = DummyData.dataTvShow()

    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun checkMovieAndTvShow() {
        Espresso.onView(ViewMatchers.withId(R.id.rvMovie)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvMovie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(listDummyMovie.size))

        Espresso.onView(ViewMatchers.withId(R.id.nav_tvshow)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.rvTvShow)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvTvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(listDummyTvShow.size))

        Espresso.onView(ViewMatchers.withId(R.id.nav_movie)).perform(ViewActions.click())
    }

    @Test
    fun checkDetailOnMovie() {
        Espresso.onView(ViewMatchers.withId(R.id.rvMovie)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvMovie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(9))
        Espresso.onView(ViewMatchers.withId(R.id.rvMovie)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(9,
                    ViewActions.click()
                ))

        Espresso.onView(ViewMatchers.withId(R.id.image)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.imagePoster)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.detailName)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.description)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btnShare)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.detailName)).check(ViewAssertions.matches(ViewMatchers.withText(listDummyMovie[9].name)))
        Espresso.onView(ViewMatchers.withId(R.id.description)).check(ViewAssertions.matches(ViewMatchers.withText(listDummyMovie[9].desc)))

        Espresso.pressBack()
    }

    @Test
    fun checkDetailOnTvShow() {
        Espresso.onView(ViewMatchers.withId(R.id.nav_tvshow)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.rvTvShow)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvTvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(9))
        Espresso.onView(ViewMatchers.withId(R.id.rvTvShow)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(9,
                    ViewActions.click()
                ))

        Espresso.onView(ViewMatchers.withId(R.id.image)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.imagePoster)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.detailName)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.description)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btnShare)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.detailName)).check(ViewAssertions.matches(ViewMatchers.withText(listDummyTvShow[9].name)))
        Espresso.onView(ViewMatchers.withId(R.id.description)).check(ViewAssertions.matches(ViewMatchers.withText(listDummyTvShow[9].desc)))

        Espresso.pressBack()
    }
}