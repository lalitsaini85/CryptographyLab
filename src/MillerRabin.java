import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Lalit Saini (lalitsaini85)
 * Date: 11/9/2022
 * Time: 10:08 PM
 * File Name : MillerRabin.java
 */
public class MillerRabin {
    public static void main(String[] args) {
        //System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = sc.nextInt();
        while (n % 2 == 0) {
            System.out.println("Enter odd value of n: ");
            n = sc.nextInt();
        }
        System.out.println("Enter base value: ");
        int a = sc.nextInt();
        System.out.println(miller(n, a));
    }

    public static String miller(int n, int a) {
        int arr[] = convert(n - 1);
        int m = arr[1];
        int k = arr[0];
        System.out.println("m: " + m + ",k: " + k);
        int t = (int) (Math.pow(a, m) % (n));
        //System.out.println("t: " + t);
        if (t == 1 || t == -1) {
            return "Prime";
        }
        for (int i = 0; i < k; i++) {
            t = (int) (Math.pow(t, 2) % n);
            System.out.println("t: " + t);
            if (t == 1) {
                return " composite";
            }
            if (t == n - 1) {
                return "Prime";
            }
        }
        return "composite";

    }

    public static int[] convert(int n) {
        int[] arr = new int[2];
        for (int i = 1; i < 1024; i++) {
            int odd = (int) (n / Math.pow(2, i));
            System.out.println("Odd: " + odd);
            if (odd * Math.pow(2, i) == n && odd % 2 != 0) {
                arr[0] = i;
                arr[1] = odd;
                return arr;
            }
        }
        return arr;
    }
}
