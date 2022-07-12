package com.developersmill.gearbox;

public class MyProgram {

    private static Object[] characteristics = new Object[]{2000d, 1000d, 1000d, 0.5d, 2500d, 4500d, 1500d, 0.5d, 5000d, 0.7d,
            5000d, 5000d, 1500d, 2000d, 3000d, 6500d, 14d};

    private static Gearbox gearbox = new Gearbox();

    private static ExternalSystems externalSystems = new ExternalSystems();

    public static void main(String[] args) {
        // if revers, nautral, park, -> do nothing

        if (externalSystems.getCurrentRpm() > (double) characteristics[0]) {
            if (gearbox.getCurrentGear().equals(gearbox.getMaxDrive())) {
                gearbox.setCurrentGear((int) gearbox.getCurrentGear() + 1);
            }
        }

        if (externalSystems.getCurrentRpm() < (double) characteristics[1]) {
            if ((int) gearbox.getCurrentGear() == 1) {
                return;
            }
            gearbox.setCurrentGear((int) gearbox.getCurrentGear() - 1);
        }


    }


}
