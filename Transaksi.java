public class Transaksi {
    private String namaBarang;
    private int hargaBarang;
    private int jumlahBeli;

    public Transaksi(String namaBarang, int hargaBarang, int jumlahBeli) {
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBeli = jumlahBeli;
    }

    public int hitungTotal() {
        return hargaBarang * jumlahBeli;
    }

    public void cetakDetail() {
        System.out.printf("%-15s Rp%-10d %-5d Rp%-10d\n",
            namaBarang, hargaBarang, jumlahBeli, hitungTotal());
    }
}