package test;

import static org.junit.Assert.*;
import exception.NoSuchCommandExceptions;
import gradeSystem.UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPromptCommandC1C2 {

	/**
	 * @uml.property  name="outContent"
	 */
	final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	/**
	 * @uml.property  name="aUI"
	 * @uml.associationEnd  
	 */
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
	TestPromptCommand 
	case 1: setUserID:962001044，指令:G
	case 2: setUserID:962001044，指令:E
	case 3: setUserID:962001044，指令:R
	case 4: setUserID:962001044，指令:I
	case 5: setUserID:962001044，指令:D
	case 6: setUserID:962001044，指令:W
	case 7: setUserID:962001044，指令:A
	------------------------------------------------------------------------------------------------------------------------- */
	//要去改source code
	@Test
	public void testG() throws NoSuchCommandExceptions {
		aUI.setUserID("962001044");
		ByteArrayInputStream inContent = new ByteArrayInputStream(
				"G".getBytes());
		System.setIn(inContent);
		String predictOutput = "輸入ID或 Q (結束使用)? "+"結束了.\r\n";
		predictOutput = predictOutput+"凌宗廷成績:\tlab1:\t\t87\r\n\t\t"
				+ "lab2:\t\t86\r\n" + "\t\t" + "lab3:\t\t98\r\n" + "\t\t"
				+ "mid-term:\t88" + "\r\n\t\t" + "final exam:\t87" + "\r\n\t\t"
				+ "total grade:\t89\r\n";
		aUI.promptCommand();
		assertEquals(predictOutput, outContent.toString());

		aUI.setUserID("899999999");
		inContent = new ByteArrayInputStream("G".getBytes());
		System.setIn(inContent);
		predictOutput = predictOutput + "此ID不在資料庫\r\n";
		aUI.promptCommand();
		assertEquals(predictOutput, outContent.toString());
	}

	@Test
	public void testE() throws NoSuchCommandExceptions {
		aUI.setUserID("962001044");
		ByteArrayInputStream inContent = new ByteArrayInputStream(
				"E".getBytes());
		System.setIn(inContent);
		String predictOutput = "輸入ID或 Q (結束使用)? "+"結束了.\r\n";
		aUI.promptCommand();
		assertEquals(predictOutput, outContent.toString());
	} 
	@Test
	public void testR() throws NoSuchCommandExceptions {
		aUI.setUserID("962001044");
		ByteArrayInputStream inContent = new ByteArrayInputStream(
				"R".getBytes());
		System.setIn(inContent);
		String predictOutput = "輸入ID或 Q (結束使用)? "+"結束了.\r\n";
		predictOutput = predictOutput+"凌宗廷排名第34\r\n" ;
		aUI.promptCommand();
		assertEquals(predictOutput, outContent.toString());

		aUI.setUserID("899999999");
		inContent = new ByteArrayInputStream("R".getBytes());
		System.setIn(inContent);
		predictOutput = predictOutput + "此ID不在資料庫\r\n";
		aUI.promptCommand();
		assertEquals(predictOutput, outContent.toString());
	} 

	@Test
	public void testI() throws NoSuchCommandExceptions {//改了source code
		aUI.setUserID("962001044");
		ByteArrayInputStream inContent = new ByteArrayInputStream(
				"I".getBytes());
		System.setIn(inContent);
		String predictOutput = "輸入ID或 Q (結束使用)? "+"結束了.\r\n";
		aUI.promptCommand();
		predictOutput = predictOutput + "Student ID:" + "Student Name:"
				+ "lab1:" + "lab2:" + "lab3:" + "midTerm:"
				+ "finalExam:";
		assertEquals(predictOutput, outContent.toString());
	} 
	@Test
	public void testD() throws NoSuchCommandExceptions {//改了source code
		aUI.setUserID("962001044");
		ByteArrayInputStream inContent = new ByteArrayInputStream(
				"D 899999999".getBytes());
		System.setIn(inContent);
		String predictOutput = "輸入ID或 Q (結束使用)? "+"結束了.\r\n";
		predictOutput = predictOutput+"此ID不在資料庫\r\n" ;
		aUI.promptCommand();
		assertEquals(predictOutput, outContent.toString());

		aUI.setUserID("962001044");
		inContent = new ByteArrayInputStream("D 962001044".getBytes());
		System.setIn(inContent);
		predictOutput = predictOutput + "不能刪除自己!\r\n";
		aUI.promptCommand();
		assertEquals(predictOutput, outContent.toString());

		aUI.setUserID("962001044");
		inContent = new ByteArrayInputStream("D 975002501".getBytes());
		System.setIn(inContent);
		predictOutput = predictOutput + "以上正確嗎? Y (Yes) 或 N (No)\r\n";
		aUI.promptCommand();
		assertEquals(predictOutput, outContent.toString());
	} 

	@Test
	public void testW() throws NoSuchCommandExceptions {//改了source code
		aUI.setUserID("962001044");
		ByteArrayInputStream inContent = new ByteArrayInputStream(
				"W".getBytes());
		System.setIn(inContent);
		String predictOutput = "輸入ID或 Q (結束使用)? "+"結束了.\r\n";
		aUI.promptCommand();
		predictOutput = predictOutput+"舊配分\r\n" + "lab1\t\t"
		 + 0.1 * 100 + "%\r\nlab2\t\t"
		 + 0.1 * 100 + "%\r\nlab3\t\t"
		 + 0.2 * 100 + "%\r\nmid-term\t"
		 + 0.3 * 100 + "%\r\nfinal exam\t"
		 + 0.3 * 100 + "%\r\n";
		assertEquals(predictOutput, outContent.toString());
	} 
	
	@Test
	public void testA() throws NoSuchCommandExceptions {//改了source code
		aUI.setUserID("962001044");
		ByteArrayInputStream inContent = new ByteArrayInputStream(
				"A".getBytes());
		System.setIn(inContent);
		String predictOutput = "輸入ID或 Q (結束使用)? "+"結束了.\r\n";
		aUI.promptCommand();
		predictOutput = predictOutput+"指令錯誤!\r\n";
		assertEquals(predictOutput, outContent.toString());
	} 
}
