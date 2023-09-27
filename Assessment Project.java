
package final_project_budget;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class BudgetTrackerApplication {

	private int ids;
    private   String dates;
    private String categories;
    private double prices;
    private String descriptions;

    public BudgetTrackerApplication(int id, String date, String category, double price, String description) {
        this.ids = id;
        this.dates = date;
        this.categories = category;
        this.prices = price;
        this.descriptions = description;
    }

    public static void displayDateWiseLog(
            int[] ids, String[] dates, String[] categories, double[] prices, String[] descriptions, Scanner scanner) {
            System.out.print("ENTER THE DATE IN DD-MM-YYYY FORMAT FOR WHICH YOU WANT TO DISPLAY THE BUDGETARY LOGS: ");
            String selectedDate = scanner.next();

            System.out.println("+----+-------------+------------------+--------------+------------------+");
            System.out.println("| ID |    DATE     |     CATEGORY     |    AMOUNT    |   DESCRIPTION    |");
            System.out.println("+----+-------------+------------------+--------------+------------------+");

            for (int i = 0; i < ids.length; i++) {
                String[] dateParts = dates[i].split("-");
                if (dateParts.length == 3 && dates[i].equals(selectedDate)) {
                    System.out.printf("| %-2d | %-11s | %-16s | %-12.2f | %-14s |%n", ids[i], dates[i], categories[i], prices[i], descriptions[i]);
                }
            }

            System.out.println("+----+-------------+------------------+--------------+------------------+");
        }

        public static void displayMonthWiseLog(
            int[] ids, String[] dates, String[] categories, double[] prices, String[] descriptions, Scanner scanner) {
            System.out.print("ENTER THE MONTH NUMBER BETWEEN 1 TO 12 FOR WHICH YOU WANT TO DISPLAY THE BUDGETARY LOGS: ");
            int selectedMonth = scanner.nextInt();

            System.out.println("+----+-------------+------------------+--------------+------------------+");
            System.out.println("| ID |    DATE     |     CATEGORY     |    AMOUNT    |   DESCRIPTION    |");
            System.out.println("+----+-------------+------------------+--------------+------------------+");

            for (int i = 0; i < ids.length; i++) {
                String[] dateParts = dates[i].split("-");
                if (dateParts.length == 3) {
                    int month = Integer.parseInt(dateParts[1]);
                    if (month == selectedMonth) {
                        System.out.printf("| %-2d | %-11s | %-16s | %-12.2f | %-14s |%n", ids[i], dates[i], categories[i], prices[i], descriptions[i]);
                    }
                }
            }

            System.out.println("+----+-------------+------------------+--------------+------------------+");
        }

    public static void displayTotalBudget(double[] expenses, double monthlyBudget) {
    	
        double totalBudget = monthlyBudget;
        double totalSpending = 8000;
        for (double expense : expenses) {
            totalSpending += expense;
        }

        double currentBudget = monthlyBudget - totalSpending;

        System.out.println("MONTHLY BUDGET: " + monthlyBudget);
        System.out.println("CURRENT BUDGET: " + currentBudget);
        System.out.println("TOTAL SPENDING: " + totalSpending);
    }



    public static void main(String[] args) {
 
        int[] ids = {1, 2, 3, 4, 5, 6};
        String[] dates = {"27-09-2023", "27-09-2023", "27-08-2023", "27-09-2023", "28-09-2023", "28-08-2023", "27-09-2023"};
        String[] categories = {"Fuels", "Exam fees", "food", "clothes", "food", "clothes", "electricityBill"};
        double[] prices = {500, 4000, 800, 6000, 500, 700, 4098};
        String[] descriptions = {"Fuels", "Exam fees", "food", "clothes", "food", "clothes", "electricityBill"};

        List<BudgetTrackerApplication> budgetList = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            BudgetTrackerApplication budget = new BudgetTrackerApplication(ids[i], dates[i % dates.length], categories[i % categories.length], prices[i % prices.length], descriptions[i % descriptions.length]);
            budgetList.add(budget);
        }

        Scanner scanner = new Scanner(System.in);
        double monthlyBudget =1000;
        String password = "admin123";

        // Create an array to store expenses for different categories
        double[] expenses = new double[8];
        boolean[] budgetLogsSet = new boolean[8];

        System.out.println("+----+-------------+------------------+--------------+-------+");
        System.out.println("|WELCOME TO BUDGET TRACKER APP|");
        System.out.println("+----+-------------+------------------+--------------+-------+");
        System.out.println("PLEASE LOGIN TO CONTINUE");
        System.out.print("USERNAME: ");
        String username = scanner.nextLine();
        System.out.print("PASSWORD: ");
        String enteredPassword = scanner.nextLine();

        if (!enteredPassword.equals(password)) {
            System.out.println("Incorrect password. Exiting the program.");
            System.exit(0);
        }

        while (true) {
            System.out.println("1. SET MONTHLY BUDGET");
            System.out.println("2. RECORD AN EXPENSE");
            System.out.println("3. BUDGETARY LOGS");
            System.out.println("4. CHANGE PASSWORD");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	if (monthlyBudget > 0) {
                        System.out.print("MONTHLY BUDGET IS ALREADY SET, DO YOU WANT TO UPDATE IT? (Y: YES | N: NO) ");
                        char updateChoice = scanner.next().charAt(0);
                        if (updateChoice == 'Y' || updateChoice == 'y') {
                            System.out.print("ENTER THE MONTHLY BUDGET AMOUNT FOR EVERY MONTH: ");
                            monthlyBudget = scanner.nextDouble();
                            System.out.println("YOUR MONTHLY BUDGET HAS BEEN UPDATED SUCCESSFULLY.");
                        } else {
                            System.out.println("Monthly budget remains unchanged.");
                        }
                    } else {
                        System.out.print("ENTER THE MONTHLY BUDGET AMOUNT FOR EVERY MONTH: ");
                        monthlyBudget = scanner.nextDouble();
                        System.out.println("YOUR MONTHLY BUDGET HAS BEEN SET SUCCESSFULLY.");
                    }
                    break;
                  
                case 2:
                	System.out.println("CHOOSE THE EXPENSE CATEGORY");
                    System.out.println("1. CLOTHES");
                    System.out.println("2. ELECTRICITY BILL");
                    System.out.println("3. EXAM FEES");
                    System.out.println("4. FOOD");
                    System.out.println("5. FUEL");
                    System.out.println("6. HOUSE RENT");
                    System.out.println("7. TRAVELLING");
                    System.out.println("8. OTHER");
                    System.out.print("Enter the expense category (1-8): ");
                    int expenseCategory = scanner.nextInt();

                    System.out.print("ENTER EXPENSE AMOUNT: ");
                    double expenseAmount = scanner.nextDouble();

                    // Record the expense
                    if (expenseCategory >= 1 && expenseCategory <= 8) {
                        expenses[expenseCategory - 1] += expenseAmount;
                        budgetLogsSet[expenseCategory - 1] = true;
                        System.out.println("EXPENSE RECORDED SUCCESSFULLY.");
                    } else {
                        System.out.println("Invalid expense category.");
                    }
                    break;
                case 3:
                	System.out.println("BUDGETARY LOGS OPTIONS:");
                    System.out.println("1. Date-wise Log");
                    System.out.println("2. Month-wise Log");
                    System.out.println("3. Total Budget");
                    System.out.println("4. Delete Budgetary Log");
                    System.out.print("Select the budget log you want to display: ");
                    int logChoice = scanner.nextInt();
                    switch (logChoice) {
                        case 1:
                        	 displayDateWiseLog(ids, dates, categories, prices, descriptions, scanner);
                            break;
                        case 2:
                        	displayMonthWiseLog(ids, dates, categories, prices, descriptions, scanner);
                            break;
                        case 3:
                        	displayTotalBudget(expenses, monthlyBudget);
                            break;
                            
                        case 4:
                            deleteBudgetaryLog(expenses, budgetLogsSet, scanner);
                            break;
                        default:
                            System.out.println("Invalid log choice.");
                            break;
                    }
                    break;
                case 4:
                    System.out.print("ENTER NEW PASSWORD: ");
                    password = scanner.next();
                    System.out.println("Password changed successfully.");
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        }
    }
    
  private static void deleteBudgetaryLog(double[] expenses, boolean[] budgetLogsSet, Scanner scanner) {
        System.out.println("DELETE BUDGETARY LOG");
        System.out.println("Expense Categories:");
        for (int i = 0; i < expenses.length; i++) {
            if (budgetLogsSet[i]) {
                System.out.println((i + 1) + ". " + getCategoryName(i));
            }
        }

        System.out.print("Enter the expense category (ID) to delete: ");
        int deleteCategoryID = scanner.nextInt();

        if (deleteCategoryID >= 1 && deleteCategoryID <= expenses.length && budgetLogsSet[deleteCategoryID - 1]) {
            expenses[deleteCategoryID - 1] = 0; // Reset the expense amount to zero
            budgetLogsSet[deleteCategoryID - 1] = false; // Mark the budget log as deleted
            System.out.println("Budgetary log for " + getCategoryName(deleteCategoryID - 1) + " deleted successfully.");
        } else {
            System.out.println("Invalid category ID or no budgetary log found for the selected category.");
        }
    }


    public static String getCategoryName(int category) {
        String[] categories = {
            "CLOTHES",
            "ELECTRICITY BILL",
            "EXAM FEES",
            "FOOD",
            "FUEL",
            "HOUSE RENT",
            "TRAVELLING",
            "OTHER"
        };
        if (category >= 0 && category < categories.length) {
            return categories[category];
        }
        return "UNKNOWN";
    }
}


    