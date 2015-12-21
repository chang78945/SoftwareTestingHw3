package gradeSystem;

//class Grades 儲存 ID, name, lab1, lab2, lab3, midTerm, finalExam, and totalGrade
//calculateTotalGrade(weights)
//Grades () { } //建構子


public class Grades {
	/**
	 * @uml.property  name="iD"
	 */
	private String ID;
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="lab1"
	 */
	private int lab1;
	/**
	 * @uml.property  name="lab2"
	 */
	private int lab2;
	/**
	 * @uml.property  name="lab3"
	 */
	private int lab3;
	/**
	 * @uml.property  name="midTerm"
	 */
	private int midTerm;
	/**
	 * @uml.property  name="finalExam"
	 */
	private int finalExam;
	/**
	 * @uml.property  name="totalGrade"
	 */
	private int totalGrade;
	private boolean lab1flag;
	private boolean lab2flag;
	private boolean lab3flag;
	private boolean midtermflag;
	private boolean finalflag;

	/*
	 * method calculateTotalGrade ----------------------------------------------
	 * 利用各成績的比重，算出totalGrades
	 * 
	 * @param lab1Weight 成績lab1的比重
	 * 
	 * @param lab2Weight 成績lab2的比重
	 * 
	 * @param lab3Weight 成績lab3的比重
	 * 
	 * @param midTermWeight 成績midTerm的比重
	 * 
	 * @param finalExamWeight 成績finalExam的比重
	 * 
	 * Time estimate : O(1)
	 * -------------------------------------------------------------------------
	 */

	// public calculateTotalGrade(weights) {totalGrade須四捨五入}
	public void calculateTotalGrade(double lab1Weight, double lab2Weight,
			double lab3Weight, double midTermWeight, double finalExamWeight) {
		
		totalGrade = (int) Math.round(lab1 * lab1Weight + lab2 * lab2Weight
				+ lab3 * lab3Weight + midTerm * midTermWeight + finalExam
				* finalExamWeight);
		if(totalGrade > 100)
			totalGrade = 100;
	}

	// public Grades () { } //建構子
	public Grades() {
		lab1flag = false;
		lab2flag = false;
		lab3flag = false;
		midtermflag = false;
		finalflag = false;
	}

	/**
	 * @return
	 * @uml.property  name="finalExam"
	 */
	public int getFinalExam() {
		return finalExam;
	}

	/**
	 * @return
	 * @uml.property  name="iD"
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @return
	 * @uml.property  name="lab1"
	 */
	public int getLab1() {
		return lab1;
	}

	/**
	 * @return
	 * @uml.property  name="lab2"
	 */
	public int getLab2() {
		return lab2;
	}

	/**
	 * @return
	 * @uml.property  name="lab3"
	 */
	public int getLab3() {
		return lab3;
	}

	/**
	 * @return
	 * @uml.property  name="midTerm"
	 */
	public int getMidTerm() {
		return midTerm;
	}

	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 * @uml.property  name="totalGrade"
	 */
	public int getTotalGrade() {
		return totalGrade;
	}

	/**
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param finalExam
	 * @uml.property  name="finalExam"
	 */
	public void setFinalExam(int finalExam) {
		this.finalExam = finalExam;
	}

	/**
	 * @param iD
	 * @uml.property  name="iD"
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @param lab1
	 * @uml.property  name="lab1"
	 */
	public void setLab1(int lab1) {
		this.lab1 = lab1;
	}

	/**
	 * @param lab2
	 * @uml.property  name="lab2"
	 */
	public void setLab2(int lab2) {
		this.lab2 = lab2;
	}

	/**
	 * @param lab3
	 * @uml.property  name="lab3"
	 */
	public void setLab3(int lab3) {
		this.lab3 = lab3;
	}

	/**
	 * @param midTerm
	 * @uml.property  name="midTerm"
	 */
	public void setMidTerm(int midTerm) {
		this.midTerm = midTerm;
	}

	/**
	 * @param totalGrade
	 * @uml.property  name="totalGrade"
	 */
	public void setTotalGrade(int totalGrade) {
		this.totalGrade = totalGrade;
	}

}
