package com.developersmill.gearbox;

public class Gear implements Comparable<Integer> {

    private final Integer value;

    public Gear(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Gear can not be lover then zero");
        }
        this.value = value;
    }

    public Gear next() {
        return new Gear(value + 1);
    }

    public Gear previous() {
        return new Gear(value - 1);
    }

    public int getGear() {
        return value;
    }

    @Override
    public int compareTo(Integer o) {
        return value.compareTo(o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gear gear = (Gear) o;

        return value != null ? value.equals(gear.value) : gear.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
