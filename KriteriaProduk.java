import java.util.ArrayList; // Mengimpor ArrayList untuk menyimpan daftar hasil pencarian
import java.util.Scanner; // Mengimpor Scanner untuk membaca input dari pengguna
// Kelas Produk merepresentasikan data produk yang dijual
class Produk {
    String id; // Menyimpan ID produk
    String nama; // Menyimpan nama produk
    String kategori; // Menyimpan kategori produk (misal: Elektronik, Buku)
    double harga; // Menyimpan harga produk
    int stok; // Menyimpan jumlah stok produk
    // Konstruktor untuk inisialisasi objek Produk
    public Produk(String id, String nama, String kategori, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }
    // Metode untuk mengembalikan representasi string dari objek Produk
    @Override
    public String toString() {
        return String.format("%-5s | %-25s | %-15s | Rp %.2f | Stok: %d",
                id, nama, kategori, harga, stok);
    }
}
// Kelas utama program pencarian produk
public class KriteriaProduk {
    public static void main(String[] args) {
        // Inisialisasi array berisi daftar produk
        Produk[] daftarProduk = {
                new Produk("P001", "Laptop Asus VivoBook", "Elektronik", 8500000, 10),
                new Produk("P002", "Smartphone Samsung Galaxy", "Elektronik", 5000000, 15),
                new Produk("P003", "Kemeja Formal Pria", "Fashion", 250000, 50),
                new Produk("P004", "Sepatu Lari Nike", "Fashion", 1200000, 25),
                new Produk("P005", "Buku Pemrograman Java", "Buku", 150000, 30),
                new Produk("P006", "Mouse Gaming Logitech", "Elektronik", 350000, 20),
                new Produk("P007", "Novel Bumi Manusia", "Buku", 95000, 40),
                new Produk("P008", "Tas Ransel", "Fashion", 300000, 35)
        };
        // Membuat objek Scanner untuk membaca input dari pengguna
        Scanner scanner = new Scanner(System.in);
        // Menampilkan judul sistem pencarian dan pilihan kategori
        System.out.println("=== SISTEM PENCARIAN PRODUK ===");
        System.out.println("Kategori tersedia: Elektronik, Fashion, Buku");
        // Meminta pengguna untuk memasukkan kategori produk yang dicari
        System.out.print("Masukkan kategori produk: ");
        String kategoriCari = scanner.nextLine();
        // Meminta pengguna untuk memasukkan harga minimum
        System.out.print("Masukkan harga minimum: Rp ");
        double hargaMin = scanner.nextDouble();
        // Meminta pengguna untuk memasukkan harga maksimum
        System.out.print("Masukkan harga maksimum: Rp ");
        double hargaMax = scanner.nextDouble();
        // Memanggil method pencarian berdasarkan kategori dan rentang harga
        ArrayList<Produk> hasilPencarian = cariProdukByKriteria(daftarProduk, kategoriCari, hargaMin, hargaMax);
        // Menampilkan hasil pencarian
    System.out.println("\nHASIL PENCARIAN:");
        System.out.println("===============================================================");
        System.out.printf("%-5s | %-25s | %-15s | %-10s | %-10s\n",
                "ID", "Nama Produk", "Kategori", "Harga", "Stok");
        System.out.println("---------------------------------------------------------------");
        // Jika hasil pencarian tidak kosong, tampilkan produk yang ditemukan
        if (hasilPencarian.size() > 0) {
            for (Produk p : hasilPencarian) {
                System.out.println(p);
            }
        } else {
            // Jika tidak ada produk yang sesuai
            System.out.println("Tidak ada produk yang sesuai dengan kriteria pencarian.");
        }
        System.out.println("===============================================================");
        // Menutup Scanner
        scanner.close();
    }
    // Method pencarian produk berdasarkan kategori dan harga yang diberikan
    public static ArrayList<Produk> cariProdukByKriteria(Produk[] daftarProduk,
            String kategori,
            double hargaMin,
            double hargaMax) {
        ArrayList<Produk> hasilPencarian = new ArrayList<>(); // Untuk menyimpan hasil pencarian
        // Loop untuk mengecek satu per satu produk
        for (int i = 0; i < daftarProduk.length; i++) {
            Produk produk = daftarProduk[i];
            // Periksa apakah produk memenuhi kriteria pencarian (kategori dan rentang
            // harga)
            if (produk.kategori.equalsIgnoreCase(kategori)
                    && produk.harga >= hargaMin
                    && produk.harga <= hargaMax) {
                hasilPencarian.add(produk); // Tambahkan ke daftar hasil
            }
        }
        return hasilPencarian; // Kembalikan hasil pencarian
    }
}
