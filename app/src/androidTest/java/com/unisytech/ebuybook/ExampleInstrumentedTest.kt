package com.unisytech.ebuybook

import androidx.paging.PagingData
import androidx.paging.filter
import androidx.paging.map
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.unisytech.ebuybook.di.DaggerEBuyBookComponent
import com.unisytech.ebuybook.ditest.EBuyBookComponentTest
import com.unisytech.ebuybook.repo.FakeBookRepo
import com.unisytech.ebuybook.repo.BooksRepository
import com.unisytech.ebuybook.repo.UTAPIResponse
import com.unisytech.ebuybook.network.response.Book
import com.unisytech.ebuybook.network.response.BooksListApiResponse
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.util.regex.Pattern.matches

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
     val activityRule = ActivityScenarioRule(MainActivity::class.java)
    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        (InstrumentationRegistry.getInstrumentation()
            .targetContext.applicationContext as TestEBuyBookApplication).appComponent?.let { (it as EBuyBookComponentTest).inject(this) }
    }
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.unisytech.ebuybook", appContext.packageName)

    }

    @Test
     fun booksListShown() {
        onView(withId(R.id.recycler_view)).check(ViewAssertions.matches(isDisplayed()))
        onView(withText("BookTest"))
            .check(ViewAssertions.matches(isDisplayed()))
     }



}