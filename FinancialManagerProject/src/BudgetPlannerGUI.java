
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class BudgetPlannerGUI {
    private JFrame subFrame;
    private JList<String> sourceList;
    private DefaultListModel<String> listModel;

    public BudgetPlannerGUI(String type, FinancialData data, JFrame parentFrame) {
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
                data.addBudgetItem(name, amount, goal);
                double progress = Math.round(amount/goal * 100.00);
                 
                listModel.addElement(name + " |  Total Contribution: "+ amount + " |  Goal: " + goal + " |  Progress: "+progress + "%");
            }
        });
        buttonPanel.add(addButton);

        
        JButton contributeButton = new JButton("Contribute");
        contributeButton.addActionListener(e -> {
            int index = sourceList.getSelectedIndex();
            if (index != -1) {
            	double amount = Double.parseDouble(JOptionPane.showInputDialog(subFrame, "Enter amount you can contribute: "));

                String itemDetails = data.contributeItem(amount, index);
                listModel.set(index, itemDetails);
                System.out.println(itemDetails);
                sourceList.repaint();
            }
        });
        buttonPanel.add(contributeButton);
        
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(e -> {
            int index = sourceList.getSelectedIndex();
            if (index != -1) {
                data.removeBudgetItem(index);
                listModel.remove(index);
                
                
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
