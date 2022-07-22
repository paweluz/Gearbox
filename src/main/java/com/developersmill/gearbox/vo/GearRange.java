package com.developersmill.gearbox.vo;

public class GearRange {

    private final Gear first;
    private final Gear max;

    public GearRange(Gear first, Gear max) {
        if (first.greaterThen(max)) {
            throw new IllegalArgumentException("Invalid range, first: " + first.getGear()+" is greater then max: " + max.getGear());
        }
        this.first = first;
        this.max = max;
    }

    public Gear next(Gear gear){
        return trim(gear.next());
    }

    public Gear previous(Gear gear){
        return trim(gear.previous());
    }

    public Gear trim(Gear gear) {
        if (gear.greaterThen(max)) {
            return max;
        }
        if (gear.lessOrEquals(first)) {
            return first;
        }
        return gear;
    }
}
