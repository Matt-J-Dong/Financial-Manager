
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainGUI {
    private JFrame frame;
    private FinancialData data;

    public MainGUI(FinancialData data) {
        this.data = data;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Financial Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(416, 362);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 0, 416, 334);
        JButton netIncomeTrackerButton = new JButton("Net Income Tracker");
        
        netIncomeTrackerButton.setBounds(6, 63, 400, 90);
        netIncomeTrackerButton.addActionListener(e -> new NetIncomeTrackerGUI(data));
        buttonPanel.setLayout(null);
        buttonPanel.add(netIncomeTrackerButton);

        JButton accountsButton = new JButton("Accounts");
        accountsButton.setBounds(6, 148, 400, 90);
        accountsButton.addActionListener(e -> new AccountsGUI(data));
        buttonPanel.add(accountsButton);

        JButton budgetPlannerButton = new JButton("Budget Advisor");
        budgetPlannerButton.setBounds(6, 238, 400, 90);
        budgetPlannerButton.addActionListener(e -> new BudgetPlannerGUI("Budget", data, frame));
        frame.getContentPane().setLayout(null);
        buttonPanel.add(budgetPlannerButton);

        frame.getContentPane().add(buttonPanel);
        
        JLabel titleLabel = new JLabel("How can we help you today?");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        titleLabel.setBounds(65, 6, 293, 50);
        buttonPanel.add(titleLabel);
        frame.setVisible(true);
    }
}

