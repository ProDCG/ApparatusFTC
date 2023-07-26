package com.apparatuscore.pathing;

public class MotionState {
    private double position, velocity, acceleration;

    public MotionState(final double position, final double velocity, final double acceleration) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    public double getPosition() {
        return this.position;
    }

    public double getVelocity() {
        return this.velocity;
    }

    public double getAcceleration() {
        return this.acceleration;
    }
}
