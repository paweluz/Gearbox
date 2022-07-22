package com.developersmill.gearbox.vo;

import java.util.Objects;

public class RpmRange {

    private final RPM left;
    private final RPM right;

    public RpmRange(RPM left, RPM right) {
        this.left = left;
        this.right = right;
    }

    public boolean startGreaterThan(RPM rpm) {
        return left.compareTo(rpm) > 0;
    }

    public boolean endLowerThan(RPM rpm) {
        return right.compareTo(rpm) < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RpmRange rpmRange = (RpmRange) o;

        if (!Objects.equals(left, rpmRange.left)) return false;
        return Objects.equals(right, rpmRange.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
