//memasukkan fungsi scanner
import java.util.Scanner;
public class jualBuku {
    
    public static void main(String[] args) {
        // memanggil fungsi scanner
        Scanner in = new Scanner (System.in);
        // menginisialkan maks atau jumlah produk yang ingin ditambahkan dengan -1
        int maks = -1;
        // memanggil loop yang akan muncul minimal satu kali, sampai angka yang diinputkan lebih atau sama dengan nol;
        do{
            // menghandle error jika tipe data yang dimasukkan tidak sesuai
            try{
                System.out.println("Masukkan jumlah produk yang ingin di tambahkan\nInput 0 jika tidak ingin menambah produk ");
                maks = in.nextInt();

                if(maks < 0){
                    System.err.println("Tidak menerima angka negatif");
                };
            }
            catch(Exception e){
                System.err.println("Tipe data yang dimasukkan salah. Input kembali.");
                in.next();
            }
        }
        while(maks < 0);
        // apabila angka yang diinputkan adalah nol
        if(maks == 0){
            System.out.println("Tidak ada buku yang ditambahkan. ");
        }
        // membuat array yang menyimpan data, yang ukurannya sebanyak maks
        buku[] buku = new buku[maks];
        // input data produk sampai jumlah maks
        for (int i = 0; i < maks; i++){
            in.nextLine(); //membersihkan buffer
            System.out.println("Masukkan nomor Buku ke " + (i+1) + ": ");
            String nomor = in.nextLine();

            System.out.println("Masukkan Nama Buku ke " + (i+1) + ": "); 
            String nama = in.nextLine();

            System.out.println("Masukkan jumlah buku ke " + (i+1) + ": ");
            int jumlah = in.nextInt();

            System.out.println("Masukkan harga buku ke " + (i+1) + ": ");
            float harga = in.nextFloat();

            System.out.println("Status buku ke " + (i+1) + "(true/false): ");
            boolean status = in.nextBoolean();
            // data baru masuk
            buku[i] = new buku(nomor, nama, jumlah, harga, status);
        } 
        // menutup fungsi scanner
        in.close();
        // menampilkan informasi buku
        System.out.println("Informasi buku: ");
        for(buku b : buku){
            System.out.println(b + "\n");
        }

    }
}
