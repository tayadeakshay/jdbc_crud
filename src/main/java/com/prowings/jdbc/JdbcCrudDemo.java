package com.prowings.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class JdbcCrudDemo {

	/*
	 * C - create
	 * R - read
	 * U - update
	 * D - delete 
	 */
	
	
	public boolean createStudent(Student student) throws SQLException
	{
		Connection con = DbUtil.getDbConnection();
		Random ran = new Random();
		int id = ran.nextInt(6) + 5;
		
		String insertStudentQuery = "insert into Student values(?,?,?,?)";

		PreparedStatement stmt = con.prepareStatement(insertStudentQuery);
		
		stmt.setInt(1, id);
		stmt.setInt(2, student.getRoll());
		stmt.setString(3, student.getName());
		stmt.setString(4, student.getCollageName());
		
		int updateFlag = stmt.executeUpdate();
		
		DbUtil.closeDbConnection();
		
		if(updateFlag>0)
		{
			System.out.println("Record inserted to DB successfully");
			return true;
		}
		else
			return false;
	}
	
	
	public Student getStudentByRoll(int roll)
	{
		Student fetchedStudent = new Student();
		
		
		
		return null;
	}
	
	public boolean updateStudent(Student student)
	{
		return false;
	}
	
	public boolean deleteStudentByRoll(int roll)
	{
		return false;
	}
}
