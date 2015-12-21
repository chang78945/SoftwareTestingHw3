package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import exception.NoSuchIDExceptions;
import gradeSystem.GradeSystems;
import gradeSystem.UI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCheckID_C1C2 {

	/**
	 * @uml.property  name="aUI"
	 * @uml.associationEnd  
	 */
	final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	UI aUI = null;

	@Before
	public void setUp() throws Exception {
		final ByteArrayInputStream inContent = new ByteArrayInputStream(
				"Q".getBytes());
		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		aUI = new UI();
	}

	@After
	public void tearDown() throws Exception {
	}
	/** ----------------------------------------------------------------------------------------------------------------------
	TestCheckID 
	case 1: ID=899999999，Invalid ID
	case 2: ID=962001044，Pass
	case 3: ID=999999999，No ID
	------------------------------------------------------------------------------------------------------------------------- */

	@Test
	public void C1C2Test() {
		String predictOutput = "輸入ID或 Q (結束使用)? "+"結束了.\r\n";
		assertEquals(false, aUI.checkID("899999999"));
		predictOutput = predictOutput + "Invalid ID\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(true, aUI.checkID("962001044"));
		predictOutput = predictOutput + "Pass\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(false, aUI.checkID("999999999"));
		predictOutput = predictOutput + "No ID\r\n";
		assertEquals(predictOutput, outContent.toString());
	}
}