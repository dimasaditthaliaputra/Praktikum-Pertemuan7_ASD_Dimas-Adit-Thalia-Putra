import java.util.Scanner;

public class MahasiswaDemo06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumMhs = sc.nextInt();
        sc.nextLine();
        MahasiswaBerprestasi06 list = new MahasiswaBerprestasi06(jumMhs);

        for (int i = 0; i < jumMhs; i++) {
            System.out.println("Masukkan Data Mahasiswa ke-" + (i + 1));
            System.out.print("Masukan NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Masukan Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Masukan Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("Masukan IPK   : ");
            String ip = sc.nextLine();
            Double ipk = Double.parseDouble(ip);
            System.out.println("-----------------------------");

            list.tambah(new Mahasiswa06(nim, nama, kelas, ipk));
        }

        list.tampil();
        // melakukan pencarian data sequential
        // System.out.println("------------------------------------------");
        // System.out.println("Pencarian Data");
        // System.out.println("------------------------------------------");
        // System.out.println("masukan ipk mahasiswa yang dicari: ");
        // System.out.print("IPK: ");
        // double cari = sc.nextDouble();

        // System.out.println("Menggunakan sequential searching");
        // double posisi = list.sequentialSearching(cari);
        // int pss = (int)posisi;
        // list.tampilPosisi(cari, pss);
        // list.tampilDataSearch(cari, pss);

        // melakukan pencarian data Binary
        System.out.println("------------------------------------------");
        System.out.println("Pencarian Data");
        System.out.println("------------------------------------------");
        System.out.println("masukan ipk mahasiswa yang dicari: ");
        System.out.print("IPK: ");
        double cari2 = sc.nextDouble();
        System.out.println("------------------------------------------");
        System.out.println("Menggunakan binary search");
        System.out.println("------------------------------------------");
        double posisi2 = list.sequentialSearching(cari2);
        int pss2 = (int)posisi2;
        list.tampilPosisi(cari2, pss2);
        list.tampilDataSearch(cari2, pss2);
    }
}