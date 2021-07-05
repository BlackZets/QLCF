package QLCF;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author black zetsu
 */
public class HoaDon {
    private float TongTien;

    public HoaDon() {
    }

    public HoaDon(float TongTien, boolean daThanhToan) {
        this.TongTien = TongTien;
    }
    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    ThucDon td = new ThucDon();
    @Override
    public String toString() {
        return hoaDon;
    }
    public static float tong= 0; 
    String hoaDon="";
    public void nhapHoaDon(){
        ThucDon td = new ThucDon();
        System.out.println("-------Menu------");
        td.docfiletd();
        System.out.println("Chọn đồ uống:");
        for (int i = 0; i < td.listtd2.size(); i++) {
            System.out.println(i+"-"+td.listtd2.get(i));
        }
        String luuDoUong = td.listtd2.get(new Scanner(System.in).nextInt());
        String luuGia[]= luuDoUong.split("\\ ");
        System.out.println("Chọn: "+luuGia[2]+" với giá mỗi ly: "+luuGia[4]);
        Float gia=Float.valueOf(luuGia[4]);
        System.out.println("Nhập số lượng:");
        int soluong=new Scanner(System.in).nextInt();
        System.out.println("Tổng tiền:");
        this.setTongTien(gia*soluong);
        System.out.println(getTongTien());
        tong+=getTongTien();
        hoaDon="-- Hóa đơn: "+soluong+" cốc "+ luuGia[2]+" *"+gia+" = "+this.getTongTien();

    }
    public static void main(String[] args) {
        HoaDon hd = new HoaDon();
        hd.nhapHoaDon();
    }
}
