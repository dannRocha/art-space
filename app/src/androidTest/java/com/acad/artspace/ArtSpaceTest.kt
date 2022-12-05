package com.acad.artspace

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.acad.artspace.ui.theme.ArtSpaceTheme
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

class ArtSpaceTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun should_have_a_dog_when_open_app() {
        composeTestRule.setContent {
            ArtSpaceTheme{
                ArtSpace()
            }
        }

        composeTestRule.onNodeWithText("Dog")
            .assertExists()

    }

    @Test
    fun should_performance_button_next_and_change_image() {
        composeTestRule.setContent {
            ArtSpaceTheme{
                ArtSpace()
            }
        }

        composeTestRule.onNodeWithText("Next")
            .performClick()

        composeTestRule.onNodeWithText("Cat")
            .assertExists()

    }

    @Test
    fun should_performance_button_previous_and_change_image() {
        composeTestRule.setContent {
            ArtSpaceTheme{
                ArtSpace()
            }
        }

        composeTestRule.onNodeWithText("Previous")
            .performClick()

        composeTestRule.onNodeWithText("Owl")
            .assertExists()

    }

    @Test
    fun should_have_two_buttons_previous_and_next() {
        composeTestRule.setContent {
            ArtSpaceTheme{
                ArtSpace()
            }
        }

        composeTestRule.onNodeWithText("Previous")
            .assertExists()

        composeTestRule.onNodeWithText("Next")
            .assertExists()

    }
}