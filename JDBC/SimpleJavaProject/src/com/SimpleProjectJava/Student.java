package com.SimpleProjectJava;

public class Student {
	public int id;
	public String name;
	public Student() {
		System.out.println("This is student class");
	}
	@Override
	public String toString() {
		return ("Student name: "+name+" \nId: "+id);
	}

}
