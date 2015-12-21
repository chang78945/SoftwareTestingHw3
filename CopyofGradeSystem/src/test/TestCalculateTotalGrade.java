package test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import gradeSystem.Grades;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestCalculateTotalGrade {
	/**
	 * @uml.property  name="outContent"
	 */
	final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	/**
	 * @uml.property  name="grades"
	 * @uml.associationEnd  
	 */
	Grades grades;
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		grades = null;

	}

	@After
	public void tearDown() throws Exception {
	}
	/** ----------------------------------------------------------------------------------------------------------------------
	0 <= lab1weight <= 0.3
	0 <= lab2weight <= 0.3
	0 <= lab3weight <= 0.3
	0 <= midTermweight <= 0.3
	0 <= finalExamweight <= 0.3
	
	testCalculateTotalGrade 
	lab1 87  lab2 86  lab3 98  midTerm 88 finalExam 87
	case 1: 
	lab1weight -0.05  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 2: 
	lab1weight 0  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 3: 
	lab1weight 0.5  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 4: 
	lab1weight 1.5  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 5: 
	lab1weight 2.5  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 6: 
	lab1weight 3  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 7: 
	lab1weight 3.5  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 8: 
	lab1weight 0.2  lab2weight -0.05  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
		.
		.
		.
	case 34: 
	lab1weight 0.2  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.3
	case 35: 
	lab1weight 0.2  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.35
	------------------------------------------------------------------------------------------------------------------------- */

	@Test
	public void boundaryTest() {
		Grades grades = new Grades();
		grades.setLab1(87);
		grades.setLab2(86);
		grades.setLab3(98);
		grades.setMidTerm(88);
		grades.setFinalExam(87);
		
		grades.calculateTotalGrade(-0.05, 0.2, 0.2, 0.2, 0.2);
		String predictOutput = "";
		predictOutput = predictOutput+"lab1Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0, 0.2, 0.2, 0.2, 0.2);
		assertEquals(72, grades.getTotalGrade());	
		
		grades.calculateTotalGrade(0.05, 0.2, 0.2, 0.2, 0.2);
		assertEquals(76, grades.getTotalGrade());	
		
		grades.calculateTotalGrade(0.15, 0.2, 0.2, 0.2, 0.2);
		assertEquals(85, grades.getTotalGrade());	
		
		grades.calculateTotalGrade(0.25, 0.2, 0.2, 0.2, 0.2);
		assertEquals(94, grades.getTotalGrade());	
		
		grades.calculateTotalGrade(0.3, 0.2, 0.2, 0.2, 0.2);
		assertEquals(98, grades.getTotalGrade());	
		
		grades.calculateTotalGrade(0.35, 0.2, 0.2, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.05, 0.2, 0.2, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0, 0.2, 0.2, 0.2);
		assertEquals(72, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.05, 0.2, 0.2, 0.2);
		assertEquals(76, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.15, 0.2, 0.2, 0.2);
		assertEquals(85, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.25, 0.2, 0.2, 0.2);
		assertEquals(94, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.3, 0.2, 0.2, 0.2);
		assertEquals(98, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.35, 0.2, 0.2, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, -0.05, 0.2, 0.2);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0, 0.2, 0.2);
		assertEquals(70, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.2, 0.05, 0.2, 0.2);
		assertEquals(75, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.2, 0.15, 0.2, 0.2);
		assertEquals(84, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.2, 0.25, 0.2, 0.2);
		assertEquals(94, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.2, 0.3, 0.2, 0.2);
		assertEquals(99, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.2, 0.35, 0.2, 0.2);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.2, -0.05, 0.2);
		predictOutput = predictOutput+"midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0, 0.2);
		assertEquals(72, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.05, 0.2);
		assertEquals(76, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.15, 0.2);
		assertEquals(85, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.25, 0.2);
		assertEquals(94, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.3, 0.2);
		assertEquals(98, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.35, 0.2);
		predictOutput = predictOutput+"midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.2, -0.05);
		predictOutput = predictOutput+"finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.2, 0);
		assertEquals(72, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.2, 0.05);
		assertEquals(76, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.2, 0.15);
		assertEquals(85, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.2, 0.25);
		assertEquals(94, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.2, 0.3);
		assertEquals(98, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.2, 0.35);
		predictOutput = predictOutput+"finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
	}
	/** ----------------------------------------------------------------------------------------------------------------------
	testCalculateTotalGrade 
	lab1 87  lab2 86  lab3 98  midTerm 88 finalExam 87
	case 1: 
	lab1weight 0.2  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 2: 
	lab1weight -0.05  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 3: 
	lab1weight 0.2  lab2weight -0.05  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 4: 
	lab1weight 0.2  lab2weight 0.2  lab3weight -0.05  midTermweight 0.2  finalExamweight 0.2
	case 5: 
	lab1weight 0.2  lab2weight 0.2  lab3weight 0.2  midTermweight -0.05  finalExamweight 0.2
	case 6: 
	lab1weight 0.2  lab2weight 0.2  lab3weight -0.05  midTermweight 0.2  finalExamweight 0.2
	case 7: 
	lab1weight 0.2  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight -0.05
	case 8: 
	lab1weight -0.05  lab2weight -0.05  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 9: 
	lab1weight -0.05  lab2weight 0.2  lab3weight -0.05  midTermweight 0.2  finalExamweight 0.2
		.
		.
		.
	------------------------------------------------------------------------------------------------------------------------- */
	@Test
	public void equivalentClassTest() {
		Grades grades = new Grades();
		grades.setLab1(87);
		grades.setLab2(86);
		grades.setLab3(98);
		grades.setMidTerm(88);
		grades.setFinalExam(87);

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.2, 0.2);
		assertEquals(89, grades.getTotalGrade());	

		
		grades.calculateTotalGrade(-0.1, 0.2, 0.2, 0.2, 0.2);
		String predictOutput = "";
		predictOutput = predictOutput+"lab1Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, -0.1, 0.2, 0.2, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, -0.1, 0.2, 0.2);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.2, -0.1, 0.2);
		predictOutput = predictOutput+"midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.2, -0.1);
		predictOutput = predictOutput+"finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.1, -0.1, 0.2, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.1, 0.2, -0.1, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.1, 0.2, 0.2, -0.1, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.1, 0.2, 0.2, 0.2, -0.1);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.1, -0.1, 0.2, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.1, 0.2, -0.1, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.1, 0.2, 0.2, -0.1);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.2, -0.1, -0.1, 0.2);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.2, 0.2, -0.1, -0.1);
		predictOutput = predictOutput+"midTermWeight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.1, -0.1, -0.1, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.1, -0.1, 0.2, -0.1, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.1, -0.1, 0.2, 0.2, -0.1);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.1, -0.1, -0.1, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.1, -0.1, 0.2, -0.1);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.2, -0.1, -0.1, -0.1);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.1, -0.1, -0.1, -0.1, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.1, -0.1, -0.1, 0.2, -0.1);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.1, -0.1, -0.1, -0.1, -0.1);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.4, 0.2, 0.2, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.4, 0.2, 0.2, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.4, 0.2, 0.2);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.4, 0.2);
		predictOutput = predictOutput+"midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.2, 0.4);
		predictOutput = predictOutput+"finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.4, 0.4, 0.2, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.4, 0.2, 0.4, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.4, 0.2, 0.2, 0.4, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.4, 0.2, 0.2, 0.2, 0.4);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.4, 0.4, 0.2, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.4, 0.2, 0.4, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.4, 0.2, 0.2, 0.4);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.2, 0.4, 0.4, 0.2);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.4, 0.4);
		predictOutput = predictOutput+"midTermWeight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.4, 0.4, 0.4, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.4, 0.4, 0.2, 0.4, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.4, 0.4, 0.2, 0.2, 0.4);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.4, 0.4, 0.4, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.4, 0.4, 0.2, 0.4);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.2, 0.4, 0.4, 0.4);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.4, 0.4, 0.4, 0.4, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.4, 0.4, 0.4, 0.2, 0.4);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(3.5, 3.5, 3.5, 3.5, 3.5);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
	}

	/** ----------------------------------------------------------------------------------------------------------------------
	testCalculateTotalGrade 
	lab1 87  lab2 86  lab3 98  midTerm 88 finalExam 87
	case 1: 
	lab1weight 0  lab2weight 0  lab3weight 0  midTermweight 0  finalExamweight 0
	case 2: 
	lab1weight 0.05  lab2weight 0.05  lab3weight 0.05  midTermweight 0.05  finalExamweight 0.05
	case 3: 
	lab1weight 0.15  lab2weight 0.15  lab3weight 0.15  midTermweight 0.15  finalExamweight 0.15
	case 4: 
	lab1weight 0.25  lab2weight 0.25  lab3weight 0.25  midTermweight 0.25  finalExamweight 0.25
	case 5: 
	lab1weight 0.3  lab2weight 0.3  lab3weight 0.3  midTermweight 0.3  finalExamweight 0.3
	case 6: 
	lab1weight -0.05  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 7: 
	lab1weight 0.2  lab2weight -0.05  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 8: 
	lab1weight 0.2  lab2weight 0.2  lab3weight -0.05  midTermweight 0.2  finalExamweight 0.2
	case 9: 
	lab1weight 0.2  lab2weight 0.2  lab3weight 0.2  midTermweight -0.05  finalExamweight 0.2
	case 10: 
	lab1weight 0.2  lab2weight 0.2  lab3weight -0.05  midTermweight 0.2  finalExamweight 0.2
	case 11: 
	lab1weight 0.2  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight -0.05
	case 12: 
	lab1weight -0.05  lab2weight -0.05  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 13: 
	lab1weight -0.05  lab2weight 0.2  lab3weight -0.05  midTermweight 0.2  finalExamweight 0.2
		.
		.
		.	
	------------------------------------------------------------------------------------------------------------------------- */

	@Test
	public void edgeTest() {
		Grades grades = new Grades();
		grades.setLab1(87);
		grades.setLab2(86);
		grades.setLab3(98);
		grades.setMidTerm(88);
		grades.setFinalExam(87);

		grades.calculateTotalGrade(0, 0, 0, 0, 0);
		assertEquals(0, grades.getTotalGrade());	

		grades.calculateTotalGrade(0.05, 0.05, 0.05, 0.05, 0.05);
		assertEquals(22, grades.getTotalGrade());

		grades.calculateTotalGrade(0.15, 0.15, 0.15, 0.15, 0.15);
		assertEquals(67, grades.getTotalGrade());

		grades.calculateTotalGrade(0.25, 0.25, 0.25, 0.25, 0.25);
		assertEquals(100, grades.getTotalGrade());

		grades.calculateTotalGrade(0.3, 0.3, 0.3, 0.3, 0.3);
		assertEquals(100, grades.getTotalGrade());
		
		grades.calculateTotalGrade(-0.05, 0.2, 0.2, 0.2, 0.2);
		String predictOutput = "";
		predictOutput = predictOutput+"lab1Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, -0.05, 0.2, 0.2, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, -0.05, 0.2, 0.2);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.2, -0.05, 0.2);
		predictOutput = predictOutput+"midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.2, -0.05);
		predictOutput = predictOutput+"finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, -0.05, 0.2, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, 0.2, -0.05, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, 0.2, 0.2, -0.05, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, 0.2, 0.2, 0.2, -0.05);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.05, -0.05, 0.2, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.05, 0.2, -0.05, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.05, 0.2, 0.2, -0.05);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.2, -0.05, -0.05, 0.2);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.2, 0.2, -0.05, -0.05);
		predictOutput = predictOutput+"midTermWeight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, -0.05, -0.05, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, -0.05, 0.2, -0.05, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, -0.05, 0.2, 0.2, -0.05);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.05, -0.05, -0.05, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.05, -0.05, 0.2, -0.05);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.2, -0.05, -0.05, -0.05);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, -0.05, -0.05, -0.05, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, -0.05, -0.05, 0.2, -0.05);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, -0.05, -0.05, -0.05, -0.05);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.35, 0.2, 0.2, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.35, 0.2, 0.2, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.35, 0.2, 0.2);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.35, 0.2);
		predictOutput = predictOutput+"midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.2, 0.35);
		predictOutput = predictOutput+"finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.35, 0.35, 0.2, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.35, 0.2, 0.35, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.35, 0.2, 0.2, 0.35, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.35, 0.2, 0.2, 0.2, 0.35);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.35, 0.35, 0.2, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.35, 0.2, 0.35, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.35, 0.2, 0.2, 0.35);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.2, 0.35, 0.35, 0.2);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.35, 0.35);
		predictOutput = predictOutput+"midTermWeight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.35, 0.35, 0.35, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.35, 0.35, 0.2, 0.35, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.35, 0.35, 0.2, 0.2, 0.35);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.35, 0.35, 0.35, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.35, 0.35, 0.2, 0.35);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.2, 0.35, 0.35, 0.35);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.35, 0.35, 0.35, 0.35, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.35, 0.35, 0.35, 0.2, 0.35);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(3.5, 3.5, 3.5, 3.5, 3.5);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
	}

	/** ----------------------------------------------------------------------------------------------------------------------
	testCalculateTotalGrade 
	lab1 87  lab2 86  lab3 98  midTerm 88 finalExam 87
	case 1: 
	lab1weight 0.2  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 2: 
	lab1weight -0.05  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 3: 
	lab1weight 0.2  lab2weight -0.05  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 4: 
	lab1weight 0.2  lab2weight 0.2  lab3weight -0.05  midTermweight 0.2  finalExamweight 0.2
	case 5: 
	lab1weight 0.2  lab2weight 0.2  lab3weight 0.2  midTermweight -0.05  finalExamweight 0.2
	case 6: 
	lab1weight 0.2  lab2weight 0.2  lab3weight -0.05  midTermweight 0.2  finalExamweight 0.2
	case 7: 
	lab1weight 0.2  lab2weight 0.2  lab3weight 0.2  midTermweight 0.2  finalExamweight -0.05
	case 8: 
	lab1weight -0.05  lab2weight -0.05  lab3weight 0.2  midTermweight 0.2  finalExamweight 0.2
	case 9: 
	lab1weight -0.05  lab2weight 0.2  lab3weight -0.05  midTermweight 0.2  finalExamweight 0.2
		.
		.
		.
	------------------------------------------------------------------------------------------------------------------------- */

	@Test
	public void decisionTableTest() {
		Grades grades = new Grades();
		grades.setLab1(87);
		grades.setLab2(86);
		grades.setLab3(98);
		grades.setMidTerm(88);
		grades.setFinalExam(87);

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.2, 0.2);
		assertEquals(89, grades.getTotalGrade());	
		
		grades.calculateTotalGrade(-0.05, 0.2, 0.2, 0.2, 0.2);
		String predictOutput = "";
		predictOutput = predictOutput+"lab1Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, -0.05, 0.2, 0.2, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, -0.05, 0.2, 0.2);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.2, -0.05, 0.2);
		predictOutput = predictOutput+"midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());

		grades.calculateTotalGrade(0.2, 0.2, 0.2, 0.2, -0.05);
		predictOutput = predictOutput+"finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, -0.05, 0.2, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, 0.2, -0.05, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, 0.2, 0.2, -0.05, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, 0.2, 0.2, 0.2, -0.05);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.05, -0.05, 0.2, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.05, 0.2, -0.05, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.05, 0.2, 0.2, -0.05);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.2, -0.05, -0.05, 0.2);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.2, 0.2, -0.05, -0.05);
		predictOutput = predictOutput+"midTermWeight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, -0.05, -0.05, 0.2, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, -0.05, 0.2, -0.05, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, -0.05, 0.2, 0.2, -0.05);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.05, -0.05, -0.05, 0.2);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, -0.05, -0.05, 0.2, -0.05);
		predictOutput = predictOutput+"lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(0.2, 0.2, -0.05, -0.05, -0.05);
		predictOutput = predictOutput+"lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, -0.05, -0.05, -0.05, 0.2);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, -0.05, -0.05, 0.2, -0.05);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		grades.calculateTotalGrade(-0.05, -0.05, -0.05, -0.05, -0.05);
		predictOutput = predictOutput+"lab1Weight is out of range\r\n"
				+ "lab2Weight is out of range\r\n"
				+ "lab3Weight is out of range\r\n"
				+ "midTermWeight is out of range\r\n"
				+ "finalExamWeight is out of range\r\n";
		assertEquals(predictOutput, outContent.toString());
	}
}
