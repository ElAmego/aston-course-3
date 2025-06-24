package ru.aston.hometask;

public class MyException extends Exception {
    public MyException(final String exceptionText) {
        super("Ошибка: " + exceptionText);
    }
}