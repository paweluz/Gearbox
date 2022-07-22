package com.developersmill.gearbox.acl;

import com.developersmill.gearbox.vo.RPM;
import com.developersmill.gearbox.vo.RpmRange;

public class CharacteristicsACL {

    private static final Object[] characteristics = new Object[]{2000d, 1000d, 1000d, 0.5d, 2500d, 4500d, 1500d, 0.5d, 5000d, 0.7d,
            5000d, 5000d, 1500d, 2000d, 3000d, 6500d, 14d};

    private final RPM minRpm = new RPM((Long) characteristics[1]);
    private final RPM maxRpm = new RPM((Long) characteristics[0]);

    public RpmRange getOptionalRange() {
        return new RpmRange(minRpm, maxRpm);
    }

}