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
public class Assigment implements AssigmentInterface
{
    private ArrayList<Note> AssigmentNotes;
    
    private String Name;
    private int Deadline;
    private int LateDeadline;
    
    
    Assigment(String name, int deadline, int lateDeadline)
    {
            setName(name);
            setDeadline(deadline);
            setLateDeadline(lateDeadline);
            AssigmentNotes = new ArrayList<Note>();
    }
    

    @Override
    public ArrayList<Note> getAssigmentNotesList()
    {
        return AssigmentNotes;
    }
    

    @Override
    public boolean DoesUploadStudentAssigment(Student student)
    {
        for(int i=0; i<this.getAssigmentNotesList().size(); ++i)
        {
            if(this.getAssigmentNotesList().get(i).getStudent()==student)
                return true;
        }
        return false;
    }
    

    @Override
    public int getNoteOfStudentAsInteger(Student student)
    {
      try
      {
        for(int i=0; i<getAssigmentNotesList().size(); ++i)
        {
            if(getAssigmentNotesList().get(i).getStudent()==student)
                return getAssigmentNotesList().get(i).getNote();
        }
        Exception ex = new Exception("This student is not in this Assigment!");
        throw ex;
      }
      catch(Exception ex)
      {
          System.err.println(ex.getMessage());
          return -2;     
      }
        
    }
    

    @Override
    public Note getNoteOfStudentAsNote(Student student)
    {
      try
      {
        for(int i=0; i<getAssigmentNotesList().size(); ++i)
        {
            if(getAssigmentNotesList().get(i).getStudent()==student)
                return getAssigmentNotesList().get(i);
        }
        Exception ex = new Exception("This student is not in this Assigment!");
        throw ex;
      }
      catch(Exception ex)
      {
          System.err.println(ex.getMessage());
          return null;     
      }
    }
    

    @Override
    public void setName(String newName)
    {
        Name = newName;
    }

    @Override
    public String getName()
    {
        return Name;
    }
    
    @Override
    public void setDeadline(int newDeadline)
    {
        Deadline = newDeadline;
    }


    @Override
    public int getDeadline()
    {
        return Deadline;
    }
    

    @Override
    public void setLateDeadline(int newLateDeadline)
    {
        LateDeadline = newLateDeadline;
    }

    @Override
    public int getLateDeadline()
    {
        return LateDeadline;
    }
    
 
    @Override
    public boolean equals(Assigment otherAssigment)
    {
        return (getName() == otherAssigment.getName());
    }
    
    @Override
    public String toString()
    {
        return String.format("Assigment : %s\nDeadLine : %s - LateDateline : %s", 
                                  getName(), getDeadline(), getLateDeadline());
    }
    
}
