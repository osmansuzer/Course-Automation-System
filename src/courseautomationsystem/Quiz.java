/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseautomationsystem;

import java.util.ArrayList;

/**
 *
 * @author Osman Süzer
 */
public class Quiz extends Assigment
{
    Quiz(String name, int deadline, int lateDeadline)
    {
        super(name, deadline, lateDeadline);
    }
    
    /**
     * Converts Quiz to String.
     * @return Quiz as String.
     */
    public String toString()
    {
        return String.format("Quiz(Assigment) : %s\nDeadLine : %s - LateDateline : %s", 
                                  getName(), getDeadline(), getLateDeadline());
    }

}
