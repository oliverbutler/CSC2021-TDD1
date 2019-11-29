package com.example.tddCoursework.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.example.tddCoursework.Module;
import com.example.tddCoursework.RecordManager;
import com.example.tddCoursework.Student;

/**
 * JUnit Test to test feature 7 from Task 3
 */
public class Task3Feature7 extends AbstractLoggingJUnitTest {
    private RecordManager rm;
    private Student s1;
    private Module m1;

    @Before
    public void init() {
        rm = new RecordManager();
        s1 = new Student("Oliver Butler", "oliver@oliverbutler.uk", "Some address", "Computer Science",
                LocalDate.of(2018, 9, 20));
        m1 = new Module("CSC2021", "Software Engineering", 10, 80);

    }

    @Test
    public void testAddNewModuleExisting() {
        rm.addStudent(s1);
        rm.studentAddModule(s1.getId(), m1);
        assertTrue(rm.getStudentByID(s1.getId()).getModules().size() == 1);
        assertEquals("CSC2021", rm.getStudentByID(s1.getId()).getModules().get(0).getCode());
    }

    @Test
    public void testAddNewModuleNew() {
        rm.addStudent(s1);
        rm.studentAddModule(s1.getId(), "CSC2000", "Title", 80);
        assertEquals("CSC2000", rm.getStudentByID(s1.getId()).getModules().get(0).getCode());
    }

    @Test
    public void testAddNewModuleNewNoMark() {
        rm.addStudent(s1);
        rm.studentAddModule(s1.getId(), "CSC2000", "Title", 10);
        assertEquals("CSC2000", rm.getStudentByID(s1.getId()).getModules().get(0).getCode());
        assertTrue(rm.getStudentByID(s1.getId()).getModules().get(0).getMark() == 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNewModuleError() {
        rm.addStudent(s1);
        rm.getStudentByID(s1.getId()).addModule("Bad name", "Valid title", 50);
    }

}