import java.text.DecimalFormat;

public class product {
    // instance field declaration
    private String nomorBuku;
    private String namaBuku;
    private int jumlahBuku;
    private float hargaBuku;
    private boolean statusBuku = true;
    private static final DecimalFormat df = new DecimalFormat("#,###.00");

    product(){
    }

    product (String nomor, String nama, int jumlah, float harga){
        this.nomorBuku = nomor;
        this.namaBuku = nama;
        this.jumlahBuku = jumlah;
        this.hargaBuku = harga;
    }

// untuk mendapatkan nomorbuku, namabuku, jumlahbuku dan hargabuku

    public boolean getStatusProduk(){
        return statusBuku;
    }

    public void setStatusProduk(boolean status){
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

    public double getNilaiBuku(float jumlah, float harga){
        return jumlahBuku * hargaBuku;
    }

    public String toString(){
        String p1 = "";
        String status = getStatusProduk()?"Aktif":"Tidak Aktif";
        p1 = "Nomor Buku \t: " + getNomorBuku() + "\n"
            + "Nama Buku \t: " + getNamaBuku() + "\n"
            + "Jumlah Buku \t: " + getJumlahBuku() + "\n"
            + "Harga Buku \t: Rp" + df.format(getHargaBuku()) + "\n"
            + "Status Produk \t: " + status + "\n"
            + "Nilai Buku \t: Rp" + df.format(getNilaiBuku(jumlahBuku,hargaBuku)) + "\n";
        return p1;
    }
}