package employee_ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import database.ConnectDB;
import employeeClass.Employees;
import model.EmployeeModel;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Change_pw_emp {

	JFrame frame;
	private JTextField textField_currentPassword;
	private JTextField textField_NewPassword;
	private JTextField textField_ConfirmPassword;
	private Employees em;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_pw_emp window = new Change_pw_emp();
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
	public Change_pw_emp() {
		initialize();
	}
	
	public Change_pw_emp(Employees em) {
		this.em = em;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 572, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCurrentPassword = new JLabel("Current Password :");
		lblCurrentPassword.setBounds(55, 102, 164, 24);
		lblCurrentPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(lblCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New Password :");
		lblNewPassword.setBounds(84, 158, 135, 24);
		lblNewPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setBounds(53, 216, 166, 24);
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(lblConfirmPassword);
		
		textField_currentPassword = new JPasswordField();
		textField_currentPassword.setBounds(241, 100, 251, 33);
		frame.getContentPane().add(textField_currentPassword);
		textField_currentPassword.setColumns(10);
		
		textField_NewPassword = new JPasswordField();
		textField_NewPassword.setColumns(10);
		textField_NewPassword.setBounds(241, 155, 251, 33);
		frame.getContentPane().add(textField_NewPassword);
		
		textField_ConfirmPassword = new JPasswordField();
		textField_ConfirmPassword.setColumns(10);
		textField_ConfirmPassword.setBounds(241, 214, 251, 33);
		frame.getContentPane().add(textField_ConfirmPassword);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblChangePassword.setBounds(185, 32, 278, 31);
		frame.getContentPane().add(lblChangePassword);
		
		JButton btnNewButton = new JButton("Confirm Change");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(34, 139, 34));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				System.out.println(em.getPassword());
//				System.out.println(textField_currentPassword.getText());
				
				//Test whether current password field is correct.
				if (textField_currentPassword.getText().equals(em.getPassword())) {
					
					//Test whether both new and confirm password match.
					if (textField_NewPassword.getText().equals(textField_ConfirmPassword.getText())) {
						
						//Updating password
						if (EmployeeModel.update_Password(textField_NewPassword.getText(), em.getID())) {
							JOptionPane.showMessageDialog(null, "Password has been updated.");
							frame.dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Erorr updating password.");
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "New password and Confirm password do not match.");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Current Password is not correct.");
				}
				
			}
		});
		btnNewButton.setBounds(187, 270, 184, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBackground(Color.GRAY);
		btnBack.setBounds(12, 32, 105, 39);
		frame.getContentPane().add(btnBack);
	}
}
