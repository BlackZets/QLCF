package QLCF;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Scanner;


/**
 *
 * @author black zetsu
 */
public class QuanLy {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        float tongDoanhThu=0;
        int i=1;
        while(i!=4){
            do{
              System.out.println("                                COFFEE MANAGE - SEVEN GROUP");
              System.out.println("");
              System.out.println("                                      ****TRANG CHỦ*****"); 
              System.out.println(" -------------------    ---------------------    --------------------    -------------------");
              System.out.println("|1-Quản lí nhân viên|  | 2-Quản lí thực đơn  |  |   3-Quản lí bàn    |  |      4-Thoát      |");
              System.out.println(" -------------------    ---------------------    --------------------    -------------------");
              System.out.print("Chọn chức năng:");
              i=new Scanner(System.in).nextInt();
              System.out.println("Bạn đã lựa chọn: "+i);
              if(i!=1 && i!=2 && i!=3 && i!=4){System.out.println("Không tồn tại chức năng đã chọn");}
              if(i==4){System.out.println("Thoát chương trình!"); }
            } while (i!=1 && i!=2 && i!=3 && i!=4);
          if(i==1){
            int e=1;
            while (e!=0){
             System.out.println("");
             System.out.println("*** 1-Quản lí nhân viên: ***");
              NhanVien nv = new NhanVien();
             System.out.println("Chọn chức năng:");
             do{
                System.out.println("1-Thêm nhân viên:");
                System.out.println("2-Sửa nhân viên:");
                System.out.println("3-Xóa nhân viên:");
                System.out.println("4-Xem danh sách nhân viên:");
                System.out.println("0-Thoát");
                System.out.print("Lựa chọn:");
                e= new Scanner(System.in).nextInt();
            } while (e!=0 && e!=1 && e!=2 && e!=3 && e!=4);
                switch (e){
                   case 1:
                    { 
                        System.out.println("Chọn 1 - Thêm nhân viên");
                        nv.ghifilenv();
                        break;
                    }
                   case 2: 
                   { 
                        System.out.println("Chọn 2 - Sửa nhân viên:---");
                        System.out.println("--Danh sách nhân viên--");
                        nv.docfileSV();
                        if(NhanVien.trangthai==0){
                            System.out.print("Nhập mã nhân viên cần sửa:");
                            int id= new Scanner(System.in).nextInt();
                            nv.SuaNV(id);
                            break;
                        } else break;
                   }
                   case 3: 
                   {
                        System.out.println("Chọn 3 - Xóa nhân viên:---");
                        System.out.println("--Danh sách nhân viên--");
                        nv.docfileSV();
                        if(NhanVien.trangthai==0){
                            System.out.print("Nhập mã nhân viên cần xóa: ");
                            int id= new Scanner(System.in).nextInt();
                            nv.XoaNV(id);
                            break;
                        } else break;
                        
                   }
                   case 4:
                   {    System.out.println("---Danh sách nhân viên:---");
                        nv.docfileSV();
                        break;
                   }
                   case 0:
                   {
                       System.out.println("Trở về trang chủ");
                       break;
                   }
                }
            }
        } 
         else if (i==2){
            int f=1;
            while(f!=0){
            System.out.println("*** 2-Quản lí thực đơn: ***");
            System.out.println("Chọn chức năng:");
            do{
              System.out.println("1-Thêm đồ uống:");
              System.out.println("2-Sửa đồ uống:");
              System.out.println("3-Xóa đồ uống:");
              System.out.println("4-Danh sách đồ uống");
              System.out.println("0-Thoát");
              System.out.print("Lựa chọn:");
              f= new Scanner(System.in).nextInt();
              } while (f!=0 && f!=1 && f!=2 && f!=3 && f!=4);
                ThucDon td = new ThucDon();
                switch(f){
                    
                  case 1: 
                    {
                     System.out.println("Chọn 1 - Thêm đồ uống: ");
                     System.out.println("---Danh sách thực đơn:---");
                     td.ghifiletd();
                     break;
                    }
                  case 2: 
                    {
                     System.out.println("Chọn 2 - Sửa đồ uống:");
                     System.out.println("--Danh sách đồ uống--");
                     td.docfiletd();
                     if(ThucDon.thucdon==0){
                            System.out.println("Nhập tên đồ uống cần sửa");
                            String ten= new Scanner(System.in).nextLine();
                            td.SuaTĐ(ten);
                            break;
                        } else break;
                    }
                  case 3: 
                    {
                     System.out.println("---Xóa đồ uống:---");
                     System.out.println("--Danh sách đồ uống--");
                     td.docfiletd();
                     if(ThucDon.thucdon==0){
                            System.out.println("Nhập tên đồ uống cần xóa");
                            String ten= new Scanner(System.in).nextLine();
                            td.XoaTĐ(ten);
                            break;
                        } else break;
                    }
                  case 4: 
                    {
                     System.out.println("Danh sách đồ uống");
                     td.docfiletd();
                     break;
                    }
                  case 0:
                  {
                     break;
                  }
                }
            }
        } else if(i==3){
            int g=1;
            while(g!=0){
            System.out.println("*** 3-Quản lí Order: ***");
            System.out.println("Chọn chức năng:");
            do{
              System.out.println("1-Thêm bàn:");
              System.out.println("2-Quản lí order:");
              System.out.println("3-Xem danh sách thông tin bàn:");
              System.out.println("4-Xem doanh thu:");
              System.out.println("0-Thoát:");
              System.out.print("Lựa chọn:");
              g= new Scanner(System.in).nextInt();
              } while (g!=0 && g!=1 && g!=2 &&g!=3 &&g!=4);
              Ban ban = new Ban();
                switch(g){
                  case 1: 
                    {
                        System.out.println("Chọn 1 - Thêm bàn");
                        System.out.println("--Danh sách thông tin bàn đã có--");
                         ban.ghifileban();
                         System.out.println("Thêm bàn thành công");
                         break;
                    }
                    
                  case 3: 
                    {           int h=1;
                                while(h!=0){
                                System.out.println("Chọn danh sách bàn muốn xem:");
                                do{
                                  System.out.println("1-Tất cả:");
                                  System.out.println("2-Có khách:");
                                  System.out.println("3-Còn trống:");
                                  System.out.println("0-Trở về:");
                                  System.out.print("Lựa chọn:");
                                  h= new Scanner(System.in).nextInt();
                                  } while (h!=0 && h!=1 && h!=2 && h!=3);
                                    switch(h){
                                      case 1: 
                                        {
                                             System.out.println("Danh sách bàn - Tất cả");
                                             ban.dockieukhac=1;
                                             ban.docfileban();
                                             break;
                                        }

                                      case 2: 
                                        {
                                            System.out.println("Danh sách bàn - Có khách");
                                            ban.dockieukhac=2;
                                            ban.docfileban();
                                            ban.loc();
                                            ban.indsbancokhach();
                                            break;
                                        }
                                      case 3:
                                        {
                                            System.out.println("Danh sách bàn - Còn trống");
                                            ban.dockieukhac=3;
                                            ban.docfileban();
                                            ban.loc();
                                            ban.indsbantrong();
                                            break;
                                        }
                                      case 4: {
                                            break;
                                        }
                                    }
                                }
                                break;
                    }
                            
                  case 0:
                  {
                      break;
                  }
                  case 2:{
                     System.out.println("Danh sách thông tin bàn");
                     ban.dockieukhac=1;
                     ban.docfileban();
                     System.out.println("Nhập stt bàn muốn xóa/thêm order");
                      System.out.println("*Note:* Bàn có trạng thái=Có khách sau khi sửa sẽ trở thành Trạng thái=Trống");
                      System.out.println("      * Bàn có trạng thái=Trống sau khi sửa sẽ trở thành Trạng thái=Có khách kèm hóa đơn đồ uống của bàn đó");
                     int soTT= new Scanner(System.in).nextInt();
                     ban.SuaBan(soTT);
                     tongDoanhThu +=Ban.tongTungBan;
                     break;
                  }
                  case 4: {
                      System.out.println("Tổng doanh thu: "+tongDoanhThu);
                  }
                }
            }    
         } else if(i==4){
          System.exit(0);
         }
       }
    }
}
