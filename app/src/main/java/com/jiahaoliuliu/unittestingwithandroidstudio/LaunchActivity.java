package com.jiahaoliuliu.unittestingwithandroidstudio;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LaunchActivity extends ActionBarActivity {

    private Button mLaunchCalculatorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        mLaunchCalculatorBtn = (Button) findViewById(R.id.launch_calculator_btn);
        mLaunchCalculatorBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startCalculatorIntent = new Intent(LaunchActivity.this, MainActivity.class);
                startActivity(startCalculatorIntent);
            }
        });
    }
}
