package com.developersmill.gearbox;

public class GearCalculator {
    private final Integer maxDrive;
    private final RPM minRpm;
    private final RPM maxRpm;

    public GearCalculator(int maxDrive, RPM minRpm, RPM maxRpm) {
        this.maxDrive = maxDrive;
        this.minRpm = minRpm;
        this.maxRpm = maxRpm;
    }

    public int calc(RPM currentRpm, Integer currentGear) {
        if (currentRpm.greaterThen(maxRpm)) {
            if (currentGear.equals(maxDrive)) {
                return currentGear;
            }
            return currentGear + 1;
        }

        if (currentRpm.lowerThen(minRpm)) {
            if (currentGear == 1) {
                return currentGear;
            }
            return currentGear - 1;
        }
        return currentGear;
    }

}
