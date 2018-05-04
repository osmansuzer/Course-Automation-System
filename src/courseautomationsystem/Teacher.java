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
public class Teacher extends User
{
    ArrayList<CourseInterface> MyCourseList;
    
    Teacher(String name, String surname, String userName, String password)
    {
        super(name, surname, userName, password);
        MyCourseList = new ArrayList<CourseInterface>();
    }

    
    /**
     * Gets Course List of Teacher.
     * @return It returns Course List of Teacher.
     */
    public ArrayList <CourseInterface> getMyCourseList()
    {
        return MyCourseList;
    }
    
    /**
     * Adds Student To Course.
     * @param newStudent Student to add to Course.
     * @param course Course to add Student in it.
     * @return It return "true" if it can add Student to Course.
     */
    public boolean addStudentToCourse(Student newStudent, CourseInterface course)
    {
      try
      {
        Course myCourse = (Course)course;
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        if(myCourse.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz!!
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        
        return myCourse.addStudent(newStudent);
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
      
    }
    
    /**
     * Removes Student from Course.
     * @param student Student to remove from Course.
     * @param course Course to remove Student from it.
     * @return It return "true" if it can remove Student from Course.
     */
    public boolean removeStudentFromCourse(Student student, CourseInterface course)
    {
      try
      {        
        Course myCourse = (Course)course;
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        if(myCourse.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz!!
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        
        return myCourse.removeStudent(student);
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
      
    }
    
    /**
     * Print all of Student in Course.
     * @param course Course to take Students in it.
     * @return it returns "true" if it can take Student list in course.
     */
    public boolean showStudentListInCourse(CourseInterface course)
    {
      try
      {
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else if(course.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz. 
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        else if(course.IsThereTeacher(this))
        {
            Course myCourse = (Course)course;
            for(int i=0; i<myCourse.NumberOfStudent(); ++i)
            {
                System.out.printf("%d : ", i+1);
                System.out.println(myCourse.getStudentFromStudentList(i));
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
     * Gets Student on index from Tutor List in Course.
     * @param index İnteger to take Student on it.
     * @param course Course to take Student in it.
     * @return It returns a Student if Course has that Student on index.
     */
    public Student getStudentFromStudentListInCourse(int index, CourseInterface course)
    {        
      try
      {
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        Course myCourse = (Course) course;
        if(course.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz.
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        else if(index>=0 && index<myCourse.NumberOfStudent())
            return myCourse.getStudentFromStudentList(index);
        else
        {
            UnknownReason ex = new UnknownReason();
            throw ex;
        }
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
          return null;
      }
      catch(NotExistentUser ex)
      {
          ex.printMessage();
          return null;
      }
      catch(UnknownReason ex)
      {
          ex.printMessage();
          return null;
      }
      
    }
    
    /**
     * Adds Tutur To Course.
     * @param newTutor Tutue to add to Course.
     * @param course Course to add Tutor in it.
     * @return It return "true" if it can add Tutor to Course.
     */
    public boolean addTutorToCourse(Tutor newTutor, CourseInterface course)
    {
      try
      {
        Course myCourse = (Course)course;
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        if(myCourse.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz!!
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        
        return myCourse.addTutor(newTutor);
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
      
    }
   
    /**
     * Removes Tutor from Course.
     * @param tutor Tutor to remove from Course.
     * @param course Course to remove Tutor from it.
     * @return It return "true" if it can remove Tutor from Course.
     */
    public boolean removeTutorFromCourse(Tutor tutor, CourseInterface course)
     {
      try
      {
        Course myCourse = (Course)course;
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        if(myCourse.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz!!
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        
        return myCourse.removeTutor(tutor);
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

    }
    
    /**
     * Print all of Tutor in Course.
     * @param course Course to take Tutor in it.
     * @return it returns "true" if it can take Tutor list in course.
     */
    public boolean showTutorListInCourse(CourseInterface course)
    {
      try
      {
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else if(course.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz. 
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        else if(course.IsThereTeacher(this))
        {
            Course c = (Course)course;
            for(int i=0; i<c.NumberOfTutor(); ++i)
            {
                System.out.printf("%d : ", i+1);
                System.out.println(c.getTutorFromTutorList(i));
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
     * Gets Tutor on index from Tutor List in Course.
     * @param index İnteger to take Tutor on it.
     * @param course Course to take Tutor in it.
     * @return It returns a Tutor if Course has that Tutor on index.
     */
    public Tutor getTutorFromTutorListInCourse(int index, CourseInterface course)
    {        
      try
      {
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        Course myCourse = (Course) course;
        if(course.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz.
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        else if(index>=0 && index<myCourse.NumberOfTutor())
            return myCourse.getTutorFromTutorList(index);
        else
        {
            UnknownReason ex = new UnknownReason();
            throw ex;
        }
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
          return null;
      }
      catch(NotExistentUser ex)
      {
          ex.printMessage();
          return null;
      }
      catch(UnknownReason ex)
      {
          ex.printMessage();
          return null;
      }
    }
   
    /**
     * Adds Document To Course.
     * @param newDocument Document to add to Course.
     * @param course Course to add Document in it.
     * @return It return "true" if it can add Document to Course.
     */
    public boolean addDocumentToCourse(Document newDocument, CourseInterface course)
    {
      try
      {
        Course myCourse = (Course)course;
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        if(course.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz!!
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        
        return myCourse.addDocument(newDocument);
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
      
    }
    
    /**
     * Removes Document from Course.
     * @param document Document to remove from Course.
     * @param course Course to remove Document from it.
     * @return It return "true" if it can remove Document from Course.
     */
    public boolean removeDocumentFromCourse(Document document, CourseInterface course)
    {
      try
      {
        Course myCourse = (Course)course;
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        if(myCourse.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz!!
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        
        return myCourse.removeDocument(document);
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
      
    }
    
    /**
     * Print all of Document in Course.
     * @param course Course to take Document in it.
     * @return it returns "true" if it can take Document list in course.
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
        else if(course.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz. 
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        else if(course.IsThereTeacher(this))
        {
            Course c = (Course)course;
            for(int i=0; i<c.NumberOfDocument(); ++i)
            {
                System.out.printf("%d : ", i+1);
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
     * Gets Document on index from Document List in Course.
     * @param index İnteger to take Document on it.
     * @param course Course to take Document in it.
     * @return It returns a Document if Course has that Document on index.
     */
    public Document getDocumentInCourse(int index, CourseInterface course)
    {
      try
      {        
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        if(course.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz!!
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        else if(index>=0 && index<course.NumberOfDocument())
        {
            return course.getDocumentList().get(index);
        }
        else if(index<0 || index>=course.NumberOfDocument())
        {
            //yanlış index;
            NotExistentIndex ex = new NotExistentIndex();
            throw ex; 
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
          return null;
      }
      catch(NotExistentUser ex)
      {
          ex.printMessage();
          return null;
      }
      catch(UnknownReason ex)
      {
          ex.printMessage();
          return null;
      }
      catch(NotExistentIndex ex)
      {
          ex.printMessage();
          return null;
      }
      
    }
    
    /**
     * Adds Assigment To Course.
     * @param newAssigment Assigment to add to Course.
     * @param course Course to add Assigment in it.
     * @return It return "true" if it can add Assigment to Course.
     */
    public boolean giveAssigmentToCourse(AssigmentInterface newAssigment, CourseInterface course)
    {
      try
      {
        Course myCourse = (Course)course;
        if(myCourse.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else if(myCourse.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz!!
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        
        return myCourse.addAssigment(newAssigment);
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
      
    }
    
    /**
     * Removes Assigment from Course.
     * @param assigment Assigment to remove from Course.
     * @param course Course to remove Assigment from it.
     * @return It return "true" if it can remove Assigment from Course.
     */
    public boolean removeAssigmentFromCourse(Assigment assigment, CourseInterface course)
    {
      try
      {
        Course myCourse = (Course)course;
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else if(myCourse.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz!!
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        
        return myCourse.removeAssigment(assigment);
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
      
    }
    
    /**
     *
     * @param student
     * @param projectGroup
     * @param course
     * @return
     */
    public boolean addStudentToProjectGroupInCourse(Student student, 
                              GroupProject projectGroup, CourseInterface course)
    {
      try
      {
        Course myCourse = (Course)course;
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else if(myCourse.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz!!
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        else if(myCourse.IsThereAssigment(projectGroup)==false)
        {
            //bu kursta böyle bir assigment yok!!!
            NotExistentMaterial ex = new NotExistentMaterial();
            throw ex;
        }
       
        return projectGroup.addStudentToGroup(student);
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
      
    }
    
    /**
     * Print all of Assigment in Course.
     * @param course Course to take Assigment in it.
     * @return it returns "true" if it can take Assigment list in course.
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
        else if(course.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz. 
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        else if(course.IsThereTeacher(this))
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
     * Gets Assigment on index from Assigment List in Course.
     * @param index İnteger to take Assigment on it.
     * @param course Course to take Assigment in it.
     * @return It returns a Assigment if Course has that Assigment on index.
     */
    public AssigmentInterface getAssigmentInCourse(int index, CourseInterface course)
    {
      try
      {        
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        if(course.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz!!
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        else if(index>=0 && index<course.NumberOfAssigment())
        {
            return course.getAssigmentList().get(index);
        }
        else if(index<0 || index>=course.NumberOfDocument())
        {
            NotExistentIndex ex = new NotExistentIndex();
            throw ex;                   
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
          return null;
      }
      catch(NotExistentUser ex)
      {
          ex.printMessage();
          return null;
      }
      catch(UnknownReason ex)
      {
          ex.printMessage();
          return null;
      }
      catch(NotExistentIndex ex)
      {
          ex.printMessage();
          return null;
      }
      
    }
   
    /**
     *
     * @param note Integer to give note to Student
     * @param student Student to give note his/her
     * @param assigmentIndex İnteger to find Assigment
     * @param course Course to find Assigment.
     * @return it returns "true" if it can give note to Student. 
     */
    public boolean giveNoteToStudentOfAssigmentInCourse(int note,
                                                       Student student,
                                                       int assigmentIndex,
                                                       CourseInterface course)
   {
      try
      {
     
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else if(course.IsThereTeacher(this)==false)
        {
            //bu kursta yetkili değilsiniz!!
            //bu kursta değilsiniz.
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        else if(course.IsThereAssigment(course.getAssigmentList().get(assigmentIndex))==false)
        {
            //bu kursta böyle bir assigment yok
            NotExistentMaterial ex = new NotExistentMaterial();
            throw ex;
        }
        else if(course.IsThereStudent(student)==false)
        {
            //bu kursta böyle bir öğrenci yok
            NotExistentUser ex = new NotExistentUser();
            throw ex;
        }
        else if(course.getAssigmentList().get(assigmentIndex).DoesUploadStudentAssigment(student))
        {
            course.getAssigmentList().get(assigmentIndex).getNoteOfStudentAsNote(student).setNote(note);
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
      catch(NotExistentMaterial ex)
      {
          ex.printMessage();
          return false;
      }
    }
   
    /**
     * Converts Teacher to String.
     * @return Teacher as String.
     */
    public String toString()
    {
        return String.format("Teacher: - Name: %s - Surname: %s - Username: %s", 
                                getName(), getSurname(), getUsername());
    }
    
}