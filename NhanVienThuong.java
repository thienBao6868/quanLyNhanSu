/**
 * 
 */
package quanLyNhanSu;

import java.util.Scanner;

/**
 * 
 */
public class NhanVienThuong extends NhanVien {

	private String maTruongPhong = null;

	public String getMaTruongPhong() {
		return maTruongPhong;
	}

	public void setMaTruongPhong(String maTruongPhong) {
		this.maTruongPhong = maTruongPhong;
	}

	@Override
	public void xuatThongTinNhanVien(int stt) {
		// TODO Auto-generated method stub
		super.xuatThongTinNhanVien(stt);
		System.out.print(this.maTruongPhong + "\t| \n");
	}
	
	
	
}
