package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import gradeSystem.GradeSystems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestContainsID {
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
		final ByteArrayInputStream inContent = new ByteArrayInputStream(
				"Q".getBytes());
		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		gradeSystems = new GradeSystems();
	}

	@After
	public void tearDown() throws Exception {
	}
	/** ----------------------------------------------------------------------------------------------------------------------
	TestContainsID 
	case 1: ID=899999999¡AInvalid ID
	case 2: ID=900000000¡ANo ID
	case 3: ID=900000001¡ANo ID
	case 4: ID=962001044¡APass
	case 5: ID=999999998¡ANo ID
	case 6: ID=999999999¡ANo ID
	case 7: ID=1000000000¡AInvalid ID
	------------------------------------------------------------------------------------------------------------------------- */

	@Test
	public void boundaryTest() {
		assertEquals(false, gradeSystems.containsID("899999999"));
		String predictOutput = "Invalid ID\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(false, gradeSystems.containsID("900000000"));
		predictOutput = predictOutput + "No ID\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(false, gradeSystems.containsID("900000001"));
		predictOutput = predictOutput + "No ID\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(true, gradeSystems.containsID("962001044"));
		predictOutput = predictOutput + "Pass\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(false, gradeSystems.containsID("999999998"));
		predictOutput = predictOutput + "No ID\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(false, gradeSystems.containsID("999999999"));
		predictOutput = predictOutput + "No ID\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(false, gradeSystems.containsID("1000000000"));
		predictOutput = predictOutput + "Invalid ID\r\n";
		assertEquals(predictOutput, outContent.toString());
	}
	/** ----------------------------------------------------------------------------------------------------------------------
	TestContainsID 
	case 1: ID=899999999¡AInvalid ID
	case 2: ID=900000001¡ANo ID
	case 3: ID=962001044¡APass
	case 4: ID=1000000000¡AInvalid ID
	------------------------------------------------------------------------------------------------------------------------- */

	@Test
	public void equivalentClassTest() {
		assertEquals(false, gradeSystems.containsID("899999999"));
		String predictOutput = "Invalid ID\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(false, gradeSystems.containsID("900000001"));
		predictOutput = predictOutput + "No ID\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(true, gradeSystems.containsID("962001044"));
		predictOutput = predictOutput + "Pass\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(false, gradeSystems.containsID("1000000000"));
		predictOutput = predictOutput + "Invalid ID\r\n";
		assertEquals(predictOutput, outContent.toString());
	}
	/** ----------------------------------------------------------------------------------------------------------------------
	TestContainsID 
	case 1: ID=899999999¡AInvalid ID
	case 2: ID=900000000¡ANo ID
	case 3: ID=900000001¡ANo ID
	case 4: ID=962001044¡APass
	case 5: ID=999999998¡ANo ID
	case 6: ID=999999999¡ANo ID
	case 7: ID=1000000000¡AInvalid ID
	------------------------------------------------------------------------------------------------------------------------- */

	@Test
	public void edgeTest() {
		assertEquals(false, gradeSystems.containsID("899999999"));
		String predictOutput = "Invalid ID\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(false, gradeSystems.containsID("900000000"));
		predictOutput = predictOutput + "No ID\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(false, gradeSystems.containsID("900000001"));
		predictOutput = predictOutput + "No ID\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(true, gradeSystems.containsID("962001044"));
		predictOutput = predictOutput + "Pass\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(false, gradeSystems.containsID("999999998"));
		predictOutput = predictOutput + "No ID\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(false, gradeSystems.containsID("999999999"));
		predictOutput = predictOutput + "No ID\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(false, gradeSystems.containsID("1000000000"));
		predictOutput = predictOutput + "Invalid ID\r\n";
		assertEquals(predictOutput, outContent.toString());
	}
	/** ----------------------------------------------------------------------------------------------------------------------
	TestContainsID 
	case 1: ID=900000001¡ANo ID
	case 2: ID=962001044¡APass
	------------------------------------------------------------------------------------------------------------------------- */

	@Test
	public void decisionTableTest() {
		assertEquals(false, gradeSystems.containsID("900000001"));
		String predictOutput = "No ID\r\n";
		assertEquals(predictOutput, outContent.toString());
		assertEquals(true, gradeSystems.containsID("962001044"));
		predictOutput = predictOutput + "Pass\r\n";
		assertEquals(predictOutput, outContent.toString());
	}
}
