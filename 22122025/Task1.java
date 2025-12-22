public class Task1 {
    public void printHalfNumber(int n){
        while(n>=2){
            System.out.println(n);
            n = n/2;
        }
    }
    public static void main(String[] args) {
        int input = Integer.parseInt(args[0]);
        Task1 obj = new Task1();
        obj.printHalfNumber(input);
    }
}
