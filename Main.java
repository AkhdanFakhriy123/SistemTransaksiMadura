import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
        String lanjut;
        int totalBayar = 0;

        System.out.println("=== APLIKASI TRANSAKSI WARUNG MADURA ===");

        do {
            System.out.print("Masukkan Nama Barang : ");
            String nama = input.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            int harga = Integer.parseInt(input.nextLine());

            System.out.print("Masukkan Jumlah Beli : ");
            int jumlah = Integer.parseInt(input.nextLine());

            Transaksi t = new Transaksi(nama, harga, jumlah);
            daftarTransaksi.add(t);
            totalBayar += t.hitungTotal();

            System.out.print("Tambah barang lagi? (y/n): ");
            lanjut = input.nextLine().toLowerCase();
            System.out.println();
        } while (lanjut.equals("y"));

        // Cetak struk lengkap
        System.out.println("=========== STRUK PEMBELIAN ===========");
        System.out.printf("%-15s %-12s %-6s %-10s\n", 
            "Nama Barang", "Harga", "Satuan", "Subtotal");
        System.out.println("----------------------------------------");
        for (Transaksi t : daftarTransaksi) {
            t.cetakDetail();
        }
        System.out.println("----------------------------------------");
        System.out.println("TOTAL BAYAR : Rp" + totalBayar);

        // Pembayaran
        int bayar = 0;
        while (true) {
            System.out.print("Masukkan Uang Pembayaran: Rp");
            bayar = Integer.parseInt(input.nextLine());
            if (bayar >= totalBayar) break;
            System.out.println("Uang tidak cukup. Masukkan kembali.");
        }

        int kembalian = bayar - totalBayar;
        System.out.println("KEMBALIAN    : Rp" + kembalian);
        System.out.println("========================================");

        input.close();
    }
}