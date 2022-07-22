package com.developersmill.gearbox.acl;

import com.developersmill.gearbox.vo.RPM;
import com.developersmill.gearbox.external.ExternalSystems;

public class RpmProviderACL {

    private final ExternalSystems externalSystems;

    public RpmProviderACL(ExternalSystems externalSystems) {
        this.externalSystems = externalSystems;
    }

    public RPM getCurrentRPM(){
        return RPM.value((long) externalSystems.getCurrentRpm());
    }
}
