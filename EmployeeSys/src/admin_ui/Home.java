package admin_ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
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
	JLabel lblMessage;
	JPanel panel_message;
	JPanel panel_attendance;
	JPanel panel_promote;
	JPanel panel_premission ;
	JLabel tittle;
	JPanel panel_showStaff;
	private JTable table_employees;
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}
	
	public void show_all_employee() {
		ArrayList<Employees> list = EmployeeModel.all();
		DefaultTableModel model = (DefaultTableModel) table_employees.getModel();
		Object[] row = new Object[8];
		String[] column = { "eID", "first_name", "last_name", "email", "dob", "phone", "position", "salary" };
		
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1191, 667);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel bar = new JPanel();
		bar.setBorder(new LineBorder(new Color(0, 0, 0)));
		bar.setBackground(SystemColor.activeCaption);
		bar.setBounds(0, 0, 1173, 59);
		frame.getContentPane().add(bar);
		bar.setLayout(null);
		
		tittle = new JLabel("Staff");
		tittle.setHorizontalAlignment(SwingConstants.CENTER);
		tittle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		tittle.setBounds(511, 0, 286, 59);
		bar.add(tittle);
		
		JLabel lblDate = new JLabel();
		lblDate.setForeground(Color.BLUE);
		long mill= System.currentTimeMillis();
		lblDate.setText(new Date(mill).toString());
		lblDate.setBounds(0, 3, 194, 58);
		bar.add(lblDate);
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(193, -4, 2, 65);
		bar.add(separator);
		separator.setOrientation(SwingConstants.VERTICAL);
		
		lblMessage = new JLabel("Message");
		lblMessage.setBounds(1032, 0, 141, 59);
		bar.add(lblMessage);
		lblMessage.setBackground(new Color(0, 255, 255));
		lblMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_message.setVisible(true);
				panel_attendance.setVisible(false);
				panel_premission.setVisible(false);
				panel_promote.setVisible(false);
				tittle.setText("Message");
				panel_showStaff.setVisible(false);
			
			}
		});
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		JPanel btn_content = new JPanel();
		btn_content.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_content.setBackground(SystemColor.activeCaption);
		btn_content.setBounds(0, 57, 195, 563);
		frame.getContentPane().add(btn_content);
		btn_content.setLayout(null);
		
		JLabel lblCheckAttandent = new JLabel("Attendance");
		lblCheckAttandent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_message.setVisible(false);
				panel_attendance.setVisible(true);	
				panel_premission.setVisible(false);
				panel_promote.setVisible(false);
				tittle.setText("Attandence");
				panel_showStaff.setVisible(false);
			}
		});
		lblCheckAttandent.setBounds(0, 85, 194, 59);
		btn_content.add(lblCheckAttandent);
		lblCheckAttandent.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckAttandent.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		JLabel lblPremission = new JLabel("Premission");
		lblPremission.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_message.setVisible(false);
				panel_attendance.setVisible(false);
				panel_premission.setVisible(true);
				panel_promote.setVisible(false);
				tittle.setText("Premission");
				panel_showStaff.setVisible(false);
				
			}
		});
		lblPremission.setBounds(0, 154, 194, 59);
		btn_content.add(lblPremission);
		lblPremission.setHorizontalAlignment(SwingConstants.CENTER);
		lblPremission.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		JLabel lblPromote = new JLabel("Promote");
		lblPromote.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_message.setVisible(false);
				panel_attendance.setVisible(false);
				panel_premission.setVisible(false);
				panel_promote.setVisible(true);
				panel_showStaff.setVisible(false);
				tittle.setText("Promote page");
			}
			
		});
		lblPromote.setBounds(0, 226, 194, 59);
		btn_content.add(lblPromote);
		lblPromote.setHorizontalAlignment(SwingConstants.CENTER);
		lblPromote.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		JButton btnAddEmployee = new JButton("Add Employe");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				try {
					AddEm addEM = new AddEm();
					addEM.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

		JLabel lblAllStaff = new JLabel("All Staff");
		lblAllStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_message.setVisible(false);
				panel_attendance.setVisible(false);
				panel_premission.setVisible(false);
				panel_promote.setVisible(false);
				panel_showStaff.setVisible(true);
				tittle.setText("All staff");
			}
		});
		lblAllStaff.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllStaff.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAllStaff.setBounds(0, 13, 194, 59);
		btn_content.add(lblAllStaff);
		
		panel_showStaff = new JPanel();
		panel_showStaff.setBackground(SystemColor.inactiveCaption);
		panel_showStaff.setBounds(196, 57, 977, 563);
		frame.getContentPane().add(panel_showStaff);
		panel_showStaff.setLayout(null);
		
		
		//All Staff
		JLabel label = new JLabel("All Staff");
		label.setBounds(450, 13, 79, 27);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_showStaff.add(label);
		
			String[] column = { "eID", "First Name", "Last Name", "Email", "DoB", "Phone", "Position", "Salary" };
			DefaultTableModel model = new DefaultTableModel();
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 59, 953, 491);
			panel_showStaff.add(scrollPane);
			table_employees = new JTable(model);
			scrollPane.setViewportView(table_employees);
			for (int i=0; i<8; i++) {
				model.addColumn(column[i]);
			}
			
			show_all_employee();
		
			
		// Add Employee
		btnAddEmployee.setForeground(new Color(255, 255, 255));
		btnAddEmployee.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddEmployee.setBackground(new Color(0, 0, 255));
		btnAddEmployee.setBounds(28, 497, 137, 42);
		btn_content.add(btnAddEmployee);
		
		panel_message = new JPanel();
		panel_message.setBackground(new Color(224, 255, 255));
		panel_message.setBounds(194, 57, 979, 563);
		frame.getContentPane().add(panel_message);
		
		// Message Page
		JLabel lblMessagePage = new JLabel("Message page ");
		lblMessagePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessagePage.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblMessagePage.setBounds(369, 175, 355, 76);
		panel_message.add(lblMessagePage);
		
		
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
		
		panel_premission = new JPanel();
		panel_premission.setBackground(new Color(224, 255, 255));
		panel_premission.setBounds(194, 61, 979, 559);
		frame.getContentPane().add(panel_premission);
		panel_premission.setLayout(null);
		
		JLabel lblPremissionPage = new JLabel("Premission page ");
		lblPremissionPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPremissionPage.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblPremissionPage.setBounds(388, 5, 202, 33);
		panel_premission.add(lblPremissionPage);
		
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
