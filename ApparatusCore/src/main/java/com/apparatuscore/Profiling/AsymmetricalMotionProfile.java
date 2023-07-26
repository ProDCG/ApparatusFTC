package com.apparatuscore.pathing;

class MotionProfile {

    MotionState initialState;
    MotionState finalState;

    MotionConstraints constraints;

    double duration;

    public MotionProfile(MotionState initialState, MotionState finalState, MotionConstraints constraints) {
        this.initialState = initialState;
        this.finalState = finalState;
        this.constraints = constraints;

        double deltaPosition = finalState.getPosition() - initialState.getPosition();
        double maxAccel = constraints.getMaxAcceleration();
        double maxDecel = constraints.getMaxDeceleration();
        double maxVel = constraints.getMaxVelocity();

        double t1 = (maxVel - initialState.getVelocity()) / maxAccel;
        double t2 = (finalState.getVelocity() - maxVel) / maxDecel;
        double t3 = (deltaPosition - (initialState.getVelocity() + maxVel) * t1 / 2 - (maxVel + finalState.getVelocity()) * t2 / 2) / maxVel;

        duration = t1 + t2 + t3;
    }

    public MotionState getMotionState(double time) {

        time = Math.max(0, Math.min(time, duration));

        double position;
        double velocity;
        double acceleration;

        double deltaPosition = finalState.getPosition() - initialState.getPosition();
        double maxAccel = constraints.getMaxAcceleration();
        double maxDecel = constraints.getMaxDeceleration();
        double maxVel = constraints.getMaxVelocity();

        double t1 = (maxVel - initialState.getVelocity()) / maxAccel;
        double t2 = (finalState.getVelocity() - maxVel) / maxDecel;
        double t3 = (deltaPosition - (initialState.getVelocity() + maxVel) * t1 / 2 - (maxVel + finalState.getVelocity()) * t2 / 2) / maxVel;

        if (time < t1) {
        position = initialState.getPosition() + (initialState.getVelocity() + maxAccel * time / 2) * time;
        velocity = initialState.getVelocity() + maxAccel * time;
        acceleration = maxAccel;
        }
        else if (time < t1 + t3) {
        position = initialState.getPosition() + (initialState.getVelocity() + maxVel) * t1 / 2 + maxVel * (time - t1);
        velocity = maxVel;
        acceleration = 0;
        }
        else {
        position = finalState.getPosition() - (finalState.getVelocity() + maxDecel * (duration - time) / 2) * (duration - time);
        velocity = finalState.getVelocity() + maxDecel * (duration - time);
        acceleration = -maxDecel;
        }

        return new MotionState(position, velocity, acceleration);
    }
}