package com.developersmill.gearbox.vo;

import java.util.Objects;

public class RPM implements Comparable<RPM> {
    private final Double rpm;

    public RPM(Double rpm) {
        if (rpm < 0) {
            throw new IllegalArgumentException("RPM must be positive number");
        }
        this.rpm = rpm;
    }

    public static RPM value(Double value) {
        return new RPM(value);
    }

    public boolean isAbove(RpmRange rpmRange) {
        return rpmRange.endLowerThan(this);
    }

    public boolean isBelow(RpmRange rpmRange) {
        return rpmRange.startGreaterThan(this);
    }

    @Override
    public int compareTo(RPM other) {
        return rpm.compareTo(other.rpm);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RPM rpm1 = (RPM) o;

        return Objects.equals(rpm, rpm1.rpm);
    }

    @Override
    public int hashCode() {
        return rpm != null ? rpm.hashCode() : 0;
    }
}
