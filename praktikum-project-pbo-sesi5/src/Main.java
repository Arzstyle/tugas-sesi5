// import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        System.out.println("Selamat datang di Aplikasi Rekening Tohir");

        Rekening Tabungan = new Tabungan("Akbar", "123456", 0, 0.5);
        System.out.println("Setor Tabungan : " + Tabungan.addSetor(200));
        System.out.println("Tarik Tabungan : " + Tabungan.getSaldo(100));
        Tabungan.tampilkanInfo();
        System.out.println("Jenis Rekening : Tabungan");

        // Rekening Giro = new Giro("Akbar", "123456", 0);
        // System.out.println("Setor Giro : " + Giro.addSetor(200));  
        // System.out.println("Tarik Giro : " + Giro.getSaldo(100));
        // Giro.tampilkanInfo();
        // System.out.println("Jenis Giro : Giro");


    }
    
}
