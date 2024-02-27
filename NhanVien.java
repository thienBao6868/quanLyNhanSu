/**
 * 
 */
package quanLyNhanSu;

import java.util.Scanner;

/**
 * 
 */
public class NhanVien {

	protected static final KiemTraDieuKien kt = new KiemTraDieuKien();
	protected static int thangLamViec = 3;

	public static int getThangLamViec() {
		return thangLamViec;
	}

	public static void setThangLamViec(int thangLamViec) {
		NhanVien.thangLamViec = thangLamViec;
	}

	public static int getNamLamViec() {
		return namLamViec;
	}

	public static void setNamLamViec(int namLamViec) {
		NhanVien.namLamViec = namLamViec;
	}

	protected static int namLamViec = 2024;
	protected String maSo;
	protected String hoTen;
	protected String soDienThoai;
	protected int soNgayLamViec;
	protected double luongMotNgay;

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public int getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(int soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}

	public double getLuongMotNgay() {
		return luongMotNgay;
	}

	public void setLuongMotNgay(double luongMotNgay) {
		this.luongMotNgay = luongMotNgay;
	}

	/**
	 * 
	 */

// Sử dụng tính trừu tượng cho Lớp Nhân Viên nên không cần constructor
//	public NhanVien() {
//		// TODO Auto-generated constructor stub
//	}

	// Hàm nhập thông tin nhân viên (Trong Câu 1)
	public void nhapThongTinNhanVien() {
		Scanner scan = new Scanner(System.in);
		// hàm nhập mã số nhân viên 
		nhapMaSo(scan);
		// Hàm nhập họ tên nhân viên 
		nhapHoTen(scan);
		// hàm nhập số điện thoại 
		nhapSoDienThoai(scan);
		// hàm nhập số ngày làm việc 
		nhapSoNgayLamViec(scan);
		// hàm nhập lương
		nhapLuong(scan);
	};

	// Hàm Xuất thông tin nhân viên
	public void xuatThongTinNhanVien(int stt) {
		System.out.print(stt + "\t|");
		System.out.print(this.maSo + "\t\t|");
		System.out.print(this.hoTen + "\t\t\t|");
		System.out.print(this.soDienThoai + "\t\t|");
		System.out.print(this.soNgayLamViec + "\t\t|");
		System.out.print(this.luongMotNgay + "\t\t| \n");

	};

	// Hàm nhập mã số
	private void nhapMaSo(Scanner scan) {
		System.out.println(" Vui Lòng nhập mã số nhân viên : ");
		String maSo = scan.nextLine();
		
		while (true)
			if (kt.KiemTraChieuDaiChuoi(maSo, 3) && kt.KiemTraChuoiSo(maSo))
				break;
			else
				maSo = scan.nextLine();
		setMaSo(maSo);
	}

	// Hàm nhập họ tên

	private void nhapHoTen(Scanner scan) {
		System.out.println(" Vui Lòng nhập họ tên nhân viên : ");
		String hoTen = scan.nextLine();
		while (true)
			if (kt.KiemTraChuoiRong(hoTen))
				break;
			else
				hoTen = scan.nextLine();
		setHoTen(hoTen);
	}

	// Hàm nhập số điện thoại

	private void nhapSoDienThoai(Scanner scan) {
		System.out.println("Vui lòng nhập số điện thoaị :  ");
		String soDT = scan.nextLine();
		while (true)
			if (kt.KiemTraChieuDaiChuoi(soDT, 10) && kt.KiemTraChuoiSo(soDT))
				break;
			else
				soDT = scan.nextLine();
		setSoDienThoai(soDT);
	}

	// Hàm nhập số ngày làm việc
	private void nhapSoNgayLamViec(Scanner scan) {
		System.out.println("Vui lòng nhập số ngày làm việc :  ");
		int soNgayLV = Integer.parseInt(scan.nextLine());

		while (true)
			if (kt.KiemTraSoNgayLamViec(soNgayLV, getThangLamViec(), getNamLamViec()))
				break;
			else
				soNgayLV = Integer.parseInt(scan.nextLine());
		setSoNgayLamViec(soNgayLV);

	}

	// Hàm nhập lương
	private void nhapLuong(Scanner scan) {
		System.out.println("Vui lòng nhập lương một ngày của nhân viên: ");
		double luong = Double.parseDouble(scan.nextLine());
		while (true)
			if (kt.KiemTraSoDuong(luong))
				break;
			else
				luong = Double.parseDouble(scan.nextLine());
		setLuongMotNgay(luong);
	}
	// Hàm thêm nhân viên 
	
	
	// Hàm Tính Lương
	public double tinhLuong() {
		double luong = this.soNgayLamViec * this.luongMotNgay;
		return luong ;
		
	};

	// Hàm lấy tên nhân viên
	public String layTenNhanVien() {
		return this.hoTen;

	}

}
