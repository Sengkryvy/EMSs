package employee_UI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import admin_ui.Home;
import employeeClass.Permission;
import model.PermissionModel;

import java.awt.SystemColor;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Edit_permission {

	JFrame frame;
	private	JTextPane textPane_reason;
	private	JDateChooser dateChooser_leavingDate;
	private	JComboBox comboBox_type;
	private Permission p ;
	private JButton btnUpdate;
	private JButton btnCancel;
	int id;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_permission window = new Edit_permission();
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
	public Edit_permission(Permission permission) {
		System.out.println("id="+permission.getId());
		p=permission;
		System.out.println("permission = " + p.getId());
		System.out.println("reason = "+ p.getReason());
		initialize();
	}

	public Edit_permission() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 558, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Edit Permission Form");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD, 30));
		label.setBounds(77, 26, 352, 31);
		frame.getContentPane().add(label);
		
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
		dateChooser_leavingDate.setDate(Date.valueOf(p.getLeavingDate()));
		frame.getContentPane().add(dateChooser_leavingDate);
		
		
		textPane_reason = new JTextPane();
		textPane_reason.setForeground(new Color(0, 0, 0));
		textPane_reason.setBounds(215, 231, 251, 67);
		textPane_reason.setText(p.getReason());
		frame.getContentPane().add(textPane_reason);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(dateChooser_leavingDate.getDate());
					Permission per_update=new Permission(p.geteID(),comboBox_type.getSelectedItem().toString(), p.getApplyDate(),date,textPane_reason.getText());
					per_update.setId(p.getId());
					
				try {
					System.out.println(per_update.toString());
					//PermissionModel model=new PermissionModel();
					if (PermissionModel.edit(per_update)) {
						System.out.println("heiilo ");
						
//						Home_Emp home= new Home_Emp();
//						home.frame.setVisible(true);
						JOptionPane.showMessageDialog(null, "Permission is successfully Updated.");
						Home_Emp.model_permission.setRowCount(0);
						//Home_Emp.fill_tablePermission(PermissionModel.all());
						System.out.println(per_update.getReason());
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Error Update permission record.");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e);
				}
					
				} 
			});
			
		
		btnUpdate.setBackground(new Color(255, 160, 122));
		btnUpdate.setBounds(215, 311, 97, 25);
		frame.getContentPane().add(btnUpdate);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int input = JOptionPane.showConfirmDialog(null, "Do you want to cancel it ?", "Cancel",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
			   	if(input==0) {
			   		frame.dispose();
//			   		Home_Emp.model_permission.setRowCount(0);
//			   		Home_Emp.fill_tablePermission(p.geteID());
			  }   
				
			}
		});
		btnCancel.setBackground(new Color(255, 160, 122));
		btnCancel.setBounds(215, 351, 97, 25);
		frame.getContentPane().add(btnCancel);

	}
}
