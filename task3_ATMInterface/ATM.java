import java.util.Scanner;

public class ATM {

    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        int choice;

        do {
            System.out.println("\n*************************************");
            System.out.println("              ATM INTERFACE");
            System.out.println("**************************************");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("**************************************");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    depositMoney();
                    break;

                case 3:
                    withdrawMoney();
                    break;

                case 4:
                    System.out.println("\nThank you for using the ATM!");
                    break;

                default:
                    System.out.println("\nInvalid choice! Please select 1-4.");
            }

        } while (choice != 4);
    }

    private void checkBalance() {

        System.out.printf("\nYour current balance is: %.2f\n",
                account.getBalance());
    }

    private void depositMoney() {

        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (account.deposit(amount)) {
            System.out.printf("%.2f deposited successfully!\n", amount);

            System.out.printf("Updated balance: %.2f\n", account.getBalance());

        } else {
            System.out.println("Invalid amount! Deposit must be greater than zero.");
        }
    }

    private void withdrawMoney() {

        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {

            System.out.printf("%.2f withdrawn successfully!\n", amount);

            System.out.printf("Remaining balance: %.2f\n", account.getBalance());

        } else {

            if (amount <= 0) {
                System.out.println("Invalid amount! Withdrawal must be greater than zero.");

            } else {
                System.out.println("Insufficient balance!");
            }
        }
    }
}