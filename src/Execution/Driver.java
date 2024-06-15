package Execution;

import java.util.Scanner;


public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager("C:\\Users\\Nilesh Kane\\Downloads"); 
        Menu menu = new Menu(scanner, fileManager);

        boolean running = true;
        while (running) {
            menu.showWelcomeScreen();
            int choice = menu.getChoice();
            switch (choice) {
                case 1:
                    fileManager.listFiles();
                    break;
                case 2:
                    menu.showFileOperationsMenu();
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
        System.exit(0);
    }
}
