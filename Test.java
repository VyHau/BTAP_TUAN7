package Bai3;
import java.util.*;
import Bai2.SinhVien;

public class Test {
    public static Scanner sc = new Scanner(System.in);

    // Hàm tạo tài khoản mới
    public static void TaoTaiKhoan(ArrayList<TaiKhoan> arr) {
        System.out.print("Nhập số tài khoản: ");
        String soTaiKhoan = sc.nextLine();
        System.out.print("Nhập tên tài khoản: ");
        String chuTaiKhoan = sc.nextLine();
        System.out.print("Nhập số dư ban đầu: ");
        double soDu = sc.nextDouble();
        sc.nextLine(); 
        System.out.print("Nhập mật khẩu: ");
        String passWord = sc.nextLine();

        // Kiểm tra xem mật khẩu này đã tồn tại hay chưa.
        while (checkTaiKhoan(arr, passWord) != null) {
            System.out.println("Mật khẩu này đã tồn tại! Vui lòng chọn mật khẩu khác.");
            System.out.print("Nhập lại password: ");
            passWord = sc.nextLine();
        }

        TaiKhoan tk = new TaiKhoan(soTaiKhoan, chuTaiKhoan, soDu, passWord);
        arr.add(tk);
        System.out.println("Tạo tài khoản thành công");
    }

    // Hàm kiểm tra tài khoản dựa trên mật khẩu người dùng nhập vào có tồn tại hay không
    public static TaiKhoan checkTaiKhoan(ArrayList<TaiKhoan> arr, String passWordEnter) {
        for (TaiKhoan x : arr)
            if (x.getPassword().equals(passWordEnter))
                return x;
        return null;
    }

    // Hàm đăng nhập
    public static void DangNhap(ArrayList<TaiKhoan> arr) {
        for (int i = 0; i < 3; i++) {
            System.out.print("Mời nhập password: ");
            String passWordEnter = sc.nextLine();
            TaiKhoan tk = checkTaiKhoan(arr, passWordEnter);
            if (tk != null) {
                System.out.println("Đăng nhập thành công!");
                hienThiMenu2(tk);
                return;
            }
            else
                System.out.println("Mật khẩu không tồn tại !");
        }
        System.out.println("Bạn đã nhập sai quá 3 lần!Vui lòng truy cập lại");
        hienThiMenu1(arr); 
    }

    // Hàm đổi mật khẩu
    public static void DoiMatKhau(TaiKhoan tk) {
        System.out.print("Nhập mật khẩu hiện tại: ");
        String currentPassWord = sc.nextLine();

        // Xác thực mật khẩu hiện tại
        while (tk.getPassword().equals(currentPassWord)==false) {
            System.out.println("Mật khẩu sai! Vui lòng nhập lại.");
            System.out.print("Nhập mật khẩu hiện tại: ");
            currentPassWord = sc.nextLine();
        }

        String newPassWord, confirmPassWord;
        System.out.print("Nhập mật khẩu mới: ");
        newPassWord = sc.nextLine();
        System.out.print("Xác nhận lại mật khẩu mới: ");
        confirmPassWord = sc.nextLine();

        // Kiểm tra xác nhận mật khẩu
        while (!confirmPassWord.equals(newPassWord)) {
            System.out.println("Mật khẩu xác nhận không trùng khớp! Vui lòng nhập lại.");
            System.out.print("Nhập lại mật khẩu xác nhận mới: ");
            confirmPassWord = sc.nextLine();
        }
        tk.setPassword(confirmPassWord);
        System.out.println("Đổi mật khẩu thành công!");
    }

    // Hàm hiển thị menu chính
    public static void hienThiMenu1(ArrayList<TaiKhoan> arr) {
        boolean check = true;
        while (check) {
            System.out.println("-----------------MENU----------------");
            System.out.println("1. Tạo tài khoản");
            System.out.println("2. Đăng nhập tài khoản");
            System.out.println("-------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            int lc = sc.nextInt();
            sc.nextLine();
            switch (lc) {
                case 1:
                    TaoTaiKhoan(arr);
                    break;
                case 2:
                    DangNhap(arr);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // Hàm hiển thị menu sau khi đăng nhập
    public static void hienThiMenu2(TaiKhoan tk) {
        boolean check = true;
        while (check) {
            System.out.println("-------------THAO TÁC---------------");
            System.out.println("1. Xem số dư tài khoản");
            System.out.println("2. Rút tiền");
            System.out.println("3. Nộp tiền");
            System.out.println("4. Đổi mật khẩu");
            System.out.println("5. Đăng xuất");
            System.out.println("------------------------------------");
            System.out.print("Nhập thao tác: ");
            int tt = sc.nextInt();
            sc.nextLine(); 
            switch (tt) {
                case 1:
                    System.out.println("Số dư tài khoản là: " + tk.getSoDu());
                    break;
                case 2:
                    System.out.print("Nhập số tiền cần rút: ");
                    double tienRut = sc.nextDouble();
                    if(tienRut >=0)
                        if (tienRut <= tk.getSoDu()){
                            tk.RutTien(tienRut);
                            System.out.println("Rút tiền thành công!");
                        }
                        else 
                            System.out.println("Số dư không đủ!");
                    else
                        System.out.println("Số tiền cần rút không hợp lệ!");
                    break;
                case 3:
                    System.out.print("Nhập số tiền cần nộp: ");
                    double tienGui = sc.nextDouble();
                    if(tienGui > 0){
                        tk.GuiTien(tienGui);
                        System.out.println("Nộp tiền thành công!");
                    }
                    else
                        System.out.println("Số tiền nộp vào không hợp lệ!");
                    break;
                case 4:
                    DoiMatKhau(tk);
                    break;
                case 5:
                    System.out.println("Đăng xuất thành công!");
                    check = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<TaiKhoan> arr = new ArrayList<>();
        while (true) {
            hienThiMenu1(arr);
        }
    }
}
