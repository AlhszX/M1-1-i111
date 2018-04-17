package XIN.i111.report1;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[][] data = {
                {103, 97, 106, 104, 107, 101, 100, 106, 103, 99, 102, 111},
                {92, 95, 97, 99, 100, 101, 103, 106, 110, 112, 118, 121}
        };

        int month, value, min;
        int in, out, temValue;
        //int realIn = 0, realOut = 0;

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
                        //realIn = month;

                    }
                } else if (out > min) {
                    min = out;
                    //realOut = month;
                }

            }

            //System.out.println("in: " + realIn + " ,out: " + realOut);
            System.out.println("min:  "+1+" in"+1);
            System.out.println(value);
        }
    }

}
