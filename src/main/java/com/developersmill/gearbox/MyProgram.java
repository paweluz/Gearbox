package com.developersmill.gearbox;

public class MyProgram {

    private static Object[] characteristics = new Object[]{2000d, 1000d, 1000d, 0.5d, 2500d, 4500d, 1500d, 0.5d, 5000d, 0.7d,
            5000d, 5000d, 1500d, 2000d, 3000d, 6500d, 14d};

    private static Gearbox gearbox = new Gearbox();

    private static RPM minRpm =  new RPM((Long) characteristics[1]);
    private static RPM maxRpm =  new RPM((Long) characteristics[0]);

    private static ExternalSystems externalSystems = new ExternalSystems();

    public static void main(String[] args) {
        // if revers, nautral, park, -> do nothing

        Integer maxDrive = gearbox.getMaxDrive();
        Integer currentGear = (Integer) gearbox.getCurrentGear();
        RPM currentRpm = new RPM((long) externalSystems.getCurrentRpm());
        int calculation = new GearCalculator(maxDrive, minRpm, maxRpm).calc(currentRpm, currentGear);
        gearbox.setCurrentGear(calculation);
    }




}
