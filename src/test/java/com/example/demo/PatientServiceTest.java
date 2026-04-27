package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatientServiceTest {

    @Test
    void testAddition() {
        int result = 2 + 3;
        assertEquals(5, result);
    }

    @Test
    void testPatientName() {
        String name = "John";
        assertNotNull(name);
        assertEquals("John", name);
    }

}
