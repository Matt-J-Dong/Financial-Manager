
import java.util.ArrayList;

public class FinancialData {
    private double balance = 0.0;  // Starting balance
    private double incomeTotal = 0.0;
    private double expenseTotal = 0.0;
    private double investmentTotal = 0.0;
    private double checkingTotal = 0.0;
    private double savingTotal = 0.0;
    private double creditTotal = 0.0;
    private ArrayList<String> incomeSources = new ArrayList<>();
    private ArrayList<String> expenseSources = new ArrayList<>();
    private ArrayList<String> investmentSources = new ArrayList<>();
   
    private ArrayList<String> checkingsSources = new ArrayList<>();
    private ArrayList<String> savingsSources = new ArrayList<>();
    private ArrayList<String> creditSources = new ArrayList<>();
    
    private ArrayList<String> budgetList = new ArrayList<>();

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

    public void addCheckings(String source, double amount) {
        checkingsSources.add(source + ": $" + amount);
        checkingTotal += amount;
    }

    public void addSavings(String source, double amount) {
        savingsSources.add(source + ": $" + amount);
        savingTotal += amount;
    }

    public void addCredit(String source, double amount) {
        creditSources.add(source + ": $" + amount);
        creditTotal += amount;
    }
    
    public void removeSource(ArrayList<String> list, int index) {
        String entry = list.get(index);
        String[] parts = entry.split(": \\$");
        double amount = Double.parseDouble(parts[1]);
        if (list == creditSources) {
            creditTotal += amount; 
        }else if (list == savingsSources) {
            savingTotal += amount;  
        } else if (list == checkingsSources) {
            checkingTotal += amount;  
        }else if (list == expenseSources) {
            balance += amount;  // Undo the expense subtraction
        } else {
            balance -= amount;  // Undo the income or investment addition
        }
        list.remove(index);
    }
    
    public void removeBudgetItem(int index) {
    	budgetList.remove(index);
    }
    
    public void addBudgetItem(String itemName, double amount, double goal) {
    	double progress = Math.round(amount/goal * 100.0);
    	budgetList.add(itemName + " |  Total Contribution: "+ amount + " |  Goal: " + goal + " |  Progress: "+progress + "%");
    }
    
    public String contributeItem(double amount, int index) {
    	String entry = budgetList.get(index);
    	String itemName = entry.substring(0, entry.indexOf(" |"));
    	String[] parts = entry.split("\\|");
    	System.out.println(parts.toString());
    	System.out.println(entry);
    	for (String part: parts) {
    		System.out.println(part);
    	}
    	String amountStr = parts[1].trim().split(":")[1].trim();
    	
        String goalStr = parts[2].trim().split(":")[1].trim();

        double amt = Double.parseDouble(amountStr);
        double gl = Double.parseDouble(goalStr);
        double totalAmt = amt+amount;
    	double progress = Math.round(totalAmt/gl * 100.0);

    	budgetList.set(index, itemName + " |  Total Contribution: "+ totalAmt+ " |  Goal: " + gl + " |  Progress: "+progress + "%");
//    	if (progress >= 100) {
//    		String message = itemName + " Category Completed! Great job :)";
//    		new MessageGUI(message);
//    	}
    	return itemName + " |  Total Contribution: "+ totalAmt + " |  Goal: " + gl + " |  Progress: "+progress + "%";
    	
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

    public ArrayList<String> getCheckingsSources() {
        return checkingsSources;
    }

    public ArrayList<String> getSavingsSources() {
        return savingsSources;
    }

    public ArrayList<String> getCreditSources() {
        return creditSources;
    }
    
    
    public ArrayList<String> getBudgetSources() {
        return budgetList;
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
    public double getCheckings() {
        return checkingTotal;
    }
    public double getSavings() {
        return savingTotal;
    }
    public double getCredit() {
        return creditTotal;
    }
    
    public void payCreditBill() {
    	if (checkingTotal > creditTotal) {
    		checkingTotal -= creditTotal;
    		checkingsSources.add("Paid Credit Card Bill: -" + creditTotal);
        	creditSources.add("Bill Paid: -"+ creditTotal);
        	creditTotal = 0;
    	}else {
    		new MessageGUI();
    		return;
    	}
    	
    	
    }
    
   

 

    
    

}
