import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner pemindai = new Scanner(System.in);

        String nama;
        do {
            System.out.print("Masukkan nama: ");
            nama = pemindai.nextLine();
            if (nama.length() > 50) {
                System.out.println("Nama terlalu panjang, maksimal 50 karakter!");
            }
        } while (nama.length() > 50);

        char jenisKelamin;
        do {
            System.out.print("Masukkan jenis kelamin (P/L): ");
            jenisKelamin = pemindai.next().charAt(0);
            if (jenisKelamin != 'P' && jenisKelamin != 'L') {
                System.out.println("Masukkan jenis kelamin yang valid (P/L)!");
            }
        } while (jenisKelamin != 'P' && jenisKelamin != 'L');

        String jenisKelaminLengkap = (jenisKelamin == 'L') ? "Laki-laki" : "Perempuan";

        String tanggalLahirString;
        do {
            System.out.print("Masukkan tanggal lahir (YYYY-MM-DD): ");
            tanggalLahirString = pemindai.next();
            if (!validasiFormatTanggal(tanggalLahirString)) {
                System.out.println("Format tanggal lahir salah. Gunakan format YYYY-MM-DD.");
            }
        } while (!validasiFormatTanggal(tanggalLahirString));

        String[] tanggalLahirArray = tanggalLahirString.split("-");
        int tahunLahir = Integer.parseInt(tanggalLahirArray[0]);
        int bulanLahir = Integer.parseInt(tanggalLahirArray[1]);
        int tanggalLahir = Integer.parseInt(tanggalLahirArray[2]);

        Period umur = hitungUmur(tahunLahir, bulanLahir, tanggalLahir);

        System.out.println("\nData Diri:");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelaminLengkap);
        System.out.println("Umur: " + umur.getYears() + " tahun " + umur.getMonths() + " bulan");

        pemindai.close();
    }

    public static Period hitungUmur(int tahunLahir, int bulanLahir, int tanggalLahir) {
        LocalDate tanggalLahirObj = LocalDate.of(tahunLahir, bulanLahir, tanggalLahir);
        LocalDate sekarang = LocalDate.now();
        return Period.between(tanggalLahirObj, sekarang);
    }

    public static boolean validasiFormatTanggal(String tanggal) {
        return tanggal.matches("\\d{4}-\\d{2}-\\d{2}");
    }
}

