import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Lalit Saini (lalitsaini85)
 * Date: 11/30/2022
 * Time: 9:09 PM
 * File Name : RSASignature.java
 */
public class RSASignature {
    static int dec = 0;
    static int ekey = 0;
    static BigInteger enc;

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

        n = p * q;
        System.out.println("Enter message: ");
        int msg = sc.nextInt();
        while (msg > n) {
            System.out.println("Enter correct message: ");
            msg = sc.nextInt();
        }
        z = (p - 1) * (q - 1); // fi(n);
        System.out.println("the value of z(fi(n)) = " + z);

        encryption(z, d, msg, n);
        decryption(enc, dec, n);
        BigInteger sig = BigInteger.valueOf(msg).pow(dec).mod(BigInteger.valueOf(n));
        BigInteger sig1 = sig.pow(ekey).mod(BigInteger.valueOf(n));
        System.out.println("Signature:" + sig);
        System.out.println("Signature Inverse:" + sig1);
        if (msg == sig1.intValue()) {
            System.out.println("Verified");
        }

    }

    public static void encryption(int z, int d, int msg, int n) {
        int i, e;
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
        ekey = en;
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
        BigInteger emg = BigInteger.valueOf(msg).pow(en).mod(BigInteger.valueOf(n));
        //System.out.println("ec: " + emg);

        enc = emg;
        System.out.println("Encrypted message is : " + emg);
    }

    public static void decryption(BigInteger en, double c, int n) {

//        // converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(n).toBigInteger();
        BigInteger msgback = (en.pow(dec)).mod(C);
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
