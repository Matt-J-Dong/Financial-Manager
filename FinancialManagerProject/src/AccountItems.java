
import java.util.ArrayList;

public class AccountItems{
    
    private double checkingTotal = 0.0;
    private double savingTotal = 0.0;
    private double creditTotal = 0.0;

   
    private ArrayList<String> checkingsSources = new ArrayList<>();
    private ArrayList<String> savingsSources = new ArrayList<>();
    private ArrayList<String> creditSources = new ArrayList<>();
    
    

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
        }
        list.remove(index);
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
