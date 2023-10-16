import java.awt.*;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Set;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String puth = "resalt.txt";

    public static void main(String[] args) {
        while (true) {
            System.out.print("тяжело");
            System.out.print("Введите первую строку: ");
            String firstLine = scanner.nextLine();
            System.out.print("Введите вторую строку: ");
            String secondLine = scanner.nextLine();

            Set<Character> analis = new HashSet<>();
            Iterator<Character> iterAnalis;

            System.out.println("Выберите действие:");
            System.out.println("1. Определить символы входящие и в первую и во вторую строку");
            System.out.println("2. Определить символы входящие в первую и не входящие во вторую строку");
            System.out.println("3. Определить символы входящие хотябы в одну строку");
            System.out.println("4. Выход");

            switch (scanner.nextInt()) {
                case 1:
                    for (char symbol : firstLine.toCharArray()) {
                        if (secondLine.contains(String.valueOf(symbol))) {
                           analis.add(symbol);
                        }
                    }
                    iterAnalis = analis.iterator();
                    while (iterAnalis.hasNext()) {
                        char symbol = iterAnalis.next();
                        System.out.print(symbol + " ");
                    }
                    Choice(analis);
                    break;
                case 2:
                    for (char symbol : firstLine.toCharArray()) {
                        if (!secondLine.contains(String.valueOf(symbol))) {
                            analis.add(symbol);
                        }
                    }
                    iterAnalis = analis.iterator();
                    while (iterAnalis.hasNext()) {
                        char symbol = iterAnalis.next();
                        System.out.print(symbol + " ");
                    }
                    Choice(analis);
                    break;
                case 3:
                    for (char symbol : firstLine.toCharArray()) {
                        analis.add(symbol);
                    }
                    for (char symbol : secondLine.toCharArray()) {
                        analis.add(symbol);
                    }
                    iterAnalis = analis.iterator();
                    while (iterAnalis.hasNext()) {
                        char symbol = iterAnalis.next();
                        System.out.print(symbol + " ");
                    }
                    Choice(analis);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Вы ввели не корректную команду");
            }
            scanner.nextLine();
        }
    }
    private static void saveToFile(String filename, Set<Character> symbols) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Символы: " + symbols + "\n");
            System.out.println("Результаты сохранены в файл: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void Choice(Set line){
        System.out.println();
        System.out.println("Желаете ли сохранить результат в файле?");
        System.out.println("1. Да");
        System.out.println("2. нет");
        switch (scanner.nextInt()){
            case 1:
                saveToFile(puth, line);
                break;
            case 2:
                break;
            default:
                System.out.println("Вы ввели не корректную команду");
        }
    }
}