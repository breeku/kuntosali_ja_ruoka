package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.ArrowKeyMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Luokka sisältää koodin, jolla saadaan tekstiä uuteen käyttäjä näkymään.
 * @author ilkka
 * @version 1.0 5/12/2019
 */

public class ViewFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food);

        Bundle b = getIntent().getExtras();
        int i = b.getInt(ActivityFood.EXTRA,0);

        ((TextView)findViewById(R.id.ruoka_name))
                .setText(Ruoat.getInstance().getFood(i).toString());
        ((TextView)findViewById(R.id.ruoka_tarvike))
                .setText(Ruoat.getInstance().getFood(i).getTarvikkeet());
        ((TextView)findViewById(R.id.ruoka_ohje))
                .setText(Ruoat.getInstance().getFood(i).getOhjeet());
        ((ImageView)findViewById(R.id.ruoka_kuva))
                .setImageResource(getImage(Ruoat.getInstance().getFood(i).getKuvat()));
        ((TextView) findViewById(R.id.ruoka_tarvike)).setMovementMethod(ArrowKeyMovementMethod.getInstance());
        ((TextView) findViewById(R.id.ruoka_ohje)).setMovementMethod(ArrowKeyMovementMethod.getInstance());

    }
    /**
     * Palauttaa kuvan nimen, joka on Arraylistassa singleton luokassa.
     * @param name  nimi, joka annetaan ImageView:ta varten.
     * @return palauttaa jpg kuvan nimen ImageView:ta varten.
     */
    private int getImage(String name) {
        // Searches image by resource ID from the drawable directory
        int resID = getResources().getIdentifier(name, "drawable", getPackageName());
        return resID;
    }
}
