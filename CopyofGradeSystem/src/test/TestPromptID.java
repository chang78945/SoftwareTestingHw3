package test;

import static org.junit.Assert.*;
import gradeSystem.UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPromptID {

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
	TestPromptID 
	case 1: 測試輸出 "輸入ID或 Q (結束使用)? "
	------------------------------------------------------------------------------------------------------------------------- */
	
	@Test
	public void test() {
		String predictOutput = "輸入ID或 Q (結束使用)? "+"結束了.\r\n";
		predictOutput=predictOutput+"輸入ID或 Q (結束使用)? ";
		aUI.promptID();
		assertEquals(predictOutput, outContent.toString());
	}

}
