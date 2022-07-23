package com.developersmill.gearbox.acl;

import com.developersmill.gearbox.external.Gearbox;
import com.developersmill.gearbox.vo.Gear;

public class GearboxACL {

    private final Gearbox gearbox;

    public GearboxACL(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public Gear getCurrentGear() {
        return new Gear((Integer) gearbox.getCurrentGear());
    }

    public void changeGear(Gear gear) {
        gearbox.setCurrentGear(gear.getGear());
    }

    public Gear getMaxGear() {
        return new Gear(gearbox.getMaxDrive());
    }

    public Gear getFirstGear() {
        return new Gear(1);
    }


}
