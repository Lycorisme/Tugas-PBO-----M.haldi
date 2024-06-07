package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class pembelian {

    private String databaseName = "2210010283_m_haldi";
    private String username = "root";
    private String password = "";
    private String lokasi = "jdbc:mysql://localhost/" + databaseName;
    public static Connection koneksiDB;

    public pembelian() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(lokasi, username, password);
            System.out.println("Database Terkoneksi");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Koneksi Gagal: " + e.getMessage());
        }
    }

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
}
