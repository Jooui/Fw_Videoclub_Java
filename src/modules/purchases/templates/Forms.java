package modules.purchases.templates;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import modules.products.classes.*;
import modules.products.classes.Product;
import modules.products.classes.Singleton;
import modules.users.classes.*;

public class Forms {

	static double discount = 0.00;
	static int quantity = 0;
	static int stock = 0;
	static double prodPricePVE = 0.00;
	static double finalPrice = 0.00;
	static Product prodSelected = null;
	static Partner partnerSelected = null;

	public static ArrayList<Object> createPurchase() {
		ArrayList<Object> result = new ArrayList<Object>();
		String[] choice = { "Create", "Cancel" };
		String errorText = "";
		//Restart variables
		finalPrice = 0.00;
		discount = 0.00;
		quantity = 0;
		stock = 0;
		prodPricePVE = 0.00;
		prodSelected = null;
		partnerSelected = null;
		ArrayList<String> productsName = new ArrayList<String>();
		ArrayList<String> partnersName = new ArrayList<String>();
		ArrayList<Product> productsObj = new ArrayList<Product>();
		ArrayList<Partner> partnersObj = new ArrayList<Partner>();
		final JComboBox<String> box1 = new JComboBox<String>(new String[] { "Films", "Games", "Music Discs" });

		// DECLARE SEPARATORS
		final JSeparator separator = new JSeparator();
		final JSeparator separator2 = new JSeparator();
		final JSeparator separator3 = new JSeparator();
		final JSeparator separator4 = new JSeparator();

		final DefaultListModel<Object> listModelProducts = new DefaultListModel<>();
		final DefaultListModel<Object> listModelPartners = new DefaultListModel<>();

		// FILTER FIELD AND BUTTONS + AND - FOR QUANTITY
		JButton buttonQuantityMinus = new JButton("-");
		JButton buttonQuantityPlus = new JButton("+");
		JTextField quantityField = new JTextField(3);
		quantityField.setText("0");
		quantityField.setEditable(false);
		quantityField.setHorizontalAlignment(JTextField.CENTER);
		quantityField.setBorder(null);
		buttonQuantityMinus.setBounds(200, 150, 80, 30);
		buttonQuantityPlus.setBounds(200, 150, 80, 30);

		// FILTER FIELD AND BUTTON FOR PRODUCTS
		JButton buttonFilterProd = new JButton("Filter");
		JTextField filterFieldProd = new JTextField(20);
		buttonFilterProd.setBounds(200, 150, 80, 30);

		// FILTER FIELD AND BUTTON FOR PARTNERS
		JButton buttonFilterPartners = new JButton("Filter");
		JTextField filterFieldPartners = new JTextField(20);
		buttonFilterProd.setBounds(200, 150, 80, 30);

		// MAKE LIST FOR PRODUCTS
		final JList<Object> listProducts = new JList<>(listModelProducts);
		JScrollPane scrollProducts = new JScrollPane(listProducts);
		listProducts.setBounds(100, 100, 75, 75);

		// MAKE LIST FOR PARTNERS
		final JList<Object> listPartners = new JList<>(listModelPartners);
		JScrollPane scrollPartners = new JScrollPane(listPartners);
		listPartners.setBounds(100, 100, 75, 75);

		// ASSIGN LABELS FOR PRICE AND DISCOUNT
		final JLabel labelPriceUnit = new JLabel();
		labelPriceUnit.setSize(500, 100);
		labelPriceUnit
				.setText("Unit Price:                                                        " + prodPricePVE + " €");

		final JLabel labelPricePVE = new JLabel();
		labelPricePVE.setSize(500, 100);
		labelPricePVE
				.setText("Price PVE:                                                        " + prodPricePVE + " €");

		final JLabel labelDiscount = new JLabel();
		labelDiscount.setSize(500, 100);
		labelDiscount.setText("User Discount:                                                 " + discount + "%");

		final JLabel labelTotalPrice = new JLabel();
		labelTotalPrice.setSize(500, 100);
		labelTotalPrice
				.setText("Total Price:                                                     " + finalPrice + " €");

		final JLabel stockQuantity = new JLabel();
		stockQuantity.setSize(500, 100);
		stockQuantity.setText("Stock: " + stock + " Unit/s");

		// CREATE JPANELS FOR ALIGN ITEMS HORITZONTALLY
		JPanel panelProducts = new JPanel();

		panelProducts.add(filterFieldProd);
		panelProducts.add(buttonFilterProd);

		JPanel panelPartners = new JPanel();

		panelPartners.add(filterFieldPartners);
		panelPartners.add(buttonFilterPartners);

		JPanel panelQuantity = new JPanel();
		FlowLayout flowLayoutRight = new FlowLayout(FlowLayout.RIGHT, 10, 5);
		final JLabel labelQuantity = new JLabel();
		labelQuantity.setSize(500, 100);
		labelQuantity.setText("Quantity:                           ");
		panelQuantity.add(labelQuantity);
		panelQuantity.add(buttonQuantityMinus);
		panelQuantity.add(quantityField);
		panelQuantity.add(buttonQuantityPlus);
		panelQuantity.setLayout(flowLayoutRight);

		// PUT EVERY ITEM CREATED INTO OBJECT
		Object[] message = { "Choose type:", box1, scrollProducts, panelProducts, separator, "Choose user:",
				scrollPartners, panelPartners, separator4, stockQuantity, panelQuantity, separator2, labelPriceUnit,
				labelPricePVE, labelDiscount, separator3, labelTotalPrice,

		};

		// OBTAIN THE NAME AND OBJECT OF EVERY PRODUCT
		for (int a = 0; a < Singleton.products.size(); a++) {
			Product product = Singleton.products.get(a);
			if (product instanceof Film) {
				productsName.add(product.getName());
				productsObj.add(product);
			}
		}

		// OBTAIN THE NAME, DNI AND OBJECT OF EVERY PARTNER
		for (int a = 0; a < modules.users.classes.Singleton.users.size(); a++) {
			User partner = modules.users.classes.Singleton.users.get(a);
			if (partner instanceof Partner) {
				partnersName.add(partner.getName() + " - DNI: " + partner.getDni());
				partnersObj.add((Partner) partner);
			}

		}

		// PUT EVERY NAME ON THE RESPECTIVE LIST
		for (int i = 0; i < productsName.size(); i++) {
			listModelProducts.addElement(productsName.get(i));
		}
		for (int i = 0; i < partnersName.size(); i++) {
			listModelPartners.addElement(partnersName.get(i));
		}

		// LISTENER FOR SELECT THE TYPE OF PRODUCTS WE WANT TO SEARCH
		box1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				productsName.clear();
				
				if (box1.getSelectedItem().equals("Films")) {
					for (int i = 0; i < Singleton.products.size(); i++) {
						Product product = Singleton.products.get(i);
						if (product instanceof Film) {
							productsName.add(product.getName());
						}

					}

				}

				if (box1.getSelectedItem().equals("Games")) {

					for (int i = 0; i < Singleton.products.size(); i++) {
						Product product = Singleton.products.get(i);
						if (product instanceof Game)
							productsName.add(product.getName());

					}
				}

				if (box1.getSelectedItem().equals("Music Discs")) {

					for (int i = 0; i < Singleton.products.size(); i++) {
						Product product = Singleton.products.get(i);
						if (product instanceof MusicDisc)
							productsName.add(product.getName());
					}
				}
				listModelProducts.removeAllElements();
				for (int x = 0; x < productsName.size(); x++) {
					listModelProducts.addElement(productsName.get(x));
				}

			}
		});

		buttonFilterProd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int cont = 0;
				String labelText = filterFieldProd.getText();
				if (!labelText.isEmpty()) {
					boolean check = false;
					listModelProducts.removeAllElements();
					for (int x = 0; x < productsName.size(); x++) {

						for (int y = 0; y < labelText.length(); y++) {
							if (labelText.length() <= productsName.get(x).length()) {
								try {
									if (labelText.substring(y, y + 1)
											.equalsIgnoreCase(productsName.get(x).substring(y, y + 1))) {
										check = true;
									} else {
										check = false;
										break;

									}
								} catch (Exception e2) {
									check = false;
								}
							}

						}
						if (check == true) {
							listModelProducts.addElement(productsName.get(x));
							cont++;
						}
					}
				} else {
					listModelProducts.removeAllElements();
					for (int i = 0; i < productsName.size(); i++) {
						listModelProducts.addElement(productsName.get(i));
					}
				}
				if (cont == 0 && (!labelText.isEmpty())) {
					listModelProducts.addElement("No products found");
				}
			}

		});

		buttonFilterPartners.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int cont = 0;
				String labelText = filterFieldPartners.getText();
				if (!labelText.isEmpty()) {
					boolean check = false;
					listModelPartners.removeAllElements();
					for (int x = 0; x < partnersName.size(); x++) {
						for (int y = 0; y < labelText.length(); y++) {
							if (labelText.length() <= partnersName.get(x).length()) {
								try {
									if (labelText.substring(y, y + 1)
											.equalsIgnoreCase(partnersName.get(x).substring(y, y + 1))) {
										check = true;
									} else {
										check = false;
										break;

									}
								} catch (Exception e2) {
									check = false;
								}
							}

						}
						if (check == true) {
							listModelPartners.addElement(partnersName.get(x));
							cont++;
						}
					}
				} else {
					listModelPartners.removeAllElements();
					for (int i = 0; i < partnersName.size(); i++) {
						listModelPartners.addElement(partnersName.get(i));
					}
				}
				if (cont == 0 && (!labelText.isEmpty())) {
					listModelPartners.addElement("No products found");
				}
			}

		});

		listProducts.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				if (me.getClickCount() == 1) {
					String nameProd = "";
					nameProd = "" + listProducts.getSelectedValue();
					for (Product product : productsObj) {

						if (product.getName().equals(nameProd)) {
							prodSelected = product;
						}
					}
					stock = prodSelected.getStock();
					stockQuantity.setText("Stock: " + stock + " Unit/s");
					prodPricePVE = prodSelected.getPrice();
					labelPriceUnit.setText("Unit Price:                                                       "
							+ (prodPricePVE) + " €");
					labelPricePVE.setText("Price PVE:                                                        "
							+ (prodPricePVE * quantity) + " €");
					if (discount != 0.00) {
						finalPrice = (prodPricePVE - (prodPricePVE * discount)) * quantity;
						labelTotalPrice.setText("Total Price:                                                     "
								+ finalPrice + " €");

					}

					me.consume();
				}
			}
		});

		listPartners.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				if (me.getClickCount() == 1) {
					String namePartnerRaw = "";
					namePartnerRaw = "" + listPartners.getSelectedValue();

					String[] splitName = namePartnerRaw.split("-");
					String namePartner = functions.functions.removeLastChar(splitName[0]);

					for (Partner partner : partnersObj) {
						if (partner.getName().equals(namePartner)) {
							partnerSelected = partner;
						}
					}
					String discountRaw = ("0." + partnerSelected.getDiscount());

					discount = Double.parseDouble(discountRaw);
					finalPrice = (prodPricePVE - (prodPricePVE * discount)) * quantity;
					labelDiscount.setText(
							"User Discount:                                                 " + discount + "%");
					labelTotalPrice.setText(
							"Total Price:                                                     " + finalPrice + " €");

					me.consume();
				}
			}
		});

		// QUANTITY LISTENERS

		buttonQuantityMinus.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String currentQuantity = (quantityField.getText());
				int currentQuantityInt = (Integer.parseInt(currentQuantity));
				if (currentQuantityInt != 0) {
					quantity = currentQuantityInt - 1;
					quantityField.setText((quantity + ""));
					if (discount != 0.00 && prodPricePVE != 0.00) {
						finalPrice = (prodPricePVE - (prodPricePVE * discount)) * quantity;
						labelTotalPrice.setText("Total Price:                                                     "
								+ finalPrice + " €");
						labelPricePVE.setText("Price PVE:                                                        "
								+ (prodPricePVE * quantity) + " €");
					}
				}
			}
		});

		buttonQuantityPlus.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String currentQuantity = (quantityField.getText());
				int currentQuantityInt = (Integer.parseInt(currentQuantity));
				if (quantity < stock) {
					quantity = currentQuantityInt + 1;
					quantityField.setText((quantity + ""));
					if (discount != 0.00 && prodPricePVE != 0.00) {
						finalPrice = (prodPricePVE - (prodPricePVE * discount)) * quantity;
						labelTotalPrice.setText("Total Price:                                                     "
								+ finalPrice + " €");
						labelPricePVE.setText("Price PVE:                                                        "
								+ (prodPricePVE * quantity) + " €");
					}
				}

			}
		});

		do {
			errorText = "";
			int option = JOptionPane.showOptionDialog(null, message, "Purchase", 0, JOptionPane.QUESTION_MESSAGE, null,
					choice, choice[0]);
			if ((option == JOptionPane.CLOSED_OPTION) || (option == 1)) { // When you click on cancel or close the
																			// window, the function closes and returns
																			// to the previous one.
				return null;
			}
			if (prodSelected == null)errorText = (errorText +"You haven't selected any product\n");
			if (partnerSelected == null)errorText = (errorText +"You haven't selected any partner\n");
			if (quantity == 0)errorText = (errorText +"You haven't set the quantity\n");
				
			if (errorText != "") {
				JOptionPane.showMessageDialog(null, errorText,"Error", JOptionPane.ERROR_MESSAGE);
			}else {
				List<Object> list = Arrays.asList(prodSelected, partnerSelected, quantity);
				result.addAll(list);
			}
			
		} while (prodSelected == null || partnerSelected == null || quantity == 0);

		return result;
	}

}
