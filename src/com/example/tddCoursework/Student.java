package com.example.tddCoursework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import com.example.tddCoursework.Module;

/**
 * Represents a Student who goes to University as specified within CSC2021-TDD1
 */
public class Student {
    final private UUID id;
    private String name;
    private String email;
    private String postalAddr;
    private String courseTitle;
    private LocalDate dateEnrolled;
    private ArrayList<Module> modules = new ArrayList<>();

    /**
     * Create a student with the specified parameters
     * 
     * @param name         The name of the Student
     * @param email        The email of the Student
     * @param postalAddr   The postal address of the Student
     * @param courseTitle  The course title the Student does
     * @param dateEnrolled The date the student enrolled on their course
     * 
     * @throws IllegalArgumentException if the parameters suplied are invalid
     */
    public Student(String name, String email, String postalAddr, String courseTitle, LocalDate dateEnrolled) {

        if (name == null | name.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");
        if (email == null | email.isEmpty())
            throw new IllegalArgumentException("Email cannot be null or empty");
        /**
         * Email regex from
         * https://howtodoinjava.com/regex/java-regex-validate-email-address/ Used to
         * ensure that the email is a valid email
         */
        if (!email.matches(
                "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"))
            throw new IllegalArgumentException("Email is not a valid Email");
        if (postalAddr == null | postalAddr.isEmpty())
            throw new IllegalArgumentException("Postal Address cannot be null or empty");
        if (courseTitle == null | courseTitle.isEmpty())
            throw new IllegalArgumentException("Course Title cannot be null or empty");
        if (dateEnrolled == null)
            throw new IllegalArgumentException("Date Enrolled cannot be null");

        LocalDate today = LocalDate.now();

        if (dateEnrolled.isAfter(today))
            throw new IllegalArgumentException("Date Enrolled cannot be in the future");

        this.id = UUID.randomUUID(); // A random UUID for the ID is a sensible decision
        this.name = name;
        this.email = email.toLowerCase(); // Emails should be lower case, ammend upon initialisation
        this.postalAddr = postalAddr;
        this.courseTitle = courseTitle;
        this.dateEnrolled = dateEnrolled;
    }

    /**
     * Overrides the original toString method, prints out all of the students
     * information in a formatted way
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Integer paddingLength = (40 - name.length()) / 2;
        str.append("=".repeat(paddingLength));
        str.append(String.format("[ %s ]", name));
        str.append("=".repeat(paddingLength));
        str.append(String.format("\nID %s\nEmail: %s\nAddress: %s\nCourse Title: %s\nDate Enrolled: %s\n", id, email,
                postalAddr, courseTitle, dateEnrolled));
        str.append("Modules: \n");
        for (Module m : modules) {
            str.append("  " + m + "\n");
        }
        str.append("\n");
        return str.toString();
    }

    /**
     * Gets the average mark for a student based upon all of their registered
     * modules within 'modules' which is an ArrayList<Module> which holds the
     * students modules
     * 
     * @return average mark for a students modules
     * 
     * @throws IllegalArguementException if the student has no modules
     */
    public Double getAverageMark() {
        if (modules.size() == 0)
            throw new IllegalArgumentException("No modules registered");
        Double total = 0.0;
        for (Module m : modules)
            total += m.getMark();
        return total /= modules.size();
    }

    /**
     * Returns the ID of a valid student
     * 
     * @return ID of the Student
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Returns the name of a student
     * 
     * @return name of the student
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of a student
     * 
     * @param name new name for the student
     * 
     * @throws IllegalArgumentException if the name is null or empty
     */
    public void setName(String name) {
        if (name == null | name.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
    }

    /**
     * Getter for student email
     * 
     * @return student email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Getter for the postal address for the student
     * 
     * @return the postal address of the student
     */
    public String getPostalAddr() {
        return this.postalAddr;
    }

    /**
     * Setter for the postal address of a student which is stored as a string
     * 
     * @param postalAddr the new postal address for the student
     */
    public void setPostalAddr(String postalAddr) {
        if (postalAddr == null | postalAddr.isEmpty())
            throw new IllegalArgumentException("Postal Address cannot be null or empty");
        this.postalAddr = postalAddr;
    }

    /**
     * Getter for the course title of a student
     * 
     * @return course title
     */
    public String getCourseTitle() {
        return this.courseTitle;
    }

    /**
     * Getter for the date a student was enrolled at University
     * 
     * @return the date enrolled for the student
     */
    public LocalDate getDateEnrolled() {
        return this.dateEnrolled;
    }

    /**
     * getter for the modules a student takes
     * 
     * @return the modules a student takes as an ArrayList<Module>
     */
    public ArrayList<Module> getModules() {
        return this.modules;
    }

    /**
     * Add a new (pre-existing) module to a students list of modules
     * 
     * @param module the new module to add to the list of modules a student takes
     * 
     * @throws IllegalArgumentException if the module is null
     */
    public void addModule(Module module) {
        checkAddModule(module);
    }

    /**
     * Add a new module to the students list of modules
     * 
     * @param code  Module code for the module
     * @param title Module title
     * @param mark  Mark for the module between 1-100
     * 
     * @throws IllegalArgumentException if the parameters suplied are invalid
     * 
     * @see Module
     */
    public void addModule(String code, String title, Integer mark) {
        Module m = new Module(code, title, mark);
        checkAddModule(m);
    }

    /**
     * Adds a new module (Without a mark) to the students list of modules
     * 
     * @param code  Module code for the module
     * @param title Module title
     * 
     * @throws IllegalArgumentException if the parameters suplied are invalid
     * 
     * @see Module
     */
    public void addModule(String code, String title) {
        Module m = new Module(code, title);
        checkAddModule(m);
    }

    /**
     * Internal add module to check for duplicates
     * 
     * @param module new Module to add
     */
    private void checkAddModule(Module module) {
        if (module == null)
            throw new IllegalArgumentException("Module cannot be null");
        for (Module m : this.modules)
            if (m.getCode().equals(module.getCode()))
                throw new IllegalArgumentException("Duplicate Modules disallowed");
        this.modules.add(module);
    }

}