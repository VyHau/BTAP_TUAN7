package Bai3;
import java.util.*;
public class TaiKhoan {
    public String soTaiKhoan;
    public String chuTaiKhoan;
    public double soDu;
    private String password;
    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String password) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.password = password;
    }
    public void RutTien(double TienRut){
        if(TienRut<=soDu)
            soDu-=TienRut;
        else
            System.out.println("Tien rut khong hop le!");
    }
    public void GuiTien(double TienGui){
        if(TienGui>0)
            soDu+=TienGui;
        else
            System.out.println("Tien gui khong hop le!");
    }
    void in(){
        System.out.println("STK: "+this.soTaiKhoan);
        System.out.println("Chu TK: "+this.chuTaiKhoan);
        System.out.println("So du: "+this.soDu);
    }
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }
    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }
    public double getSoDu() {
        return soDu;
    }
    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
