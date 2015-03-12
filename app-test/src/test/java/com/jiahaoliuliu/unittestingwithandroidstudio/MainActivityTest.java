package com.jiahaoliuliu.unittestingwithandroidstudio;

import android.content.Intent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jiahao on 3/9/15.
 */
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {

    private MainActivity mMainActivity;

    @Before
    public void setup() {
        Intent startMainActivityIntent = new Intent(
                ShadowApplication.getInstance().getApplicationContext(), MainActivity.class);
        // Here you can add any data to the intent

        mMainActivity = Robolectric.buildActivity(MainActivity.class)
                .withIntent(startMainActivityIntent).create().get();
    }

    @Test
    public void simpleTest() {
        assertThat(mMainActivity).isNotNull();
    }

    @After
    public void tearDown() {
        mMainActivity = null;
    }
}
