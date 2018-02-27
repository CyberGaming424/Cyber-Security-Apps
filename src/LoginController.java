import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

public class LoginController extends JFrame{
	Scanner sc = new Scanner(System.in);
	ArrayList<String> userNames = new ArrayList<String>();
	ArrayList<String> passwords = new ArrayList<String>();
	boolean accepted;
	private Scanner users;
	int currentUser;

	public LoginController() {
		try {
			users = new Scanner(new File("loginInfo.txt"));
		} catch (Exception e) {
			System.out.println("File not found");

		}
		readFile();
		System.out.println("Welcome to Cyber Corp. where the future was yesterday.");
		userCheck();
	}

	void readFile() {
		int step = 1;
		while(users.hasNext()) {
			switch(step) {
			case 1:
				userNames.add(users.next());
				step = 2;
				break;
			case 2:
				passwords.add(users.next());
				step = 1;
				break;
			}
		}

	}

	void userCheck() {
		while (accepted == false) {
			System.out.println("User: ");
			String in = sc.next();
			for (String users : userNames) {
				if (in.equals(users)) {
					currentUser = userNames.indexOf(users);
					passCheck();
					accepted = true;
				}
				
			}

		}

	}

	void passCheck() {
		System.out.println("Pass: ");
		String in = sc.next();
		if(in.equals(passwords.get(currentUser))) {
			System.out.println("Welcome to Cyber Corp.");
			
		}else {
			//System.out.println();
			System.out.println("Denied");
		}
	}

	void newUser() {

	}

}
