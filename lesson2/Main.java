package lesson2;

public class Main {

    public static void main(String[] args) {
            String[][] correctMassiv = {
                    {"4", "10", "155", "8"},
                    {"5", "1", "0", "1"},
                    {"2", "3", "4", "5"},
                    {"6", "7", "9", "1"}
            };
            String[][] wrongSize = {
                    {"1", "2", "3", "4"},
                    {"1", "5", "8", "111"},
                    {"2", "55"},
                    {"1", "24", "766", "6"}
            };
            String[][] wrongInt = {
                    {"gdg", "6", "4", "4"},
                    {"2", "dg", "44", "4"},
                    {"5", "5", "766", "33"},
                    {"1", "88", "6", "5"}
            };

            try {
                System.out.println(MassivCorrect.strConverter(correctMassiv));
            } catch (MassivException e) {
                e.getMessage();
            }


            try {
                System.out.println(MassivCorrect.strConverter(wrongSize));
            } catch (MassivException e) {
                System.err.println("wrongSize "+e.getMessage());
            }

            try {
                System.out.println(MassivCorrect.strConverter(wrongInt));
            } catch (MassivException e) {
                System.err.println("wrongInt "+ e.getMessage());
            }
        }
    }

