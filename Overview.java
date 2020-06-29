package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Overview extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Overview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFoodCategory = new JButton("Food Category");
		btnFoodCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//FoodCategory fc = new FoodCategory();
				Food_Category fc = new Food_Category();
				fc.setVisible(true);
			}
		});
		btnFoodCategory.setBounds(15, 29, 151, 29);
		contentPane.add(btnFoodCategory);
		
		JButton btnMarket = new JButton("Market");
		btnMarket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Market gr = new Market();
				gr.setVisible(true);
			}
		});
		btnMarket.setBounds(216, 29, 151, 29);
		contentPane.add(btnMarket);
		
		JButton btnExitDatabase = new JButton("Exit");
		btnExitDatabase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnExitDatabase.setBounds(521, 452, 115, 29);
		contentPane.add(btnExitDatabase);
		
		JButton btnAllergic = new JButton("Allergic");
		btnAllergic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Allergic gr = new Allergic();
				gr.setVisible(true);
			}
		});
		btnAllergic.setBounds(464, 206, 115, 29);
		contentPane.add(btnAllergic);
		
		JButton btnCity = new JButton("Customer");
		btnCity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Customer gr = new Customer();
				gr.setVisible(true);
			}
		});
		btnCity.setBounds(496, 29, 115, 29);
		contentPane.add(btnCity);
		
		JButton btnFoodItem = new JButton("Food Item");
		btnFoodItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FoodItem gr = new FoodItem();
				gr.setVisible(true);
			}
		});
		btnFoodItem.setBounds(25, 86, 115, 29);
		contentPane.add(btnFoodItem);
		
		JButton btnGroup = new JButton("Group");
		btnGroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Group gr = new Group();
				gr.setVisible(true);
			}
		});
		btnGroup.setBounds(475, 86, 115, 29);
		contentPane.add(btnGroup);
		
		JButton btnNutrient = new JButton("Nutrient");
		btnNutrient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Nutrient gr = new Nutrient();
				gr.setVisible(true);
			}
		});
		btnNutrient.setBounds(25, 149, 115, 29);
		contentPane.add(btnNutrient);
		
		JButton btnCity_1 = new JButton("City");
		btnCity_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				City gr = new City();
				gr.setVisible(true);
			}
		});
		btnCity_1.setBounds(226, 86, 115, 29);
		contentPane.add(btnCity_1);
		
		JButton btnCountry = new JButton("Country");
		btnCountry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Country gr = new Country();
				gr.setVisible(true);
			}
		});
		btnCountry.setBounds(226, 149, 115, 29);
		contentPane.add(btnCountry);
		
		JButton btnDailyNutrient = new JButton("Daily Nutrient");
		btnDailyNutrient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Daily_Nutrient dn = new Daily_Nutrient();
				dn.setVisible(true);
			}
		});
		btnDailyNutrient.setBounds(451, 149, 163, 29);
		contentPane.add(btnDailyNutrient);
		
		JButton btnConsumptionRequirement = new JButton("Consumption Requirement");
		btnConsumptionRequirement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CR gr = new CR();
				gr.setVisible(true);
			}
		});
		btnConsumptionRequirement.setBounds(-15, 233, 246, 29);
		contentPane.add(btnConsumptionRequirement);
		
		JButton btnGroceryVisit = new JButton("Grocery Visit");
		btnGroceryVisit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GV gr = new GV();
				gr.setVisible(true);
			}
		});
		btnGroceryVisit.setBounds(246, 220, 176, 29);
		contentPane.add(btnGroceryVisit);
		
		JButton btnStorageRequirement = new JButton("Storage Requirement");
		btnStorageRequirement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SR gr = new SR();
				gr.setVisible(true);
			}
		});
		btnStorageRequirement.setBounds(-5, 291, 218, 29);
		contentPane.add(btnStorageRequirement);
	}

}
