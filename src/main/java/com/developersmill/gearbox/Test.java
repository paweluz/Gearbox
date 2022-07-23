package com.developersmill.gearbox;

import com.developersmill.gearbox.acl.CharacteristicsACL;
import com.developersmill.gearbox.acl.GearboxACL;
import com.developersmill.gearbox.acl.RpmProviderACL;
import com.developersmill.gearbox.external.ExternalSystems;
import com.developersmill.gearbox.external.Gearbox;

public class Test {

    private static GearboxACL gearbox = new GearboxACL(new Gearbox());
    private static RpmProviderACL rpmProvider = new RpmProviderACL(new ExternalSystems());

    private static CharacteristicsACL characteristics = new CharacteristicsACL();

    private static GearCalculators gearCalculators = new GearCalculators(gearbox, characteristics);

    public static void main(String[] args) {
        final GearboxDriver gearboxDriver = new GearboxDriver(rpmProvider, gearbox, gearCalculators);
        gearboxDriver.recalculate();
    }


}
