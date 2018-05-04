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
public interface CourseInterface 
{

    /**
     * Sets Course Name.
     * @param newCourseName String to set Course Name.
     */
    public void setCourseName(String newCourseName);

    /**
     * Gets Course Name.
     * @return It returns Course Name as String.
     */
    public String getCourseName();

    /**
     * Controls existence of Course in System.
     * @return It returns "true" if there is Course in System.
     */
    public boolean IsThereCourse();    
    
    /**
     * Get List of Courses.
     * @return ArrayList of Courses.
     */
    public ArrayList <CourseInterface> getCourseList();

    /**
     * Get List of Removed Courses.
     * @return ArrayList of Removed Courses.
     */
    public ArrayList <CourseInterface> getRemovedCourseList();
    
    /**
     * Get List of Teachers in Course.
     * @return ArrayList of Teachers in Course.
     */
    public ArrayList <Teacher> getTeacherList();    

    /**
     * Get List of Students in Course.
     * @return ArrayList of Students in Course.
     */
    public ArrayList <Student> getStudentList();

    /**
     * Get List of Tuturs in Course.
     * @return ArrayList of Tutors in Course.
     */
    public ArrayList <Tutor> getTutorList();

    /**
     * Get List of Documents in Course.
     * @return ArrayList of Documents in Course.
     */
    public ArrayList <Document> getDocumentList();

    /**
     * Get List of Assigments in Course.
     * @return ArrayList of Assigments in Course.
     */
    public ArrayList <AssigmentInterface> getAssigmentList();
    
    /**
     * Give number of Teacher in Coutrse.
     * @return number of Teacher in Coutrse.
     */
    public int NumberOfTeacher();    

    /**
     * Give number of Student in Coutrse.
     * @return number of Student in Coutrse.
     */
    public int NumberOfStudent();

    /**
     * Give number of Tutor in Coutrse.
     * @return number of Tutor in Coutrse.
     */
    public int NumberOfTutor();

    /**
     * Give number of Document in Coutrse.
     * @return number of Document in Coutrse.
     */
    public int NumberOfDocument(); 

    /**
     * Give number of Assigment in Coutrse.
     * @return number of Assigment in Coutrse.
     */
    public int NumberOfAssigment();
    
    
    /**
     * Controls existence of Student in Course.
     * @param student Student who is controlled.
     * @return It returns "true" if there is Student in Course.
     */
    public boolean IsThereStudent(Student student);

    /**
     * Controls existence of Teacher in Course.
     * @param teacher Teacher who is controlled.
     * @return It returns "true" if there is Teacher in Course.
     */
    public boolean IsThereTeacher(Teacher teacher);

    /**
     * Controls existence of Tutor in Course.
     * @param tutor Tutor who is controlled.
     * @return It returns "true" if there is Tutor in Course.
     */
    public boolean IsThereTutor(Tutor tutor);

    /**
     * Controls existence of Document in Course.
     * @param document Document which is controlled.
     * @return It returns "true" if there is Document in Course.
     */
    public boolean IsThereDocument(Document document); 

    /**
     * Controls existence of Assigment in Course.
     * @param assigment Assigment which is controlled.
     * @return It returns "true" if there is Assigment in Course.
     */
    public boolean IsThereAssigment(AssigmentInterface assigment);

    /**
     * Controls equality of Course with another Course. 
     * @param otherCourse Course which equality controlled.
     * @return It returns "true" if Courses are equal.
     */
    public boolean equals(Course otherCourse);
    
    /**
     * Converts Course to String.
     * @return Course as String.
     */
    @Override
    public String toString();
}