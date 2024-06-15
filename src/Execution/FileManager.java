package Execution;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileManager {
    private String directoryPath;

    public FileManager(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void listFiles() {
        File directory = new File(directoryPath);
        File[] filesList = directory.listFiles();
        if (filesList != null && filesList.length > 0) {
            Arrays.sort(filesList);
            System.out.println("Files in " + directoryPath + ":");
            for (File file : filesList) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("The directory is empty or doesn't exist.");
        }
    }

    public void addFile(String fileName) {
        File file = new File(directoryPath + "/" + fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public void deleteFile(String fileName) {
        File file = new File(directoryPath + "/" + fileName);
        if (file.delete()) {
            System.out.println("File deleted: " + file.getName());
        } else {
            System.out.println("File not found or could not be deleted.");
        }
    }

    public void searchFile(String fileName) {
        File directory = new File(directoryPath);
        File[] filesList = directory.listFiles();
        boolean found = false;
        if (filesList != null) {
            for (File file : filesList) {
                if (file.getName().equals(fileName)) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            System.out.println("File found: " + fileName);
        } else {
            System.out.println("File not found.");
        }
    }
}
