package lesson2;

public class MassivCorrect {
    public static int strConverter(String[][] strArray)
            throws sizeException, dataException {

        int sum = 0;

        for (int i = 0; i < strArray.length; i++) {

            if (4 != strArray[i].length) throw new sizeException();

            for (int j = 0; j < strArray[i].length; j++) {

                try {
                    sum += Integer.parseInt(strArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new dataException(i, j);
                }
            }
        }

        return sum;
    }
}
