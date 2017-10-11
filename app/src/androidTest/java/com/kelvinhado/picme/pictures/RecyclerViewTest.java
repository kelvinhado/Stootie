package com.kelvinhado.picme.pictures;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.kelvinhado.picme.R;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by kelvin on 11/10/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class RecyclerViewTest {

    private static final int ITEM_BELOW_THE_FOLD = 12;

    @Rule
    public ActivityTestRule<PicturesActivity> mActivityRule = new ActivityTestRule<>(
            PicturesActivity.class);

    @Test
    public void check_recycler_view_is_present() {
        try {
            onView(withId(R.id.rv_pictures)).perform(click());
            Assert.assertTrue("RecyclerView is present in the hierarchy", true);

        } catch (NoMatchingViewException e) {
            Assert.assertTrue("RecyclerView is present in the hierarchy", false);
        }
    }
}
