import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Selamat Datang di Aplikasi Rekening Tohir ===");

        System.out.println("Pilih jenis rekening: ");
        System.out.println("1. Tabungan (Pemilik: Akbar)");
        System.out.println("2. Giro (Pemilik: Sechan Dokoni)");
        System.out.print("Masukkan pilihan (1/2): ");
        int pilihan = input.nextInt();

        String namaPemilik;
        String noRek;
        Rekening rekening;

        if (pilihan == 1) {
            namaPemilik = "Andi";
            System.out.print("Masukkan nomor rekening: ");
            noRek = input.next();
            System.out.print("Masukkan saldo awal: Rp: ");
            double saldo = input.nextDouble();
            rekening = new Rekening(namaPemilik, noRek, saldo);
        } else if (pilihan == 2) {
            namaPemilik = "Budi";
            System.out.print("Masukkan nomor rekening: ");
            noRek = input.next();
            System.out.print("Masukkan saldo awal: Rp: ");
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
                    System.out.print("Masukkan jumlah setoran: Rp: ");
                    double setorTunai = input.nextDouble();
                    rekening.setor(setorTunai);
                    break;
                case 2:
                    System.out.print("Masukkan jumlah transfer: Rp: ");
                    double setorTransfer = input.nextDouble();
                    System.out.print("Apakah transfer dari rekening lain? (true/false): ");
                    boolean dariRekLain = input.nextBoolean();
                    rekening.setor(setorTransfer, dariRekLain);
                    break;
                case 3:
                    System.out.print("Masukkan jumlah penarikan: Rp: ");
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