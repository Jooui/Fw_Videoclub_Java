package dashboard;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import classes.*;
public class Login{
    public static void main(String[] args) {

        String[] choice = {"Log In","Exit"};
        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        int option = 0;
        Object[] message = {
		    "Login\n\nUsername: ", username,
		    "Password:", password,
		};
        option = JOptionPane.showOptionDialog(null, message,"Create Admin",0,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
        
        System.out.println(new String(password.getPassword()));
//        for (int i = 0; i<users.size();i++){
//            System.out.println(users.get(i));
//            User user = null;
//            user = users.get(i);
//            if (user instanceof Admin) {
//                //System.out.println((Admin)user.getPassword());
//            }
//        }


    }
}