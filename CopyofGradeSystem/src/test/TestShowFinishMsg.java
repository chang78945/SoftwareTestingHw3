package test;

import static org.junit.Assert.*;

import gradeSystem.UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestShowFinishMsg {

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
	TestShowFinishMsg 
	case 1: ���տ�X "�����F."
	------------------------------------------------------------------------------------------------------------------------- */
	
	@Test
	public void test() {
		String predictOutput = "��JID�� Q (�����ϥ�)? "+"�����F.\r\n";
		predictOutput=predictOutput+"�����F.\r\n";
		aUI.showFinishMsg();
		assertEquals(predictOutput, outContent.toString());
	}

}
