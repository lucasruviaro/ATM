import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	private JFrame frame = new JFrame();
	private JLabel labelUser = new JLabel("Username");
	private JLabel labelPassword = new JLabel("Password");
	private JTextField textUser = new JTextField();
	private JPasswordField textPassword = new JPasswordField();
	private JButton btnLogin = new JButton("Login");
	public static String readUser;
	
	public Login () {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 150);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		labelUser.setBounds(10, 5, 100, 50);
		textUser.setBounds(10, 40, 200, 20);
		labelPassword.setBounds(10, 50, 100, 50);
		textPassword.setBounds(10, 85, 200, 20);
		btnLogin.setBounds(220, 85, 100, 25);
		btnLogin.addActionListener(this);
		frame.getContentPane().setBackground(Color.gray);
		frame.setTitle("ATM");
		frame.add(labelUser);
		frame.add(labelPassword);
		frame.add(textUser);
		frame.add(textPassword);
		frame.add(btnLogin);
		frame.setVisible(true);
	}
public void actionPerformed(ActionEvent e) {
	
	readUser = textUser.getText();
	String readPassword = String.valueOf(textPassword.getPassword());
	
	
	if(readUser.equals("admin") && (readPassword.equals("admin"))) {
		
			frame.dispose();
			new Account();
		
	}  else {
		JOptionPane.showMessageDialog(null, "Wrong credentials. Please, try again.");
	}
	}

public static String getReadUser() {
	return readUser;
}
public void setReadUser(String readUser) {
	this.readUser = readUser;
}
}	
		
			
		
		
		
	
	
	
		

	

