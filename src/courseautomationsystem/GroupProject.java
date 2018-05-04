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
public class GroupProject extends Assigment
{
    private ArrayList <Student> GroupList = new ArrayList <Student>();
    
    GroupProject(String name, int deadline, int lateDeadline)
    {
        super(name, deadline, lateDeadline);
    }
    
    /**
     *
     * @return
     */
    public ArrayList <Student> getGroupList()
    {
        return GroupList;
    }
    
    /**
     *
     * @return
     */
    public int NumberOfStudentInGroup()
    {
        return getGroupList().size();
    }
    
    /**
     *
     * @param index
     * @return
     */
    public Student getStudentFromGroupList(int index)
    {
        if(index<NumberOfStudentInGroup() && index>=0)
            return getGroupList().get(index);
        
        return null;
    }
    
    /**
     *
     * @param student
     * @return
     */
    public boolean IsThereStudentInGroup(Student student)
    {
        for(int i=0; i<NumberOfStudentInGroup(); ++i)
        {
            if(student == getStudentFromGroupList(i))
                return true;
        }
        return false;
    }

    /**
     *
     * @param newStudent
     * @return
     */
    public boolean addStudentToGroup(Student newStudent)
    {
      try
      {
        if(newStudent.IsThereUser()==false)
        {
            //bu öğrenci sisteme eklenmemiş.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        else if(IsThereStudentInGroup(newStudent))
        {
            //bu grupta bu öğrenci var!!!
            AlreadyExistentUser ex = new AlreadyExistentUser();
            throw ex;
        }
        
        return getGroupList().add(newStudent);
      }
      catch(NotExistentUser ex)
      {
          ex.printMessage();
          return false;
      }
      catch(AlreadyExistentUser ex)
      {
          ex.printMessage();
          return false;
      }
      
    }
    
    /**
     *
     * @param removingStudent
     * @return
     */
    public boolean removeStudentFromGroup(Student removingStudent)
    {
      try
      {
        if(IsThereStudentInGroup(removingStudent))
        {
            return getGroupList().remove(removingStudent);
        }
        else
        {
            // böyle bir öğrenci zaten bulunmamaktadır.
            NotExistentUser ex = new NotExistentUser();
            throw ex;

        }
      }
      catch(NotExistentUser ex)
      {
          ex.printMessage();
          return false;
      }
    }

    /**
     *
     * @param otherGroupProject
     * @return
     */
    public boolean equals(GroupProject otherGroupProject)
    {
        return (getName() == otherGroupProject.getName());
    }
    
    public String toString()
    {
        return String.format("Group Project(Assigment) : %s\nDeadLine : %s - LateDateline : %s", 
                                  getName(), getDeadline(), getLateDeadline());
    }
}
