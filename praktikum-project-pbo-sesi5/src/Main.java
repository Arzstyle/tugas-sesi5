public class Main {
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("Selamat datang di Aplikasi Rekening Tohir");
        System.out.println("=====================================\n");


        Tabungan tabungan = new Tabungan("Akbar", "123456", 0, 5.0);
        tabungan.setor(200000);
        tabungan.tarik(100000);
        tabungan.tampilkanInfo();
        tabungan.hitungBunga(6);

        Giro giro = new Giro("Akbar", "654321", 0, 500000);
        giro.setor(250000, true);
        giro.tarik(200000);
        giro.tampilkanInfo();
    }
}
