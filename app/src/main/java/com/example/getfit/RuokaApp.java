package com.example.getfit;

import android.app.Application;
import android.content.Context;

/**
 * Luokan ainut tehtävä on luoda konteksti, jota käytetään kuvan piirtämisessä.
 * @author ilkka
 * @version 1.0 5/12/2019
 */
public class RuokaApp extends Application {

    private static RuokaApp instance;

    public RuokaApp() {
        instance = this;
    }

    /**
     * Palauttaa instancen jolla on konteksti.
     * @return
     */
    public static Context getContext() {
        return instance;
    }
}
