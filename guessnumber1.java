import java.util.Random;
import java.util.Scanner;

public class guessnumber1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I will generate a number between 1 and 100. Try to guess it!");

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1; 
            int guess;
            int attempts = 0;
            int maxAttempts = 10;
            boolean roundWon = false;

            System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else if (guess > randomNumber) {
                    System.out.println("Your guess is too high. Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                    totalScore += maxAttempts - attempts + 1; 
                    roundWon = true;
                    break;
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber + ".");
                } else {
                    System.out.println("You have " + (maxAttempts - attempts) + " attempts remaining.");
                }
            }

            roundsPlayed++;

            if (roundWon) {
                System.out.println("Round won!");
            } else {
                System.out.println("Round lost.");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine(); 
            String response = scanner.nextLine();

            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game over! You played " + roundsPlayed + " rounds with a total score of " + totalScore + ".");
        scanner.close();
    }
}
