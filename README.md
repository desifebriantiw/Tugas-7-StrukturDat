a.Pencarian Data Mahasiswa 
import java.util.Scanner; // Mengimpor kelas Scanner untuk membaca input dari pengguna
// Kelas Mahasiswa untuk menyimpan data mahasiswa
class Mahasiswa {
    String nim; // Nomor Induk Mahasiswa
    String nama; // Nama mahasiswa
    String jurusan; // Jurusan mahasiswa
    double ipk; // Indeks Prestasi Kumulatif
    // Konstruktor untuk menginisialisasi objek Mahasiswa
    public Mahasiswa(String nim, String nama, String jurusan, double ipk) {
        this.nim = nim; // Mengatur NIM
        this.nama = nama; // Mengatur nama
        this.jurusan = jurusan; // Mengatur jurusan
        this.ipk = ipk; // Mengatur IPK
    }
    // Metode untuk mengembalikan representasi string dari objek Mahasiswa
    @Override
    public String toString() {
        return String.format("NIM: %s\nNama: %s\nJurusan: %s\nIPK: %.2f", nim, nama, jurusan, ipk);
    }
}
// Kelas utama untuk pencarian data mahasiswa
public class PencarianDataMahasiswa {
    public static void main(String[] args) {
        // Data mahasiswa yang disimpan dalam array
        Mahasiswa[] daftarMahasiswa = {
                new Mahasiswa("2023001", "Budi Santoso", "Teknik Informatika", 3.75),
                new Mahasiswa("2023002", "Andi Wijaya", "Sistem Informasi", 3.50),
                new Mahasiswa("2023003", "Dewi Lestari", "Teknik Komputer", 3.90),
                new Mahasiswa("2023004", "Rina Maulana", "Teknik Informatika", 3.60),
                new Mahasiswa("2023005", "Doni Kusuma", "Manajemen Informatika", 3.25),
                new Mahasiswa("2023006", "Sinta Rahma", "Sistem Informasi", 3.85),
                new Mahasiswa("2023007", "Rudi Hermawan", "Teknik Komputer", 3.40)
        };
        // Membuat objek Scanner untuk membaca input dari pengguna
        Scanner scanner = new Scanner(System.in);
        // Menampilkan judul sistem pencarian
        System.out.println("=== SISTEM PENCARIAN DATA MAHASISWA ===");
        // Meminta pengguna untuk memasukkan NIM yang ingin dicari
        System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
        String nimCari = scanner.nextLine(); // Membaca input NIM dari pengguna
        // Melakukan pencarian mahasiswa berdasarkan NIM
        Mahasiswa hasilPencarian = cariMahasiswaByNIM(daftarMahasiswa, nimCari);
        // Menampilkan hasil pencarian
        System.out.println("\nHASIL PENCARIAN:");
        if (hasilPencarian != null) { // Jika mahasiswa ditemukan
            System.out.println("Mahasiswa ditemukan!");
            System.out.println(hasilPencarian); // Menampilkan data mahasiswa
        } else { // Jika mahasiswa tidak ditemukan
            System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
        }
        // Menutup scanner untuk mencegah kebocoran memori
        scanner.close();
    }
    // Metode untuk mencari mahasiswa berdasarkan NIM
    public static Mahasiswa cariMahasiswaByNIM(Mahasiswa[] daftarMahasiswa, String nim) {
        // Melakukan pencarian linear pada array daftarMahasiswa
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            // Bandingkan NIM mahasiswa saat ini dengan NIM yang dicari
            if (daftarMahasiswa[i].nim.equals(nim)) {
                return daftarMahasiswa[i]; // Mengembalikan objek Mahasiswa jika ditemukan
            }
        }
        // Jika tidak ditemukan, mengembalikan null
        return null;
    }
}

b.Kriteria Produk
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

c.Pencarian Kata
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

