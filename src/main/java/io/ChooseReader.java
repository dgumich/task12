package io;
import java.util.Scanner;


/**
 * Класс предназначен для считывания типа памяти, в которой необходимо вызвать утечки
 */
public class ChooseReader {

    /**
     * Метод выводит пользователю информацию и дает право выбора помяти, после чего считывает введенную строку
     * @return и возвращает ее.
     */
    public static String readLine() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Какую память вы хотите съесть? 1 - Heap, 2 - MetaSpace");
            return scanner.nextLine();

        }
    }
}
