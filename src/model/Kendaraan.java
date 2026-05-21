package model;

import java.time.LocalDateTime;

public class Kendaraan {

    protected String platNomor;
    protected String jenis;
    protected LocalDateTime waktuMasuk;

    public Kendaraan(
            String platNomor,
            String jenis
    ) {

        this.platNomor = platNomor;
        this.jenis = jenis;

        this.waktuMasuk =
                LocalDateTime.now();
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public String getJenis() {
        return jenis;
    }

    public LocalDateTime getWaktuMasuk() {
        return waktuMasuk;
    }

    public double hitungBiaya(int jam) {
        return 0;
    }
}