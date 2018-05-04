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
public abstract class User implements UserInterface
{
    
    /**
     *
     */
    public static ArrayList <UserInterface> UserList = new ArrayList<>();
    
    private String Name;
    private String Surname;
    private String UserName;
    private String Password;
    
    User(String newName, String newSurname, 
                      String newUserName, String newPassword)
    {
        Name = newName;
        Surname = newSurname;
        UserName = newUserName;
        Password = newPassword;
    }    
    
    /**
     *
     * @return
     */
    public ArrayList <UserInterface> getUserList()
    {
        return UserList;
    }
  
    /**
     *
     * @param newName
     */
    @Override
    public void setName(String newName)
    {
        Name = newName;
    }
    
    /**
     *
     * @param newSurname
     */
    @Override
    public void setSurname(String newSurname)
    {
        Surname = newSurname;
    }
    
    /**
     *
     * @param newUserName
     */
    @Override
    public void setUserName(String newUserName)
    {
        UserName = newUserName;
    }

    /**
     *
     * @param newPassword
     */
    @Override
    public void setPassword(String newPassword)
    {
        Password = newPassword;
    }
   
    /**
     *
     * @return
     */
    @Override
    public String getName() {return Name;}

    /**
     *
     * @return
     */
    @Override
    public String getSurname() {return Surname;}

    /**
     *
     * @return
     */
    @Override
    public String getUsername() {return UserName;}

    /**
     *
     * @return
     */
    @Override
    public String getPassword() {return Password;}
    
    /**
     *
     * @param userName
     * @param password
     * @return
     */
    public boolean LoginToSystem(String userName, String password)
    {
      try
      {
        if(getUsername()==userName  && getPassword() == password)
            return true;
        else
        {
            //yanlış kullanıcı acı veya parola
            Exception ex = new Exception("Wrong username or wrong password!");
            throw ex;
        }
      }
      catch(Exception ex)
      {
          System.err.println(ex.getMessage());
          return false;
      }
            
    }
    
    /**
     *
     * @return
     */
    public boolean RequestToJoinToSystem()
    {
      try
      {
        if(this.IsThereUser())
        {
            AlreadyExistentUser ex = new AlreadyExistentUser();
            throw ex;
        }
        else
        {
            for(int i=0; i<NumberOfUser(); ++i)
            {
                if(getUsername() == getUserFromUserList(i).getUsername())
                {
                    //bu kullanıcı adı başkası tarafanıdan kullanılıyor 
                    //başka bir kullanıcı adıyla tekrar deneyiniz.
                    Exception ex = new Exception("There is already this Username!");
                    throw ex;
                }
            }
            
            //isteğiniz alınmıştır. birkaçgün içerisinde büyük ihtimalle 
            //onaylanacaktır. daha sonra kullanıcı adınız ve 
            //şifrenizle giriş yapmayı deneyiniz.
            System.err.println("Your request has been taken. Please wait for approval of an Administrator.");
            return true;
        }
      }
      catch(AlreadyExistentUser ex)
      {
          ex.printMessage();
          return false;
      }
      catch(Exception ex)
      {
          System.err.println(ex.getMessage());
          return false;
      }
    }
    

    @Override
    public boolean equals(UserInterface other)
    {
        return(getName()==other.getName() && 
               getSurname()==other.getSurname() && 
               getUsername()==other.getUsername());
    }    
    

    @Override
    public boolean equalsUserName(UserInterface other)
    {
        return(getUsername()==other.getUsername());
    }
    

    @Override
    public boolean equalsPassword(UserInterface other)
    {
        return(getPassword()==other.getPassword());
    }
    
    @Override
    public String toString()
    {
        return String.format("User: Name: %s - Surname: %s - Username: %s\n", 
                                getName(), getSurname(), getUsername());
    }
    

    @Override
    public int NumberOfUser()
    {
        return getUserList().size();
    }
    

    @Override
    public UserInterface getUserFromUserList(int index)
    {
      try
      {
        if(index<NumberOfUser() && index>=0)
            return getUserList().get(index);
       
        else
        {
            NotExistentIndex ex = new NotExistentIndex();
            throw ex;
        }
      }
      catch(NotExistentIndex ex)
      {   
          ex.printMessage();
          return null;
      }
    }
    

    @Override
    public boolean IsThereUser()
    {
        for(int i=0; i<NumberOfUser(); ++i)
        {
            if(this == getUserFromUserList(i))
                return true;
        }
        return false;
    }
}