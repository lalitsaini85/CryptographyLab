package myLab;

import java.util.Scanner;

public class HillCipher {
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plain text: ");
        String message = sc.next();
        System.out.println("Enter key:");
        String key = sc.next();
        HillCipher(message, key);
    }

    public static void showMenu() {
        System.out.println("Hill Cipher System:");
        System.out.println("To Encrypt press 1.");
        System.out.println("To Decrypt press 2.");
        System.out.println("To Exit press 3.");

    }

    public static void encryption(int[][] cipherMatrix,
                                  int[][] keyMatrix,
                                  int[][] messageVector) {
        int x, i, j;
        for (i = 0; i < keyMatrix.length; i++) {
            for (j = 0; j < 1; j++) {
                cipherMatrix[i][j] = 0;

                for (x = 0; x < 3; x++) {
                    cipherMatrix[i][j] +=
                            keyMatrix[i][x] * messageVector[x][j];
                }

                cipherMatrix[i][j] = cipherMatrix[i][j] % 26;
            }
        }
    }

    public static void getKeyMatrix(String key, int[][] keyMatrix) {
        int k = 0;
        for (int i = 0; i < keyMatrix.length; i++) {
            for (int j = 0; j < keyMatrix[0].length; j++) {
                keyMatrix[i][j] = (key.charAt(k)) % 65;
                k++;
            }
        }
    }

    public static void getMessageMatrix(String message, int[][] messageVector, int row) {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < row; j++) {
                if (k >= message.length()) {
                    messageVector[i][j] = 25;
                } else {
                    messageVector[i][j] = alphabet.indexOf(message.charAt(k));
                    k++;
                }
            }
        }
    }

    static void HillCipher(String message, String key) {
        int n = key.length() / 3;
        if (key.length() % 3 != 0) {
            n = n + 1;
        } else {
            n = key.length();
        }
        int[][] keyMatrix = new int[n][3];
        getKeyMatrix(key, keyMatrix);

        int col = message.length() / 3;
        if (message.length() % 3 != 0) {
            col = col + 1;
        }

        int[][] messageVector = new int[3][col];
        getMessageMatrix(message, messageVector, col);


//        for (int i = 0; i < keyMatrix.length; i++)
//            messageVector[i][0] = (message.charAt(i)) % 65;

        int[][] cipherMatrix = new int[keyMatrix.length][1];
        encryption(cipherMatrix, keyMatrix, messageVector);

        String CipherText = "";

        for (int i = 0; i < keyMatrix.length; i++)
            CipherText += (char) (cipherMatrix[i][0] + 65);


        System.out.print(" Ciphertext:" + CipherText);
    }
}
