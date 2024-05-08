
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class EditAccountItemsGUI {
    private JFrame subFrame;
    private JList<String> sourceList;
    private DefaultListModel<String> listModel;

    public EditAccountItemsGUI(String type, AccountItems data, JFrame parentFrame, JLabel balanceLabel) {
    	myFrame(type, data, parentFrame, balanceLabel);
    }
    private void myFrame(String type, AccountItems data, JFrame parentFrame, JLabel balanceLabel) {
    	
        subFrame = new JFrame("Edit " + type);
        subFrame.setSize(300, 400);
        subFrame.setLocationRelativeTo(parentFrame);
        subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        listModel = new DefaultListModel<>();
        ArrayList<String> sources = 
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
            addItem(type, data, parentFrame, balanceLabel);
        });
        buttonPanel.add(addButton);

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(e -> {
            removeItem(type, data, parentFrame, balanceLabel, sources);
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
    
    
    private void removeItem(String type, AccountItems data, JFrame parentFrame, JLabel balanceLabel, ArrayList<String> sources) {
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
            }
            
        }
    }
    
    
    private void addItem(String type, AccountItems data, JFrame parentFrame, JLabel balanceLabel) {
    	String name = JOptionPane.showInputDialog(subFrame, "Enter source name:");
        if (name != null && !name.isEmpty()) {
            double amount = Double.parseDouble(JOptionPane.showInputDialog(subFrame, "Enter amount:"));
            if ("Checkings".equals(type)) {
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
    }
}
