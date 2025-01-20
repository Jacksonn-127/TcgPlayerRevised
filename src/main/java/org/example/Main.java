package org.example;

import java.nio.file.FileSystems;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String currentFilePath = Paths.get("").toAbsolutePath().toString();
        System.setProperty("webdriver.chrome.driver", "D:\\work\\personalProjects\\TcgPlayerFix\\chromeDriver\\chromedriver-win64\\chromedriver.exe");

        csvWriter writer = new csvWriter();
        writer.writeToCSV();
    }
}