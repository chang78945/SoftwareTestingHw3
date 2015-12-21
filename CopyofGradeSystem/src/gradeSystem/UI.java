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
//UI() �غc�l �غc aGradeSystem

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
	 * @param �GID ,a user ID ,ex: 123456789
	 * 
	 * @return �paGradeSystems.containsID�Otrue�A�N�^��true
	 * 
	 * @throws NoSuchIDExceptions
	 * 
	 * Time estimate : O(n) n is aGradeSystem �����Z�H��
	 * -------------------------------------------------------------------------
	 */
	// checkID (ID) throws NoSuchIDExceptions return Boolean
	// 1. �naGradeSystem ��containsID(ID) �� ID �O�_�t�b aGradeSystem��
	// 2. if not, throw an object of NoSuchIDExceptions
	// 3. �^�� true
	public boolean checkID(String ID) {
		return aGradeSystems.containsID(ID);
	}

	/*
	 * method promptCommand ----------------------------------------------
	 * 
	 * @throws NoSuchCommandExceptions - if ��J�����O���OG�BR�BW�BE�BI�BD
	 * 
	 * Time estimate : O(n) n is aGradeSystem �����Z�H��
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
			System.out.println("���O���~!");
		}
	}

	/*
	 * method promptID ----------------------------------------------
	 * 
	 * Time estimate : O(1)
	 * -------------------------------------------------------------------------
	 */
	// �L�X������T
	public void promptID() {
		System.out.print("��JID�� Q (�����ϥ�)? ");
	}

	/*
	 * method showFinishMsg ----------------------------------------------
	 * 
	 * Time estimate : O(1)
	 * -------------------------------------------------------------------------
	 */
	// �L�X������T
	public void showFinishMsg() {
		System.out.println("�����F.");
	}

	/*
	 * method showWelcomeMsg ----------------------------------------------
	 * 
	 * Time estimate : O(1)
	 * -------------------------------------------------------------------------
	 */
	// �L�X�w���T�M�\�श��
	public void showWelcomeMsg() {
		System.out.println("Welcome " + userName);
		System.out.println("��J���O \t1) G ��ܦ��Z (Grade)\n \t2) R ��ܱƦW (Rank)\n \t3) "
				+ "W ��s�t�� (Weight)\n \t4) I �s�W�Ǹ� (Insert)\n \t5) D �R���Ǹ� (Delete)\n \t6) "
				+ "E ���}��� (Exit)");
	}

	// UI() �غc�l throws NoSuchIDExceptions, NoSuchCommandExceptions
	// try
	// 1.call GradeSystems() to�غc aGradeSystem
	//
	// 2.loop1 until Q (Quit)
	// 1. promptID() to get user ID ��JID�� Q (�����ϥ�)�H
	// 2. checkID (ID) �� ID �O�_�b aGradeSystem��
	// 3. showWelcomeMsg (ID) ex. Welcome���§�
	// 4. loop2 until E (Exit)
	// promptCommand() to prompt for inputCommand
	// end loop2
	// end loop1
	// 3.showFinishMsg() �����F
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
