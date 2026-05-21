package view;

import controller.ParkirController;
import model.SlotParkir;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;

public class Dashboard2 extends JFrame {

    // =====================================================
    // CONTROLLER
    // =====================================================

    private ParkirController controller =
            new ParkirController();

    // =====================================================
    // KOMPONEN
    // =====================================================

    private JTextField tfPlat;

    private JComboBox<String> cbJenis;

    private JTable table;

    private DefaultTableModel tableModel;

    private JLabel[] labelSlot =
            new JLabel[10];

    private JLabel lblTotalKendaraan;

    private JLabel lblTotalPemasukan;

    private int totalKendaraan = 0;

    private double totalPemasukan = 0;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public Dashboard2() {

        setTitle(
                "Smart Parking Visual System"
        );

        setSize(1200, 720);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                EXIT_ON_CLOSE
        );

        setLayout(
                new BorderLayout(12, 12)
        );

        getContentPane().setBackground(
                new Color(24, 24, 24)
        );

        // =================================================
        // PANEL KIRI
        // =================================================

        JPanel panelKiri =
                new JPanel(
                        new BorderLayout(10, 10)
                );

        panelKiri.setPreferredSize(
                new Dimension(340, 0)
        );

        panelKiri.setBorder(
                new EmptyBorder(10, 10, 10, 5)
        );

        panelKiri.setBackground(
                new Color(24, 24, 24)
        );

        panelKiri.add(
                buatFormPanel(),
                BorderLayout.NORTH
        );

        panelKiri.add(
                buatSlotPanel(),
                BorderLayout.CENTER
        );

        panelKiri.add(
                buatStatistikPanel(),
                BorderLayout.SOUTH
        );

        // =================================================
        // PANEL KANAN
        // =================================================

        JPanel panelKanan =
                new JPanel(
                        new BorderLayout(10, 10)
                );

        panelKanan.setBorder(
                new EmptyBorder(10, 5, 10, 10)
        );

        panelKanan.setBackground(
                new Color(24, 24, 24)
        );

        JLabel lblTitle =
                new JLabel(
                        "📋 Riwayat Transaksi"
                );

        lblTitle.setForeground(
                Color.WHITE
        );

        lblTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20
                )
        );

        panelKanan.add(
                lblTitle,
                BorderLayout.NORTH
        );

        panelKanan.add(
                buatTabelPanel(),
                BorderLayout.CENTER
        );

        // =================================================
        // ADD PANEL
        // =================================================

        add(panelKiri, BorderLayout.WEST);

        add(panelKanan, BorderLayout.CENTER);

        setVisible(true);
    }

    // =====================================================
    // FORM PANEL
    // =====================================================

    private JPanel buatFormPanel() {

        JPanel panel =
                new JPanel();

        panel.setLayout(
                new GridLayout(0, 1, 8, 8)
        );

        panel.setBackground(
                new Color(35, 35, 35)
        );

        panel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                new Color(70, 70, 70)
                        ),
                        "🚗 Input Kendaraan"
                )
        );

        // =================================================
        // INPUT
        // =================================================

        JLabel lblPlat =
                new JLabel("Plat Nomor");

        lblPlat.setForeground(
                Color.WHITE
        );

        tfPlat = new JTextField();

        JLabel lblJenis =
                new JLabel("Jenis Kendaraan");

        lblJenis.setForeground(
                Color.WHITE
        );

        cbJenis =
                new JComboBox<>(
                        new String[]{
                                "Mobil",
                                "Motor"
                        }
                );

        // =================================================
        // BUTTON
        // =================================================

        JButton btnMasuk =
                new JButton("Masuk");

        JButton btnKeluar =
                new JButton("Keluar");

        JButton btnReset =
                new JButton("Reset");

        // WARNA BUTTON

        btnMasuk.setBackground(
                new Color(40, 167, 69)
        );

        btnMasuk.setForeground(
                Color.WHITE
        );

        btnKeluar.setBackground(
                new Color(220, 53, 69)
        );

        btnKeluar.setForeground(
                Color.WHITE
        );

        btnReset.setBackground(
                new Color(108, 117, 125)
        );

        btnReset.setForeground(
                Color.WHITE
        );

        // =================================================
        // EVENT BUTTON
        // =================================================

        // MASUK

        btnMasuk.addActionListener(e -> {

            aksiMasuk();

        });

        // KELUAR

        btnKeluar.addActionListener(e -> {

            aksiKeluar();

        });

        // RESET

        btnReset.addActionListener(e -> {

            tfPlat.setText("");

            cbJenis.setSelectedIndex(0);

        });

        JPanel panelButton =
                new JPanel(
                        new GridLayout(1, 3, 8, 0)
                );

        panelButton.setBackground(
                new Color(35, 35, 35)
        );

        panelButton.add(btnMasuk);

        panelButton.add(btnKeluar);

        panelButton.add(btnReset);

        // =================================================
        // ADD COMPONENT
        // =================================================

        panel.add(lblPlat);

        panel.add(tfPlat);

        panel.add(lblJenis);

        panel.add(cbJenis);

        panel.add(panelButton);

        return panel;
    }

    // =====================================================
    // SLOT PANEL
    // =====================================================

    private JPanel buatSlotPanel() {

        JPanel panel =
                new JPanel(
                        new GridLayout(2, 5, 10, 10)
                );

        panel.setBackground(
                new Color(35, 35, 35)
        );

        panel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                new Color(70, 70, 70)
                        ),
                        "🅿️ Area Parkir"
                )
        );

        for (int i = 0; i < 10; i++) {

            labelSlot[i] =
                    new JLabel(
                            "S" + (i + 1),
                            SwingConstants.CENTER
                    );

            labelSlot[i].setOpaque(true);

            labelSlot[i].setBackground(
                    new Color(40, 167, 69)
            );

            labelSlot[i].setForeground(
                    Color.WHITE
            );

            labelSlot[i].setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            16
                    )
            );

            labelSlot[i].setBorder(
                    BorderFactory.createLineBorder(
                            new Color(90, 90, 90),
                            2
                    )
            );

            panel.add(labelSlot[i]);
        }

        return panel;
    }

    // =====================================================
    // STATISTIK PANEL
    // =====================================================

    private JPanel buatStatistikPanel() {

        JPanel panel =
                new JPanel(
                        new GridLayout(2, 1, 5, 5)
                );

        panel.setBackground(
                new Color(35, 35, 35)
        );

        panel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                new Color(70, 70, 70)
                        ),
                        "📊 Statistik"
                )
        );

        lblTotalKendaraan =
                new JLabel(
                        "Total Kendaraan : 0"
                );

        lblTotalPemasukan =
                new JLabel(
                        "Total Pemasukan : Rp 0"
                );

        lblTotalKendaraan.setForeground(
                Color.WHITE
        );

        lblTotalPemasukan.setForeground(
                Color.WHITE
        );

        panel.add(lblTotalKendaraan);

        panel.add(lblTotalPemasukan);

        return panel;
    }

    // =====================================================
    // TABEL PANEL
    // =====================================================

    private JScrollPane buatTabelPanel() {

        String[] kolom = {
                "Plat",
                "Jenis",
                "Slot",
                "Biaya"
        };

        tableModel =
                new DefaultTableModel(
                        kolom,
                        0
                );

        table =
                new JTable(tableModel);

        table.setRowHeight(30);

        JScrollPane scrollPane =
                new JScrollPane(table);

        return scrollPane;
    }

    // =====================================================
    // AKSI MASUK
    // =====================================================

    private void aksiMasuk() {

        String plat =
                tfPlat.getText().trim();

        String jenis =
                cbJenis.getSelectedItem()
                        .toString();

        if (plat.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Plat nomor wajib diisi!"
            );

            return;
        }

        String hasil =
                controller.kendaraanMasuk(
                        plat,
                        jenis
                );

        JOptionPane.showMessageDialog(
                this,
                hasil
        );

        refreshSlot();

        totalKendaraan++;

        lblTotalKendaraan.setText(
                "Total Kendaraan : "
                        + totalKendaraan
        );

        tfPlat.setText("");
    }

    // =====================================================
    // AKSI KELUAR
    // =====================================================

    private void aksiKeluar() {

        String input =
                JOptionPane.showInputDialog(
                        this,
                        "Masukkan nomor slot:"
                );

        if (input == null) {

            return;
        }

        int slot =
                Integer.parseInt(input);

        String hasil =
                controller.kendaraanKeluar(
                        slot
                );

        JOptionPane.showMessageDialog(
                this,
                hasil
        );

        totalPemasukan += 10000;

        lblTotalPemasukan.setText(
                "Total Pemasukan : Rp "
                        + totalPemasukan
        );

        refreshSlot();
    }

    // =====================================================
    // REFRESH SLOT
    // =====================================================

    private void refreshSlot() {

        ArrayList<SlotParkir> slots =
                controller.getDaftarSlot();

        for (int i = 0; i < 10; i++) {

            if (slots.get(i).isStatus()) {

                labelSlot[i].setBackground(
                        new Color(220, 53, 69)
                );

                labelSlot[i].setText(
                        "🚗\nS" + (i + 1)
                );

            } else {

                labelSlot[i].setBackground(
                        new Color(40, 167, 69)
                );

                labelSlot[i].setText(
                        "S" + (i + 1)
                );
            }
        }
    }

    // =====================================================
    // MAIN
    // =====================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new Dashboard2();

        });

    }
}