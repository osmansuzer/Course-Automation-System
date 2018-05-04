/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseautomationsystem;

/**
 * It is an Exception to control Courses which are already existent. 
 * @author Osman Süzer
 */
class AlreadyExistentCourse extends Exception
{
    private String Message;
    public AlreadyExistentCourse() 
    {
        Message = "There is already that Course in System!";
    }
    public void printMessage()
    {
        System.err.println(Message);
    }
}
