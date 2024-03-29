import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Book> bookList = new ArrayList<>();
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Admin admin = new Admin(studentList);

    public static void main(String[] args) {
        // Menambahkan beberapa buku ke dalam daftar buku
        bookList.add(new HistoryBook("1", "Sejarah Indonesia", "Author 1", "History Book", 5));
        bookList.add(new StoryBook("2", "Cara Dapat Jodoh", "Author 2", "Story Book", 1));
        bookList.add(new TextBook("3", "Matematika Dasar", "Author 3", "Text Book", 2));

        // Memanggil menu utama
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    studentLogin();
                    break;
                case 2:
                    adminLogin();
                    break;
                case 3:
                    System.out.println("Thank you. Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
    }

    public static void studentLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your NIM (input 99 to go back): ");
        String nim = scanner.nextLine();
        if (nim.equals("99")) {
            return;
        }
        Student student = findStudent(nim);
        if (student != null) {
            // Menampilkan menu untuk mahasiswa
            studentMenu(student);
        } else {
            System.out.println("Student dengan NIM tersebut tidak ditemukan.");
        }
    }

    public static void studentMenu(Student student) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Student Menu =====");
            System.out.println("1. List of Borrowed Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Borrow a Book or Logout");
            System.out.print("Choose option (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    student.displayBooks(bookList);
                    break;
                case 2:
                    // Implementasi peminjaman buku
                    break;
                case 3:
                    // Implementasi pengembalian buku
                    break;
                case 4:
                    System.out.println("Logging out from student account.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    public static void adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username (admin): ");
        String username = scanner.nextLine();
        System.out.print("Enter your password (admin): ");
        String password = scanner.nextLine();
        if (username.equals("admin") && password.equals("admin")) {
            adminMenu();
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }

    public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Book");
            System.out.println("3. Display Registered Students");
            System.out.println("4. Display Available Books");
            System.out.println("5. Logout");
            System.out.print("Choose option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    admin.inputBook(bookList);
                    break;
                case 3:
                    admin.displayStudent();
                    break;
                case 4:
                    displayAvailableBooks();
                    break;
                case 5:
                    System.out.println("Logging out from admin account.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    public static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Enter student faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter student program: ");
        String programStudi = scanner.nextLine();
        admin.addStudent(name, nim, faculty, programStudi);
        System.out.println("Student successfully registered.");
    }

    public static Student findStudent(String nim) {
        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                return student;
            }
        }
        return null;
    }

    public static void displayAvailableBooks() {
        System.out.println("===== Available Books =====");
        System.out.println("|| No. || Book ID || Title || Author || Category || Stock ||");
        for (Book book : bookList) {
            System.out.println("|| " + book.getBookId() + " || " + book.getTitle() + " || " + book.getAuthor() + " || " + book.getCategory() + " || " + book.getStock() + " ||");
        }
        System.out.println("=======================================");
    }
}
