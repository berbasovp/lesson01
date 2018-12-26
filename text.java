package Marathon;

public class  text {

    public static void bes(String text) {
        int stroka = 0;
        int sum = 0;
        text = text + "\n";
        int length = text.length();
            for (int i = 0; i < length; i++) {
                if ((text.charAt(i) == 97) || (text.charAt(i) == 121) || (text.charAt(i) == 10) || (text.charAt(i) == 117) || (text.charAt(i) == 111) || (text.charAt(i) == 101)) {
                    sum = sum + 1;
                    if (text.charAt(i) == 10) {
                        stroka++;
                        System.out.println("Гласных в строке " + stroka + " - " + sum);
                        sum = 0;
                    }
                }
            }

    }
}
