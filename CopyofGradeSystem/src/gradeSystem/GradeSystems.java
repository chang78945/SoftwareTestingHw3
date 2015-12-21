package gradeSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import exception.NoSuchIDExceptions;

//class GradeSystems儲存 a list of student grades.
//containsID(ID)  // 看aGradeSystem有否含此ID
//GradeSystems () //建構子
//showGrade(ID)
//showRank(ID)
//updateWeights ()


public class GradeSystems {
	/**
	 * @uml.property  name="aList"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="gradeSystem.Grades"
	 */
	LinkedList<Grades> aList;
	/**
	 * @uml.property  name="bufferedReader"
	 */
	BufferedReader bufferedReader;

	/**
	 * @uml.property  name="lab1Weight"
	 */
	private double lab1Weight;
	/**
	 * @uml.property  name="lab2Weight"
	 */
	private double lab2Weight;
	/**
	 * @uml.property  name="lab3Weight"
	 */
	private double lab3Weight;
	/**
	 * @uml.property  name="midTermWeight"
	 */
	private double midTermWeight;
	/**
	 * @uml.property  name="finalExamWeight"
	 */
	private double finalExamWeight;
	/**
	 * @uml.property  name="temps" multiplicity="(0 -1)" dimension="1"
	 */
	private int temps[] = new int[5];

	/**
	 * @uml.property  name="newID"
	 */
	private String newID;
	/**
	 * @uml.property  name="newName"
	 */
	private String newName;
	/**
	 * @uml.property  name="lab1NewGrade"
	 */
	private int lab1NewGrade;
	/**
	 * @uml.property  name="lab2NewGrade"
	 */
	private int lab2NewGrade;
	/**
	 * @uml.property  name="lab3NewGrade"
	 */
	private int lab3NewGrade;
	/**
	 * @uml.property  name="midTermNewGrade"
	 */
	private int midTermNewGrade;
	/**
	 * @uml.property  name="finalExamNewGrade"
	 */
	private int finalExamNewGrade;

	/**
	 * @uml.property  name="uIUserName"
	 */
	private String UIUserName;

	/*
	 * method containsID ----------------------------------------------
	 * 
	 * @param ：ID ,a user ID ,ex: 123456789
	 * 
	 * @return 如ID有在aGradeSystem內就回傳true
	 *  
	 * 
	 * Time estimate : O(n) n is aGradeSystem 內全班人數
	 * -------------------------------------------------------------------------
	 */
	// public containsID(ID) 看 ID 是否含在 aGradeSystem內
	// end class GradeSystems
	public boolean containsID(String ID){
		if(Integer.valueOf(ID) < 900000000 || Integer.valueOf(ID) > 999999999){
			System.out.println("Invalid ID");
			return false;
		}
		for (int i = 0; i < this.aList.size(); i++) {
			if (this.aList.get(i).getID().equals(ID)) {
				UIUserName = this.aList.get(i).getName();
				System.out.println("Pass");
				return true;
			}
		}
		System.out.println("No ID");
		return false;
	}

	/*
	 * method deleteGrade ----------------------------------------------
	 * 
	 * @param ：ID ,a user ID ,ex: 123456789
	 * 
	 * Time estimate : O(n) n is aGradeSystem 內全班人數
	 * -------------------------------------------------------------------------
	 */
	// public deleteGrade(ID)
	// 輸入ID之後
	// ID.equals(userID) 確認是否等於現行使用者
	// 不是的話到aList中loop找到欲刪除的ID
	public void deleteGrade(String userID, String ID) {
		if(Integer.valueOf(ID) < 900000000 || Integer.valueOf(ID) > 999999999)
			System.out.println("此ID不在資料庫");
		else
		{
			if (ID.equals(userID)) {
				System.out.println("不能刪除自己!");
			} else {
				System.out.println("以上正確嗎? Y (Yes) 或 N (No)");
				//String judge = scanner.next().trim();
				String judge = "Y";
				if (judge.equals("Y")) {
					for (int i = 0; i < aList.size(); i++) {
						if (aList.get(i).getID().equals(ID)) {
							aList.remove(i);
						}
					}
				}
			}
		}
	}

