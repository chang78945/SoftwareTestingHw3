package test;
import static org.junit.Assert.*;

import gradeSystem.GradeSystems;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestShowRank {
	/**
	 * @uml.property  name="outContent"
	 */
	final  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
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
		
		predictOutput = predictOutput + "許文馨排名第4\r\n" ;
		gradeSystems.showRank("955002056");
		assertEquals(predictOutput, outContent.toString());

		predictOutput = predictOutput + "凌宗廷排名第34\r\n" ;
		gradeSystems.showRank("962001044");
		assertEquals(predictOutput, outContent.toString());

		predictOutput = predictOutput + "張廷瑄排名第26\r\n" ;
		gradeSystems.showRank("975002501");
		assertEquals(predictOutput, outContent.toString());

		predictOutput = predictOutput + "闕裕柏排名第34\r\n" ;
		gradeSystems.showRank("986002026");
		assertEquals(predictOutput, outContent.toString());

		predictOutput = predictOutput + "舒晨馨排名第41\r\n" ;
		gradeSystems.showRank("995002901");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "此ID不在資料庫\r\n";
		gradeSystems.showRank("1000000000");
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
		
		predictOutput = predictOutput + "張廷瑄排名第26\r\n" ;
		gradeSystems.showRank("975002501");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "此ID不在資料庫\r\n";
		gradeSystems.showRank("1111111111");
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
		
		predictOutput = predictOutput + "許文馨排名第4\r\n" ;
		gradeSystems.showRank("955002056");
		assertEquals(predictOutput, outContent.toString());

		predictOutput = predictOutput + "凌宗廷排名第34\r\n" ;
		gradeSystems.showRank("962001044");
		assertEquals(predictOutput, outContent.toString());

		predictOutput = predictOutput + "張廷瑄排名第26\r\n" ;
		gradeSystems.showRank("975002501");
		assertEquals(predictOutput, outContent.toString());

		predictOutput = predictOutput + "闕裕柏排名第34\r\n" ;
		gradeSystems.showRank("986002026");
		assertEquals(predictOutput, outContent.toString());

		predictOutput = predictOutput + "舒晨馨排名第41\r\n" ;
		gradeSystems.showRank("995002901");
		assertEquals(predictOutput, outContent.toString());
		
		predictOutput = predictOutput + "此ID不在資料庫\r\n";
		gradeSystems.showRank("1000000000");
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
		
		predictOutput = predictOutput + "張廷瑄排名第26\r\n" ;
		gradeSystems.showRank("975002501");
		assertEquals(predictOutput, outContent.toString());
	}
}
