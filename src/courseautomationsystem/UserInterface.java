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
public interface UserInterface 
{      

    /**
     * Gets User List. 
     * @return It return User list.
     */
    public ArrayList <UserInterface> getUserList();
    
    /**
     * Sets Name of User.
     * @param newName  String to set Name of User.
     */
    public void setName(String newName);

    /**
     * Sets Surname of User.
     * @param newSurname  String to set Surname of User.
     */
    public void setSurname(String newSurname);

    /**
     * Sets Username of User.
     * @param newUsername  String to set Username of User.
     */
    public void setUserName(String newUsername);

    /**
     * Sets Password of User.
     * @param newPassword String to set Password of User.
     */
    public void setPassword(String newPassword);
    
    /**
     * Gets Name of User.
     * @return String is Name of User.
     */
    public String getName();

    /**
     * Gets Surname of User.
     * @return String is Surname of User.
     */
    public String getSurname();

    /**
     * Gets Username of User.
     * @return String is Username of User.
     */
    public String getUsername();

    /**
     * Gets Password of User.
     * @return String is Password of User.
     */
    public String getPassword();
    
    /**
     * Controls equality of User with another User. 
     * @param other User who equality controlled.
     * @return It returns "true" if Users are equal.
     */
    public boolean equals(UserInterface other);

    /**
     * Controls equality of username of User with username of another User.
     * @param other User who equality controlled.
     * @return It returns "true" if usernames of Users are equal.
     */
    public boolean equalsUserName(UserInterface other);    


    /**
     * Controls equality of Password of User with password of another User. 
     * @param other User who equality controlled.
     * @return It returns "true" if Passwords of Users are equal.
     */
    public boolean equalsPassword(UserInterface other);
    
    /**
     * Controls username and password of User.
     * @param userName String is username of user
     * @param password String is password of user
     * @return It returns "true" if User can login in System.
     */
    public boolean LoginToSystem(String userName, String password);

    /**
     * Request to Join to System from Administrator. 
     * @return It returns "true" if User has true feature to join to System.
     */
    public boolean RequestToJoinToSystem();
    

    
    /**
     * Give Number of User in System.
     * @return It returns Number of User in System.
     */
    public int NumberOfUser();

    
    /**
     * Gives User on index from User List.
     * @param index Index to take User on it.
     * @return It returns UserInterface on index from User List.
     */
    public UserInterface getUserFromUserList(int index);

   
    /**
     * Controls existence of User in System.
     * @return It returns "true" if there is User in System.
     */
    public boolean IsThereUser();
    
    
    /**
     * Converts User to String.
     * @return User as String.
     */
    @Override
    public String toString();
}