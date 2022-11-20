import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Lalit Saini (lalitsaini85)
 * Date: 11/10/2022
 * Time: 8:20 AM
 * File Name : DiffieHellman.java
 */
public class DiffieHellman {
    static ArrayList<Integer> primitiveRootList = new ArrayList<>();

    public static void main(String[] args) {
        int q, Pr, a, b;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of q: ");
        q = sc.nextInt();
        while (!isPrime(q)) {
            System.out.println("Enter Prime value of q: ");
            q = sc.nextInt();
        }
        primtiveRootTable(q);
        System.out.println("Enter value for alpha from above list:");
        Pr = sc.nextInt();
        while (!primitiveRootList.contains(Pr)) {
            System.out.println("Choose correct value of alpha from list:");
            Pr = sc.nextInt();

        }
        System.out.println("Enter value for private key Xa selected by user1:");
        a = sc.nextInt();
        while (a >= q) {
            System.out.println("Enter correct value for private key Xa selected by user1:");
            a = sc.nextInt();
        }
        System.out.println("Enter value for private key Xb selected by user2:");
        b = sc.nextInt();
        while (b >= q) {
            System.out.println("Enter correct value for private key Xb selected by user1:");
            b = sc.nextInt();
        }
        BigInteger x = calculatePower(Pr, a, q);
        System.out.println("x: " + x);
        BigInteger y = calculatePower(Pr, b, q);
        System.out.println("y: " + y);
        BigInteger ka = calculatePower(y.intValue(), a, q);
        BigInteger kb = calculatePower(x.intValue(), b, q);
        System.out.println("Secret key for User1 is:" + ka);
        System.out.println("Secret key for User2 is:" + kb);
    }

    static int power(int x, int y, int p) {
        int res = 1;

        x = x % p;
        if (x == 0)
            return 0;

        while (y > 0) {
            if ((y & 1) != 0)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    static boolean isPrime(long n) {

        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    static void primtiveRootTable(int n) {
        int phi = n - 1;
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int calc = power(i, j, n);
                matrix[i][j] = calc;
            }
        }
        HashMap<Integer, Integer> orderOfElement = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i][j] == 1) {
                    orderOfElement.put(i, j);
                    break;
                }
            }
        }
        for (Integer ele : orderOfElement.keySet()) {

            if (orderOfElement.get(ele) == phi) {
                primitiveRootList.add(ele);
            }
        }
        System.out.println(primitiveRootList);
    }

    private static BigInteger calculatePower(long c, long b, long p) {
        BigInteger answer = BigInteger.valueOf(c).pow((int) b);
        BigInteger nn = BigInteger.valueOf(p);
        BigInteger ans = answer.mod(nn);
        return ans;
    }
}
