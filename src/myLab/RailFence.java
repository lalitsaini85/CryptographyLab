package myLab;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Lalit Saini (lalitsaini85)
 * Date: 11/17/2022
 * Time: 8:36 AM
 * File Name : RailFence.java
 */

public class RailFence {
    public static void main(String args[]) throws Exception {
        RailFenceBasic rf = new RailFenceBasic();
        Scanner scn = new Scanner(System.in);
        int depth;

        String plainText, cipherText, decryptedText;

        System.out.println("Enter plain text:");
        plainText = scn.nextLine();

        System.out.println("Enter depth for Encryption:");
        depth = scn.nextInt();

        cipherText = rf.Encryption(plainText, depth);
        System.out.println("Encrypted text is:\n" + cipherText);

        decryptedText = rf.Decryption(cipherText, depth);

        System.out.println("Decrypted text is:\n" + decryptedText);

    }
}

class RailFenceBasic {
    int depth;

    String Encryption(String text, int key) throws Exception {
        char[][] rail = new char[key][(text.length())];


        for (int i = 0; i < key; i++)
            for (int j = 0; j < text.length(); j++)
                rail[i][j] = '\n';


        boolean dir_down = false;
        int row = 0, col = 0;

        for (int i = 0; i < text.length(); i++) {

            if (row == 0 || row == key - 1)
                dir_down = !dir_down;


            rail[row][col++] = text.charAt(i);


            if (dir_down) row++;
            else row--;
        }


        String result = "";
        String cipher = "";
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < text.length(); j++) {
                if (rail[i][j] != '\n') {
                    result += (rail[i][j]);
                    cipher += (rail[i][j]);
                }
            }
            result += " ";
        }

        System.out.println(result);
        return cipher;
    }


    String Decryption(String cipher, int key) throws Exception {
        char[][] rail = new char[key][(cipher.length())];

        for (int i = 0; i < key; i++)
            for (int j = 0; j < cipher.length(); j++)
                rail[i][j] = '\n';


        boolean dir_down = false;

        int row = 0, col = 0;


        for (int i = 0; i < cipher.length(); i++) {

            if (row == 0)
                dir_down = true;
            if (row == key - 1)
                dir_down = false;


            rail[row][col++] = '*';


            if (dir_down) row++;
            else row--;
        }


        int index = 0;
        for (int i = 0; i < key; i++)
            for (int j = 0; j < cipher.length(); j++)
                if (rail[i][j] == '*' && index < cipher.length())
                    rail[i][j] = cipher.charAt(index++);


        String result = "";

        row = 0;
        col = 0;
        for (int i = 0; i < cipher.length(); i++) {

            if (row == 0)
                dir_down = true;
            if (row == key - 1)
                dir_down = false;


            if (rail[row][col] != '*')
                result += (rail[row][col++]);


            if (dir_down) row++;
            else row--;
        }
        return result;
    }
}


