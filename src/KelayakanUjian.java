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

        System.out.println();
        System.out.println("a (tanpa kurung)      : " + a);
        System.out.println("b (kurung precedence) : " + b);
        System.out.println("c (kurung digeser)    : " + c);

        input.close();
    }
}