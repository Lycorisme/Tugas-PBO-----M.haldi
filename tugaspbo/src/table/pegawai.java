package table;

public class pegawai {
    String id_pegawai, nama, alamat, telp;

    public pegawai(String id_pegawai, String nama, String alamat, String telp) {
        this.id_pegawai = id_pegawai;
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
    }

    public String getIdPegawai() {
        return id_pegawai;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTelp() {
        return telp; 
    }
}
