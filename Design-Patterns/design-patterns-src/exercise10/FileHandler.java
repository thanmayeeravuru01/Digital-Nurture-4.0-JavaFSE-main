package exercise10;

import java.io.*;

public class FileHandler {
    public static void main(String[] args) {
        String filePath = "sample.txt";

        // Writing to a file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Welcome to File Handling in Java!\n");
            writer.write("This is the second line.");
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing: " + e.getMessage());
        }

        // Reading from a file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Reading from file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading: " + e.getMessage());
        }
    }
}
