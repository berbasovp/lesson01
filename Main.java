package lesson23;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Задание 1
	String Text="XX xy ff ddg gg sw gh dd gg hh de gg sw ff sq ku lgkk dll snnn ue lhhl";
        String[] arr2=Text.split(" ");
	ArrayList<String> mass=new ArrayList<>(Arrays.asList(arr2));
	HashSet<String> mass1=new HashSet<>(mass);
        for (String item:mass1) {
            int count = Collections.frequency(mass, item);
            System.out.println("Слово "+item+" встречается "+count+" раз");
        }
            System.out.println("Маасив без повторений:"+mass1);


        //Задание 2
        Map<Integer, String> tel = new HashMap<>();
        int telSearch=3141413;
        String familySearch="Семенов";
        tel.put(3141413,"Семенов");
        tel.put(3141411,"Иванов");
        tel.put(3558522,"Сидоров");
        tel.put(3558525,"Семенов");
        for (Map.Entry<Integer, String> item : tel.entrySet()) {
        if (item.getKey()==telSearch) {
        System.out.println("Поиск по телену "+telSearch+" "+item.getValue());
        }
            if (item.getValue()==familySearch) {
                System.out.println("Телефон по фамилии "+familySearch+" "+item.getKey());
            }
        }
        }

    }
