package modules.users.functions;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import classes.*;
import functions.functions;
import modules.products.classes.Film;
import modules.products.classes.Game;
import modules.products.classes.MusicDisc;
import modules.products.classes.Product;
import modules.users.classes.*;
import modules.users.templates.Forms;

public class User_CRUD {
	// Date date = new Date();
	// User user = null;
	// defaultAdmin = new Admin("admin", "admin", "Administrator", "Surname1
	// Surname2", "Ontinyent", "46870", "Carrer Sant Josep, 6",
	// "jrevertvila@gmail.com", date, 665996125);
	// Singleton.users.add(defaultAdmin);
	public static void createUser(String type) {// CREATE NEW PRODUCT
		User user = null;
		boolean repeated = false;
		do {
			repeated = false;
			ArrayList<Object> properties = new ArrayList<Object>();
			if (type == "Admin") { // create new Admin
				properties = Forms.adminForm();
				if (properties == null)
					return;
				user = new Admin((String) properties.get(0), (String) properties.get(1), (String) properties.get(2),
						(String) properties.get(3), (String) properties.get(4), (String) properties.get(5),
						(String) properties.get(6), (String) properties.get(7), (String) properties.get(8),(Date) properties.get(9), (int) properties.get(10));

			} else if (type == "Partner") { // create new Partner
				properties = Forms.partnerForm();
				if (properties == null)
					return;
				user = new Partner("partner","123",(String) properties.get(0), (String) properties.get(1), (String) properties.get(2),
						(String) properties.get(3), (String) properties.get(4), (String) properties.get(5),
						(String) properties.get(6), (Date) properties.get(7), (int) properties.get(8));
			}
			if (user.find() == 1) {
				repeated = true;
				JOptionPane.showMessageDialog(null, "This user already exists", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} while (repeated == true);
		Singleton.users.add(user);

	}

	public static void searchUser(String type) {
		
		int cont_list = 0;
		List<String[]> defaultValues = new ArrayList<String[]>();
		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();
		ArrayList<Integer> positions = new ArrayList<Integer>();

		// Create general columns for table
		columns.add("ID");
		columns.add("NAME \u25BC");
		columns.add("SURNAMES \u25BC");
		columns.add("DNI \u25BC");
		columns.add("EMAIL \u25BC");

		for (int i = 0; i < modules.users.classes.Singleton.users.size(); i++) {
			User objUser = modules.users.classes.Singleton.users.get(i);
			if (functions.validateInstaceof(objUser, type)) {
				cont_list++;
				String[] strProd = { "" + cont_list, objUser.getName(),objUser.getSurnames(),"" + objUser.getDni(), objUser.getEmail(), };
				values.add(strProd);
				defaultValues.add(strProd);
				positions.add(i);
			}
		}
		DefaultTableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
		
		JTable table = new JTable(tableModel) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};		
		
		JScrollPane scrollUsersTable = new JScrollPane(table);
		
		// LISTENERS
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            	if (e.getClickCount() == 2) {
            		String[][] objProperties = null;
            		User objUser = modules.users.classes.Singleton.users.get(positions.get(table.getSelectedRow()));
            		if (functions.validateInstaceof(objUser, "Admin")) {
            			objProperties = ((Admin) objUser).getProperties();
            		} else if (functions.validateInstaceof(objUser, "Partner")){
            			objProperties = ((Partner) objUser).getProperties();
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
		
		
		
		
		JOptionPane.showMessageDialog(null, scrollUsersTable); //Show products
	
	}
	
	
	public static void deleteUser(String type) {
		int cont_list = 0;
		String[] choice = {"Delete","Cancel"};
		List<Object[]> defaultValues = new ArrayList<Object[]>();
		List<String> columns = new ArrayList<String>();
		List<Object[]> values = new ArrayList<Object[]>();
		ArrayList<Integer> positions = new ArrayList<Integer>();
		JCheckBox check=new JCheckBox();

		// Create general columns for table
		columns.add("ID");
		columns.add("NAME \u25BC");
		columns.add("SURNAMES \u25BC");
		columns.add("DNI \u25BC");
		columns.add("EMAIL \u25BC");
		columns.add("DELETE");

		for (int i = 0; i < modules.users.classes.Singleton.users.size(); i++) {
			User objUser = modules.users.classes.Singleton.users.get(i);
			if (functions.validateInstaceof(objUser, type)) {
				cont_list++;
				Object[] strObj = { "" + cont_list, objUser.getName(),objUser.getSurnames(),"" + objUser.getDni(), objUser.getEmail(), Boolean.FALSE};				
				values.add(strObj);
				defaultValues.add(strObj);
				positions.add(i);
			}
		}

		DefaultTableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
		
		JTable table = new JTable(tableModel) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				if (colIndex == 5)
					return true;
				return false;
			}
		};

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
            		User objUser = modules.users.classes.Singleton.users.get(positions.get(table.getSelectedRow()));
            		if (functions.validateInstaceof(objUser, "Admin")) {
            			objProperties = ((Admin) objUser).getProperties();
            		} else if (functions.validateInstaceof(objUser, "Partner")){
            			objProperties = ((Partner) objUser).getProperties();
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
		
        int option = 0;
		
        
        	option = JOptionPane.showOptionDialog(null, scrollProductsTable, "Delete user", 0, 0, null, choice, choice[0]);
    		
    		if ((option == JOptionPane.CLOSED_OPTION) || (option == 1)) { //When you click on cancel or close the window, the function closes and returns to the previous one.
    			return;
    		}
    		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?\n(The users will be permantelly deleted)");
    		
    		if ((confirm == JOptionPane.YES_OPTION)) {
    			int u = 0;
    			for(int i=0;i<table.getModel().getRowCount();i++)
    	        {
    				
    	          if ((boolean) table.getValueAt(i, 5)==true)
    	          {
    	        	  
    	        	  int pos = positions.get(u);
    	        	  System.out.println(pos);
    	        	  modules.users.classes.Singleton.users.remove(pos);
    	        	  u = u-1;
    	          }
    	          u++;
    	       }
    			return;
    		}
        
		
		
		
		
		//JOptionPane.showMessageDialog(null, scrollProductsTable); //Show products
		
	}
}