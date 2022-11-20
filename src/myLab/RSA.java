package myLab;

/**
 * Created by IntelliJ IDEA.
 * User: Lalit Saini (lalitsaini85)
 * Date: 9/23/2022
 * Time: 10:20 AM
 * File Name : RSA.java
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
    static int dec = 0;
    static double enc = 0;

    public static void main(String args[]) {
        int p, q, n, z, d = 0, e, i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter values of P and Q respectively: ");
        p = sc.nextInt();
        q = sc.nextInt();
        while (p == q || !isPrime(p) || !isPrime(q)) {
            System.out.println("Enter correct values of p and q: ");
            p = sc.nextInt();
            q = sc.nextInt();
        }


        // The number to be encrypted and decrypted

        BigInteger msgback;
        n = p * q;
        System.out.println("Enter message: ");
        int msg = sc.nextInt();
        while (msg > n) {
            System.out.println("Enter correct message: ");
            msg = sc.nextInt();
        }
        z = (p - 1) * (q - 1); // fi(n);
        System.out.println("the value of z = " + z);

        encryption(z, d, msg, n);
        decryption(n, dec);

//
    }

    public static void encryption(int z, int d, int msg, int n) {
        int i, e;
        double c;
        Scanner sc = new Scanner(System.in);
        System.out.print("values of e: ");
        for (e = 2; e < z; e++) {

            // e is for public key
            if (gcd(e, z) == 1) {
                System.out.print(e + " ");
                //break;
            }
        }
        System.out.println("Choose the value of e: ");
        int en = sc.nextInt();
        System.out.println("the value of e = " + en);
        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);

            // d is for private key
            if (x % en == 0) {
                d = x / en;
                break;
            }
        }
        dec = d;
        System.out.println("the value of d = " + d);
        c = (Math.pow(msg, en)) % n;
        enc = c;
        System.out.println("Encrypted message is : " + c);
    }

    public static void decryption(int n, double c) {
        // converting int value of n to BigInteger
        BigInteger N = BigInteger.valueOf(n);

//        // converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        BigInteger msgback = (C.pow(dec)).mod(N);
        System.out.println("Decrypted message is : "
                + msgback);
    }

    static int gcd(int e, int z) {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if ((num % i) == 0)
                return false;
        }
        return true;
    }
}
