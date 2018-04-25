package XIN.i111.report2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //締め切り5.2
        //100までの素数25個からなる昇順配列だデータがある
        //二分探索法で10,33,73を探す
        //「余裕」1000までの素数

        System.out.println("i111 report 2");
        int MAXNUM1 = 100;
        int MAXNUM2 = 1000;

        boolean[] flag = sieveOfEratosthenes(MAXNUM2);
        int numOfPrim = 0;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                System.out.printf("%d ", i);
                numOfPrim++;
            }
        }
        System.out.println();
        System.out.println(numOfPrim);

        int[] prim = new int[numOfPrim];
        int n = 0;

        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                prim[n] = i;
                n++;
            }
        }

        int wantNum = 6;
        boolean ifGet;

        ifGet = bisectionMethod(prim, wantNum);

        if (!ifGet) {
            System.out.println("No " + wantNum);
        }

    }

    //sieve of Eratosthenes get prim number
    private static boolean[] sieveOfEratosthenes(int maxNum) {
        boolean[] flag = new boolean[maxNum];
        Arrays.fill(flag, true);

        flag[0] = false;
        flag[1] = false;

        int number, multiple;

        for (number = 2; number < maxNum; number++) {
            if (flag[number]) {
                for (multiple = 2 * number; multiple < maxNum; multiple += number) {
                    flag[multiple] = false;
                }
            }
        }
        return flag;
    }

    private static boolean bisectionMethod(int[] ascendingSequence, int wantNum) {

        int high = ascendingSequence.length;
        int low = 0;
        int middle;
        int k = 0;

        while (high >= low) {
            middle = (high + low) / 2;
            //System.out.println();
            //System.out.println("LOW:" + low + " High:" + high);
            //System.out.println("Middle:"+middle + "  " + ascendingSequence[middle]);
            k++;
            if (wantNum > ascendingSequence[middle]) {
                low = middle + 1;
            } else if (wantNum < ascendingSequence[middle]) {
                high = middle - 1;
            } else {
                System.out.printf("the number %d is Sequence[%d],  %d times get", wantNum, middle, k);
                return true;
            }
        }
        return false;
    }

}
