package table;

public class stok {
    private String kode_produk;
    private String rasa;
    private int harga;
    private int stok;

    public stok(String kode_produk, String rasa, int harga, int stok) {
        this.kode_produk = kode_produk;
        this.rasa = rasa;
        this.harga = harga;
        this.stok = stok;
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

    public int getStok() {
        return stok;
    }
}
