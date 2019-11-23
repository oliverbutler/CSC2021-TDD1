package com.example.tddCoursework.test;

import static org.junit.Assert.*;

import com.example.tddCoursework.Module;

import org.junit.Test;

/**
 * JUnit Test to test Module.java
 */
public class Task2ModuleTest {

    @Test
    public void testAddModule() {
        Module m = new Module("CSC2021", "Software Engineering", 99);
        assertEquals("CSC2021", m.getCode());
        assertEquals("Software Engineering", m.getTitle());
        assertTrue(m.getMark() == 99);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddModulErrorCode() {
        new Module("jeff", "Software Engineering", 99);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddModuleErrorMarkHigh() {
        new Module("CSC2022", "Software", 101);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddModuleErrorMarkLow() {
        new Module("CSC2022", "Software", 0);
    }

    @Test
    public void testAddModuleWithoutMark() {
        Module m = new Module("CSC2022", "Test");
        assertEquals("CSC2022", m.getCode());
        assertTrue(m.getMark() == 1);
    }

}