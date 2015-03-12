package com.jiahaoliuliu.unittestingwithandroidstudio;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    public void linkedViewsTest() {
        assertThat(mMainActivity).isNotNull();

        EditText mFirstNumberET = (EditText)mMainActivity.findViewById(R.id.first_number_et);
        assertThat(mFirstNumberET).isNotNull();

        EditText mSecondNumberET = (EditText)mMainActivity.findViewById(R.id.second_number_et);
        assertThat(mSecondNumberET).isNotNull();

        TextView mResultTV = (TextView)mMainActivity.findViewById(R.id.result_tv);
        assertThat(mResultTV).isNotNull();

        Button mCalculateBtn = (Button)mMainActivity.findViewById(R.id.calculate_btn);
        assertThat(mCalculateBtn).isNotNull();

    }

    @After
    public void tearDown() {
        mMainActivity = null;
    }
}
