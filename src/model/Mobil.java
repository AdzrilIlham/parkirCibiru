package model;

public class Mobil extends Kendaraan {

    public Mobil(String platNomor) {

        super(platNomor, "Mobil");
    }

    @Override
    public double hitungBiaya(int jam) {

        return jam * 5000;
    }
}