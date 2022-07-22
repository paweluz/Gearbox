package com.developersmill.gearbox;

import com.developersmill.gearbox.acl.GearboxACL;
import com.developersmill.gearbox.acl.RpmProviderACL;
import com.developersmill.gearbox.vo.Gear;

public class GearBoxDriver {

    enum DriveState {
        Reverse, Neutral, Park, Drive;
    }

    private final RpmProviderACL rpmProvider;
    private final GearboxACL gearbox;
    private final GearCalculator gearCalculator;
    private DriveState state = DriveState.Park;

    public GearBoxDriver(RpmProviderACL rpmProvider, GearboxACL gearbox, GearCalculator gearCalculator) {
        this.rpmProvider = rpmProvider;
        this.gearbox = gearbox;
        this.gearCalculator = gearCalculator;
    }

    void recalculate() {
        if (state == DriveState.Drive) {
            Gear gear = gearCalculator.calculate(rpmProvider.getCurrentRPM(), gearbox.getCurrentGear());
            gearbox.changeGear(gear);
        }
    }
}
