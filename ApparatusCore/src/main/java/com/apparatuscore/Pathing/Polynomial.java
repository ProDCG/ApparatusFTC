package com.apparatuscore.pathing;

import java.util.ArrayList;

import org.ejml.simple.SimpleMatrix;

public class Polynomial {
    private ArrayList<Double> coeffs = new ArrayList<>();

    public Polynomial(SimpleMatrix coeffs) {
        for (int i = 0; i < 4; i++) {
            this.coeffs.add(coeffs.get(i));
        }
    }

    public Polynomial(double... coeffs) {
        for (double coeff : coeffs) {
            this.coeffs.add(coeff);
            System.out.println(coeff);
        }
    }

    public double calculate(double x) {
        double result = 0.0;
        double power = 1.0;
    
        for (double c : coeffs) {
            result += c * power;
            power *= x;
        }

        return result;
    }

    @Override
    public String toString() {
        return String.format("%s", coeffs.toString());
    }
}
