/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseautomationsystem;

/**
 * It is an Exception to control Users who are not existent. 
 * @author Osman Süzer
 */
class NotExistentUser extends Exception 
{
    private String Message;
    public NotExistentUser() 
    {
        Message = "There is not that User in System or Course";
    }
    public void printMessage()
    {
        System.err.println(Message);
    }
}
