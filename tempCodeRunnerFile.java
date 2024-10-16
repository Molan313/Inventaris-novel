//memasukkan fungsi scanner
import java.util.InputMismatchException;
import java.util.Scanner;
public class jualBuku {
    
    public static void main(String[] args) {
        // memanggil fungsi scanner
        Scanner in = new Scanner (System.in);

        buku[] banyakbuku = null;
        int opsi;

        do{
            opsi = opsiMenu(in);
            eksekusiMenu(opsi, banyakbuku, in);
        }while(opsi != 0);

        in.close();
    }

    // fungsi untuk menampilkan menu
    public static int opsiMenu(Scanner in){
        int opsi = -1;
        do{
            try{
                System.out.println("1. Lihat Inventori Buku\n2. Tambahkan Buku\n3. Kurangi Buku\n4.Menghentikan status buku\n0.Keluar");
                opsi = in.nextInt();
    
                if( opsi > 4 || opsi < 0){
                    System.out.println("Masukkan input sesuai menu");
                }
        }
            catch(Exception e){
                System.err.println("Opsi yang dimasukkan harus berupa angka");
                in.next();
            }
        }while(opsi < 0 || opsi > 4 );

        return opsi;
    }

    // fungsi untuk mengeksekusi opsi menu
    public static void eksekusiMenu(int opsi, buku[] listbuku, Scanner in){
        switch (opsi) {
            case 1:
            if (listbuku == null || listbuku.length == 0) {
                System.out.println("List buku\n");
                displayBuku(listbuku);       
            }
            break;
            
            case 2: 
                System.out.println("Tambah jumlah buku\n");
                int maks = banyakBuku(in);
                if (maks > 0 ) {
                    listbuku = new buku[maks];
                    menambahBuku(listbuku, in);
                }
                else{
                    System.out.println("Tidak ada buku yang ditambahkan");
                }
                break;
            case 3:
                if(listbuku == null || listbuku.length == 0){
                    System.out.println("Tidak ada buku untuk dikurangi");
                }
                else{
                    System.out.println("Mengurangi jumlah buku\n");
                    mengurangiBuku(listbuku, in);
                }
                break;

            case 4:
            if (listbuku==null || listbuku.length == 0) {
                System.out.println("Tidak ada buku untuk dinonaktifkan");
            }
            else{
                System.out.println("Menonaktifkan buku\n");
                statusBuku(listbuku, in);
            }
            break;

            case 0:
                System.out.println("Anda telah keluar dari program");
            default:
                System.out.println("Opsi tidak valid");
        }
    }

    // fungsi untuk menampilkan index value dan nama produk yang akan diupdate
    public static int angkaBuku(buku[] banyakbuku, Scanner in){
        int pilihanBuku = -1;
        System.out.println("Pilih Buku yang ingin diperbarui\n");
        for( int i = 0; i < banyakbuku.length; i++){
            System.out.println((i+1) + ". " + banyakbuku[i].getNamaBuku());
        }

        do{
            try{
                System.out.println("Masukkan nomor buku (1 sampai )" + (banyakbuku.length) + "): ");
                pilihanBuku = in.nextInt();
                if(pilihanBuku < 1 || pilihanBuku > banyakbuku.length){
                    System.out.println("Masukkan angka yang valid");
                }
            }catch (Exception e ){
                System.err.println("Tipe data yang dimasukkan salah. Masukkan input angka yang benar ");
                in.next();
            }
        }while(pilihanBuku < 1 || pilihanBuku > banyakbuku.length);
        return pilihanBuku - 1;
    }
    
    // fungsi untuk menambah buku
    public static void menambahBuku(buku[] banyakbuku, Scanner in){
        int pilihanBuku;
        int updateNilai = -1;
        pilihanBuku = angkaBuku(banyakbuku, in);
        do{
            try{
                System.out.println("Berapa banyak buku yang ingin kamu tambahkan?\n");
                updateNilai = in.nextInt();
                if(updateNilai < 0){
                    System.out.println("Tambahan tidak boleh kurang dari 0");
                };
            }
            catch(Exception e){
                System.err.println("Tipe data salah. Masukkan input berupa angka");
            }
        }while(updateNilai < 0);

        banyakbuku[pilihanBuku].menambahBuku(updateNilai);
    }

