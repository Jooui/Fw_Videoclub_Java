package tests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ListsWithScroll {

	public static void main(String[] args) {
		String[] choice = {"Create","Cancel"};
		ArrayList<String> elements = new ArrayList<String>(Arrays.asList("Films","Games","Games","Films","Games","Games","Films","Games","Games","Films","Games","Games","Films","Games","Games","Films","Games","Games","Films","Games","Games","Fil","Fil","Fil","Fil"));
		final DefaultListModel<Object> listModel1 = new DefaultListModel<>();  
		JButton button=new JButton("Filter");
		JTextField filterField = new JTextField();
        button.setBounds(200,150,80,30);
        
        for (int i = 0; i<elements.size(); i++) {
        	listModel1.addElement(elements.get(i)); 
        }
        
        button.addActionListener(new ActionListener() {  
            
            public void actionPerformed(ActionEvent e) {   
                System.out.println("entra al action");
            	String labelText = filterField.getText();
            	if (!labelText.isEmpty()) {
	            	boolean check = false;
	            	listModel1.removeAllElements();
	            	for (int x = 0; x < elements.size(); x++) {
	            		
	            		for (int y = 0; y < labelText.length(); y++) {
	            			if (labelText.length()<=elements.get(x).length()) {
	            				try {
		            				if(labelText.substring(y,y+1).equalsIgnoreCase(elements.get(x).substring(y,y+1))){
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
	            				System.out.println(elements.get(x));
	            			}
	            			
	            			
	            		}
	            		if (check == true) {
	                    	listModel1.addElement(elements.get(x)); 
	            		}
	            	}
            	}else {
	            	listModel1.removeAllElements();
            		for (int i = 0; i<elements.size(); i++) {
                    	listModel1.addElement(elements.get(i)); 
                    }
            	}
            }
            
        });    
        
        final JList<Object> list1 = new JList<>(listModel1); 
        JScrollPane scrollSynpsis = new JScrollPane(list1);
        list1.setBounds(100,100, 75,75);
        
        
        
        Object[] message = {
        		filterField,button,
				"", scrollSynpsis,

			};
		int option = JOptionPane.showOptionDialog(null, message,"Add Game",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
		String data = "";  
        if (list1.getSelectedIndex() != -1) {                       
            data = "" + list1.getSelectedValue();   
            System.out.println(data);
        }  
		     
        
        
        
	}

}
