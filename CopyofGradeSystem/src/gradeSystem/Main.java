package gradeSystem;

import exception.NoSuchCommandExceptions;
import exception.NoSuchIDExceptions;

//class Main 
//main ( ) 


public class Main {
	static final String NO_SUCH_ID_EXCEPTIONS_STRING = "��ID���s�b!";
	static final String NO_SUCH_COMMAND_EXCEPTIONS_STRING = "���O���~!";

	// public static void main (String args[])
	// try { call UI() �غc aUI } end try
	// catch (NoSuchIDExceptions e1) {print msg1} //ex ��ID���s�b!
	// catch (NoSuchCommandExceptions e2) {print msg2}//ex���O���~!
	// end class Main
	public static void main(String[] args) {
		try {
			UI aUi = new UI();
		} catch (NoSuchIDExceptions e) {
			System.out.print(NO_SUCH_ID_EXCEPTIONS_STRING);
		} catch (NoSuchCommandExceptions e) {
			System.out.print(NO_SUCH_COMMAND_EXCEPTIONS_STRING);
		}
	}
}
