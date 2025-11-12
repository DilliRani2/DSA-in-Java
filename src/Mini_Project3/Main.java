package Mini_Project3;

import java.util.*;

// -------------------- Expense Class --------------------
class Expense {
    private int expenseId;
    private double amount;
    private String category;
    private String description;

    public Expense(int expenseId, double amount, String category, String description) {
        this.expenseId = expenseId;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public int getExpenseId() { return expenseId; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }

    public void setAmount(double amount) { this.amount = amount; }
    public void setCategory(String category) { this.category = category; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Expense ID: " + expenseId +
                ", Amount: " + amount +
                ", Category: " + category +
                ", Description: " + description;
    }
}

// -------------------- ExpenseManager Class --------------------
class ExpenseManager {
    private ArrayList<Expense> expenses;
    private int nextId;

    public ExpenseManager() {
        expenses = new ArrayList<>();
        nextId = 1;
    }

    public void addExpense(double amount, String category, String description) {
        Expense expense = new Expense(nextId++, amount, category, description);
        expenses.add(expense);
        System.out.println("Expense added successfully!\n");
    }

    public void deleteExpense(int expenseId) {
        boolean found = false;
        for (Expense e : expenses) {
            if (e.getExpenseId() == expenseId) {
                expenses.remove(e);
                System.out.println("Expense deleted successfully!\n");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Expense ID not found.\n");
        }
    }

    public void viewAllExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.\n");
        } else {
            for (Expense e : expenses) {
                System.out.println(e);
            }
            System.out.println();
        }
    }

    public void searchByCategory(String category) {
        boolean found = false;
        for (Expense e : expenses) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expenses found for this category.\n");
        } else {
            System.out.println();
        }
    }

    public double getTotalExpense() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }
}

// -------------------- Main Class --------------------
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();
        int choice = 0;

        do {
            System.out.println("====== Expense Tracker Menu ======");
            System.out.println("1. Add Expense");
            System.out.println("2. Delete Expense");
            System.out.println("3. View All Expenses");
            System.out.println("4. Search by Category");
            System.out.println("5. View Total Expense");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter category: ");
                        String category = sc.nextLine();
                        System.out.print("Enter description: ");
                        String desc = sc.nextLine();
                        manager.addExpense(amount, category, desc);
                        break;

                    case 2:
                        System.out.print("Enter Expense ID to delete: ");
                        int id = sc.nextInt();
                        manager.deleteExpense(id);
                        break;

                    case 3:
                        manager.viewAllExpenses();
                        break;

                    case 4:
                        System.out.print("Enter category to search: ");
                        String cat = sc.nextLine();
                        manager.searchByCategory(cat);
                        break;

                    case 5:
                        System.out.println("Total Expense: " + manager.getTotalExpense() + "\n");
                        break;

                    case 6:
                        System.out.println("Exiting... Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter correct data.\n");
                sc.nextLine(); // clear invalid input
            }

        } while (choice != 6);

        sc.close();
    }
}
