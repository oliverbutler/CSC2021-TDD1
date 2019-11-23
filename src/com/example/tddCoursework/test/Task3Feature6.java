package com.example.tddCoursework.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.example.tddCoursework.RecordManager;
import com.example.tddCoursework.Student;

/**
 * JUnit Test to test feature 6 from Task 3
 */
public class Task3Feature6 extends AbstractLoggingJUnitTest {
    private RecordManager rm;
    private Student s1;

    /**
     * Initialize the RecordManager and an example Student
     */
    @Before
    public void init() {
        rm = new RecordManager();
        s1 = new Student("Oliver Butler", "oliver@oliverbutler.uk", "Some address", "Computer Science",
                LocalDate.of(2018, 9, 20));
    }

    /**
     * Check that the name changes correctly in normal conditions
     */
    @Test
    public void testChangeName() {
        rm.addStudent(s1);
        assertEquals("Oliver Butler", s1.getName());
        rm.setStudentName(s1.getId(), "Jeff");
        assertEquals("Jeff", rm.getStudentByID(s1.getId()).getName());
    }

    /**
     * Check that an error is thrown if the request is invalid, e.g. an empty name
     */
    @Test(expected = IllegalArgumentException.class)
    public void testChangeNameError() {
        rm.addStudent(s1);
        assertEquals("Oliver Butler", s1.getName());
        rm.setStudentName(s1.getId(), "");
    }

    /**
     * Check that the address changes correctly in normal conditions
     */
    @Test
    public void testChangeAddress() {
        rm.addStudent(s1);
        assertEquals("Some address", s1.getPostalAddr());
        rm.setStudentAddress(s1.getId(), "New Address");
        assertEquals("New Address", rm.getStudentByID(s1.getId()).getPostalAddr());
    }

    /**
     * Check that an error is thrown if there is an invalid request
     */
    @Test(expected = IllegalArgumentException.class)
    public void testChangeAddressError() {
        rm.addStudent(s1);
        assertEquals("Some address", s1.getPostalAddr());
        rm.setStudentAddress(s1.getId(), "");
    }
}