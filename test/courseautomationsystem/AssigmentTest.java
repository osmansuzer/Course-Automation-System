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
public class AssigmentTest {
    
    public AssigmentTest() {
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
     * Test of DoesUploadStudentAssigment method, of class Assigment.
     */
    @Test
    public void testDoesUploadStudentAssigment() throws Exception {

        Course course = new Course("dsfssdf");
        Administrator add = new Administrator("sdfs","sdadas","dsfs","fgjghj");
        Teacher teac = new Teacher("sdfs","tytr","ghjh","vbn");
        Student student = new Student("asas","asfsdf","sdfs","asdasd",4545);
        Assigment instance = new Assigment("dsfsd", 12, 14);
        add.addCourseToSystem(course);
        add.addUserToCourse(teac, course);
        add.addUserToCourse(student, course);
        teac.giveAssigmentToCourse(instance, course);

        Homework homework = new Homework("asda", 11, 12);
        
        boolean expResult1 = false;
        boolean result1 = instance.DoesUploadStudentAssigment(student);
        assertEquals(expResult1, result1);
        
        student.UploadAssigmentToAssigmentInCourse(homework, 0, course);
        boolean expResult = true;
        boolean result = instance.DoesUploadStudentAssigment(student);
        assertEquals(expResult, result);

    }
    
}
