package ru.aston.hometask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextReader implements Strategy{
    @Override
    public void action(Path filePath) throws MyException {
        try {
            List<String> allRows = Files.readAllLines(filePath);
            allRows.stream().forEach(System.out::println);
        } catch (IOException e) {
            throw new MyException(e.getMessage());
        }
    }
}
