/**
 * 
 */
package quanLyNhanSu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */
public class TruongPhong extends NhanVien {

	private int soLuongNhanVien;

	private ArrayList<NhanVienThuong> danhSachNhanVien;

	public int getSoLuongNhanVien() {
		return soLuongNhanVien;
	}

	public void setSoLuongNhanVien(int soLuongNhanVien) {
		this.soLuongNhanVien = soLuongNhanVien;
	}

	public ArrayList<NhanVienThuong> getDanhSachNhanVien() {
		return danhSachNhanVien;
	}

	public void setDanhSachNhanVien(ArrayList<NhanVienThuong> danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
	}

	public void tiepNhanNhanVien(NhanVienThuong nv) {
		this.soLuongNhanVien +=1 ;
		this.danhSachNhanVien.add(nv);
	}

	public void loaiBoNhanVien(NhanVien nv) {
		this.soLuongNhanVien -=1;
		this.danhSachNhanVien.remove(nv);
	}
	
	

	@Override
	public void xuatThongTinNhanVien(int stt) {
		// TODO Auto-generated method stub
		super.xuatThongTinNhanVien(stt);
		System.out.print(this.soLuongNhanVien + "\t\t| \n");
	}

	@Override
	public double tinhLuong() {
		// TODO Auto-generated method stub
		double luong = this.getSoNgayLamViec() * this.getLuongMotNgay()  + 100 * this.getSoLuongNhanVien();
		return luong ;
	}

}
