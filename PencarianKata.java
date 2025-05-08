import java.util.ArrayList; // Mengimpor class ArrayList untuk menyimpan posisi kata
import java.util.Scanner; // Mengimpor class Scanner untuk membaca input dari pengguna
public class PencarianKata {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk input dari keyboard
        System.out.println("=== SISTEM PENCARIAN KATA ===");
        System.out.print("Masukkan teks: ");
        String teks = scanner.nextLine(); // Membaca teks masukan dari pengguna
        System.out.print("Masukkan kata yang dicari: ");
        String kataCari = scanner.nextLine(); // Membaca kata yang ingin dicari dalam teks
        // Lakukan pencarian kata
        ArrayList<Integer> posisiDitemukan = cariKata(teks, kataCari); // Memanggil method cariKata dan menyimpan posisi
                                                                       // kemunculan kata
        System.out.println("\nHASIL PENCARIAN:");
        if (posisiDitemukan.size() > 0) { // Jika ditemukan posisi kata yang dicari
            System.out.println("Kata '" + kataCari + "' ditemukan sebanyak "
                    + posisiDitemukan.size() + " kali pada posisi:");
            for (int i = 0; i < posisiDitemukan.size(); i++) {
                System.out.println("- Indeks ke-" + posisiDitemukan.get(i)
                        + " (karakter ke-" + (posisiDitemukan.get(i) + 1) + ")");
                // Menampilkan indeks tempat kata ditemukan dalam teks
            }
            // Tampilkan teks dengan highlight kata yang ditemukan
            System.out.println("\nTeks dengan highlight:");
            tampilkanTeksHighlight(teks, kataCari, posisiDitemukan); // Menampilkan teks dengan penanda [ ] pada kata
                                                                     // yang ditemukan
        } else {
            System.out.println("Kata '" + kataCari + "' tidak ditemukan dalam teks.");
        }
        scanner.close(); // Menutup scanner untuk menghindari kebocoran memori
    }
    // Method untuk mencari posisi kata yang ditemukan
    public static ArrayList<Integer> cariKata(String teks, String kata) {
        ArrayList<Integer> posisi = new ArrayList<>();
        String teksLower = teks.toLowerCase();
        String kataLower = kata.toLowerCase();
        int panjangKata = kataLower.length(); // Menghitung panjang kata yang dicari
        int panjangTeks = teksLower.length(); // Menghitung panjang teks
        // Melakukan pencarian linear
        for (int i = 0; i <= panjangTeks - panjangKata; i++) {
            String potongan = teksLower.substring(i, i + panjangKata);
            // Memeriksa apakah substring sama dengan kata yang dicari
            if (potongan.equals(kataLower)) {
                posisi.add(i);
            }
        }
        return posisi; // Mengembalikan daftar posisi kata yang ditemukan
    }
    // Method untuk menampilkan teks dengan highlight
    public static void tampilkanTeksHighlight(String teks, String kata, ArrayList<Integer> posisi) {
        StringBuilder hasil = new StringBuilder(teks);
        for (int i = posisi.size() - 1; i >= 0; i--) {
            int pos = posisi.get(i);
            hasil.insert(pos + kata.length(), "]");
            hasil.insert(pos, "[");
        }
        System.out.println(hasil.toString()); // Menampilkan teks yang telah di-highlight
    }
}
