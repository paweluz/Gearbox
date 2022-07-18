package com.developersmill.gearbox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GearTest {

    @Test
    public void testIllegalArguments() {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Gear(-1);
        });

        Assertions.assertEquals("Gear can not be lover then zero", exception.getMessage());
    }

    @Test
    public void testGear() {
        Assertions.assertEquals(new Gear(3).next(), new Gear(4));
        Assertions.assertEquals(new Gear(3).previous(), new Gear(2));
    }
}
