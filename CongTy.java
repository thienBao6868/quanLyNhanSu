/**
 * 
 */
package quanLyNhanSu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class CongTy {

	protected static final KiemTraDieuKien kt = new KiemTraDieuKien();
	private String tenCongTy;
	private String maSoThue;
	private Double doanhThuThang;
	private List<NhanVien> danhSachNhanVien;

	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;

	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public Double getDoanhThuThang() {
		return doanhThuThang;
	}

	public void setDoanhThuThang(Double doanhThuThang) {
		this.doanhThuThang = doanhThuThang;
	}

	public List<NhanVien> getDanhSachNhanVien() {
		return danhSachNhanVien;
	}

	public void setDanhSachNhanVien(ArrayList<NhanVien> danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
	}

	/**
	 * 
	 */

	// Hàm khởi tạo đối tượng công ty
	public CongTy() {
		// TODO Auto-generated constructor stub
		danhSachNhanVien = new ArrayList<>();
	}

	// Hàm khởi tạo công ty với các tham số
	public CongTy(String _tenCongTy, String _maSoThue, double _doanhThuThang, ArrayList<NhanVien> _danhSachNhanVien) {
		this.tenCongTy = _tenCongTy;
		this.maSoThue = _maSoThue;
		this.doanhThuThang = _doanhThuThang;
		this.danhSachNhanVien = _danhSachNhanVien;
	}

	// Câu 1: Hàm nhập thông tin công ty
	public void nhapThongTinCongTy() {
		Scanner scan = new Scanner(System.in);

		nhapTenCongTy(scan);

		nhapMaSoThue(scan);

		nhapDoanhThuThang(scan);

	}

// Hàm thêm nhân Viên vào danh sách nhân Viên. 
	public void themNhanVien(NhanVien nv) {
		if (danhSachNhanVien == null) {
			danhSachNhanVien = new ArrayList<>();
		}
		this.danhSachNhanVien.add(nv);
	};

// hàm xuất thông tin công ty 

	public void xuatThongTinCongTy() {
		System.out.print(this.tenCongTy + "\t\t|");
		System.out.printf("%-20s | %-20s | %-20s\n", "Ten cong ty", "Ma so thue", "Doanh thu thang");
		System.out.printf("%-20s | %-20s | %-20.2f", tenCongTy, maSoThue, doanhThuThang);

	}
// 

// Hàm nhập tên Công Ty
	private void nhapTenCongTy(Scanner scan) {

		System.out.println("Nhập tên Công ty:  ");

		String tenCT = scan.nextLine();
		while (true) {
			if (kt.KiemTraChuoiRong(tenCT))
				break;
			else
				tenCT = scan.nextLine();
		}
		setTenCongTy(tenCT);
	}

// Hàm nhập mã số thuế 
	private void nhapMaSoThue(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("Nhập mã số thuế của Công ty : ");
		String maSoThue = scan.nextLine();
		while (true)
			if (kt.KiemTraChuoiSo(maSoThue) && kt.KiemTraChieuDaiChuoi(maSoThue, 10))
				break;
			else
				maSoThue = scan.nextLine();
		setMaSoThue(maSoThue);
	};

// Hàm nhập doanh thu 
	private void nhapDoanhThuThang(Scanner scan) {
		System.out.println("Vui lòng nhập Doanh Thu Tháng : ");
		double doanhThuThang = Double.parseDouble(scan.nextLine());
		while (true) {
			if (kt.KiemTraSoDuong(doanhThuThang))
				break;
			else
				doanhThuThang = Double.parseDouble(scan.nextLine());
		}
		setDoanhThuThang(doanhThuThang);
	}

// Chức năng 2: Hàm phân bổ nhân viên vào trưởng phòng 
	public void PhanBoNhanVienVaoTruongPhong() {
		Scanner scan = new Scanner(System.in);
		DSNhanVienChuaCoTP();
		System.out.println("Vui lòng nhập mã nhân viên mà bạn muốn phân bổ : ");
		String maNVThuong = scan.nextLine();
		NhanVienThuong nvTimDuoc = (NhanVienThuong) TimNhanVienThuongTheoMa(maNVThuong);
		if (nvTimDuoc == null) {
			System.out.println("không tìm thấy nhân viên với mã đã nhập " + maNVThuong);
		} else {
			DSTruongPhong();
			System.out.println("Vui lòng nhập mã trưởng phòng mà bạn muốn phân bổ nhân viên vào : ");
			String maTP = scan.nextLine();
			TruongPhong tpTimDuoc = (TruongPhong) TimTruongPhongTheoMa(maTP);
			if (tpTimDuoc == null) {
				System.out.println("Không tìm thấy trưởng phòng với mã đã nhập " + maTP);
			} else {
				nvTimDuoc.setMaTruongPhong(maTP);
				tpTimDuoc.tiepNhanNhanVien(nvTimDuoc);
			}
		}

	}

	// Hàm lấy danh sách nhân Viên chưa có trưởng phòng
	private void DSNhanVienChuaCoTP() {
		System.out.println("Danh Sach Nhan Vien Thuong");
		System.out.printf("%-10s | %-20s | %-10s | %-10s\n", "mã số", "Họ tên", "SDT", "mã TP");
		for (NhanVien nv : danhSachNhanVien) {
			if (nv instanceof NhanVienThuong) {
				System.out.printf("%-10s | %-20s | %-10s | %-10s\n", nv.getMaSo(), nv.getHoTen(), nv.getSoDienThoai(),
						((NhanVienThuong) nv).getMaTruongPhong());
			}
		}

	}

	// Hàm lấy danh sách các trưởng phòng
	private void DSTruongPhong() {
		// Hàm lấy danh sách nhân Viên chưa có trưởng phòng

		System.out.println("Danh Sach Truong Phong");
		System.out.printf("%-10s | %-20s | %-10s | %-10s\n", "mã số", "Họ tên", "SDT");
		for (NhanVien nv : danhSachNhanVien) {
			if (nv instanceof TruongPhong) {
				System.out.printf("%-10s | %-20s | %-10s\n", nv.getMaSo(), nv.getHoTen(), nv.getSoDienThoai());
			}
		}

	}

	// Hàm tìm nhân viên thường theo mã
	private NhanVien TimNhanVienThuongTheoMa(String maNVThuong) {
		for (NhanVien nv : danhSachNhanVien) {
			if (nv instanceof NhanVienThuong && nv.getMaSo().equals(maNVThuong))
				return nv;
		}
		return null;

	}
	// Hàm tìm trưởng phòng theo mã

	private NhanVien TimTruongPhongTheoMa(String maTP) {
		for (NhanVien nv : danhSachNhanVien) {
			if (nv instanceof TruongPhong && nv.getMaSo().equals(maTP))
				return nv;
		}
		return null;

	}
	// Hàm tìm nv theo mã

	private NhanVien TimNhanVienTheoMa(String maNV) {
		for (NhanVien nv : danhSachNhanVien) {
			if (nv.getMaSo().equals(maNV))
				return nv;
		}
		return null;

	}

	// hàm xoá nhân viên (chức năng 3-2: Xoá nhân Viên)
	public void xoaNhanVien(String maNV) {
		NhanVien nvTimDuoc = TimNhanVienTheoMa(maNV);
		if (nvTimDuoc instanceof NhanVienThuong) {
			TruongPhong tp = (TruongPhong) TimTruongPhongTheoMa(((NhanVienThuong) nvTimDuoc).getMaTruongPhong());
			tp.loaiBoNhanVien(nvTimDuoc);
		}
		if (nvTimDuoc instanceof TruongPhong) {
			ArrayList<NhanVienThuong> dsNhanVienThuong = ((TruongPhong) nvTimDuoc).getDanhSachNhanVien();
			for (NhanVienThuong nv : dsNhanVienThuong) {
				nv.setMaTruongPhong(null);
			}
		}
	}

	// chức năng 4 : hàm xuất toàn bộ thông tin nhân Viên
	public void xuatToanBoNhanVien() {
		System.out.println("Dưới đây là danh sách tất cả các nhân viên");
		for (int i = 0; i < danhSachNhanVien.size(); i++) {
			if (danhSachNhanVien.get(i) instanceof NhanVienThuong) {
				NhanVienThuong nv = (NhanVienThuong) danhSachNhanVien.get(i);
				nv.xuatThongTinNhanVien(i);
			}
			if (danhSachNhanVien.get(i) instanceof TruongPhong) {
				TruongPhong tp = (TruongPhong) danhSachNhanVien.get(i);
				tp.xuatThongTinNhanVien(i);
			}
			if (danhSachNhanVien.get(i) instanceof GiamDoc) {
				GiamDoc gd = (GiamDoc) danhSachNhanVien.get(i);
				gd.xuatThongTinNhanVien(i);
			}
		}

	}

// Hàm tính và xuất tổng lương cho công ty
	public void tongLuongCongTy() {
		double tongLuong = 0;
		for (int i = 0; i < danhSachNhanVien.size(); i++) {

			if (danhSachNhanVien.get(i) instanceof TruongPhong) {
				TruongPhong tp = (TruongPhong) danhSachNhanVien.get(i);
				tongLuong += tp.tinhLuong();
			} else {
				tongLuong += danhSachNhanVien.get(i).tinhLuong();
			}

		}
	}

// Chức năng 6: Hàm tìm nhân viên thường có luong cao nhat 
	public void nhanVienThuongCoLuongCaoNhat() {
		for (NhanVien nv : danhSachNhanVien)
			if (nv instanceof NhanVienThuong && nv.tinhLuong() == luongNhanVienThuongCaoNhat())
				nv.xuatThongTinNhanVien(1);
		System.out.println("Luong của nhân viên thường cao nhất là : " + luongNhanVienThuongCaoNhat());
	}

// Hàm tìm lương cao nhất của nhân viên thường  
	public double luongNhanVienThuongCaoNhat() {
		double luongCaoNhat = 0;
		for (int i = 0; i < danhSachNhanVien.size(); i++) {

			if (danhSachNhanVien.get(i) instanceof NhanVienThuong
					&& danhSachNhanVien.get(i).tinhLuong() > luongCaoNhat) {
				luongCaoNhat = danhSachNhanVien.get(i).tinhLuong();
			}

		}
		return luongCaoNhat;
	}

// Hàm tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất 
	public void tpCoNVDuoiQuyenNhieuNhat() {
		for (NhanVien nv : danhSachNhanVien)
			if (nv instanceof TruongPhong) {
				TruongPhong nv1 = null;
				TruongPhong tp = (TruongPhong) nv1;
				if (tp.getSoLuongNhanVien() == soNhanVienNhieuNhatCuaMotTruongPhong()) {
					tp.xuatThongTinNhanVien(1);
					System.out.println("Số lượng nhân viên dưới quyền nhiều nhất của một trưởng phòng là: "
							+ soNhanVienNhieuNhatCuaMotTruongPhong());
				}
			}

	}

// Hàm tìm số nhân viên nhiều nhất của một trưởng phòng 
	public int soNhanVienNhieuNhatCuaMotTruongPhong() {
		int slNhanVien = 0;
		for (int i = 0; i < danhSachNhanVien.size(); i++) {
			if (danhSachNhanVien.get(i) instanceof TruongPhong) {
				TruongPhong tp = (TruongPhong) danhSachNhanVien.get(i);
				if (tp.getSoLuongNhanVien() > slNhanVien) {
					slNhanVien = tp.getSoLuongNhanVien();
				}
			}
		}
		return slNhanVien;
	}

// Chức năng 9 Sắp xếp nhân viên theo tên 
	public void sapXepNhanVienTheoTen() {
		Collections.sort(danhSachNhanVien, (nv1, nv2) -> nv1.layTenNhanVien().compareTo(nv2.layTenNhanVien()));
		xuatToanBoNhanVien();
	}
// chức năng 10: hàm tìm giám đốc có số cổ phần nhiều nhất 
	public void timGDcoSLCPNhieuNhat () {
		for(NhanVien nv:danhSachNhanVien)
			if(nv instanceof GiamDoc) {
				GiamDoc gd = (GiamDoc) nv;
				if(gd.getPhanTramCoPhan() == soLuongCoPhanLonNhat()) {
					gd.xuatThongTinNhanVien(1);
				}
				System.out.println("số lượng cổ phiếu nhiều nhất do giám đốc nắm giữ là : " + soLuongCoPhanLonNhat());
			}
	}
// Hàm tìm só lượng cổ phần lớn nhất 
	private double soLuongCoPhanLonNhat() {
		double slCpLonNhat = 0;
		for(NhanVien nv:danhSachNhanVien)
			if(nv instanceof GiamDoc) {
				GiamDoc gd = (GiamDoc) nv;
				if(gd.getPhanTramCoPhan() > slCpLonNhat) 
					slCpLonNhat = gd.getPhanTramCoPhan();
			}
		return slCpLonNhat;
				
	}
// Chức năng 11 : Tính và xuất ra tổng thu nhập của từng giám đốc
	public void thuNhapCuaTungGiamDoc() {
		for(int i=0;i < danhSachNhanVien.size(); i++ )
			if(danhSachNhanVien.get(i) instanceof GiamDoc) {
				GiamDoc gd = (GiamDoc) danhSachNhanVien.get(i);
				gd.tinhLuong();
				gd.xuatThongTinNhanVien(i+1);
				System.out.println("Lương của giám đốc là: " + gd.tinhLuong());
			}
	}
}
