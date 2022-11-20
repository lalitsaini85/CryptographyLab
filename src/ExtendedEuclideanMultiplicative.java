import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Lalit Saini (lalitsaini85)
 * Date: 11/12/2022
 * Time: 10:10 PM
 * File Name : ExtendedEuclideanMultiplicative.java
 */
public class ExtendedEuclideanMultiplicative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input value of a=");
        int a = sc.nextInt();
        System.out.print("Input value of b=");
        int b = sc.nextInt();
        int r1 = a;
        int r2 = b;
        int r = 0;
        int q = 0;
        int t1 = 0;
        int t2 = 1;
        int t = 0;
        while (r2 > 0) {
            q = r1 / r2;
            r = r1 - (q * r2);
            t = t1 - (q * t2);
            System.out.print("q=" + q + "  r1=" + r1 + "  r2=" + r2 + "  r=" + r + "  t1=" + t1 + "  t2=" + t2 + "  t=" + t);
            System.out.println();
            t1 = t2;
            t2 = t;
            r1 = r2;
            r2 = r;
        }
        System.out.print("     r1=" + r1 + "  r2=" + r2 + "        t1=" + t1 + "  t2=" + t2);
        System.out.println();
        if (r1 == 1)
            System.out.println("inverse of: " + a + " = " + t1);
        else
            System.out.println("Inverse does not exist");

    }

}
