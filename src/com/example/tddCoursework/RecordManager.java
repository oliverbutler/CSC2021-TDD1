package com.example.tddCoursework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import com.example.tddCoursework.Student;
import com.example.tddCoursework.Module;

/**
 * Represents the Record Manager at a University which holds information about
 * students
 */
public class RecordManager {
    private ArrayList<Student> students;

    /**
     * Creates a new RecordManager with no Students
     */
    public RecordManager() {
        this.students = new ArrayList<>();
    }

    /**
     * Override the default toString() method to print a list of the students
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Student s : students) {
            str.append(s);
        }
        return str.toString();
    }

    /**
     * Search the RecordManager for (completely matching) Student names and returns
     * an ArrayList<Student> of matching students
     * 
     * @param search the students name to match
     * @return the ArrayList<Student> of matching students
     * 
     * @throws IllegalArgumentException if no match is found
     */
    public ArrayList<Student> getStudentsByName(String search) {
        ArrayList<Student> searchResult = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(search))
                searchResult.add(s);
        }
        if (searchResult.size() == 0)
            throw new IllegalArgumentException("No Student(s) with that name found");
        return searchResult;
    }

    /**
     * Searches the RecordManager for a student with a matching ID, as IDs are
     * unique only one Student will be returned, otherwise an error will be thrown
     * 
     * @param id The ID of the Student to search for
     * @return the matching Student
     * 
     * @throws IllegalArgumentException if no match is found
     */
    public Student getStudentByID(UUID id) {
        for (Student s : students)
            if (s.getId() == id)
                return s;
        throw new IllegalArgumentException("No Student with that ID found");
    }

    /**
     * Set the name of a Student within the record manager by their ID
     * 
     * @param id   the ID of the student
     * @param name the new name of the student
     * 
     * @throws IllegalArgumentException if the user is not found by that ID or the
     *                                  supplied parameters are invalid
     */
    public void setStudentName(UUID id, String name) {
        getStudentByID(id).setName(name);
    }

    /**
     * Set the address of a Student within the RecordManager with a specified ID
     * 
     * @param id      the ID of the Student
     * @param address the new postal address of the Student
     * 
     * @throws IllegalArgumentException if the user is not found by that ID or the
     *                                  supplied parameters are invalid
     */
    public void setStudentAddress(UUID id, String address) {
        getStudentByID(id).setPostalAddr(address);
    }

    /**
     * Add an existing module to the student
     * 
     * @param id     the ID of the student
     * @param module An existing Module
     * 
     * @throws IllegalArgumentException if the parameters suplied are invalid
     * 
     * @see Student
     */
    public void studentAddModule(UUID id, Module module) {
        getStudentByID(id).addModule(module);
    }

    /**
     * Add a new module to the student
     * 
     * @param id      the ID of the student
     * @param code    the Module code for the Module
     * @param title   the Module title
     * @param credits Credits for the module
     * @param mark    the mark of the Module
     * 
     * @throws IllegalArgumentException if the parameters suplied are invalid
     * 
     * @see Student
     */
    public void studentAddModule(UUID id, String code, String title, Integer credits, Integer mark) {
        getStudentByID(id).addModule(code, title, credits, mark);
    }

    /**
     * Add a new module (without a mark) to the student
     * 
     * @param id      the ID of the student
     * @param code    the Module code for the Module
     * @param title   the Module title
     * @param credits Credits for the module
     * 
     * @throws IllegalArgumentException if the parameters suplied are invalid
     * 
     * @see Student
     */
    public void studentAddModule(UUID id, String code, String title, Integer credits) {
        getStudentByID(id).addModule(code, title, credits);
    }

    /**
     * Return the average mark of a students modules from the RecordManager
     * 
     * @param id the ID of the Student
     * @return the average mark of the student specified modules (between 1-100)
     * 
     * @see Student
     */
    public Double getStudentAverageMark(UUID id) {
        return getStudentByID(id).getAverageMark();
    }

    /**
     * Get a full ArrayList<Student> of the students within the RecordManager
     * 
     * @return the students in the RecordManager
     */
    public ArrayList<Student> getStudents() {
        return this.students;
    }

    /**
     * Add an existing Student to the RecordManager
     * 
     * @param student the existing Student
     */
    public void addStudent(Student student) {
        if (student == null)
            throw new IllegalArgumentException("Student cannot be null");
        this.students.add(student);
    }

    /**
     * Add a new Student to the RecordManager
     * 
     * @param name         The name of the Student
     * @param email        The email of the Student
     * @param postalAddr   The postal address of the Student
     * @param courseTitle  The course title the Student does
     * @param dateEnrolled The date the student enrolled on their course
     * 
     * @throws IllegalArgumentException if the parameters suplied are invalid
     * 
     * @see Student
     */
    public void addStudent(String name, String email, String postalAddr, String courseTitle, LocalDate dateEnrolled) {
        try {
            Student s = new Student(name, email, postalAddr, courseTitle, dateEnrolled);
            this.students.add(s);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

}