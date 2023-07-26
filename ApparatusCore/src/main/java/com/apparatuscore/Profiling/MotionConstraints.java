package com.apparatuscore.pathing;

class MotionConstraints {
    private double maxAcceleration;
    private double maxVelocity;
    private double maxDeceleration;

    public MotionConstraints(final double maxAcceleration, final double maxVelocity, final double maxDeceleration) {
        this.maxAcceleration = maxAcceleration;
        this.maxVelocity = maxVelocity;
        this.maxDeceleration = maxDeceleration;
    }

    public double getMaxAcceleration() {
        return maxAcceleration;
    }

    public double getMaxVelocity() {
        return maxVelocity;
    }

    public double getMaxDeceleration() {
        return maxDeceleration;
    }
}
