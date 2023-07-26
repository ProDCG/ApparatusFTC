package com.apparatuscore.pathing;

public class Vector2D {
    public double x,y;

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public static Vector2D fromHeadingAndMagnitude(double h, double m){
        return new Vector2D(Math.cos(h) * m, Math.sin(h) * m);
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}