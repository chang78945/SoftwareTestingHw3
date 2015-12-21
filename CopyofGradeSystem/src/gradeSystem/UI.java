package gradeSystem;

import java.util.Scanner;

import exception.NoSuchCommandExceptions;
import exception.NoSuchIDExceptions;

//class UI (user interface) 
//checkID(ID)
//promptCommand()
//promptID()
//showFinishMsg()
//showWelcomeMsg()
//UI() 建構子 建構 aGradeSystem

public class UI {
	/**
	 * @uml.property  name="aGradeSystems"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private GradeSystems aGradeSystems;
	/**
	 * @uml.property  name="userID"
	 */
	private String userID = null;
	/**
	 * @uml.property  name="userName"
	 */
	private String userName = null;
	/**
	 * @uml.property  name="isQuit"
	 */
	private boolean isQuit = false;
	/**
	 * @uml.property  name="isExit"
	 */
	private boolean isExit = false;

	/*
	 * method checkID ----------------------------------------------
	 * 
	 * @param ：ID ,a user ID ,ex: 123456789
	 * 
	 * @return 如aGradeSystems.containsID是true，就回傳true
	 * 
	 * @throws NoSuchIDExceptions
	 * 
	 * Time estimate : O(n) n is aGradeSystem 內全班人數
	 * -------------------------------------------------------------------------
	 */
	// checkID (ID) throws NoSuchIDExceptions return Boolean
	// 1. 要aGradeSystem 做containsID(ID) 看 ID 是否含在 aGradeSystem內
	// 2. if not, throw an object of NoSuchIDExceptions
	// 3. 回傳 true
	public boolean checkID(String ID) {
		return aGradeSystems.containsID(ID);
	}

	/*
	 * method promptCommand ----------------------------------------------
	 * 
	 * @throws NoSuchCommandExceptions - if 輸入的指令不是G、R、W、E、I、D
	 * 
	 * Time estimate : O(n) n is aGradeSystem 內全班人數
	 * -------------------------------------------------------------------------
	 */
	// promptCommand () throws NoSuchCommandExceptions
	// 1. prompt user for inputCommand
	// 2. if inputCommand is not G (Grade),R (Rank), W (Weights), E
	// (Exit),I(Insert),or D(delete)
	// throws an object of NoSuchCommandException
	// 3. if inputCommand is E (Exit) then break
	// else: G aGradeSystem.showGrade(ID), R showRank(ID), W updateWeights() ,I
	// insertGrade(), D deleteGrade() end if
	public void promptCommand() throws NoSuchCommandExceptions {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next().trim();
		if (input.equals("G")) {
			aGradeSystems.showGrade(userID);
		} else if (input.equals("E")) {
			isExit = true;
		} else if (input.equals("R")) {
			aGradeSystems.showRank(userID);
		} else if (input.equals("W")) {
			aGradeSystems.updateWeights();
		} else if (input.equals("I")) {
			aGradeSystems.insertGrade();
		} else if (input.equals("D")) {
			input = scanner.next().trim();
			aGradeSystems.deleteGrade(userID,input);
		} else {
			//throw new NoSuchCommandExceptions();
			System.out.println("指令錯誤!");
		}
	}

	/*
	 * method promptID ----------------------------------------------
	 * 
	 * Time estimate : O(1)
	 * -------------------------------------------------------------------------
	 */
	// 印出結束資訊
	public void promptID() {
		System.out.print("輸入ID或 Q (結束使用)? ");
	}

	/*
	 * method showFinishMsg ----------------------------------------------
	 * 
	 * Time estimate : O(1)
	 * -------------------------------------------------------------------------
	 */
	// 印出結束資訊
	public void showFinishMsg() {
		System.out.println("結束了.");
	}

	/*
	 * method showWelcomeMsg ----------------------------------------------
	 * 
	 * Time estimate : O(1)
	 * -------------------------------------------------------------------------
	 */
	// 印出歡迎資訊和功能介面
	public void showWelcomeMsg() {
		System.out.println("Welcome " + userName);
		System.out.println("輸入指令 \t1) G 顯示成績 (Grade)\n \t2) R 顯示排名 (Rank)\n \t3) "
				+ "W 更新配分 (Weight)\n \t4) I 新增學號 (Insert)\n \t5) D 刪除學號 (Delete)\n \t6) "
				+ "E 離開選單 (Exit)");
	}

	// UI() 建構子 throws NoSuchIDExceptions, NoSuchCommandExceptions
	// try
	// 1.call GradeSystems() to建構 aGradeSystem
	//
	// 2.loop1 until Q (Quit)
	// 1. promptID() to get user ID 輸入ID或 Q (結束使用)？
	// 2. checkID (ID) 看 ID 是否在 aGradeSystem內
	// 3. showWelcomeMsg (ID) ex. Welcome李威廷
	// 4. loop2 until E (Exit)
	// promptCommand() to prompt for inputCommand
	// end loop2
	// end loop1
	// 3.showFinishMsg() 結束了
	// end try
	// finally {}
	public UI() throws NoSuchIDExceptions, NoSuchCommandExceptions {
		aGradeSystems = new GradeSystems();
		Scanner scanner = new Scanner(System.in);

		while (!isQuit) {
			promptID();
			String input = scanner.next().trim();

			if (input.equals("Q")) {
				isQuit = true;
			} else if (checkID(input)) {
				userName = aGradeSystems.getUIUserName();
				isExit = false;
				userID = input;
				showWelcomeMsg();
				while (!isExit) {
					promptCommand();
				}
			} else {
				throw new NoSuchIDExceptions();
			}
		}
		showFinishMsg();
	}

	/**
	 * @param userID
	 * @uml.property  name="userID"
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @param userName
	 * @uml.property  name="userName"
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
