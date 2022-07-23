package com.developersmill.gearbox;

import com.developersmill.gearbox.acl.CharacteristicsACL;
import com.developersmill.gearbox.acl.GearboxACL;
import com.developersmill.gearbox.vo.GearRange;

public class GearCalculators {

    enum DriveMode {
        Eco, Comfort, Sport;
    }

    private DriveMode mode = DriveMode.Comfort;

    private final GearboxACL gearbox;

    private final CharacteristicsACL characteristics;

    public GearCalculators(GearboxACL gearbox, CharacteristicsACL characteristics) {
        this.gearbox = gearbox;
        this.characteristics = characteristics;
    }

    public GearCalculator chooseCalculator() {
        if (mode == DriveMode.Comfort) {
            return new GearCalculator(new GearRange(gearbox.getFirstGear(), gearbox.getMaxGear()), characteristics.getOptimalComfortRange());
        }
        if (mode == DriveMode.Eco) {
            return new GearCalculator(new GearRange(gearbox.getFirstGear(), gearbox.getMaxGear()), characteristics.getOptimalEcoRange());
        }
        if (mode == DriveMode.Sport) {
            return new GearCalculator(new GearRange(gearbox.getFirstGear(), gearbox.getMaxGear()), characteristics.getOptimalSportRange());
        }
        return new GearCalculator(new GearRange(gearbox.getFirstGear(), gearbox.getMaxGear()), characteristics.getOptimalComfortRange());
    }

    public void enableComfort() {
        this.mode = DriveMode.Comfort;
    }

    public void enableEco() {
        this.mode = DriveMode.Eco;
    }

    public void enableSport() {
        this.mode = DriveMode.Sport;
    }
}
