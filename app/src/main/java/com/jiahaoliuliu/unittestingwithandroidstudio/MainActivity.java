package com.jiahaoliuliu.unittestingwithandroidstudio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private EditText mFirstNumberET;
    private EditText mSecondNumberET;
    private Button mCalculateBtn;
    private TextView mResultTV;
    private Calculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creates the calculator
        mCalculator = new Calculator();

        // Link the elements
        mFirstNumberET = (EditText)findViewById(R.id.first_number_et);
        mSecondNumberET = (EditText)findViewById(R.id.second_number_et);
        mResultTV = (TextView)findViewById(R.id.result_tv);
        mCalculateBtn = (Button)findViewById(R.id.calculate_btn);
        mCalculateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCalculator.clean();

                // Set the first number
                String firstNumberString = mFirstNumberET.getText().toString();
                if (!TextUtils.isEmpty(firstNumberString)) {
                    mCalculator.setFirstNumber(Integer.valueOf(firstNumberString));
                }

                // Set the second number
                String secondNumberString = mSecondNumberET.getText().toString();
                if (!TextUtils.isEmpty(secondNumberString)) {
                    mCalculator.setSecondNumber(Integer.valueOf(secondNumberString));
                }

                // String.valueOf() is needed here because otherwise, the method setText(int resourceId)
                // will be invoked and it could break the app.
                mResultTV.setText(String.valueOf(mCalculator.sum()));
            }
        });

    }
}
