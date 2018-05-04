/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseautomationsystem;

/**
 * 
 * @author Osman Süzer
 */
public class Note 
{
    
    Student N_Student;    
    AssigmentInterface N_Assigment;
    int N_Note;
    
    Note(Student student, AssigmentInterface assigment, int note)
    {
        setStudent(student);
        setAssigment(assigment);
        setNote(note);
    }
    
    /**
     * Sets Sutudent.
     * @param newStudent Student to set.
     */
    public void setStudent(Student newStudent)
    {
        N_Student = newStudent;
    }
    
    /**
     * Sets Assigment.
     * @param newAssigment Assigment to set.
     */
    public void setAssigment(AssigmentInterface newAssigment)
    {
        N_Assigment = newAssigment;
    }
    
    /**
     * Sets Note.
     * @param newNote Note(integer) to set.
     */
    public void setNote(int newNote)
    {
        N_Note = newNote;
    }
    
    /**
     * Give Student.
     * @return It returns Student.
     */
    public Student getStudent()
    {
        return N_Student;
    }
    
    /**
     * Give Assigment.
     * @return It returns Assigment.
     */
    public AssigmentInterface getAssigment()
    {
        return N_Assigment;
    }
    
    /**
     * Give Note as integer.
     * @return It returns not as integer.
     */
    public int getNote()
    {
        return N_Note;
    }

    /**
     * Converts Note to String.
     * @return Note as String.
     */
    public String toString()
    {
        return String.format("%s : %s = %d", this.getStudent(), this.getAssigment().getName(), this.getNote());
    }
}
