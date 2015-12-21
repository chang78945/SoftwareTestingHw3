package test;
import static org.junit.Assert.*;

import gradeSystem.GradeSystems;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestShowGrade {

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
		//System.setOut(null);
	}

	/** ----------------------------------------------------------------------------------------------------------------------
	TestShowGrade 
	case 1: ID:899999999
	case 2: ID:955002056
	case 3: ID:962001044
	case 4: ID:975002501
	case 5: ID:986002026
	case 6: ID:995002901
	case 7: ID:1000000000
	------------------------------------------------------------------------------------------------------------------------- */
	
	@Test
	public void boundaryTest() {
		String predictOutput = "此ID不在資料庫\r\n";
		gradeSystems.showGrade("899999999");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "許文馨成績:\tlab1:\t\t88\r\n\t\t"
				+ "lab2:\t\t92\r\n" + "\t\t" + "lab3:\t\t88\r\n" + "\t\t"
				+ "mid-term:\t98" + "\r\n\t\t" + "final exam:\t91" + "\r\n\t\t"
				+ "total grade:\t84\r\n";
		gradeSystems.showGrade("955002056");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "凌宗廷成績:\tlab1:\t\t87\r\n\t\t"
				+ "lab2:\t\t86\r\n" + "\t\t" + "lab3:\t\t98\r\n" + "\t\t"
				+ "mid-term:\t88" + "\r\n\t\t" + "final exam:\t87" + "\r\n\t\t"
				+ "total grade:\t80\r\n";
		gradeSystems.showGrade("962001044");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "張廷瑄成績:\tlab1:\t\t80\r\n\t\t"
				+ "lab2:\t\t86\r\n" + "\t\t" + "lab3:\t\t98\r\n" + "\t\t"
				+ "mid-term:\t94" + "\r\n\t\t" + "final exam:\t87" + "\r\n\t\t"
				+ "total grade:\t81\r\n";
		gradeSystems.showGrade("975002501");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "闕裕柏成績:\tlab1:\t\t90\r\n\t\t"
				+ "lab2:\t\t85\r\n" + "\t\t" + "lab3:\t\t89\r\n" + "\t\t"
				+ "mid-term:\t87" + "\r\n\t\t" + "final exam:\t91" + "\r\n\t\t"
				+ "total grade:\t80\r\n";
		gradeSystems.showGrade("986002026");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "舒晨馨成績:\tlab1:\t\t82\r\n\t\t"
				+ "lab2:\t\t90\r\n" + "\t\t" + "lab3:\t\t85\r\n" + "\t\t"
				+ "mid-term:\t84" + "\r\n\t\t" + "final exam:\t93" + "\r\n\t\t"
				+ "total grade:\t79\r\n";
		gradeSystems.showGrade("995002901");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "此ID不在資料庫\r\n";
		gradeSystems.showGrade("1000000000");
		assertEquals(predictOutput, outContent.toString());
	}

	/** ----------------------------------------------------------------------------------------------------------------------
	TestShowGrade 
	case 1: ID:800000000
	case 2: ID:975002501
	case 3: ID:1111111111
	------------------------------------------------------------------------------------------------------------------------- */
	@Test
	public void equivalentClassTest() {
		String predictOutput = "此ID不在資料庫\r\n";
		gradeSystems.showGrade("800000000");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "張廷瑄成績:\tlab1:\t\t80\r\n\t\t"
				+ "lab2:\t\t86\r\n" + "\t\t" + "lab3:\t\t98\r\n" + "\t\t"
				+ "mid-term:\t94" + "\r\n\t\t" + "final exam:\t87" + "\r\n\t\t"
				+ "total grade:\t81\r\n";
		gradeSystems.showGrade("975002501");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "此ID不在資料庫\r\n";
		gradeSystems.showGrade("1111111111");
		assertEquals(predictOutput, outContent.toString());
	}
	/** ----------------------------------------------------------------------------------------------------------------------
	TestShowGrade 
	case 1: ID:899999999
	case 2: ID:955002056
	case 3: ID:962001044
	case 4: ID:975002501
	case 5: ID:986002026
	case 6: ID:995002901
	case 7: ID:1000000000
	------------------------------------------------------------------------------------------------------------------------- */
	
	@Test
	public void edgeTest() {
		String predictOutput = "此ID不在資料庫\r\n";
		gradeSystems.showGrade("899999999");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "許文馨成績:\tlab1:\t\t88\r\n\t\t"
				+ "lab2:\t\t92\r\n" + "\t\t" + "lab3:\t\t88\r\n" + "\t\t"
				+ "mid-term:\t98" + "\r\n\t\t" + "final exam:\t91" + "\r\n\t\t"
				+ "total grade:\t84\r\n";
		gradeSystems.showGrade("955002056");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "凌宗廷成績:\tlab1:\t\t87\r\n\t\t"
				+ "lab2:\t\t86\r\n" + "\t\t" + "lab3:\t\t98\r\n" + "\t\t"
				+ "mid-term:\t88" + "\r\n\t\t" + "final exam:\t87" + "\r\n\t\t"
				+ "total grade:\t80\r\n";
		gradeSystems.showGrade("962001044");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "張廷瑄成績:\tlab1:\t\t80\r\n\t\t"
				+ "lab2:\t\t86\r\n" + "\t\t" + "lab3:\t\t98\r\n" + "\t\t"
				+ "mid-term:\t94" + "\r\n\t\t" + "final exam:\t87" + "\r\n\t\t"
				+ "total grade:\t81\r\n";
		gradeSystems.showGrade("975002501");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "闕裕柏成績:\tlab1:\t\t90\r\n\t\t"
				+ "lab2:\t\t85\r\n" + "\t\t" + "lab3:\t\t89\r\n" + "\t\t"
				+ "mid-term:\t87" + "\r\n\t\t" + "final exam:\t91" + "\r\n\t\t"
				+ "total grade:\t80\r\n";
		gradeSystems.showGrade("986002026");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "舒晨馨成績:\tlab1:\t\t82\r\n\t\t"
				+ "lab2:\t\t90\r\n" + "\t\t" + "lab3:\t\t85\r\n" + "\t\t"
				+ "mid-term:\t84" + "\r\n\t\t" + "final exam:\t93" + "\r\n\t\t"
				+ "total grade:\t79\r\n";
		gradeSystems.showGrade("995002901");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "此ID不在資料庫\r\n";
		gradeSystems.showGrade("1000000000");
		assertEquals(predictOutput, outContent.toString());
	}

	/** ----------------------------------------------------------------------------------------------------------------------
	TestShowGrade 
	case 1: ID:800000000
	case 2: ID:975002501
	------------------------------------------------------------------------------------------------------------------------- */
	
	@Test
	public void decisionTableTest() {
		String predictOutput = "此ID不在資料庫\r\n";
		gradeSystems.showGrade("800000000");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "張廷瑄成績:\tlab1:\t\t80\r\n\t\t"
				+ "lab2:\t\t86\r\n" + "\t\t" + "lab3:\t\t98\r\n" + "\t\t"
				+ "mid-term:\t94" + "\r\n\t\t" + "final exam:\t87" + "\r\n\t\t"
				+ "total grade:\t81\r\n";
		gradeSystems.showGrade("975002501");
		assertEquals(predictOutput, outContent.toString());
	}
}
