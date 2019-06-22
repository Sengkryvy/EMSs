package employee_ui;

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
	private JPanel panel_showStaff;
	static DefaultTableModel model_employees;
	static DefaultTableModel model_permission;
	
	//label
	private JLabel tittle_profile;
	
	//button
	private JButton btnEdit;
	
	
	//variables
	private Employees em = new Employees();
	private JPanel panel_main;
	
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
		btn_sidebar.setBounds(0, 57, 194, 563);
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
				
				panel_main.add(panel_showStaff);
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
		//End of Show Staff///////////////////////////////
		
		// Panel to Show all Employees
				panel_showStaff = new JPanel();
				panel_showStaff.setBounds(1, -2, 977, 563);
				panel_main.add(panel_showStaff);
				panel_showStaff.setBackground(SystemColor.inactiveCaption);
				panel_showStaff.setLayout(null);
				
				
				//Edit
				btnEdit = new JButton("Edit Profile");
				btnEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Edit Profile");
					}
				});
				btnEdit.setForeground(Color.WHITE);
				btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnEdit.setBackground(new Color(255, 140, 0));
				btnEdit.setBounds(666, 508, 137, 42);
				panel_showStaff.add(btnEdit);
				btnEdit.setEnabled(false);
				
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
				
				//Panel Permission
				panel_permission = new JPanel();
				panel_permission.setBounds(1, -2, 977, 563);
				panel_main.add(panel_permission);
				panel_permission.setBackground(SystemColor.inactiveCaption);
				panel_permission.setLayout(null);
				
		
		
		
	}
}
