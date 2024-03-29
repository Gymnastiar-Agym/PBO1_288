import java.util.ArrayList;

public class Student {
    String name, nim, faculty, programStudi;

    public Student(String name, String nim, String faculty, String programStudi) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.programStudi = programStudi;
    }

    public String getNim() {
        return this.nim;
    }

    public String getName() {
        return this.name;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public String getProgramStudi() {
        return this.programStudi;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", nim='" + nim + '\'' +
                ", faculty='" + faculty + '\'' +
                ", programStudi='" + programStudi + '\'' +
                '}';
    }

    public void displayBooks(ArrayList<Book> bookList) {
        System.out.println("==================================================================================================");
        System.out.println("|| No.\t||\tid buku\t||Nama buku\t\t||Author\t||Category\t||\tStock\t||");
        System.out.println("==================================================================================================");

        for (Book book : bookList) {
            System.out.println("|| " + book.getBookId() + " || " + book.getTitle() + " || " + book.getAuthor() + " || " + book.getCategory() + " || " + book.getStock() + " ||");
        }

        System.out.println("==================================================================================================");
    }
}
