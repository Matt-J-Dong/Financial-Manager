
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class EditGUI {
    private JFrame subFrame;
    private JList<String> sourceList;
    private DefaultListModel<String> listModel;

    public EditGUI(String type, FinancialData data, JFrame parentFrame, JLabel balanceLabel) {
        subFrame = new JFrame("Edit " + type);
        subFrame.setSize(300, 400);
        subFrame.setLocationRelativeTo(parentFrame);
        subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        listModel = new DefaultListModel<>();
        ArrayList<String> sources = 
        		"Income".equals(type) ? data.getIncomeSources() :
            "Expenses".equals(type) ? data.getExpenseSources() : 
            	"Investments".equals(type) ? data.getInvestmentSources(): 
            		"Checkings".equals(type) ? data.getCheckingsSources() :
            			"Savings".equals(type) ? data.getSavingsSources():
            				data.getCreditSources();
        sources.forEach(listModel::addElement);
        subFrame.getContentPane().setLayout(null);

        sourceList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(sourceList);
        scrollPane.setBounds(0, 0, 300, 343);
        subFrame.getContentPane().add(scrollPane);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.setBounds(0, 343, 300, 29);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(subFrame, "Enter source name:");
            if (name != null && !name.isEmpty()) {
                double amount = Double.parseDouble(JOptionPane.showInputDialog(subFrame, "Enter amount:"));
                if ("Income".equals(type)) {
                    data.addIncome(name, amount);
                    balanceLabel.setText("$" + data.getBalance());
                } else if ("Expenses".equals(type)) {
                    data.addExpense(name, amount);
                    balanceLabel.setText("$" + data.getBalance());
                }else if ("Investments".equals(type)) {
                    data.addInvestment(name, amount);
                    balanceLabel.setText("$" + data.getBalance());
                }else if ("Checkings".equals(type)) {
                    data.addCheckings(name, amount);
                    balanceLabel.setText("$" + data.getCheckings());
                }else if ("Savings".equals(type)) {
                    data.addSavings(name, amount);
                    balanceLabel.setText("$" + data.getSavings());
                } else if ("Credit".equals(type)) {
                    data.addCredit(name, amount);
                    balanceLabel.setText("$" + data.getCredit());
                }
                listModel.addElement(name + ": $" + amount);
                
            }
        });
        buttonPanel.add(addButton);

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(e -> {
            int index = sourceList.getSelectedIndex();
            if (index != -1) {
                data.removeSource(sources, index);
                listModel.remove(index);
                if ("Checkings".equals(type)) {
                	balanceLabel.setText("$" + data.getCheckings());
                }else if ("Savings".equals(type)) {
                	balanceLabel.setText("$" + data.getSavings());
                } else if ("Credit".equals(type)) {
                	balanceLabel.setText("$" + data.getCredit());
                }else {
                	balanceLabel.setText("$" + data.getBalance());
                }
                
            }
        });
        
        
        buttonPanel.add(removeButton);

        JButton saveExitButton = new JButton("Save & Exit");
        saveExitButton.addActionListener(e -> subFrame.dispose());
        buttonPanel.add(saveExitButton);

        subFrame.getContentPane().add(buttonPanel);
        subFrame.setVisible(true);
    }
}
