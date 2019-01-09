package password;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите пароль\n 1. Пароль должен быть не менее 8ми символов.\n" +
                "2. В пароле должно быть число\n" +
                "3. В пароле должна быть хотя бы 1 строчная буква\n" +
                "4. В пароле должна быть хотя бы 1 заглавная буква\n" +
                "5. Не должно быть пробелов\n" +
                "6. Должен быть спец. символ");
        Scanner scan=new Scanner(System.in);
        String pass=scan.nextLine();
        Pattern pattern=Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])[^\\s]{8,}$");
        Matcher matcher=pattern.matcher(pass);
        if (matcher.find()){
            System.out.println("пароль верен");
        }
        else System.out.println("пароль неверен");
    }
}
