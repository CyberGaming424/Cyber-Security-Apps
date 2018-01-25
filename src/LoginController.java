import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginController {
	Scanner sc = new Scanner(System.in);
	static ArrayList<String> userNames = new ArrayList<String>();
	String passWord = "admin";
	boolean accepted;
	private Scanner users;

	public LoginController() {
		try {
			users = new Scanner(new File("UserNames.txt"));
		} catch (Exception e) {
			System.out.println("File not found");

		}
		readFile();
		System.out.println("Welcome to Cyber Corp. where the future was yesterday.");
		userCheck();
	}

	void readFile() {
		while (users.hasNext()) {
			userNames.add(users.next());

		}
		for (String i : userNames) {
			System.out.println(i);
		}

	}

	void userCheck() {
		while (accepted == false) {
			System.out.println("User: ");
			String in = sc.next();
			for (String users : userNames) {
				if (in.equals(users)) {
					accepted = true;
				}
				
			}

		}

	}

	void passCheck() {

	}

	void newUser() {

	}

}
