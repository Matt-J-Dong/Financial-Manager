
import javax.swing.*;
import java.awt.*;

public class NetIncomeTrackerGUI {
    private JFrame frame;
    private FinancialData data;

    public NetIncomeTrackerGUI(FinancialData data) {
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
        editIncomeButton.addActionListener(e -> new EditGUI("Income", data, frame, balanceLabel));
        buttonPanel.setLayout(null);
        buttonPanel.add(editIncomeButton);

        JButton editExpensesButton = new JButton("Edit Expenses");
        editExpensesButton.setBounds(31, 86, 327, 52);
        editExpensesButton.addActionListener(e -> new EditGUI("Expenses", data, frame, balanceLabel));
        buttonPanel.add(editExpensesButton);

        JButton editInvestmentsButton = new JButton("Edit Investments");
        editInvestmentsButton.setBounds(31, 150, 327, 52);
        editInvestmentsButton.addActionListener(e -> new EditGUI("Investments", data, frame, balanceLabel));
        buttonPanel.add(editInvestmentsButton);
        JButton saveExitButton = new JButton("Save/Exit");
        saveExitButton.addActionListener(e -> frame.dispose());
        saveExitButton.setBounds(136, 212, 117, 29);
        buttonPanel.add(saveExitButton);
        frame.setVisible(true);
        frame.getContentPane().add(buttonPanel);
        frame.setVisible(true);
    }
}

