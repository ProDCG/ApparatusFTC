package Core.Profiling;

class MotionConstraints {
    double maxAcceleration;
    double maxVelocity;
    double maxDeceleration;

    // Constructor
    public MotionConstraints(final double maxAcceleration, final double maxVelocity, final double maxDeceleration) {
        this.maxAcceleration = maxAcceleration;
        this.maxVelocity = maxVelocity;
        this.maxDeceleration = maxDeceleration;
    }

    // Getter methods
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
