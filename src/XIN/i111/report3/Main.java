package XIN.i111.report3;

public class Main {

    public static void main(String[] args) {

        //締め切り5.2
        //n個のデータ　s[0]-s[n-1]
        //数値範囲　０－１００
        //ある数字を探す　二分探索やhash法も使えるか
        //ある方法：
        //a[0]-a[100]　０に初期化して
        //for(int i = 10; i < n; i++) {a[s[i]]++;}->前処理
        //aはsの中にある数値の数
        //この方法メリットデメリットは何

        System.out.println("i111 report 3");

        int dataMax = 100;
        int dataSize = 300;

        int[] s = new int[dataSize];
        int[] a = new int[dataMax];

        System.out.println("data :");
        for (int i = 0; i < s.length; i++) {
            s[i] = (int) (Math.random() * dataMax);
            System.out.printf("%d ", s[i]);
        }
        System.out.println();

        System.out.println("use the new way :");
        newFindReady(a, s);
        for (int element : a) {
            System.out.printf("%d ", element);
        }
        System.out.println();

        for (int i = 0; i < 5; i++) {
            int want = (int) (Math.random() * dataMax);
            if (newFind(want, a)) {
                System.out.println(want + " is existed");
            } else {
                System.out.println(want + " is not existed");
            }
        }
        //try to use hash
        int[] sHash = setHashSequence((int) (s.length / 0.8), s);
        System.out.println("hash table:");
        for (int element : sHash) {
            System.out.printf("%d ", element);
        }

        System.out.println();
        for (int i = 0; i < 5; i++) {
            int want = (int) (Math.random() * 100);
            System.out.println("want : " + want);
            if (hashFind(sHash, want)) {
                System.out.println("get " + want);
            } else {
                System.out.println(want + " not found");
            }
        }
    }

    private static boolean newFind(int want, int[] a) {
        System.out.println("a " + want + " : " + a[want]);
        return a[want] != 0;
    }

    private static void newFindReady(int[] a, int[] s) {
        for (int score : s) {
            a[score]++;
        }
    }

    private static int[] setHashSequence(int hashParameter, int[] ascendingSequence) {
        int[] hashSeq = new int[hashParameter];
        int hashPlace;
        int count = 0;
        for (int element : ascendingSequence) {
            hashPlace = element % hashParameter;
            while (hashSeq[hashPlace] != 0) {
                hashPlace = (hashPlace + 1) % hashParameter;
                count++;
            }
            hashSeq[hashPlace] = element;
        }
        System.out.println("when hash parameter is : " + hashParameter + ", data size is : " + ascendingSequence.length + ", not zero check :" + count + " times");
        return hashSeq;
    }

    private static boolean hashFind(int[] hashTable, int wantNum) {
        int i = wantNum % hashTable.length;
        int find = 0;
        while (hashTable[i] != 0) {
            find++;
            if (hashTable[i] == wantNum) {
                System.out.println("do " + find + "times");
                return true;
            }
            i = (i + 1) % hashTable.length;
        }
        System.out.println("do " + find + "times");
        return false;
    }
}
