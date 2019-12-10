package com.example.getfit;

import androidx.annotation.NonNull;

/**
 * Luokka antaa pohjan tietojen hakemiselle ArrayList:tä.
 * @author ilkka
 * @version 1.0 5/12/2019
 */
public class Ruoka {
    private String name;
    private String tarvikkeet;
    private String ohjeet;
    private String kuvat;

    /**
     *
     * @param name ruokalajin nimi, joka lukee mainActivityn listassa.
     * @param tarvikkeet ruokalajin sisältämät raaka-aineet.
     * @param ohjeet ruuanlaitto ohjeet tietylle ruoka-annokselle.
     * @param kuvat kuva tiedoston nimi, joka näytetään ImageView:ssä.
     */
    public Ruoka(String name, String tarvikkeet, String ohjeet, String kuvat) {
        this.name = name;
        this.tarvikkeet = tarvikkeet;
        this.ohjeet = ohjeet;
        this.kuvat = kuvat;
    }
    public String getName() {
        return name;
    }
    public String getTarvikkeet() {
        return tarvikkeet;
    }

    public String getOhjeet()  {
        return ohjeet;
    }
    public String getKuvat() {
        return kuvat;
    }
    @NonNull
    @Override
    public String toString() {
        return name;
    }
}

