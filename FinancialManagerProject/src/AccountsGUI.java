
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountsGUI {
    private JFrame frame;
    private FinancialData data;

    public AccountsGUI(FinancialData data) {
        this.data = data;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Accounts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 378);
        frame.getContentPane().setLayout(null);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 0, 400, 349);
        JButton checkingsButton = new JButton("Checkings");
        checkingsButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        checkingsButton.setHorizontalAlignment(SwingConstants.LEFT);
        checkingsButton.setBounds(31, 63, 327, 85);
        JLabel checkingsLabel = new JLabel("$" + data.getCheckings(), SwingConstants.RIGHT);
        checkingsButton.addActionListener(e -> new EditGUI("Checkings", data, frame, checkingsLabel));
        buttonPanel.setLayout(null);
        
     
        checkingsLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        checkingsLabel.setVerticalAlignment(SwingConstants.TOP);
        checkingsLabel.setBounds(170, 86, 164, 32);
        buttonPanel.add(checkingsLabel);
        buttonPanel.add(checkingsButton);

        frame.getContentPane().add(buttonPanel);
        
        JLabel savingsLabel = new JLabel("$" + data.getSavings(), SwingConstants.RIGHT);
        savingsLabel.setVerticalAlignment(SwingConstants.TOP);
        savingsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        savingsLabel.setBounds(170, 166, 164, 32);
        buttonPanel.add(savingsLabel);
        JButton savingsButton = new JButton("Savings");
        savingsButton.addActionListener(e -> new EditGUI("Savings", data, frame, savingsLabel));
        savingsButton.setHorizontalAlignment(SwingConstants.LEFT);
        savingsButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        savingsButton.setBounds(31, 137, 327, 89);
        buttonPanel.add(savingsButton);
        
        JLabel creditCardLabel = new JLabel("$" + data.getCredit(), SwingConstants.RIGHT);
        JButton payBillButton = new JButton("Pay Credit Card Bill");
        payBillButton.setBounds(196, 264, 151, 29);
        buttonPanel.add(payBillButton);
        payBillButton.addActionListener(e -> {
           data.payCreditBill();
           String newCheckings = "$" + data.getCheckings();
           checkingsLabel.setText(newCheckings);
           String newCredit = "$" + data.getCredit();
           creditCardLabel.setText(newCredit);
        });
        
        
        creditCardLabel.setVerticalAlignment(SwingConstants.TOP);
        creditCardLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        creditCardLabel.setBounds(170, 244, 164, 32);
        buttonPanel.add(creditCardLabel);
        JButton creditCardButton = new JButton("Credit Card");
        creditCardButton.setHorizontalAlignment(SwingConstants.LEFT);
        creditCardButton.addActionListener(e -> new EditGUI("Credit", data, frame, creditCardLabel));
        creditCardButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        creditCardButton.setBounds(31, 215, 327, 89);
        buttonPanel.add(creditCardButton);
        
        
        JLabel accountsTitleLabel = new JLabel("OOP Bank Private Client");
        accountsTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        accountsTitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 26));
        accountsTitleLabel.setBounds(31, 16, 327, 35);
        buttonPanel.add(accountsTitleLabel);
        
        JButton saveExitButton = new JButton("Save/Exit");
        saveExitButton.addActionListener(e -> frame.dispose());
        saveExitButton.setBounds(136, 314, 117, 29);
        buttonPanel.add(saveExitButton);
        frame.setVisible(true);
    }
}