	// public GradeSystems () //建構子
	//
	// 1. 開檔 input file
	// 2. 用Java LinkedList建構an empty list of grades叫 aList
	// 3. read line
	// 4. while not endOfFile
	// 1.call Grades() 建構aGrade
	// 2.用 Java Scanner 來 scan line 把各欄位存入aGrade
	// 3. aGrade.calculateTotalGrade(weights) 回傳aTotalGrade把它存入aGrade
	// 4. 把 aGrade 存入 aList
	// 5. if endOfLine then read line end if
	// end while
	public GradeSystems() {
		try {
			aList = new LinkedList<>();
			File f = new File("File.txt");
			setWeights(0.1, 0.1, 0.2, 0.3, 0.3);
			Scanner input = new Scanner(f);
			String line;
			while (input.hasNextLine()) {
				line = input.nextLine();
				// 處理讀入每一行的資料
				String[] afterSplit = line.split(" ");
				Grades aGrades = new Grades();
				aGrades.setID(afterSplit[0]);
				aGrades.setName(afterSplit[1]);
				aGrades.setLab1(Integer.parseInt(afterSplit[2]));
				aGrades.setLab2(Integer.parseInt(afterSplit[3]));
				aGrades.setLab3(Integer.parseInt(afterSplit[4]));
				aGrades.setMidTerm(Integer.parseInt(afterSplit[5]));
				aGrades.setFinalExam(Integer.parseInt(afterSplit[6]));
				aGrades.calculateTotalGrade(lab1Weight, lab2Weight, lab3Weight,
						midTermWeight, finalExamWeight);
				aList.add(aGrades);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * method insertGrade ----------------------------------------------
	 * 
	 * Time estimate : O(1)
	 * -------------------------------------------------------------------------
	 */
	// public insertGrade()
	// 輸入ID和Name和各成績之後
	// getNewGrades(); 顯示輸入資料
	// insertGradeCheck(); 確定新增資料
	public void insertGrade() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Student ID:");
		newID = scanner.next();
		System.out.print("Student Name:");
		newName = scanner.next();
		System.out.print("lab1:");
		lab1NewGrade = scanner.nextInt();
		System.out.print("lab2:");
		lab2NewGrade = scanner.nextInt();
		System.out.print("lab3:");
		lab3NewGrade = scanner.nextInt();
		System.out.print("midTerm:");
		midTermNewGrade = scanner.nextInt();
		System.out.print("finalExam:");
		finalExamNewGrade = scanner.nextInt();

		getNewGrades();
		insertGradeCheck();
	}

	/*
	 * method showGrade ----------------------------------------------
	 * 
	 * @param ：ID ,a user ID ,ex: 123456789
	 * 
	 * Time estimate : O(n) n is aGradeSystem 內全班人數
	 * -------------------------------------------------------------------------
	 */
	// public showGrade(ID) { show 這 ID 的 grade }
	public void showGrade(String ID) {
		if(Integer.valueOf(ID) < 900000000 || Integer.valueOf(ID) > 999999999)
			System.out.println("此ID不在資料庫");
		else
		{
			for (int i = 0; i < aList.size(); i++) {
				if (aList.get(i).getID().equals(ID)) {
					System.out.println(aList.get(i).getName() + "成績:\tlab1:\t\t"
							+ aList.get(i).getLab1());
					System.out.println("\t\t" + "lab2:\t\t"
							+ aList.get(i).getLab2());
					System.out.println("\t\t" + "lab3:\t\t"
							+ aList.get(i).getLab3());
					System.out.println("\t\t" + "mid-term:\t"
							+ aList.get(i).getMidTerm());
					System.out.println("\t\t" + "final exam:\t"
							+ aList.get(i).getFinalExam());
					System.out.println("\t\t" + "total grade:\t"
							+ aList.get(i).getTotalGrade());
					break;
				}
			}
		}
	}

	/*
	 * method showRank ----------------------------------------------
	 * 
	 * @param ：ID ,a user ID ,ex: 123456789
	 * 
	 * Time estimate : O(n) n is aGradeSystem 內全班人數
	 * -------------------------------------------------------------------------
	 */
	// public showRank(ID)
	// 1. 取得這 ID 的 theTotalGrade
	// 2. 令rank 為 1
	// 3. loop aGrade in aList if aTotalGrade > theTotalGrade then rank加1(退1名)
	// end loop
	// 4. 回傳 rank
	public void showRank(String ID) {
		int rank = 1;
		int grade = 0;
		String name = null;
		if(Integer.valueOf(ID) < 900000000 || Integer.valueOf(ID) > 999999999)
			System.out.println("此ID不在資料庫");
		else
		{
			for (int i = 0; i < aList.size(); i++) {
				if (aList.get(i).getID().equals(ID)) {
					grade = aList.get(i).getTotalGrade();
					name = aList.get(i).getName();
				}
			}
	
			for (int i = 0; i < aList.size(); i++) {
				if (grade < aList.get(i).getTotalGrade()) {
					rank++;
				}
			}
			System.out.println(name + "排名第" + rank);
		}
	}

	/*
	 * method updateWeights ----------------------------------------------
	 * 
	 * Time estimate : O(n) n is aGradeSystem 內全班人數
	 * -------------------------------------------------------------------------
	 */
	// public updateWeights ()更新成績比重
	// 1. showOldWeights()
	// 2. getNewWeights()
	// 3. showNewWeights()
	// 4. confirm()
	// 5. loop aGrade in aList to calculateTotalGrade(weights) end loop
	public void updateWeights() {
		showOldWeights();
		getNewWeights();
		showNewWeights();
		confirm();
		for (int i = 0; i < aList.size(); i++) {
			aList.get(i).calculateTotalGrade(lab1Weight, lab2Weight,
					lab3Weight, midTermWeight, finalExamWeight);
		}
	}

	/*
	 * method confirm ----------------------------------------------
	 * 
	 * Time estimate : O(1)
	 * -------------------------------------------------------------------------
	 */
	// 輸入Y 或 y就確認剛剛所輸入的新配分
	private void confirm() {
		System.out.println("以上正確嗎? Y (Yes) 或 N (No)");
		/*Scanner scanner = new Scanner(System.in);
		String judge = scanner.next().trim();*/
		String judge = "Y";
		if (judge.equals("Y")) {
			lab1Weight = (double) (temps[0]) / 100;
			lab2Weight = (double) (temps[1]) / 100;
			lab3Weight = (double) (temps[2]) / 100;
			midTermWeight = (double) (temps[3]) / 100;
			finalExamWeight = (double) (temps[4]) / 100;
		}
	}

	/*
	 * method getNewGrades ----------------------------------------------
	 * 
	 * Time estimate : O(1)
	 * -------------------------------------------------------------------------
	 */
	// 把欲新加的學生資料印出來
	private void getNewGrades() {
		System.out.println("請確認資料:");
		System.out.println("新使用者ID\t" + newID);
		System.out.println("新名稱\t\t" + newName);
		System.out.println("lab1\t\t" + lab1NewGrade);
		System.out.println("lab2\t\t" + lab2NewGrade);
		System.out.println("lab3\t\t" + lab3NewGrade);
		System.out.println("mid-term\t" + midTermNewGrade);
		System.out.println("final exam\t" + finalExamNewGrade);
	}

	/*
	 * method getNewWeights ----------------------------------------------
	 * 
	 * Time estimate : O(1)
	 * -------------------------------------------------------------------------
	 */
	// 輸入各科成績新的比重
	private void getNewWeights() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("新配分");
		System.out.print("lab1\t\t");
		int temp = scanner.nextInt();
		temps[0] = temp;

		System.out.print("lab2\t\t");
		temp = scanner.nextInt();
		temps[1] = temp;

		System.out.print("lab3\t\t");
		temp = scanner.nextInt();
		temps[2] = temp;

		System.out.print("mid-term\t");
		temp = scanner.nextInt();
		temps[3] = temp;

		System.out.print("final exam\t");
		temp = scanner.nextInt();
		temps[4] = temp;
	}

	/*
	 * method insertGradeCheck ----------------------------------------------
	 * 
	 * Time estimate : O(1)
	 * -------------------------------------------------------------------------
	 */
	// 輸入Y或y就確認剛剛新加的同學的資料正確
	// 如不是輸入Y或y，剛剛新加的學生資料就取消加入
	private void insertGradeCheck() {
		System.out.println("以上正確嗎? Y (Yes) 或 N (No)");
		/*Scanner scanner = new Scanner(System.in);
		String judge = scanner.next().trim();*/
		String judge = "Y";
		if (judge.equals("Y")) {
			Grades aGrades = new Grades();
			aGrades.setID(newID);
			aGrades.setName(newName);
			aGrades.setLab1(lab1NewGrade);
			aGrades.setLab2(lab2NewGrade);
			aGrades.setLab3(lab3NewGrade);
			aGrades.setMidTerm(midTermNewGrade);
			aGrades.setFinalExam(finalExamNewGrade);
			aGrades.calculateTotalGrade(lab1Weight, lab2Weight, lab3Weight,
					midTermWeight, finalExamWeight);
			aList.add(aGrades);
		}
	}

	/*
	 * method setWeights ----------------------------------------------
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
	// 把各科成績比重存進private變數
	private void setWeights(double lab1Weight, double lab2Weight,
			double lab3Weight, double midTermWeight, double finalExamWeight) {
		this.lab1Weight = lab1Weight;
		this.lab2Weight = lab2Weight;
		this.lab3Weight = lab3Weight;
		this.midTermWeight = midTermWeight;
		this.finalExamWeight = finalExamWeight;
	}

	/*
	 * method showNewWeights ----------------------------------------------
	 * 
	 * Time estimate : O(1)
	 * -------------------------------------------------------------------------
	 */
	// 印出新配分的資訊
	private void showNewWeights() {

		System.out.println("請確認新配分");
		System.out.println("lab1\t\t" + temps[0] + "%");
		System.out.println("lab2\t\t" + temps[1] + "%");
		System.out.println("lab3\t\t" + temps[2] + "%");
		System.out.println("mid-term\t" + temps[3] + "%");
		System.out.println("final exam\t" + temps[4] + "%");

	}

	/*
	 * method showOldWeights ----------------------------------------------
	 * 
	 * Time estimate : O(1)
	 * -------------------------------------------------------------------------
	 */
	// 印出舊配分的資訊
	private void showOldWeights() {
		System.out.println("舊配分");
		System.out.println("lab1\t\t" + lab1Weight * 100 + "%");
		System.out.println("lab2\t\t" + lab2Weight * 100 + "%");
		System.out.println("lab3\t\t" + lab3Weight * 100 + "%");
		System.out.println("mid-term\t" + midTermWeight * 100 + "%");
		System.out.println("final exam\t" + finalExamWeight * 100 + "%");

	}

	/**
	 * @return
	 * @uml.property  name="finalExamWeight"
	 */
	public double getFinalExamWeight() {
		return finalExamWeight;
	}

	/**
	 * @return
	 * @uml.property  name="lab1Weight"
	 */
	public double getLab1Weight() {
		return lab1Weight;
	}

	/**
	 * @return
	 * @uml.property  name="lab2Weight"
	 */
	public double getLab2Weight() {
		return lab2Weight;
	}

	/**
	 * @return
	 * @uml.property  name="lab3Weight"
	 */
	public double getLab3Weight() {
		return lab3Weight;
	}

	/**
	 * @return
	 * @uml.property  name="midTermWeight"
	 */
	public double getMidTermWeight() {
		return midTermWeight;
	}

	/**
	 * @return
	 * @uml.property  name="uIUserName"
	 */
	public String getUIUserName() {
		return UIUserName;
	}
}
