import java.util.Random;
import java.util.Scanner;
class Game{
    public static void main(String args[]){
        try(Scanner scan = new Scanner(System.in)){
        Random random = new Random();
        int numofdice;
        int totalrolls = 0;
        System.out.println("Welcome to DICE ROLLER GAME!");
        System.out.print("Enter no.of times to roll a dice:");
        numofdice = scan.nextInt();
        if(numofdice > 0){
            for(int i = 0;i < numofdice; i++){
                int roll = random.nextInt(1,7);
                System.out.println("You Rolled:" +roll);
                 Dice(roll);
                totalrolls += roll;
            }
            System.out.println(totalrolls);
        }
            else{
                System.out.println("The roll of dice must be greater than 0");
            }
        
        
       
        
        }
    }
 static void Dice(int roll){
     String Die1="""
                 -------
                |       |
                |   *   |
                |       |
                 -------
     """;
      String Die2="""
                 -------
                |       |
                | *   * |
                |       |
                 -------
     """;
      String Die3="""
                 -------
                | *     |
                |   *   |
                |     * |
                 -------
     """;
     String Die4="""
                 -------
                | *   * |
                |       |
                | *   * |
                 -------
     """;
     String Die5="""
                 -------
                | *   * |
                |   *   |
                | *   * |
                 -------
     """;
     String Die6="""
                 -------
                | *   * |
                | *   * |
                | *   * |
                 -------
     """;
     switch(roll){
     case 1->System.out.print(Die1);
     case 2->System.out.print(Die2);
     case 3->System.out.print(Die3);
     case 4->System.out.print(Die4);
     case 5->System.out.print(Die5);
     case 6->System.out.print(Die6);
     default->System.out.print("Invalid choice");
 }
 }
}