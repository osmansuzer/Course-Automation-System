/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseautomationsystem;

/**
 *
 * @author Osman Süzer
 */
public class CourseAutomationSystem {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception
    {
            Administrator admin = new Administrator("osman", "suzer", "admin", "123456");

            CourseInterface course1 = new Course("Course1");
            CourseInterface course2 = new Course("Course2");
            CourseInterface course3 = new Course("Course3");
            
            CourseInterface course3copy = new Course("Course3");
            
            Student Student1 = new Student("Stu1", "Student", "Student1", "43546", 123);
            Student Student2 = new Student("Stu2", "Student", "Student2", "43546", 124);
            Student Student3 = new Student("Stu3", "Student", "Student3", "43546", 125);
            Student Student4 = new Student("Stu4", "Student", "Student4", "43546", 126);
            Student Student5 = new Student("Stu5", "Student", "Student5", "43546", 127);
            Student Student6 = new Student("Stu6", "Student", "Student6", "43546", 128);
            Student Student7 = new Student("Stu7", "Student", "Student7", "43546", 129);
            Student Student8 = new Student("Stu8", "Student", "Student8", "43546", 130);
            Student Student9 = new Student("Stu9", "Student", "Student9", "43546", 131);
            
            Student Student9copy = new Student("Stu9", "Student", "Student9", "43546", 131);
            Student Student9username = new Student("Stu9username", "Student", "Student9","545", 145);
            
            
            Teacher Teacher1 = new Teacher("TeacherName1", "TeacherSurname1", "Teacher1", "546546");
            Teacher Teacher2 = new Teacher("TeacherName2", "TeacherSurname2", "Teacher2", "546546");
            Teacher Teacher3 = new Teacher("TeacherName3", "TeacherSurname3", "Teacher3", "546546");
            Teacher Teacher4 = new Teacher("TeacherName4", "TeacherSurname4", "Teacher4", "546546");
            Teacher Teacher5 = new Teacher("TeacherName5", "TeacherSurname5", "Teacher5", "546546");
            
     
            System.out.println("\n......Administrator adds all Courses to System.................");
           
            admin.addCourseToSystem(course1);
            admin.addCourseToSystem(course2);
            admin.addCourseToSystem(course3);
            
            System.out.println("\n......Administrator shows all Courses to System.................");
            
            admin.showCourseList();
            
            
            System.out.println("\n......Administrator add copy of Course3 to System.................");
            System.out.println("(.Note : System has already Course3.)");
            admin.addCourseToSystem(course3copy);
            
            System.out.println("\n......Administrator shows all Courses to System.................");
            admin.showCourseList();
                        
            
            System.out.println("\n......Administrator add Teachers to System and Course.........");
            
            admin.addUserToCourse(Teacher1, course1);
            admin.addUserToCourse(Teacher2, course2);
            admin.addUserToCourse(Teacher3, course3);
            admin.addUserToCourse(Teacher4, course1);
            admin.addUserToCourse(Teacher5, course2);
            admin.addUserToCourse(Teacher4, course3);
            admin.addUserToCourse(Teacher5, course1);
            
            System.out.println("\n......Administrator show all User in System.........");
            admin.showUserList();
            
            System.out.println("\n......Administrator add some Students to System................");
            
            admin.addUserToSystem(Student1);
            admin.addUserToSystem(Student2);
            admin.addUserToSystem(Student3);
            admin.addUserToSystem(Student4);
            admin.addUserToSystem(Student5);
            admin.addUserToSystem(Student6);
            admin.addUserToSystem(Student7);

            System.out.println("\n......Administrator show all User in System.........");
            admin.showUserList();
            
            System.out.println("\n......Student8 RegisterIntoSytem ................");
            Student8.RegisterIntoSystem();
            
            System.out.println("\n......Student9 RegisterIntoSytem ................");
            Student9.RegisterIntoSystem();
            
            System.out.println("\n......Administrator show all User in System.........");
            admin.showUserList();
            
            System.out.println("\n......Administrator show Requests For Register.........");
            admin.showRequestsForRegisterList();
            
            System.out.println("\n......Administrator Approve Requests of Student.........");
            admin.ApproveRequestOfStudent(0);
            admin.ApproveRequestOfStudent(1);
            
            System.out.println("\n......Administrator show all User in System.........");
            admin.showUserList();
            
