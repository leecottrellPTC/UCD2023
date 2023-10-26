package com.leecottrell;
import java.util.Objects;

public class Physics {
    double velocity;
    double acceleration;
    double mass;
    double v0, v1;
    double time;

    public Physics() {
    }

    public Physics(double velocity, double acceleration, double mass, double v0, double v1, double time) {
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.mass = mass;
        this.v0 = v0;
        this.v1 = v1;
        this.time = time;
    }

    public double getVelocity() {
        return this.velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getAcceleration() {
        return this.acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getMass() {
        return this.mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getV0() {
        return this.v0;
    }

    public void setV0(double v0) {
        this.v0 = v0;
    }

    public double getV1() {
        return this.v1;
    }

    public void setV1(double v1) {
        this.v1 = v1;
    }

    public double getTime() {
        return this.time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public Physics velocity(double velocity) {
        setVelocity(velocity);
        return this;
    }

    public Physics acceleration(double acceleration) {
        setAcceleration(acceleration);
        return this;
    }

    public Physics mass(double mass) {
        setMass(mass);
        return this;
    }

    public Physics v0(double v0) {
        setV0(v0);
        return this;
    }

    public Physics v1(double v1) {
        setV1(v1);
        return this;
    }

    public Physics time(double time) {
        setTime(time);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Physics)) {
            return false;
        }
        Physics physics = (Physics) o;
        return velocity == physics.velocity && acceleration == physics.acceleration && mass == physics.mass && v0 == physics.v0 && v1 == physics.v1 && time == physics.time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(velocity, acceleration, mass, v0, v1, time);
    }

    @Override
    public String toString() {
        return "{" +
            " velocity='" + getVelocity() + "'" +
            ", acceleration='" + getAcceleration() + "'" +
            ", mass='" + getMass() + "'" +
            ", v0='" + getV0() + "'" +
            ", v1='" + getV1() + "'" +
            ", time='" + getTime() + "'" +
            "}";
    }

    public double avgVelocity(){
        return (v0 + v1)/2;
    }
    
}
