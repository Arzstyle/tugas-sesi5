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
