package QLCF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author black zetsu
 */
public class ThucDon {
    private String tenDoUong;
    private float gia;

    public ThucDon() {
    }

    public ThucDon(String tenDoUong, float gia) {
        
        this.tenDoUong = tenDoUong;
        this.gia = gia;
    }

    public String getTenDoUong() {
        return tenDoUong;
    }

    public void setTenDoUong(String tenDoUong) {
        this.tenDoUong = tenDoUong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
    @Override
    public String toString() {
        return " *Tên= " + tenDoUong + " *giá= " + gia;
    }
    public void nhapThucDon(){
        System.out.println("Nhập tên đồ uống:");
        this.setTenDoUong(new Scanner(System.in).nextLine());
        System.out.println("Nhập giá đồ uống:");
        this.setGia(new Scanner(System.in).nextInt());
    }
    public static int thucdon=0;
     public ArrayList<String> listtd0 = new ArrayList<>();
    public void ghifiletd(){
         try
            {
                File f = new File("ThucDon.txt");
                FileReader fr = new FileReader(f); 
                BufferedReader br = new BufferedReader(fr); 
                String line ;
                while((line = br.readLine())!= null) 
                {
                    System.out.println(line);
                    listtd0.add(line);
                }
                    thucdon=0;
                    fr.close();
                    br.close();
                } catch (IOException ex) {
                    System.out.println("File rỗng");
                    thucdon=1;
        }
        BufferedWriter bf = null;  
        int luuVitri=1;
        try {
            bf = new BufferedWriter(new FileWriter("ThucDon.txt",true)); 
                
                String line="";
                if(listtd0.size()==0){
                  ThucDon td = new ThucDon();
                  td.nhapThucDon();
                  line = td.toString();
                  bf.write(line);
                  System.out.println("Lưu thành công đồ uống mới");
                  bf.newLine(); 
                } else{
                    while (luuVitri!=-1){
                    ThucDon td = new ThucDon();
                    td.nhapThucDon();
                    line = td.toString();
                    for (int i = 0; i < listtd0.size(); i++) {
                            if(listtd0.get(i).indexOf(td.getTenDoUong())!=-1){
                                luuVitri=i;
                                System.out.println("Đã tồn tại đồ uống tên  "+td.getTenDoUong()+" trong menu");
                                break;
                            } else luuVitri=-1;
                        }
                    } 
                    bf.write(line);
                    System.out.println("Lưu thành công đồ uống mới");
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
    public static ArrayList<String> listtd2 = new ArrayList<>();
    public void docfiletd(){
        listtd2.clear();
    try
            {
                File f = new File("ThucDon.txt");
                FileReader fr = new FileReader(f); 
                BufferedReader br = new BufferedReader(fr); 
                String line ;
                while((line = br.readLine())!= null) 
                {
                    System.out.println(line);
                    listtd2.add(line);
                }
                    thucdon=0;
                    fr.close();
                    br.close();
                } catch (IOException ex) {
                    System.out.println("File rỗng");
                    thucdon=1;
        }
    }
    public ArrayList<String> listtd1 = new ArrayList<>();
    public void SuaTĐ (String ten){
	        String luuTen="";
                int luuGia=0;
                int luuvitri=-1;
		 try
                {
                    File f = new File("ThucDon.txt");
                    FileReader fr = new FileReader(f); 
                    BufferedReader br = new BufferedReader(fr); 
                    String line ;
                    while((line = br.readLine())!= null) 
                    {
                        listtd1.add(line);
                    }
                    
                    for (int i = 0; i < listtd1.size(); i++) {
                        if(listtd1.get(i).indexOf("Tên= "+String.valueOf(ten))!=-1){
                            luuvitri=i;
                            break;
                        }
                    }
                    if(luuvitri>-1){
                     System.out.println("Thông tin đồ uống có tên="+ten+" trước khi sửa: "+listtd1.get(luuvitri));
                        System.out.println("Sửa đồ uống có tên="+(ten));
                        System.out.print("Nhập Tên đồ uống cần sửa lại:");
                        luuTen = new Scanner(System.in).nextLine();
                        System.out.print("Nhập giá cần sửa:");
                        luuGia =  new Scanner(System.in).nextInt();
                        System.out.println("");
                        line =" *Tên= "+luuTen+" *giá= "+String.valueOf(luuGia);
                        listtd1.set(luuvitri, line);
                        System.out.println("Thông tin đồ uống có tên="+ten+" sau khi sửa: "+listtd1.get(luuvitri));
                        BufferedWriter bf = null;  
                        try {
                            bf = new BufferedWriter(new FileWriter("ThucDon.txt")); 
                                for (int i = 0; i < listtd1.size(); i++) {
                                  bf.write(listtd1.get(i));
                                  bf.newLine(); 

                            }
                            System.out.println("Lưu thành công đồ uống"); 
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

                    } else System.out.println("Không tồn tại tên đồ uống đã nhập");
                   fr.close();
                   br.close();    
                } catch (IOException ex) {
                    System.out.println("Lỗi đọc file : "+ex);
                   }
    }
    public ArrayList<String> listtd = new ArrayList<>();
    public void XoaTĐ (String ten){
        String luutdXoa="";
        int luuvitri=-1;
		 try
                {
                    File f = new File("ThucDon.txt");
                    FileReader fr = new FileReader(f); 
                    BufferedReader br = new BufferedReader(fr); 
                    String line ;
                    while((line = br.readLine())!= null) 
                    {
                        listtd.add(line);
                    }
                    for (int i = 0; i < listtd.size(); i++) {
                        if(listtd.get(i).indexOf("Tên= "+ten)!=-1){
                            luuvitri=i;
                        }
                    }
                    if(luuvitri>-1){
                       luutdXoa = listtd.get(luuvitri);
                       listtd.remove(luuvitri);
                       System.out.println("Xóa thành công đồ uống: " + luutdXoa);
                    } else System.out.println("Không tồn tại tên đồ uống đã nhập");
                        fr.close();
                        br.close();
                } catch (IOException ex) {
                    System.out.println("Lỗi đọc file : "+ex);
                   }
                 BufferedWriter bf = null;  
        try {
            bf = new BufferedWriter(new FileWriter("ThucDon.txt")); 
                for (int i = 0; i < listtd.size(); i++) {
                  bf.write(listtd.get(i));
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

