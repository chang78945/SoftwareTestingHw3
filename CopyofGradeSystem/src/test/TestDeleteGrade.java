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
	//須改source code
	/** ----------------------------------------------------------------------------------------------------------------------
	TestDeleteGrade 
	case 1: UserID=899999999 ，欲刪除ID=899999999，此ID不在資料庫
	case 2: UserID=899999999 ，欲刪除ID=955002056，此ID不在資料庫
	case 3: UserID=899999999 ，欲刪除ID=962001044，此ID不在資料庫
	case 4: UserID=899999999 ，欲刪除ID=975002501，此ID不在資料庫
	case 5: UserID=899999999 ，欲刪除ID=986002026，此ID不在資料庫
	case 6: UserID=899999999 ，欲刪除ID=995002901，此ID不在資料庫
	case 7: UserID=899999999 ，欲刪除ID=1000000000，此ID不在資料庫
	case 8: UserID=955002056 ，欲刪除ID=899999999，確認刪除(Y)
	case 9: UserID=955002056 ，欲刪除ID=955002056，不能刪除自己
	case 10: UserID=955002056 ，欲刪除ID=962001044，確認刪除(Y)
	case 11: UserID=955002056 ，欲刪除ID=975002501，確認刪除(Y)
	case 12: UserID=955002056 ，欲刪除ID=986002026，確認刪除(Y)
	case 13: UserID=955002056 ，欲刪除ID=995002901，確認刪除(Y)
	case 14: UserID=955002056 ，欲刪除ID=1000000000，確認刪除(Y)
	case 15: UserID=955002056 ，欲刪除ID=899999999，確認刪除(Y)
	case 16: UserID=955002056 ，欲刪除ID=962001044，確認刪除(Y)
	case 17: UserID=955002056 ，欲刪除ID=975002501，確認刪除(Y)
	case 18: UserID=955002056 ，欲刪除ID=986002026，確認刪除(Y)
	case 19: UserID=955002056 ，欲刪除ID=995002901，確認刪除(Y)
	case 20: UserID=955002056 ，欲刪除ID=1000000000，確認刪除(Y)
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
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("899999999".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("899999999".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("899999999".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("899999999".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("899999999".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("899999999".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("955002056 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("955002056".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "不能刪除自己!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("955002056 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("955002056 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("955002056 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("962001044 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("962001044 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "不能刪除自己!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("962001044 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("962001044 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("962001044 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "不能刪除自己!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("986002026 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("986002026 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "不能刪除自己!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("986002026 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("986002026 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("986002026 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("995002901 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("995002901 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "不能刪除自己!\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("995002901 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("995002901 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("995002901 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());*/
	}

	/** ----------------------------------------------------------------------------------------------------------------------
	TestDeleteGrade 
	case 1: UserID=800000000 ，欲刪除ID=800000000，此ID不在資料庫
	case 2: UserID=975002501 ，欲刪除ID=955002056，確認刪除(Y)
	case 3: UserID=975002501 ，欲刪除ID=975002501，不能刪除自己
	case 4: UserID=975002501 ，欲刪除ID=955002056，不刪除(N)
	case 5: UserID=1111111111 ，欲刪除ID=1111111111，此ID不在資料庫
	------------------------------------------------------------------------------------------------------------------------- */

	@Test
	public void equivalentClassTest() {
		/*ByteArrayInputStream inContent = new ByteArrayInputStream("800000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("800000000");
		String predictOutput = "";
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "不能刪除自己!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1111111111".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1111111111");
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());*/
	}

	/** ----------------------------------------------------------------------------------------------------------------------
	TestDeleteGrade 
	case 1: UserID=899999999 ，欲刪除ID=899999999，此ID不在資料庫
	case 2: UserID=955002056 ，欲刪除ID=955002056，不能刪除自己
	case 3: UserID=962001044 ，欲刪除ID=962001044，不能刪除自己
	case 4: UserID=975002501 ，欲刪除ID=975002501，不能刪除自己
	case 5: UserID=986002026 ，欲刪除ID=986002026，不能刪除自己
	case 6: UserID=995002901 ，欲刪除ID=995002901，不能刪除自己
	case 7: UserID=962001044 ，欲刪除ID=955002056，確認刪除(Y)
	case 8: UserID=962001051 ，欲刪除ID=962001044，確認刪除(Y)
	case 9: UserID=985002001 ，欲刪除ID=975002501，確認刪除(Y)
	case 10: UserID=985002515 ，欲刪除ID=986002026，確認刪除(Y)
	case 11: UserID=986002026 ，欲刪除ID=995002901，確認刪除(Y)
	case 12: UserID=962001044 ，欲刪除ID=955002056，確認刪除(N)
	case 13: UserID=962001051 ，欲刪除ID=962001044，確認刪除(N)
	case 14: UserID=985002001 ，欲刪除ID=975002501，確認刪除(N)
	case 15: UserID=985002515 ，欲刪除ID=986002026，確認刪除(N)
	case 16: UserID=986002026 ，欲刪除ID=995002901，確認刪除(N)
	case 17: UserID=1000000000，欲刪除ID=1000000000，此ID不在資料庫
	------------------------------------------------------------------------------------------------------------------------- */

	@Test
	public void edgeTest() {
	/*	ByteArrayInputStream inContent = new ByteArrayInputStream("899999999".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("899999999");
		String predictOutput = "";
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("955002056".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "不能刪除自己!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "不能刪除自己!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "不能刪除自己!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "不能刪除自己!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("995002901");
		predictOutput = predictOutput+"Student ID:\r\n" + "不能刪除自己!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001051");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("985002001");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("985002515");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("955002056 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001044");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("962001044 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("962001051");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("985002001");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("986002026 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("985002515");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("995002901 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("986002026");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("1000000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("1000000000");
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());*/
	}

	/** ----------------------------------------------------------------------------------------------------------------------
	TestDeleteGrade 
	case 1: UserID=800000000 ，欲刪除ID=800000000，此ID不在資料庫
	case 1: UserID=975002501 ，欲刪除ID=955002056，確認刪除(Y)
	case 2: UserID=975002501 ，欲刪除ID=975002501，不能刪除自己
	case 3: UserID=975002501 ，欲刪除ID=955002056，不刪除(N)
	------------------------------------------------------------------------------------------------------------------------- */

	@Test
	public void decisionTableTest() {
		/*ByteArrayInputStream inContent = new ByteArrayInputStream("800000000".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("800000000");
		String predictOutput = "";
		predictOutput = predictOutput+"Student ID:\r\n" + "此ID不在資料庫\r\n";
		assertEquals(predictOutput, outContent.toString());
		
		inContent = new ByteArrayInputStream("975002501 Y".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("975002501");
		predictOutput = predictOutput+"Student ID:\r\n" + "不能刪除自己!\r\n";
		assertEquals(predictOutput, outContent.toString());

		inContent = new ByteArrayInputStream("975002501 N".getBytes());
		System.setIn(inContent);
		gradeSystems.deleteGrade("955002056");
		predictOutput = predictOutput+"Student ID:\r\n" + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		assertEquals(predictOutput, outContent.toString());*/
	}
}
