package modules.products.functions;

import modules.products.classes.*;
import modules.products.templates.*;
import modules.purchases.classes.Purchase;
import modules.users.classes.Partner;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import classes.*;

import functions.*;

public class Product_CRUD {

	public static void createProduct(String type) {// CREATE NEW PRODUCT
		Product product = null;
		ArrayList<Object> properties = new ArrayList<Object>();
		if (type == "Film") { // create new Film
			properties = Forms.filmForm(null);
			if (properties == null)
				return;
			product = new Film((String) properties.get(0), (int) properties.get(1), (int) properties.get(2),
					(double) properties.get(3), (Date) properties.get(4), (int) properties.get(5),
					(String) properties.get(6));

		} else if (type == "Game") { // create new Game
			properties = Forms.gameForm(null);

			if (properties == null)
				return;
			product = new Game((String) properties.get(0), (int) properties.get(1), (int) properties.get(2),
					(double) properties.get(3), (Date) properties.get(4), (String) properties.get(5));

		} else if (type == "Music") { // create new MusicDisc
			properties = Forms.musicForm(null);
			if (properties == null)
				return;
			product = new MusicDisc((String) properties.get(0), (int) properties.get(1), (int) properties.get(2),
					(double) properties.get(3), (Date) properties.get(4), (int) properties.get(5),
					(String) properties.get(6));
		}
		Singleton.products.add(product);
	}

	public static void showProducts(String type) {
		System.out.println("ARRAY SIZE PRODUCTS: "+modules.products.classes.Singleton.products.size());
		int cont_list = 0;
		List<String[]> defaultValues = new ArrayList<String[]>();
		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();
		ArrayList<Integer> positions = new ArrayList<Integer>();
		JCheckBox check=new JCheckBox();

		// Create general columns for table
		columns.add("ID");
		columns.add("NAME");
		columns.add("PRICE");
		columns.add("STOCK");
		columns.add("DATE");

		for (int i = 0; i < modules.products.classes.Singleton.products.size(); i++) {
			Product objProduct = modules.products.classes.Singleton.products.get(i);
			if (functions.validateInstaceof(objProduct, type)) {
				cont_list++;
				String[] strProd = { "" + String.format("%04d", cont_list), objProduct.getName(),objProduct.getPrice()+"\u20AC","" + objProduct.getStock(), objProduct.getDate().getDate(), };
				values.add(strProd);
				defaultValues.add(strProd);
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

		JScrollPane scrollProductsTable = new JScrollPane(table);
		
		// LISTENERS
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            	if (e.getClickCount() == 2) {
            		String[][] objProperties = null;
            		Product objProduct = modules.products.classes.Singleton.products.get(positions.get(table.getSelectedRow()));
            		if (functions.validateInstaceof(objProduct, "Film")) {
            			objProperties = ((Film) objProduct).getProperties();
            		} else if (functions.validateInstaceof(objProduct, "Game")){
            			objProperties = ((Game) objProduct).getProperties();
            		} else if (functions.validateInstaceof(objProduct, "MusicDisc")) {
            			objProperties = ((MusicDisc) objProduct).getProperties();
            		}
            		String str = type+" Information\n\n";
            		
            		String[] values = (String[]) objProperties[0];
            		
            		String[] names = (String[]) objProperties[1];

            		for (int i = 0; i < values.length; i++) {
						str = str +(names[i]+values[i]+"\n");
					}
            		
            		JOptionPane.showMessageDialog(null, str);
            		
					e.consume();
            	}
                
            }
        });
		
		
		
		
		JOptionPane.showMessageDialog(null, scrollProductsTable); //Show products
	}

	
	
	public static void editProduct(String type) {

		int cont_list = 0;
		List<String[]> defaultValues = new ArrayList<String[]>();
		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();
		ArrayList<Integer> positions = new ArrayList<Integer>();
		JCheckBox check=new JCheckBox();

		// Create general columns for table
		columns.add("ID");
		columns.add("NAME");
		columns.add("PRICE");
		columns.add("STOCK");
		columns.add("DATE");

		for (int i = 0; i < modules.products.classes.Singleton.products.size(); i++) {
			Product objProduct = modules.products.classes.Singleton.products.get(i);
			if (functions.validateInstaceof(objProduct, type)) {
				cont_list++;
				String[] strProd = { "" + String.format("%04d", cont_list), objProduct.getName(),objProduct.getPrice()+"\u20AC","" + objProduct.getStock(), objProduct.getDate().getDate(), };
				values.add(strProd);
				defaultValues.add(strProd);
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

		JScrollPane scrollProductsTable = new JScrollPane(table);
		
		

		
		// LISTENERS
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            	if (e.getClickCount() == 2) {
	            	System.out.println("entra al event");
	            	Integer selected = 0, cont_list = 0;
	        		ArrayList<Object> properties = new ArrayList<Object>();
	        		Product product1 = modules.products.classes.Singleton.products.get(positions.get(table.getSelectedRow()));
	        		selected = table.getSelectedRow();
	        		int getNumber = positions.get((selected));
	        		product1 = Singleton.products.get(getNumber);
	        		
	        		if (product1 instanceof Film) {
	        			properties = Forms.filmForm((Film) product1);
	        			if (properties == null)
	        				return;
	        			Film product = null;
	        			product = new Film((String) properties.get(0), (int) properties.get(1), (int) properties.get(2),
	        					(double) properties.get(3), (Date) properties.get(4), (int) properties.get(5),
	        					(String) properties.get(6));
	        			Singleton.products.set(getNumber, product);
	
	        		} else if (product1 instanceof Game) {
	        			Game product = null;
	        			properties = Forms.gameForm((Game) product1);
	        			if (properties == null)
	        				return;
	
	        			product = new Game((String) properties.get(0), (int) properties.get(1), (int) properties.get(2),
	        					(double) properties.get(3), (Date) properties.get(4), (String) properties.get(5));
	        			Singleton.products.set(getNumber, product);
	
	        		} else if (product1 instanceof MusicDisc) {
	        			MusicDisc product = null;
	        			properties = Forms.musicForm((MusicDisc) product1);
	        			if (properties == null)
	        				return;
	
	        			product = new MusicDisc((String) properties.get(0), (int) properties.get(1), (int) properties.get(2),
	        					(double) properties.get(3), (Date) properties.get(4), (int) properties.get(5),
	        					(String) properties.get(6));
	        			Singleton.products.set(getNumber, product);
	        			
	        			
	        		}
					tableModel.setRowCount(0);

	        		for (int i = 0; i < modules.products.classes.Singleton.products.size(); i++) {
	        			Product objProduct = modules.products.classes.Singleton.products.get(i);
	        			if (functions.validateInstaceof(objProduct, type)) {
	        				cont_list++;
							tableModel.addRow(new String[] { "" + String.format("%04d", cont_list), objProduct.getName(),objProduct.getPrice()+"\u20AC","" + objProduct.getStock(), objProduct.getDate().getDate(), });
	        			}
	        		}
	        		e.consume();
            	}
            }
        });
        
        JOptionPane.showMessageDialog(null, scrollProductsTable); //Show products
	}

	public static void deleteProduct(String type) {
		int cont_list = 0;
		String[] choice = {"Delete","Cancel"};
		List<Object[]> defaultValues = new ArrayList<Object[]>();
		List<String> columns = new ArrayList<String>();
		List<Object[]> values = new ArrayList<Object[]>();
		ArrayList<Integer> positions = new ArrayList<Integer>();
		JCheckBox check=new JCheckBox();

		// Create general columns for table
		columns.add("ID");
		columns.add("NAME");
		columns.add("PRICE");
		columns.add("STOCK");
		columns.add("DATE");
		columns.add("DELETE");

		for (int i = 0; i < modules.products.classes.Singleton.products.size(); i++) {
			Product objProduct = modules.products.classes.Singleton.products.get(i);
			if (functions.validateInstaceof(objProduct, type)) {
				cont_list++;
				Object[] strProd = { "" + String.format("%04d", cont_list), objProduct.getName(),objProduct.getPrice()+"\u20AC","" + objProduct.getStock(), objProduct.getDate().getDate(), Boolean.FALSE};				
				values.add(strProd);
				defaultValues.add(strProd);
				positions.add(i);
			}
		}

		DefaultTableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);

		JTable table = new JTable(tableModel) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				if (colIndex == 5)
					return true;
				return false;
			}
		};
		table.setRowSorter(sorter);

