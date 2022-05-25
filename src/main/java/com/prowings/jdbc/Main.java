package com.prowings.jdbc;

import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) {
		
		int updateId=24;
		int deleteRoll=30;
		JdbcCrudDemo crudDemo = new JdbcCrudDemo();
		
		Student std1 = new Student(30, "Sita", "Hyderabad");
		Student std2 = new Student(10, "Ram", "Banglore");
		Student std3 = new Student(20, "Sham", "Mumbai");
		Student std4 = new Student(40, "Gita", "Pune");
		
		try {
			crudDemo.createStudent(std1);
			crudDemo.getStudentByRoll(std1.roll);
			crudDemo.updateStudent(updateId, std2);
			crudDemo.deleteStudentByRoll(deleteRoll);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
