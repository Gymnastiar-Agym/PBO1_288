


import java.util.ArrayList;
public class User {
    // Method untuk menampilkan daftar buku yang ada di perpustakaan
    public static void displayBooks(ArrayList<Book> bookList) {
        System.out.println("===== Available Books =====");
        System.out.println("|| No.\t|| Id buku\t|| Nama buku\t\t|| Author\t|| Category\t|| Stock\t||");
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            System.out.println("|| " + (i+1) + "\t|| " + book.getBookId() + "\t|| " + book.getTitle() + "\t\t|| " +
                    book.getAuthor() + "\t|| " + book.getCategory() + "\t|| " + book.getStock() + "\t||");
        }
        System.out.println("===========================");
    }
}
