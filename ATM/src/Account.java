import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Account extends JFrame implements ActionListener, KeyListener {

    private double balanceValue = 35845; 
	private JLabel Balance = new JLabel("Your balance is: USD " + getBalanceValue());
	private JLabel bemVindo = new JLabel("Welcome again, " + Login.getReadUser());
    private JButton withdraw = new JButton("Withdraw");
    private JButton insertFunds = new JButton("Insert funds");

    Account() {
        this.setBounds(300,300,400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
        this.setResizable(false);
		this.setVisible(true);
        withdraw.setBounds(100, 200, 100, 25);
        withdraw.addActionListener(this);
        insertFunds.setBounds(200, 200, 125, 25);
        insertFunds.addActionListener(this);
        bemVindo.setBounds(10, -40, 150, 100);
        Balance.setBounds(100, -50, 200, 200);
        this.addKeyListener(this);
        this.add(withdraw);
        this.add(bemVindo);
        this.add(insertFunds);
        this.add(Balance);
        this.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
    	if (e.getSource()==withdraw) {
    	String withdrawal = JOptionPane.showInputDialog(null, "Insert the amount you want to withdraw:", "Withdrawal",JOptionPane.QUESTION_MESSAGE);
    	double d=Double.parseDouble(withdrawal);  
    		if (d > 0 && balanceValue > d) {
    			balanceValue = balanceValue - d;
    			JOptionPane.showMessageDialog(null, "Your new balance is USD " + balanceValue);			
    	} else {
    		JOptionPane.showMessageDialog(null, "You don't have enough money to withdraw!");
    	}
    		Balance.setText("Your balance is: USD " + getBalanceValue());
    	}
    	
    	if (e.getSource()==insertFunds) {
    		String insertFunds = JOptionPane.showInputDialog(null, "Insert the amount you to deposit:", "Deposit",JOptionPane.QUESTION_MESSAGE);
        	double d=Double.parseDouble(insertFunds);  
        		if (d < 10000 && d > 0) {
        			balanceValue = balanceValue + d;
        			JOptionPane.showMessageDialog(null, "Your new balance is USD " + balanceValue);		
        		} else if (d < 0) {
        					JOptionPane.showMessageDialog(null, "You cannot deposit negative values!");
        				}
    				 else if (d > 10000){
    					JOptionPane.showMessageDialog(null, "You can only deposit USD 10.000,00 on our App.");
    		}	
        	Balance.setText("Your balance is: USD " + getBalanceValue());
    	}
    	
    }
    
    
    public double getBalanceValue() {
		return balanceValue;
	}

	public void setBalanceValue(double balanceValue) {
		this.balanceValue = balanceValue;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
		System.out.println("oi");
		JOptionPane.showOptionDialog(null, "Do you want to close the app?", "Exit", 0, 0, null, null, e);
		
		}
	}
	
}
    
