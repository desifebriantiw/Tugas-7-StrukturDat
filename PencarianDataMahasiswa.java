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