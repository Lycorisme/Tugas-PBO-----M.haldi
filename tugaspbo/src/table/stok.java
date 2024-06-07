package CRUD;

import static CRUD.penjualan.koneksiDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class stok{
    
    private String databaseName = "2210010283_m_haldi";
    private String username = "root";
    private String password = "";
    private String lokasi = "jdbc:mysql://localhost/" + databaseName;
    public static Connection koneksiDB;

    public stok() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(lokasi, username, password);
            System.out.println("Database Terkoneksi");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Koneksi Gagal: " + e.getMessage());
        }
    }
    
    
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
    
    public void caripenjualan(String kode_produk) {
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
    
    public void datapenjualan() {
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