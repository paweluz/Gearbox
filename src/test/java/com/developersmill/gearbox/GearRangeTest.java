package com.developersmill.gearbox;

import com.developersmill.gearbox.vo.Gear;
import com.developersmill.gearbox.vo.GearRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GearRangeTest {

    @Test
    public void whenEverythingIsFineDoNothing() {
        Assertions.assertEquals(new Gear(3), new GearRange(new Gear(1), new Gear(7)).trim(new Gear(3)));
    }

    @Test
    public void whenIsAboutToSwitchToHigherGearButAlreadyIsOnMaxShouldReturnMax() {
        Assertions.assertEquals(new Gear(7), new GearRange(new Gear(1), new Gear(7)).trim(new Gear(8)));
    }

    @Test
    public void whenIsAboutToSwitchToBelowFirstGearShouldReturnFirst() {
        Assertions.assertEquals(new Gear(3), new GearRange(new Gear(3), new Gear(7)).trim(new Gear(2)));
    }

    @Test
    public void whenFirstIsBiggerThenTheMaxExceptionIsThrown() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new GearRange(new Gear(8), new Gear(4));
        });

        Assertions.assertEquals("Invalid range, first: 8 is greater then max: 4", exception.getMessage());
    }
}
