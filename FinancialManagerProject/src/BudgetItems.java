
import java.util.ArrayList;

public class BudgetItems {
   
    private ArrayList<String> budgetList = new ArrayList<>();

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
    public ArrayList<String> getBudgetSources() {
        return budgetList;
    }

   
    
    
   

 

    
    

}
