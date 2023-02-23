package com.github.dylan.bootcamp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var testRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun intentIsFiredWhenButtonClicked() {
        Intents.init()

        onView(withId(R.id.mainGoButton))
            .perform(click())

        intended(allOf(
            IntentMatchers.hasExtra("name", "Your name"),
            IntentMatchers.hasComponent(GreetingActivity::class.java.name)
        ))
        Intents.release()
    }
}