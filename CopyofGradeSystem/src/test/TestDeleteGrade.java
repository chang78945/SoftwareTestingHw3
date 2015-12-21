package test;

import static org.junit.Assert.*;
import gradeSystem.GradeSystems;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDeleteGrade {
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
	//����source code
	/** ----------------------------------------------------------------------------------------------------------------------
	TestDeleteGrade 
	case 1: UserID=899999999 �A���R��ID=899999999�A��ID���b��Ʈw
	case 2: UserID=899999999 �A���R��ID=955002056�A��ID���b��Ʈw
	case 3: UserID=899999999 �A���R��ID=962001044�A��ID���b��Ʈw
	case 4: UserID=899999999 �A���R��ID=975002501�A��ID���b��Ʈw
	case 5: UserID=899999999 �A���R��ID=986002026�A��ID���b��Ʈw
	case 6: UserID=899999999 �A���R��ID=995002901�A��ID���b��Ʈw
	case 7: UserID=899999999 �A���R��ID=1000000000�A��ID���b��Ʈw
	case 8: UserID=955002056 �A���R��ID=899999999�A�T�{�R��(Y)
	case 9: UserID=955002056 �A���R��ID=955002056�A����R���ۤv
	case 10: UserID=955002056 �A���R��ID=962001044�A�T�{�R��(Y)
	case 11: UserID=955002056 �A���R��ID=975002501�A�T�{�R��(Y)
	case 12: UserID=955002056 �A���R��ID=986002026�A�T�{�R��(Y)
	case 13: UserID=955002056 �A���R��ID=995002901�A�T�{�R��(Y)
	case 14: UserID=955002056 �A���R��ID=1000000000�A�T�{�R��(Y)
	case 15: UserID=955002056 �A���R��ID=899999999�A�T�{�R��(Y)
	case 16: UserID=955002056 �A���R��ID=962001044�A�T�{�R��(Y)
	case 17: UserID=955002056 �A���R��ID=975002501�A�T�{�R��(Y)
	case 18: UserID=955002056 �A���R��ID=986002026�A�T�{�R��(Y)
	case 19: UserID=955002056 �A���R��ID=995002901�A�T�{�R��(Y)
	case 20: UserID=955002056 �A���R��ID=1000000000�A�T�{�R��(Y)
		.
		.
		.
	------------------------------------------------------------------------------------------------------------------------- */

	@Test
	public void boundaryTest() {
		/*ByteArrayInputStream inContent = new ByteArrayInputStream("899999999".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		String predictOutput = "";
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("899999999".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("899999999".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("899999999".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("899999999".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("899999999".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("899999999".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("955002056 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("955002056".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "����R���ۤv!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("955002056 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("955002056 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("955002056 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("962001044 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("962001044 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "����R���ۤv!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("962001044 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("962001044 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("962001044 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "����R���ۤv!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("986002026 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("986002026 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "����R���ۤv!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("986002026 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("986002026 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("986002026 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("995002901 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("995002901 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "����R���ۤv!\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("995002901 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("995002901 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("995002901 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());*/
	}

	/** ----------------------------------------------------------------------------------------------------------------------
	TestDeleteGrade 
	case 1: UserID=800000000 �A���R��ID=800000000�A��ID���b��Ʈw
	case 2: UserID=975002501 �A���R��ID=955002056�A�T�{�R��(Y)
	case 3: UserID=975002501 �A���R��ID=975002501�A����R���ۤv
	case 4: UserID=975002501 �A���R��ID=955002056�A���R��(N)
	case 5: UserID=1111111111 �A���R��ID=1111111111�A��ID���b��Ʈw
	------------------------------------------------------------------------------------------------------------------------- */

	@Test
	public void equivalentClassTest() {
		/*ByteArrayInputStream inContent = new ByteArrayInputStream("800000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("800000000");
		String predictOutput = "";
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "����R���ۤv!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1111111111".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1111111111");
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());*/
	}

	/** ----------------------------------------------------------------------------------------------------------------------
	TestDeleteGrade 
	case 1: UserID=899999999 �A���R��ID=899999999�A��ID���b��Ʈw
	case 2: UserID=955002056 �A���R��ID=955002056�A����R���ۤv
	case 3: UserID=962001044 �A���R��ID=962001044�A����R���ۤv
	case 4: UserID=975002501 �A���R��ID=975002501�A����R���ۤv
	case 5: UserID=986002026 �A���R��ID=986002026�A����R���ۤv
	case 6: UserID=995002901 �A���R��ID=995002901�A����R���ۤv
	case 7: UserID=962001044 �A���R��ID=955002056�A�T�{�R��(Y)
	case 8: UserID=962001051 �A���R��ID=962001044�A�T�{�R��(Y)
	case 9: UserID=985002001 �A���R��ID=975002501�A�T�{�R��(Y)
	case 10: UserID=985002515 �A���R��ID=986002026�A�T�{�R��(Y)
	case 11: UserID=986002026 �A���R��ID=995002901�A�T�{�R��(Y)
	case 12: UserID=962001044 �A���R��ID=955002056�A�T�{�R��(N)
	case 13: UserID=962001051 �A���R��ID=962001044�A�T�{�R��(N)
	case 14: UserID=985002001 �A���R��ID=975002501�A�T�{�R��(N)
	case 15: UserID=985002515 �A���R��ID=986002026�A�T�{�R��(N)
	case 16: UserID=986002026 �A���R��ID=995002901�A�T�{�R��(N)
	case 17: UserID=1000000000�A���R��ID=1000000000�A��ID���b��Ʈw
	------------------------------------------------------------------------------------------------------------------------- */

	@Test
	public void edgeTest() {
	/*	ByteArrayInputStream inContent = new ByteArrayInputStream("899999999".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		String predictOutput = "";
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("955002056".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "����R���ۤv!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "����R���ۤv!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "����R���ۤv!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "����R���ۤv!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "����R���ۤv!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001051");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("985002001");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("985002515");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001051");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("985002001");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("985002515");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());*/
	}

	/** ----------------------------------------------------------------------------------------------------------------------
	TestDeleteGrade 
	case 1: UserID=800000000 �A���R��ID=800000000�A��ID���b��Ʈw
	case 1: UserID=975002501 �A���R��ID=955002056�A�T�{�R��(Y)
	case 2: UserID=975002501 �A���R��ID=975002501�A����R���ۤv
	case 3: UserID=975002501 �A���R��ID=955002056�A���R��(N)
	------------------------------------------------------------------------------------------------------------------------- */

	@Test
	public void decisionTableTest() {
		/*ByteArrayInputStream inContent = new ByteArrayInputStream("800000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("800000000");
		String predictOutput = "";
		predictOutput = predictOutput+"Student ID:\r\n" + "��ID���b��Ʈw\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "����R���ۤv!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "�H�W���T��? Y (Yes) �� N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());*/
	}
}
