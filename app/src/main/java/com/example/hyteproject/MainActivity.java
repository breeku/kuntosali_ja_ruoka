package com.example.hyteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int selectedLift = 1;
    boolean fiveThreeOne = true;



    //// ui refresh setup

    HorizontalScrollView horizontalScrollView;
    LinearLayout bigFourLinearLayout;
    ScrollView verticalScrollView;
    LinearLayout bottomButtonsLayout;


    EditText squatEditText;
    EditText benchEditText;
    EditText deadliftEditText;
    EditText overheadpressEditText;
    TextView squatTextView;
    TextView benchTextView;
    TextView deadliftTextView;
    TextView overheadpressTextView;

    TextView fiveThreeOneTextView;


    TextView set1TextView;
    TextView set1NumTextView;

    TextView set2TextView;
    TextView set2NumTextView;

    TextView set3TextView;
    TextView set3NumTextView;

    TextView set4TextView;
    TextView set4NumTextView;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        uiRefresh();

        squatEditText.setOnKeyListener(onKeyListener);
        benchEditText.setOnKeyListener(onKeyListener);
        deadliftEditText.setOnKeyListener(onKeyListener);
        overheadpressEditText.setOnKeyListener(onKeyListener);


        // getting saved shared preferences for the four edit texts

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("com.example.hyteproject", Context.MODE_PRIVATE);

        int count = sharedPref.getInt("Count", 0);

        float[] savedWeight = new float[4];

        for (int i = 0; i < count; i++) {

            savedWeight[i] = sharedPref.getFloat("savedWeight_" + i, -1);
        }

        squatEditText.setText(String.valueOf(savedWeight[0]));
        benchEditText.setText(String.valueOf(savedWeight[1]));
        deadliftEditText.setText(String.valueOf(savedWeight[2]));
        overheadpressEditText.setText(String.valueOf(savedWeight[3]));



       horizontalScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_UP || motionEvent.getAction() == MotionEvent.ACTION_CANCEL) {

                    int center = horizontalScrollView.getScrollX() + horizontalScrollView.getWidth() / 2;
                    int childNumber = bigFourLinearLayout.getChildCount();

                    for (int i = 0; i < childNumber; i++) {

                        View v1 = bigFourLinearLayout.getChildAt(i);
                        int viewLeft = v1.getLeft();
                        int viewWidth = v1.getWidth();

                        if (center >= viewLeft && center <= viewLeft + viewWidth) {

                            horizontalScrollView.scrollBy((viewLeft + viewWidth / 2) - center, 0);
                            selectedLift = i;

                            if (i == 1) {
                                //SQUAT color on
                                squatEditText.setTextColor(Color.WHITE);
                                squatTextView.setTextColor(Color.WHITE);

                                benchEditText.setTextColor(Color.BLACK);
                                benchTextView.setTextColor(Color.BLACK);
                                deadliftEditText.setTextColor(Color.BLACK);
                                deadliftTextView.setTextColor(Color.BLACK);
                                overheadpressEditText.setTextColor(Color.BLACK);
                                overheadpressTextView.setTextColor(Color.BLACK);

                            } else if (i == 2) {
                                //BENCH color on
                                benchEditText.setTextColor(Color.WHITE);
                                benchTextView.setTextColor(Color.WHITE);

                                squatEditText.setTextColor(Color.BLACK);
                                squatTextView.setTextColor(Color.BLACK);
                                deadliftEditText.setTextColor(Color.BLACK);
                                deadliftTextView.setTextColor(Color.BLACK);
                                overheadpressEditText.setTextColor(Color.BLACK);
                                overheadpressTextView.setTextColor(Color.BLACK);
                            } else if (i == 3) {
                                //DEADLIFT color on
                                deadliftEditText.setTextColor(Color.WHITE);
                                deadliftTextView.setTextColor(Color.WHITE);

                                benchEditText.setTextColor(Color.BLACK);
                                benchTextView.setTextColor(Color.BLACK);
                                squatEditText.setTextColor(Color.BLACK);
                                squatTextView.setTextColor(Color.BLACK);
                                overheadpressEditText.setTextColor(Color.BLACK);
                                overheadpressTextView.setTextColor(Color.BLACK);
                            } else if (i == 4) {
                                //OVERHEADPRESS color on
                                overheadpressEditText.setTextColor(Color.WHITE);
                                overheadpressTextView.setTextColor(Color.WHITE);

                                benchEditText.setTextColor(Color.BLACK);
                                benchTextView.setTextColor(Color.BLACK);
                                deadliftEditText.setTextColor(Color.BLACK);
                                deadliftTextView.setTextColor(Color.BLACK);
                                squatEditText.setTextColor(Color.BLACK);
                                squatTextView.setTextColor(Color.BLACK);
                            }


                            break;
                        }
                    }
                }
                return false;
            }
        });

        horizontalScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                horizontalScrollView.smoothScrollTo(200, 0); //need to set exact WIDTH to middle squad layout point
                setFiveThreeOne(fiveThreeOneTextView);
                squatEditText.setTextColor(Color.WHITE);
                squatTextView.setTextColor(Color.WHITE);
            }
        });
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    public String round(double number) {

        double temp = number % 2.5;

        if (temp < 1.25)
            return String.valueOf(number - temp);
        else
            return String.valueOf(number + 2.5 - temp);

    }

    public void setFiveThreeOne(View v) {

        fiveThreeOne = true;
        fiveThreeOneTextView.setTextColor(Color.WHITE);
        setFiveThreeOneText();
    }

    public void setFiveThreeOneText() {

        double weight;

        if (selectedLift == 1) {
            //SQUAT
            weight = Double.parseDouble(squatEditText.getText().toString());

            set1NumTextView.setText(round(weight * .65) + " x7");
            set2NumTextView.setText(round(weight * .75) + " x5");
            set3NumTextView.setText(round(weight * .85) + " x3");
            set4NumTextView.setText(round(weight * .95) + " x1+");


            set1TextView.setText("Set 1 - 65%");
            set2TextView.setText("Set 2 - 75%");
            set3TextView.setText("Set 3 - 85%");
            set4TextView.setText("Set 4 - 95%");



        } else if (selectedLift == 2) {
            //BENCH
            weight = Double.parseDouble(benchEditText.getText().toString());

            set1NumTextView.setText(round(weight * .65) + " x7");
            set2NumTextView.setText(round(weight * .75) + " x5");
            set3NumTextView.setText(round(weight * .85) + " x3");
            set4NumTextView.setText(round(weight * .95) + " x1+");


            set1TextView.setText("Set 1 - 65%");
            set2TextView.setText("Set 2 - 75%");
            set3TextView.setText("Set 3 - 85%");
            set4TextView.setText("Set 4 - 95%");


        } else if (selectedLift == 3) {
            //DEAD LIFT
            weight = Double.parseDouble(deadliftEditText.getText().toString());

            set1NumTextView.setText(round(weight * .65) + " x7");
            set2NumTextView.setText(round(weight * .75) + " x5");
            set3NumTextView.setText(round(weight * .85) + " x3");
            set4NumTextView.setText(round(weight * .95) + " x1+");


            set1TextView.setText("Set 1 - 65%");
            set2TextView.setText("Set 2 - 75%");
            set3TextView.setText("Set 3 - 85%");
            set4TextView.setText("Set 4 - 95%");


        } else if (selectedLift == 4) {
            //OHP
            weight = Double.parseDouble(overheadpressEditText.getText().toString());

            set1NumTextView.setText(round(weight * .65) + " x7");
            set2NumTextView.setText(round(weight * .75) + " x5");
            set3NumTextView.setText(round(weight * .85) + " x3");
            set4NumTextView.setText(round(weight * .95) + " x1+");


            set1TextView.setText("Set 1 - 65%");
            set2TextView.setText("Set 2 - 75%");
            set3TextView.setText("Set 3 - 85%");
            set4TextView.setText("Set 4 - 95%");

        }

    }

    View.OnKeyListener onKeyListener = new View.OnKeyListener() {

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent keyEvent) {
            // if the event is a key-down event on the "enter" button
            if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER)) {
                // Perform action on key press

                float[] savedWeights = {Float.parseFloat(squatEditText.getText().toString()), Float.parseFloat(benchEditText.getText().toString()),
                        Float.parseFloat(deadliftEditText.getText().toString()), Float.parseFloat(overheadpressEditText.getText().toString())};

                saveWeight(savedWeights);

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                return true;

            }
            return false;
        }
    };

    public void saveWeight (float[] array) {

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("com.example.hyteproject", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("Count", array.length);

        int count = 0;
        for (float i : array) {
            editor.putFloat("savedWeight" + count++, i);
        }
        editor.apply();
    }

    public void uiRefresh () {

        horizontalScrollView =  findViewById(R.id.horizontalScrollView);
        bigFourLinearLayout = findViewById(R.id.bigFourLayout);
        verticalScrollView =  findViewById(R.id.verticalScrollView);
        bottomButtonsLayout = findViewById(R.id.bottomButtonsLayout);


        squatEditText = findViewById(R.id.squatEditText);
        benchEditText = findViewById(R.id.benchEditText);
        deadliftEditText = findViewById(R.id.deadliftEditText);
        overheadpressEditText = findViewById(R.id.overheadpressEditText);
        squatTextView = findViewById(R.id.squatTextView);
        benchTextView = findViewById(R.id.benchTextView);
        deadliftTextView = findViewById(R.id.deadliftTextView);
        overheadpressTextView = findViewById(R.id.overheadpressTextView);
        fiveThreeOneTextView = findViewById(R.id.fiveThreeOneTextView);

        set1TextView = findViewById(R.id.set1TextView);
        set1NumTextView = findViewById(R.id.set1NumTextView);

        set2TextView = findViewById(R.id.set2TextView);
        set2NumTextView =  findViewById(R.id.set2NumTextView);

        set3TextView = findViewById(R.id.set3TextView);
        set3NumTextView = findViewById(R.id.set3NumTextView);

        set4TextView = findViewById(R.id.set4TextView);
        set4NumTextView = findViewById(R.id.set4NumTextView);

    }
}