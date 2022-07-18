package com.developersmill.gearbox;

public class GearCalculator {
    private final Integer maxDrive;
    private final RpmRange optimalRange;

    public GearCalculator(int maxDrive, RpmRange optimalRange) {
        this.maxDrive = maxDrive;
        this.optimalRange = optimalRange;
    }

    public Gear calc(RPM currentRpm, Gear currentGear) {
        if (currentRpm.isAbove(optimalRange)){
            if (currentGear.equals(new Gear(maxDrive))) {
                return currentGear;
            }
            return currentGear.next();
        }

        if (currentRpm.isBelow(optimalRange)) {
            if (currentGear.equals(new Gear(1))) {
                return currentGear;
            }
            return currentGear.previous();
        }
        return currentGear;
    }

}
