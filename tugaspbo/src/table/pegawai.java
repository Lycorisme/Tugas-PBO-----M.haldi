package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class pegawai {

    private String databaseName = "2210010283_m_haldi";
    private String username = "root";
    private String password = "";
    private String lokasi = "jdbc:mysql://localhost/" + databaseName;
    public static Connection koneksiDB;

    public pegawai() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(lokasi, username, password);
            System.out.println("Database Terkoneksi");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Koneksi Gagal: " + e.getMessage());
        }
    }

    public void simpanpegawai(String id_pegawai, String nama, String alamat, String telp) {
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
}
