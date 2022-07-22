package com.developersmill.gearbox.acl;

import com.developersmill.gearbox.vo.Gear;
import com.developersmill.gearbox.external.Gearbox;

public class GearboxACL {

    private final Gearbox gearbox;

    public GearboxACL(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public Gear getCurrentGear() {
        return new Gear((Integer) gearbox.getCurrentGear());
    }

    public void changeGear(Gear gear){
        gearbox.setCurrentGear(gear.getGear());
    }


}
