import java.util.Scanner;
class Calculator{
    public static void main(String args[]){
        //using switchcase calculator
        Scanner scan = new Scanner(System.in);
        char symbol;
        int operator1,operator2;
        System.out.println("Let's try Basic calculations!");
        System.out.print("Enter Operator1 value:");
        operator1=scan.nextInt();
        System.out.print("Enter Operator2 value:");
        operator2=scan.nextInt();
        System.out.print("Enter any Symbol (+,-,*,/,%):");
        symbol = scan.next().charAt(0);

        
            switch(symbol){
                case '+':System.out.print((operator1 + operator2));break;
                case '-':System.out.print((operator1 - operator2));break;
                case '*':System.out.print((operator1 * operator2));break;
                case '/':
                 if (operator2 != 0) {
                    System.out.println((operator1 / operator2));
                } else {
                    System.out.println("Error: Division by zero not allowed.");
                }break;
                case '%':
                    if (operator2 != 0) {
                    System.out.println((operator1 % operator2));
                } else {
                    System.out.println("Error: Modulus by zero not allowed.");
                }break;
                default: System.out.print("Invalid Operator");
            }
        
        
        
    }
}