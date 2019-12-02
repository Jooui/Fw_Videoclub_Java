package modules.purchases.functions;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import functions.functions;
import modules.products.classes.Product;
import modules.purchases.classes.Purchase;
import modules.purchases.classes.Singleton;
import modules.purchases.templates.*;
import modules.users.classes.Partner;
import modules.users.classes.User;

public class Purchase_CRUD {

	public static void createPurchase(String type) {
		if (type == "Purchase") {
			
			Purchase purchase = null;
			ArrayList<Object> properties = new ArrayList<Object>();
			properties = Forms.createPurchase();
			if (properties == null)return;
			purchase = new Purchase((Product) properties.get(0), (Partner) properties.get(1), (int) properties.get(2));
			
			modules.purchases.classes.Singleton.purchases.add(purchase);
		}
		
	}
	
	public static void searchPurchase(String type) {
		if (type == "Purchase") {
			search.searchPurchase();
		}
	}
	
	public static void myPurchases(String type) {

		int cont_list = 0;
		List<String[]> defaultValues = new ArrayList<String[]>();
		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();
		ArrayList<Integer> positions = new ArrayList<Integer>();

		// Create general columns for table
		columns.add("ID");
		columns.add("PRODUCT");
		columns.add("PARTNER");
		columns.add("DNI");
		columns.add("DATE");

		for (int i = 0; i < modules.purchases.classes.Singleton.purchases.size(); i++) {
			Purchase purchase = modules.purchases.classes.Singleton.purchases.get(i);
			if (purchase.getPartner() == modules.users.classes.Singleton.userLog) {
				cont_list++;
				//String[] strProd = { "" + String.format("%04d", cont_list), objUser.getName(),objUser.getSurnames(),"" + objUser.getDni(), objUser.getEmail(), };
				
				String[] strP = { "" + String.format("%04d", cont_list), purchase.getIdProduct(), purchase.getPartner().getName(),
						purchase.getPartner().getDni(), purchase.getPurchaseDate().getDate(), };
				
				values.add(strP);
				defaultValues.add(strP);
				positions.add(i);
			}
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);

		JTable table = new JTable(tableModel) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};		
		table.setRowSorter(sorter);

		JScrollPane scrollUsersTable = new JScrollPane(table);
		JOptionPane.showMessageDialog(null, scrollUsersTable); //Show products

	}
}
