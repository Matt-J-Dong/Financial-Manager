
import java.util.ArrayList;

public class NetIncomeItems {
    private double balance = 0.0;  // Starting balance
    private double incomeTotal = 0.0;
    private double expenseTotal = 0.0;
    private double investmentTotal = 0.0;
    
    private ArrayList<String> incomeSources = new ArrayList<>();
    private ArrayList<String> expenseSources = new ArrayList<>();
    private ArrayList<String> investmentSources = new ArrayList<>();
   
   

    public void addIncome(String source, double amount) {
        incomeSources.add(source + ": $" + amount);
        incomeTotal += amount;
        balance += amount;
    }

    public void addExpense(String source, double amount) {
        expenseSources.add(source + ": $" + amount);
        expenseTotal += amount;
        balance -= amount;
    }

    public void addInvestment(String source, double amount) {
        investmentSources.add(source + ": $" + amount);
        investmentTotal += amount;
        balance += amount;
    }

    
    public void removeSource(ArrayList<String> list, int index) {
        String entry = list.get(index);
        String[] parts = entry.split(": \\$");
        double amount = Double.parseDouble(parts[1]);
        if (list == expenseSources) {
            balance += amount;  // Undo the expense subtraction
        } else {
            balance -= amount;  // Undo the income or investment addition
        }
        list.remove(index);
    }
    
    
   

    public ArrayList<String> getIncomeSources() {
        return incomeSources;
    }

    public ArrayList<String> getExpenseSources() {
        return expenseSources;
    }

    public ArrayList<String> getInvestmentSources() {
        return investmentSources;
    }

   
    
    public double getBalance() {
        return balance;
    }
    
    public double getIncome() {
        return incomeTotal;
    }
    public double getExpense() {
        return expenseTotal;
    }
    public double getInvestments() {
        return investmentTotal;
    }
 
    
   

 

    
    

}
