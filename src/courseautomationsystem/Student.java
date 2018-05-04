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
public class Student extends User 
{
    private Integer StudentID;
    
    private ArrayList <CourseInterface> MyCourseList;
    
    Student(String name, String surname, String userName, String password, Integer studentID)
    {
        super(name, surname, userName, password);
        setStudentID(studentID);
        MyCourseList = new ArrayList <CourseInterface>();
    }

    /**
     * Gets StudentID of Student.
     * @return it is returns StudentID of Student.
     */
    public Integer getStudentID()
    {
        return StudentID;
    }
    
    /**
     * Sets StudentID of Student.
     * @param newStudentID Integer to set StudentID of Student.
     */
    public void setStudentID(Integer newStudentID)
    {
        StudentID = newStudentID;
    }

    /**
     * Controls equality of Student with another Student. 
     * @param otherStudent Student who equality controlled.
     * @return It returns "true" if Students are equal.
     */
    public boolean equals(Student otherStudent)
    {
        return(super.equals(otherStudent) &&
               getStudentID() == otherStudent.getStudentID());
    }
    
    /**
     * Prints Documents list in course.
     * @param course Course to print Documents in it.
     * @return it returns "true" if it can take Documents in course.
     */
    public boolean showDocumentListInCourse(CourseInterface course)
    {
      try
      {
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else if(course.IsThereStudent(this)==false)
        {
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
           
        }
        else if(course.IsThereStudent(this))
        {
            Course c = (Course)course;
            for(int i=0; i<c.NumberOfDocument(); ++i)
            {
                System.out.printf("%d : ", i);
                System.out.println(c.getDocumentFromDocumentList(i));
            }
            return true;
        }
        else
        {
            UnknownReason ex = new UnknownReason();
            throw ex;
        }
        
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
          return false;
      }
      catch(NotExistentUser ex)
      {
          ex.printMessage();
          return false;
      }
      catch(UnknownReason ex)
      {
          ex.printMessage();
          return false;
      }
    }
    
    /**
     * Prints Assigment list in course.
     * @param course Course to print Assigments in it.
     * @return it returns "true" if it can take Assigments in course.
     */
    public boolean showAssigmentListInCourse(CourseInterface course)
    {
      try
      {
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else if(course.IsThereStudent(this)==false)
        {
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        
        }
        else if(course.IsThereStudent(this))
        {
            Course c = (Course)course;
            for(int i=0; i<c.NumberOfAssigment(); ++i)
            {
                System.out.printf("%d : ", i+1);
                System.out.println(c.getAssigmentFromAssigmentList(i));
            }
            return true;
        }
        else
        {
            UnknownReason ex = new UnknownReason();
            throw ex;
        }
        
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
          return false;
      }
      catch(NotExistentUser ex)
      {
          ex.printMessage();
          return false;
      }
      catch(UnknownReason ex)
      {
          ex.printMessage();
          return false;
      }
    }

    /**
     * Upload Assigment to Assigment In Course.
     * @param uploadAssigment Assigment of Student
     * @param assigmentIndex İnteger is index of Assigment of Course
     * @param course Course of assigment
     * @return it returns "true" if it can upload Assigment to Course
     */
    public boolean UploadAssigmentToAssigmentInCourse(AssigmentInterface uploadAssigment,
                                                      int assigmentIndex,
                                                      CourseInterface course)
    {
      try
      {
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs yok
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else if(course.IsThereStudent(this)==false)
        {
            //bu kursa kayıtlı değilsin
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        else if(course.IsThereAssigment(course.getAssigmentList().get(assigmentIndex))==false)
        {
            //bu kursta böyle bir assigment yok
            NotExistentMaterial ex = new NotExistentMaterial();
            throw ex;
        }
        else if(course.getAssigmentList().get(assigmentIndex).getLateDeadline()<0)
        {
            Exception ex2 = new Exception("Wrong date to Upload Assigment!");
            throw ex2;
            //bu kursun yüklenme zamanı geçmiş
        }
        
        return (course.getAssigmentList().get(assigmentIndex).getAssigmentNotesList()).add(new Note(this, uploadAssigment, -1));
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
          return false;
      }
      catch(NotExistentUser ex)
      {
          ex.printMessage();
          return false;
      }      
      catch(NotExistentMaterial ex)
      {
          ex.printMessage();
          return false;
      }
      catch(Exception ex2)
      {
          System.err.println(ex2.getMessage());
          return false;
      }

    }
    
    /**
     * Gives all Courses of Student.
     * @return it returns all Courses of Student.
     */
    public ArrayList <CourseInterface> getMyCourseList()
    {
        return MyCourseList;
    }
    
    /**
     * Print all Grades of Student.
     */
    public void showGrades()
    {
        for(int i=0; i<this.getMyCourseList().size(); ++i)
        {
            for(int j=0; j<this.getMyCourseList().get(i).NumberOfAssigment(); ++j)
            {
                if(getMyCourseList().get(i).getAssigmentList().get(j).DoesUploadStudentAssigment(this))
                {
                    System.out.println(getMyCourseList().get(i).getAssigmentList().get(j).getNoteOfStudentAsNote(this));
                }
            }
        }
    }
    
    /**
     * Request to Join to System from Administrator. 
     * @return It returns "true" if User has true feature to join to System.
     */
    public boolean RegisterIntoSystem()
    {
      try
      {
        for(int i=0; i<NumberOfUser(); ++i)
        {
            if(super.getUserFromUserList(i).getUsername()== this.getUsername())
            {
                // aynı kullanıcı isminde bir kullanıcı bulunmaktadır.
                Exception ex = new Exception("There is that Username in System!");
                throw ex;
            }
        }
        
        Administrator.getRequestsForRegisterList().add(this);
        System.out.println("Your Request wait for the consent of an Administrator.");
        return true;
      }
      catch(Exception ex)
      {
          System.err.println(ex.getMessage());
          return false;
      }
    }
    
    /**
     * Converts Student to String.
     * @return Student as String.
     */
    public String toString()
    {
        return String.format("Student: Name: %s - Surname: %s - Username: %s", 
                                getName(), getSurname(), getUsername());
        
    }
    
}
