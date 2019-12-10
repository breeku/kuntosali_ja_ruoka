package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    double calorieCount;
    Henkilo henkilo;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        henkilo = (Henkilo) intent.getSerializableExtra("HENKILO");
        calorieCount = henkilo.getCalorie();

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.kaloriMaara);
        textView.setText(Double.toString(calorieCount) + " kcal");

        button = findViewById(R.id.kcal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityFood();
            }
        });

        button = findViewById(R.id.gym);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityGym();
            }
        });
    }

    /**
     * open other activity when the button clicked
     * @author Ali
     */
    public void openActivityFood(){
        Intent intent = new Intent(this, ActivityFood.class);
        startActivity(intent);
    }
    /**
     * open other activity when the button clicked
     * @author Ali
     */
    public void openActivityGym(){
        Intent intent = new Intent(this, ActivityGym.class);
        startActivity(intent);
    }
}
