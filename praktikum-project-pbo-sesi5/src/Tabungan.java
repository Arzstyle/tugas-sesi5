public class Tabungan extends Rekening {
    double bungaTahunan;
    
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

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("Bunga Tahunan: %.2f%%%n", this.bungaTahunan);
        System.out.println("Bunga Tahunan: " + this.bungaTahunan + "%");
    }
    
    public void hitungBunga(int bulan) {
        this.bungaTahunan = this.bungaTahunan / 12 * getSaldo(0) * bulan;
    }
}

