package com.example.getfit;

import java.io.Serializable;

public class Henkilo implements Serializable {

    private String gender;
    private double activity;
    private int age;
    private int height;
    private int weight;
    private double calorieCount;

    public Henkilo(String gender, String activity, int age, int height, int weight) {
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;

        if (activity.equals("Täysi lepo (1.0x)")) {
            this.activity = 1;
        } else if (activity.equals("Kevyt (1.3x)")) {
            this.activity = 1.3;
        } else if (activity.equals("Tavallinen (1.5x)")) {
            this.activity = 1.5;
        } else if (activity.equals("Kohtalainen (1.9x)")) {
            this.activity = 1.9;
        } else if (activity.equals("Kova (2.2x)")) {
            this.activity = 2.2;
        } else if (activity.equals("Erittäin kova (2.5x)")) {
            this.activity = 2.5;
        }
    }
    /**
     * Palauttaa kalorimäärän Doublena.
     * Kalorimäärä on laskettu seuraavilla kaavoilla,
     * Miehille: (10 * weight + 6.25 * height – 5 * age + 5) * factor
     * Naisille: (10 * weight + 6.25 * height – 5 * age – 161) * factor
     * Arvot otettu sivustolta https://steemit.com/java/@nicetea/java-tutorial-13-creating-a-graphical-calories-calculator.
     *
     * @author Matias
     */
    public double getCalorie() {
        if (gender.equals("Mies")) {
            calorieCount = (10 * weight + 6.25 * height - 5 * age + 5) * activity;
        } else if (gender.equals("Nainen")) {
            calorieCount = (10 * weight + 6.25 * height - 5 * age - 161) * activity;
        }
        return calorieCount;
    }
}
