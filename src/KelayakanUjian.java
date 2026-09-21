import java.util.Scanner;

public class KelayakanUjian {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Kehadiran (%)   : ");
        int kehadiran = input.nextInt();
        System.out.print("Nilai tugas     : ");
        int nilaiTugas = input.nextInt();
        System.out.print("Dispensasi      : ");
        boolean dispensasi = input.nextBoolean();

        boolean a = kehadiran >= 75 && nilaiTugas >= 60 || dispensasi;
        boolean b = (kehadiran >= 75 && nilaiTugas >= 60) || dispensasi;
        boolean c = kehadiran >= 75 && (nilaiTugas >= 60 || dispensasi);

        /*
         * HASIL PERBANDINGAN:
         * Versi yang sama dengan a adalah b. Versi c berbeda dari a.
         *
         * KESIMPULAN: operator && punya precedence lebih tinggi daripada ||,
         * jadi Java membaca a sebagai (kehadiran >= 75 && nilaiTugas >= 60)
         * || dispensasi, persis seperti b. Pada c, kurung menggeser urutan
         * sehingga || dihitung lebih dulu dan hasilnya bisa berbeda, misalnya
         * pada kehadiran 60, nilai tugas 80, dispensasi true:
         * a = true, b = true, c = false.
         */

        boolean tidakDispensasi = !dispensasi;

        System.out.println();
        System.out.println("a (tanpa kurung)      : " + a);
        System.out.println("b (kurung precedence) : " + b);
        System.out.println("c (kurung digeser)    : " + c);
        System.out.println("!dispensasi           : " + tidakDispensasi);

        input.close();
    }
}