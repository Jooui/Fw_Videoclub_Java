package modules.purchases.templates;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.sun.jdi.event.Event;

import modules.products.classes.*;
import modules.products.classes.Product;
import modules.purchases.classes.Purchase;
import modules.users.classes.Partner;
import classes.Date;
import functions.functions;

public class search {
	@SuppressWarnings("serial")
	public static ArrayList<Object> searchPurchase() {
		ArrayList<Object> result = new ArrayList<Object>();
		JComboBox<String> boxFilter = new JComboBox<String>(new String[] { "Films", "Games", "Music Discs", "All" });
		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();
		List<String> purchList = new ArrayList<String>();

		// DOWN ARROW u25BC
		// UP ARROW u25B2
		columns.add("ID");
		columns.add("PRODUCT");
		columns.add("PARTNER");
		columns.add("DNI");
		columns.add("DATE");

		DefaultListModel<Object> listModelPurchases = new DefaultListModel<>();

		final JList<Object> listPurchases = new JList<>(listModelPurchases);
		JScrollPane scrollProducts = new JScrollPane(listPurchases);
		listPurchases.setBounds(100, 100, 75, 75);

		JComboBox<String> box1 = new JComboBox<String>(new String[] { "By Partner", "By Product", "By Date" });
		JButton buttonFilterProd = new JButton("Search");
		JTextField filterFieldProd = new JTextField(20);
		buttonFilterProd.setBounds(200, 150, 80, 30);

		JPanel panelFilters = new JPanel();

		panelFilters.add(box1);
		panelFilters.add(filterFieldProd);
		panelFilters.add(buttonFilterProd);
		int contTable = 0000;
		String[] classes = { "Film", "Game", "MusicDisc", "All" };
		for (int i = 0; i < modules.purchases.classes.Singleton.purchases.size(); i++) {

			Purchase objPurchase = modules.purchases.classes.Singleton.purchases.get(i);
			Product product = objPurchase.getProduct();
			if (boxFilter.getSelectedIndex() == 3) {
				contTable++;
				String strPurchase = (String.format("%04d", contTable) + " - PRODUCT: " + objPurchase.getIdProduct() + " ---- PARTNER: "
						+ objPurchase.getPartner().getName() + " DNI: " + objPurchase.getPartner().getDni()
						+ " --- DATE: " + objPurchase.getPurchaseDate().getDate());
						
				String[] strP = { "" + String.format("%04d", contTable), objPurchase.getIdProduct(), objPurchase.getPartner().getName(),
						objPurchase.getPartner().getDni(), objPurchase.getPurchaseDate().getDate(), };
				listModelPurchases.addElement(strPurchase);
				values.add(strP);
				purchList.add(strPurchase);
			} else if (functions.validateInstaceof(product, classes[boxFilter.getSelectedIndex()])) {
				contTable++;
				String strPurchase = (String.format("%04d", contTable) + " - PRODUCT: " + objPurchase.getIdProduct() + " ---- PARTNER: "
						+ objPurchase.getPartner().getName() + " DNI: " + objPurchase.getPartner().getDni()
						+ " --- DATE: " + objPurchase.getPurchaseDate().getDate());
				String[] strP = { "" + String.format("%04d", contTable), objPurchase.getIdProduct(), objPurchase.getPartner().getName(),
						objPurchase.getPartner().getDni(), objPurchase.getPurchaseDate().getDate(), };
				listModelPurchases.addElement(strPurchase);
				values.add(strP);
				purchList.add(strPurchase);
			}
		}

		// values.sort(Comparator.comparing(strP[2]));
		DefaultTableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
		
		JTable table = new JTable(tableModel) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};

		table.setRowSorter(sorter);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setRowSelectionAllowed(true);

		JScrollPane scrollProductsTable = new JScrollPane(table);

		// LISTENERS

		// JComboBox

