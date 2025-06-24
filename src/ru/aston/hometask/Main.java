package ru.aston.hometask;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Введите абсолютный путь файла: ");
        final String filePath = scanner.nextLine();

        System.out.println("Введите номер операции:\n1: Запись текста в файл\n2: Чтение текста построчно из файла в " +
                "консоль");
        final int operationNumber = scanner.nextInt();

        switch (operationNumber) {
            case 1:
                try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
                    System.out.println("1 строка в консоли = 1 строка в файле, end -> завершить");

                    scanner.nextLine(); // Чтобы первая строка в файле не была пустой. Можно было бы добавить if в while,
                                        // но тогда нельзя будет сохранять пустые строки в файл.

                    while (true) {
                        final String text = scanner.nextLine();

                        if (text.equals("end")) break;

                        bufferedWriter.write(text+"\n");
                    }
                } catch (IOException e) {
                    throw new MyException(e.getMessage());
                }

                break;

            case 2:
                try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
                    while (bufferedReader.ready()) System.out.println(bufferedReader.readLine());
                } catch (IOException e) {
                    throw new MyException(e.getMessage());
                }

                break;
        }
    }
}