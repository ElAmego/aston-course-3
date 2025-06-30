package ru.aston.hometask;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class TextWriter implements Strategy {
    @Override
    public void action(final Path filePath) throws MyException {
        try {
            final Scanner scanner = new Scanner(System.in);
            final StringBuilder content = new StringBuilder();

            System.out.println("1 строка в консоли = 1 строка в файле, end -> завершить");

            while (scanner.hasNextLine()) {
                final String text = scanner.nextLine();

                if (text.equals("end")) break;

                content.append(text).append("\n");
            }

            Files.write(filePath, content.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new MyException(e.getMessage());
        }
    }
}