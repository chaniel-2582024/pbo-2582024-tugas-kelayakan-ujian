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

        // Bukti short-circuit
        int cek = 0;
        boolean x = (kehadiran >= 75) && (cek++ >= 0);
        boolean y = (nilaiTugas >= 60) || (cek++ >= 0);

        /*
         * PENJELASAN cek:
         * Pada input contoh (kehadiran 60, nilai tugas 80) nilai cek tetap 0.
         * Pada x, sisi kiri (kehadiran >= 75) bernilai false, jadi && sudah
         * pasti false dan sisi kanan (cek++ >= 0) tidak pernah dievaluasi.
         * Pada y, sisi kiri (nilaiTugas >= 60) bernilai true, jadi || sudah
         * pasti true dan sisi kanan juga dilewati. Karena cek++ tidak jalan
         * sama sekali, cek berakhir di 0. Itulah short-circuit evaluation.
         */

        System.out.println();
        System.out.println("a (tanpa kurung)      : " + a);
        System.out.println("b (kurung precedence) : " + b);
        System.out.println("c (kurung digeser)    : " + c);
        System.out.println("!dispensasi           : " + tidakDispensasi);
        System.out.println("cek dipanggil         : " + cek);

        input.close();
    }
}