package com.developersmill.gearbox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class GearCalculatorTest {

    private final GearCalculator gearCalculator = new GearCalculator(8, RPM.value(2000L), RPM.value(4000L));

    @Test
    public void whenRmpIsToBig_shouldShiftUp() {
        //when
        int gear = gearCalculator.calc(RPM.value(5000L), 5);

        //then
        Assertions.assertEquals(gear, 6);
    }

    @Test
    public void whenRmpIsToLow_shouldShiftDown() {
        //when
        int gear = gearCalculator.calc(RPM.value(1000L), 5);

        //then
        Assertions.assertEquals(gear, 4);
    }

    @Test
    public void whenRmpIsToLowButAlreadyOnFirstGear_shouldDoNothing() {
        //when
        int gear = gearCalculator.calc(RPM.value(1000L), 1);

        //then
        Assertions.assertEquals(gear, 1);
    }

    @Test
    public void whenRmpIsToHighButAlreadyOnHighestGear_shouldDoNothing() {
        //when
        int gear = gearCalculator.calc(RPM.value(6000L), 8);

        //then
        Assertions.assertEquals(gear, 8);
    }

    @Test
    public void whenRmpAreFineForCurrentGear_shouldDoNothing() {
        //when
        int gear = gearCalculator.calc(RPM.value(3000L), 6);

        //then
        Assertions.assertEquals(gear, 6);
    }

}
