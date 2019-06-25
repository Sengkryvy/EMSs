package employee_UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JPanel;	
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import employeeClass.Employees;
import employeeClass.Permission;
import model.EmployeeModel;
import model.PermissionModel;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;

public class Home_Emp {

	public JFrame frame;
	
	//panel 
	private JPanel panel_attendance;
	private JPanel panel_permission ;
	private JPanel panel_profile;
	static DefaultTableModel model_employees;
	static DefaultTableModel model_permission;
	
	private JTextField textField_firstName;
	private JTextField textField_lastName;
	private JLabel lblBirthOfDate;
	private JTextField textField_email;
	private JTextField textField_phone;
	private JDateChooser dateChooser_dob;
	private JButton btnUpdate;

	
	//label
	private JLabel tittle_profile;
	
	//button
	private JButton btnEdit;
	
	
	//variables
	private Employees em = new Employees();
	private JPanel panel_main;
	private JTextField textField_position;
	private JTextField textField_salary;
	private JButton btnChangePassword;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_Emp window = new Home_Emp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		});
	}

	public Home_Emp() {
		initialize();
	}
	
	public Home_Emp(Employees em) {
		this.em = em;
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1191, 667);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		//Navigation bar
		JPanel bar = new JPanel();
		bar.setBorder(new LineBorder(new Color(0, 0, 0)));
		bar.setBackground(SystemColor.activeCaption);
		bar.setBounds(0, 0, 1173, 59);
		frame.getContentPane().add(bar);
		bar.setLayout(null);
			
			//Title
			tittle_profile = new JLabel("Profile");
			tittle_profile.setHorizontalAlignment(SwingConstants.CENTER);
			tittle_profile.setFont(new Font("Times New Roman", Font.BOLD, 24));
			tittle_profile.setBounds(511, 0, 286, 59);
			bar.add(tittle_profile);
			
			//Date
			JLabel lblDate = new JLabel();
			lblDate.setForeground(Color.BLUE);
			long mill= System.currentTimeMillis();
			lblDate.setText(new Date(mill).toString());
			lblDate.setBounds(0, 3, 194, 58);
			bar.add(lblDate);
			lblDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblDate.setHorizontalAlignment(SwingConstants.CENTER);
			
			//Separator
			JSeparator separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(193, -4, 2, 65);
			bar.add(separator);
			separator.setOrientation(SwingConstants.VERTICAL);
		
		//Side-bar
		JPanel btn_sidebar = new JPanel();
		btn_sidebar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_sidebar.setBackground(SystemColor.activeCaption);
		btn_sidebar.setBounds(0, 58, 194, 563);
		frame.getContentPane().add(btn_sidebar);
		btn_sidebar.setLayout(null);
		
			//Button attendance
			JLabel lblCheckAttandent = new JLabel("Attendance");
			lblCheckAttandent.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tittle_profile.setText("Attandence");
					panel_main.removeAll();
					panel_main.repaint();
					panel_main.revalidate();
					
					panel_main.add(panel_attendance);
					panel_main.repaint();
					panel_main.revalidate();
				}
			});
			lblCheckAttandent.setBounds(0, 157, 193, 59);
			btn_sidebar.add(lblCheckAttandent);
			lblCheckAttandent.setHorizontalAlignment(SwingConstants.CENTER);
			lblCheckAttandent.setFont(new Font("Times New Roman", Font.BOLD, 22));
			
			//Button permission
			JLabel lblPermission = new JLabel("Permission");
			lblPermission.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tittle_profile.setText("Permission");
					panel_main.removeAll();
					panel_main.repaint();
					panel_main.revalidate();
					
					panel_main.add(panel_permission);
					panel_main.repaint();
					panel_main.revalidate();
					
				}
			});
			lblPermission.setBounds(0, 85, 193, 59);
			btn_sidebar.add(lblPermission);
			lblPermission.setHorizontalAlignment(SwingConstants.CENTER);
			lblPermission.setFont(new Font("Times New Roman", Font.BOLD, 22));
		//End of Side-bar//////////////////////////////////
			
			
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_main.removeAll();
				panel_main.repaint();
				panel_main.revalidate();
				
				panel_main.add(panel_profile);
				panel_main.repaint();
				panel_main.revalidate();
				tittle_profile.setText("Profile");
			}
		});
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblProfile.setBounds(0, 13, 193, 59);
		btn_sidebar.add(lblProfile);
		
		//Panel main
		panel_main = new JPanel();
		panel_main.setBounds(194, 60, 979, 559);
		frame.getContentPane().add(panel_main);
		panel_main.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(1, -2, 977, 563);
				panel_main.add(scrollPane);
		//End of Show Staff///////////////////////////////
		
		// Panel to Show all Employees
				panel_profile = new JPanel();
				scrollPane.setViewportView(panel_profile);
				panel_profile.setBackground(SystemColor.inactiveCaption);
				panel_profile.setLayout(null);
				
				//Edit
				btnEdit = new JButton("Edit Profile");
				btnEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//						JOptionPane.showMessageDialog(null, "Edit Profile");
