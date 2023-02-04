/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankminiproject;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Aayush Patel
 */
public class JavaDatabaseConnect {
    static Connection connect() {
        Connection con = null;
        try
        {
		Class.forName("com.mysql.jdbc.Driver"); // Loading driver class for communication with mysql
		System.out.println("Driver Loaded Successfully");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root",""); // Connecting Database
                System.out.println("Connection Established Successfully");
	}
	catch(SQLException e){	
		System.out.println("SQL Exception" + e);
	} 
	catch(Exception e){	
		System.out.println(e);
	}
        return con;
    }
}
