package controller;


import database.Koneksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.*;

import java.util.ArrayList;

public class ParkirController {

    private ArrayList<SlotParkir>
            daftarSlot = new ArrayList<>();

    public ParkirController() {

        for (int i = 1; i <= 10; i++) {

            daftarSlot.add(
                    new SlotParkir(i)
            );
        }
    }

    public ArrayList<SlotParkir>
    getDaftarSlot() {

        return daftarSlot;
    }

    // =====================================================
    // KENDARAAN MASUK
    // =====================================================

    public String kendaraanMasuk(
        String plat,
        String jenis
) {

    Kendaraan kendaraan;

    if (jenis.equals("Mobil")) {

        kendaraan = new Mobil(plat);

    } else {

        kendaraan = new Motor(plat);
    }

    for (SlotParkir slot : daftarSlot) {

        if (!slot.isStatus()) {

            slot.isiSlot(kendaraan);

            // =========================================
            // SIMPAN KE DATABASE
            // =========================================

            try {

                Connection conn =
                        Koneksi.getConnection();

                String sql =
                        "INSERT INTO transaksi "
                                + "(plat_nomor, jenis, slot, waktu_masuk) "
                                + "VALUES (?, ?, ?, NOW())";

                PreparedStatement ps =
                        conn.prepareStatement(sql);

                ps.setString(1, plat);

                ps.setString(2, jenis);

                ps.setString(
                        3,
                        "S" + slot.getIdSlot()
                );

                ps.executeUpdate();

            } catch (Exception e) {

                e.printStackTrace();
            }

            return "Kendaraan masuk ke Slot S"
                    + slot.getIdSlot();
        }
    }

    return "Parkir penuh!";
}

    // =====================================================
    // KENDARAAN KELUAR
    // =====================================================

    public String kendaraanKeluar(
        int idSlot
) {

    SlotParkir slot =
            daftarSlot.get(idSlot - 1);

    if (!slot.isStatus()) {

        return "Slot kosong!";
    }

    Kendaraan kendaraan =
            slot.getKendaraan();

    double biaya =
            kendaraan.hitungBiaya(2);

    // =========================================
    // UPDATE DATABASE
    // =========================================

    try {

        Connection conn =
                Koneksi.getConnection();

        String sql =
                "UPDATE transaksi "
                        + "SET waktu_keluar = NOW(), "
                        + "total_biaya = ? "
                        + "WHERE plat_nomor = ? "
                        + "AND waktu_keluar IS NULL";

        PreparedStatement ps =
                conn.prepareStatement(sql);

        ps.setDouble(1, biaya);

        ps.setString(
                2,
                kendaraan.getPlatNomor()
        );

        ps.executeUpdate();

    } catch (Exception e) {

        e.printStackTrace();
    }

    String hasil =
            "===== STRUK ====="
                    + "\nPlat : "
                    + kendaraan.getPlatNomor()
                    + "\nJenis : "
                    + kendaraan.getJenis()
                    + "\nBiaya : Rp "
                    + biaya
                    + "\n================";

    slot.kosongkan();

    return hasil;
}
}