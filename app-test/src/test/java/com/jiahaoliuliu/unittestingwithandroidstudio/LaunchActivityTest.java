package com.jiahaoliuliu.unittestingwithandroidstudio;

import android.content.ComponentName;
import android.content.Intent;
import android.widget.Button;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.ShadowIntent;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jiahao on 3/12/15.
 */
@RunWith(RobolectricGradleTestRunner.class)
public class LaunchActivityTest {

    private LaunchActivity mLaunchActivity;

    @Before
    public void setup() {
        mLaunchActivity = Robolectric.buildActivity(LaunchActivity.class).create().get();
    }

    @Test
    public void linkedViewsTest() {
        assertThat(mLaunchActivity).isNotNull();

        // Test the views
        Button mLaunchCalculatorBtn = (Button) mLaunchActivity.findViewById(R.id.launch_calculator_btn);
        assertThat(mLaunchCalculatorBtn).isNotNull();
    }

    @Test
    public void checkIntentLaunched() {
        Intent expectedIntent =
                new Intent(ShadowApplication.getInstance().getApplicationContext(),
                        MainActivity.class);

        Button mLaunchCalculatorBtn = (Button) mLaunchActivity.findViewById(R.id.launch_calculator_btn);
        mLaunchCalculatorBtn.performClick();

        ShadowActivity shadowActivity = Shadows.shadowOf(mLaunchActivity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = Shadows.shadowOf(startedIntent);

        assertThat(Shadows.shadowOf(mLaunchActivity).getNextStartedActivity())
                .isEqualTo(expectedIntent);
    }

    @After
    public void tearDown() {
        mLaunchActivity = null;
    }
}
