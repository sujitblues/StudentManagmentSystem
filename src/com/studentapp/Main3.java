package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main3 {
	private static List<Student>studentList;
	public static void main(String[] args) {
		System.out.println("*********Student Mangment System **********");
		System.out.println("*********Welcome********");
		studentList=new ArrayList<Student>();
		Student s1;//refrence variable
		s1=new Student("Kajal",22,"S-123");
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("DevOps");
		s1.enrollCourse("C#");
		
		Student s2=new Student("Uday",24,"S-11");
		s2.enrollCourse("Java");
		
		//System.out.println(s2);
		Student s3=new Student("Ritu",27,"S-13");
		s3.enrollCourse("DevOps");
		
		//System.out.println(s3);
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		
		Student result=findStudentById("S-11");
		System.out.println("result :"+result);
		sortByName();

	}
	private static void sortByName()
	{
		//using lamda expression
		Comparator<Student>studentNameComparator=(o1,o2)->o1.getName().compareTo(o2.getName());
		/*
		Comparator<Student>studentNameComparator=new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
				
			}
			
		};*/
		Collections.sort(studentList,studentNameComparator);
		System.out.println(studentList);
	}
	public static Student findStudentById(String studentId)
	{
		Student result=null;
		try
		{
		result=studentList.stream().filter(x->x.getStudentId().equalsIgnoreCase(studentId))
		.findFirst()
		.orElseThrow(()-> new RuntimeException("No data found"));
		}
		catch(RuntimeException e)
		{
			System.err.println("student with id "+studentId+" Not found!");
		}
		
		return result;
	}

}
