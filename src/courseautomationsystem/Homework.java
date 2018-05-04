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
public class Homework extends Assigment
{
    Homework(String name, int deadline, int lateDeadline)
    {
        super(name, deadline, lateDeadline);
    }

    /**
     * Converts Homework to String.
     * @return Homework as String.
     */
    public String toString()
    {
        return String.format("Homework(Assigment) : %s\nDeadLine : %s - LateDateline : %s", 
                                  getName(), getDeadline(), getLateDeadline());
    }
}
