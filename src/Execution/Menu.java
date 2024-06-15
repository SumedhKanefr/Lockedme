package Execution;



import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private FileManager fileManager;

    public Menu(Scanner scanner, FileManager fileManager) {
        this.scanner = scanner;
        this.fileManager = fileManager;
    }

    public void showWelcomeScreen() {
        System.out.println("                                ");
        System.out.println("    Welcome to LockedMe         ");
        System.out.println("    Developer: Sumedh Nilesh Kane   ");
        System.out.println("                                ");
        System.out.println("1. List files in ascending order");
        System.out.println("2. File operations");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public int getChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        return choice;
    }

    public void showFileOperationsMenu() {
    	boolean x=true;
        while (x) {
            System.out.println("====================================");
            System.out.println("          File Operations           ");
            System.out.println("====================================");
            System.out.println("1. Add a file");
            System.out.println("2. Delete a file");
            System.out.println("3. Search for a file");
            System.out.println("4. Back to main menu");
            System.out.print("Enter your choice: ");
            int choice = getChoice();
            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the file to add: ");
                    String addFileName = scanner.nextLine();
                    fileManager.addFile(addFileName);
                    break;
                case 2:
                    System.out.print("Enter the name of the file to delete: ");
                    String deleteFileName = scanner.nextLine();
                    fileManager.deleteFile(deleteFileName);
                    break;
                case 3:
                    System.out.print("Enter the name of the file to search: ");
                    String searchFileName = scanner.nextLine();
                    fileManager.searchFile(searchFileName);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
