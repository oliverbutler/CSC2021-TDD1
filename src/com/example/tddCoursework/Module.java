package com.example.tddCoursework;

/**
 * Represents a Module which a student may take, similar to the modules at
 * Newcastle University in terms of the Module Code
 */
public class Module {
    private String code;
    private String title;
    private Integer mark;
    private Integer credits;

    /**
     * Create a new Module with the specified parameters
     * 
     * @param code    Module code in the format XXX0000 e.g. CSC2021
     * @param title   Title for the module
     * @param credits Credits for the module
     * @param mark    Mark for the module between 1-100
     * 
     * @throws IllegalArgumentException if the parameters suplied are invalid
     */
    public Module(String code, String title, Integer credits, Integer mark) {
        makeModule(code, title, credits, mark);
    }

    /**
     * Creates a module with the mark of 1
     * 
     * @param code    Module code in the format XXX0000 e.g. CSC2021
     * @param title   Title for the module
     * @param credits Credits for the module
     * 
     * @throws IllegalArgumentException if the parameters suplied are invalid
     */
    public Module(String code, String title, Integer credits) {
        makeModule(code, title, credits, 1);
    }

    private void makeModule(String code, String title, Integer credits, Integer mark) {
        if (code == null | code.isEmpty())
            throw new IllegalArgumentException("Module code cannot be null or empty");
        if (!code.matches("^[a-zA-Z]{3}[0-9]{4}$"))
            throw new IllegalArgumentException("Module code must be in the format XXX0000 e.g. CSC2021");
        if (title == null | title.isEmpty())
            throw new IllegalArgumentException("Title cannot be null or empty");
        if (credits == null)
            throw new IllegalArgumentException("Credits cannot be null");
        if (credits < 1)
            throw new IllegalArgumentException("Credits cannot be less than 1");
        if (mark == null)
            throw new IllegalArgumentException("Mark cannot be null");
        if (mark < 1 | mark > 100)
            throw new IllegalArgumentException("Mark must be between 1-100");

        this.code = code.toUpperCase();
        this.title = title;
        this.credits = credits;
        this.mark = mark;
    }

    /**
     * Override the original toString() method to return the appropriate information
     */
    @Override
    public String toString() {
        return String.format("%s %s (%d/100)", code, title, mark);
    }

    /**
     * Getter for the module code of a module
     * 
     * @return module code for a module
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Getter for the module title
     * 
     * @return the module title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Getter for the module mark
     * 
     * @return the module mark
     */
    public Integer getMark() {
        return this.mark;
    }

    /**
     * Getter for the credits
     * 
     * @return the credits
     */
    public Integer getCredits() {
        return this.credits;
    }

}