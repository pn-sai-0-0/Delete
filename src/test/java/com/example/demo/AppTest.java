package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testAddition() {
        assertEquals(4, 2 + 2);
    }

    @Test
    void testString() {
        String name = "Hospital";
        assertEquals("Hospital", name);
    }
}
