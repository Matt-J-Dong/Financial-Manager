
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class EditNetIncomeTrackerItemsGUI {
    private JFrame subFrame;
    private JList<String> sourceList;
    private DefaultListModel<String> listModel;

    public EditNetIncomeTrackerItemsGUI(String type, NetIncomeItems data, JFrame parentFrame, JLabel balanceLabel) {
    	myFrame(type, data, parentFrame, balanceLabel);
    }
    private void myFrame(String type, NetIncomeItems data, JFrame parentFrame, JLabel balanceLabel) {
        subFrame = new JFrame("Edit " + type);
        subFrame.setSize(300, 400);
        subFrame.setLocationRelativeTo(parentFrame);
        subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        listModel = new DefaultListModel<>();
        ArrayList<String> sources = 
        		"Income".equals(type) ? data.getIncomeSources() :
            "Expenses".equals(type) ? data.getExpenseSources() : 
            	data.getInvestmentSources();
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
        	addItem(type, data, parentFrame, balanceLabel);
        });
        buttonPanel.add(addButton);

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(e -> {
        	int index = sourceList.getSelectedIndex();
            remove(index, balanceLabel, data, sources);
        });
        
        
        buttonPanel.add(removeButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> exit());
        buttonPanel.add(exitButton);

        subFrame.getContentPane().add(buttonPanel);
        subFrame.setVisible(true);
    }
    
    private void exit() {
    	subFrame.dispose();
    }
    
    private void remove(int index, JLabel balanceLabel, NetIncomeItems data, ArrayList<String> sources) {
    	
        if (index != -1) {
            data.removeSource(sources, index);
            listModel.remove(index);
            
            balanceLabel.setText("$" + data.getBalance());
            
            
        }
    }
    
    
    private void addItem(String type, NetIncomeItems data, JFrame parentFrame, JLabel balanceLabel) {
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
            }
            listModel.addElement(name + ": $" + amount);
            
        }
    }
    
}
