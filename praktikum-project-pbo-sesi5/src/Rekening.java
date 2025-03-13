public class Rekening {
    protected String namaPemilik;
    protected String nomorRekening;
    protected double saldo;

    public Rekening(String namaPemilik, String nomorRekening, double saldo) {
        this.namaPemilik = namaPemilik;
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Overloading setor() - Versi 1: Setor tunai biasa
    public void setor(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Setoran tunai sebesar Rp" + jumlah + " berhasil.");
        } else {
            System.out.println("Jumlah setoran harus lebih dari 0.");
        }
    }

    // Overloading setor() - Versi 2: Setor melalui transfer
    public void setor(double jumlah, boolean transfer) {
        if (jumlah > 0) {
            saldo += jumlah;
            if (transfer) {
                System.out.println("Transfer sebesar Rp" + jumlah + " berhasil.");
            } else {
                System.out.println("Setoran tunai sebesar Rp" + jumlah + " berhasil.");
            }
        } else {
            System.out.println("Jumlah setoran harus lebih dari 0.");
        }
    }

    public void tarik(double jumlah) {
        if (jumlah > 0 && saldo >= jumlah) {
            saldo -= jumlah;
            System.out.println("Penarikan sebesar Rp" + jumlah + " berhasil.");
        } else {
            System.out.println("Saldo tidak mencukupi atau jumlah tidak valid.");
        }
    }

    public void tampilkanInfo() {
        System.out.println("\n===========================");
        System.out.println("Nama Pemilik  : " + namaPemilik);
        System.out.println("No. Rekening  : " + nomorRekening);
        System.out.println("Saldo Saat Ini: Rp" + saldo);
        System.out.println("===========================\n");
    }
}
