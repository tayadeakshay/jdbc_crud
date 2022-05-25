package com.prowings.jdbc;

public class Student {
	
	int roll;
	String name;
	String collageName;
	
	public Student() {
		super();
	}

	public Student(int roll, String name, String collageName) {
		super();
		this.roll = roll;
		this.name = name;
		this.collageName = collageName;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollageName() {
		return collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", collageName=" + collageName + "]";
	}
	
	

}
