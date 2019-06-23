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
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class Create_permission_record {

	JFrame frame;
	private Employees em;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_permission_record window = new Create_permission_record();
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
	public Create_permission_record() {
		initialize();
	}
	
	public Create_permission_record(Employees em) {
		this.em = em;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.getContentPane().setForeground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 572, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChangePassword = new JLabel("Create Permission Form");
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblChangePassword.setBounds(114, 31, 352, 31);
		frame.getContentPane().add(lblChangePassword);
		
		JButton btnNewButton = new JButton("Confirm Change");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 0, 139));
		btnNewButton.setBounds(195, 348, 184, 39);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblType.setBounds(53, 98, 151, 31);
		frame.getContentPane().add(lblType);
		
		JLabel lblLeavingDate = new JLabel("Leaving Date :");
		lblLeavingDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLeavingDate.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblLeavingDate.setBounds(53, 163, 151, 31);
		frame.getContentPane().add(lblLeavingDate);
		
		JLabel lblReason = new JLabel("Reason :");
		lblReason.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReason.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblReason.setBounds(53, 222, 151, 31);
		frame.getContentPane().add(lblReason);
		
		
		String[] leavingType = {
				"Early leave", "Sick Leave", "Personal leave"
		};
		JComboBox comboBox_type = new JComboBox(leavingType);
		comboBox_type.setBounds(241, 100, 251, 39);
		frame.getContentPane().add(comboBox_type);
		
		JDateChooser dateChooser_leavingDate = new JDateChooser();
		dateChooser_leavingDate.getCalendarButton().setText("Date");
		dateChooser_leavingDate.setBounds(241, 163, 251, 39);
		frame.getContentPane().add(dateChooser_leavingDate);
		
		JTextPane textPane_reason = new JTextPane();
		textPane_reason.setForeground(new Color(0, 0, 0));
		textPane_reason.setBounds(241, 231, 251, 67);
		frame.getContentPane().add(textPane_reason);
	}
}
