package com.apparatuscore.pathing;

public class Spline {
    private Polynomial x, y;

    public Spline(Polynomial x, Polynomial y) {
        this.x = x;
        this.y = y;
    }

    public Point calculate(double t) {
        return new Point(x.calculate(t), y.calculate(t));
    }
}
