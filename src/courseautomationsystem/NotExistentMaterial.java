/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseautomationsystem;

/**
 * It is an Exception to control Materials which are not existent.
 * @author Osman Süzer
 */
class NotExistentMaterial extends Exception {

    private String Message;
    public NotExistentMaterial() 
    {
        Message = "There is not that Material in Course!";
    }
    public void printMessage()
    {
        System.err.println(Message);
    }
}
