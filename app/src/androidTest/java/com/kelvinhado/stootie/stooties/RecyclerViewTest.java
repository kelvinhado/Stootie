package com.kelvinhado.stootie.stooties;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.kelvinhado.stootie.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by kelvin on 11/10/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class RecyclerViewTest {

    private static final int ITEM_BELOW_THE_FOLD = 12;

    @Rule
    public ActivityTestRule<StootiesActivity> mActivityRule = new ActivityTestRule<>(
            StootiesActivity.class);

    @Test
    public void check_recycler_view_is_present() {
        onView(withId(R.id.rv_stooties)).check(matches(isDisplayed()));
    }

    @Test
    public void check_recycler_view_click() {
        onView(withText("Cours d'italien")).perform(click());
        onView(withId(R.id.tv_item_title)).check(matches(withText("Cours d'italien")));
    }
}
