package tests;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import modules.products.classes.*;

public class testFormPurchase {
	
    static DefaultListModel defaultListModel=new DefaultListModel();

	public static javax.swing.JScrollPane jScrollPane1;
	public static javax.swing.JList<String> myJList;
	public static javax.swing.JTextField searchTxt;
	
	
	
	public static ArrayList<String> getProducts()
    {
        ArrayList<String> productsName=new ArrayList<String>();
        
        for ( int i = 0; i<Singleton.products.size(); i++) {
        	Product product = Singleton.products.get(i);
        	productsName.add(product.getName());
        }

        return productsName;
    }
	
	public static void bindData() {
		getProducts().stream().forEach((product) -> {
            defaultListModel.addElement(product);
        });
        myJList.setModel(defaultListModel);
        myJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	@SuppressWarnings("unchecked")
	private static void searchFilter(String searchTerm)
    {
        DefaultListModel filteredItems=new DefaultListModel();
        ArrayList products=getProducts();

        products.stream().forEach((product) -> {
            String productName=product.toString().toLowerCase();
            if (productName.contains(searchTerm.toLowerCase())) {
                filteredItems.addElement(product);
            }
        });
        defaultListModel=filteredItems;
        myJList.setModel(defaultListModel);

    }
	
	private static void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        myJList = new javax.swing.JList<>();
        searchTxt = new javax.swing.JTextField();

        
        myJList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myJListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(myJList);

        searchTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
        });

       
    }// </editor-fold>      
	
	private static void myJListMouseClicked(java.awt.event.MouseEvent evt) {                                     
        JOptionPane.showMessageDialog(null,myJList.getSelectedValue(), "Selected Star", JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private static void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {                                      
        searchFilter(searchTxt.getText());
    }    
	
public static void main(String[] args) {
	
	initComponents();
	getProducts();
	bindData();
    	String[] choice = {"Create","Cancel"};

		Object[] message = {
				
			    "Products", jScrollPane1,

			};
		int option = JOptionPane.showOptionDialog(null, message,"Add Game",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
		
		
	}
	
    
    
    
    
}
