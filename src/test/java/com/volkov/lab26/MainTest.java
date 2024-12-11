package com.volkov.lab26;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private final String filePath = "test.txt";

    @BeforeEach
    public void setup() throws IOException {
        // Очищаем файл перед каждым тестом
        Main.clearFile(filePath);
    }

    @AfterEach
    public void cleanup() throws IOException {
        // Удаляем файл после каждого теста
        Files.deleteIfExists(Paths.get(filePath));
    }

    @Test
    public void testMainAddsMessage() throws IOException {
        // Тестируем запись в файл
        String message = "Привет, мир!";
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(message + System.lineSeparator());
        }

        String content = Main.readFileContent(filePath);
        assertEquals(message + System.lineSeparator(), content, "Содержимое файла должно совпадать с записанным сообщением.");
    }

    @Test
    public void testWriteToFileAppendsMessage() throws IOException {
        // Тестируем добавление нового сообщения в файл
        String message1 = "Привет, мир!";
        String message2 = "Как дела?";

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(message1 + System.lineSeparator());
            writer.write(message2 + System.lineSeparator());
        }

        String content = Main.readFileContent(filePath);
        assertEquals(message1 + System.lineSeparator() + message2 + System.lineSeparator(), content,
                "Содержимое файла должно содержать оба сообщения.");
    }
}
