package ru.aston.hometask;

import java.nio.file.Path;

public interface Strategy {
    void action(final Path filePath) throws MyException;
}
