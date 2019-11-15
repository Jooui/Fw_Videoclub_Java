package modules.purchases.templates;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

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

public class Forms {
	
	public static ArrayList<Object> createPurchase(){
		
		String[] choice = {"Create","Cancel"};
		
		ArrayList<String> productsName=new ArrayList<String>();
		final JComboBox<String> box1 = new JComboBox<String>(new String[]{"Films", "Games", "Music Discs"});
        
		
		final DefaultListModel<Object> listModelProducts = new DefaultListModel<>();
		final DefaultListModel<Object> listModelPartners = new DefaultListModel<>(); 
		JButton buttonFilterProd=new JButton("Filter");
		JTextField filterFieldProd = new JTextField(20);
		buttonFilterProd.setBounds(200,150,80,30);
		
		JButton buttonFilterPartners=new JButton("Filter");
		JTextField filterFieldPartners = new JTextField(20);
		buttonFilterProd.setBounds(200,150,80,30);
        
        for (int i = 0; i<productsName.size(); i++) {
        	listModelProducts.addElement(productsName.get(i)); 
        }
        
        box1.addActionListener(new ActionListener(){
        	
 		   public void actionPerformed(ActionEvent e){
 			  productsName.clear();
 			   System.out.println(box1.getSelectedItem());
 		       if(box1.getSelectedItem().equals("Films")){
	         		System.out.println("enter films");

 		    	  for ( int i = 0; i<Singleton.products.size(); i++) {
 		         	Product product = Singleton.products.get(i);
 		         	if (product instanceof Film) {
 		         		System.out.println(product.getName());
 	 		         	productsName.add(product.getName());
 		         	}
 		         		
 		         }
 		    	      
 		       }
 		       
 		       if(box1.getSelectedItem().equals("Games")){
	         		System.out.println("enter gamesss");

 		    	  for ( int i = 0; i<Singleton.products.size(); i++) {
 	 		         	Product product = Singleton.products.get(i);
 	 		         	if (product instanceof Game)
 	 		         	productsName.add(product.getName());
 	 		         	
 	 		         }
 		       }
 		       
 		      if(box1.getSelectedItem().equals("Music Discs")){
	         		System.out.println("enter music");

 		    	  for ( int i = 0; i<Singleton.products.size(); i++) {
 	 		         	Product product = Singleton.products.get(i);
 	 		         	if (product instanceof MusicDisc)
 	 		         	productsName.add(product.getName());
 	 		         }
 		       }
 		      listModelProducts.removeAllElements();
 		      System.out.println(productsName.size());
 		     for (int x = 0; x < productsName.size(); x++) {
 		    	listModelProducts.addElement(productsName.get(x));
 		     }
 		      
 		   }
 		});
        
        buttonFilterProd.addActionListener(new ActionListener() {  
            
            public void actionPerformed(ActionEvent e) {
            	int cont = 0;
                System.out.println("entra al action");
            	String labelText = filterFieldProd.getText();
            	if (!labelText.isEmpty()) {
	            	boolean check = false;
	            	listModelProducts.removeAllElements();
	            	for (int x = 0; x < productsName.size(); x++) {
	            		
	            		for (int y = 0; y < labelText.length(); y++) {
	            			if (labelText.length()<=productsName.get(x).length()) {
	            				try {
		            				if(labelText.substring(y,y+1).equalsIgnoreCase(productsName.get(x).substring(y,y+1))){
			                            check = true;
			                        }else {
			                        	check = false;
			                        	break;
			                        	
			                        }
								} catch (Exception e2) {
									check = false;
									System.out.println("exceptionnnn");
								}
	            			}else {
	            				System.out.println(productsName.get(x));
	            			}
	            			
	            			
	            		}
	            		if (check == true) {
	            			listModelProducts.addElement(productsName.get(x));
                            cont++;
	            		}
	            	}
            	}else {
            		listModelProducts.removeAllElements();
            		for (int i = 0; i<productsName.size(); i++) {
            			listModelProducts.addElement(productsName.get(i)); 
                    }
            	}
            	if (cont==0 && (!labelText.isEmpty())) {
            		listModelProducts.addElement("No products found"); 
            	}
            }
            
        });    
        final JSeparator separator = new JSeparator();  
        final JSeparator separator2 = new JSeparator();  

        
        final JList<Object> listProducts = new JList<>(listModelProducts); 
        JScrollPane scrollProducts = new JScrollPane(listProducts);
        listProducts.setBounds(100,100, 75,75);
        
        final JList<Object> listPartners = new JList<>(listModelPartners); 
        JScrollPane scrollPartners = new JScrollPane(listPartners);
        listPartners.setBounds(100,100, 75,75);
        
        final JLabel labelPricePVE = new JLabel();          
        labelPricePVE.setSize(500,100);
        labelPricePVE.setText("Price PVE:                                                        49.00€");

        final JLabel labelDiscount = new JLabel();          
        labelDiscount.setSize(500,100);
        labelDiscount.setText("User Discount:                                                       5%");

        final JLabel labelTotalPrice = new JLabel();          
        labelTotalPrice.setSize(500,100);
        labelTotalPrice.setText("Total Price:                                                     46.00€");
        
        JPanel panelProducts = new JPanel();

        panelProducts.add(filterFieldProd);
        panelProducts.add(buttonFilterProd);

        JPanel panelPartners = new JPanel();

        panelPartners.add(filterFieldPartners);
        panelPartners.add(buttonFilterPartners);
        
        Object[] message = {
        		"Choose type:",box1,
				scrollProducts,
				panelProducts,
				separator,
				"Choose user:",scrollPartners,
				panelPartners,
				separator2,
				labelPricePVE,
				labelDiscount,
				labelTotalPrice,

			};
		int option = JOptionPane.showOptionDialog(null, message,"Add Game",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
		
		String data = "";  
        if (listProducts.getSelectedIndex() != -1) {                       
            data = "" + listProducts.getSelectedValue();   
            System.out.println(data);
        }  
		     
	
		


		return null;
	}

}
