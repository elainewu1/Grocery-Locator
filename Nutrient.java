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


public class Nutrient extends JFrame {

	private JPanel contentPane;
	private JTextField CateName;
	private JTextField CateID;
	private JTextField textField;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Nutrient() {
		
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
		
		JLabel lblCategoryI = new JLabel("Nutrient ID");
		lblCategoryI.setBounds(15, 26, 147, 20);
		contentPane.add(lblCategoryI);
		
		JLabel lblCategoryName = new JLabel("Nutrient Name");
		lblCategoryName.setBounds(15, 72, 124, 20);
		contentPane.add(lblCategoryName);
		
		JLabel lblMess = new JLabel("");
		lblMess.setBounds(31, 411, 449, 132);
		contentPane.add(lblMess);
		
		CateID = new JTextField();
		CateID.setBounds(237, 23, 252, 26);
		contentPane.add(CateID);
		CateID.setColumns(10);
		
		CateName = new JTextField();
		CateName.setBounds(237, 69, 252, 26);
		contentPane.add(CateName);
		CateName.setColumns(10);
		
		JButton btnInsertCategory = new JButton("Insert Nutrient");
		btnInsertCategory.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				try {
					String id = CateID.getText();
					String name = CateName.getText();
					
					String sql = "insert into wu_elaine_db.nutrient(Nutrient_ID,"
							+ "Nutrient_Name) values("
							+ id +",'"+name+"')";
					DataAccess da = new DataAccess();
					
					int result = da.ExecuteUpdate(sql);
					if (result>0) {
						lblMess.setText("Nutrient Added.");
					
					}
					else {
						lblMess.setText("Failed to add nutrient.");
					}
					
				}catch (Exception e1) {
					lblMess.setText(e1.getMessage());
				}
			}
		});
		btnInsertCategory.setBounds(15, 150, 182, 29);
		contentPane.add(btnInsertCategory);
		
		JButton btnUpdateCategory = new JButton("Update");
		btnUpdateCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String id = CateID.getText();
					String name = CateName.getText();
					
					String sql = "update `nutrient` set `Nutrient_Name`=? where `Nutrient_ID`=?";
					
					//checking if it exists in database
					String sql_s = "Select * from nutrient where Nutrient_ID="+id;
					DataAccess da = new DataAccess();
					ArrayList <String> temp = da.test(sql_s);
					if (temp.isEmpty()) {
						lblMess.setText("The nutrient ID does not exist");
					}
					else {
					PreparedStatement preparedStmt = DataAccess.conn().prepareStatement(sql);
				
				     preparedStmt.setString(1, name);
				     preparedStmt.setString   (2, id);    
					 preparedStmt.executeUpdate();
					 lblMess.setText("Successfully updated");
					 preparedStmt.close();
					}
				}catch (Exception e1) {
					lblMess.setText(e1.getMessage());
				}
				
			}
		});
		btnUpdateCategory.setBounds(15, 195, 409, 29);
		contentPane.add(btnUpdateCategory);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = CateID.getText();
					String name = CateName.getText();
					
					String sql = "delete from `nutrient` where `Nutrient_ID`=?";
					
					//checking if it exists in database
					String sql_s = "Select * from nutrient where Nutrient_ID="+id;
					DataAccess da = new DataAccess();
					ArrayList <String> temp = da.test(sql_s);
					if (temp.isEmpty()) {
						lblMess.setText("The nutrient ID does not exist");
					}
					else {
					PreparedStatement preparedStmt = DataAccess.conn().prepareStatement(sql);
				
				     preparedStmt.setString   (1, id);    
					 preparedStmt.execute();
					 lblMess.setText("Successfully deleted");
					 preparedStmt.close();
					}
				}catch (Exception e1) {
					lblMess.setText(e1.getMessage());
				}
			}
		});
		btnNewButton.setBounds(15, 248, 409, 29);
		contentPane.add(btnNewButton);
		
		JButton btnBackToPrevious = new JButton("Back to previous");
		btnBackToPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnBackToPrevious.setBounds(373, 366, 164, 29);
		contentPane.add(btnBackToPrevious);
	}
}
