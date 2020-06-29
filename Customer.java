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
import javax.swing.JEditorPane;


public class Customer extends JFrame {

	private JPanel contentPane;
	private JTextField CateName;
	private JTextField CateID;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField Ma_ID;
	private JTextField CoID;
	private JTextField CiID;
	private JTextField AID;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Customer() {
		
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
		
		JLabel lblCategoryI = new JLabel("Customer ID");
		lblCategoryI.setBounds(15, 26, 147, 20);
		contentPane.add(lblCategoryI);
		
		JLabel lblCategoryName = new JLabel("Last Name");
		lblCategoryName.setBounds(15, 72, 124, 20);
		contentPane.add(lblCategoryName);
		
		
		JLabel lblMarketId = new JLabel("age");
		lblMarketId.setBounds(15, 114, 124, 20);
		contentPane.add(lblMarketId);
		
		JLabel lblMess = new JLabel("");
		lblMess.setBounds(68, 434, 449, 132);
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
		
		
		JLabel lblCountryId = new JLabel("Group ID");
		lblCountryId.setBounds(15, 172, 124, 20);
		contentPane.add(lblCountryId);
		
		JLabel lblCityId = new JLabel("First Name");
		lblCityId.setBounds(15, 208, 69, 20);
		contentPane.add(lblCityId);
		
		CoID = new JTextField();
		CoID.setBounds(237, 172, 146, 26);
		contentPane.add(CoID);
		CoID.setColumns(10);
		
		CiID = new JTextField();
		CiID.setBounds(237, 205, 146, 26);
		contentPane.add(CiID);
		CiID.setColumns(10);
		
		
		JLabel lblAllergicId = new JLabel("Allergic ID");
		lblAllergicId.setBounds(15, 250, 69, 20);
		contentPane.add(lblAllergicId);
		
		AID = new JTextField();
		AID.setBounds(237, 247, 146, 26);
		contentPane.add(AID);
		AID.setColumns(10);

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
					String aid = AID.getText();
					
					String sql = "insert into wu_elaine_db.customer(Customer_ID,"
							+ "Last_Name, age, Group_Group_ID, First_Name, Allergic_ID) values("
							+ id +",'"+name+"','"+mid+"','"+coid+"','"+ciid+"','"+aid+"')";
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
		btnInsertCategory.setBounds(0, 302, 182, 29);
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
					String aid = AID.getText();

					String sql = "update `customer` set `Last_Name`=?, `age`=?, `Group_Group_ID`=?,"
							+ "`First_Name`=?,`Allergic_ID`=?, where `Customer_ID`=?";
							
					
					//checking if it exists in database
					String sql_s = "Select * from customer where Customer_ID='"+id+"'";
					DataAccess da = new DataAccess();
					ArrayList <String> temp = da.test(sql_s);
					if (temp.isEmpty()) {
						lblMess.setText("The data does not exist");
					}
					else {
					PreparedStatement preparedStmt = DataAccess.conn().prepareStatement(sql);
				
				     preparedStmt.setString(1, name);
				     preparedStmt.setString   (2, mid);    
				     preparedStmt.setString   (3, coid);
				     preparedStmt.setString   (4, ciid);    
				     preparedStmt.setString   (5, aid);
				     preparedStmt.setString   (5, id);
					 preparedStmt.executeUpdate();
					 lblMess.setText("Successfully updated");
					 preparedStmt.close();
					}
				}catch (Exception e1) {
					lblMess.setText(e1.getMessage());
				}
				
			}
		});
		btnUpdateCategory.setBounds(0, 349, 409, 29);
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
		
		JButton btnShowTable = new JButton("Show table");
		btnShowTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerTable ct = new CustomerTable();
				ct.setVisible(true);
			}
		});
		btnShowTable.setBounds(0, 404, 115, 29);
		contentPane.add(btnShowTable);
	}
}
