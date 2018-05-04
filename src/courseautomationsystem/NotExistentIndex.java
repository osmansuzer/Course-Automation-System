/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseautomationsystem;

/**
 * It is an Exception to control Index which are not existent.
 * @author Osman Süzer
 */
class NotExistentIndex extends Exception {

    private String Message;
    public NotExistentIndex() 
    {
        Message = "This index is not in List";
    }
    public void printMessage()
    {
        System.err.println(Message);
    }
}
