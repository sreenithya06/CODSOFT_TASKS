import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRoundsWon = 0;
        char playAgain;

        System.out.println("**************************************");
        System.out.println("          CODSOFT NUMBER GAME");
        System.out.println("**************************************");

        do {
            int secretNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");
            System.out.println("--------------------------------------");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess == secretNumber) {
                    guessedCorrectly = true;
                    totalRoundsWon++;

                    int score = (maxAttempts - attempts + 1) * 10;

                    System.out.println("\n Congratulations!");
                    System.out.println("You guessed the correct number!");
                    System.out.println("Number: " + secretNumber);
                    System.out.println("Attempts used: " + attempts);
                    System.out.println("Score: " + score);

                    break;

                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");

                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("\n You have used all your attempts.");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.println("--------------------------------------");
            System.out.println("Rounds won: " + totalRoundsWon);

            System.out.print("Do you want to play another round? (Y/N): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n************************************");
        System.out.println("        THANK YOU FOR PLAYING!");
        System.out.println("        Total rounds won: " + totalRoundsWon);
        System.out.println("*************************************");

        scanner.close();
    }
}