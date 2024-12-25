import java.util.Random;
import java.util.Scanner;

public class numbergame {
   public numbergame() {
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Random random = new Random();
      boolean playAgain = true;
      int totalScore = 0;
      int round = 1;
      System.out.println("Welcome to the Number Game!");

      while(playAgain) {
         int numberToGuess = random.nextInt(100) + 1;
         int attempts = 0;
         int maxAttempts = 7;
         boolean guessedCorrectly = false;
         System.out.println("Round " + round + ": Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

         while(attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = sc.nextInt();
            ++attempts;
            if (userGuess == numberToGuess) {
               System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
               guessedCorrectly = true;
               totalScore += maxAttempts - attempts + 1;
               break;
            }

            if (userGuess > numberToGuess) {
               System.out.println("Too high! Try again.");
            } else {
               System.out.println("Too low! Try again.");
            }
         }

         if (!guessedCorrectly) {
            System.out.println("Sorry, you've used all attempts. The correct number was: " + numberToGuess);
         }

         System.out.print("Would you like to play another round? (yes/no): ");
         String response = sc.next();
         playAgain = response.equalsIgnoreCase("yes");
         if (playAgain) {
            ++round;
         }
      }

      System.out.println("Thank you for playing! Your total score is: " + totalScore);
      sc.close();
   }
}
