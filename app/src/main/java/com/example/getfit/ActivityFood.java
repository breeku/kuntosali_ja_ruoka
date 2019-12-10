package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Luokka sisältää koodin, joka kertoo mistä etusivun layout koostuu.
 * Lisää onItemClickListenerin, joka huomaa kun listan jäsentä klikataan.
 * @author ilkka
 * @version 1.0 5/12/2019
 */

public class ActivityFood extends AppCompatActivity {
    Button button;

    public static final String EXTRA = "com.example.getfit.MESSAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        ListView lv = findViewById(R.id.ruokaListView);
        lv.setAdapter(new ArrayAdapter<Ruoka>(
                this,
                android.R.layout.simple_list_item_1,
                Ruoat.getInstance().getFood()
        ));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("User", "onItemClick(" + i + ")");
                Intent nextActivity = new Intent(ActivityFood.this, ViewFood.class);
                nextActivity.putExtra(EXTRA, i);
                startActivity(nextActivity);
            }
        });

        button = findViewById(R.id.gym);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityGym();
            }
        });

        button = findViewById(R.id.bmi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityBmi();
            }
        });
    }

    /**
     * open other activity when the button clicked
     * @author Ali
     */

    public void openActivityBmi(){
        Intent intent = new Intent(this, ActivityBmi.class);
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
