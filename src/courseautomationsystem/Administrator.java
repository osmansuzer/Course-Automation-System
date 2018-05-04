/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseautomationsystem;


import java.util.ArrayList;


/**
 *Manage the Course Automation System.
 * @author Osman Süzer
 */
public class Administrator extends User
{   

    /**
     *The list for students who request to register to Course Automation System.
     */
    public static ArrayList<Student> RequestsForRegisterList = new ArrayList<Student>();
    

            
    Administrator(String name, String surname, String userName, String password)
    {
        super(name, surname, userName, password);
        getUserList().add(this);
    }
    
    
    /**
     * get the list for students who request to register to Course Automation System.
     * @return return ArrayList of Student who request to register to Course Automation System.. 
     */
    public static ArrayList<Student> getRequestsForRegisterList()
    {
        return RequestsForRegisterList;
    }    
    
    
    /**
     * Adds the user to System.
     * @param addingUser User to add to system. 
     * @return It return "true" if can add the User to System. 
     */
    public boolean addUserToSystem(UserInterface addingUser)     
    {
      try
      {
        for(int i=0; i<getUserList().size(); ++i)
        {
            if(getUserList().get(i).equals(addingUser))
            {
                AlreadyExistentUser ex =new AlreadyExistentUser();
                throw ex;
            }
            else if(getUserList().get(i).equalsUserName(addingUser))
            {
                Exception ex = new Exception("There is that Username in System!");
                throw ex;
            }
        }
            
        return getUserList().add(addingUser);
        
      }
      catch(AlreadyExistentUser ex)
      {
          ex.printMessage();
          return false;
      }
      catch(Exception ex)
      {
          System.err.println(ex.getMessage());
          return false;
      }
    }
    
