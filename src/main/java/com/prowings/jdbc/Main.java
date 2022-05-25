package com.prowings.jdbc;

import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) {
		
		JdbcCrudDemo crudDemo = new JdbcCrudDemo();
		
		Student std1 = new Student(10, "Ram", "Pune");
		
		try {
			crudDemo.createStudent(std1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
