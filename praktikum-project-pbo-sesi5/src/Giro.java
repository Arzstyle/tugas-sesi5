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
