import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class System implements ActionListener {

    private JFrame SystemFrame = new JFrame();
    private double balanceValue = 35845; 
	private JLabel Balance = new JLabel("Your balance is: USD " + getBalanceValue());
    private JButton withdraw = new JButton("Withdraw");
    private JButton insertFunds = new JButton("Insert funds");

    System() {
        SystemFrame.setBounds(300,300,800,600);
		SystemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SystemFrame.setLayout(null);
        SystemFrame.setResizable(false);
		SystemFrame.setVisible(true);
        withdraw.setBounds(150, 400, 100, 25);
        withdraw.addActionListener(this);
        insertFunds.setBounds(280, 400, 125, 25);
        insertFunds.addActionListener(this);
        Balance.setBounds(300, -50, 200, 200);
        SystemFrame.add(withdraw);
        SystemFrame.add(insertFunds);
        SystemFrame.add(Balance);
        SystemFrame.setLocationRelativeTo(null);
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
	
}
    
