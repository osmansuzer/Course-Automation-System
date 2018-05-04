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
public class CourseTest {
    
    public CourseTest() {
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
     * Test of IsThereCourse method, of class Course.
     */
    @Test
    public void testIsThereCourse() {

        Course instance = new Course("newCourseforTutor");
        Administrator doc = new Administrator("add", "miin", "documentfor", "dsfsfs");
        doc.addCourseToSystem(instance);
        boolean expResult = true;
        boolean result = instance.IsThereCourse();
        assertEquals(expResult, result);

    }



    /**
     * Test of addStudent method, of class Course.
     */
    @Test
    public void testAddStudent() {
        System.out.println("addDocument");
        Student newStudent = new Student("add", "miin", "studdentfor", "dsfsfs",5454);
        Course instance = new Course("newCourseforTutor");
        Administrator doc = new Administrator("add", "miin", "documentfor", "dsfsfs");
        doc.addCourseToSystem(instance);
        doc.addUserToSystem(newStudent);
 
        boolean expResult = true;
        boolean result = instance.addStudent(newStudent);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeStudent method, of class Course.
     */
    @Test
    public void testRemoveStudent() {

        System.out.println("addDocument");
        Student newStudent = new Student("add", "miin", "studdentfor", "dsfsfs",5454);
        Course instance = new Course("newCourseforTutor");
        Administrator doc = new Administrator("add", "miin", "documentfor", "dsfsfs");
        doc.addCourseToSystem(instance);
        doc.addUserToSystem(newStudent);
 
        instance.addStudent(newStudent);

        boolean expResult = false;
        boolean result = instance.removeStudent(newStudent);
        assertEquals(expResult, result);

    }


    /**
     * Test of addTeacher method, of class Course.
     */
    @Test
    public void testAddTeacher() {
        System.out.println("addDocument");
        Teacher newTeacher = new Teacher("add", "miin", "teacherfor", "dsfsfs");
        Course instance = new Course("newCourseforTutor");
        Administrator doc = new Administrator("add", "miin", "documentfor", "dsfsfs");
        doc.addCourseToSystem(instance);
        doc.addUserToSystem(newTeacher);
 
        boolean expResult = true;
        boolean result = instance.addTeacher(newTeacher);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeTeacher method, of class Course.
     */
    @Test
    public void testRemoveTeacher() {
        System.out.println("addDocument");
        Teacher newTeacher = new Teacher("add", "miin", "teacherfor", "dsfsfs");
        Course instance = new Course("newCourseforTutor");
        Administrator doc = new Administrator("add", "miin", "documentfor", "dsfsfs");
        doc.addCourseToSystem(instance);
        doc.addUserToSystem(newTeacher);
 
        instance.addTeacher(newTeacher);

        boolean expResult = false;
        boolean result = instance.removeTeacher(newTeacher);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeTutor method, of class Course.
     */
    @Test
    public void testRemoveTutor() {
        System.out.println("addDocument");
        Tutor newTutor = new Tutor("add", "miin", "tutorfor", "dsfsfs",5454);
        Course instance = new Course("newCourseforTutor");
        Administrator doc = new Administrator("add", "miin", "documentfor", "dsfsfs");
        doc.addCourseToSystem(instance);
        doc.addUserToSystem(newTutor);
 
        instance.addTutor(newTutor);

        
        boolean expResult = true;
        boolean result = instance.removeTutor(newTutor);
        assertEquals(expResult, result);

    }


    /**
     * Test of addDocument method, of class Course.
     */
    @Test
    public void testAddDocument() throws Exception {
        System.out.println("addDocument");
        Document newDocument = new Document("document","type");
        Course instance = new Course("newCourseforDocument");
        Administrator doc = new Administrator("add", "miin", "documentfor", "dsfsfs");
        Teacher teacFordoc = new Teacher("add", "miin", "documentforteach", "dsfsfs");
        doc.addCourseToSystem(instance);
        doc.addUserToCourse(teacFordoc, instance);
 
        boolean expResult = true;
        boolean result = instance.addDocument(newDocument);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeDocument method, of class Course.
     */
    @Test
    public void testRemoveDocument() throws Exception {
        System.out.println("addDocument");
        Document newDocument = new Document("document","type");
        Course instance = new Course("newCourseforDocument");
        Administrator doc = new Administrator("add", "miin", "documentfor", "dsfsfs");
        Teacher teacFordoc = new Teacher("add", "miin", "documentforteach", "dsfsfs");
        doc.addCourseToSystem(instance);
        doc.addUserToCourse(teacFordoc, instance);
 
        instance.addDocument(newDocument);

        boolean expResult = true;
        boolean result = instance.removeDocument(newDocument);
        assertEquals(expResult, result);

    }


    /**
     * Test of IsThereAssigment method, of class Course.
     */
    @Test
    public void testIsThereAssigment() {
        System.out.println("addDocument");
        Assigment newAssigment = new Assigment("document",12,15);
        Course instance = new Course("newCourseforDocument");
        Administrator doc = new Administrator("add", "miin", "documentfor", "dsfsfs");
        Teacher teacFordoc = new Teacher("add", "miin", "documentforteach", "dsfsfs");
        doc.addCourseToSystem(instance);
        instance.addAssigment(newAssigment);
        
        boolean expResult = true;
        boolean result = instance.IsThereAssigment(newAssigment);
        assertEquals(expResult, result);

    }

    /**
     * Test of addAssigment method, of class Course.
     */
    @Test
    public void testAddAssigment() {
        System.out.println("addDocument");
        Assigment newAssigment = new Assigment("document",12,15);
        Course instance = new Course("newCourseforDocument");
        Administrator doc = new Administrator("add", "miin", "documentfor", "dsfsfs");
        Teacher teacFordoc = new Teacher("add", "miin", "documentforteach", "dsfsfs");
        doc.addCourseToSystem(instance);
 
        boolean expResult = true;
        boolean result = instance.addAssigment(newAssigment);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAssigment method, of class Course.
     */
    @Test
    public void testRemoveAssigment() {
        System.out.println("addDocument");
        Assigment newAssigment = new Assigment("document",12,15);
        Course instance = new Course("newCourseforDocument");
        Administrator doc = new Administrator("add", "miin", "documentfor", "dsfsfs");
        Teacher teacFordoc = new Teacher("add", "miin", "documentforteach", "dsfsfs");
        doc.addCourseToSystem(instance);
        instance.addAssigment(newAssigment);
        boolean expResult = true;
        boolean result = instance.removeAssigment(newAssigment);
        assertEquals(expResult, result);
    }
    
}
