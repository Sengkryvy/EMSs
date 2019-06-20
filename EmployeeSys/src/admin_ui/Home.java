package admin_ui;

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
import model.EmployeeModel;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;

public class Home {

	public JFrame frame;
	
	//panel 
	private JPanel panel_message;
	private JPanel panel_attendance;
	private JPanel panel_promote;
	private JPanel panel_permission ;
	private JPanel panel_showStaff;
	private JTable table_employees;
	static DefaultTableModel model;
	
	//textField
	private JTextField textField;
	
	//label
	private JLabel lblMessage;
	private JLabel tittle;
	
	//button
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnSearch;
	private JButton btnAdd;
	
	
	//variables
	private Employees em = new Employees();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		});
	}

	public Home() {
		initialize();
	}
	
	public static void fill_table() {
		ArrayList<Employees> list = EmployeeModel.all();
		//DefaultTableModel model = (DefaultTableModel) table_employees.getModel();
		Object[] row = new Object[8];
		//String[] row = new String[8];
		for (Employees e : list) {
			row[0] = e.getID();
			row[1] = e.getFirstname();
			row[2] = e.getLastname();
			row[3] = e.getEmail();
			row[4] = e.getDob();
			row[5] = e.getPhone();
			row[6] = e.getPosition();
			row[7] = e.getSalary();
			model.addRow(row);
		}
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
			tittle = new JLabel("Staff");
			tittle.setHorizontalAlignment(SwingConstants.CENTER);
			tittle.setFont(new Font("Times New Roman", Font.BOLD, 24));
			tittle.setBounds(511, 0, 286, 59);
			bar.add(tittle);
			
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
			
			//Message button
			lblMessage = new JLabel("Message");
			lblMessage.setBounds(1032, 0, 141, 59);
			bar.add(lblMessage);
			lblMessage.setBackground(new Color(0, 255, 255));
			lblMessage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					panel_message.setVisible(true);
					panel_attendance.setVisible(false);
					panel_permission.setVisible(false);
					panel_promote.setVisible(false);
					tittle.setText("Message");
					panel_showStaff.setVisible(false);
				
				}
			});
			lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
			lblMessage.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		//Side-bar
		JPanel btn_sidebar = new JPanel();
		btn_sidebar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_sidebar.setBackground(SystemColor.activeCaption);
		btn_sidebar.setBounds(0, 57, 195, 563);
		frame.getContentPane().add(btn_sidebar);
		btn_sidebar.setLayout(null);
		
			//Button attendance
			JLabel lblCheckAttandent = new JLabel("Attendance");
			lblCheckAttandent.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panel_message.setVisible(false);
					panel_attendance.setVisible(true);	
					panel_permission.setVisible(false);
					panel_promote.setVisible(false);
					tittle.setText("Attandence");
					panel_showStaff.setVisible(false);
				}
			});
			lblCheckAttandent.setBounds(0, 85, 194, 59);
			btn_sidebar.add(lblCheckAttandent);
			lblCheckAttandent.setHorizontalAlignment(SwingConstants.CENTER);
			lblCheckAttandent.setFont(new Font("Times New Roman", Font.BOLD, 22));
			
			//Button permission
			JLabel lblPermission = new JLabel("Permission");
			lblPermission.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panel_message.setVisible(false);
					panel_attendance.setVisible(false);
					panel_permission.setVisible(true);
					panel_promote.setVisible(false);
					tittle.setText("Premission");
					panel_showStaff.setVisible(false);
					
				}
			});
			lblPermission.setBounds(0, 154, 194, 59);
			btn_sidebar.add(lblPermission);
			lblPermission.setHorizontalAlignment(SwingConstants.CENTER);
			lblPermission.setFont(new Font("Times New Roman", Font.BOLD, 22));
			
			//Button Add Employee
			btnAdd = new JButton("Add Employee");
			btnAdd.setBounds(32, 508, 137, 42);
			btn_sidebar.add(btnAdd);
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						AddEm addEM = new AddEm();
						addEM.frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			btnAdd.setForeground(new Color(255, 255, 255));
			btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnAdd.setBackground(new Color(0, 0, 255));
		//End of Side-bar//////////////////////////////////
			
			
		// Panel to Show all Employees
		JLabel lblAllStaff = new JLabel("All Staff");
		lblAllStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_message.setVisible(false);
				panel_attendance.setVisible(false);
				panel_permission.setVisible(false);
				panel_promote.setVisible(false);
				panel_showStaff.setVisible(true);
				tittle.setText("All staff");
			}
		});
		lblAllStaff.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllStaff.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAllStaff.setBounds(0, 13, 194, 59);
		btn_sidebar.add(lblAllStaff);
		
		panel_showStaff = new JPanel();
		panel_showStaff.setBackground(SystemColor.inactiveCaption);
		panel_showStaff.setBounds(196, 57, 977, 563);
		frame.getContentPane().add(panel_showStaff);
		panel_showStaff.setLayout(null);
		
			//Table of all Employees
			String[] column = { "eID", "First Name", "Last Name", "Email", "DoB", "Phone", "Position", "Salary" };
			model = new DefaultTableModel();
			JScrollPane scrollPane = new JScrollPane();
			model.setColumnIdentifiers(column); 
			scrollPane.setBounds(12, 13, 953, 482);
			panel_showStaff.add(scrollPane);
			table_employees = new JTable(model);
			fill_table();
			table_employees.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnDelete.setEnabled(true);
					btnEdit.setEnabled(true);
					int row = table_employees.getSelectedRow();
					int col = table_employees.getSelectedColumn();
					
					em.setID(Integer.parseInt(table_employees.getValueAt(row, 0).toString()));
					em.setFirstname(table_employees.getValueAt(row, 1).toString());
					em.setLastname(table_employees.getValueAt(row, 2).toString());
					em.setEmail(table_employees.getValueAt(row, 3).toString());
					em.setDob(table_employees.getValueAt(row, 4).toString());
					em.setPhone(table_employees.getValueAt(row, 5).toString());
					em.setPosition(table_employees.getValueAt(row, 6).toString());
					em.setSalary(Double.parseDouble(table_employees.getValueAt(row, 7).toString()));
					
					//System.out.println(row + " " + col + " = " + table_employees.getValueAt(row, col));
					//System.out.println(em.toString() + em.getID());
					
				}
			});
			scrollPane.setViewportView(table_employees);
				
				//Delete
				btnDelete = new JButton("Delete");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "DELETE");
						EmployeeModel.delete(em.getID());
						model.setRowCount(0);
						fill_table();
					}
				});
				btnDelete.setForeground(Color.WHITE);
				btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnDelete.setBackground(new Color(255, 0, 0));
				btnDelete.setBounds(828, 508, 137, 42);
				panel_showStaff.add(btnDelete);
				btnDelete.setEnabled(false);
				
				//Edit
				btnEdit = new JButton("Edit");
				btnEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EditEm editEm = new EditEm(em);
						editEm.frame.setVisible(true);
					}
				});
				btnEdit.setForeground(Color.WHITE);
				btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnEdit.setBackground(new Color(255, 140, 0));
				btnEdit.setBounds(666, 508, 137, 42);
				panel_showStaff.add(btnEdit);
				btnEdit.setEnabled(false);
				
				//Search
				textField = new JTextField();
				textField.setBounds(12, 508, 324, 42);
				panel_showStaff.add(textField);
				textField.setColumns(10);
			
				btnSearch = new JButton("Search");
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				btnSearch.setForeground(Color.WHITE);
				btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnSearch.setBackground(new Color(128, 128, 128));
				btnSearch.setBounds(348, 508, 137, 42);
				panel_showStaff.add(btnSearch);
		//End of Show Staff///////////////////////////////
				
				
		//Panel Message
		panel_message = new JPanel();
		panel_message.setBackground(new Color(224, 255, 255));
		panel_message.setBounds(194, 57, 979, 563);
		frame.getContentPane().add(panel_message);
		
			JLabel lblMessagePage = new JLabel("Message page ");
			lblMessagePage.setHorizontalAlignment(SwingConstants.CENTER);
			lblMessagePage.setFont(new Font("Times New Roman", Font.BOLD, 28));
			lblMessagePage.setBounds(369, 175, 355, 76);
			panel_message.add(lblMessagePage);
		
		//Panel Promote
		panel_promote = new JPanel();
		panel_promote.setBackground(new Color(224, 255, 255));
		panel_promote.setBounds(194, 60, 979, 560);
		frame.getContentPane().add(panel_promote);
		panel_promote.setLayout(null);
		
			JLabel lblPromotePage = new JLabel("Promote page ");
			lblPromotePage.setHorizontalAlignment(SwingConstants.CENTER);
			lblPromotePage.setFont(new Font("Times New Roman", Font.BOLD, 28));
			lblPromotePage.setBounds(369, 175, 355, 76);
			panel_promote.add(lblPromotePage);
		
		//Panel Permission
		panel_permission = new JPanel();
		panel_permission.setBackground(new Color(224, 255, 255));
		panel_permission.setBounds(194, 61, 979, 559);
		frame.getContentPane().add(panel_permission);
		panel_permission.setLayout(null);
		
			JLabel lblPermissionPage = new JLabel("Premission page ");
			lblPermissionPage.setHorizontalAlignment(SwingConstants.CENTER);
			lblPermissionPage.setFont(new Font("Times New Roman", Font.BOLD, 28));
			lblPermissionPage.setBounds(388, 5, 202, 33);
			panel_permission.add(lblPermissionPage);
		
		//Panel Attendance
		panel_attendance = new JPanel();
		panel_attendance.setBackground(new Color(224, 255, 255));
		panel_attendance.setBounds(194, 60, 979, 560);
		frame.getContentPane().add(panel_attendance);
		panel_message.setLayout(null);
		panel_attendance.setLayout(null);
		
			JLabel lblAttendancePage = new JLabel("Attendance page ");
			lblAttendancePage.setHorizontalAlignment(SwingConstants.CENTER);
			lblAttendancePage.setFont(new Font("Times New Roman", Font.BOLD, 28));
			lblAttendancePage.setBounds(386, 5, 206, 33);
			panel_attendance.add(lblAttendancePage);
		
		
		
	}
}
