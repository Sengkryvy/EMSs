package employee_ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login_em {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_em window = new Login_em();
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
	public Login_em() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 624, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblLogin.setBounds(245, 23, 102, 36);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblLoginAsEmployee = new JLabel("login as employee");
		lblLoginAsEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginAsEmployee.setBounds(472, 0, 122, 16);
		frame.getContentPane().add(lblLoginAsEmployee);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setBounds(68, 111, 102, 16);
		frame.getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(174, 107, 281, 29);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblPassword.setBounds(68, 159, 102, 16);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(174, 158, 281, 29);
		frame.getContentPane().add(textField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(245, 252, 142, 29);
		frame.getContentPane().add(btnLogin);
	}
}
