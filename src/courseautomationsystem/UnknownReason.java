/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseautomationsystem;

/**
 * It is an Exception to control of Unknown Reason Problem. 
 * @author Osman Süzer
 */
class UnknownReason extends Exception
{
    private String Message;
    public UnknownReason() 
    {
        Message = "Your operation stopped because of unknown reason!";
    }
    public void printMessage()
    {
        System.err.println(Message);
    }
}
