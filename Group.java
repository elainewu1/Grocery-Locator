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
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JComboBox;


public class Group extends JFrame {

	private JPanel contentPane;
	private JTextField CateID;
	private JTextField textField;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Group() {
		
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
		
		JLabel lblCategoryI = new JLabel("Group ID");
		lblCategoryI.setBounds(15, 26, 147, 20);
		contentPane.add(lblCategoryI);
		
		JLabel lblMess = new JLabel("");
		lblMess.setBounds(31, 411, 449, 132);
		contentPane.add(lblMess);
		
		CateID = new JTextField();
		CateID.setBounds(237, 23, 252, 26);
		contentPane.add(CateID);
		CateID.setColumns(10);
		
		JList list = new JList();
		list.setBounds(358, 115, 1, 1);
		contentPane.add(list);
		
		JComboBox combo = new JComboBox();
		combo.setBounds(236, 90, 188, 26);
		contentPane.add(combo);
		
		JLabel lblSelectPhysicalGender = new JLabel("Select Physical Gender");
		lblSelectPhysicalGender.setBounds(15, 93, 182, 20);
		contentPane.add(lblSelectPhysicalGender);
		
		combo.addItem("Female");
		combo.addItem("Male");
		combo.setSelectedItem(null);
		
		JButton btnInsertCategory = new JButton("Insert Group");
		btnInsertCategory.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				try {
					String id = CateID.getText();
					String gen = (String)combo.getSelectedItem();
					if (gen==null) {
						lblMess.setText("Please select a gender group.");
					}
					else {
						String sql = "insert into wu_elaine_db.`group`(Group_ID,"
								+ "Physical_Gender) values("
								+ id +",'"+gen+"')";
						DataAccess da = new DataAccess();
						
						int result = da.ExecuteUpdate(sql);
						if (result>0) {
							lblMess.setText("Category Added.");
						
						}
						else {
							lblMess.setText("Failed to add category.");
						}
					}
				}catch (Exception e1) {
					lblMess.setText(e1.getMessage());
				}
			}
		});
		btnInsertCategory.setBounds(15, 150, 182, 29);
		contentPane.add(btnInsertCategory);
		
		JButton btnUpdateCategory = new JButton("Update Group");
		btnUpdateCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String id = CateID.getText();
					String gen = (String)combo.getSelectedItem();
					if (gen==null) {
						lblMess.setText("Please select a gender group.");
					}
					else {
					String sql = "update `group` set `Physical_Gender`=? where `Group_ID`=?";
					
					//checking if it exists in database
					String sql_s = "Select * from `group` where Group_ID="+id;
					DataAccess da = new DataAccess();
					ArrayList <String> temp = da.test(sql_s);
					if (temp.isEmpty()) {
						lblMess.setText("The group ID does not exist");
					}
					else {
					PreparedStatement preparedStmt = DataAccess.conn().prepareStatement(sql);
				
				     preparedStmt.setString(1, gen);
				     preparedStmt.setString   (2, id);    
					 preparedStmt.executeUpdate();
					 lblMess.setText("Successfully updated");
					 preparedStmt.close();
					}
					}
				}catch (Exception e1) {
					lblMess.setText(e1.getMessage());
				}
				
			}
		});
		btnUpdateCategory.setBounds(15, 195, 182, 29);
		contentPane.add(btnUpdateCategory);
		
		JButton btnNewButton = new JButton("Delete Group");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = CateID.getText();
					
					String sql ="delete from `group` where `Group_ID`=?";

					
					//checking if it exists in database
					//for string, has to include '
					String sql_s = "Select * from `group` where Group_ID="+id;
					
					DataAccess da = new DataAccess();
					ArrayList <String> temp = da.test(sql_s);
					if (temp.isEmpty()) {
						lblMess.setText("The group ID does not exist");
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
		
		JButton btnShowCategoryTable = new JButton("Show Group Table");
		btnShowCategoryTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GroupTable ct = new GroupTable();
				ct.setVisible(true);
			}
		});
		btnShowCategoryTable.setBounds(15, 293, 312, 29);
		contentPane.add(btnShowCategoryTable);
	}
}
