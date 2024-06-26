package table;

public class pembelian {
    private String noNota;
    private String tanggal;
    private String idPegawai;
    private String nama;
    private int totalHarga;
    private int jumlahBayar;
    private int kembali;

    public pembelian(String noNota, String tanggal, String idPegawai, String nama, int totalHarga, int jumlahBayar, int kembali) {
        this.noNota = noNota;
        this.tanggal = tanggal;
        this.idPegawai = idPegawai;
        this.nama = nama;
            this.totalHarga = totalHarga;
        this.jumlahBayar = jumlahBayar;
        this.kembali = kembali;
    }

    public String getNoNota() {
        return noNota;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public String getNama() {
        return nama;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public int getJumlahBayar() {
        return jumlahBayar;
    }

    public int getKembali() {
        return kembali;
    }
}
