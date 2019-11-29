package com.example.tddCoursework.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import com.example.tddCoursework.Module;
import com.example.tddCoursework.Student;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit Test to test features 1-5 added in Task2 TDD not used within this class
 */
public class Task2TestStudent {
    private Student s1;
    private Student s2;

    @Before
    public void init() {
        s1 = new Student("Oliver Butler", "oliver@oliverbutler.uk", "Some address", "Computer Science",
                LocalDate.of(2018, 9, 20));
        s2 = new Student("Jeff Wilson", "jeff@gmail.com", "Jeff address", "Computer Science",
                LocalDate.of(2018, 9, 21));
    }

    @Test
    public void testCreateStudent() {
        assertTrue("Student not created properly", s1 instanceof Student);
        assertTrue("Name not correct", s1.getName().equals("Oliver Butler"));
        assertTrue("Email not correct", s1.getEmail().equals("oliver@oliverbutler.uk"));
        assertTrue("Address not correct", s1.getPostalAddr().equals("Some address"));
        assertTrue("Course Title not correct", s1.getCourseTitle().equals("Computer Science"));
        assertTrue("Date not correct", s1.getDateEnrolled().equals(LocalDate.of(2018, 9, 20)));
    }

    @Test
    public void testStudentIDUnique() {
        assertNotEquals("IDs are not Unique", s1.getId(), s2.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddStudentNull() {
        new Student("Invalid name", "oliver@oliverbutler.uk", "Some address", "Computer Science", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddStudentEmptyName() {
        new Student("", "oliver@oliverbutler.uk", "Some address", "Computer Science", LocalDate.of(2018, 9, 20));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddStudentEmptyEmail() {
        new Student("Valid", "", "Some address", "Computer Science", LocalDate.of(2018, 9, 20));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddStudentEmptyAddress() {
        new Student("Valid", "oliver@oliverbutler.uk", "", "Computer Science", LocalDate.of(2018, 9, 20));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddStudentEmptyTitle() {
        new Student("Valid", "oliver@oliverbutler.uk", "Some address", "", LocalDate.of(2018, 9, 20));
    }

    /**
     * Check the date is not in the future as that would make no sense
     * 
     * @see Student
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddStudentDateInFuture() {
        new Student("", "oliver@oliverbutler.uk", "Some address", "Computer Science", LocalDate.now().plusYears(1));
    }

    /**
     * Regex test for custom email validation
     * 
     * @see Student
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddStudentEmailInvalid() {
        new Student("Valid Name", "Not an email", "Some address", "computer science", LocalDate.of(2017, 1, 1));
    }

    @Test
    public void testStudentAddModule() {
        Module m = new Module("CSC2022", "Test", 10, 50);
        s1.addModule(m);
        assertEquals("CSC2022", s1.getModules().get(0).getCode());
    }

    @Test
    public void testStudentAddModuleNew() {
        s1.addModule("CSC2021", "Software Engineering", 100);
        assertEquals("CSC2021", s1.getModules().get(0).getCode());
    }

    @Test
    public void testStudentAddModuleNewNoMark() {
        s1.addModule("CSC2021", "Software Engineering", 10);
        assertEquals("CSC2021", s1.getModules().get(0).getCode());
        assertTrue(s1.getModules().get(0).getMark() == 1);
    }

    @Test
    public void testStudentGetModules() {
        s1.addModule("CSC2021", "Software Engineering", 10);
        s1.addModule("CSC2022", "Software Engineering Team Project", 10);
        s1.addModule("CSC2023", "Algoirthms Design & Analysis", 10);
        assertTrue(s1.getModules().size() == 3);
        assertEquals("CSC2022", s1.getModules().get(1).getCode());
    }
}