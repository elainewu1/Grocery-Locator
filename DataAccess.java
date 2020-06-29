/*
 * Elaine Wu 
 * TCES 455
 * The main function for this file is to establish connection and execute received query
 * Reference: 
 * https://www.youtube.com/watch?v=HE6ZHSuHcu0&list=PLP63X8dYTuaJTAMBZUHScyUCsJVPjSQgJ&index=5
 * https://www.youtube.com/watch?v=oz4iD_lidHg
 * UI 
https://www.youtube.com/watch?v=gkBT_aX0GQk


Commands from mysql
https://alvinalexander.com/blog/post/jdbc/sample-jdbc-preparedstatement-sql-update
https://www.tutorialspoint.com/javaexamples/jdbc_innerjoin.htm

Panel switch
https://www.youtube.com/watch?v=JtTy9CnBIyM&feature=youtu.be
 */

package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class DataAccess {
	
	Statement st = null;
	
	ResultSet rs = null;
	
	Connection connect = null;
	
	//Make Connection, change to different driver here
	public static Connection conn() throws Exception {
		
		//CHANGE url, username, pass to your own
		
		String url = "jdbc:mysql://localhost:3306/wu_elaine_db";
		String username = "elaine";
		String pass = "password";
		Connection con = DriverManager.getConnection(url, username, pass);
		
		return con;
		
	}
	
	//To execute Query through connection and return ResultSet
	public ResultSet ExecuteQuery(String sql) throws Exception {
		connect = conn();
		st = connect.createStatement();
		return st.executeQuery(sql);
	}
	
	//to execute query through connection and return success/failure
	public int ExecuteUpdate(String sql) throws Exception{
		connect = conn();
		st=connect.createStatement();
		return st.executeUpdate(sql);
	}
	
	//to check if intended to update data exists, empty array means data not exist
	public ArrayList<String> test(String sql) throws Exception{
		connect = conn();
		PreparedStatement state = connect.prepareStatement(sql);
		ResultSet result = state.executeQuery();
		ArrayList<String> array = new ArrayList<String>();
		if (result.next()) {
			array.add("1");
		}
		return array;
	}
	
	//to create table for display
	public ResultSet display(String sql) throws Exception{
		connect = conn();
		PreparedStatement state = connect.prepareStatement(sql);
		ResultSet result = state.executeQuery();
		return result;
	}
}
