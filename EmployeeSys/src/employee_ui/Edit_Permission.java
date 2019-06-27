package employee_ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;

import model.PermissionModel;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import classes.Permission;

import javax.swing.JTextPane;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.beans.PropertyChangeEvent;

public class Edit_Permission {
	
	//variable declaration
	private	JTextPane textPane_reason;
	private	JDateChooser dateChooser_fromDate;
	@SuppressWarnings("rawtypes")
	private	JComboBox comboBox_type;
	JDateChooser dateChooser_toDate;
	String date = "";
	
	
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
					Edit_Permission window = new Edit_Permission();
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
	public Edit_Permission() {
		initialize();
	}
	
	public Edit_Permission(int id, Permission p) {
		eID = id;
		Edit_Permission.p = p;
		p.seteID(eID);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.getContentPane().setForeground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 572, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChangePassword = new JLabel("Update Permission Form");
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblChangePassword.setBounds(114, 31, 352, 31);
		frame.getContentPane().add(lblChangePassword);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			//On create click
			public void actionPerformed(ActionEvent e) {
				//check if the input are blank
				if (dateChooser_fromDate.getDate().toString().length() != 0 || textPane_reason.getText().length() != 0) {
					p.seteID(eID);
					p.setType(comboBox_type.getSelectedItem().toString());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					date = sdf.format(dateChooser_fromDate.getDate());
					String toDate = sdf.format(dateChooser_toDate.getDate());
					p.setLeavingDate(date);
					p.setToDate(toDate);
					p.setReason(textPane_reason.getText());
					//check if the creation success
					if (PermissionModel.edit(p)) {
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
		btnNewButton.setBounds(300, 396, 151, 39);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblType.setBounds(27, 98, 151, 31);
		frame.getContentPane().add(lblType);
		
		JLabel lblFromDate = new JLabel("From Date :");
		lblFromDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFromDate.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblFromDate.setBounds(27, 163, 151, 31);
		frame.getContentPane().add(lblFromDate);
		
		JLabel lblReason = new JLabel("Reason :");
		lblReason.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReason.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblReason.setBounds(27, 311, 151, 31);
		frame.getContentPane().add(lblReason);
		
		dateChooser_toDate = new JDateChooser();
		dateChooser_toDate.getCalendarButton().setText("Date");
		dateChooser_toDate.setDateFormatString("yyyy-MM-dd");
		dateChooser_toDate.setDate(Date.valueOf(p.getToDate()));
		dateChooser_toDate.setBounds(215, 233, 251, 39);
		dateChooser_toDate.getDateEditor().addPropertyChangeListener(
			    new PropertyChangeListener() {
			        @Override
			        public void propertyChange(PropertyChangeEvent e) {
			            if ("date".equals(e.getPropertyName())) {
			            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							date = sdf.format(dateChooser_fromDate.getDate());
			            	if (date.compareTo(sdf.format(dateChooser_toDate.getDate())) > 0) {
			            		dateChooser_toDate.setDate(java.sql.Date.valueOf(p.getToDate()));
			            		JOptionPane.showMessageDialog(null, "Please choose a date later than " + date);
			            	}
			            }
			        }
			    });
		frame.getContentPane().add(dateChooser_toDate);
		
		String[] leavingType = {
				"Early leave", "Sick Leave", "Personal leave"
		};
		comboBox_type = new JComboBox(leavingType);
		comboBox_type.setBounds(215, 100, 251, 39);
		frame.getContentPane().add(comboBox_type);
		
		dateChooser_fromDate = new JDateChooser();
		dateChooser_fromDate.getDateEditor().addPropertyChangeListener(
			    new PropertyChangeListener() {
			        @Override
			        public void propertyChange(PropertyChangeEvent e) {
			            if ("date".equals(e.getPropertyName())) {
			            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							date = sdf.format(dateChooser_fromDate.getDate());
//			            	dateChooser_toDate.setDate(java.sql.Date.valueOf(date));
			            	if (date.compareTo(sdf.format(dateChooser_toDate.getDate())) > 0) {
			            		dateChooser_toDate.setDate(java.sql.Date.valueOf(date));
//			            		JOptionPane.showMessageDialog(null, "Please choose a date later than " + date);
			            	}
			            }
			        }
			    });
		dateChooser_fromDate.getCalendarButton().setText("Date");
		dateChooser_fromDate.setDateFormatString("yyyy-MM-dd");
		dateChooser_fromDate.setDate(Date.valueOf(p.getLeavingDate()));
		dateChooser_fromDate.setBounds(215, 163, 251, 39);
		frame.getContentPane().add(dateChooser_fromDate);
		
		textPane_reason = new JTextPane();
		textPane_reason.setText(p.getReason());
		textPane_reason.setForeground(new Color(0, 0, 0));
		textPane_reason.setBounds(215, 301, 251, 67);
		frame.getContentPane().add(textPane_reason);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBackground(new Color(128, 0, 0));
		btnCancel.setBounds(114, 396, 151, 39);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblToDate = new JLabel("To Date :");
		lblToDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblToDate.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblToDate.setBounds(27, 233, 151, 31);
		frame.getContentPane().add(lblToDate);

	}
}
