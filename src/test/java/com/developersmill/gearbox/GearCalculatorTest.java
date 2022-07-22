package com.developersmill.gearbox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class GearCalculatorTest {

    private final GearCalculator gearCalculator = new GearCalculator(new GearRange(new Gear(1), new Gear(8))
            , new RpmRange(new RPM(2000L), new RPM(4000L)));

    @Test
    public void whenRmpIsToBig_shouldShiftUp() {
        //when
        int gear = gearCalculator.calculate(RPM.value(5000L), new Gear(5)).getGear();

        //then
        Assertions.assertEquals(gear, 6);
    }

    @Test
    public void whenRmpIsToLow_shouldShiftDown() {
        //when
        int gear = gearCalculator.calculate(RPM.value(1000L), new Gear(5)).getGear();

        //then
        Assertions.assertEquals(gear, 4);
    }

    @Test
    public void whenRmpIsToLowButAlreadyOnFirstGear_shouldDoNothing() {
        //when
        int gear = gearCalculator.calculate(RPM.value(1000L), new Gear(1)).getGear();

        //then
        Assertions.assertEquals(gear, 1);
    }

    @Test
    public void whenRmpIsToHighButAlreadyOnHighestGear_shouldDoNothing() {
        //when
        int gear = gearCalculator.calculate(RPM.value(6000L), new Gear(8)).getGear();

        //then
        Assertions.assertEquals(gear, 8);
    }

    @Test
    public void whenRmpAreFineForCurrentGear_shouldDoNothing() {
        //when
        int gear = gearCalculator.calculate(RPM.value(3000L), new Gear(6)).getGear();

        //then
        Assertions.assertEquals(gear, 6);
    }

}
