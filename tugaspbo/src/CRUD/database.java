package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class database {

    private String databaseName = "2210010283_m_haldi";
    private String username = "root";
    private String password = "";
    private String lokasi = "jdbc:mysql://localhost/" + databaseName;
    public static Connection koneksiDB;

    public database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(lokasi, username, password);
            System.out.println("Database Terkoneksi");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Koneksi Gagal: " + e.getMessage());
        }
    }

    //TABLE UJI//
    public void simpanuji(String nik, String nama, String no_telp, String alamat) {
        try {
            String SQL = "INSERT INTO UJI (nik, nama, no_telp, alamat) VALUES (?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, nik);
            perintah.setString(2, nama);
            perintah.setString(3, no_telp);
            perintah.setString(4, alamat);
            perintah.executeUpdate();
            System.out.println("Data berhasil disimpan");
        } catch (SQLException e) {
            System.err.println("Gagal Menyimpan Data: " + e.getMessage());
        }
    }
    
        public void ubahuji(String nik, String nama, String no_telp, String alamat) {
        try {
            String SQL = "UPDATE UJI SET nama = ?, no_telp = ?, alamat = ? WHERE nik = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, nama);
            perintah.setString(2, no_telp);
            perintah.setString(3, alamat);
            perintah.setString(4, nik);
            perintah.executeUpdate();
            System.out.println("Data berhasil diubah");
        } catch (SQLException e) {
            System.err.println("Gagal Menyimpan Data: " + e.getMessage());
        }
        
    }
        public void hapusuji(String nik){
            try {
                String SQL = "DELETE FROM UJI WHERE nik=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
                perintah.setString(1, nik);
                perintah.executeUpdate();
                System.out.println("Data berhasil dihapus");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        
        public void cariuji(String nik){
            try {
                String SQL="SELECT*FROM uji WHERE nik=?";
                PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
                perintah.setString(1, nik);
                ResultSet data = perintah.executeQuery();
                while(data.next()){
                    System.out.println("NIK :"+data.getString("nik"));
                    System.out.println("NAMA :"+data.getString("nama"));
                    System.out.println("NO_TELPON :"+data.getString("no_telp"));
                    System.out.println("ALAMAT :"+data.getString("alamat"));
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        
        public void datauji(){
            try {
                Statement stmt = koneksiDB.createStatement();
                ResultSet baris = stmt.executeQuery("SELECT*FROM uji ORDER BY nik ASC");
                while (baris.next()){
                    System.out.println(baris.getString("nik")+" | "+
                            baris.getString("nama")+" | "+
                            baris.getString("no_telp")+" | "+
                            baris.getString("alamat"));
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        
    //TABLE PEGAWAI
public void simpanpegawai(String id_pegawai, String nama, String alamat, String telp) {
    // Validasi input
    if (id_pegawai == null || id_pegawai.isEmpty()) {
        System.err.println("ID Pegawai tidak boleh kosong");
    } else if (nama == null || nama.isEmpty()) {
        System.err.println("Nama tidak boleh kosong");
    } else if (alamat == null || alamat.isEmpty()) {
        System.err.println("Alamat tidak boleh kosong");
    } else if (telp == null || telp.isEmpty()) {
        System.err.println("Telepon tidak boleh kosong");
    } else {
        // Jika semua input valid, simpan data ke database
        try {
            String SQL = "INSERT INTO pegawai (id_pegawai, nama, alamat, telp) VALUES (?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, id_pegawai);
            perintah.setString(2, nama);
            perintah.setString(3, alamat);
            perintah.setString(4, telp);
            perintah.executeUpdate();
            System.out.println("Data berhasil disimpan");
        } catch (SQLException e) {
            System.err.println("Gagal Menyimpan Data: " + e.getMessage());
        }
    }
}

    public void ubahpegawai(String id_pegawai, String nama, String alamat, String telp) {
        try {
            String SQL = "UPDATE pegawai SET nama = ?, alamat = ?, telp = ? WHERE id_pegawai = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, nama);
            perintah.setString(2, alamat);
            perintah.setString(3, telp);
            perintah.setString(4, id_pegawai);
            perintah.executeUpdate();
            System.out.println("Data berhasil diubah");
        } catch (SQLException e) {
            System.err.println("Gagal Menyimpan Data: " + e.getMessage());
        }
    }

    public void hapuspegawai(String id_pegawai){
        try {
            String SQL = "DELETE FROM pegawai WHERE id_pegawai=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, id_pegawai);
            perintah.executeUpdate();
            System.out.println("Data berhasil dihapus");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void caripegawai(String id_pegawai){
        try {
            String SQL = "SELECT * FROM pegawai WHERE id_pegawai=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, id_pegawai);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID_PEGAWAI : " + data.getString("id_pegawai"));
                System.out.println("NAMA : " + data.getString("nama"));
                System.out.println("ALAMAT : " + data.getString("alamat"));
                System.out.println("NO_TELPON : " + data.getString("telp"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void datapegawai(){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM pegawai ORDER BY id_pegawai ASC");
            while (baris.next()){
                System.out.println(baris.getString("id_pegawai") + " | " +
                                   baris.getString("nama") + " | " +
                                   baris.getString("alamat") + " | " +
                                   baris.getString("telp"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    //TABLE PEMBELIAN
        public void simpanpembelian(String no_nota, String tanggal, String id_pegawai, String nama, int total_harga, int jumlah_bayar, int kembali) {
        try {
            String SQL = "INSERT INTO pembelian (no_nota, tanggal, id_pegawai, nama, total_harga, jumlah_bayar, kembali) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, no_nota);
            perintah.setString(2, tanggal);
            perintah.setString(3, id_pegawai);
            perintah.setString(4, nama);
            perintah.setInt(5, total_harga);
            perintah.setInt(6, jumlah_bayar);
            perintah.setInt(7, kembali);
            perintah.executeUpdate();
            System.out.println("Data berhasil disimpan");
        } catch (SQLException e) {
            System.err.println("Gagal Menyimpan Data: " + e.getMessage());
        }
    }

    public void ubahpembelian(String no_nota, String tanggal, String id_pegawai, String nama, int total_harga, int jumlah_bayar, int kembali) {
        try {
            String SQL = "UPDATE pembelian SET tanggal = ?, id_pegawai = ?, nama = ?, total_harga = ?, jumlah_bayar = ?, kembali = ? WHERE no_nota = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, tanggal);
            perintah.setString(2, id_pegawai);
            perintah.setString(3, nama);
            perintah.setInt(4, total_harga);
            perintah.setInt(5, jumlah_bayar);
            perintah.setInt(6, kembali);
            perintah.setString(7, no_nota);
            perintah.executeUpdate();
            System.out.println("Data berhasil diubah");
        } catch (SQLException e) {
            System.err.println("Gagal Menyimpan Data: " + e.getMessage());
        }
    }

    public void hapuspembelian(String no_nota) {
        try {
            String SQL = "DELETE FROM pembelian WHERE no_nota=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, no_nota);
            perintah.executeUpdate();
            System.out.println("Data berhasil dihapus");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void caripembelian(String no_nota) {
        try {
            String SQL = "SELECT * FROM pembelian WHERE no_nota=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, no_nota);
            ResultSet data = perintah.executeQuery();
            while(data.next()) {
                System.out.println("NO_NOTA: " + data.getString("no_nota"));
                System.out.println("TANGGAL: " + data.getString("tanggal"));
                System.out.println("ID_PEGAWAI: " + data.getString("id_pegawai"));
                System.out.println("NAMA: " + data.getString("nama"));
                System.out.println("TOTAL_HARGA: " + data.getString("total_harga"));
                System.out.println("JUMLAH_BAYAR: " + data.getString("jumlah_bayar"));
                System.out.println("KEMBALI: " + data.getString("kembali"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void datapembelian() {
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM pembelian ORDER BY no_nota ASC");
            while (baris.next()) {
                System.out.println(baris.getString("no_nota") + " | " +
                                   baris.getString("tanggal") + " | " +
                                   baris.getString("id_pegawai") + " | " +
                                   baris.getString("nama") + " | " +
                                   baris.getString("total_harga") + " | " +
                                   baris.getString("jumlah_bayar") + " | " +
                                   baris.getString("kembali"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    //TABLE PENJUALAN
    public void simpanpenjualan(String no_nota, String kode_produk, String rasa, int harga, int jumlah_beli, int jumlah_harga) {
        try {
            String SQL = "INSERT INTO penjualan (no_nota, kode_produk, rasa, harga, jumlah_beli, jumlah_harga) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, no_nota);
            perintah.setString(2, kode_produk);
            perintah.setString(3, rasa);
            perintah.setInt(4, harga);
            perintah.setInt(5, jumlah_beli);
            perintah.setInt(6, jumlah_harga);
            perintah.executeUpdate();
            System.out.println("Data berhasil disimpan");
        } catch (SQLException e) {
            System.err.println("Gagal Menyimpan Data: " + e.getMessage());
        }
    }

    public void ubahpenjualan(String no_nota, String kode_produk, String rasa, int harga, int jumlah_beli, int jumlah_harga) {
        try {
            String SQL = "UPDATE penjualan SET kode_produk  = ?, rasa = ?, harga = ?, jumlah_beli = ?, jumlah_harga = ? WHERE no_nota  = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, kode_produk);
            perintah.setString(2, rasa);
            perintah.setInt(3, harga);
            perintah.setInt(4, jumlah_beli);
            perintah.setInt(5, jumlah_harga);
            perintah.setString(6, no_nota);
            perintah.executeUpdate();
            System.out.println("Data berhasil diubah");
        } catch (SQLException e) {
            System.err.println("Gagal Menyimpan Data: " + e.getMessage());
        }
    }
    
    public void hapuspenjualan(String no_nota) {
        try {
            String SQL = "DELETE FROM penjualan WHERE no_nota=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, no_nota);
            perintah.executeUpdate();
            System.out.println("Data berhasil dihapus");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
     
    public void caripenjualan(String no_nota) {
        try {
            String SQL = "SELECT * FROM penjualan WHERE no_nota=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, no_nota);
            ResultSet data = perintah.executeQuery();
            while(data.next()) {
                System.out.println("NO_NOTA: " + data.getString("no_nota"));
                System.out.println("KODE_PRODUK : " + data.getString("kode_produk"));
                System.out.println("RASA : " + data.getString("rasa"));
                System.out.println("HARGA : " + data.getString("harga"));
                System.out.println("JUMLAH_BELI : " + data.getString("jumlah_beli"));
                System.out.println("JUMLAH_HARGA: " + data.getString("jumlah_harga"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
        
    public void datapenjualan() {
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM penjualan ORDER BY no_nota ASC");
            while (baris.next()) {
                System.out.println(baris.getString("no_nota") + " | " +
                                   baris.getString("kode_produk") + " | " +
                                   baris.getString("rasa") + " | " +
                                   baris.getString("harga") + " | " +
                                   baris.getString("jumlah_beli") + " | " +
                                   baris.getString("jumlah_harga"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    //TABLE STOK
    public void simpanstok(String kode_produk, String rasa, int harga, int stok) {
        try {
            String SQL = "INSERT INTO stok (kode_produk, rasa, harga, stok) VALUES (?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, kode_produk);
            perintah.setString(2, rasa);
            perintah.setInt(3, harga);
            perintah.setInt(4, stok);
            perintah.executeUpdate();
            System.out.println("Data berhasil disimpan");
        } catch (SQLException e) {
            System.err.println("Gagal Menyimpan Data: " + e.getMessage());
        }
    }
    
    public void ubahstok(String kode_produk, String rasa, int harga, int stok) {
        try {
            String SQL = "UPDATE stok SET rasa = ?, harga = ?, stok = ? WHERE kode_produk=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, rasa);
            perintah.setInt(2, harga);
            perintah.setInt(3, stok);
            perintah.setString(4, kode_produk);
            perintah.executeUpdate();
            System.out.println("Data berhasil diubah");
        } catch (SQLException e) {
            System.err.println("Gagal Menyimpan Data: " + e.getMessage());
        }
    }
    
    public void hapusstok(String kode_produk) {
        try {
            String SQL = "DELETE FROM stok WHERE kode_produk =?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, kode_produk);
            perintah.executeUpdate();
            System.out.println("Data berhasil dihapus");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void caristok(String kode_produk) {
        try {
            String SQL = "SELECT * FROM stok WHERE kode_produk=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, kode_produk);
            ResultSet data = perintah.executeQuery();
            while(data.next()) {
                System.out.println("KODE_PRODUK : " + data.getString("kode_produk"));
                System.out.println("RASA : " + data.getString("rasa"));
                System.out.println("HARGA : " + data.getString("harga"));
                System.out.println("STOK : " + data.getString("stok"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void datastok() {
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM stok ORDER BY kode_produk ASC");
            while (baris.next()) {
                System.out.println(baris.getString("kode_produk") + " | " +
                                   baris.getString("rasa") + " | " +
                                   baris.getString("harga") + " | " +
                                   baris.getString("stok"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
