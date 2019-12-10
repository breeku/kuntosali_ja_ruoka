package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class ActivityBmi extends AppCompatActivity {
    private Henkilo henkilo;
    private RadioGroup radioGenderGroup;
    private RadioGroup radioActivityGroup;
    private RadioButton radioGender;
    private RadioButton radioActivity;
    private EditText ika;
    private EditText pituus;
    private EditText paino;
    private String genderValue;
    private String activityValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        radioGenderGroup = findViewById(R.id.genderSelect);
        radioActivityGroup = findViewById(R.id.aktiivisuus);
        ika = findViewById(R.id.ika);
        pituus = findViewById(R.id.pituus);
        paino = findViewById(R.id.paino);


    }

    /**
     * Simppeli virheilmoitus metodi. @param mukaan lähettää
     * Toastin käyttäjälle, ilmoittaen virheen.
     *
     * @param error Virheilmoitus tekstinä
     * @Author Matias
     */
    private void toastError (String error) {
        Toast toast = Toast.makeText(getApplicationContext(),
                error,
                Toast.LENGTH_SHORT);

        toast.show();
    }

    /**
     * Luo datan perusteella @Henkilo luokasta henkilön, ja lähettää sen
     * intenttinä @DisplayMessageActivity luokkaan.
     *
     * @Author Matias
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        int selectedGender = radioGenderGroup.getCheckedRadioButtonId();
        int selectedActivity = radioActivityGroup.getCheckedRadioButtonId();

        radioGender = findViewById(selectedGender);
        radioActivity = findViewById(selectedActivity);

        if (radioGender != null) {
            genderValue = radioGender.getText().toString();
        } else {
            toastError("Valitse sukupuoli");
            return;
        }
        if (radioActivity != null) {
            activityValue = radioActivity.getText().toString();
        } else {
            toastError("Valitse aktiivisuustasosi");
            return;
        }

        String ageString = ika.getText().toString();
        String heightString = pituus.getText().toString();
        String weightString = paino.getText().toString();

        int ageValue = ageString.length() > 0 ? Integer.parseInt(ageString) : 0;
        int heightValue = heightString.length() > 0 ? Integer.parseInt(heightString) : 0;
        int weightValue = weightString.length() > 0 ?  Integer.parseInt(weightString) : 0;

        if (ageValue == 0) {
            toastError("Ikä puuttuu");
            return;
        } else if (heightValue == 0) {
            toastError("Pituus puuttuu");
            return;
        } else if (weightValue == 0) {
            toastError("Paino puuttuu");
            return;
        }

        henkilo = new Henkilo(genderValue, activityValue, ageValue, heightValue, weightValue);

        intent.putExtra("HENKILO", henkilo);
        startActivity(intent);
    }

}
