/**
 * 
 */
package quanLyNhanSu;

/**
 * 
 */
public class KiemTraDieuKien {

	/**
	 * 
	 */
	public KiemTraDieuKien() {
		// TODO Auto-generated constructor stub
	}

	// Hàm kiểm tra chuỗi
	public boolean KiemTraChuoiRong(String chuoi) {
		if (chuoi.isEmpty()) {
			System.out.println("Tên công ty không được để trống - vui lòng nhập lại: ");
			return false;
		} else
			return true;
	}

	// Hàm kiểm tra chiều dài chuổi số
	public boolean KiemTraChieuDaiChuoi(String chuoi, int chieuDai) {
		if (chuoi.length() == chieuDai) {
			return true;
		} else {
			System.out.println("Mã Số thuế phải có chiều dài là : " + chieuDai + " - vui lòng nhập lại : ");
			return false;
		}
	}

	// Hàm kiểm tra chuổi số
	public boolean KiemTraChuoiSo(String chuoi) {
		if (chuoi == null || chuoi.equals("")) {
			System.out.println("Mã Số thuế không hợp lệ - Vui Lòng nhập lại : ");
			return false;
		}
		for (char c : chuoi.toCharArray()) {
			// Nếu ký tự không phải là số, trả về false
			if (!Character.isDigit(c)) {
				System.out.println("Mã số thuế phải là chuỗi chỉ chứa số - Vui Lòng Nhập lại: ");
				return false;
			}
		}

		// Nếu tất cả các ký tự trong chuỗi đều là số, trả về true
		return true;

	}

	// Hàm kiểm tra số có phải là số dương
	public boolean KiemTraSoDuong(double soDuong) {
		if (soDuong < 0) {
			System.out.println("Doanh Thu phải là số >= 0 - Vui lòng nhập lại Doanh Thu : ");
			return false;
		}
		return true;
	}

	// Hàm Kiểm tra phần trăm cổ phần.
	public boolean KiemTraPhanTram(float phanTramCoPhan) {
		if (phanTramCoPhan < 0 || phanTramCoPhan >= 100) {
			System.out.println("Phần trăm cổ phần phải >= 0 và < 100 - Vui lòng nhập lại phần trăm cổ phần");
			return false;
		}
		return true;
	}

	// Hàm kiểm tra số ngày làm việc
	public boolean KiemTraSoNgayLamViec(int soNgayLamViec, int thang, int nam) {
		int soNgayCuaThang = SoNgayCuaThang(thang, nam);

		if (soNgayLamViec <= soNgayCuaThang && soNgayLamViec >= 0)
			return true;
		else {
			System.out.println(
					"Số ngày làm việc của tháng " + thang + "phải từ 0 - " + soNgayCuaThang + " - Vui lòng nhập lại");
			return false;
		}
	}

	// Hàm kiểm tra số ngày của tháng	
	private int SoNgayCuaThang(int thang, int nam ) {
		switch (thang) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30; 
		case 2:
			if((nam % 4 == 0 && nam % 100 != 0) || nam % 400 == 0) return 29;
            else return 28;
        default:
            return -1;
		}
		
	}
	
	// hàm kiểm tra mã tồn tại 

}
