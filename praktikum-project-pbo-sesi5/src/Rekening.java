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
        System.out.println("Setoran berhasil! Saldo sekarang: Rp: " + saldo);
    }

    // Overloading setor() untuk transfer
    public void setor(double jumlah, boolean dariRekeningLain) {
        if (dariRekeningLain) {
            double biayaAdmin = 2500;
            if (jumlah > biayaAdmin) {
                saldo += (jumlah - biayaAdmin); 
                System.out.println("Transfer diterima dari rekening lain!");
                System.out.println("Biaya admin Rp 2.500 dipotong. Saldo sekarang: Rp: " + saldo);
            } else {
                System.out.println("Transfer gagal! Jumlah tidak mencukupi setelah dipotong biaya admin.");
            }
        } else {
            saldo += jumlah;
            System.out.println("Transfer berhasil! Saldo sekarang: Rp: " + saldo);
        }
    }

    public void tarik(double jumlah) {
        if (jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Penarikan berhasil! Saldo sekarang: Rp: " + saldo);
        } else {
            System.out.println("Penarikan gagal! Saldo tidak mencukupi.");
        }
    }

    public void tampilkanInfo() {
        System.out.println("\n=== Informasi Rekening ===");
        System.out.println("Nama Pemilik  : " + namaPemilik);
        System.out.println("No. Rekening  : " + noRekening);
        System.out.println("Saldo         : Rp: " + saldo);
    }
}
