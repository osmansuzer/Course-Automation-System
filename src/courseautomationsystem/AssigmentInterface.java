/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseautomationsystem;

import java.util.ArrayList;

/**
 *
 * @author Osman Süzer
 */
public interface AssigmentInterface 
{

    /**
     * Sets Assigment Name.
     * @param newName String to set Name.
     */
    public void setName(String newName);

    /**
     * Gives Assigment Name.
     * @return It returns Assiment Name.
     */
    public String getName();
    
    /**
     * Sets Assigment Deadline
     * @param newDeadline integer to set Deadline.
     */
    public void setDeadline(int newDeadline);

    /**
     * Gets Assigment Deadline
     * @return It returns Assiment Deadline.
     */
    public int getDeadline();

    /**
     * Sets Assigment Late Deadline
     * @param newLateDeadline integer to set Late Deadline.
     */
    public void setLateDeadline(int newLateDeadline);

    /**
     * Gets Assigment Late Deadline
     * @return It returns Assiment Late Deadline.
     */
    public int getLateDeadline();

    /**
     * Give ArrayList which notes of student store in . 
     * @return notes list. 
     */
    public ArrayList<Note> getAssigmentNotesList();

    /**
     * Controls students who upload Assigment.
     * @param student Student who is controled to upload.
     * @return It returns "true" if student uploaded assigment.
     */
    public boolean DoesUploadStudentAssigment(Student student);
    
    
    // not girilmemişse -1 return eder
    // öğrenci yoksa -2 return eder

    /**
     * Give note of Student as integer.
     * @param student Student who is owner of returned note.
     * @return It returns integer that is note of student.
     */
    public int getNoteOfStudentAsInteger(Student student);
    
    /**
     * Give note of Student as Note type.
     * @param student Student who is owner of returned note.
     * @return It returns Note type that is note of student.
     */
    public Note getNoteOfStudentAsNote(Student student);
    
    /**
     * Controls equality of Assigment with another Assigment.
     * @param otherAssigment Assigment which equality controlled.
     * @return It returns "true" if Assigments are equal.
     */
    public boolean equals(Assigment otherAssigment);

    /**
     * Converts Assigment to String.
     * @return Assigment as String.
     */
    @Override
    public String toString();
}


// newAssigment.getAssigmentNotesList().add(i, new Note(this.getStudentFromStudentList(i), Assigment(), -1));