//		JTable table = new JTable(tableModel);

		//Put chechbox on JTable
		TableColumn Tcol = new TableColumn();
		Tcol=table.getColumnModel().getColumn(5);//el numero dentro de getColum se refiere a la posici�nen la que se encuentra tu columna	 
		Tcol.setCellEditor(table.getDefaultEditor(Boolean.class));
		Tcol.setCellRenderer(table.getDefaultRenderer(Boolean.class));
		
		
	
		JScrollPane scrollProductsTable = new JScrollPane(table);
		
		
		// LISTENERS
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            	if (e.getClickCount() == 2) {
            		String[][] objProperties = null;
            		Product objProduct = modules.products.classes.Singleton.products.get(positions.get(table.getSelectedRow()));
            		System.out.println(objProduct.toString());
            		if (functions.validateInstaceof(objProduct, "Film")) {
            			objProperties = ((Film) objProduct).getProperties();
            		} else if (functions.validateInstaceof(objProduct, "Game")){
            			objProperties = ((Game) objProduct).getProperties();
            		} else if (functions.validateInstaceof(objProduct, "MusicDisc")) {
            			System.out.println("Entra al validateInstanceof");
            			objProperties = ((MusicDisc) objProduct).getProperties();
            			System.out.println("Sale del getProperties");
            		}
            		String str = type+" Information\n\n";
            		
            		String[] values = (String[]) objProperties[0];
            		
            		String[] names = (String[]) objProperties[1];
            		
            		
            		for (int i = 0; i < values.length; i++) {
						System.out.println(values[i]);
					}
            		for (int i = 0; i < names.length; i++) {
						System.out.println(names[i]);
					}
            		
            		for (int i = 0; i < values.length; i++) {
						str = str +(names[i]+values[i]+"\n");
					}
            		
            		JOptionPane.showMessageDialog(null, str);
            		
					e.consume();
            	}
                
            }
        });
        int option = 0;
		
        
        	option = JOptionPane.showOptionDialog(null, scrollProductsTable, "Delete product", 0, 0, null, choice, choice[0]);
    		
    		if ((option == JOptionPane.CLOSED_OPTION) || (option == 1)) { //When you click on cancel or close the window, the function closes and returns to the previous one.
    			return;
    		}
    		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?\n(The products will be permantelly deleted)");
    		
    		if ((confirm == JOptionPane.YES_OPTION)) {
    			for(int i=0;i<table.getModel().getRowCount();i++)
    	        {
    	          if ((boolean) table.getValueAt(i, 5)==true)
    	          {
    	        	  int pos = positions.get(i);
    	        	  modules.products.classes.Singleton.products.remove(pos);
    	          }
    	       }
    			return;
    		}
        
		
		
		
		
		//JOptionPane.showMessageDialog(null, scrollProductsTable); //Show products
		
	}
}
