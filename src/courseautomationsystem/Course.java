/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseautomationsystem;
import java.io.*;
import java.util.ArrayList;

/**
 * 
 * @author Osman Süzer
 */
public class Course implements CourseInterface
{

    /**
     * It stores all of Courses in System. 
     */
    public static ArrayList <CourseInterface> CourseList = new ArrayList<>();

    /**
     *  It stores all of Courses from System. 
     */
    public static ArrayList <CourseInterface> RemovedCourseList = new ArrayList <>();
    
    private String CourseName;
    
    private ArrayList <Student> StudentList;
    private ArrayList <Teacher> TeacherList;
    private ArrayList <Tutor> TutorList;
    
    private ArrayList <Document> DocumentList;
    private ArrayList <AssigmentInterface> AssigmentList;
    
    Course(String courseName)
    {   
        setCourseName(courseName);
        StudentList = new ArrayList<Student>();
        TeacherList = new ArrayList<Teacher>();
        TutorList = new ArrayList<Tutor>();
    
        DocumentList = new ArrayList<Document>();
        AssigmentList = new ArrayList <AssigmentInterface>();
    }


    @Override
    public void setCourseName(String newCourseName)
    {
        CourseName = newCourseName;
    }

    
    @Override
    public String getCourseName()
    {
        return CourseName;
    }
    

    @Override
    public ArrayList <CourseInterface> getCourseList()
    {
        return CourseList;
    }


    @Override
    public ArrayList <CourseInterface> getRemovedCourseList()
    {
        return RemovedCourseList;
    }
    

    @Override
    public ArrayList <Student> getStudentList()
    {
        return StudentList;
    }
    

    @Override
    public ArrayList <Teacher> getTeacherList()
    {
        return TeacherList;
    }
    

    @Override
    public ArrayList <Tutor> getTutorList()
    {
        return TutorList;
    }
    

    @Override
    public ArrayList <Document> getDocumentList()
    {
        return DocumentList;
    }
    
    @Override
    public ArrayList <AssigmentInterface> getAssigmentList()
    {
        return AssigmentList;
    }
    

    
    
    ///////////////////////////////////////////////////////////////////////////
    //                      for CourseList                                   //
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Gives Course on index from Course List.
     * @param index Index to take Course on it.
     * @return It returns Course on index from Course List.
     */

    public CourseInterface getCourseFromCourseList(int index)
    {
        try
        {
            if(index<NumberOfCourse() && index>=0)
                return getCourseList().get(index);
        
            NotExistentIndex ex = new NotExistentIndex();
            throw ex; 
        }
        catch(NotExistentIndex ex)
        {
            ex.printMessage();
            return null;
        }
    }
    
    /**
     * Give Number of Course in System.
     * @return It returns Number of Course in System.
     */
    public int NumberOfCourse()
    {
        return getCourseList().size();
    }
    
    @Override
    public boolean IsThereCourse()
    {
        for(int i=0; i<NumberOfCourse(); ++i)
        {
            if(getCourseFromCourseList(i).equals(this))
                return true;
        }
        return false;
    }
    
    ////////////////////////////////////////////////////////////////////
    ////                       for Removed Course 
    ////////////////////////////////////////////////////////////////////
    
    /**
     * Gives Removed Course on index from Removed Course List.
     * @param index Index to take Removed Course on it.
     * @return It returns Removed Course on index from Removed Course List.
     */
    
    public CourseInterface getCourseFromRemovedCourseList(int index)
    {
        try{
            if(index<NumberOfCourse() && index>=0)
                return getRemovedCourseList().get(index);
        
            NotExistentIndex ex = new NotExistentIndex();
            throw ex; 
        }
        catch(NotExistentIndex ex)
        {
            ex.printMessage();
            return null;
        }
    }
    
    /**
     * Give Number of Removed Course in System.
     * @return It returns Number of Removed Course in System.
     */
    public int NumberOfRemovedCourse()
    {
        return getRemovedCourseList().size();
    }
    
