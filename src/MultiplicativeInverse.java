import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Lalit Saini (lalitsaini85)
 * Date: 11/30/2022
 * Time: 8:49 PM
 * File Name : MultiplicativeInverse.java
 */
public class MultiplicativeInverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of A:");
        int a = sc.nextInt();
        System.out.println("Enter the value of mode:");
        int mod = sc.nextInt();
        int count = 0;
        // A naive method is to try all numbers from 1 to m. For every number x, check if (A * i) % Mod is 1
        for (int i = 1; i <= mod; i++) {
            if ((a * i) % mod == 1) {
                System.out.println("Inverse:" + i);
                count = 1;
                break;
            }
        }
        if (count == 0) {
            System.out.println("Inverse Not Exists");
        }
    }
}
