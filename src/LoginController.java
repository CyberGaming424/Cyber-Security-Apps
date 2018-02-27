import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LoginController extends JFrame {

	private static final long serialVersionUID = -7605758154007146213L;

	JTextArea userName, password;
	JButton login;
	JLabel acceptedOrDenied;
	JPanel panel = new JPanel();
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
		// Creates the window
		createView();

		// Sets the name of the window to Click Me
		setTitle("Cyber Corp. Security");
		// Sets the default close operation aka when you click the X, it will close the
		// program
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Sets the size of the frame
		// Packs everything into the window
		pack();
		// Make the window open in the center of the screen
		setLocationRelativeTo(null);
		// Sets Resizilbe to false
		setResizable(true);
		// Makes the window visible
		setVisible(true);

		readFile();

	}

	private void createView() {

		getContentPane().add(panel);
		panel.setPreferredSize(new Dimension(400, 125));
		JLabel userText = new JLabel("Username: ");
		panel.add(userText);
		userName = new JTextArea();
		userName.setLineWrap(true);
		userName.setWrapStyleWord(true);
		userName.setPreferredSize(new Dimension(90, 20));
		panel.add(userText);
		panel.add(userName);
		JLabel passText = new JLabel("Password: ");
		panel.add(passText);
		password = new JTextArea();
		password.setLineWrap(true);
		password.setWrapStyleWord(true);
		password.setPreferredSize(new Dimension(90, 20));
		panel.add(password);
		login = new JButton("Submit");
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				userCheck();
			}

		});
		panel.add(login);
		acceptedOrDenied = new JLabel("Please enter you Username and password");
		panel.add(acceptedOrDenied);

	}

	void readFile() {
		int step = 1;
		while (users.hasNext()) {
			switch (step) {
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
		String in = userName.getText();
		for (String users : userNames) {
			if (in.equals(users)) {
				currentUser = userNames.indexOf(users);
				passCheck();
			}

		}

	}

	void passCheck() {
		String in = password.getText();

		if (in.equals(passwords.get(currentUser))) {
			acceptedOrDenied.setText("Accepted!");

		} else {
			acceptedOrDenied.setText("Denied!");
		}
		
		panel.add(acceptedOrDenied);
	}

	void newUser() {

	}

}
