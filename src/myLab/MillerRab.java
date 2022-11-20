package myLab;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Lalit Saini (lalitsaini85)
 * Date: 11/12/2022
 * Time: 9:49 PM
 * File Name : MillerRab.java
 */
public class MillerRab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n=");
        int n = sc.nextInt();
        //System.out.println();
        System.out.print("Enter the base a=");
        double a = sc.nextInt();
        //System.out.println();
        double k = 0, m = 0;
        int temp = n - 1;
        while (temp % 2 == 0) {
            k = k + 1;
            temp = temp / 2;
        }
        m = temp;
        int f = 0;
        System.out.println("k=" + k + "     m=" + m);
        double b = Math.pow(a, m) % n;
        System.out.println("bo: " + b);
        if (b == 1) {
            System.out.println("Prime");
        } else {
            for (int i = 0; i < k; i++) {

                System.out.println("i=" + i);
                b = (b * b) % n;
                System.out.println("b: " + b);
                if (b == n - 1) {
                    System.out.println("N is prime");
                    f = 1;
                    break;
                } else if (b == 1) {
                    System.out.println("N is composite");
                    f = 1;
                    break;
                }

            }
            if (f == 0) {
                System.out.println("N is composite");
            }
        }
    }

}