		boxFilter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tableModel.setRowCount(0);
				String[] classes = { "Film", "Game", "MusicDisc", "All" };
				System.out.println(classes[boxFilter.getSelectedIndex()]);
				int contTable = 0;
				for (int i = 0; i < modules.purchases.classes.Singleton.purchases.size(); i++) {

					Purchase objPurchase = modules.purchases.classes.Singleton.purchases.get(i);
					Product product = objPurchase.getProduct();
					System.out.println(functions.validateInstaceof(product, classes[boxFilter.getSelectedIndex()]));
					if (boxFilter.getSelectedIndex() == 3) {
						contTable++;
						String strPurchase = (String.format("%04d", contTable) + " - PRODUCT: " + objPurchase.getIdProduct() + " ---- PARTNER: "
								+ objPurchase.getPartner().getName() + " DNI: " + objPurchase.getPartner().getDni()
								+ " --- DATE: " + objPurchase.getPurchaseDate().getDate());
						String[] strP = { "" + String.format("%04d", contTable), objPurchase.getIdProduct(), objPurchase.getPartner().getName(),
								objPurchase.getPartner().getDni(), objPurchase.getPurchaseDate().getDate(), };
						listModelPurchases.addElement(strPurchase);
						values.add(strP);
						purchList.add(strPurchase);
						tableModel.addRow(new String[] { "" + String.format("%04d", contTable), objPurchase.getIdProduct(),
								objPurchase.getPartner().getName(), objPurchase.getPartner().getDni(),
								objPurchase.getPurchaseDate().getDate(), });

					} else if (functions.validateInstaceof(product, classes[boxFilter.getSelectedIndex()])) {
						contTable++;
						String strPurchase = (String.format("%04d", contTable) + " - PRODUCT: " + objPurchase.getIdProduct() + " ---- PARTNER: "
								+ objPurchase.getPartner().getName() + " DNI: " + objPurchase.getPartner().getDni()
								+ " --- DATE: " + objPurchase.getPurchaseDate().getDate());
						String[] strP = { "" + String.format("%04d", contTable), objPurchase.getIdProduct(), objPurchase.getPartner().getName(),
								objPurchase.getPartner().getDni(), objPurchase.getPurchaseDate().getDate(), };
						listModelPurchases.addElement(strPurchase);
						values.add(strP);
						purchList.add(strPurchase);
						tableModel.addRow(new String[] { "" + String.format("%04d", contTable), objPurchase.getIdProduct(),
								objPurchase.getPartner().getName(), objPurchase.getPartner().getDni(),
								objPurchase.getPurchaseDate().getDate(), });
					}
				}
			}
		});

		// Table
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {

					System.out.println(table.getSelectedRow());
					System.out.println(table.getValueAt(table.getSelectedRow(), 0)); // get id from column 1
					Purchase objPurchase = null;
					String strIdRow = ((String) table.getValueAt(table.getSelectedRow(), 0)).replaceFirst("^0+(?!$)", "");
					int idRow = Integer.parseInt(strIdRow);
					int pos = idRow - 1;

					objPurchase = modules.purchases.classes.Singleton.purchases.get(pos);
					String dataProd = "";

					Partner partnerPurchase = objPurchase.getPartner();
					Product productPurchase = objPurchase.getProduct();
					JLabel dataProduc = new JLabel();

					if (functions.validateInstaceof(productPurchase, "Film")) {
						dataProd = "<html>Name: " + ((Film) productPurchase).getName() + "<br/>Type: "
								+ ((Film) productPurchase).getClass().getSimpleName() + "<br/>Price: "
								+ ((Film) productPurchase).getPrice() + "<br/>Date: "
								+ ((Film) productPurchase).getDate().getDayMonthYear() + "<br/>Duration: "
								+ ((Film) productPurchase).getDuration() + "</html>";

					} else if (functions.validateInstaceof(productPurchase, "Game")) {

						dataProd = "<html>Name: " + ((Game) productPurchase).getName() + "<br/>Type: "
								+ ((Game) productPurchase).getClass().getSimpleName() + "<br/>Price: "
								+ ((Game) productPurchase).getPrice() + "<br/>Date: "
								+ ((Game) productPurchase).getDate().getDayMonthYear() + "<br/>Platform: "
								+ ((Game) productPurchase).getPlatform() + "</html>";

					} else if (functions.validateInstaceof(productPurchase, "MusicDisc")) {

						dataProd = "<html>Name: " + ((MusicDisc) productPurchase).getName() + "<br/>Artist: "
								+ ((MusicDisc) productPurchase).getArtist() + "<br/>Type: "
								+ ((MusicDisc) productPurchase).getClass().getSimpleName() + "<br/>Price: "
								+ ((MusicDisc) productPurchase).getPrice() + "<br/>Date: "
								+ ((MusicDisc) productPurchase).getDate().getDayMonthYear() + "<br/>Duration: "
								+ ((MusicDisc) productPurchase).getDuration() + "</html>";
					}
					dataProduc.setText(dataProd);

					String partnerNameSur = (partnerPurchase.getName() + " " + partnerPurchase.getSurnames());
					String partnerAddress = (partnerPurchase.getPostalCode() + ", " + partnerPurchase.getCity() + ", "
							+ partnerPurchase.getAddress());
					String dataPart = "<html>Name :" + partnerNameSur + "<br/>DNI: " + partnerPurchase.getDni()
							+ "<br/>Tlf: " + partnerPurchase.getTlf() + "<br/>Email: " + partnerPurchase.getEmail()
							+ "<br/>Birth Date: " + partnerPurchase.getFnac().getDayMonthYear() + "<br/>Address: "
							+ partnerAddress + "</html>";

					JLabel dataPartner = new JLabel();
					dataPartner.setText(dataPart);
					JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
					JSeparator separator2 = new JSeparator();
					Dimension d = separator.getPreferredSize();
					d.height = 0;
					separator.setPreferredSize(d);
					JSeparator x = new JSeparator(SwingConstants.VERTICAL);
					x.setPreferredSize(new Dimension(10, 100));

					// CREATE JPANEL FOR ALIGN ITEMS HORITZONTALLY
					JPanel panelInfo = new JPanel();
					panelInfo.add(dataProduc);
					panelInfo.add(separator);
					panelInfo.add(x);
					panelInfo.add(dataPartner);

					Object[] message = { "Purchase INFO", separator2, panelInfo,
							"\n\nPurchase Date: " + objPurchase.getPurchaseDate().getDate(),
							"Quantity: " + objPurchase.getQuantity(), "Discount Applied: " + objPurchase.getDiscount(),
							"Price: " + objPurchase.getPrice() };

					JOptionPane.showMessageDialog(null, message);
					e.consume();

				}

			}
		});

		/*
		 * table.getSelectionModel().addListSelectionListener(new
		 * ListSelectionListener(){ public void valueChanged(ListSelectionEvent event) {
		 * // do some actions here, for example // print first column value from
		 * selected row System.out.println(table.getValueAt(table.getSelectedRow(),
		 * 0).toString());
		 * 
		 * 
		 * System.out.println(table.getSelectedRow()); } });
		 */

		listPurchases.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				if (me.getClickCount() == 2) {

					Purchase objPurchase = modules.purchases.classes.Singleton.purchases
							.get(listPurchases.getSelectedIndex());
					Partner partnerPurchase = objPurchase.getPartner();
					Product productPurchase = objPurchase.getProduct();
					Date datePurchase = objPurchase.getPurchaseDate();
					String dataProd = "";
					JLabel dataProduc = new JLabel();
					if (functions.validateInstaceof(productPurchase, "Film")) {
						System.out.println("ES PELICULA");
						dataProd = "<html>Name: " + ((Film) productPurchase).getName() + "<br/>Type: "
								+ ((Film) productPurchase).getClass().getSimpleName() + "<br/>Price: "
								+ ((Film) productPurchase).getPrice() + "<br/>Date: "
								+ ((Film) productPurchase).getDate().getDayMonthYear() + "<br/>Duration: "
								+ ((Film) productPurchase).getDuration() + "</html>";

					} else if (functions.validateInstaceof(productPurchase, "Game")) {

						dataProd = "<html>Name: " + ((Game) productPurchase).getName() + "<br/>Type: "
								+ ((Game) productPurchase).getClass().getSimpleName() + "<br/>Price: "
								+ ((Game) productPurchase).getPrice() + "<br/>Date: "
								+ ((Game) productPurchase).getDate().getDayMonthYear() + "<br/>Platform: "
								+ ((Game) productPurchase).getPlatform() + "</html>";

					} else if (functions.validateInstaceof(productPurchase, "MusicDisc")) {

						dataProd = "<html>Name: " + ((MusicDisc) productPurchase).getName() + "<br/>Artist: "
								+ ((MusicDisc) productPurchase).getArtist() + "<br/>Type: "
								+ ((MusicDisc) productPurchase).getClass().getSimpleName() + "<br/>Price: "
								+ ((MusicDisc) productPurchase).getPrice() + "<br/>Date: "
								+ ((MusicDisc) productPurchase).getDate().getDayMonthYear() + "<br/>Duration: "
								+ ((MusicDisc) productPurchase).getDuration() + "</html>";
					}

					dataProduc.setText(dataProd);

					String partnerNameSur = (partnerPurchase.getName() + " " + partnerPurchase.getSurnames());
					String partnerAddress = (partnerPurchase.getPostalCode() + ", " + partnerPurchase.getCity() + ", "
							+ partnerPurchase.getAddress());
					String dataPart = "<html>Name :" + partnerNameSur + "<br/>DNI: " + partnerPurchase.getDni()
							+ "<br/>Tlf: " + partnerPurchase.getTlf() + "<br/>Email: " + partnerPurchase.getEmail()
							+ "<br/>Birth Date: " + partnerPurchase.getFnac().getDayMonthYear() + "<br/>Address: "
							+ partnerAddress + "</html>";

					JLabel dataPartner = new JLabel();
					dataPartner.setText(dataPart);
					JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
					JSeparator separator2 = new JSeparator();
					Dimension d = separator.getPreferredSize();
					d.height = 0;
					separator.setPreferredSize(d);
					JSeparator x = new JSeparator(SwingConstants.VERTICAL);
					x.setPreferredSize(new Dimension(10, 100));

					// CREATE JPANEL FOR ALIGN ITEMS HORITZONTALLY
					JPanel panelInfo = new JPanel();
					panelInfo.add(dataProduc);
					panelInfo.add(separator);
					panelInfo.add(x);
					panelInfo.add(dataPartner);

					Object[] message = { "Purchase INFO", separator2, panelInfo,
							"\n\nPurchase Date: " + objPurchase.getPurchaseDate().getDate(),
							"Quantity: " + objPurchase.getQuantity(), "Discount Applied: " + objPurchase.getDiscount(),
							"Price: " + objPurchase.getPrice() };

					JOptionPane.showMessageDialog(null, message);
					me.consume();
				}
			}
		});

		// FOR TABLE MODEL
		filterFieldProd.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				tableModel.setRowCount(0);

				String searchType = "";
				int contNum = 0;
				int cont = 0;
				String labelText = filterFieldProd.getText();
				if (!labelText.isEmpty()) {
					boolean check = false;
					tableModel.setRowCount(0);
					for (int x = 0; x < modules.purchases.classes.Singleton.purchases.size(); x++) {
						for (int y = 0; y < labelText.length(); y++) {
							if (labelText.length() <= modules.purchases.classes.Singleton.purchases.get(x)
									.getPurchaseDate().getDate().length()) {
								try {
									if (labelText.substring(y, y + 1)
											.equalsIgnoreCase(modules.purchases.classes.Singleton.purchases.get(x)
													.getPurchaseDate().getDate().substring(y, y + 1))) {
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
							contNum++;
							Purchase objPurchase = modules.purchases.classes.Singleton.purchases.get(x);
							tableModel.addRow(new String[] { "" + (x + 1), objPurchase.getIdProduct(),
									objPurchase.getPartner().getName(), objPurchase.getPartner().getDni(),
									objPurchase.getPurchaseDate().getDate(), });

							cont++;
						}
					}
				} else {
					tableModel.setRowCount(0);
					for (int i = 0; i < modules.purchases.classes.Singleton.purchases.size(); i++) {
						Purchase objPurchase = modules.purchases.classes.Singleton.purchases.get(i);

						tableModel.addRow(new String[] { "" + (i + 1), objPurchase.getIdProduct(),
								objPurchase.getPartner().getName(), objPurchase.getPartner().getDni(),
								objPurchase.getPurchaseDate().getDate(), });

					}
				}
				if (cont == 0 && (!labelText.isEmpty())) {
					tableModel.setRowCount(0);
				}

			}
		});

		buttonFilterProd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tableModel.setRowCount(0);

				int contNum = 0;
				int cont = 0;
				String labelText = filterFieldProd.getText();
				if (!labelText.isEmpty()) {
					boolean check = false;
					tableModel.setRowCount(0);
					for (int x = 0; x < modules.purchases.classes.Singleton.purchases.size(); x++) {
						for (int y = 0; y < labelText.length(); y++) {
							if (labelText.length() <= modules.purchases.classes.Singleton.purchases.get(x)
									.getPurchaseDate().getDate().length()) {
								try {
									if (labelText.substring(y, y + 1)
											.equalsIgnoreCase(modules.purchases.classes.Singleton.purchases.get(x)
													.getPurchaseDate().getDate().substring(y, y + 1))) {
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
							contNum++;
							Purchase objPurchase = modules.purchases.classes.Singleton.purchases.get(x);
							tableModel.addRow(new String[] { "" + (x + 1), objPurchase.getIdProduct(),
									objPurchase.getPartner().getName(), objPurchase.getPartner().getDni(),
									objPurchase.getPurchaseDate().getDate(), });

							cont++;
						}
					}
				} else {
					tableModel.setRowCount(0);
					for (int i = 0; i < modules.purchases.classes.Singleton.purchases.size(); i++) {
						Purchase objPurchase = modules.purchases.classes.Singleton.purchases.get(i);

						tableModel.addRow(new String[] { "" + (i + 1), objPurchase.getIdProduct(),
								objPurchase.getPartner().getName(), objPurchase.getPartner().getDni(),
								objPurchase.getPurchaseDate().getDate(), });

					}
				}
				if (cont == 0 && (!labelText.isEmpty())) {
					tableModel.setRowCount(0);
				}
			}
		});

		// FOR LISTMODEL
		filterFieldProd.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int contNum = 0;
				int cont = 0;
				String labelText = filterFieldProd.getText();
				if (!labelText.isEmpty()) {
					boolean check = false;
					listModelPurchases.removeAllElements();
					for (int x = 0; x < modules.purchases.classes.Singleton.purchases.size(); x++) {
						for (int y = 0; y < labelText.length(); y++) {
							if (labelText.length() <= modules.purchases.classes.Singleton.purchases.get(x)
									.getPurchaseDate().getDate().length()) {
								try {
									if (labelText.substring(y, y + 1)
											.equalsIgnoreCase(modules.purchases.classes.Singleton.purchases.get(x)
													.getPurchaseDate().getDate().substring(y, y + 1))) {
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
							contNum++;
							String strPurchase = ((contNum) + " - PRODUCT: "
									+ modules.purchases.classes.Singleton.purchases.get(x).getIdProduct()
									+ " ---- PARTNER: "
									+ modules.purchases.classes.Singleton.purchases.get(x).getPartner().getName()
									+ " DNI: "
									+ modules.purchases.classes.Singleton.purchases.get(x).getPartner().getDni()
									+ " --- DATE: "
									+ modules.purchases.classes.Singleton.purchases.get(x).getPurchaseDate().getDate());
							listModelPurchases.addElement(strPurchase);
							cont++;
						}
					}
				} else {
					listModelPurchases.removeAllElements();
					for (int i = 0; i < modules.purchases.classes.Singleton.purchases.size(); i++) {
						String strPurchase = ((i + 1) + " - PRODUCT: "
								+ modules.purchases.classes.Singleton.purchases.get(i).getIdProduct()
								+ " ---- PARTNER: "
								+ modules.purchases.classes.Singleton.purchases.get(i).getPartner().getName() + " DNI: "
								+ modules.purchases.classes.Singleton.purchases.get(i).getPartner().getDni()
								+ " --- DATE: "
								+ modules.purchases.classes.Singleton.purchases.get(i).getPurchaseDate().getDate());
						listModelPurchases.addElement(strPurchase);
					}
				}
				if (cont == 0 && (!labelText.isEmpty())) {
					listModelPurchases.addElement("No products found");
				}

			}
		});

		table.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int col = table.columnAtPoint(e.getPoint());
					String name = table.getColumnName(col);
					System.out.println("Column index selected " + col + " " + name);
				}
			}
		});

		buttonFilterProd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int contNum = 0;
				int cont = 0;
				String labelText = filterFieldProd.getText();
				if (!labelText.isEmpty()) {
					boolean check = false;
					listModelPurchases.removeAllElements();
					for (int x = 0; x < modules.purchases.classes.Singleton.purchases.size(); x++) {
						for (int y = 0; y < labelText.length(); y++) {
							if (labelText.length() <= modules.purchases.classes.Singleton.purchases.get(x)
									.getPurchaseDate().getDate().length()) {
								try {
									if (labelText.substring(y, y + 1)
											.equalsIgnoreCase(modules.purchases.classes.Singleton.purchases.get(x)
													.getPurchaseDate().getDate().substring(y, y + 1))) {
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
							contNum++;
							String strPurchase = ((contNum) + " - PRODUCT: "
									+ modules.purchases.classes.Singleton.purchases.get(x).getIdProduct()
									+ " ---- PARTNER: "
									+ modules.purchases.classes.Singleton.purchases.get(x).getPartner().getName()
									+ " DNI: "
									+ modules.purchases.classes.Singleton.purchases.get(x).getPartner().getDni()
									+ " --- DATE: "
									+ modules.purchases.classes.Singleton.purchases.get(x).getPurchaseDate().getDate());
							listModelPurchases.addElement(strPurchase);
							cont++;
						}
					}
				} else {
					listModelPurchases.removeAllElements();
					for (int i = 0; i < modules.purchases.classes.Singleton.purchases.size(); i++) {
						String strPurchase = ((i + 1) + " - PRODUCT: "
								+ modules.purchases.classes.Singleton.purchases.get(i).getIdProduct()
								+ " ---- PARTNER: "
								+ modules.purchases.classes.Singleton.purchases.get(i).getPartner().getName() + " DNI: "
								+ modules.purchases.classes.Singleton.purchases.get(i).getPartner().getDni()
								+ " --- DATE: "
								+ modules.purchases.classes.Singleton.purchases.get(i).getPurchaseDate().getDate());
						listModelPurchases.addElement(strPurchase);
					}
				}
				if (cont == 0 && (!labelText.isEmpty())) {
					listModelPurchases.addElement("No products found");
				}
			}
		});

		Object[] messageObj = { boxFilter, scrollProductsTable, "Choose filter", panelFilters,

		};
		JOptionPane.showMessageDialog(null, messageObj);
		int[] rows = table.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			System.out.println(rows[i]);
		}

		return result;
	}
}
