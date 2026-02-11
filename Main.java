import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int guess = 0;
        int attempts = 0;
        int min = 0;
        int max = 1;
        String difficulty;
        String playAgain;
        boolean inProgram = true;
        int randomNumber = random.nextInt(0, 11);

        System.out.println("Welcome to number guessing game!");
        System.out.print("What difficulty do you choose? (Easy, medium, Hard, Custom): ");

        while(inProgram){

            difficulty = scanner.nextLine().toLowerCase();

            switch(difficulty){
                case "easy" -> {
                    randomNumber = random.nextInt(0, 11);
                    System.out.println("You chose the Easy difficulty.");
                    System.out.println("Guess a number between 1 and 10.");
                }
                case "medium" -> {
                    randomNumber = random.nextInt(0, 31);
                    System.out.println("You chose the Medium difficulty.");
                    System.out.println("Guess a number between 1 and 30.");
                }
                case "hard" -> {
                    randomNumber = random.nextInt(0, 101);
                    System.out.println("You chose the Hard difficulty.");
                    System.out.println("Guess a number between 1 and 100.");
                }
                case "custom" -> {
                    System.out.print("Choose your max number: ");
                    max = scanner.nextInt();
                    randomNumber = random.nextInt(min, max + 1);
                    System.out.printf("Guess a number between %d and %d.\n", min, max);
                }
                default -> {
                    System.out.print("Keep playing? ");
                    playAgain = scanner.nextLine().toLowerCase();
                    if(!playAgain.equals("yes")){
                        System.out.println("User chose to quit. Closing program...");
                        inProgram = false;
                        break;
                    }
                    System.out.print("What difficulty do you choose? (Easy, medium, Hard, Custom): ");
                }
            }

            while(guess != randomNumber){
                System.out.print("Enter a guess: ");
                guess = scanner.nextInt();

                if(guess > randomNumber){
                    System.out.println("Lower!");
                    attempts++;
                } else if(guess < randomNumber){
                    System.out.println("Higher!");
                    attempts++;
                } else{
                    System.out.println("You guessed the number! (" + randomNumber + ") at " + (attempts + 1) + " attempts!");
                    attempts = 0;
                }
            }

        }
        scanner.close();
    }

}
