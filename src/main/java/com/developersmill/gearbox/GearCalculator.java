package com.developersmill.gearbox;

public class GearCalculator {
    private final GearRange gearRange;
    private final RpmRange optimalRange;

    public GearCalculator(GearRange gearRange, RpmRange optimalRange) {
        this.gearRange = gearRange;
        this.optimalRange = optimalRange;
    }

    public Gear calculate(RPM currentRpm, Gear currentGear) {
        if (currentRpm.isAbove(optimalRange)){
            return gearRange.next(currentGear);
        }
        if (currentRpm.isBelow(optimalRange)) {
            return gearRange.previous(currentGear);
        }
        return currentGear;
    }

}
