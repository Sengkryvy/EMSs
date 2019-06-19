package admin_ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

//import com.luv2code.jdbc.employeesearch.ui.EmployeeSearchApp;

import database.AccountConnection;

import javax.swing.JPasswordField;
import javax.swing.JEditorPane;

public class Login {

	private JFrame frame;
	private JTextField username_field;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 255, 204));
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 610, 0);
		frame.getContentPane().add(label);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 33));
		lblLogin.setBounds(250, 25, 86, 41);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblUsername.setBounds(76, 103, 110, 27);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblPassword.setBounds(76, 164, 110, 27);
		frame.getContentPane().add(lblPassword);
		
		username_field = new JTextField();
		username_field.setBounds(198, 102, 262, 34);
		frame.getContentPane().add(username_field);
		username_field.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(51, 153, 255));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLogin.setBounds(259, 222, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(198, 160, 262, 34);
		frame.getContentPane().add(passwordField);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnExit.setBackground(new Color(255, 51, 51));
		btnExit.setBounds(259, 267, 97, 25);
		frame.getContentPane().add(btnExit);
		frame.setBounds(100, 100, 628, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				   int input = JOptionPane.showConfirmDialog(null, "Are You Sure to leave it?", "Exit..",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				   	if(input==0) {
				   		frame.dispose();
				  }   
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username= username_field.getText();
				String paString= passwordField.getText();
//				JOptionPane.showMessageDialog(null, "OK");
				frame.dispose();
				try {
					System.out.println(paString);
					AccountConnection connect= new AccountConnection();
					if(	connect.login(username, paString)) {
						Home window = new Home();
						window.frame.setVisible(true);
					}else {
				   		frame.setVisible(true);
						int input = JOptionPane.showConfirmDialog(null, "Something Error!! ", "Error Aler",
							JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
							System.out.println(input);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
