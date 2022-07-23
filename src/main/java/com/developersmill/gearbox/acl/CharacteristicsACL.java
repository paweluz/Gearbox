package com.developersmill.gearbox.acl;

import com.developersmill.gearbox.vo.RPM;
import com.developersmill.gearbox.vo.RpmRange;

public class CharacteristicsACL {

    private static final Object[] characteristics = new Object[]{2000d, 1000d, 1000d, 0.5d, 2500d, 4500d, 1500d, 0.5d, 5000d, 0.7d,
            5000d, 5000d, 1500d, 2000d, 3000d, 6500d, 14d};


    public RpmRange getOptimalEcoRange() {
        return new RpmRange(new RPM((Double) characteristics[2]), new RPM((Double) characteristics[4]));
    }

    public RpmRange getOptimalComfortRange() {
        return new RpmRange(new RPM((Double) characteristics[1]), new RPM((Double) characteristics[4]));
    }

    public RpmRange getOptimalSportRange() {
        return new RpmRange(new RPM((Double) characteristics[14]), new RPM((Double) characteristics[15]));
    }

}