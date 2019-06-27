package employee_UI;

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
import employeeClass.Permission;
import model.EmployeeModel;
import model.PermissionModel;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class Create_permission_record {
	
	//variable declaration
	private	JTextPane textPane_reason;
	private	JDateChooser dateChooser_leavingDate;
	private	JComboBox comboBox_type;
	private static Permission p = new Permission();

	JFrame frame;
//	private Employees em;
	int eID;

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
	
	public Create_permission_record(int id) {
		eID = id;
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
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			//On create click
			public void actionPerformed(ActionEvent e) {
				//check if the input are blank
				if (dateChooser_leavingDate.getDate().toString().length() != 0 || textPane_reason.getText().length() != 0) {
					p.seteID(eID);
					p.setType(comboBox_type.getSelectedItem().toString());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(dateChooser_leavingDate.getDate());
					p.setLeavingDate(date);
					p.setReason(textPane_reason.getText());
					//check if the creation success
					if (PermissionModel.create(p)) {
						JOptionPane.showMessageDialog(null, "Permission is successfully created.");
						Home_Emp.model_permission.setRowCount(0);
						Home_Emp.fill_tablePermission(eID);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Error creating permission record.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Missing information, please fill all the input.");
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 0, 139));
		btnNewButton.setBounds(194, 342, 151, 39);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblType.setBounds(27, 98, 151, 31);
		frame.getContentPane().add(lblType);
		
		JLabel lblLeavingDate = new JLabel("Leaving Date :");
		lblLeavingDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLeavingDate.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblLeavingDate.setBounds(27, 163, 151, 31);
		frame.getContentPane().add(lblLeavingDate);
		
		JLabel lblReason = new JLabel("Reason :");
		lblReason.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReason.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblReason.setBounds(27, 222, 151, 31);
		frame.getContentPane().add(lblReason);
		
		
		String[] leavingType = {
				"Early leave", "Sick Leave", "Personal leave"
		};
		comboBox_type = new JComboBox(leavingType);
		comboBox_type.setBounds(215, 100, 251, 39);
		frame.getContentPane().add(comboBox_type);
		
		dateChooser_leavingDate = new JDateChooser();
		dateChooser_leavingDate.getCalendarButton().setText("Date");
		dateChooser_leavingDate.setDateFormatString("yyyy-MM-dd");
		dateChooser_leavingDate.setBounds(215, 163, 251, 39);
		frame.getContentPane().add(dateChooser_leavingDate);
		
		textPane_reason = new JTextPane();
		textPane_reason.setForeground(new Color(0, 0, 0));
		textPane_reason.setBounds(215, 231, 251, 67);
		frame.getContentPane().add(textPane_reason);

	}
}
