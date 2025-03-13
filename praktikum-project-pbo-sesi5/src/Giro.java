public class Giro extends Rekening {
    double limitPenarikan;

    public Giro(String namaPemilik, String nomorRekening, double saldo) {
        super(namaPemilik, nomorRekening, saldo);
    }

    public double getLimitPenarikan() {
        return limitPenarikan;
    }

    public void setLimitPenarikan(double limitPenarikan) {
        this.limitPenarikan = limitPenarikan;
    }

    public void Setor(double jumlahSetor) {
        super.addSetor(jumlahSetor);
    }

    public void Setor(double jumlahSetor, boolean transfer) {
        super.addSetor(jumlahSetor);
        if (transfer == true) {
            super.addTarik(jumlahSetor);
        }
    }
 
    public double addTarik(double jumlahTarik) {
        if (jumlahTarik <= this.limitPenarikan) {
            super.addTarik(jumlahTarik);
        }
                return jumlahTarik;
    }
}
