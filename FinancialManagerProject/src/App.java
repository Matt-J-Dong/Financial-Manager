

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            
            AccountItems dataA = new AccountItems();
            BudgetItems dataB = new BudgetItems();
            NetIncomeItems dataN = new NetIncomeItems();
            new MainGUI(dataA, dataB, dataN);
        });
    }
}



