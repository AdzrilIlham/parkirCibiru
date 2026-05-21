package model;

public class SlotParkir {

    private int idSlot;
    private boolean status;

    private Kendaraan kendaraan;

    public SlotParkir(int idSlot) {

        this.idSlot = idSlot;
        this.status = false;
    }

    public int getIdSlot() {
        return idSlot;
    }

    public boolean isStatus() {
        return status;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void isiSlot(
            Kendaraan kendaraan
    ) {

        this.kendaraan = kendaraan;
        this.status = true;
    }

    public void kosongkan() {

        kendaraan = null;
        status = false;
    }
}