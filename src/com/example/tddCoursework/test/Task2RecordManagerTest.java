package com.example.tddCoursework.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import com.example.tddCoursework.Module;
import com.example.tddCoursework.RecordManager;
import com.example.tddCoursework.Student;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit Test to test features 1-5 added in Task2 TDD not used within this class
 */
public class Task2RecordManagerTest {
    private RecordManager rm;
    private Student s1;
    private Student s2;

    @Before
    public void init() {
        rm = new RecordManager();
        s1 = new Student("Oliver Butler", "oliver@oliverbutler.uk", "Some address", "Computer Science",
                LocalDate.of(2018, 9, 20));
        s2 = new Student("Jeff Wilson", "jeff@gmail.com", "Jeff address", "Computer Science",
                LocalDate.of(2018, 9, 21));
    }

    @Test
    public void testCreateRecordManager() {
        assertTrue("Record Manager not created properly", rm instanceof RecordManager);
    }

    @Test
    public void testAddStudentExisting() {
        rm.addStudent(s1);
        assertEquals("Student not added correctly", s1, rm.getStudents().get(0));
    }

    @Test
    public void testAddStudentMultiple() {
        rm.addStudent(s1);
        rm.addStudent(s2);
        rm.addStudent("name", "email@gmail.com", "postalAddr", "courseTitle", LocalDate.of(2017, 1, 1));
        assertTrue(rm.getStudents().size() == 3);
        assertEquals("Oliver Butler", rm.getStudents().get(0).getName());
        assertEquals("name", rm.getStudents().get(2).getName());
    }

    @Test
    public void testAddStudentNew() {
        rm.addStudent("Test Name", "test@gmail.com", "postalAddr", "courseTitle", LocalDate.of(2017, 1, 1));
        assertEquals("Student not added correctly", "Test Name", rm.getStudents().get(0).getName());
    }

    @Test
    public void testRecordManagerSearch() {
        rm.addStudent(s1);
        assertEquals(rm.getStudents().get(0).getId(), s1.getId()); // ensure the same Student
        assertEquals("Search didnt work", s1.getId(), rm.getStudentsByName(s1.getName()).get(0).getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRecordManagerSearchError() {
        rm.addStudent(s1);
        rm.getStudentsByName("Jeff");
    }

    @Test
    public void testRecordManagerGetStudentByID() {
        rm.addStudent(s1);
        assertEquals(rm.getStudents().get(0).getId(), s1.getId()); // ensure the same Student
        assertEquals("Search didnt work", s1.getName(), rm.getStudentByID(s1.getId()).getName());
    }
}