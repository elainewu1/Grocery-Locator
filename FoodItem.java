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


public class FoodItem extends JFrame {

	private JPanel contentPane;
	private JTextField CoID;
	private JTextField calorie;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField NuID;
	private JTextField ItID;
	private JTextField ItNa;
	private JTextField FID;
	private JTextField SID;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FoodItem() {
		
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
		
		JLabel lblCategoryI = new JLabel("calorie");
		lblCategoryI.setBounds(15, 26, 147, 20);
		contentPane.add(lblCategoryI);
		
		JLabel lblCategoryName = new JLabel("consumed ID");
		lblCategoryName.setBounds(15, 72, 124, 20);
		contentPane.add(lblCategoryName);
		
		
		JLabel lblMarketId = new JLabel("Nutrient ID");
		lblMarketId.setBounds(15, 114, 124, 20);
		contentPane.add(lblMarketId);
		
		JLabel lblMess = new JLabel("");
		lblMess.setBounds(36, 438, 449, 132);
		contentPane.add(lblMess);
		
		calorie = new JTextField();
		calorie.setBounds(237, 23, 252, 26);
		contentPane.add(calorie);
		calorie.setColumns(10);
		
		CoID = new JTextField();
		CoID.setBounds(237, 69, 252, 26);
		contentPane.add(CoID);
		CoID.setColumns(10);
		
		NuID = new JTextField();
		NuID.setBounds(237, 111, 252, 26);
		contentPane.add(NuID);
		NuID.setColumns(10);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(15, 150, 124, 20);
		contentPane.add(lblItemName);
		
		JLabel lblFoodCategoryId = new JLabel("Food Category ID");
		lblFoodCategoryId.setBounds(15, 186, 182, 20);
		contentPane.add(lblFoodCategoryId);
		
		JLabel lblStorageRequirementId = new JLabel("Storage Requirement ID");
		lblStorageRequirementId.setBounds(15, 238, 219, 20);
		contentPane.add(lblStorageRequirementId);
		
		JLabel lblItemId = new JLabel("Item ID");
		lblItemId.setBounds(36, 274, 93, 20);
		contentPane.add(lblItemId);
		
		ItID = new JTextField();
		ItID.setBounds(237, 271, 146, 26);
		contentPane.add(ItID);
		ItID.setColumns(10);
		
		ItNa = new JTextField();
		ItNa.setBounds(247, 153, 146, 26);
		contentPane.add(ItNa);
		ItNa.setColumns(10);
		
		FID = new JTextField();
		FID.setBounds(247, 194, 146, 26);
		contentPane.add(FID);
		FID.setColumns(10);
		
		SID = new JTextField();
		SID.setBounds(249, 235, 146, 26);
		contentPane.add(SID);
		SID.setColumns(10);
		
		
		JButton btnInsertCategory = new JButton("Insert");
		btnInsertCategory.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				try {
					String ca = calorie.getText();
					String coID = CoID.getText();
					String nuID = NuID.getText();
					String itNa = ItNa.getText();
					String fid = FID.getText();
					String sid = SID.getText();
					String iid = ItID.getText();
					String cid = fid;
					
					String sql = "insert into wu_elaine_db.Food_Item(calorie,"
							+ "Consumed_ID, Nutrient_ID, Item_Name, Food_Category_Category_ID,"
							+ "Storage_Requirement_Storage_ID, Item_ID, Category_ID) values("
							+ ca +",'"+coID+"','"+nuID+"','"+itNa+"','"+fid+"','"+sid+"','"+iid+"','"+cid+"')";
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
		btnInsertCategory.setBounds(15, 327, 182, 29);
		contentPane.add(btnInsertCategory);
		
		JButton btnUpdateCategory = new JButton("Update");
		btnUpdateCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String ca = calorie.getText();
					String coID = CoID.getText();
					String nuID = NuID.getText();
					String itNa = ItNa.getText();
					String fid = FID.getText();
					String sid = SID.getText();
					String iid = ItID.getText();
					String cid = fid;
										
					String sql = "update `food_item` set `calorie`=? and `Consumed_ID`=? "
							+ "and `Nutrient_ID`=? and `Item_Name`=? and `Food_Category_Category_ID`=?"
							+ "and `Storage_Requirement_Storage_ID`=? where `Item_ID`=? and `Category_ID`=?";
					
					//checking if it exists in database
					String sql_s = "Select * from food_item where Item_ID="+iid+" and Category_ID="+cid;
					DataAccess da = new DataAccess();
					ArrayList <String> temp = da.test(sql_s);
					if (temp.isEmpty()) {
						lblMess.setText("The data does not exist");
					}
					else {
					PreparedStatement preparedStmt = DataAccess.conn().prepareStatement(sql);
				
				     preparedStmt.setString(1, ca);
				     preparedStmt.setString(2, coID);    
				     preparedStmt.setString(3, nuID);
				     preparedStmt.setString(4, itNa);
				     preparedStmt.setString(5, fid);    
				     preparedStmt.setString(6, sid);
				     preparedStmt.setString(7, iid);    
				     preparedStmt.setString(8, cid);
					 preparedStmt.executeUpdate();
					 lblMess.setText("Successfully updated");
					 preparedStmt.close();
					}
				}catch (Exception e1) {
					lblMess.setText(e1.getMessage());
				}
				
			}
		});
		btnUpdateCategory.setBounds(15, 372, 409, 29);
		contentPane.add(btnUpdateCategory);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ca = calorie.getText();
					String coID = CoID.getText();
					String nuID = NuID.getText();
					String itNa = ItNa.getText();
					String fid = FID.getText();
					String sid = SID.getText();
					String iid = ItID.getText();
					String cid = fid;
					String sql ="delete from `food_item` where `Item_ID`=? and `Category_ID`=?";
							
					//checking if it exists in database
					//for string, has to include '
					String sql_s = "Select * from food_item where Item_ID="+iid+" and Category_ID="+cid;
					
					DataAccess da = new DataAccess();
					ArrayList <String> temp = da.test(sql_s);
					if (temp.isEmpty()) {
						lblMess.setText("The data does not exist");
					}
					else {
					PreparedStatement preparedStmt = DataAccess.conn().prepareStatement(sql);
				
				     preparedStmt.setString   (1, iid);
				     preparedStmt.setString   (2, cid);
					 preparedStmt.execute();
					 lblMess.setText("Successfully deleted");
					 preparedStmt.close();
					}
				}catch (Exception e1) {
					lblMess.setText(e1.getMessage());
				}
			}
		});
		btnNewButton.setBounds(25, 417, 409, 29);
		contentPane.add(btnNewButton);
		
		JButton btnBackToPrevious = new JButton("Back to previous");
		btnBackToPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnBackToPrevious.setBounds(475, 487, 164, 29);
		contentPane.add(btnBackToPrevious);
	}
}
