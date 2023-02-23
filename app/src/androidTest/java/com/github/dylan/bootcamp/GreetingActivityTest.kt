package com.github.dylan.bootcamp

import android.content.Intent
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GreetingActivityTest {

    @get:Rule
    var testRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun correctGreetingDisplayedOnIntent() {
        val message = "My testing value"
        val intent =
            Intent(ApplicationProvider.getApplicationContext(), GreetingActivity::class.java)
        intent.putExtra("name", message)
        ActivityScenario.launch<GreetingActivity>(intent).use{
            it.onActivity { activity ->
                assertThat(
                    activity.findViewById<TextView>(R.id.greetingMessage).text,
                    `is`("Hello $message!"))
            }
        }
    }
}