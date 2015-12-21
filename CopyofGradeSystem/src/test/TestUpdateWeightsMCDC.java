package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import gradeSystem.GradeSystems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUpdateWeightsMCDC {
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
	TestUpdateWeights 
	case 1: lab1weight:20�Alab2weight:20�Alab3weight:10�AmidTermweight:20�AfinalExamweight:30�A�T�{�ק�t��(Y)
	case 2: lab1weight:30�Alab2weight:30�Alab3weight:30�AmidTermweight:30�AfinalExamweight:30�A�T�{�ק�t��(Y)
	case 3: lab1weight:20�Alab2weight:20�Alab3weight:10�AmidTermweight:20�AfinalExamweight:30�A���ק�t��(N)
	------------------------------------------------------------------------------------------------------------------------- */
	//�ݭק�source code
	@Test
	public void test() {
		final ByteArrayInputStream inContent = new ByteArrayInputStream(
				"20 20 10 20 30 ".getBytes());
		System.setIn(inContent);
		gradeSystems.updateWeights();
		String predictOutput = "";
		 predictOutput = predictOutput+"�°t��\r\n" + "lab1\t\t"
		 + 0.1 * 100 + "%\r\nlab2\t\t"
		 + 0.1 * 100 + "%\r\nlab3\t\t"
		 + 0.2 * 100 + "%\r\nmid-term\t"
		 + 0.3 * 100 + "%\r\nfinal exam\t"
		 + 0.3 * 100 + "%\r\n";
		 predictOutput = predictOutput + "�s�t��\r\n" + "lab1\t\t" + "lab2\t\t"
		 + "lab3\t\t" + "mid-term\t" + "final exam\t";
		 predictOutput = predictOutput + "�нT�{�s�t��\r\n" + "lab1\t\t"
		 + 20 + "%\r\nlab2\t\t"
		 + 20 + "%\r\nlab3\t\t"
		 + 10 + "%\r\nmid-term\t"
		 + 20 + "%\r\nfinal exam\t"
		 + 30 + "%\r\n";
		 
		predictOutput = predictOutput + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

	}

	@Test
	public void test2() {
		final ByteArrayInputStream inContent = new ByteArrayInputStream(
				"30 30 30 30 30 ".getBytes());
		System.setIn(inContent);
		gradeSystems.updateWeights();
		String predictOutput = "";
		 predictOutput = predictOutput+"�°t��\r\n" + "lab1\t\t"
		 + 0.1 * 100 + "%\r\nlab2\t\t"
		 + 0.1 * 100 + "%\r\nlab3\t\t"
		 + 0.2 * 100 + "%\r\nmid-term\t"
		 + 0.3 * 100 + "%\r\nfinal exam\t"
		 + 0.3 * 100 + "%\r\n";
		 predictOutput = predictOutput + "�s�t��\r\n" + "lab1\t\t" + "lab2\t\t"
		 + "lab3\t\t" + "mid-term\t" + "final exam\t";
		 predictOutput = predictOutput + "�нT�{�s�t��\r\n" + "lab1\t\t"
		 + 30 + "%\r\nlab2\t\t"
		 + 30 + "%\r\nlab3\t\t"
		 + 30 + "%\r\nmid-term\t"
		 + 30 + "%\r\nfinal exam\t"
		 + 30 + "%\r\n";
		 
		predictOutput = predictOutput + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

	}
	@Test
	public void test3() {
		final ByteArrayInputStream inContent = new ByteArrayInputStream(
				"20 20 10 20 30 ".getBytes());
		System.setIn(inContent);
		gradeSystems.updateWeights();
		String predictOutput = "";
		 predictOutput = predictOutput+"�°t��\r\n" + "lab1\t\t"
		 + 0.1 * 100 + "%\r\nlab2\t\t"
		 + 0.1 * 100 + "%\r\nlab3\t\t"
		 + 0.2 * 100 + "%\r\nmid-term\t"
		 + 0.3 * 100 + "%\r\nfinal exam\t"
		 + 0.3 * 100 + "%\r\n";
		 predictOutput = predictOutput + "�s�t��\r\n" + "lab1\t\t" + "lab2\t\t"
		 + "lab3\t\t" + "mid-term\t" + "final exam\t";
		 predictOutput = predictOutput + "�нT�{�s�t��\r\n" + "lab1\t\t"
		 + 20 + "%\r\nlab2\t\t"
		 + 20 + "%\r\nlab3\t\t"
		 + 10 + "%\r\nmid-term\t"
		 + 20 + "%\r\nfinal exam\t"
		 + 30 + "%\r\n";
		 
		predictOutput = predictOutput + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

	}
}
