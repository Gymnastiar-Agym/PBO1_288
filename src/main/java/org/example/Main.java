import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Input Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    if (nim.length() != 15) {
                        System.out.println("Panjang NIM harus 15 angka!");
                        continue;
                    }
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Jurusan: ");
                    String jurusan = scanner.nextLine();
                    Mahasiswa mahasiswaBaru = new Mahasiswa(nim, nama, jurusan);
                    daftarMahasiswa.add(mahasiswaBaru);
                    System.out.println("Data mahasiswa berhasil ditambahkan!");
                    break;

                case "2":
                    if (daftarMahasiswa.isEmpty()) {
                        System.out.println("Belum ada data mahasiswa yang dimasukkan.");
                    } else {
                        System.out.println("\nData Mahasiswa:");
                        int idx = 1;
                        for (Mahasiswa mahasiswa : daftarMahasiswa) {
                            System.out.println("Mahasiswa ke-" + idx + ":");
                            mahasiswa.tampilDataMahasiswa();
                            idx++;
                        }
                    }
                    break;

                case "3":
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
                    break;
            }
        }
    }
}
