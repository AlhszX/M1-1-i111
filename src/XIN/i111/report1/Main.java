package XIN.i111.report1;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[][] data = {
                {103, 97, 106, 104, 107, 101, 100, 106, 103, 99, 102, 111},
                {92, 95, 97, 99, 99, 100, 103, 106, 110, 112, 118, 121}
        };

        int month, value, min;
        int in, out, temValue;

        for (int year = 0; year < data.length; year++) {
            value = 0;
            min = data[year][0];

            for (month = 1; month < data[year].length; month++) {
                in = data[year][month - 1];
                out = data[year][month];

                if (in >= out) {
                    temValue = out - min;
                    if (temValue < value) {
                        value = temValue;
                    }
                } else if (out > min) {
                    min = out;
                }

            }

            System.out.println(value);
        }
    }

}
