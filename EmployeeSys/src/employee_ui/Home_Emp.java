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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import classes.Employees;
import classes.Permission;
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
	static DefaultTableModel model_permission;
	JLabel lblProfile;
	
	private JTextField textField_firstName;
	private JTextField textField_lastName;
	private JLabel lblBirthOfDate;
	private JTextField textField_email;
	private JTextField textField_phone;
	private JDateChooser dateChooser_dob;
	private JButton btnUpdate;
	int id;
	Permission p = new Permission();

	
	//label
	private JLabel lblTitle;
	
	//button
	private JButton btnEdit_Profile;
	
	
	//variables
	private Employees em = new Employees();
	private JPanel panel_main;
	private JTextField textField_position;
	private JTextField textField_salary;
	private JButton btnChangePassword;
	private JTable table_permission;
	private JScrollPane scrollPane_permission_table;
	private JButton btnCreatePermission;
	private JButton btnDelete;
	private JButton btnEdit_Permission;
	int eID;
	
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
		eID = em.getID();
		initialize();
	}
	
	public static void fill_tablePermission(int eID) {
		ArrayList<Permission> list = PermissionModel.all(eID);
		Object[] row = new Object[7];
		for (Permission p : list) {
			row[0] = p.getId();
			row[1] = p.getType();
			row[2] = p.getApplyDate();
			row[3] = p.getLeavingDate();
			row[4] = p.getToDate();
			row[5] = p.getReason();
			row[6] = p.getStatus();
			model_permission.addRow(row);
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1085, 667);
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
			lblTitle = new JLabel("Profile");
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
			lblTitle.setBounds(498, 2, 286, 59);
			bar.add(lblTitle);
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
//			lblCheckAttandent.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					lblTitle.setText("Attandence");
//					panel_main.removeAll();
//					panel_main.repaint();
//					panel_main.revalidate();
//					
//					panel_main.add(panel_attendance);
//					panel_main.repaint();
//					panel_main.revalidate();
//				}
//			});
			lblCheckAttandent.setBounds(0, 157, 193, 59);
			btn_sidebar.add(lblCheckAttandent);
			lblCheckAttandent.setHorizontalAlignment(SwingConstants.CENTER);
			lblCheckAttandent.setFont(new Font("Times New Roman", Font.BOLD, 22));
			//Button permission
			JLabel lblPermission = new JLabel("Permission");
			lblPermission.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblProfile.setForeground(new Color(0, 0, 0));
					lblPermission.setForeground(new Color(0, 0, 255));
					lblCheckAttandent.setForeground(new Color(0, 0, 0));
					model_permission.setRowCount(0);
					btnEdit_Permission.setEnabled(false);
					btnDelete.setEnabled(false);
					fill_tablePermission(em.getID());
					lblTitle.setText("Permission");
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
			//Button Profile
			lblProfile = new JLabel("Profile");
			lblProfile.setForeground(new Color(0, 0, 255));
			lblProfile.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblProfile.setForeground(new Color(0, 0, 255));
					lblPermission.setForeground(new Color(0, 0, 0));
					lblCheckAttandent.setForeground(new Color(0, 0, 0));
					panel_main.removeAll();
					panel_main.repaint();
					panel_main.revalidate();
					
					panel_main.add(panel_profile);
					panel_main.repaint();
					panel_main.revalidate();
					lblTitle.setText("Profile");
				}
			});
			lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
			lblProfile.setFont(new Font("Times New Roman", Font.BOLD, 22));
			lblProfile.setBounds(0, 13, 193, 59);
			btn_sidebar.add(lblProfile);
		//End of Side-bar//////////////////////////////////
		
		//Panel main
		panel_main = new JPanel();
		panel_main.setBounds(194, 60, 979, 559);
		frame.getContentPane().add(panel_main);
		panel_main.setLayout(null);
			// Panel to Profile
			panel_profile = new JPanel();
			panel_profile.setBounds(0, 0, 873, 561);
			panel_main.add(panel_profile);
			panel_profile.setBackground(SystemColor.inactiveCaption);
			panel_profile.setLayout(null);
			//Edit
			btnEdit_Profile = new JButton("Edit Profile");
			btnEdit_Profile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnUpdate.setVisible(true);
					btnEdit_Profile.setVisible(false);
					textField_firstName.setEditable(true);
					textField_lastName.setEditable(true);
					textField_email.setEditable(true);
					textField_phone.setEditable(true);
					dateChooser_dob.setEnabled(true);
				}
			});
			//Profile_panel
			JLabel lblFirstName = new JLabel("First Name :");
			lblFirstName.setBounds(174, 42, 151, 31);
			panel_profile.add(lblFirstName);
			lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 22));
			lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
			//DOB
			dateChooser_dob = new JDateChooser();
			dateChooser_dob.getCalendarButton().setText("Date");
			dateChooser_dob.setBounds(353, 233, 279, 30);
			dateChooser_dob.setEnabled(false);
			panel_profile.add(dateChooser_dob);
			dateChooser_dob.setDateFormatString("yyyy-MM-dd");
			//Edit Profile
			btnEdit_Profile.setForeground(Color.WHITE);
			btnEdit_Profile.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnEdit_Profile.setBackground(new Color(255, 140, 0));
			btnEdit_Profile.setBounds(495, 484, 137, 42);
			panel_profile.add(btnEdit_Profile);
			panel_profile.add(lblFirstName);
			//FirstName
			textField_firstName = new JTextField();
			textField_firstName.setEditable(false);
			textField_firstName.setBounds(353, 42, 279, 31);
			panel_profile.add(textField_firstName);
			textField_firstName.setColumns(10);
			//LastName
			textField_lastName = new JTextField();
			textField_lastName.setEditable(false);
			textField_lastName.setBounds(353, 103, 279, 31);
			panel_profile.add(textField_lastName);
			textField_lastName.setColumns(10);
			JLabel lblFullName = new JLabel("Last Name :");
			lblFullName.setBounds(197, 103, 128, 31);
			panel_profile.add(lblFullName);
			lblFullName.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFullName.setFont(new Font("Times New Roman", Font.BOLD, 22));
			//Email
			textField_email = new JTextField();
			textField_email.setEditable(false);
			textField_email.setBounds(353, 164, 279, 31);
			panel_profile.add(textField_email);
			textField_email.setColumns(10);
			JLabel lblEmail = new JLabel("Email :");
			lblEmail.setBounds(179, 168, 146, 31);
			panel_profile.add(lblEmail);
			lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
			lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 22));
			//DOB
			lblBirthOfDate = new JLabel("Date of Birth :");
			lblBirthOfDate.setBounds(147, 234, 178, 31);
			panel_profile.add(lblBirthOfDate);
			lblBirthOfDate.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBirthOfDate.setFont(new Font("Times New Roman", Font.BOLD, 22));
			//Phone
			JLabel lblPhone = new JLabel("Phone :");
			lblPhone.setBounds(179, 303, 146, 31);
			panel_profile.add(lblPhone);
			lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 22));
			textField_phone = new JTextField();
			textField_phone.setEditable(false);
			textField_phone.setBounds(353, 299, 279, 31);
			panel_profile.add(textField_phone);
			textField_phone.setColumns(10);
			//Salary
			JLabel lblSalalry = new JLabel("Position :");
			lblSalalry.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSalalry.setFont(new Font("Times New Roman", Font.BOLD, 22));
			lblSalalry.setBounds(179, 360, 146, 31);
			panel_profile.add(lblSalalry);
			JLabel lblSalary = new JLabel("Salary :");
			lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSalary.setFont(new Font("Times New Roman", Font.BOLD, 22));
			lblSalary.setBounds(179, 416, 146, 31);
			panel_profile.add(lblSalary);
			//Filling info corresponding to Login-ed employee
			textField_position = new JTextField();
			textField_position.setText((String) null);
			textField_position.setEditable(false);
			textField_position.setColumns(10);
			textField_position.setBounds(353, 360, 279, 31);
			panel_profile.add(textField_position);
			//
			textField_salary = new JTextField();
			textField_salary.setText((String) null);
			textField_salary.setEditable(false);
			textField_salary.setColumns(10);
			textField_salary.setBounds(353, 416, 279, 31);
			panel_profile.add(textField_salary);
			//
			textField_firstName.setText(em.getFirstname());
			textField_lastName.setText(em.getLastname());
			textField_email.setText(em.getEmail());
			dateChooser_dob.setDateFormatString("yyyy-MM-dd");
			dateChooser_dob.setDate(Date.valueOf(em.getDob()));
			textField_position.setText(em.getPosition());
			textField_phone.setText(em.getPhone());
			textField_salary.setText(Double.toString(em.getSalary()));
			//ButtonUpdate
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					em.setFirstname(textField_firstName.getText());
					em.setLastname(textField_lastName.getText());
					em.setEmail(textField_email.getText());
					em.setPhone(textField_phone.getText());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(dateChooser_dob.getDate());
					em.setDob(date);
					if (textField_firstName.getText().equals("")||textField_lastName.getText().equals("")||textField_phone.getText().equals("")||textField_email.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill all informations.");
					} else {
						if(EmployeeModel.edit(em)) {
							btnEdit_Profile.setVisible(true);
							btnUpdate.setVisible(false);
							textField_firstName.setEditable(false);
							textField_lastName.setEditable(false);
							textField_email.setEditable(false);
							textField_phone.setEditable(false);
							dateChooser_dob.setEnabled(false);
							JOptionPane.showMessageDialog(null, "Information updated");
						} else {
							JOptionPane.showMessageDialog(null, "Error updating information.");
						}						
					}

				}
			});
			btnUpdate.setForeground(Color.WHITE);
			btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnUpdate.setBackground(new Color(0, 0, 205));
			btnUpdate.setBounds(495, 484, 137, 42);
			btnUpdate.setVisible(false);
			panel_profile.add(btnUpdate);
			//ChangePW
			btnChangePassword = new JButton("Change Password");
			btnChangePassword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Change_pw_emp change_pw_emp = new Change_pw_emp(em);
					change_pw_emp.frame.setVisible(true);
				}
			});
			btnChangePassword.setBounds(289, 484, 170, 42);
			panel_profile.add(btnChangePassword);
			btnChangePassword.setForeground(Color.WHITE);
			btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnChangePassword.setBackground(new Color(0, 128, 0));

			//End of Profile panel///////////////////////////////
											
			//Panel Permission
			panel_permission = new JPanel();
			panel_permission.setBounds(1, -2, 872, 563);
			panel_main.add(panel_permission);
			panel_permission.setBackground(SystemColor.inactiveCaption);
			panel_permission.setLayout(null);
			//PermissionTable
			
			//PermissionModel
			String[] columnName = {"id", "Type", "SubmittedDate", "FromDate", "ToDate", "Reason", "Status"};
			model_permission = new DefaultTableModel() {
				@Override
			    public boolean isCellEditable(int row, int column) {
			       return false;
			    }
			};
			model_permission.setColumnIdentifiers(columnName);
			fill_tablePermission(em.getID());
			scrollPane_permission_table = new JScrollPane();
			scrollPane_permission_table.setBounds(12, 13, 848, 474);
			panel_permission.add(scrollPane_permission_table);
			table_permission = new JTable(model_permission);
			table_permission.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					int row = table_permission.getSelectedRow();
					if (e.getClickCount() == 2) {
//								System.out.println("Double clicked");
					}
					id = (int) table_permission.getValueAt(row, 0);
					p.setId(id);
					p.seteID(eID);
					p.setType(table_permission.getValueAt(row, 1).toString());
					p.setLeavingDate(table_permission.getValueAt(row, 3).toString());
					p.setToDate(table_permission.getValueAt(row, 4).toString());
					p.setReason(table_permission.getValueAt(row, 5).toString());
					if (table_permission.getValueAt(row, 6).equals("Not Respond")) {
						btnEdit_Permission.setEnabled(true);
						btnDelete.setEnabled(true);
					} else {
						btnEdit_Permission.setEnabled(false);
						btnDelete.setEnabled(false);
					}
					
				}
			});
			scrollPane_permission_table.setViewportView(table_permission);
			//CreatePermission
			btnCreatePermission = new JButton("Create Permission");
			btnCreatePermission.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Create_permission_record create_permission = new Create_permission_record(em.getID());
					create_permission.frame.setVisible(true);
				}
			});
			btnCreatePermission.setForeground(Color.WHITE);
			btnCreatePermission.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnCreatePermission.setBackground(new Color(0, 0, 128));
			btnCreatePermission.setBounds(12, 508, 176, 42);
			panel_permission.add(btnCreatePermission);
			
			btnEdit_Permission = new JButton("Edit");
			btnEdit_Permission.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnEdit_Permission.setEnabled(false);
					btnDelete.setEnabled(false);
					Edit_Permission edit_Permission = new Edit_Permission(eID, p);
					edit_Permission.frame.setVisible(true);
				}
			});
			btnEdit_Permission.setForeground(Color.WHITE);
			btnEdit_Permission.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnEdit_Permission.setBackground(new Color(255, 140, 0));
			btnEdit_Permission.setBounds(622, 508, 106, 42);
			panel_permission.add(btnEdit_Permission);
			
			//DeletePermission
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int input = JOptionPane.showConfirmDialog(null, "Do you want to cancel it ?", "Cancel",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
					if(input==0) {
						if(PermissionModel.delete(id)) {
							btnDelete.setEnabled(false);
							btnEdit_Permission.setEnabled(false);
							model_permission.setRowCount(0);
							fill_tablePermission(eID);
							JOptionPane.showMessageDialog(null, "Deleted.");
						} else {
						  JOptionPane.showMessageDialog(null, "Error deleting Permission!");
						}

					} ;
				}
			});
			btnDelete.setForeground(Color.WHITE);
			btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnDelete.setBackground(new Color(178, 34, 34));
			btnDelete.setBounds(754, 508, 106, 42);
			panel_permission.add(btnDelete);

				
					//initial Profile panel
					panel_main.removeAll();
					panel_main.repaint();
					panel_main.revalidate();
					panel_main.repaint();
					panel_main.revalidate();
					panel_main.add(panel_profile);
					//End of permission panel
						
						
						//Panel Attendance
						panel_attendance = new JPanel();
						panel_attendance.setBounds(1, -2, 872, 563);
						panel_main.add(panel_attendance);
						panel_attendance.setBackground(new Color(224, 255, 255));
						panel_attendance.setLayout(null);

					lblTitle.setText("Profile");
		
		
		
	}
}
