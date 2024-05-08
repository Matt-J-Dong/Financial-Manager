
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class BudgetPlannerGUI {
    private JFrame subFrame;
    private JList<String> sourceList;
    private DefaultListModel<String> listModel;

    public BudgetPlannerGUI(String type, BudgetItems data, JFrame parentFrame) {
    	myFrame(type, data, parentFrame);
    }
    private void myFrame(String type, BudgetItems data, JFrame parentFrame) {
        subFrame = new JFrame("Edit " + type);
        subFrame.setSize(500, 300);
        subFrame.setLocationRelativeTo(parentFrame);
        subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        listModel = new DefaultListModel<>();
        ArrayList<String> sources = data.getBudgetSources();
        for (String source : sources) {
            listModel.addElement(source);
        }
        subFrame.getContentPane().setLayout(null);

        sourceList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(sourceList);
        scrollPane.setBounds(0, 0, 500, 219);
        subFrame.getContentPane().add(scrollPane);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.setBounds(10, 231, 484, 29);
        
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(subFrame, "Enter new category name:");
            if (name != null && !name.isEmpty()) {
                double amount = Double.parseDouble(JOptionPane.showInputDialog(subFrame, "Enter amount:"));
                double goal = Double.parseDouble(JOptionPane.showInputDialog(subFrame, "Enter goal:"));
                add(data, name, amount, goal);
                
                
            }
        });
        buttonPanel.add(addButton);
        
        
        JButton contributeButton = new JButton("Contribute");
        contributeButton.addActionListener(e -> {
            int index = sourceList.getSelectedIndex();
            if (index != -1) {
            	double amount = Double.parseDouble(JOptionPane.showInputDialog(subFrame, "Enter amount you can contribute: "));
            	contribute(data, amount, index);
                
            }
        });
        buttonPanel.add(contributeButton);
        
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(e -> {
            int index = sourceList.getSelectedIndex();
            if (index != -1) {
                remove(data, index);
            }
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
    
    private void remove(BudgetItems data, int index) {
    	data.removeBudgetItem(index);
        listModel.remove(index);
    }
    
    private void contribute(BudgetItems data, double amount, int index) {
    	String itemDetails = data.contributeItem(amount, index);
        listModel.set(index, itemDetails);
        sourceList.repaint();
    }
    private void add(BudgetItems data, String name, double amount, double goal) {
    	data.addBudgetItem(name, amount, goal);
    	double progress = Math.round(amount/goal * 100.00);
    	listModel.addElement(name + " |  Total Contribution: "+ amount + " |  Goal: " + goal + " |  Progress: "+progress + "%");
    }
}
