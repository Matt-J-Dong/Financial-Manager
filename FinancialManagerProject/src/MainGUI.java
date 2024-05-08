
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainGUI {
    private JFrame frame;
    private AccountItems dataA;
    private BudgetItems dataB;
    private NetIncomeItems dataN;

    public MainGUI(AccountItems dataA, BudgetItems dataB, NetIncomeItems dataN) {
        this.dataA = dataA;
        this.dataB = dataB;
        this.dataN = dataN;
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
        netIncomeTrackerButton.addActionListener(e -> new NetIncomeTrackerGUI(dataN));
        buttonPanel.setLayout(null);
        buttonPanel.add(netIncomeTrackerButton);

        JButton accountsButton = new JButton("Accounts");
        accountsButton.setBounds(6, 150, 400, 90);
        accountsButton.addActionListener(e -> new AccountsGUI(dataA));
        buttonPanel.add(accountsButton);

        JButton budgetPlannerButton = new JButton("Budget Advisor");
        budgetPlannerButton.setBounds(6, 238, 400, 90);
        budgetPlannerButton.addActionListener(e -> new BudgetPlannerGUI("Budget", dataB, frame));
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

