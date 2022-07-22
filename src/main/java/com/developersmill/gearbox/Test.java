package com.developersmill.gearbox;

import com.developersmill.gearbox.acl.CharacteristicsACL;
import com.developersmill.gearbox.acl.GearboxACL;
import com.developersmill.gearbox.acl.RpmProviderACL;
import com.developersmill.gearbox.external.ExternalSystems;
import com.developersmill.gearbox.external.Gearbox;
import com.developersmill.gearbox.vo.Gear;
import com.developersmill.gearbox.vo.GearRange;

public class Test {

    private static GearboxACL gearbox = new GearboxACL(new Gearbox());
    private static RpmProviderACL rpmProvider = new RpmProviderACL(new ExternalSystems());

    private static CharacteristicsACL characteristics = new CharacteristicsACL();

    private static GearCalculator gearCalculator = new GearCalculator(new GearRange(new Gear(1), new Gear(8)), characteristics.getOptionalRange());

    public static void main(String[] args) {
        // if revers, nautral, park, -> do nothing

        gearbox.changeGear(gearCalculator.calculate(rpmProvider.getCurrentRPM(), gearbox.getCurrentGear()));
    }


}
