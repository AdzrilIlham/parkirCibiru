package model;

public class Motor extends Kendaraan {

    public Motor(String platNomor) {

        super(platNomor, "Motor");
    }

    @Override
    public double hitungBiaya(int jam) {

        return jam * 3000;
    }
}