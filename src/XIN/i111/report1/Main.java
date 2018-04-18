package XIN.i111.report1;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] value;
        int[][] data = {
                //data from teacher
                {103, 97, 106, 104, 107, 101, 100, 106, 103, 99, 102, 111},
                {92, 95, 97, 99, 99, 100, 103, 106, 110, 112, 118, 121},
                //just for test
                {1, 1, 5, 4, 3, 8, 10, 12},
                {900, 9, 99, 199, 299, 30, 50, 20, 1, 6, 9},
                {0, 0, 1, 1, 5, 4, 3, 6, 5, 43, 7, 5, 3, 9, 3, 0, 3},
                {-1, -5, -8, -7, -3, -6, -9, -1, -1, -5, -9, 0}
        };

        value = theGoodAlg(data);
        for (int element : value) {
            System.out.println("good alg: " + element);
        }
        System.out.println();

        value = maybeBadAlg(data);
        for (int element : value) {
            System.out.println("bad alg: " + element);
        }

    }

    private static int[] theGoodAlg(int[][] d) {
        int month, value, maxOut;
        int in, out, temValue;
        int[] v = new int[d.length];
        for (int year = 0; year < d.length; year++) {
            value = 0;
            maxOut = d[year][0];

            for (month = 1; month < d[year].length; month++) {
                in = d[year][month - 1];
                out = d[year][month];

                if (in >= out) {
                    temValue = out - maxOut;
                    if (temValue < value) {
                        value = temValue;
                    }
                } else if (out > maxOut) {
                    maxOut = out;
                }

            }
            v[year] = value;
        }
        return v;
    }

    private static int[] maybeBadAlg(int[][] d) {

        int[] v = new int[d.length];
        for (int year = 0; year < d.length; year++) {

            int temIn, temOut, in, out, temValue, value,minOut;
            temIn = d[year][0];
            temOut = d[year][1];
            value = temOut - temIn;
            temValue = value;

            for (in = 0; in < d[year].length - 1; in++) {
                temIn = d[year][in];
                minOut = d[year][in + 1];
                for (out = in + 1; out < d[year].length; out++) {
                    temOut = d[year][out];
                    if (minOut >= temOut) {
                        minOut = temOut;
                        temValue = minOut - temIn;
                        //System.out.println("min out :" + minOut + " and  tem value: " + temValue);
                    }
                }
                if (temValue < value) {
                    value = temValue;
                }

            }
            v[year] = value;
        }
        return v;
    }
}

