package ru.aston.hometask;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {
        final Map<Integer, Strategy> operationMap = new HashMap<>();
        operationMap.put(1, new TextWriter());
        operationMap.put(2, new TextReader());

        final Scanner scanner = new Scanner(System.in);

        System.out.println("Введите абсолютный путь файла: ");
        final Path filePath = Paths.get(scanner.nextLine());

        System.out.println("Введите номер операции:\n1: Запись текста в файл\n2: Чтение текста построчно из файла в " +
                "консоль");
        final int operationNumber = scanner.nextInt();

        if (operationMap.containsKey(operationNumber)) operationMap.get(operationNumber).action(filePath);
    }
}