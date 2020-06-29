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

public class CategoryTable extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public CategoryTable() {
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
					String sql = "select * from food_category";
					DataAccess da = new DataAccess();
					ResultSet show = da.display(sql);
					DefaultTableModel model = new DefaultTableModel(new String[] {"Category ID","Category Name","Market ID"},0);
					
					while (show.next()) {
						String a = show.getString("Category_ID");
						String b = show.getString("Category_Name");
						String c = show.getString("Market_Market_ID");
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
					String sql = "select * from food_category Order By Category_ID DESC";
					DataAccess da = new DataAccess();
					ResultSet show = da.display(sql);
					DefaultTableModel model = new DefaultTableModel(new String[] {"Category ID","Category Name","Market ID"},0);
					
					while (show.next()) {
						String a = show.getString("Category_ID");
						String b = show.getString("Category_Name");
						String c = show.getString("Market_Market_ID");
						model.addRow(new Object[] {a,b,c});
					}
					table.setModel(model);
					
					}catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnOrderByDesc.setBounds(0, 326, 156, 29);
		contentPane.add(btnOrderByDesc);
		
		JButton btnInfoLeastCalorie = new JButton("Category contains least calorie food");
		btnInfoLeastCalorie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sql = "select Item_Name, calorie, Category_Name\r\n" + 
							"from\r\n" + 
							"(select Item_Name, calorie, Category_ID as cd\r\n" + 
							"from food_item\r\n" + 
							"order by calorie\r\n" + 
							"limit 1 \r\n" + 
							") a, food_category\r\n" + 
							"where food_category.Category_ID=cd";
					DataAccess da = new DataAccess();
					ResultSet show = da.display(sql);
					DefaultTableModel model = new DefaultTableModel(new String[] {"Item_Name","Calorie","Category_Name"},0);
					
					while (show.next()) {
						String a = show.getString("Item_Name");
						String b = show.getString("Calorie");
						String c = show.getString("Category_Name");
						model.addRow(new Object[] {a,b,c});
					}
					table.setModel(model);
					
					}catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnInfoLeastCalorie.setBounds(186, 294, 319, 29);
		contentPane.add(btnInfoLeastCalorie);
		
		JButton btnMarketWithMost = new JButton("Market and its category count");
		btnMarketWithMost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sql = "select Market_name, count(*) as count\r\n" + 
							"from food_category, market\r\n" + 
							"where food_category.market_market_id=market.market_id\r\n" + 
							"group by market_market_id";
					DataAccess da = new DataAccess();
					ResultSet show = da.display(sql);
					DefaultTableModel model = new DefaultTableModel(new String[] {"Market Name","Number of Category"},0);
					
					while (show.next()) {
						String a = show.getString("Market_Name");
						String b = show.getString("Count");
						model.addRow(new Object[] {a,b});
					}
					table.setModel(model);
					
					}catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnMarketWithMost.setBounds(258, 326, 247, 29);
		contentPane.add(btnMarketWithMost);
	}
}
