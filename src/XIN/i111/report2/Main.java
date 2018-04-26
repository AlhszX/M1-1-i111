package XIN.i111.report2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //締め切り5.2
        //100までの素数25個からなる昇順配列だデータがある
        //二分探索法で10,33,73を探す
        //「余裕」1000までの素数 適当な三数字を探す
        //データをhash x = x % 30 で格納して
        //add関数の htb[j] != 0 のチェック回数をカウントし，その25回分の合計を求める
        //「余裕」　m=28 or 29 or 50　htb[j] != 0 のチェック回数
        System.out.println();
        System.out.println("i111 report 2");
        System.out.println();

        int[] maxNum = new int[]{100, 1000};
        int[][] wantNumber = new int[][]{
                {10, 33, 73},
                {getRandom(0, 333), getRandom(333, 666), getRandom(666, 1000)}
        };

        //int numOfPrim;
        Integer[][] prim = new Integer[maxNum.length][];
        ArrayList<Integer> primList;

        boolean ifGet;
        boolean[] flag;

        int[] hashBaseParameter = new int[]{30, 29, 28, 50};
        int[][] hashParameter = new int[maxNum.length][hashBaseParameter.length];
        int[] hashS;

        for (int sequenceNum = 0; sequenceNum < maxNum.length; sequenceNum++) {

            primList = new ArrayList<>();

            flag = sieveOfEratosthenes(maxNum[sequenceNum]);

            System.out.println("prime table is :");
            for (int number = 0; number < flag.length; number++) {
                if (flag[number]) {
                    primList.add(number);
                    System.out.printf("%d ", number);
                }
            }
            prim[sequenceNum] = primList.toArray(new Integer[0]);
            System.out.println();
            System.out.println();
            System.out.println("before " + maxNum[sequenceNum] + " all prim number :" + prim[sequenceNum].length);

            for (int wantN = 0; wantN < wantNumber[sequenceNum].length; wantN++) {
                ifGet = bisectionMethod(prim[sequenceNum], wantNumber[sequenceNum][wantN]);
                if (!ifGet) {
                    System.out.println("No " + wantNumber[sequenceNum][wantN]);
                }
            }

            for (int parameterNum = 0; parameterNum < hashBaseParameter.length; parameterNum++) {

                hashParameter[sequenceNum][parameterNum] = (int) (prim[sequenceNum].length / (25.0 / hashBaseParameter[parameterNum]));

                System.out.println();
                System.out.println();
                hashS = setHashSequence(hashParameter[sequenceNum][parameterNum], prim[sequenceNum]);

                System.out.println("hash table is :");
                for (int element : hashS) {
                    System.out.printf("%d ", element);
                }
            }
            System.out.println();
            System.out.println();
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

    //ランダムで1素数の中にさがしたい数字を生成する
    private static int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    //二分法
    private static boolean bisectionMethod(Integer[] ascendingSequence, int wantNum) {

        int high = ascendingSequence.length;
        int low = 0;
        int middle;
        int k = 0;

        System.out.println("search " + wantNum);
        //while (high >= low) {
        do {
            middle = (high + low) / 2;
            //System.out.println();
            //System.out.println("LOW:" + low + " High:" + high);
            //System.out.println("Middle:" + middle + "  " + ascendingSequence[middle]);
            k++;
            if (wantNum > ascendingSequence[middle]) {
                low = middle + 1;
            } else if (wantNum < ascendingSequence[middle]) {
                high = middle - 1;
            } else {
                System.out.printf("the number %d is Sequence[%d],  %d times get", wantNum, middle, k);
                System.out.println();
                return true;
            }
        } while (high >= low);

        return false;
    }

    //hashテーブルを作る
    private static int[] setHashSequence(int hashParameter, Integer[] ascendingSequence) {
        int[] hashSeq = new int[hashParameter];//配列の初期化不要　Java int sequence default is 0
        int hashPlace;
        int count = 0;
        //ppt code のadd関数(方法..?)と同じ
        for (int element : ascendingSequence) {
            //ppt code のhash関数(方法..?)と同じ
            hashPlace = element % hashParameter;
            //ppt codeのfind関数(方法..?)と同じ
            while (hashSeq[hashPlace] != 0) {
                hashPlace = (hashPlace + 1) % hashParameter;
                count++;
            }
            hashSeq[hashPlace] = element;
        }
        System.out.println("when hash parameter is : " + hashParameter + ", data size is : " + ascendingSequence.length + ", not zero check :" + count + " times");
        return hashSeq;
    }

    //

    //hash search? search from hash sequence..?
    //ニーズから見ると…多分いらない…？
    /*private static boolean hashSearch() {

        return false;
    }
    */
}
