/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg130073107005;

/**
 *
 * @author student1
 */

import java.sql.*;

public class UserDB {

    public static void main(String[] args) {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection cn=DriverManager.getConnection("jdbc:odbc:UserDB");
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery("select *from login");
            System.out.println("User Info..");
            System.out.println("Sr. No.\tUser Name\tPassword");
            
            while(rs.next())
            {
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)); 
            }
        }
        catch(Exception e)
        {
            System.out.println("There is an error with database");
        }
    }
    
}
