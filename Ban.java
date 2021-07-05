package QLCF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author black zetsu
 */
public class Ban {
    private int stt;
    private int soGhe;
    private String trangThai;

    public Ban() {
    }

    public Ban(int stt, int soGhe, String trangThai) {
        this.stt = stt;
        this.trangThai = trangThai;
    }
    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    HoaDon hd = new HoaDon();
    
    @Override
    public String toString() {
        if(this.getTrangThai()=="Có khách"){
         return " STT= " + stt + " Số ghế= " + soGhe + " Trạng thái= " + trangThai+ hd.toString();
        } else return " STT= " + stt + " Số ghế= " + soGhe + " Trạng thái= " + trangThai;  
    }
    public void nhapBan(){
        System.out.println("Nhập stt bàn:");
        this.setStt(new Scanner(System.in).nextInt());
        System.out.println("Nhập số ghế:");
        this.setSoGhe(new Scanner(System.in).nextInt());
        int trangthaiban=0;
        do{
        System.out.println("Chọn trạng thái:");
        System.out.println("1-Trống  2-Có khách");
        trangthaiban=new Scanner(System.in).nextInt();
        } while(trangthaiban !=1 && trangthaiban!=2);
        if(trangthaiban==1){
         this.setTrangThai("Trống");
        } else  this.setTrangThai("Có khách");
        if(this.getTrangThai()=="Có khách"){
                hd.nhapHoaDon();
        }
    }
     public ArrayList<String> listtd0 = new ArrayList<>();
    public void ghifileban(){
         try
            {
                File f = new File("Ban.txt");
                FileReader fr = new FileReader(f); 
                BufferedReader br = new BufferedReader(fr); 
                String line="" ;
                while((line = br.readLine())!= null) 
                {
                    System.out.println(line);
                    listtd0.add(line);
                }
                    fr.close();
                    br.close();
                } catch (IOException ex) {
                    System.out.println("File rỗng");
        }
        BufferedWriter bf = null;  
        int luuVitri=1;
        try {
            bf = new BufferedWriter(new FileWriter("Ban.txt",true)); 
                
                String line="";
                if(listtd0.size()==0){
                    Ban ban = new Ban();
                    ban.nhapBan();
                    line = ban.toString();
                    bf.write(line);
                    System.out.println("Lưu thành công bàn mới");
                    bf.newLine(); 
                } else{
                    while (luuVitri!=-1){
                    Ban ban = new Ban();
                    ban.nhapBan();
                    line = ban.toString();
                    for (int i = 0; i < listtd0.size(); i++) {
                            if(listtd0.get(i).indexOf(String.valueOf(ban.getStt()))==6){
                                luuVitri=i;
                                System.out.println("Đã tồn tại stt bàn= "+ban.getStt()+" trong danh sách");
                                break;
                            } else luuVitri=-1;
                        }
                    } 
                    bf.write(line);
                    System.out.println("Lưu thành công bàn mới");
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
    public static ArrayList<String> listBanTatCa = new ArrayList<>();
    public static ArrayList<String> listBanTrong = new ArrayList<>();
    public static ArrayList<String> listBanCoKhach = new ArrayList<>();
    public static int dockieukhac=1;
    public int luu3=0;
    public void docfileban(){
        listBanTatCa.clear();
        listBanCoKhach.clear();
        listBanTrong.clear();
         try
            {
                File f = new File("Ban.txt");
                FileReader fr = new FileReader(f); 
                BufferedReader br = new BufferedReader(fr); 
                String line ;
                while((line = br.readLine())!= null) 
                {
                    if(dockieukhac==1){
                    System.out.println(line);
                    }
                     listBanTatCa.add(line);
                }
                
                    fr.close();
                    br.close();
                } catch (IOException ex) {
                    System.out.println("File rỗng");
                   
        }
    }
    public void loc(){
        for (int i = 0; i < listBanTatCa.size(); i++) {
            if(listBanTatCa.get(i).indexOf("Có khách")>-1){
              listBanCoKhach.add(listBanTatCa.get(i));
            }
            else {
              listBanTrong.add(listBanTatCa.get(i));
            }
        }
    }
    public void indsbantrong(){
        for (int i = 0; i <listBanTrong.size(); i++) {
            System.out.println(listBanTrong.get(i));
        }
    }
    public void indsbancokhach(){
        for (int i = 0; i < listBanCoKhach.size() ; i++) {
            System.out.println(listBanCoKhach.get(i));
        }
    }
    public static float tongTungBan= 0;
    public ArrayList<String> listban = new ArrayList<>();
    public void SuaBan (int soTT){
                tongTungBan=0;
                int luuvitri=-1;
		 try
                {
                    File f = new File("Ban.txt");
                    FileReader fr = new FileReader(f); 
                    BufferedReader br = new BufferedReader(fr); 
                    String line ;
                    while((line = br.readLine())!= null) 
                    {
                        listban.add(line);
                    }
                    for (int i = 0; i < listban.size(); i++) {
                        if(listban.get(i).indexOf(String.valueOf(soTT))==6){
                            luuvitri=i;
                            break;
                        }
                    }
 
                    if(luuvitri>-1){
                     System.out.println("Thông tin ban có số thứ tự ="+soTT+" trước khi sửa: "+listban.get(luuvitri));
                        System.out.println("Sửa bàn có số thứ tự = "+(soTT));
                        line = listban.get(luuvitri);
                        String[] ma=line.split("\\ ");
                        if(ma[8].equals("Có")){
                          ma[8]="Trống";
                          String string="";
                            for (int i = 1; i < 9; i++) {
                                string +=" "+ma[i];
                            }
                          listban.set(luuvitri, string );
                          System.out.println("Thông tin bàn có stt="+soTT+" sau khi sửa: "+listban.get(luuvitri));
                        } else{
                          ma[8]= "Có khách";
                          HoaDon hd = new HoaDon();
                          hd.nhapHoaDon();
                          String luu2="";
                            for (int i = 1; i<9; i++) {
                                luu2 +=" "+ma[i];
                            }
                          luu2 +=" "+hd.toString();
                          tongTungBan +=HoaDon.tong;
                          listban.set(luuvitri, luu2);
                          System.out.println("Thông tin bàn có stt="+soTT+" sau khi sửa: "+listban.get(luuvitri));
                        }
                        
                    } else System.out.println("Không tồn tại số thứ tự bàn đã nhập");
                   fr.close();
                   br.close();    
                } catch (IOException ex) {
                    System.out.println("Lỗi đọc file : "+ex);
                   }
                 BufferedWriter bf = null;  
        try {
            bf = new BufferedWriter(new FileWriter("Ban.txt")); 
                for (int i = 0; i < listban.size(); i++) {
                  bf.write(listban.get(i));
                  bf.newLine(); 
            }
                System.out.println("Lưu thành công thay đổi");
               
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
}
