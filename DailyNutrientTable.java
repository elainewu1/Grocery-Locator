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

public class DailyNutrientTable extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public DailyNutrientTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 411);
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
					String sql = "select * from daily_nutrient";
					DataAccess da = new DataAccess();
					ResultSet show = da.display(sql);
					DefaultTableModel model = new DefaultTableModel(new String[] {"Group ID","Nutrient Name","Nutrient Amount"},0);
					
					while (show.next()) {
						String a = show.getString("Group_ID");
						String b = show.getString("Nutrient_Name");
						String c = show.getString("Nutrient_Amount");
						model.addRow(new Object[] {a,b,c});
					}
					table.setModel(model);
					
					}catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnOrderByAsc.setBounds(15, 294, 156, 29);
		contentPane.add(btnOrderByAsc);
		
		JButton btnOrderByDesc = new JButton("Order by Desc");
		btnOrderByDesc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sql = "select * from daily_nutrient Order By Group_ID DESC, Nutrient_Name";
					DataAccess da = new DataAccess();
					ResultSet show = da.display(sql);
					DefaultTableModel model = new DefaultTableModel(new String[] {"Group ID","Nutrient Name","Nutrient Amount"},0);
					
					while (show.next()) {
						String a = show.getString("Group_ID");
						String b = show.getString("Nutrient_Name");
						String c = show.getString("Nutrient_Amount");
						model.addRow(new Object[] {a,b,c});
					}
					table.setModel(model);
					
					}catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnOrderByDesc.setBounds(15, 326, 156, 29);
		contentPane.add(btnOrderByDesc);
		
		JButton btnDisplayCustomerWith = new JButton("Display customer with need of nutrient");
		btnDisplayCustomerWith.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sql = "select Last_Name, First_Name, nutrient_name, nutrient_amount\r\n" + 
							"from customer,daily_nutrient\r\n" + 
							"where daily_nutrient.Group_ID=customer.Group_Group_ID";
					DataAccess da = new DataAccess();
					ResultSet show = da.display(sql);
					DefaultTableModel model = new DefaultTableModel(new String[] {"Last Name","First Name","Nutrient Name","Nutrient Amount"},0);
					
					while (show.next()) {
						String z = show.getString("Last_Name");
						String a = show.getString("First_Name");
						String b = show.getString("Nutrient_Name");
						String c = show.getString("Nutrient_Amount");
						model.addRow(new Object[] {z,a,b,c});
					}
					table.setModel(model);
					
					}catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnDisplayCustomerWith.setBounds(186, 294, 332, 29);
		contentPane.add(btnDisplayCustomerWith);
	}
}
