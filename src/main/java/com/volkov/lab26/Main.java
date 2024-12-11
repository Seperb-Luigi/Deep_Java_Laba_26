package com.volkov.lab26;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // Создаем объект Scanner для считывания ввода пользователя
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сообщение, которое нужно записать в файл:");
        String message = scanner.nextLine();

        // Путь к файлу
        String filePath = "test.txt";

        // Записываем сообщение в файл, добавляя данные, если файл уже существует
        try (FileWriter writer = new FileWriter(filePath, true)) { // true для добавления данных
            writer.write(message + System.lineSeparator()); // Добавляем перевод строки после сообщения
            System.out.println("Сообщение успешно записано в файл " + filePath);
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл: " + e.getMessage());
        }

        // Закрываем сканер
        scanner.close();
    }

    // Метод для очистки файла (для тестов)
    public static void clearFile(String filePath) throws IOException {
        Files.write(Paths.get(filePath), new byte[0]);
    }

    // Метод для чтения содержимого файла (для тестов)
    public static String readFileContent(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}

