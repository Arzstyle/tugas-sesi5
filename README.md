# 📚 Dokumentasi Praktikum OOP: Studi Kasus Rekening Bank

## 📖 Daftar Isi
1. [Main.java](#-mainjava)
2. [Rekening.java](#-rekeningjava)
3. [Tabungan.java](#-tabunganjava)
4. [Giro.java](#-girojava)
5. [Referensi](#-referensi)

---

## 🚀 Main.java

### 📝 Penjelasan
`Main.java` adalah kelas utama yang berfungsi sebagai antarmuka pengguna untuk mengelola rekening bank. Program ini memungkinkan pengguna untuk memilih jenis rekening (Tabungan atau Giro) dan melakukan berbagai transaksi seperti setor tunai, transfer, tarik tunai, dan menampilkan informasi rekening.

#### 📝 Penjelasan Detail `Main.java`
Kelas Main merupakan titik masuk (entry point) dari program. Program dimulai dengan menampilkan pilihan jenis rekening kepada pengguna, yaitu Tabungan atau Giro. Setelah pengguna memilih, program meminta nomor rekening dan saldo awal. Selanjutnya, program membuat objek dari kelas Tabungan atau Giro sesuai dengan pilihan pengguna. Program kemudian menampilkan menu transaksi yang terdiri dari setor tunai, transfer, tarik tunai, dan menampilkan informasi rekening. Pengguna dapat memilih opsi ini dalam sebuah perulangan, memungkinkan mereka melakukan berbagai transaksi hingga memilih keluar dari program.


### 💻 Contoh Kode
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Selamat Datang di Aplikasi Rekening ===");

        System.out.println("Pilih jenis rekening: ");
        System.out.println("1. Tabungan (Pemilik: Akbar)");
        System.out.println("2. Giro (Pemilik: Sechan Dokoni)");
        System.out.print("Masukkan pilihan (1/2): ");
        int pilihan = input.nextInt();

        String namaPemilik;
        String noRek;
        Rekening rekening;

        if (pilihan == 1) {
            namaPemilik = "Akbar";
            System.out.print("Masukkan nomor rekening: ");
            noRek = input.next();
            System.out.print("Masukkan saldo awal: Rp");
            double saldo = input.nextDouble();
            rekening = new Rekening(namaPemilik, noRek, saldo);
        } else if (pilihan == 2) {
            namaPemilik = "Sechan Dokoni";
            System.out.print("Masukkan nomor rekening: ");
            noRek = input.next();
            System.out.print("Masukkan saldo awal: Rp");
            double saldo = input.nextDouble();
            rekening = new Rekening(namaPemilik, noRek, saldo);
        } else {
            System.out.println("Pilihan tidak valid!");
            input.close();
            return;
        }

        while (true) {
            System.out.println("\n=== MENU TRANSAKSI ===");
            System.out.println("1. Setor Tunai");
            System.out.println("2. Transfer");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Tampilkan Info Rekening");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan (1-5): ");
            int menu = input.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan jumlah setoran: Rp");
                    double setorTunai = input.nextDouble();
                    rekening.setor(setorTunai);
                    break;
                case 2:
                    System.out.print("Masukkan jumlah transfer: Rp");
                    double setorTransfer = input.nextDouble();
                    System.out.print("Apakah transfer dari rekening lain? (true/false): ");
                    boolean dariRekLain = input.nextBoolean();
                    rekening.setor(setorTransfer, dariRekLain);
                    break;
                case 3:
                    System.out.print("Masukkan jumlah penarikan: Rp");
                    double tarik = input.nextDouble();
                    rekening.tarik(tarik);
                    break;
                case 4:
                    rekening.tampilkanInfo();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    input.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
```

[🔙 Kembali ke Daftar Isi](#-daftar-isi)

---

## 🚀 Rekening.java

### 📝 Penjelasan
`Rekening.java` adalah kelas dasar yang merepresentasikan rekening bank. Kelas ini memiliki atribut seperti `namaPemilik`, `noRekening`, dan `saldo`. Metode yang tersedia meliputi `setor`, `tarik`, dan `tampilkanInfo`.

#### 📝 Penjelasan Detail `Rekening.java`
Kelas Rekening berfungsi sebagai kelas induk (superclass) yang mendefinisikan atribut dasar sebuah rekening, seperti nama pemilik, nomor rekening, dan saldo. Kelas ini memiliki beberapa metode utama:

setor(double jumlah) → Menambahkan saldo sesuai dengan jumlah setoran.
setor(double jumlah, boolean transfer) → Memungkinkan setor melalui transfer dengan biaya administrasi Rp2500 jika dari rekening lain.
tarik(double jumlah) → Mengurangi saldo jika jumlah penarikan valid. Jika saldo tidak mencukupi, transaksi gagal.
tampilkanInfo() → Menampilkan informasi rekening seperti nama pemilik, nomor rekening, dan saldo terkini.
Kelas ini bersifat general, sehingga dapat diwarisi oleh kelas lain seperti Tabungan dan Giro.


### 💻 Contoh Kode
```java
public class Rekening {
    protected String namaPemilik;
    protected String noRekening;
    protected double saldo;

    public Rekening(String namaPemilik, String noRekening, double saldo) {
        this.namaPemilik = namaPemilik;
        this.noRekening = noRekening;
        this.saldo = saldo;
    }

    public void setor(double jumlah) {
        saldo += jumlah;
        System.out.println("Setoran berhasil! Saldo sekarang: Rp" + saldo);
    }

    // Overloading setor() untuk transfer
    public void setor(double jumlah, boolean dariRekeningLain) {
        if (dariRekeningLain) {
            double biayaAdmin = 2500;
            if (jumlah > biayaAdmin) {
                saldo += (jumlah - biayaAdmin); 
                System.out.println("Transfer diterima dari rekening lain!");
                System.out.println("Biaya admin Rp 2.500 dipotong. Saldo sekarang: Rp" + saldo);
            } else {
                System.out.println("Transfer gagal! Jumlah tidak mencukupi setelah dipotong biaya admin.");
            }
        } else {
            saldo += jumlah;
            System.out.println("Transfer berhasil! Saldo sekarang: Rp" + saldo);
        }
    }

    public void tarik(double jumlah) {
        if (jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Penarikan berhasil! Saldo sekarang: Rp" + saldo);
        } else {
            System.out.println("Penarikan gagal! Saldo tidak mencukupi.");
        }
    }

    public void tampilkanInfo() {
        System.out.println("\n=== Informasi Rekening ===");
        System.out.println("Nama Pemilik  : " + namaPemilik);
        System.out.println("No. Rekening  : " + noRekening);
        System.out.println("Saldo         : Rp" + saldo);
    }
}
```

[🔙 Kembali ke Daftar Isi](#-daftar-isi)

---

## 🚀 Tabungan.java

### 📝 Penjelasan
`Tabungan.java` adalah kelas turunan dari `Rekening` yang menambahkan fitur bunga tahunan. Kelas ini memiliki metode `hitungBunga` untuk menghitung bunga berdasarkan jumlah bulan tertentu.

#### 📝 Penjelasan Detail `Tabungan.java`
Kelas Tabungan merupakan turunan dari Rekening dan menambahkan fitur khusus berupa bunga sebesar 2% pada setiap setoran.

Konstruktor Tabungan → Menerima data pemilik, nomor rekening, dan saldo awal, lalu meneruskannya ke kelas induk Rekening.
Override setor(double jumlah) → Metode ini ditingkatkan dengan menambahkan bunga 2% pada setiap setoran. Jika pengguna menyetor Rp1.000.000, maka ia akan mendapatkan bonus bunga Rp20.000, sehingga saldo bertambah Rp1.020.000.
Metode lainnya, seperti tarik tunai dan tampilkan info, diwarisi langsung dari Rekening tanpa perubahan.

### 💻 Contoh Kode
```java
public class Tabungan extends Rekening {
    private double bungaTahunan;

    public Tabungan(String namaPemilik, String nomorRekening, double saldo, double bungaTahunan) {
        super(namaPemilik, nomorRekening, saldo);
        this.bungaTahunan = bungaTahunan;
    }

    public double getBungaTahunan() {
        return bungaTahunan;
    }

    public void setBungaTahunan(double bungaTahunan) {
        this.bungaTahunan = bungaTahunan;
    }

    public void hitungBunga(int bulan) {
        double bunga = (bungaTahunan / 12) * saldo * bulan;
        System.out.println("Bunga setelah " + bulan + " bulan: Rp" + bunga);
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Bunga Tahunan: " + bungaTahunan + "%");
        System.out.println("===========================\n");
    }
}
```

[🔙 Kembali ke Daftar Isi](#-daftar-isi)

---

## 🚀 Giro.java

### 📝 Penjelasan
`Giro.java` adalah kelas turunan dari `Rekening` yang menambahkan fitur limit penarikan. Kelas ini meng-override metode `tarik` untuk memastikan bahwa penarikan tidak melebihi limit yang ditentukan.

#### 📝 Penjelasan Detail `Giro.java`
Kelas Giro juga merupakan turunan dari Rekening, namun memiliki batasan khusus dalam transaksi penarikan.

Konstruktor Giro → Menerima parameter seperti nama pemilik, nomor rekening, dan saldo awal, lalu meneruskannya ke Rekening.
Override tarik(double jumlah) → Dibandingkan dengan rekening biasa, rekening giro memiliki batas maksimum penarikan sebesar Rp5.000.000 (atau menyesuaikan.) Jika pengguna mencoba menarik lebih dari batas tersebut, transaksi akan gagal.
Metode lainnya seperti setor tunai, transfer, dan tampilkan info tetap mengikuti aturan yang ada di Rekening.


### 💻 Contoh Kode
```java
public class Giro extends Rekening {
    private double limitPenarikan;

    public Giro(String namaPemilik, String nomorRekening, double saldo, double limitPenarikan) {
        super(namaPemilik, nomorRekening, saldo);
        this.limitPenarikan = limitPenarikan;
    }

    public double getLimitPenarikan() {
        return limitPenarikan;
    }

    public void setLimitPenarikan(double limitPenarikan) {
        this.limitPenarikan = limitPenarikan;
    }

    @Override
    public void tarik(double jumlah) {
        if (jumlah > 0 && jumlah <= limitPenarikan && saldo >= jumlah) {
            saldo -= jumlah;
            System.out.println("Penarikan sebesar Rp" + jumlah + " berhasil.");
        } else {
            System.out.println("Penarikan gagal! Melebihi limit atau saldo tidak cukup.");
        }
    }
}
```

[🔙 Kembali ke Daftar Isi](#-daftar-isi)

---

## 📚 Referensi
- [Java Documentation](https://docs.oracle.com/javase/tutorial/java/concepts/)
- [OOP Concepts in Java](https://www.geeksforgeeks.org/object-oriented-programming-oops-concept-in-java/)

[🔙 Kembali ke Daftar Isi](#-daftar-isi)
