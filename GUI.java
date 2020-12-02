import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI implements ActionListener {
	 private static JLabel userlabel;
	 private static JTextField usertext;
	 private static JLabel password;
	 private static JPasswordField passwordfield;
	 private static JButton button;
	 private static JLabel succes;
	
	
	
	public static void main(String arg[]) {
		
     JFrame frame = new JFrame();
     JPanel panel = new JPanel();  
     frame.setSize(400,400);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
     frame.add(panel);
     
     panel.setLayout(null);
     userlabel = new JLabel("enter a user name : ");
     userlabel.setBounds(10,20,80,25);
     panel.add(userlabel);
     usertext = new JTextField(20);
     usertext.setBounds(100, 20, 165, 25);
     panel.add(usertext);
     
     password = new JLabel("password :");
     password.setBounds(10,50,80,25);
     panel.add(password);
     passwordfield = new JPasswordField();
     passwordfield.setBounds(100, 50, 165, 25);
     panel.add(passwordfield);
     
     button = new JButton("Login");
     button.setBounds(100,80,80,25);
     button.addActionListener(new GUI());
     panel.add(button);
     
     succes = new JLabel();
     succes.setBounds(10,110,150,25);
     panel.add(succes);
     succes.setText("");
     
     frame.setVisible(true);
     
     
     
     
   	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String text = usertext.getText();
		@SuppressWarnings("deprecation")
		String password = passwordfield.getText();
		if(text.equals("kasun") ) {
			if(password.equals("Kasun#1234")) {  
			succes.setText("login successfully");}
			else {
				succes.setText("wrong password...");
			}
		
	}
		else {succes.setText("wrong user name...");}
}}


