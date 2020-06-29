package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAL.DataAccess;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JTable;

public class GroupTable extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public GroupTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 16, 406, 232);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnOrderByAsc = new JButton("Order by ASC");
		btnOrderByAsc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sql = "select * from `group`";
					DataAccess da = new DataAccess();
					ResultSet show = da.display(sql);
					DefaultTableModel model = new DefaultTableModel(new String[] {"Group ID","Physical Gender"},0);
					
					while (show.next()) {
						String a = show.getString("Group_ID");
						String b = show.getString("Physical_Gender");
						model.addRow(new Object[] {a,b});
					}
					table.setModel(model);
					
					}catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnOrderByAsc.setBounds(43, 274, 156, 29);
		contentPane.add(btnOrderByAsc);
		
		JButton btnOrderByDesc = new JButton("Order by Desc");
		btnOrderByDesc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sql = "select * from `group` ORDER by Group_ID DESC";
					DataAccess da = new DataAccess();
					ResultSet show = da.display(sql);
					DefaultTableModel model = new DefaultTableModel(new String[] {"Group ID","Physical Gender"},0);
					
					while (show.next()) {
						String a = show.getString("Group_ID");
						String b = show.getString("Physical_Gender");
						model.addRow(new Object[] {a,b});
					}
					table.setModel(model);
					
					}catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnOrderByDesc.setBounds(43, 319, 156, 29);
		contentPane.add(btnOrderByDesc);
		
		JButton btnGroupAndThe = new JButton("Group and the Grocery Visit");
		btnGroupAndThe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sql = "select Group_Group_ID, sum(visit_count)\r\n" + 
							"from customer join Grocery_visit on Customer.customer_id=Grocery_visit.Customer_Customer_ID\r\n" + 
							"group by Group_group_ID";
					DataAccess da = new DataAccess();
					ResultSet show = da.display(sql);
					DefaultTableModel model = new DefaultTableModel(new String[] {"Group ID","Grocery Visit"},0);
					
					while (show.next()) {
						String a = show.getString("Group_Group_ID");
						String b = show.getString("sum(visit_count)");
						model.addRow(new Object[] {a,b});
					}
					table.setModel(model);
					
					}catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnGroupAndThe.setBounds(245, 274, 273, 29);
		contentPane.add(btnGroupAndThe);
		
		JButton btnWinnerGroup = new JButton("Winner Group & Visit Count");
		btnWinnerGroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sql = "select Group_Group_ID, sum(visit_count) as total\r\n" + 
							"from customer join Grocery_visit on Customer.customer_id=Grocery_visit.Customer_Customer_ID\r\n" + 
							"group by Group_group_ID\r\n" + 
							"order by total DESC\r\n" + 
							"limit 1";
					DataAccess da = new DataAccess();
					ResultSet show = da.display(sql);
					DefaultTableModel model = new DefaultTableModel(new String[] {"Group ID","Grocery Visit"},0);
					
					while (show.next()) {
						String a = show.getString("Group_Group_ID");
						String b = show.getString("total");
						model.addRow(new Object[] {a,b});
					}
					table.setModel(model);
					
					}catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnWinnerGroup.setBounds(240, 319, 278, 29);
		contentPane.add(btnWinnerGroup);
		
		JButton btnGroupAndAvg = new JButton("Group and avg grocery visit by group member");
		btnGroupAndAvg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sql = "select Group_Group_ID, avg(visit_count)\r\n" + 
							"from customer join Grocery_visit on Customer.customer_id=Grocery_visit.Customer_Customer_ID\r\n" + 
							"group by Group_group_ID";
					DataAccess da = new DataAccess();
					ResultSet show = da.display(sql);
					DefaultTableModel model = new DefaultTableModel(new String[] {"Group ID","Grocery Visit"},0);
					
					while (show.next()) {
						String a = show.getString("Group_Group_ID");
						String b = show.getString("avg(visit_count)");
						model.addRow(new Object[] {a,b});
					}
					table.setModel(model);
					
					}catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnGroupAndAvg.setBounds(53, 364, 387, 29);
		contentPane.add(btnGroupAndAvg);
	}
}
