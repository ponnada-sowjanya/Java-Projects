import java.util.Random;
import java.util.Scanner;

class RandomNumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        int guess, attempts = 0;
        int randomnumber = random.nextInt(10) + 1; // random between 1–10

        System.out.println("Let's play a Number Guessing Game!");

        do {
            System.out.print("Guess a number between 1-10: ");
            guess = scan.nextInt();
            attempts++;

            if (guess > randomnumber) {
                System.out.println("Your guess is too High! Let's try another one.");
            } else if (guess < randomnumber) {
                System.out.println("Your guess is too Low! Let's try another one.");
            } else {
                System.out.println("Your guess is Correct!");
            }

        } while (guess != randomnumber);

        System.out.println("You won the Game in " + attempts + " attempts.");
    }
}
