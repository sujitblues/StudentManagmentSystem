package com.studentapp;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("*********Student Mangment System **********");
		System.out.println("*********Welcome********");
		List<Student>studentList=new ArrayList<Student>();
		Student s1;//refrence variable
		s1=new Student("Kajal",22,"S-123");
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("DevOps");
		s1.enrollCourse("C#");
		//System.out.println(s1);
		
		s1.printStudentInfo();
		Student s2=new Student("Uday",24,"S-11");
		s2.enrollCourse("Java");
		s2.printStudentInfo();
		//System.out.println(s2);
		Student s3=new Student("Ritu",27,"S-13");
		s3.enrollCourse("DevOps");
		s3.printStudentInfo();
		//System.out.println(s3);
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		
		

	}

}
