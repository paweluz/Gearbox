package com.developersmill.gearbox;

import com.developersmill.gearbox.acl.GearboxACL;
import com.developersmill.gearbox.acl.RpmProviderACL;
import com.developersmill.gearbox.vo.Gear;

public class GearboxDriver {

    enum DriveState {
        Reverse, Neutral, Park, Drive;
    }

    private final RpmProviderACL rpmProvider;
    private final GearboxACL gearbox;

    private final GearCalculators gearCalculators;

    private DriveState state = DriveState.Park;


    public GearboxDriver(RpmProviderACL rpmProvider, GearboxACL gearbox, GearCalculators gearCalculators) {
        this.rpmProvider = rpmProvider;
        this.gearbox = gearbox;
        this.gearCalculators = gearCalculators;
    }

    void recalculate() {
        if (state == DriveState.Drive) {
            GearCalculator gearCalculator = gearCalculators.chooseCalculator();
            final Gear gear = gearCalculator.calculate(rpmProvider.getCurrentRPM(), gearbox.getCurrentGear());
            gearbox.changeGear(gear);
        }
    }

    public void enableDrive() {
        this.state = DriveState.Drive;
    }

    public void enableNeutral() {
        this.state = DriveState.Neutral;
    }

    public void enablePark() {
        this.state = DriveState.Park;
    }

    public void enableReverse() {
        this.state = DriveState.Reverse;
    }


}
