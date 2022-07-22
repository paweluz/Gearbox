package com.developersmill.gearbox;

public class GearCalculator {
    private final GearRange gearRange;
    private final RpmRange optimalRange;

    public GearCalculator(GearRange gearRange, RpmRange optimalRange) {
        this.gearRange = gearRange;
        this.optimalRange = optimalRange;
    }

    public Gear calculate(RPM currentRpm, Gear currentGear){
        Gear gear = calc(currentRpm, currentGear);
        return gearRange.trim(gear);
    }

    private Gear calc(RPM currentRpm, Gear currentGear) {
        if (currentRpm.isAbove(optimalRange)){
            return currentGear.next();
        }
        if (currentRpm.isBelow(optimalRange)) {
            return currentGear.previous();
        }
        return currentGear;
    }

}
