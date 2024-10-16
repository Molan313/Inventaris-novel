// mengimpot format desimal
import java.text.DecimalFormat;
// membuat kelas buku yang menyimpan atribut buku
public class buku{
        private String nomorBuku;
        private String namaBuku;
        private int jumlahBuku;
        private float hargaBuku;
        private boolean statusBuku = true;
        private static final DecimalFormat df = new DecimalFormat("#,###.00");

    // metode pemanggilan kelas
    buku(){
    }

    // masukan
    buku (String nomor, String nama, int jumlah, float harga, boolean status){
        this.nomorBuku = nomor;
        this.namaBuku = nama;
        this.jumlahBuku = jumlah;
        this.hargaBuku = harga;
        this.statusBuku = status;

    }


    public String getNomorBuku(){
        return nomorBuku;
    }

    public void setNomorBuku(String nomor){
        this.nomorBuku = nomor;
    }

    public String getNamaBuku(){
        return namaBuku;
    }

    public void setNamaBuku(String nama){
        this.namaBuku = nama;
    }

    public int getJumlahBuku(){
        return jumlahBuku;
    }

    public void setJumlahBuku(int jumlah){
        this.jumlahBuku = jumlah;
    }

    public float getHargaBuku(){
        return hargaBuku;
    }

    public void setHargaBuku(float harga){
        this.hargaBuku = harga;
    }

    public double getNilaiBuku(float harga, float jumlah){
        return hargaBuku * jumlahBuku;
    };

    public boolean getStatusBuku(){
        return statusBuku;
    }

    public void setStatusBuku(boolean status){
        this.statusBuku = status;
    }

    public void menambahBuku(int quantity){
        if(quantity > 0){
            jumlahBuku += quantity;
            System.out.println(quantity + " buku telah ditambahkan ke dalam stok\nJumlah stok " + jumlahBuku);
        }
        else{
            System.err.println("Jumlah buku harus lebih dari 0");
        }
    }

    public void mengurangiBuku(int quantity){
        if(quantity > 0){
            if(quantity <= jumlahBuku){
                jumlahBuku -= quantity;
                System.out.println(quantity + " buku telah dikurangi dari stok\nJumlah stok " + jumlahBuku);
            }
            else{
                System.err.println("Jumlah buku lebih sedikit daripada jumlah yang akan dikurangi, jumlah stok " + jumlahBuku);
            }
        }
        else{
            System.err.println("Jumlah buku harus lebih dari 0");
        }
    }
    // mengubah data ke dalam bentuk string
    @Override
    public String toString(){
        // menginisialisasikan string kosong
        String buku = "";
        // mengupdate status buku
        String status = getStatusBuku()?"Aktif":"Tidak Aktif";
        buku = "Nomor buku\t: " + getNomorBuku() + "\n" + "Nama buku\t: " + getNamaBuku() + "\n" + "Jumlah buku\t: " + getJumlahBuku() + "\n" + "Harga Buku\t: Rp " + df.format(getHargaBuku()) + "\n" + "Nilai Buku\t: Rp " + df.format(getNilaiBuku(hargaBuku, jumlahBuku)) + "\n" + "Status Buku\t: " + status ;
        return buku;
    };

}