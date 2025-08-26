import java.util.Random;
import java.util.Scanner;
public class Rock{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random random =new Random();
        String[] choice= {"rock","paper","scissor"};
        String playerChoice;
        String computerChoice;
        String playAgain = "yes";
        System.out.println("Lets play a Rock ,Paper,Scissor Game!");
        System.out.print("Enter a choice(rock/paper/scissor):");
        playerChoice=sc.nextLine().toLowerCase();
        computerChoice= choice[random.nextInt(3)];
        System.out.print("Computer Choice:"+ computerChoice);
        do{
            if(!playerChoice.equals("rock")&&playerChoice.equals("paper")&&playerChoice.equals("scissor")){
            System.out.println("Invalid Choice");
            continue;
        }
        if(playerChoice.equals(computerChoice)){
            System.out.println("It's a tie");
        }
        else if ((playerChoice.equals("rock")&&computerChoice.equals("scissor"))||
        (playerChoice.equals("scissor")&&computerChoice.equals("paper"))||(playerChoice.equals("paper")&&computerChoice.equals("rock"))){
            System.err.println("You Win!");
        }
        else{
            System.out.println("Computer wins!");
        }
        System.out.print("Are you willing to play Again:");
        playAgain=sc.nextLine().toLowerCase();

        }while(playAgain.equals("yes"));
        System.out.println("Thanks for Playing!");
        sc.close();
    }
}