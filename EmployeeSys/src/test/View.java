package test;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import employeeClass.Employees;
import model.EmployeeModel;

import javax.swing.JScrollPane;

public class View {

	private JFrame frame;
	private JTable table_employees;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
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
	public View() {
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
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 862, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 820, 427);
		frame.getContentPane().add(scrollPane);
		
		// initial and add column to table
		String[] column = { "eID", "first_name", "last_name", "email", "dob", "phone", "position", "salary" };
		DefaultTableModel model = new DefaultTableModel();
		table_employees = new JTable(model);
		for (int i=0; i<8; i++) {
			model.addColumn(column[i]);
		}
			
		
		show_all_employee();
		
		scrollPane.setViewportView(table_employees);
	}
}
