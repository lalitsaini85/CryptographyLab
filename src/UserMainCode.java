/**
 * Created by IntelliJ IDEA.
 * User: Lalit Saini (lalitsaini85)
 * Date: 9/22/2022
 * Time: 6:08 PM
 * File Name : UserMainCode.java
 */
class userMainCode {
    public static int findKey(int input1, int input2, int input3) {
        //read only
        // write code
        int u = 0, t = 0, h = 0, th = 0;
        int length = 4;
        while (length != 0) {
            if (length == 4) {
                u = maxOfThree(input1 % 10, input2 % 10, input3 % 10) - minOfThree(input1 % 10, input2 % 10, input3 % 10);
            }
            if (length == 3) {
                t = maxOfThree(input1 % 10, input2 % 10, input3 % 10) - minOfThree(input1 % 10, input2 % 10, input3 % 10);
            }
            if (length == 2) {
                h = maxOfThree(input1 % 10, input2 % 10, input3 % 10) - minOfThree(input1 % 10, input2 % 10, input3 % 10);
            }
            if (length == 1) {
                th = maxOfThree(input1 % 10, input2 % 10, input3 % 10) - minOfThree(input1 % 10, input2 % 10, input3 % 10);
            }
            input1 /= 10;
            input2 /= 10;
            input3 /= 10;
            length--;
        }
        return (th * 1000 + h * 100 + t * 10 + u);
    }


    static int maxOfThree(int x, int y, int z) {
        return z > (x > y ? x : y) ? z : ((x > y) ? x : y);
    }

    static int minOfThree(int a, int b, int c) {
        return (a < b) ? (a < c ? a : c) : (b < c ? b : c);
    }

    public static void main(String[] args) {
        int i1 = 3521;
        int i2 = 2452;
        int i3 = 1352;
        System.out.println(findKey(i1, i2, i3));

    }

}
