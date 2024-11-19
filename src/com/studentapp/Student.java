package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	private String name;
	private int age;
	private String studentId;
	private List<String> courses;
	
	
	public Student(String name, int age, String studentId) {
		super();
		if(validateAge(age) && validateName(name) && validateStudentId(studentId))
		{
		this.name = name;
		this.age = age;
		this.studentId = studentId;
		courses=new ArrayList<String>();//intialization of courses
		}
	}
	private boolean validateStudentId(String studentId) {
		String studentIdRegx="S-\\d+$";//S-123
		Pattern studentPattern=Pattern.compile(studentIdRegx);
		Matcher studentMatcher=studentPattern.matcher(studentId);
		if(studentMatcher.matches())
		{
		return true;
		}else
		{
			System.err.println("Invalid student id ....use the formate s-123");
		}
		return false;

	}
	public void enrollCourse(String course)
	{
		if(validateCourseName(course))
		{
		if(!courses.contains(course) )
		{
			courses.add(course);
			System.out.println("Student enrolled to"+course+"Successfully");
			
		}
		else
		{
			System.err.println("Student is already enrolled in the course :"+course);
		}
		}
	}
	public void printStudentInfo()
	{
		System.out.println("=========Student Information============");
		System.out.println("Student Name :"+name);
		System.out.println("Student Age :"+age);
		System.out.println("Student Id :"+studentId);
		System.out.println("Enroll for :"+courses);
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}
	
	//validation methods
	public boolean validateAge(int age)
	{
		if(age>=19 && age<=35)
		{
			return true;
		}else
		{
			System.err.println("Invalid age!!! Student Age needs to be between 19 and 35");
			return false;
		}
	}
	
	public boolean validateName(String name)
	{
		//Kajal KAJAL kajal KaJal Talreja
		//^-Start with
		//$-end with
		
		String nameRegex="^[a-zA-Z\\s]+$";
		Pattern namePattern=Pattern.compile(nameRegex);
		Matcher nameMatcher=namePattern.matcher(name);
		
		if(nameMatcher.matches())
		{
			return true;
		}else
		{
			System.err.println("Invalid Name!! Please enter alphabets only");
			return false;
		}
	}
	
	public boolean validateCourseName(String course)
	{
		if(course.equalsIgnoreCase("Java")|| course.equalsIgnoreCase("DSA")|| course.equalsIgnoreCase("DevOps"))
		{
			return true;
		}
		else
		{
			System.err.println("Invalid course name!!! please select from course list[DSA,JAVA,DevOps]");
			return false;
		}
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getStudentId() {
		return studentId;
	}
	public List<String> getCourses() {
		return courses;
	}

	

}
