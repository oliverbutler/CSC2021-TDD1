package com.example.tddCoursework.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.example.tddCoursework.Module;
import com.example.tddCoursework.RecordManager;
import com.example.tddCoursework.Student;

/**
 * JUnit Test to test feature 7 from Task 3
 */
public class Task3ExtraTest {
    private RecordManager rm;
    private Student s1;
    private Module m1;
    private Module m2;
    private Module m3;

    @Before
    public void init() {
        rm = new RecordManager();
        s1 = new Student("Oliver Butler", "oliver@oliverbutler.uk", "Some address", "Computer Science",
                LocalDate.of(2018, 9, 20));
        m1 = new Module("CSC2021", "Software Engineering", 80);
        m2 = new Module("CSC2022", "Team Project", 75);
        m3 = new Module("CSC2023", "Algorithms", 90);

    }

    @Test
    public void testAddMultipleModules() {
        rm.addStudent(s1);
        rm.studentAddModule(s1.getId(), m1);
        rm.studentAddModule(s1.getId(), m2);
        rm.studentAddModule(s1.getId(), m3);
        ArrayList<Module> m = rm.getStudentByID(s1.getId()).getModules();
        assertTrue(m.size() == 3);
        assertEquals("CSC2021", m.get(0).getCode());
        assertEquals("CSC2022", m.get(1).getCode());
        assertEquals("CSC2023", m.get(2).getCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMultipleError() {
        rm.addStudent(s1);
        rm.studentAddModule(s1.getId(), m1);
        rm.studentAddModule(s1.getId(), "BAD NAME", "Course Title");
        rm.studentAddModule(s1.getId(), m3);
        ArrayList<Module> m = rm.getStudentByID(s1.getId()).getModules();
        assertTrue(m.size() == 2);
        assertEquals("CSC2021", m.get(0).getCode());
        assertEquals("CSC2023", m.get(1).getCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMultipleDuplicates() {
        rm.addStudent(s1);
        rm.studentAddModule(s1.getId(), m1);
        rm.studentAddModule(s1.getId(), m1);
        ArrayList<Module> m = rm.getStudentByID(s1.getId()).getModules();
        assertTrue(m.size() == 1);
        assertEquals("CSC2021", m.get(0).getCode());
    }
}