//						panel_profile.removeAll();
//						panel_profile.repaint();
//						panel_profile.revalidate();
						btnUpdate.setVisible(true);
						btnEdit.setVisible(false);
						textField_firstName.setEditable(true);
						textField_lastName.setEditable(true);
						textField_email.setEditable(true);
						textField_phone.setEditable(true);
						dateChooser_dob.setEnabled(true);
						
					}
				});
				
				JLabel lblFirstName = new JLabel("First Name :");
				lblFirstName.setBounds(142, 42, 151, 31);
				panel_profile.add(lblFirstName);
				lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 22));
				lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
				
				dateChooser_dob = new JDateChooser();
				dateChooser_dob.getCalendarButton().setText("Date");
				dateChooser_dob.setBounds(321, 233, 279, 30);
				dateChooser_dob.setEnabled(false);
				panel_profile.add(dateChooser_dob);
				dateChooser_dob.setDateFormatString("yyyy-MM-dd");
				
				btnEdit.setForeground(Color.WHITE);
				btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnEdit.setBackground(new Color(255, 140, 0));
				btnEdit.setBounds(484, 484, 137, 42);
				
				panel_profile.add(btnEdit);
				panel_profile.add(lblFirstName);
				
				textField_firstName = new JTextField();
				textField_firstName.setEditable(false);
				textField_firstName.setBounds(321, 42, 279, 31);
				panel_profile.add(textField_firstName);
				textField_firstName.setColumns(10);
			
				
				textField_lastName = new JTextField();
				textField_lastName.setEditable(false);
				textField_lastName.setBounds(321, 103, 279, 31);
				panel_profile.add(textField_lastName);
				textField_lastName.setColumns(10);
				
				JLabel lblFullName = new JLabel("Last Name :");
				lblFullName.setBounds(165, 103, 128, 31);
				panel_profile.add(lblFullName);
				lblFullName.setHorizontalAlignment(SwingConstants.RIGHT);
				lblFullName.setFont(new Font("Times New Roman", Font.BOLD, 22));
				
				textField_email = new JTextField();
				textField_email.setEditable(false);
				textField_email.setBounds(321, 164, 279, 31);
				panel_profile.add(textField_email);
				textField_email.setColumns(10);
				
				JLabel lblEmail = new JLabel("Email :");
				lblEmail.setBounds(147, 168, 146, 31);
				panel_profile.add(lblEmail);
				lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
				lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 22));
				
				lblBirthOfDate = new JLabel("Date of Birth :");
				lblBirthOfDate.setBounds(115, 234, 178, 31);
				panel_profile.add(lblBirthOfDate);
				lblBirthOfDate.setHorizontalAlignment(SwingConstants.RIGHT);
				lblBirthOfDate.setFont(new Font("Times New Roman", Font.BOLD, 22));
				
				JLabel lblPhone = new JLabel("Phone :");
				lblPhone.setBounds(147, 303, 146, 31);
				panel_profile.add(lblPhone);
				lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 22));
				
				textField_phone = new JTextField();
				textField_phone.setEditable(false);
				textField_phone.setBounds(321, 299, 279, 31);
				panel_profile.add(textField_phone);
				textField_phone.setColumns(10);
				
				JLabel lblSalalry = new JLabel("Position :");
				lblSalalry.setHorizontalAlignment(SwingConstants.RIGHT);
				lblSalalry.setFont(new Font("Times New Roman", Font.BOLD, 22));
				lblSalalry.setBounds(147, 360, 146, 31);
				panel_profile.add(lblSalalry);
				
				JLabel lblSalary = new JLabel("Salary :");
				lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
				lblSalary.setFont(new Font("Times New Roman", Font.BOLD, 22));
				lblSalary.setBounds(147, 416, 146, 31);
				panel_profile.add(lblSalary);
				
				textField_position = new JTextField();
				textField_position.setText((String) null);
				textField_position.setEditable(false);
				textField_position.setColumns(10);
				textField_position.setBounds(321, 360, 279, 31);
				panel_profile.add(textField_position);
				
				textField_salary = new JTextField();
				textField_salary.setText((String) null);
				textField_salary.setEditable(false);
				textField_salary.setColumns(10);
				textField_salary.setBounds(321, 416, 279, 31);
				panel_profile.add(textField_salary);
				
				textField_firstName.setText(em.getFirstname());
				textField_lastName.setText(em.getLastname());
				textField_email.setText(em.getEmail());
				dateChooser_dob.setDateFormatString("yyyy-MM-dd");
				dateChooser_dob.setDate(Date.valueOf(em.getDob()));
				textField_position.setText(em.getPosition());
				textField_phone.setText(em.getPhone());
				textField_salary.setText(Double.toString(em.getSalary()));
				
				btnUpdate = new JButton("Update");
				btnUpdate.setForeground(Color.WHITE);
				btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnUpdate.setBackground(new Color(255, 140, 0));
				btnUpdate.setBounds(484, 484, 137, 42);
				btnUpdate.setVisible(false);
				panel_profile.add(btnUpdate);
				
				btnChangePassword = new JButton("Change Password");
				btnChangePassword.setBounds(257, 484, 170, 42);
				panel_profile.add(btnChangePassword);
				btnChangePassword.setForeground(Color.WHITE);
				btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnChangePassword.setBackground(new Color(255, 140, 0));
				

				
				//Panel Permission
				panel_permission = new JPanel();
				panel_permission.setBounds(1, -2, 977, 563);
				panel_main.add(panel_permission);
				panel_permission.setBackground(SystemColor.inactiveCaption);
				panel_permission.setLayout(null);
				
				
				//Panel Attendance
				panel_attendance = new JPanel();
				panel_attendance.setBounds(1, -2, 977, 563);
				panel_main.add(panel_attendance);
				panel_attendance.setBackground(new Color(224, 255, 255));
				panel_attendance.setLayout(null);
				
					JLabel lblAttendancePage = new JLabel("Attendance page ");
					lblAttendancePage.setHorizontalAlignment(SwingConstants.CENTER);
					lblAttendancePage.setFont(new Font("Times New Roman", Font.BOLD, 28));
					lblAttendancePage.setBounds(386, 5, 206, 33);
					panel_attendance.add(lblAttendancePage);
				
		
		
		
	}
}
