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
public class Tutor extends Student
{

    /**
     *
     * @param name
     * @param surname
     * @param userName
     * @param password
     * @param studentID
     */
    public Tutor(String name, String surname, String userName, 
                 String password, Integer studentID) 
    {
        super(name, surname, userName, password, studentID);
    }
    
    /**
     * Converts Tutor to String.
     * @return Tutor as String.
     */
    public String toString()
    {
        return String.format("Tutor: - Name: %s - Surname: %s - Username: %s", 
                                getName(), getSurname(), getUsername());
    }
}
