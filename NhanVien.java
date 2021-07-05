package QLCF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author black zetsu
 */
public class NhanVien {
    private int maNV;
    private String tenNV;
    private String sdt;
    private int mucLuong;
    public static int trangthai=0;
//    public ArrayList<String> listnv = new ArrayList<>();
    public NhanVien() {
    }

    public NhanVien(int maNV, String tenNV, String sdt, int mucLuong) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.sdt = sdt;
        this.mucLuong = mucLuong;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getMucLuong() {
        return mucLuong;
    }

    public void setMucLuong(int mucLuong) {
        this.mucLuong = mucLuong;
    }

    @Override
    public String toString() {
        return " *Mã NV=" + maNV + " *Tên NV=" + tenNV + " *SĐT=" + sdt + " *Mức lương=" + mucLuong;
    }
    public void nhapNhanVien(){
        System.out.print("Nhập Mã NV=");
        this.setMaNV(new Scanner(System.in).nextInt());
        System.out.print("Nhập Tên NV=");
        this.setTenNV(new Scanner(System.in).nextLine());
        System.out.print("Nhập SĐT=");
        this.setSdt(new Scanner(System.in).nextLine());
        System.out.print("Nhập Mức lương=");
        this.setMucLuong(new Scanner(System.in).nextInt());
        System.out.println("");
    }
    public ArrayList<String> listnv0 = new ArrayList<>();
    public void ghifilenv(){
         try
            {
                File f = new File("NhanVien.txt");
                FileReader fr = new FileReader(f); 
                BufferedReader br = new BufferedReader(fr); 
                String line ;
                while((line = br.readLine())!= null) 
                {
                    System.out.println(line);
                    listnv0.add(line);
                }
                    trangthai=0;
                    fr.close();
                    br.close();
                } catch (IOException ex) {
                    System.out.println("File rỗng");
                    trangthai=1;
        }
        BufferedWriter bf = null;  
        int luuVitri=-1;
        try {
            bf = new BufferedWriter(new FileWriter("NhanVien.txt",true)); 
                NhanVien nv = new NhanVien();
                String line="";
                if(listnv0.size()==0){
                    nv.nhapNhanVien();
                    line = nv.toString();
                    bf.write(line);
                    System.out.println("Lưu thành công nhân viên");
                    bf.newLine();
                } else{
                    do{
                    nv.nhapNhanVien();
                    line = nv.toString();
                    String[] ma=line.split("\\*");
                    System.out.println(ma[1]);
                    for (int i = 0; i < listnv0.size(); i++) {
                            if(listnv0.get(i).indexOf(ma[1])!=-1){
                                luuVitri=i;
                                System.out.println("Đã tồn tại mã NV");
                                break;
                            } else luuVitri=-1;
                        }
                    } while (luuVitri>=0);
                    bf.write(line);
                    System.out.println("Lưu thành công nhân viên");
                    bf.newLine(); 
                }
                
        } catch (Exception e) 
        {
            e.printStackTrace(); 
        }
        finally
        {
            try {
                bf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    }
     public ArrayList<String> listnv2 = new ArrayList<>();
     
    public void docfileSV()
    {
        try
            {
                File f = new File("NhanVien.txt");
                FileReader fr = new FileReader(f); 
                BufferedReader br = new BufferedReader(fr); 
                String line ;
                while((line = br.readLine())!= null) 
                {
                    System.out.println(line);
                }
                    trangthai=0;
                    fr.close();
                    br.close();
                } catch (IOException ex) {
                    System.out.println("File rỗng");
                    trangthai=1;
        }
    }
    public void SuaNV (int id){
	        String luuHoTen="";
                String luuSdt="";
                int luuMucLuong=0;
                int luuvitri=-1;
		 try
                {
                    File f = new File("NhanVien.txt");
                    FileReader fr = new FileReader(f); 
                    BufferedReader br = new BufferedReader(fr); 
                    String line ;
                    while((line = br.readLine())!= null) 
                    {
                        listnv2.add(line);
                    }
                    for (int i = 0; i < listnv2.size(); i++) {
                        if(listnv2.get(i).indexOf("Mã NV="+String.valueOf(id))!=-1){
                            luuvitri=i;
                            break;
                        }
                    }
                    if(luuvitri>-1){
                     System.out.println("Thông tin nhân viên có mã nhân viên="+id+" trước khi sửa: "+listnv2.get(luuvitri));
                        System.out.println("Sửa nhân viên có mã nhân viên="+(id));
                        System.out.print("Nhập Tên NV cần sửa:");
                        luuHoTen = new Scanner(System.in).nextLine();
                        System.out.print("Nhập SĐT cần sửa:");
                        luuSdt = new Scanner(System.in).nextLine();
                        System.out.print("Nhập mức lương cần sửa:");
                        luuMucLuong =  new Scanner(System.in).nextInt();
                        System.out.println("");
                        line =" *Mã NV="+String.valueOf(id)+" *Tên NV="+luuHoTen+" *SĐT="+luuSdt+" *Mức lương="+String.valueOf(luuMucLuong);
                        listnv2.set(luuvitri, line);
                        System.out.println("Thông tin nhân viên có mã nhân viên= "+id+" sau khi sửa là: "+listnv2.get(luuvitri));
                        BufferedWriter bf = null;  
                        try {
                            bf = new BufferedWriter(new FileWriter("NhanVien.txt")); 
                                for (int i = 0; i < listnv2.size(); i++) {
                                  bf.write(listnv2.get(i));
                                  bf.newLine(); 
                            }
                            System.out.println("Lưu thành công nhân viên");  
                        } catch (Exception e) 
                        {
                            e.printStackTrace(); 
                        }
                        finally
                        {
                            try {
                                bf.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } 
                    } else System.out.println("Không tồn tại mã NV đã nhập");
                   fr.close();
                   br.close();    
                } catch (IOException ex) {
                    System.out.println("Lỗi đọc file : "+ex);
                   }
    }
    ArrayList<String> listnv = new ArrayList<>();
    public void XoaNV (int id){
        String luunvXoa="";
        int luuvitri=-1;
		 try
                {
                    File f = new File("NhanVien.txt");
                    FileReader fr = new FileReader(f); 
                    BufferedReader br = new BufferedReader(fr); 
                    String line ;
                    while((line = br.readLine())!= null) 
                    {
                        listnv.add(line);
                    }
                    for (int i = 0; i < listnv.size(); i++) {
                        if(listnv.get(i).indexOf("Mã NV="+String.valueOf(id))!=-1){
                            luuvitri=i;
                        }
                    }
                    if(luuvitri>0){
                       luunvXoa = listnv.get(luuvitri);
                       listnv.remove(luuvitri);
                       System.out.println("Xóa thành công nhân viên: " + luunvXoa);
                    } else System.out.println("Không tồn tại mã NV đã nhập");
                        fr.close();
                        br.close();
                } catch (IOException ex) {
                    System.out.println("Lỗi đọc file : "+ex);
                   }
                 BufferedWriter bf = null;  
        try {
            bf = new BufferedWriter(new FileWriter("NhanVien.txt")); 
                for (int i = 0; i < listnv.size(); i++) {
                  bf.write(listnv.get(i));
                  bf.newLine(); 
            }
               
        } catch (Exception e) 
        {
            System.out.println("Lỗi đọc file : "+e);
        }
        finally
        {
            try {
                bf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }
}
