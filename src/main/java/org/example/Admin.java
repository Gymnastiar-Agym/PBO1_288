import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private ArrayList<Student> studentList;

    public Admin(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(String name, String nim, String faculty, String programStudi) {
        Student newStudent = new Student(name, nim, faculty, programStudi);
        studentList.add(newStudent);
        System.out.println("Student successfully registered.");
    }

    public void inputBook(ArrayList<Book> bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select book category:");
        System.out.println("1. Story Book");
        System.out.println("2. History Book");
        System.out.println("3. Text Book");
        System.out.print("Choose category (1-3): ");
        int categoryChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String bookId = generateId();
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String category;
        switch (categoryChoice) {
            case 1:
                category = "Story Book";
                break;
            case 2:
                category = "History Book";
                break;
            case 3:
                category = "Text Book";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Story Book.");
                category = "Story Book";
        }

        Book newBook;
        switch (categoryChoice) {
            case 1:
                newBook = new StoryBook(bookId, title, author, category, stock);
                break;
            case 2:
                newBook = new HistoryBook(bookId, title, author, category, stock);
                break;
            case 3:
                newBook = new TextBook(bookId, title, author, category, stock);
                break;
            default:
                newBook = new StoryBook(bookId, title, author, category, stock);
        }

        bookList.add(newBook);
        System.out.println("Book successfully added to the library.");
    }

    // Method to display registered students
    public void displayStudent() {
        System.out.println("List of Registered Students:");
        for (Student student : studentList) {
            System.out.println("Name: " + student.getName());
            System.out.println("Faculty: " + student.getFaculty());
            System.out.println("NIM: " + student.getNim());
            System.out.println("Program: " + student.getProgramStudi());
        }
    }

    // Method to generate unique book ID
    private String generateId() {
        // Implementation to generate unique book ID
        return "unique-id"; // Placeholder for implementation
    }
}
