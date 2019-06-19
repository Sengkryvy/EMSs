package admin_ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddEm {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblBirthOfDate;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lblCancel;

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
		
		textField = new JTextField();
		textField.setBounds(229, 112, 279, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEid = new JLabel(" EID :");
		lblEid.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblEid.setHorizontalAlignment(SwingConstants.CENTER);
		lblEid.setBounds(114, 113, 76, 27);
		frame.getContentPane().add(lblEid);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(229, 156, 279, 31);
		frame.getContentPane().add(textField_1);
		
		JLabel lblFullName = new JLabel("Full Name : ");
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblFullName.setBounds(39, 160, 178, 27);
		frame.getContentPane().add(lblFullName);
		
		lblBirthOfDate = new JLabel("Birth of Date : ");
		lblBirthOfDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthOfDate.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblBirthOfDate.setBounds(26, 200, 178, 27);
		frame.getContentPane().add(lblBirthOfDate);
		
		JLabel lblD = new JLabel("Day");
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblD.setBounds(203, 204, 56, 21);
		frame.getContentPane().add(lblD);
		
		textField_2 = new JTextField();
		textField_2.setBounds(252, 200, 42, 27);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblMonth = new JLabel("month");
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMonth.setBounds(293, 204, 56, 21);
		frame.getContentPane().add(lblMonth);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(347, 200, 42, 27);
		frame.getContentPane().add(textField_3);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblYear.setBounds(388, 204, 56, 21);
		frame.getContentPane().add(lblYear);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(439, 200, 69, 27);
		frame.getContentPane().add(textField_4);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblEmail.setBounds(71, 240, 146, 27);
		frame.getContentPane().add(lblEmail);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(229, 236, 279, 31);
		frame.getContentPane().add(textField_5);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblPhone.setBounds(71, 280, 146, 27);
		frame.getContentPane().add(lblPhone);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(229, 280, 279, 31);
		frame.getContentPane().add(textField_6);
		
		JLabel lblPosition = new JLabel("Position :");
		lblPosition.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosition.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblPosition.setBounds(60, 325, 146, 27);
		frame.getContentPane().add(lblPosition);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(229, 326, 279, 31);
		frame.getContentPane().add(textField_7);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				try {
					ShowAllEmploye show = new ShowAllEmploye();
					show.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnCreate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCreate.setBounds(293, 409, 114, 45);
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
		lblCancel.setBounds(321, 465, 56, 16);
		frame.getContentPane().add(lblCancel);
	}
}