    /**
     * Removes the user from all System.
     * @param removingUser User to remove from all System 
     * @return It return "true" if can remove the User from System 
     */
    public boolean removeUserFromSystem(UserInterface removingUser)
    {
      try
      {
        if(removingUser.IsThereUser())
        {
            getUserList().remove(removingUser);
            
            // eğer kurslarda varsa kurslardakini de sil        
            removeUserFromAllCourse(removingUser);
            return true;
        }
        else
        {
            // böyle bir kullanıcı zaten sistemde bulunmamaktadır..
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
    
    ////////////////////////////////////////////////////////////////////////
    //                  for Course
    ///////////////////////////////////////////////////////////////////////

    /**
     *Adds the Course to System. 
     *@param addingCourse Course to add to system 
     *@return It return "true" if can add the course to System 
     */
    
    public boolean addCourseToSystem(CourseInterface addingCourse)    
    {
      try
      {
        if(addingCourse.IsThereCourse())
        {
            //bu kurs var 
            AlreadyExistentCourse ex = new AlreadyExistentCourse();
            throw ex;
           
        }
        else
        {
            Course c = new Course("c");
            return c.getCourseList().add(addingCourse);
        }
      }
      catch(AlreadyExistentCourse ex)
      {
          ex.printMessage();
          return false;
      }
    }
    
    /**
     *Removes the Course from System.
     * @param removingCourse Course to remove from system 
     * @return It return "true" if can remove the course from System
     */
    public boolean removeCourseFromSystem(CourseInterface removingCourse)    
    {
      try
      {
        if(removingCourse.IsThereCourse())
        {
            Course c = new Course("c");
            c.getRemovedCourseList().add(removingCourse);
            return c.getCourseList().remove(removingCourse);
        }
        else
        {
            // böyle bir kurs zaten bulunmamaktadır.
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
            
        }
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
          return false;
      }
    }
    
    ////////////////////////////////////////////////////////////////////////
    //                   for User
    ////////////////////////////////////////////////////////////////////////

    /**
     * Adds the User To Course in System.
     * @param addingUser User to add to course in System.
     * @param course Course in System to add an user.
     * @return It return "true" if can add the User to Course in System. 
     */
    public boolean addUserToCourse(UserInterface addingUser, CourseInterface course) throws Exception
    {
      try
      {
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else if(addingUser.IsThereUser()==false)
        {
            //bu kullanıcı eğer sistemde yoksa sisteme ekle
            if(addUserToSystem(addingUser))
                //bu kullanıcıyı kursa ekle
                return addUserToCourse(addingUser, course);
            
            else
            {
                UnknownReason ex = new UnknownReason();
                throw ex;
            }
        }
        else
        {
            if(addingUser instanceof Teacher)
            {
                return addTeacherToCourse((Teacher)addingUser, course);
            }
            else if(addingUser instanceof Student)
            {
                return addStudentToCourse((Student)addingUser, course);
            }
            else if(addingUser instanceof Tutor)
            {
                return addTutorToCourse((Tutor)addingUser, course);
            }
            else
            {
                UnknownReason ex = new UnknownReason();
                throw ex;
            }
        }
      }
      catch(UnknownReason ex)
      {
          ex.printMessage();
          return false;
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
          return false;
      }
      
    }
    
    
    /**
     * Removes the User To Course in System.
     * @param removingUser User to remove from course in System.
     * @param course Course in System to remove an user.
     * @return It return "true" if can remove the User from Course in System.
     */

    public boolean removeUserFromCourse(UserInterface removingUser, CourseInterface course)
    {
      try
      {
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else
        {
            if(removingUser instanceof Teacher)
            {
                return removeTeacherFromCourse((Teacher)removingUser, course);
            }
            else if(removingUser instanceof Student)
            {
                return removeStudentFromCourse((Student)removingUser, course);
            }
            else if(removingUser instanceof Tutor)
            {
                return removeTutorFromCourse((Tutor)removingUser, course);
            }
            else
            {
                UnknownReason ex = new UnknownReason();
                throw ex;
            }
        }
      }
      catch(UnknownReason ex)
      {
          ex.printMessage();
          return false;
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
          return false;
      }
    }
    
    /**
     * Removes the User from all of Course in System.
     * @param removingUser User to remove from all of Course in System.
     * @return It return "true" if can remove the User from all of Course in System.
     */
    public boolean removeUserFromAllCourse(UserInterface removingUser)
    {
        Course c = new Course("c");
        
        boolean result = false;
        
        if(removingUser instanceof Student)
        {
            Student student = (Student)removingUser;
            for(int i=0; i<c.NumberOfCourse(); ++i)
            {   
                Course course = (Course)c.getCourseFromCourseList(i);
                if(course.IsThereStudent(student))
                {
                    result = course.removeStudent(student);
                }
            }
        }
        else if(removingUser instanceof Teacher)
        {
            Teacher teacher = (Teacher)removingUser;
            for(int i=0; i<c.NumberOfCourse(); ++i)
            {   
                Course course = (Course)c.getCourseFromCourseList(i);
                if(course.IsThereTeacher(teacher))
                {
                    result = course.removeTeacher(teacher);
                }
            }
        }
        else if(removingUser instanceof Tutor)
        {
            Tutor tutor = (Tutor)removingUser;
            for(int i=0; i<c.NumberOfCourse(); ++i)
            {   
                Course course = (Course)c.getCourseFromCourseList(i);
                if(course.IsThereTutor(tutor))
                {
                    result = course.removeTutor(tutor);
                }
            }
        }
        
        return result;
    }
    
    ////////////////////////////////////////////////////////////////////////
    //                  for Teacher
    ///////////////////////////////////////////////////////////////////////
    
    private boolean addTeacherToCourse(Teacher newTeacher, CourseInterface course)
    {
      try
      {
        Course myCourse = (Course)course;
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else if(newTeacher.IsThereUser() == false)
        {
            //bu öğrentmen sisteme eklenmemiş.
            
            //öğretmen sisteme eklenir
            if(addUserToSystem(newTeacher))
                //öğretmen kursa eklenir
                return addTeacherToCourse(newTeacher, course);
            
            else
            {
                UnknownReason ex = new UnknownReason();
                throw ex;
            }
        }
        return myCourse.addTeacher(newTeacher);

      }
      catch(NotExistentCourse ex)
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
    
    private boolean removeTeacherFromCourse(Teacher newTeacher, CourseInterface course)
    {
      try
      {
        Course myCourse = (Course)course;
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        return myCourse.removeTeacher(newTeacher);
        
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
          return false;
      }

      
    }
    ////////////////////////////////////////////////////////////////////////
    //                  for Student
    ///////////////////////////////////////////////////////////////////////
    

    private boolean addStudentToCourse(Student newStudent, CourseInterface course) throws Exception
    {
      try
      {
        Course myCourse = (Course)course;
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else if(myCourse.IsThereStudent(newStudent))
        {
            //bu kursta bu öğrenci zaten var!!!
            return false;
        }
        else if(newStudent.IsThereUser() == false)
        {
            //bu öğrenci sisteme eklenmemiş.
            
            //öğrenci sisteme eklenir
            if(addUserToSystem(newStudent))
                //öğrenci kursa eklenir
                return addStudentToCourse(newStudent, course);
            else
                return false;
        }
        else if(newStudent.IsThereUser())
        {
            myCourse.addStudent(newStudent);
            return true;
        }

        return false;
      }
      catch(NotExistentCourse ex)
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
    
    private boolean removeStudentFromCourse(Student newStudent, CourseInterface course)
    {
      try
      {
        Course myCourse = (Course)course;
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        return myCourse.removeStudent(newStudent);

      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
          return false;
      }

    }
    
    ////////////////////////////////////////////////////////////////////////
    //                  for Tutor
    ///////////////////////////////////////////////////////////////////////
    
    private boolean addTutorToCourse(Tutor newTutor, CourseInterface course)
    {
      try
      {
        Course myCourse = (Course)course;
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else if(newTutor.IsThereUser() == false)
        {
            //bu öğrenci sisteme eklenmemiş.
            
            //öğrenci sisteme eklenir
            if(addUserToSystem(newTutor))
                //öğrenci kursa eklenir
                return addTutorToCourse(newTutor, course);
            else
            {
                UnknownReason ex = new UnknownReason();
                throw ex;
            }
                
        }
        
        return myCourse.addTutor(newTutor);
      }
      catch(NotExistentCourse ex)
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
    
    private boolean removeTutorFromCourse(Tutor newTutor, CourseInterface course)
    {
      try
      {
        Course myCourse = (Course)course;
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        return myCourse.removeTutor(newTutor);
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
          return false;
      }
      
    }

    
    @Override
    public String toString()
    {
        return String.format("Administrator: Name: %s - Surname: %s - Username: %s", 
                                getName(), getSurname(), getUsername());
    }
    
    /**
     * Prints all of User in System.
     */
    public void showUserList()
    {
        for(int i=0; i<NumberOfUser(); ++i)
        {
            System.out.println(this.getUserList().get(i));
        }
    }

    
    /**
     * Prints all of Course in System.
     */
    public void showCourseList()
    {
        Course c = new Course("c");
        for(int i=0; i<c.NumberOfCourse(); ++i)
        {
            System.out.println(c.getCourseFromCourseList(i));
        }
    }
    
    /**
     * Give Course on index from list of courses. 
     * @param index Index to take on Course. 
     * @return It return CourseInterface on index. 
     */
    public CourseInterface getCourseFromCourseList(int index)
    {
        Course c = new Course("c");
        if(index>=0 && index<c.NumberOfCourse())
            return c.getCourseFromCourseList(index);
        else 
            return null;
    }
    
    /**
     * Prints all of Removed Course in System.
     */
    public void showRemovedCourseList()
    {
        Course c = new Course("c");
        for(int i=0; i<c.NumberOfRemovedCourse(); ++i)
        {
            System.out.println(c.getCourseFromRemovedCourseList(i));
        }
    }
    
    /**
     * Give Removed Course on index from list of courses. 
     * @param index Index to take on Removed Course. 
     * @return It return CourseInterface on index. 
     */
    public CourseInterface getRemovedCourseFromRemovedCourseList(int index)
    {
        Course c = new Course("c");
        if(index>=0 && index<c.NumberOfRemovedCourse())
            return c.getCourseFromRemovedCourseList(index);
        else 
            return null;
    }
    
    /**
     * Prints all of Student in an Course in System.
     * @param course CourseInterface to print students in it .
     */
    public void showStudentListInCourse(CourseInterface course)
    {
      try
      {
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else
        {
            Course myCourse = (Course)course;
            for(int i=0; i<myCourse.NumberOfStudent(); ++i)
            {
                System.out.printf("%d : ", i+1);
                System.out.println(myCourse.getStudentFromStudentList(i));
            }
        }
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
      }
      
    }
    
    
    /**
     * Gives Student on index from Course.
     * @param index Index to take Student on it in Course.
     * @param course CourseInterface to take Student in it on index.
     * @return Student on index from Course.
     */
    public Student getStudentFromStudentListInCourse(int index, CourseInterface course)
    {
      try
      {
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        Course myCourse = (Course) course;
        if(index>=0 && index<myCourse.NumberOfStudent())
            return myCourse.getStudentFromStudentList(index);
        else 
            return null;
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
          return null;
      }
      
    }
    
    /**
     * Prints all of Teacher in the Course in System.
     * @param course CourseInterface to print teachers in it.
     */
    public void showTeacherListInCourse(CourseInterface course)
    {
      try
      {
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else
        {
            Course myCourse = (Course)course;
            for(int i=0; i<myCourse.NumberOfTeacher(); ++i)
            {
                System.out.printf("%d : ", i+1);
                System.out.println(myCourse.getTeacherFromTeacherList(i));
            }
        }
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
        
      }
      
    }
    
    /**
     * Gives Teacher on index from Course.
     * @param index Index to take Teacher on it in Course.
     * @param course CourseInterface to take Teacher in it on index.
     * @return Teacher on index from Course.
     */
    public Teacher getTeacherFromTeacherListInCourse(int index, CourseInterface course)
    {
      try
      {
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        Course myCourse = (Course) course;
        if(index>=0 && index<myCourse.NumberOfTeacher())
            return myCourse.getTeacherFromTeacherList(index);
        else 
            return null;
        
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
          return null;
      }
      
    }
    
    /**
     * Prints all of Tutor in the Course in System.
     * @param course CourseInterface to print tutor in it.
     */
    public void showTutorListInCourse(CourseInterface course)
    {
      try{
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        else
        {
            Course myCourse = (Course)course;
            for(int i=0; i<myCourse.NumberOfTutor(); ++i)
            {
                System.out.printf("%d : ", i+1);
                System.out.println(myCourse.getTutorFromTutorList(i));
            }
        }
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
      }
      
    }
    
    /**
     * Gives Tutor on index from Course.
     * @param index Index to take Tutor on it in Course.
     * @param course CourseInterface to take Tutor in it on index.
     * @return Tutor on index from Course.
     */
    public Tutor getTutorFromTutorListInCourse(int index, CourseInterface course)
    {
      try
      {
        if(course.IsThereCourse()==false)
        {
            //böyle bir kurs bulunmamaktadır
            NotExistentCourse ex = new NotExistentCourse();
            throw ex;
        }
        Course myCourse = (Course) course;
        if(index>=0 && index<myCourse.NumberOfTutor())
            return myCourse.getTutorFromTutorList(index);
        else 
            return null;
      }
      catch(NotExistentCourse ex)
      {
          ex.printMessage();
          return null;
      }
      
    }
    
    /**
     * Prints all of Requests to Register of Students.
     */
    public void showRequestsForRegisterList()
    {
        for(int i=0; i<Administrator.getRequestsForRegisterList().size(); ++i)
        {
            System.out.printf("%d : ", i+1);
            System.out.println(Administrator.getRequestsForRegisterList().get(i));
        }
    }
    
    /**
     * Approve request of student on index.
     * @param index Index to approve request of student on it.
     * @return it returns "true" if Administrator can add student on index to System. 
     */
    public boolean ApproveRequestOfStudent(int index)
    {
        return addUserToSystem(Administrator.getRequestsForRegisterList().get(index));
    }
}