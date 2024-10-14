// memanggil fungsi scanner
import java.util.Scanner;
public class inventori {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // memanggil kelas produk dan mengisi datanya, pakai KELAS nama = NEW KELAS(isi data)
        product p1 = new product("TL1", "Bumi", 200, 95000);
        product p2 = new product("TL2", "Pulang", 100, 80000);
        product p3 = new product();
        p3.setNomorBuku("TL3");
        p3.setNamaBuku("Negeri di Ujung Tanduk");
        p3.setJumlahBuku(150);
        p3.setHargaBuku(96000);
        
        product p4 = new product();
        p4.setNomorBuku("TL4");
        p4.setNamaBuku("Hujan");
        p4.setJumlahBuku(230);
        p4.setHargaBuku(78000);

        product p5 = new product();
        p5.setNomorBuku("AF1");
        p5.setNamaBuku("Negeri 5 Menara");
        p5.setJumlahBuku(100);
        p5.setHargaBuku(60000);

        product p6 = new product();
        p6.setNomorBuku("SH1");
        p6.setNamaBuku("Sherlock Holmes");
        p6.setJumlahBuku(200);
        p6.setHargaBuku(102000);

        System.out.println("Masukkan Nomor Buku ");
        String Nomor = in.nextLine();
        System.out.println("Masukkan Nama Buku ");
        String Nama = in.nextLine();
        System.out.println("Masukkan Jumlah Buku ");
        int Jumlah = in.nextInt();
        System.out.println("Masukkan Harga Buku ");
        float Harga = in.nextFloat();
        in.close();
        product p7 = new product(Nomor, Nama, Jumlah, Harga);


        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);

    }
}