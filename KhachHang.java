package QLCF;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author black zetsu
 */
public class KhachHang implements Serializable {
    private int maKH;
    private String HoTen;

    public KhachHang() {
    }

    public KhachHang(int maKH, String HoTen) {
        this.maKH = maKH;
        this.HoTen = HoTen;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    @Override
    public String toString() {
        return "$" + maKH + "$" + HoTen;
    }
    public void NhapKhachHang(){
        System.out.println("Nhập mã khách hàng:");
        this.setMaKH(new Scanner(System.in).nextInt());
        System.out.println("Nhập tên khách hàng:");
        this.setHoTen(new Scanner(System.in).nextLine());
    }
}
