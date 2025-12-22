import java.util.Scanner;

public class Exp6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");

        int x = sc.nextInt();

        if(x%2 == 0){
            System.out.println("the given number is even: " + x);
        }
        else{
            System.out.println("given number is odd: " + x);
        }

        sc.close();
    }
}
