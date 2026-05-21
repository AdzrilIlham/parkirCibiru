package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    private static Connection koneksi;

    public static Connection getConnection() {

        try {

            if (koneksi == null) {

                String url =
                        "jdbc:mysql://localhost:3306/spvs";

                String user = "root";
                String pass = "";

                koneksi =
                        DriverManager.getConnection(
                                url,
                                user,
                                pass
                        );

                System.out.println(
                        "Koneksi Database Berhasil"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Koneksi Database Gagal"
            );

            e.printStackTrace();
        }

        return koneksi;
    }
}