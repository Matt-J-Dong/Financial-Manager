
import javax.swing.*;
import java.awt.*;

public class NetIncomeTrackerGUI {
    private JFrame frame;
    private NetIncomeItems data;

    public NetIncomeTrackerGUI(NetIncomeItems data) {
        this.data = data;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Net Income Tacker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.getContentPane().setLayout(null);

        JLabel balanceLabel = new JLabel("Current Balance: $" + data.getBalance(), SwingConstants.CENTER);
        balanceLabel.setBounds(0, 0, 400, 16);
        frame.getContentPane().add(balanceLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 16, 400, 256);
        JButton editIncomeButton = new JButton("Edit Income");
        editIncomeButton.setBounds(31, 21, 327, 52);
        editIncomeButton.addActionListener(e -> editIncome(balanceLabel));
        buttonPanel.setLayout(null);
        buttonPanel.add(editIncomeButton);

        JButton editExpensesButton = new JButton("Edit Expenses");
        editExpensesButton.setBounds(31, 86, 327, 52);
        editExpensesButton.addActionListener(e -> editExpenses(balanceLabel));
        buttonPanel.add(editExpensesButton);

        JButton editInvestmentsButton = new JButton("Edit Investments");
        editInvestmentsButton.setBounds(31, 150, 327, 52);
        editInvestmentsButton.addActionListener(e -> editInvestments(balanceLabel));
        buttonPanel.add(editInvestmentsButton);
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> exit());
        exitButton.setBounds(136, 212, 117, 29);
        buttonPanel.add(exitButton);
        frame.setVisible(true);
        frame.getContentPane().add(buttonPanel);
        frame.setVisible(true);
    }
    private void exit() {
    	frame.dispose();
    }
    
    private EditNetIncomeTrackerItemsGUI editInvestments(JLabel balanceLabel) {
    	return new EditNetIncomeTrackerItemsGUI("Investments", data, frame, balanceLabel);
    }
    
    
    private EditNetIncomeTrackerItemsGUI editExpenses(JLabel balanceLabel) {
    	return new EditNetIncomeTrackerItemsGUI("Expenses", data, frame, balanceLabel);
    }
    
    private EditNetIncomeTrackerItemsGUI editIncome(JLabel balanceLabel) {
    	return new EditNetIncomeTrackerItemsGUI("Income", data, frame, balanceLabel);
    }
}

