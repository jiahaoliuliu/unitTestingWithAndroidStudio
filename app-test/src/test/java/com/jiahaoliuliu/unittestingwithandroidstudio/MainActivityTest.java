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

        EditText firstNumberET = (EditText)mMainActivity.findViewById(R.id.first_number_et);
        assertThat(firstNumberET).isNotNull();

        TextView addSymbolTV = (TextView)mMainActivity.findViewById(R.id.add_symbol_tv);
        assertThat(addSymbolTV).isNotNull();

        EditText secondNumberET = (EditText)mMainActivity.findViewById(R.id.second_number_et);
        assertThat(secondNumberET).isNotNull();

        Button calculateBtn = (Button)mMainActivity.findViewById(R.id.calculate_btn);
        assertThat(calculateBtn).isNotNull();

        TextView resultTV = (TextView)mMainActivity.findViewById(R.id.result_tv);
        assertThat(resultTV).isNotNull();

    }

    @Test
    public void valuesInitializedTest() {
        EditText firstNumberET = (EditText)mMainActivity.findViewById(R.id.first_number_et);
        assertThat(firstNumberET.getText()).isEqualTo("0");

        TextView addSymbolTV = (TextView)mMainActivity.findViewById(R.id.add_symbol_tv);
        assertThat(addSymbolTV.getText()).isEqualTo("+");

        EditText secondNumberET = (EditText)mMainActivity.findViewById(R.id.second_number_et);
        assertThat(secondNumberET.getText()).isEqualTo("0");

        Button calculateBtn = (Button)mMainActivity.findViewById(R.id.calculate_btn);
        assertThat(calculateBtn.getText()).isEqualTo("=");

        TextView resultTV = (TextView)mMainActivity.findViewById(R.id.result_tv);
        assertThat(resultTV.getText()).isEmpty();
    }

    /**
     * This test check if the calculator could do the follow operation:
     *     1 + 2 = 3
     */
    @Test
    public void simpleSumTest() {
        int firstNumber = 1;
        int secondNumber = 2;

        Calculator calculator = new Calculator(firstNumber, secondNumber);
        int result = calculator.sum();

        EditText firstNumberET = (EditText)mMainActivity.findViewById(R.id.first_number_et);
        firstNumberET.setText(String.valueOf(firstNumber));

        EditText secondNumberET = (EditText)mMainActivity.findViewById(R.id.second_number_et);
        secondNumberET.setText(String.valueOf(secondNumber));

        Button calculateBtn = (Button)mMainActivity.findViewById(R.id.calculate_btn);
        calculateBtn.performClick();

        TextView resultTV = (TextView)mMainActivity.findViewById(R.id.result_tv);
        assertThat(resultTV.getText()).isEqualTo(String.valueOf(result));
    }

    @After
    public void tearDown() {
        mMainActivity = null;
    }
}
