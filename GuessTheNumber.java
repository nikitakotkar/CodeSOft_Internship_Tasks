import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("-----------------------------------------------------------------");
        System.out.println("\nWelcome to the Guess the Number Game!");
        System.out.println("-----------------------------------------------------------------");

        while (true) {
            
            int lowerBound = 1;
            int upperBound = 100;
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

            int maxAttempts = 10;
            int attempts = 0;

            // Game loop
            while (attempts < maxAttempts) {
                System.out.print("\nGuess the number between " + lowerBound + " and " + upperBound + ": ");

                try {
                   
                    int userGuess = scanner.nextInt();

                    
                    if (userGuess == secretNumber) {
                        System.out.println("\nCongratulations! You guessed the correct number " + secretNumber +
                                " in " + (attempts + 1) + " attempts.");
                        System.out.println("-----------------------------------------------------------------");
                        break;
                    } else if (userGuess < secretNumber) {
                        System.out.println("\nToo low! Try again.");
                        System.out.println("-----------------------------------------------------------------");
                    } else {
                        System.out.println("\nToo high! Try again.");
                        System.out.println("-----------------------------------------------------------------");
                    }

                    attempts++;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("\nInvalid input. Please enter a valid number.");
                    scanner.next(); // consume the invalid input
                }
            }

            // Display result
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + secretNumber + ".");
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Goodbye.");
                break;
            }
        }

        scanner.close();
    }
}
