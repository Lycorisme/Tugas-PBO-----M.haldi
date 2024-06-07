package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class penjualan {
    
    private String databaseName = "2210010283_m_haldi";
    private String username = "root";
    private String password = "";
    private String lokasi = "jdbc:mysql://localhost/" + databaseName;
    public static Connection koneksiDB;

    public penjualan() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(lokasi, username, password);
            System.out.println("Database Terkoneksi");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Koneksi Gagal: " + e.getMessage());
        }
    }
    
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
        
}