package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAL.DataAccess;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;


public class Market extends JFrame {

	private JPanel contentPane;
	private JTextField CateName;
	private JTextField CateID;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField Ma_ID;
	private JTextField CoID;
	private JTextField CiID;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Market() {
		
		getContentPane().setLayout(null);



		textField = new JTextField();
		textField.setBounds(146, 54, 240, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 109, 252, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCategoryI = new JLabel("Market ID");
		lblCategoryI.setBounds(15, 26, 147, 20);
		contentPane.add(lblCategoryI);
		
		JLabel lblCategoryName = new JLabel("Market Name");
		lblCategoryName.setBounds(15, 72, 124, 20);
		contentPane.add(lblCategoryName);
		
		
		JLabel lblMarketId = new JLabel("Distance km");
		lblMarketId.setBounds(15, 114, 124, 20);
		contentPane.add(lblMarketId);
		
		JLabel lblMess = new JLabel("");
		lblMess.setBounds(2, 411, 449, 132);
		contentPane.add(lblMess);
		
		CateID = new JTextField();
		CateID.setBounds(237, 23, 252, 26);
		contentPane.add(CateID);
		CateID.setColumns(10);
		
		CateName = new JTextField();
		CateName.setBounds(237, 69, 252, 26);
		contentPane.add(CateName);
		CateName.setColumns(10);
		
		Ma_ID = new JTextField();
		Ma_ID.setBounds(237, 111, 252, 26);
		contentPane.add(Ma_ID);
		Ma_ID.setColumns(10);
		
		
		JLabel lblCountryId = new JLabel("Country ID");
		lblCountryId.setBounds(15, 172, 124, 20);
		contentPane.add(lblCountryId);
		
		JLabel lblCityId = new JLabel("City ID");
		lblCityId.setBounds(15, 241, 69, 20);
		contentPane.add(lblCityId);
		
		CoID = new JTextField();
		CoID.setBounds(237, 172, 146, 26);
		contentPane.add(CoID);
		CoID.setColumns(10);
		
		CiID = new JTextField();
		CiID.setBounds(237, 238, 146, 26);
		contentPane.add(CiID);
		CiID.setColumns(10);
		
		JButton btnInsertCategory = new JButton("Insert");
		btnInsertCategory.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				try {
					String id = CateID.getText();
					String name = CateName.getText();
					String mid = Ma_ID.getText();
					String coid = CoID.getText();
					String ciid = CiID.getText();
					
					String sql = "insert into wu_elaine_db.market(Market_ID,"
							+ "Market_Name, distance_km, City_Country_Country_ID, City_City_ID) values("
							+ id +",'"+name+"','"+mid+"','"+coid+"','"+ciid+"')";
					DataAccess da = new DataAccess();
					
					int result = da.ExecuteUpdate(sql);
					if (result>0) {
						lblMess.setText("Succesfully added.");
					
					}
					else {
						lblMess.setText("Failed to add.");
					}
					
					
				}catch (Exception e1) {
					lblMess.setText(e1.getMessage());
				}
			}
		});
		btnInsertCategory.setBounds(15, 296, 182, 29);
		contentPane.add(btnInsertCategory);
		
		JButton btnUpdateCategory = new JButton("Update");
		btnUpdateCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String id = CateID.getText();
					String name = CateName.getText();
					String mid = Ma_ID.getText();
					String coid = CoID.getText();
					String ciid = CiID.getText();

					String sql = "update `market` set `Market_Name`=?, `distance_km`=? where `Market_ID`=?"
							+ "and `City_Country_Country_ID`=? and `City_City_ID`=?";
					
					//checking if it exists in database
					String sql_s = "Select * from market where Market_ID='"+id+"'";
					DataAccess da = new DataAccess();
					ArrayList <String> temp = da.test(sql_s);
					if (temp.isEmpty()) {
						lblMess.setText("The data does not exist");
					}
					else {
					PreparedStatement preparedStmt = DataAccess.conn().prepareStatement(sql);
				
				     preparedStmt.setString(1, name);
				     preparedStmt.setString   (2, mid);    
				     preparedStmt.setString   (3, id);
				     preparedStmt.setString   (4, coid);    
				     preparedStmt.setString   (5, ciid);
					 preparedStmt.executeUpdate();
					 lblMess.setText("Successfully updated");
					 preparedStmt.close();
					}
				}catch (Exception e1) {
					lblMess.setText(e1.getMessage());
				}
				
			}
		});
		btnUpdateCategory.setBounds(15, 341, 409, 29);
		contentPane.add(btnUpdateCategory);
		
		JButton btnBackToPrevious = new JButton("Back to previous");
		btnBackToPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnBackToPrevious.setBounds(466, 461, 164, 29);
		contentPane.add(btnBackToPrevious);
		
		JButton btnShowTable = new JButton("Show Table");
		btnShowTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MarketTable mt = new MarketTable();
				mt.setVisible(true);
			}
		});
		btnShowTable.setBounds(2, 386, 115, 29);
		contentPane.add(btnShowTable);
	}
}
