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
public class Task3Feature8 {
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
    public void testStudentGetAverageOne() {
        s1.addModule(m1);
        rm.addStudent(s1);
        assertTrue(rm.getStudentAverageMark(s1.getId()) == 80);
    }

    @Test
    public void testStudentGetAverageTwo() {
        s1.addModule(m1);
        s1.addModule(m2);
        rm.addStudent(s1);
        assertTrue(rm.getStudentAverageMark(s1.getId()) == 77.5);
    }

    @Test
    public void testStudentGetAverageThree() {
        s1.addModule(m1);
        s1.addModule(m2);
        s1.addModule(m3);
        rm.addStudent(s1);
        assertTrue(rm.getStudentAverageMark(s1.getId()) - 81.6666 < 0.005);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStudentGetAverageError() {
        rm.addStudent(s1);
        rm.getStudentAverageMark(s1.getId());
    }

}