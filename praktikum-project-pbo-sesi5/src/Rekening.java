public class Rekening {
    String namaPemilik;
    String nomorRekening;
    double saldo;
    
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
        return;
    }
    public double getSaldo(int i) {
        this.saldo -= i;
        return saldo;
    }
    public double setSaldo(double saldo) {
        this.saldo = saldo;
        return this.saldo;
    }

    public double addSetor(double jumlahSetor) {
        this.saldo += jumlahSetor;
        return this.saldo;
    }

    public double addTarik(double jumlahTarik) {
        this.saldo -= jumlahTarik;
        return this.saldo;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Pemilik: " + this.namaPemilik);
        System.out.println("Nomor Rekening: " + this.nomorRekening);
        System.out.println("Saldo saat ini: " + this.saldo);
    }
}
