package test;

import static org.junit.Assert.*;
import gradeSystem.GradeSystems;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestInsertGradeC1C2 {
	/**
	 * @uml.property  name="outContent"
	 */
	final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	/**
	 * @uml.property  name="gradeSystems"
	 * @uml.associationEnd  
	 */
	GradeSystems gradeSystems = null;

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		gradeSystems = new GradeSystems();
	}

	@After
	public void tearDown() throws Exception {
	}

	/** ----------------------------------------------------------------------------------------------------------------------
	TestInsertGrade 
	case 1: Student ID:995002016 �AStudent Name:Alex�Alab1:60�Alab2:85�Alab3:70�AmidTerm:90�AfinalExam:100�A�T�{�[�J(Y)
	case 2: Student ID:995002016 �AStudent Name:Alex�Alab1:60�Alab2:85�Alab3:70�AmidTerm:90�AfinalExam:100�A���[�J(N)
	------------------------------------------------------------------------------------------------------------------------- */

	//�ݭק�source code
	@Test
	public void test() {
		final ByteArrayInputStream inContent = new ByteArrayInputStream(
				"995002016 Alex 60 85 70 90 100 ".getBytes());
		System.setIn(inContent);
		gradeSystems.insertGrade();
		String predictOutput = "";
		predictOutput = predictOutput + "Student ID:" + "Student Name:"
				+ "lab1:" + "lab2:" + "lab3:" + "midTerm:"
				+ "finalExam:";
		predictOutput = predictOutput + "�нT�{���:\r\n"+ "�s�ϥΪ�ID\t"+"995002016\r\n"+"�s�W��\t\t"+"Alex\r\n"+"lab1\t\t"
				 + 60 + "\r\nlab2\t\t"
				 + 85 + "\r\nlab3\t\t"
				 + 70 + "\r\nmid-term\t"
				 + 90 + "\r\nfinal exam\t"
				 + 100 + "\r\n";
		predictOutput = predictOutput + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
	}

	@Test
	public void test2() {
		final ByteArrayInputStream inContent = new ByteArrayInputStream(
				"995002016 Alex 60 85 70 90 100 ".getBytes());
		System.setIn(inContent);
		gradeSystems.insertGrade();
		String predictOutput = "";
		predictOutput = predictOutput + "Student ID:" + "Student Name:"
				+ "lab1:" + "lab2:" + "lab3:" + "midTerm:"
				+ "finalExam:";
		 predictOutput = predictOutput + "�нT�{���:\r\n"+ "�s�ϥΪ�ID\t"+"995002016\r\n"+"�s�W��\t\t"+"Alex\r\n"+"lab1\t\t"
				 + 60 + "\r\nlab2\t\t"
				 + 85 + "\r\nlab3\t\t"
				 + 70 + "\r\nmid-term\t"
				 + 90 + "\r\nfinal exam\t"
				 + 100 + "\r\n";
		predictOutput = predictOutput + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
	}
}
