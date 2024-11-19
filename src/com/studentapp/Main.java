package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static List<Student>studentList;
	private static Scanner scanner;
	public static void main(String[] args) {
		System.out.println("*********Student Mangment System **********");
		System.out.println("*********Welcome********");
		studentList=new ArrayList<Student>();
		while(true)
		{
		System.out.println("Select an Option...");
		System.out.println("1. Register a Student");
		System.out.println("2. Find Student with studentId");
		System.out.println("3. List all Student Information");
		System.out.println("4. List Student Information in Sorted Order");
		System.out.println("5. Exit");
		//Read Input from the terminal!!!
		scanner=new Scanner(System.in);	
		int option=scanner.nextInt();
switch(option)
{
case 1:
	enrollStudent(scanner);
	break;
case 2:
	findStudentById(scanner);
	break;
case 3:
	printAllStudentData();
	break;
case 4:
	sortByName();
	break;
case 5:
	exit();
	break;
	default:System.out.println("Invalid option selected! ... Enter between 1 to 5");
}

	}	
		
	}
	private static void enrollStudent(Scanner scanner2) {
		System.out.println("Enter the student Name");
		String studentName=scanner2.next();
		System.out.println("Enter the Student Age");
		int studentage=scanner2.nextInt();
		System.out.println("Enter the student Id");
		String studentId=scanner.next();
		Student newStudent=new Student(studentName,studentage,studentId);
		studentList.add(newStudent);
		while(true)
		{
		System.out.println("Enter the course to be enrolled!... Type Done to exit");
		String courseName=scanner.next();
			if(courseName.equalsIgnoreCase("done"))
			{
			break;//exit from the loop you will use the break!!
			}
		newStudent.enrollCourse(courseName);
		}
		newStudent.printStudentInfo();
	}
	private static void findStudentById(Scanner scanner2) {
		Student studentFound=null;
		System.out.println("Enter the student id");
		String studentId=scanner2.next();
		try
		{
			studentFound=studentList.stream().filter(x->x.getStudentId().equalsIgnoreCase(studentId))
		.findFirst()
		.orElseThrow(()-> new RuntimeException("No data found"));
		}
		catch(RuntimeException e)
		{
			System.err.println("student with id "+studentId+" Not found!");
		}
		
		studentFound.printStudentInfo();
	}
		
	
	private static void printAllStudentData() {
		if(studentList.size()>0)
		{
		System.out.println("PRINTING All Student Data .......");
		for(Student student:studentList)
		{
			student.printStudentInfo();
		}
		}
		else
		{
			System.err.println("Student list is empty");
		}
		System.out.println("..................... .......");
	}
	private static void exit() {
		System.out.println("Good Bye!!!");
		System.exit(0);
		
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
		printAllStudentData();
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
