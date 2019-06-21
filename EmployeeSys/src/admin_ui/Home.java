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
import employeeClass.Permission;
import model.EmployeeModel;
import model.PermissionModel;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;

public class Home {

	public JFrame frame;
	
	//panel 
	private JPanel panel_attendance;
	private JPanel panel_permission ;
	private JPanel panel_showStaff;
	private JTable table_employees;
	static DefaultTableModel model_employees;
	static DefaultTableModel model_permission;
//	EmployeeModel employeeModel = new EmployeeModel();
	
	//textField
	private JTextField textField_search;
	
	//label
	private JLabel tittle;
	
	//button
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnSearch;
	private JButton btnAdd;
	
	
	//variables
	private Employees em = new Employees();
	private JPanel panel_main;
	private JTable table_permission;
	private JScrollPane scrollPane_permission_table;
	
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
	
	public static void fill_tableEmployee(ArrayList<Employees> list) {
//		ArrayList<Employees> list = EmployeeModel.all();
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
			model_employees.addRow(row);
		}
	}

	public static void fill_tablePermission() {
		ArrayList<Permission> list = PermissionModel.all();
		//DefaultTableModel model = (DefaultTableModel) table_employees.getModel();
		Object[] row = new Object[7];
		//String[] row = new String[8];
		for (Permission p : list) {
			row[0] = p.getId();
			row[1] = p.geteID();
			row[2] = p.getType();
			row[3] = p.getApplyDate();
			row[4] = p.getLeavingDate();
			row[5] = p.getReason();
			row[6] = p.getStatus();
			model_permission.addRow(row);
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
			tittle = new JLabel("All Staff");
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
					tittle.setText("Attandence");
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
					tittle.setText("Permission");
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
			
			
		JLabel lblAllStaff = new JLabel("All Staff");
		lblAllStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_main.removeAll();
				panel_main.repaint();
				panel_main.revalidate();
				
				panel_main.add(panel_showStaff);
				panel_main.repaint();
				panel_main.revalidate();
				tittle.setText("All staff");
				model_employees.setRowCount(0);
				fill_tableEmployee(EmployeeModel.all());
			}
		});
		lblAllStaff.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllStaff.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAllStaff.setBounds(0, 13, 193, 59);
		btn_sidebar.add(lblAllStaff);
		
		//Panel main
		panel_main = new JPanel();
		panel_main.setBounds(194, 60, 979, 559);
		frame.getContentPane().add(panel_main);
		panel_main.setLayout(null);
		//End of Show Staff///////////////////////////////
		
		// Panel to Show all Employees
		
				//Table of all Employees
				String[] employee_columnName = { "eID", "First Name", "Last Name", "Email", "DoB", "Phone", "Position", "Salary" };
				model_employees = new DefaultTableModel();
				model_employees.setColumnIdentifiers(employee_columnName); 
				
				fill_tableEmployee(EmployeeModel.all());
				
				panel_showStaff = new JPanel();
				panel_showStaff.setBounds(1, -2, 977, 563);
				panel_main.add(panel_showStaff);
				panel_showStaff.setBackground(SystemColor.inactiveCaption);
				panel_showStaff.setLayout(null);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(12, 13, 953, 482);
				panel_showStaff.add(scrollPane);
				table_employees = new JTable(model_employees);
				table_employees.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						btnDelete.setEnabled(true);
						btnEdit.setEnabled(true);
						int row = table_employees.getSelectedRow();
						
						em.setID(Integer.parseInt(table_employees.getValueAt(row, 0).toString()));
						em.setFirstname(table_employees.getValueAt(row, 1).toString());
						em.setLastname(table_employees.getValueAt(row, 2).toString());
						em.setEmail(table_employees.getValueAt(row, 3).toString());
						em.setDob(table_employees.getValueAt(row, 4).toString());
						em.setPhone(table_employees.getValueAt(row, 5).toString());
						em.setPosition(table_employees.getValueAt(row, 6).toString());
						em.setSalary(Double.parseDouble(table_employees.getValueAt(row, 7).toString()));
						
						
					}
				});
				scrollPane.setViewportView(table_employees);
				
				//Delete
				
				btnDelete = new JButton("Delete");
//				btnDelete.setVisible(false);
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int input = JOptionPane.showConfirmDialog(null, "Do you want to cancel it ?", "Cancel",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
					  if(input==0) {
						  if(EmployeeModel.delete(em.getID())) {
								model_employees.setRowCount(0);
								fill_tableEmployee(EmployeeModel.all());
						  } else {
							  JOptionPane.showMessageDialog(null, "Error deleting Employee Make Sure This employee do not has any Permission record");
						  }

					  }   

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
//				btnEdit.setVisible(false);
				
				//Search
				textField_search = new JTextField();
				textField_search.setBounds(12, 508, 324, 42);
				panel_showStaff.add(textField_search);
				textField_search.setColumns(10);
				
					btnSearch = new JButton("Search");
					btnSearch.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if (textField_search.getText().length() != 0) {
								ArrayList<Employees> list = new ArrayList<>();
								list = EmployeeModel.search(textField_search.getText());
								model_employees.setRowCount(0);
								fill_tableEmployee(list);
								for (int i=0; i<list.size(); i++) {
									System.out.println(list.get(i).toString());
								}
							} else {
								JOptionPane.showMessageDialog(null, "Error! Please input anything.");
							}
						}
					});
					btnSearch.setForeground(Color.WHITE);
					btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
					btnSearch.setBackground(new Color(128, 128, 128));
					btnSearch.setBounds(348, 508, 137, 42);
					panel_showStaff.add(btnSearch);
				
				//Panel Permi	ssion
				panel_permission = new JPanel();
				panel_permission.setBounds(1, -2, 977, 563);
				panel_main.add(panel_permission);
				panel_permission.setBackground(SystemColor.inactiveCaption);
				panel_permission.setLayout(null);
				
				//Table of Permission
				String[] permission_ColumnName = {"id", "eID", "Type", "ApplyDate", "LeavingDate", "Leaving Date", "Status"};
				model_permission = new DefaultTableModel();
				model_permission.setColumnIdentifiers(permission_ColumnName);
				fill_tablePermission();
	
				
				scrollPane_permission_table = new JScrollPane();
				scrollPane_permission_table.setBounds(12, 13, 953, 537);
				panel_permission.add(scrollPane_permission_table);
				table_permission = new JTable(model_permission);
				scrollPane_permission_table.setViewportView(table_permission);
				
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
				
				scrollPane_permission_table = new JScrollPane();
				scrollPane_permission_table.setBounds(12, 13, 953, 537);
				panel_permission.add(scrollPane_permission_table);
				table_permission = new JTable(model_permission);
				scrollPane_permission_table.setViewportView(table_permission);
				
		
		
		
	}
}
