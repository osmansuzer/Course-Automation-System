/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseautomationsystem;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Osman Süzer
 */
public class AdministratorTest {
    
    public AdministratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addUserToSystem method, of class Administrator.
     */
    @Test
    public void testAddUserToSystem() {

        Student addingUser = new Student("stuName", "stuSurname", "stu", "student", 123);
        Administrator instance = new Administrator("adminName", "adminSurname", "admin", "admin");
        boolean expResult = true;
        boolean result = instance.addUserToSystem(addingUser);
        assertEquals(expResult, result);
        
        Student addingUser2 = new Student("stuName1", "stuSurname1", "stu", "student", 123);
        boolean expResult2 = false;
        boolean result2 = instance.addUserToSystem(addingUser2);
        assertEquals(expResult2, result2);
        
        Student addingUser3 = new Student("stuName2", "stuSurname2", "stu2", "student", 123);
        boolean expResult3 = true;
        boolean result3 = instance.addUserToSystem(addingUser3);
        assertEquals(expResult3, result3);
        
        Teacher addingUser4 = new Teacher("teacherName", "teacherSurname", "teacher", "teacher");
        boolean expResult4 = true;
        boolean result4 = instance.addUserToSystem(addingUser4);
        assertEquals(expResult4, result4);
        

    }

    /**
     * Test of removeUserFromSystem method, of class Administrator.
     */
    @Test
    public void testRemoveUserFromSystem() {
        
        Administrator instance = new Administrator("adminName", "adminSurname", "admin", "admin");
        Teacher removingUser = new Teacher("stuName2", "stuSurname2", "sst", "student");
        boolean result1 = instance.addUserToSystem(removingUser);

        boolean expResult = true;
        boolean result = instance.removeUserFromSystem(removingUser);
        assertEquals(expResult, result);

        Student removingStudent = new Student("aa", "aaa", "aaaa", "aaa", 123);
        boolean expResult2 = false;
        boolean result2 = instance.removeUserFromSystem(removingStudent);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCourseToSystem method, of class Administrator.
     */
    @Test
    public void testAddCourseToSystem() {

        CourseInterface addingCourse = new Course("Coursee");
        Administrator instance = new Administrator("admin", "admin", "admin", "admin");
        boolean expResult = true;
        boolean result = instance.addCourseToSystem(addingCourse);
        assertEquals(expResult, result);

        CourseInterface addingCourse2 = new Course("Coursee");
        boolean expResult2 = false;
        boolean result2 = instance.addCourseToSystem(addingCourse2);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of removeCourseFromSystem method, of class Administrator.
     */
    @Test
    public void testRemoveCourseFromSystem() {
        CourseInterface removingCourse = new Course("Course");
        Administrator instance = new Administrator("admin", "admin", "admin", "admin");

        boolean oldresult1 = instance.addCourseToSystem(removingCourse);
        CourseInterface removingCourse2 = new Course("Course2");
        boolean oldresult2 = instance.addCourseToSystem(removingCourse2);
        boolean expResult = true;
        boolean result = instance.removeCourseFromSystem(removingCourse);
        assertEquals(expResult, result);

        boolean expResult2 = false;
        boolean result2 = instance.removeCourseFromSystem(removingCourse);
        assertEquals(expResult2, result2);
        
        boolean result3 = instance.removeCourseFromSystem(removingCourse2);
        assertEquals(expResult, result3);
    }

    /**
     * Test of addUserToCourse method, of class Administrator.
     */
    @Test
    public void testAddUserToCourse() throws Exception {

        CourseInterface course = new Course("Course");
        CourseInterface course2 = new Course("Course2");
        Administrator instance = new Administrator("admin", "admin", "admin", "admin");
        UserInterface addingUser = new Student("student", "stu", "ssss", "123",123);
        
        boolean expResult = false;
        boolean result = instance.addUserToCourse(addingUser, course);
        assertEquals(expResult, result);
        
        instance.addCourseToSystem(course);
        
        boolean expResult2 = true;
        boolean result2 = instance.addUserToCourse(addingUser, course);
        assertEquals(expResult2, result2);
        
        instance.addCourseToSystem(course2);
        
        boolean expResult3 = true;
        boolean result3 = instance.addUserToCourse(addingUser, course2);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of removeUserFromCourse method, of class Administrator.
     */
    @Test
    public void testRemoveUserFromCourse() throws Exception {
        
        Administrator instance = new Administrator("admin", "admin", "admin", "admin");
        CourseInterface course5 = new Course("Course5");
        instance.addCourseToSystem(course5);
        Student removingUser = new Student("student", "stu", "ssssss", "123", 123);

        boolean result2 = instance.addUserToCourse(removingUser, course5);
        
        boolean expResult = true;
        boolean result = instance.removeUserFromCourse(removingUser, course5);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeUserFromAllCourse method, of class Administrator.
     */
    @Test
    public void testRemoveUserFromAllCourse() throws Exception {
        Administrator instance = new Administrator("admin", "admin", "admin", "admin");
        Student removingUser = new Student("student", "stu", "sdfsdf", "123", 123);
 
        CourseInterface course11 = new Course("Course11");
        instance.addCourseToSystem(course11);
        CourseInterface course22 = new Course("Course22");
        instance.addCourseToSystem(course22);

        instance.addUserToCourse(removingUser, course11);
        instance.addUserToCourse(removingUser, course22);
        
        boolean expResult = true;
        boolean result = instance.removeUserFromAllCourse(removingUser);
        assertEquals(expResult, result);

        
    }


    
}