            System.out.println("\n......Student9copy RegisterIntoSytem ................");
            Student9copy.RegisterIntoSystem();
            
            System.out.println("\n......Student9 same username RegisterIntoSytem ................");
            Student9username.RegisterIntoSystem();
            
            System.out.println("\n......Administrator show all User in System.........");
            admin.showUserList();
            
            System.out.println("\n......Teachers add Students to course.........");
 
            Teacher1.addStudentToCourse(Student1, course1);
            Teacher1.addStudentToCourse(Student2, course1);
            Teacher2.addStudentToCourse(Student3, course2);
            Teacher3.addStudentToCourse(Student4, course3);
            Teacher4.addStudentToCourse(Student5, course1);
            Teacher4.addStudentToCourse(Student6, course3);
            Teacher5.addStudentToCourse(Student7, course2);
            Teacher2.addStudentToCourse(Student8, course2);
            Teacher3.addStudentToCourse(Student9, course3);
            Teacher5.addStudentToCourse(Student6, course1);
            Teacher1.addStudentToCourse(Student3, course1);
            
            System.out.println("\n......Teacher1 shows course1.........");
            Teacher1.showStudentListInCourse(course1);
            
            System.out.println("\n......Teacher2 shows course2.........");
            Teacher2.showStudentListInCourse(course2);
           
            System.out.println("\n......Teacher3 shows course3.........");
            Teacher3.showStudentListInCourse(course3);
            
            System.out.println("\n......Teacher1 adds Student to Course2.........");
            System.out.println("(.Note = Course2 has not Teacher1.)");
            Teacher1.addStudentToCourse(Student5, course2);
            
            System.out.println("\n......Teacher1 shows course1.........");
            Teacher1.showStudentListInCourse(course1);
            
            System.out.println("\n......Teacher1 Remove a Student.........");
            Teacher1.removeStudentFromCourse(Student1, course1);
            
            System.out.println("\n......Teacher1 shows course1.........");
            Teacher1.showStudentListInCourse(course1);
            
            System.out.println("\n......Administrator show all User in System.........");
            admin.showUserList();
            
            System.out.println("\n......Administrator remove Student2 in System.........");
            admin.removeUserFromSystem(Student2);
            
            System.out.println("\n......Administrator show all User in System.........");
            admin.showUserList();
            System.out.println("\n......Administrator show Student list in Course1.........");
            admin.showStudentListInCourse(course1);
            
            
            System.out.println("\n......Teacher1 adds Document to Course1.........");
            Document doc = new Document("Document1", "doc");
            Teacher1.addDocumentToCourse(doc, course1);
            
            System.out.println("\n......Student5 show Documents in Course1.........");
            Student5.showDocumentListInCourse(course1);
            
            System.out.println("\n......Teacher1 gives Assigment to Course1.........");
            Homework homework1 = new Homework("Homework1", 12, 15);
            Quiz quiz1 = new Quiz("Quiz", 11, 16);
            
            Teacher1.giveAssigmentToCourse(homework1, course1);
            Teacher1.giveAssigmentToCourse(quiz1, course1);
            
            System.out.println("\n......Student5 show Assigments in Course1.........");
            Student5.showAssigmentListInCourse(course1);
            
            System.out.println("\n......Student5 and student6 upload Homework to Course1.........");
            Homework homeworkOfStudent5 = new Homework("student5_Homework", 12, 15);
            Homework homeworkOfStudent6 = new Homework("student6_Homework", 12, 15);
            
            Student5.UploadAssigmentToAssigmentInCourse(homeworkOfStudent5, 0, course1);
            Student6.UploadAssigmentToAssigmentInCourse(homeworkOfStudent6, 0, course1);
            
            System.out.println("\n......Teacher1 gives Note .........");
            Teacher1.giveNoteToStudentOfAssigmentInCourse(100, Student5, 0, course1);
            Teacher1.giveNoteToStudentOfAssigmentInCourse(90, Student6, 0, course1);
            
            System.out.println("\n......Student5 show Grades.........");
            Student5.showGrades();
            
            System.out.println("\n......Administrator show Course list.........");
            admin.showCourseList();
            
            System.out.println("\n......Administrator remove Course2.........");
            admin.removeCourseFromSystem(course2);
            
            System.out.println("\n......Administrator show Course list.........");
            admin.showCourseList();
        
    }
    
}
