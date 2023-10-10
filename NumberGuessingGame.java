import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("\nRound " + (rounds + 1) + ":");
            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange);

            while (true) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score += attempts;
                    break;
                } else if (attempts == attemptsLimit) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + targetNumber + ".");
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else if(userGuess> targetNumber){
                    System.out.println("Too high. Try again.");
                }
            }

            rounds++;

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }

        } while (true);

        System.out.println("Game over!");
        System.out.println("Total rounds played: " + rounds);
        System.out.println("Total score: " + score);

        scanner.close();}
}
