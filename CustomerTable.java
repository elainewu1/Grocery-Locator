package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAL.DataAccess;

import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CustomerTable extends JFrame {

	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JLayeredPane layeredPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Create the frame.
	 */
	public void switchPanels (JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public CustomerTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(27, 28, 500, 400);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel1 = new JPanel();
		layeredPane.add(panel1, "name_636912966655700");
		
		JScrollPane scrollPane = new JScrollPane();
		panel1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel2 = new JPanel();
		layeredPane.add(panel2, "name_636933624425000");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel2.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel3 = new JPanel();
		layeredPane.add(panel3, "name_636937909022900");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel3.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		
		JButton btnAllCustomers = new JButton("All Customers");
	
		btnAllCustomers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanels(panel1);
				try {
					String sql = "select * from customer";
					DataAccess da = new DataAccess();
					ResultSet show = da.display(sql);
					DefaultTableModel model = new DefaultTableModel(new String[] {"Customer ID","Last Name",
							"age","Group ID","First Name", "Allergic ID"},0);
					
					
					while (show.next()) {
						String a = show.getString("Customer_ID");
						String b = show.getString("Last_Name");
						String c = show.getString("age");
						String x = show.getString("Group_Group_ID");
						String y = show.getString("First_Name");
						String z = show.getString("Allergic_ID");
						model.addRow(new Object[] {a,b,c,x,y,z});
					}
					table.setModel(model);
					
					}catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnAllCustomers.setBounds(27, 430, 157, 29);
		contentPane.add(btnAllCustomers);
		
		JButton btnCustomerInGroup = new JButton("Customer in Group of female");
		btnCustomerInGroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switchPanels(panel2);
				try {
					String sql = "select * from customer join `group` on (customer.group_group_ID=`group`.group_ID)"
							+ "where `group`.physical_gender LIKE '%emale%'";
					DataAccess da = new DataAccess();
					ResultSet show = da.display(sql);
					DefaultTableModel model = new DefaultTableModel(new String[] {"Customer ID","Last Name",
							"age","Group ID","First Name", "Allergic ID"},0);
					
					
					while (show.next()) {
						String a = show.getString("Customer_ID");
						String b = show.getString("Last_Name");
						String c = show.getString("age");
						String x = show.getString("Group_Group_ID");
						String y = show.getString("First_Name");
						String z = show.getString("Allergic_ID");
						model.addRow(new Object[] {a,b,c,x,y,z});
					}
					table_1.setModel(model);
					
					}catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnCustomerInGroup.setBounds(27, 473, 282, 29);
		contentPane.add(btnCustomerInGroup);
		
		JButton btnCustomerInGroup_1 = new JButton("Customer in Group of male");
		btnCustomerInGroup_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sql = "select * from customer join `group` on (customer.group_group_ID=`group`.group_ID)"
							+ "where `group`.physical_gender LIKE 'male' or `group`.physical_gender LIKE 'Male' ";
					DataAccess da = new DataAccess();
					ResultSet show = da.display(sql);
					DefaultTableModel model = new DefaultTableModel(new String[] {"Customer ID","Last Name",
							"age","Group ID","First Name", "Allergic ID"},0);
					
					
					while (show.next()) {
						String a = show.getString("Customer_ID");
						String b = show.getString("Last_Name");
						String c = show.getString("age");
						String x = show.getString("Group_Group_ID");
						String y = show.getString("First_Name");
						String z = show.getString("Allergic_ID");
						model.addRow(new Object[] {a,b,c,x,y,z});
					}
					table_1.setModel(model);
					
					}catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnCustomerInGroup_1.setBounds(27, 518, 282, 29);
		contentPane.add(btnCustomerInGroup_1);
	}
}
