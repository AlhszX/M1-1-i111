package XIN.i111.report1;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[][] data = {
                {103, 97, 106, 104, 107, 101, 100, 106, 103, 99, 102, 111},
                {92, 95, 97, 99, 99, 100, 103, 106, 110, 112, 118, 121}
        };

        int month, value, min;
        int temIn, temOut, temValue;

        for (int i = 0; i < 2; i++) {
            value = 0;
            min = data[i][0];

            for (month = 1; month < 12; month++) {
                temIn = data[i][month - 1];
                temOut = data[i][month];

                if (temIn >= temOut) {
                    temValue = temOut - min;
                    if (temValue < value) {
                        value = temValue;
                    }
                } else if (temOut > min) {
                    min = temOut;
                }
                
            }

            System.out.println(value);
        }
    }

}
