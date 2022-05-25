package com.prowings.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		int id = ran.nextInt(60) + 5;
		
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
	
	
	public Student getStudentByRoll(int roll) throws SQLException
	{
		Connection con = DbUtil.getDbConnection();
		//Student fetchedStudent = new Student();
		String fetchStudentQuery = "select * from student where roll = ?";
		PreparedStatement stmt = con.prepareStatement(fetchStudentQuery);
		stmt.setInt(1, roll);
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" : "+rs.getInt(2)+" : "+rs.getString(3)+" : "+rs.getString(4));
		}
		DbUtil.closeDbConnection();
		
		return null;
	}
	
	public boolean updateStudent(int id,Student student) throws SQLException
	{
		Connection con = DbUtil.getDbConnection();
		
		String updateStudentQuery = "update student set roll=?,name=?,address=? where id=?";

		PreparedStatement stmt = con.prepareStatement(updateStudentQuery);
		
		stmt.setInt(1, student.getRoll());
		stmt.setString(2, student.getName());
		stmt.setString(3, student.getCollageName());
		stmt.setInt(4, id);
		
		int updateFlag = stmt.executeUpdate();
	
		DbUtil.closeDbConnection();
		
		if(updateFlag>0)
		{
			System.out.println("Record updated to DB successfully");
			return true;
		}
		else
			return false;
	}
	
	public boolean deleteStudentByRoll(int roll) throws SQLException
	{
		Connection con = DbUtil.getDbConnection();
		String deleteStudentQuery = "delete from student where roll = ?";
		PreparedStatement stmt = con.prepareStatement(deleteStudentQuery);
		stmt.setInt(1, roll);
		int updateFlag = stmt.executeUpdate();
		
		DbUtil.closeDbConnection();
		
		if(updateFlag>0)
		{
			System.out.println("Record deleted from DB successfully");
			return true;
		}
		else
			return false;
	}
}
