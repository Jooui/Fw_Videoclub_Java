package modules.purchases.templates;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import modules.products.classes.Product;
import modules.purchases.classes.Purchase;
import modules.users.classes.Partner;
import classes.Date;

public class search {
	public static ArrayList<Object> searchPurchase() {
		ArrayList<Object> result = new ArrayList<Object>();
		
		
		DefaultListModel<Object> listModelPurchases = new DefaultListModel<>();

		final JList<Object> listPurchases = new JList<>(listModelPurchases);
		JScrollPane scrollProducts = new JScrollPane(listPurchases);
		listPurchases.setBounds(100, 100, 75, 75);
		
		JComboBox<String> box1 = new JComboBox<String>(new String[] { "By Partner", "By Product", "By Date" });
		JButton buttonFilterProd = new JButton("Filter");
		JTextField filterFieldProd = new JTextField(20);
		buttonFilterProd.setBounds(200, 150, 80, 30);
		
		JPanel panelFilters = new JPanel();
		
		panelFilters.add(box1);
		panelFilters.add(filterFieldProd);
		panelFilters.add(buttonFilterProd);
		
		
		for (int i = 0; i < modules.purchases.classes.Singleton.purchases.size(); i++) {
			
			Purchase objPurchase = modules.purchases.classes.Singleton.purchases.get(i);
			
			String strPurchase = ((i+1)+" - PRODUCT: "+objPurchase.getIdProduct()+" ---- PARTNER: "+objPurchase.getPartner().getName()+" DNI: "+objPurchase.getPartner().getDni()+" --- DATE: "+objPurchase.getPurchaseDate().toString());
			
			listModelPurchases.addElement(strPurchase);
		}
		
		
		//LISTENERS
		
		listPurchases.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				if (me.getClickCount() == 2) {
					
					Purchase objPurchase = modules.purchases.classes.Singleton.purchases.get(listPurchases.getSelectedIndex());
					
					/*Partner partnerPurchase = objPurchase.getPartner();
					
					Product productPurchase = objPurchase.getProduct();
					
					Date datePurchase = objPurchase.getPurchaseDate();
					
					
					
					Object[] dataProduct = {"Name: ",productPurchase.getName(),
											"Type: ",productPurchase.getClass(),
											"Price: ",productPurchase.getPrice(),
											"Date: ",productPurchase.getDate().toString(),};
					
					String partnerNameSur = (partnerPurchase.getName()+" "+partnerPurchase.getSurnames());
					String partnerAddress = (partnerPurchase.getPostalCode()+partnerPurchase.getCity()+partnerPurchase.getAddress());
					
					Object[] dataPartner = {"Name :",partnerNameSur,
											"DNI: ",partnerPurchase.getDni(),
											"Tlf: ",partnerPurchase.getTlf(),
											"Email: ",partnerPurchase.getEmail(),
											"Birth Date: ",partnerPurchase.getFnac().toString(),
											"Address",partnerAddress};
					
					JSeparator separator = new JSeparator(JSeparator.VERTICAL);

					
					// CREATE JPANEL FOR ALIGN ITEMS HORITZONTALLY
					JPanel panelInfo = new JPanel();

					panelInfo.add(null, dataProduct);
					panelInfo.add(separator);
					panelInfo.add(null, dataPartner);
					
					Object[] message = {"Purchase INFO",panelInfo,};*/
					
					JOptionPane.showMessageDialog(null, objPurchase.toString()+"\n Objecto seleccionado. VENTANA ABIERTA");

					me.consume();
				}
			}
		});
		
		
		
		
		
		
		
		Object[] messageObj = { scrollProducts,"Choose filter", panelFilters,

		};
		JOptionPane.showMessageDialog(null, messageObj);
		return result;
	}
}
