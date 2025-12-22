public class Exp5 {
    public static void main(String[] args) {
        System.out.println("Even number");
        for (int i = 0; i <= 10; i++) {
            if(i%2==0){
                System.out.println(i);
            }
        }

        System.out.println("Odd number");
        // for (int i = 0; i <= 10; i++) {
        //     if(i%2!=0){
        //         System.out.println(i);
        //     }
        // }
        int n = 0 ;
        while (n<=10) {
            if(n%2!=0){
                System.out.println(n);
            }
            n++;
        }
    }
}
