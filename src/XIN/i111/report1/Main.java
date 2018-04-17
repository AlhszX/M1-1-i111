package XIN.i111.report1;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[][] data = {
                {103, 97, 106, 104, 107, 101, 100, 106, 103, 99, 102, 111},
                {92, 95, 97, 99, 99, 100, 103, 106, 110, 112, 118, 121},
                //just for test
                {1, 1, 5, 4, 3, 8, 10, 12},
                {100, 9, 99, 199, 299, 30, 50, 20, 1, 6, 9},
                {0, 0, 1, 1, 5, 4, 3, 6, 5, 43, 7, 5, 3, 9, 3, 0, 3}
        };

        int[] value;
        value = theGoodAlg(data);

        for (int element : value) {
            System.out.println("good alg: " + element);
        }

        value = mybeBadAlg(data);
        for (int elemenbt : value) {
            System.out.println("bad alg+ " + elemenbt);
        }

    }

    static int[] theGoodAlg(int[][] d) {
        int month, value, min;
        int in, out, temValue;
        int[] v = new int[d.length];
        for (int year = 0; year < d.length; year++) {
            value = 0;
            min = d[year][0];

            for (month = 1; month < d[year].length; month++) {
                in = d[year][month - 1];
                out = d[year][month];

                if (in >= out) {
                    temValue = out - min;
                    if (temValue < value) {
                        value = temValue;
                    }
                } else if (out > min) {
                    min = out;
                }

            }
            v[year] = value;
        }
        return v;

    }

    static int[] mybeBadAlg(int[][] d) {

        int[] v = new int[d.length];
        for (int year = 0; year < d.length; year++) {

            int temIn, temOut, in, out, temValue, value;
            temIn = d[year][0];
            temOut = d[year][1];
            value = temOut - temIn;
            int minOut;
            temValue = value;

            //System.out.println();
            //System.out.println("data length :" + d[year].length);

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
            //System.out.println(value);
            v[year] = value;
        }
        return v;
    }
}