    /*
     
    public boolean IsThereRemovedCourse()
    {
        for(int i=0; i<NumberOfRemovedCourse(); ++i)
        {
            if(getCourseFromRemovedCourseList(i).equals(this))
                return true;
        }
        return false;
    }
    */
    
    
    /////////////////////////////////////////////////////////////////////////
    //                for information of student                           //
    /////////////////////////////////////////////////////////////////////////


    @Override
    public int NumberOfStudent()
    {
        return getStudentList().size();
    }
    
    /**
     * Gives Student on index from Stundent List in Course.
     * @param index Index to take Student in Course on it.
     * @return It returns Student on index from Student List in Course.
     */
    public Student getStudentFromStudentList(int index)
    {
        try{
            if(index<NumberOfStudent() && index>=0)
                return getStudentList().get(index);
            NotExistentIndex ex = new NotExistentIndex();
            throw ex; 
        }
        catch(NotExistentIndex ex)
        {
            ex.printMessage();
            return null;
        }
    
    }
    
    
    @Override
    public boolean IsThereStudent(Student student)
    {
        for(int i=0; i<NumberOfStudent(); ++i)
        {
            if(student == getStudentFromStudentList(i))
                return true;
        }
        return false;
    }
    
    /**
     * Adds the Student to course.
     * @param newStudent Student to add to Course.
     * @return It returns "true" if it can add Student to Course.
     */
    public boolean addStudent(Student newStudent)
    {
        try{
            if(newStudent.IsThereUser()==false)
            {
                NotExistentUser ex = new NotExistentUser();
                throw ex;
            }
            else if(IsThereStudent(newStudent))
            {
                AlreadyExistentUser ex = new AlreadyExistentUser();
                throw ex;
            }
            else if(getStudentList().add(newStudent))
            {
                newStudent.getMyCourseList().add(this);
                return true;
            }
            else
            {
                UnknownReason ex = new UnknownReason();
                throw ex;
            }
        }
        catch(AlreadyExistentUser ex)
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
     * Removes the Student from course.
     * @param removingStudent Student to remove from Course.
     * @return It returns "true" if it can remove Student from Course.
     */
    public boolean removeStudent(Student removingStudent)
    {
        try{
            if(IsThereStudent(removingStudent))
            {
                if(getStudentList().remove(removingStudent))
                {
                    removingStudent.getMyCourseList().remove(this);
                    return true;
                }
                UnknownReason ex = new UnknownReason();
                throw ex;
            }
            else
            {
                NotExistentUser ex = new NotExistentUser();
                throw ex;
            }
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
    
    /////////////////////////////////////////////////////////////////////////
    //             for information of teacher                              //
    /////////////////////////////////////////////////////////////////////////

    @Override
    public int NumberOfTeacher()
    {
        return getTeacherList().size();  
    }
    
    /**
     * Gives Teacher on index from Teacher List in Course.
     * @param index Index to take Teacher in Course on it.
     * @return It returns Teacher on index from teacher List in Course.
     */
    public Teacher getTeacherFromTeacherList(int index)
    {   
        try{
            if(index<NumberOfTeacher() && index>=0)
                return getTeacherList().get(index);
            NotExistentIndex ex = new NotExistentIndex();
            throw ex; 
        }
        catch(NotExistentIndex ex)
        {
            ex.printMessage();
            return null;
        }
    }

    
    @Override
    public boolean IsThereTeacher(Teacher teacher)
    {
        for(int i=0; i<NumberOfTeacher(); ++i)
        {
            if(teacher == getTeacherFromTeacherList(i))
                return true;
        }
        return false;
    }

    /**
     * Adds the Teacher to course.
     * @param newTeacher teacher to add to Course.
     * @return It returns "true" if it can add Teacher to Course.
     */
    public boolean addTeacher(Teacher newTeacher)
    {
        try
        {
            if(newTeacher.IsThereUser()==false)
            {
                NotExistentUser ex = new NotExistentUser();
                throw ex;
            }
            else if(IsThereTeacher(newTeacher))
            {
                //bu kursta bu öğretmen var!!!
                AlreadyExistentUser ex = new AlreadyExistentUser();
                throw ex;
            }
            else if(getTeacherList().add(newTeacher))
            {
                newTeacher.getMyCourseList().add(this);
                return true;
            }
            else
            {
                UnknownReason ex = new UnknownReason();
                throw ex;
            }
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
        catch(UnknownReason ex)
        {
            ex.printMessage();
            return false;
        }
    }

    /**
     * Removes the Teacher from course.
     * @param removingTeacher Teacher to remove from Course.
     * @return It returns "true" if it can remove Teacher from Course.
     */
    public boolean removeTeacher(Teacher removingTeacher)
    {
        try
        {
            if(IsThereTeacher(removingTeacher))
            {
                if(getTeacherList().remove(removingTeacher))
                {
                    removingTeacher.getMyCourseList().remove(this);
                    return true;
                }

                UnknownReason ex = new UnknownReason();
                throw ex;
            }
            else
            {
                NotExistentUser ex = new NotExistentUser();
                throw ex;
            }
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
    
    /////////////////////////////////////////////////////////////////////////
    //                  for information of Tutor                          //
    ////////////////////////////////////////////////////////////////////////

    @Override
    public int NumberOfTutor()
    {
        return getTutorList().size();
    }
    
    /**
     * Gives Tutor on index from Tutor List in Course.
     * @param index Index to take Tutor in Course on it.
     * @return It returns Tutor on index from Tutor List in Course.
     */
    public Tutor getTutorFromTutorList(int index)
    {
        try{
            if(index<NumberOfTutor() && index>=0)
                return getTutorList().get(index);
            NotExistentIndex ex = new NotExistentIndex();
            throw ex; 
        }
        catch(NotExistentIndex ex)
        {
            ex.printMessage();
            return null;
        }
    }
    

    @Override
    public boolean IsThereTutor(Tutor tutor)
    {        
        for(int i=0; i<NumberOfTutor(); ++i)
        {
            if(tutor == getTutorFromTutorList(i))
                return true;
        }
        return false;
    }
    
    /**
     * Adds the Tutor to course.
     * @param newTutor Tutor to add to Course.
     * @return It returns "true" if it can add Tutor to Course.
     */
    public boolean addTutor(Tutor newTutor)
    {
        try
        {
            Student student = newTutor;

            if(newTutor.IsThereUser()==false)
            {
                //sisteme eklenmemiş
                NotExistentUser ex = new NotExistentUser();
                throw ex;
            }
            else if(student.IsThereUser()==false)
            {
                //öğrenci olarak sisteme eklenmemiş.
                NotExistentUser ex = new NotExistentUser();
                throw ex;
            }
            else if(IsThereStudent(student))
            {
                //bu kursta öğrenci olarak var!!!
                AlreadyExistentUser ex = new AlreadyExistentUser();
                throw ex;
            }
            else if(IsThereTutor(newTutor))
            {
                //bu kursta bu tutor var!!!
                AlreadyExistentUser ex = new AlreadyExistentUser();
                throw ex;
            }
        
            return getTutorList().add(newTutor);
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
     * Removes the Tutor from course.
     * @param removingTutor Tutor to remove from Course.
     * @return It returns "true" if it can remove Tutor from Course.
     */
    public boolean removeTutor(Tutor removingTutor)
    {
        try{
            if(IsThereTutor(removingTutor))
            {
                return getTutorList().remove(removingTutor);
            
            }
            else
            {
                // böyle bir tutor zaten bulunmamaktadır.
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
    
    /////////////////////////////////////////////////////////////////////////
    //                  for information of Document                         //
    ////////////////////////////////////////////////////////////////////////


    @Override
    public int NumberOfDocument()
    {
        return getDocumentList().size();
    }
    
    /**
     * Gives Document on index from Document List in Course.
     * @param index Index to take Document in Course on it.
     * @return It returns Document on index from Document List in Course.
     */
    public Document getDocumentFromDocumentList(int index)
    {
        try{
            if(index<NumberOfDocument() && index>=0)
                return getDocumentList().get(index);
            NotExistentIndex ex = new NotExistentIndex();
            throw ex; 
        }
        catch(NotExistentIndex ex)
        {
            ex.printMessage();
            return null;
        }
    }
    
    @Override
    public boolean IsThereDocument(Document document)
    {        
        for(int i=0; i<NumberOfDocument(); ++i)
        {
            if(document == getDocumentFromDocumentList(i))
                return true;
        }
        return false;
    }
    
    /**
     * Adds the Document to course.
     * @param newDocument Document to add to Course.
     * @return It returns "true" if it can add Document to Course.
     */
    public boolean addDocument(Document newDocument)
    {
        try
        {
            if(IsThereDocument(newDocument))
            {
                //böyle bir döküman zaten var
                AlreadyExistentMaterial ex = new AlreadyExistentMaterial();
                throw ex;
            }
        
            return getDocumentList().add(newDocument);
        }
        catch(AlreadyExistentMaterial ex)
        {
            ex.printMessage();
            return false;
        }
    }
    
    /**
     * Removes the Document from course.
     * @param removingDocument Document to remove from Course.
     * @return It returns "true" if it can remove Document from Course.
     */
    public boolean removeDocument(Document removingDocument)
    {
        try
        {
            if(IsThereDocument(removingDocument))
            {
                return getDocumentList().remove(removingDocument);
            }
            else
            {
                // böyle bir document zaten bulunmamaktadır.
                NotExistentMaterial ex = new NotExistentMaterial();
                throw ex;
            }
        }
        catch(NotExistentMaterial ex)
        {
            ex.printMessage();
            return false;
        }
    }
    
    
    /////////////////////////////////////////////////////////////////////////
    //                  for information of Assigment                        //
    ////////////////////////////////////////////////////////////////////////


    @Override
    public int NumberOfAssigment()
    {
        return getAssigmentList().size();
    }
    
    /**
     * Gives Assigment on index from Assigment List in Course.
     * @param index Index to take Assigment in Course on it.
     * @return It returns Assigment on index from Assigment List in Course.
     */
    public AssigmentInterface getAssigmentFromAssigmentList(int index)
    {
        try{
            if(index<NumberOfAssigment() && index>=0)
                return getAssigmentList().get(index);
            NotExistentIndex ex = new NotExistentIndex();
            throw ex; 
        }
        catch(NotExistentIndex ex)
        {
            ex.printMessage();
            return null;
        }
    }
    
    
    @Override
    public boolean IsThereAssigment(AssigmentInterface assigment)
    {        
        for(int i=0; i<NumberOfAssigment(); ++i)
        {
            if(assigment == getAssigmentFromAssigmentList(i))
                return true;
        }
        return false;
    }
    
    /**
     * Adds the Assiment to course.
     * @param newAssigment Assigment to add to Course.
     * @return It returns "true" if it can add Assigment to Course.
     */
    public boolean addAssigment(AssigmentInterface newAssigment)
    {
        try
        {
            if(IsThereAssigment(newAssigment))
            {
                //bu kursta bu assigment zaten var!!!
                AlreadyExistentMaterial ex = new AlreadyExistentMaterial();
                throw ex;
            }
        
            return getAssigmentList().add(newAssigment);
        }
        catch(AlreadyExistentMaterial ex)
        {
            ex.printMessage();
            return false;
        }

    }
    
    /**
     * Removes the Assiment from course.
     * @param removingAssigment Assigment to remove from Course.
     * @return It returns "true" if it can remove Assigment from Course.
     */
    public boolean removeAssigment(Assigment removingAssigment)
    {

        try
        {        
            if(IsThereAssigment(removingAssigment))
            {
                return getAssigmentList().remove(removingAssigment);
            }
            else
            {
                // böyle bir assigment zaten bulunmamaktadır.
                NotExistentMaterial ex = new NotExistentMaterial();
                throw ex;
            }
        }
        catch(NotExistentMaterial ex)
        {
            ex.printMessage();
            return false;
        }
    }
    
    ////////////////////////////////////////////////////////////////////////
    //                              Other methods                         //
    /////////////////////////////////////////////////////////////////////////

    @Override
    public boolean equals(Course otherCourse)
    {
        return(otherCourse.getCourseName() == getCourseName());
    }
    
    @Override
    public String toString()
    {
        return String.format("Course : %s\n", this.getCourseName());
    }

    
}
