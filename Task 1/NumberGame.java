// TASK 1 : NUMBER GAME 

// 1. Generate a random number within a specified range, such as 1 to 100.
// 2. Prompt the user to enter their guess for the generated number.
// 3. Compare the user's guess with the generated number and provide feedback on whether the guess is correct, too high, or too low.
// 4. Repeat steps 2 and 3 until the user guesses the correct number. You can incorporate additional details as follows:
// 5. Limit the number of attempts the user has to guess the number.
// 6. Add the option for multiple rounds, allowing the user to play again.
// 7. Display the user's score, which can be based on the number of attempts taken or rounds won.



import java.util.*;

class Range {
    public int generate(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range range = new Range();
        int totalAttempts = 0;
        int wins = 0;

        while (true) {
            System.out.print("Enter minimum number: ");
            int min = scanner.nextInt();
            System.out.print("Enter maximum number: ");
            int max = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            int targetNumber = range.generate(max, min);
            int attempts = 0;

            while (true) {
                System.out.print("Guess a number between " + min + " and " + max + ": ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess > targetNumber) {
                    System.out.println("It's Greater..");
                } else if (guess < targetNumber) {
                    System.out.println("It's Lower..");
                } else {
                    System.out.println("Correct guess!..");
                    wins++;
                    break;
                }
            }

            totalAttempts += attempts;
            System.out.println("Attempts = " + attempts);
            System.out.println("Wins = " + wins);

            double winRate = (double) wins / totalAttempts * 100;
            System.out.printf("Your win rate is %.2f%%\n", winRate);
            System.out.print("Do you want to play again (y / n)? ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("y")) {
                scanner.close();
                System.exit(0);
            }
            scanner.nextLine(); // Consume the newline character
        }
    }
}
