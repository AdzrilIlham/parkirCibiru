# 🚗 Sistem Parkiran Cibiru
## Aplikasi Desktop Manajemen Parkir Menggunakan Java Swing & MySQL

![Java](https://img.shields.io/badge/Java-Swing-orange)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue)
![NetBeans](https://img.shields.io/badge/IDE-NetBeans-green)

---

# 📖 Deskripsi Project

Sistem Parkiran Cibiru merupakan aplikasi desktop berbasis Java Swing yang dirancang untuk membantu proses pengelolaan parkir kendaraan secara digital, otomatis, dan realtime.

Project ini dibuat sebagai implementasi pembelajaran pemrograman desktop menggunakan Java Swing yang terhubung dengan database MySQL menggunakan JDBC.

Aplikasi mampu mengelola kendaraan masuk dan keluar, menentukan slot parkir otomatis, menyimpan data transaksi kendaraan, menghitung durasi parkir, serta menghitung total biaya parkir berdasarkan lama kendaraan berada di area parkir.

Sistem juga dirancang agar data kendaraan tetap tersimpan walaupun aplikasi ditutup atau dijalankan kembali. Dengan demikian, status slot parkir akan tetap sinkron dengan database dan kondisi parkiran sebelumnya.

Project ini dikembangkan sebagai simulasi sistem parkir modern yang sering digunakan pada area kampus, pusat perbelanjaan, maupun area publik lainnya.

---

# 🎯 Tujuan Project

Tujuan dibuatnya project ini adalah:

- Mengimplementasikan konsep CRUD menggunakan Java
- Mempelajari koneksi Java dengan MySQL menggunakan JDBC
- Mengembangkan aplikasi desktop berbasis Java Swing
- Memahami pengelolaan data realtime
- Mengelola transaksi kendaraan parkir
- Menerapkan sistem slot parkir otomatis
- Mengembangkan kemampuan problem solving dan teamwork

---

# ✨ Fitur Utama Sistem

## 🚘 Kendaraan Masuk
- Input plat nomor kendaraan
- Pemilihan jenis kendaraan
- Sistem pencarian slot kosong otomatis
- Slot berubah warna menjadi merah saat terisi
- Data kendaraan otomatis tampil pada JTable
- Data kendaraan tersimpan ke database MySQL
- Waktu masuk tercatat otomatis

---

## 🚗 Kendaraan Keluar
- Kendaraan dipilih melalui JTable
- Plat nomor otomatis masuk ke form
- Waktu keluar tercatat otomatis
- Slot kembali tersedia dan berubah warna hijau
- Data kendaraan aktif otomatis dihapus dari JTable
- Total biaya parkir dihitung otomatis

---

## ⏱ Sistem Perhitungan Durasi
- Menggunakan LocalDateTime
- Menggunakan Duration
- Menghitung selisih waktu masuk dan keluar kendaraan
- Durasi parkir dihitung berdasarkan jam

---

## 💰 Sistem Tarif Parkir

### Motor
- Tarif awal : Rp2.000
- Tarif per jam : Rp1.000

### Mobil
- Tarif awal : Rp5.000
- Tarif per jam : Rp2.000

---

## 🗄 Database MySQL

Sistem menggunakan database MySQL untuk:
- Menyimpan transaksi kendaraan
- Menyimpan waktu masuk dan keluar
- Menyimpan total biaya parkir
- Menyimpan status kendaraan aktif

---

# 🧠 Konsep Pemrograman Yang Digunakan

Project ini menerapkan beberapa konsep pemrograman seperti:

- Java Swing GUI
- JDBC Connection
- CRUD Database
- Event Handling
- JTable Management
- Array Slot Management
- State Management
- Object Oriented Programming (OOP)
- LocalDateTime & Duration

---

# 🖥 Teknologi Yang Digunakan

| Teknologi | Fungsi |
|---|---|
| Java | Bahasa Pemrograman |
| Java Swing | GUI Desktop |
| MySQL | Database |
| JDBC | Koneksi Java ke Database |
| NetBeans | IDE Pengembangan |

---

# 🗂 Struktur Database

## Database : `spvs`

## Tabel : `transaksi`

| Field | Tipe Data |
|---|---|
| id | INT |
| plat_nomor | VARCHAR |
| jenis | VARCHAR |
| slot | VARCHAR |
| waktu_masuk | DATETIME |
| waktu_keluar | DATETIME |
| tarif_perjam | INT |
| total_biaya | INT |

# 👨‍💻 Tim Pengembang

Project Sistem Parkiran Cibiru dikembangkan oleh:

| No | Nama | NIM |
|---|---|---|
| 1 | Adzril Ilham Ramadhan | 2401263 |
| 2 | Rasya Fadil Arfiano | 2400447 |
| 3 | Moch. Yussar Rizky | 2403195 |
| 4 | Salsabila Restu Adriani | 2402950 |
| 5 | Dzaky Alfiansyah Ramdhani | 2400615 |

---

# 🔄 Flow Sistem

## 🚘 Kendaraan Masuk

```text
Input Plat Nomor
↓
Pilih Jenis Kendaraan
↓
Cari Slot Kosong
↓
Simpan Data ke Database
↓
Slot Berubah Merah
↓
Data Tampil di JTable