    // fungsi untuk mengurangi buku
    public static void mengurangiBuku(buku[] banyakbuku, Scanner in){
        int pilihanBuku;
        int updateNilai = -1;
        pilihanBuku = angkaBuku(banyakbuku, in);
        do{
            try{
                System.out.println("Berapa banyak buku yang ingin kamu tambahkan?\n");
                updateNilai = in.nextInt();
                if(updateNilai < 0 || updateNilai > banyakbuku[pilihanBuku].getJumlahBuku()){
                    System.out.println("Pengurangan tidak boleh kurang dari 0 dan lebih dari banyak stok " + banyakbuku.length);
                };
            }
            catch(Exception e){
                System.err.println("Tipe data salah. Masukkan input berupa angka");
                in.next();
            }
        }while(updateNilai < 0);

        banyakbuku[pilihanBuku].mengurangiBuku(updateNilai);
    }

    // fungsi untuk menonaktifkan status
    public static void statusBuku(buku[] banyakbuku, Scanner in){
        int pilihanBuku = angkaBuku(banyakbuku, in);
        banyakbuku[pilihanBuku].setStatusBuku(false);
    }
    
    //fungsi untuk menampilkan informasi buku 
    public static void displayBuku(buku[] banyakbuku){
        System.out.println("\nInformasi buku: ");
        // for each loop
        for(buku b : banyakbuku){
            System.out.println(b + "\n");
        }
    }

    // fungsi untuk mengetahui banyak buku yang akan ditambahkan
    public static int banyakBuku(Scanner in){
        // memanggil loop yang akan muncul minimal satu kali, sampai angka yang diinputkan lebih atau sama dengan nol;
        int maks = -1;
        do{
            // menghandle error jika tipe data yang dimasukkan tidak sesuai
            try{
                System.out.println("Masukkan jumlah produk yang ingin ditambahkan\nInput 0 jika tidak ada penambahan buku");
                maks = in.nextInt();

                if(maks < 0){
                    System.out.println("Tidak menerima angka negatif");
                };
            }
            // mengambil error dan memberikan memberikan pesan kesalahan
            catch(InputMismatchException e){
                System.err.println("Tipe data yang dimasukkan salah. Input kembali menggunakan angka.");
                in.next();
            }
        }
        // terus menjalankan program sampai input adalah nol atau lebih
        while(maks < 0);
        return maks;

    }

    // fungsi untuk menambahkan buku
    public static void menambahBuku(int maks, Scanner in, buku[] banyakbuku){
        // input data produk sampai jumlah maks
        for (int i = 0; i < maks; i++){
            in.nextLine(); //membersihkan buffer
            int jumlah = 0;
            float harga = 0;
            boolean status = false;
            System.out.println("Masukkan Nomor Buku ke " + (i+1) + ": ");
            String nomor = in.nextLine();

            System.out.println("Masukkan Nama Buku ke " + (i+1) + ": "); 
            String nama = in.nextLine();

            while(true){
                try{
                    System.out.println("Masukkan Jumlah Buku ke " + (i+1) + ": ");
                    jumlah = in.nextInt();
                    break;
                }
                catch(Exception e){
                    System.err.println("Tipe data yang dimasukkan salah. Input kembali menggunakan angka.");
                    in.next();
                }
            }

            while(true){
                try{
                    System.out.println("Masukkan Harga Buku ke " + (i+1) + ": ");
                    harga = in.nextFloat();
                    break;
                }
                catch(Exception e){
                    System.err.println("Tipe data yang anda masukkan salah. Input kembali menggunakan angka.");
                    in.next();
                }
            }

            while(true){
                try{
                    System.out.println("Status buku ke " + (i+1) + "(gunakan true/false): ");
                    status = in.nextBoolean();
                    break;
                }
                catch(Exception e){
                    System.err.println("Tipe data yang dimasukkan salah. Input kembali menggunakan kata true jika buku masih aktif atau kata false jika buku sudah tidak aktif.");
                    in.next();
                }
            }
            // data baru masuk
            banyakbuku[i] = new buku(nomor, nama, jumlah, harga, status);
        } 
    }


}
