package admin_ui;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import employeeClass.Employees;
import model.EmployeeModel;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;

public class AddEm {

	public JFrame frame;
	private JTextField textField_firstName;
	private JTextField textField_lastName;
	private JLabel lblBirthOfDate;
	private JTextField textField_email;
	private JTextField textField_phone;
	private JLabel lblCancel;
	private JTextField textField_salary;
	private JDateChooser dateChooser_dob;
	private JLabel lblSalary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEm window = new AddEm();
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
	public AddEm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 705, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Employee");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(203, 37, 278, 31);
		frame.getContentPane().add(lblNewLabel);
		
		textField_firstName = new JTextField();
		textField_firstName.setBounds(229, 112, 279, 31);
		frame.getContentPane().add(textField_firstName);
		textField_firstName.setColumns(10);
		
		JLabel lblEid = new JLabel("First Name :");
		lblEid.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblEid.setHorizontalAlignment(SwingConstants.CENTER);
		lblEid.setBounds(46, 115, 151, 27);
		frame.getContentPane().add(lblEid);
		
		textField_lastName = new JTextField();
		textField_lastName.setColumns(10);
		textField_lastName.setBounds(229, 156, 279, 31);
		frame.getContentPane().add(textField_lastName);
		
		JLabel lblFullName = new JLabel("Last Name : ");
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblFullName.setBounds(38, 155, 178, 27);
		frame.getContentPane().add(lblFullName);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(229, 236, 279, 31);
		frame.getContentPane().add(textField_email);
		
		lblBirthOfDate = new JLabel("Date of Birth :");
		lblBirthOfDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthOfDate.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblBirthOfDate.setBounds(23, 200, 178, 27);
		frame.getContentPane().add(lblBirthOfDate);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblEmail.setBounds(71, 240, 146, 27);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblPhone.setBounds(71, 280, 146, 27);
		frame.getContentPane().add(lblPhone);
		
		textField_phone = new JTextField();
		textField_phone.setColumns(10);
		textField_phone.setBounds(229, 280, 279, 31);
		frame.getContentPane().add(textField_phone);
		
		JLabel lblPosition = new JLabel("Position :");
		lblPosition.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosition.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblPosition.setBounds(60, 325, 146, 27);
		frame.getContentPane().add(lblPosition);
		
		dateChooser_dob = new JDateChooser();
		dateChooser_dob.setDateFormatString("yyyy-MM-dd");
		dateChooser_dob.setBounds(229, 197, 279, 30);
		frame.getContentPane().add(dateChooser_dob);
		
		String[] position = {
				"Employee",
				"Manager",
		};
		JComboBox comboBox_position = new JComboBox(position);

		comboBox_position.setBounds(229, 324, 278, 31);
		frame.getContentPane().add(comboBox_position);
		
		lblSalary = new JLabel("Salary :");
		lblSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalary.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblSalary.setBounds(84, 369, 114, 27);
		frame.getContentPane().add(lblSalary);
		
		textField_salary = new JTextField();
		textField_salary.setColumns(10);
		textField_salary.setBounds(229, 368, 279, 31);
		frame.getContentPane().add(textField_salary);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				frame.dispose();

				if (textField_firstName.getText().equals("")||textField_lastName.getText().equals("")||textField_phone.getText().equals("")||comboBox_position.getSelectedItem().toString().equals("")
						||textField_salary.getText().equals("")) {
					int input = JOptionPane.showConfirmDialog(null, "Missing something", "Missing",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				   	if(input==2) {
				   		frame.dispose();
				   		Home home= new Home();
				   		home.frame.setVisible(true);	   		
				  }   
				}else {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(dateChooser_dob.getDate());
					Employees em = new Employees(textField_firstName.getText(), textField_lastName.getText(), textField_email.getText(), date, textField_phone.getText(),
												comboBox_position.getSelectedItem().toString(), Double.parseDouble(textField_salary.getText()));
					try {
						if (EmployeeModel.create(em)) {
							frame.dispose();
							ShowAllEmploye show = new ShowAllEmploye();
							show.frame.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Error adding employee to database");
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}	
			}
		});
		btnCreate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCreate.setBounds(291, 441, 114, 45);
		frame.getContentPane().add(btnCreate);
		
		lblCancel = new JLabel("cancel");
		lblCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int input = JOptionPane.showConfirmDialog(null, "Do you want to cancel it ?", "Cancel",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
			   	if(input==0) {
			   		frame.dispose();
			   		Home home= new Home();
			   		home.frame.setVisible(true);
			  }   
			}
		});
		lblCancel.setForeground(new Color(255, 0, 0));
		lblCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCancel.setBounds(323, 499, 56, 16);
		frame.getContentPane().add(lblCancel);
		
	}
}
