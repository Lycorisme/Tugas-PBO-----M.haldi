package table;

public class penjualan {
    private String no_nota;
    private String kode_produk;
    private String rasa;
    private int harga;
    private int jumlah_beli;
    private int jumlah_harga;

    public penjualan(String no_nota, String kode_produk, String rasa, int harga, int jumlah_beli, int jumlah_harga) {
        this.no_nota = no_nota;
        this.kode_produk = kode_produk;
        this.rasa = rasa;
        this.harga = harga;
        this.jumlah_beli = jumlah_beli;
        this.jumlah_harga = jumlah_harga;
    }

    public String getNoNota() {
        return no_nota;
    }

    public String getKodeProduk() {
        return kode_produk;
    }

    public String getRasa() {
        return rasa;
    }

    public int getHarga() {
        return harga;
    }

    public int getJumlahBeli() {
        return jumlah_beli;
    }

    public int getJumlahHarga() {
        return jumlah_harga;
    }
}
