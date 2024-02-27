/**
 * 
 */
package quanLyNhanSu;

import java.util.Scanner;

/**
 * 
 */
public class main {

	/**
	 * 
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CongTy CT = new CongTy();
		chonMenu(CT);

	}

	// Hàm chọn menu
	public static void chonMenu(CongTy CT) {
		Scanner scan = new Scanner(System.in);
		boolean thoat = false;
		boolean thoatNhapNV = false;
		int n, j;

		do {
			thongBao();
			n = Integer.parseInt(scan.nextLine());
			switch (n) {
			case 1:
				// Nhập thông tin công ty
				System.out.println("Nhập thông tin công ty");
				CT.nhapThongTinCongTy();

				do {
					thongBaoNhapNhanVien();
					j = Integer.parseInt(scan.nextLine());
					switch (j) {
					case 1:
						nhapNhanVienThuong(CT);
						break;
					case 2:
						nhapTruongPhong(CT);

						break;
					case 3:
						nhapGiamDoc(CT);

						break;
					case 0:
						thoatNhapNV = true;
					default:
						break;
					}

				} while (!thoatNhapNV);

				break;

			case 2:
				// Phân bổ nhân viên vào trưởng phòng
				CT.PhanBoNhanVienVaoTruongPhong();
			case 3:
				// Thêm nhân Viên
				System.out.print("Vui lòng chọn : \n" + "\t1.Thêm Nhân Viên" + "\t2.Xoá nhân Viên");
				n = Integer.parseInt(scan.nextLine());
				switch (n) {
				case 1:
					// Thêm Nhân Viên (Chức năng 3-1: Thêm Nhân Viên)
					do {
						thongBaoNhapNhanVien();
						j = Integer.parseInt(scan.nextLine());
						switch (j) {
						case 1:
							nhapNhanVienThuong(CT);
							break;
						case 2:
							nhapTruongPhong(CT);

							break;
						case 3:
							nhapGiamDoc(CT);

							break;
						case 0:
							thoatNhapNV = true;
						default:
							break;
						}

					} while (!thoatNhapNV);
					break;
				case 2:
					// xoá nhân Viên 
					System.out.println(" Vui Lòng nhập mã nhân viên muốn xoá");
					String maNV = scan.nextLine();
					CT.xoaNhanVien(maNV);
				default:
					break;
				}
				break;
			
			case 4:
				// Xuất ra thông tin toàn bộ nhân viên công ty 
				CT.xuatToanBoNhanVien();
			case 5: 
				// Tính và xuất ra tổng luong cho toàn công Ty 
				CT.tongLuongCongTy(); 
			case 6: 
				// Tìm nhân Viên Thường có lương cao nhất 
				CT.nhanVienThuongCoLuongCaoNhat();
			case 7: 
				// Hàm tìm trưởng phòng có số lượng nhân viên nhiều nhất là 
				CT.tpCoNVDuoiQuyenNhieuNhat();
			case 8: 
				//Sắp xếp nhân viên của toàn công ty theo thứ tự ABC 
				
			case 9: 
				// Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần
				CT.sapXepNhanVienTheoTen();
			case 10: 
				// Tìm giám đốc có số lượng cổ phần nhiều nhất
				CT.timGDcoSLCPNhieuNhat();
			case 11:
				// Tính và xuất tổng thu nhập của từng giám đốc 
				CT.thuNhapCuaTungGiamDoc();
			case 0:
				// Thoat chuong trinh
				thoat = true;
				System.out.print("Đang thoát chương trình");
				break;

			default:
				break;
			}
			
		} while (!thoat);

	};

	// Hàm Thông báo các chức năng trong menu
	public static void thongBao() {
		System.out.print("\nVui lòng chọn tính năng theo Menu: \n" + "\t1.Nhập thông tin công ty \n"
				+ "\t2.Phân bổ nhân viên vào trưởng phòng\n" + "\t3.Thêm, xoá thông tin một nhân sự \n"
				+ "\t4.Xuất thông tin toàn bộ người trong công ty \n" + "\t5.Tính và xuất tổng lương cho toàn công ty\n"
				+ "\t6.Tìm nhân viên thường có lương cao nhất\n"
				+ "\t7.Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất \n"
				+ "\t8.Sắp xếp nhân viên toàn công ty theo thứ tự abc \n"
				+ "\t9.Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm \n"
				+ "\t10.Tìm giám đốc có số lượng cổ phiếu nhiều nhất\n"
				+ "\t11.Tính và xuất tổng Thu Nhập của từng giám đốc\n" + "\t0.Thoát chương trình \n");
	}

	// Hàm thông báo nhập nhân viên
	public static void thongBaoNhapNhanVien() {
		System.out.print("\nVui lòng chọn tính năng :\n" + "\t1.Thêm Nhân Viên Thường\n" + "\t2.Thêm Trưởng Phòng\n"
				+ "\t3.Thêm Giám Đốc\n" + "\t0.Dừng không thêm nhân viên\n");
	}

	// Hàm Nhập nhân viên Thường
	public static void nhapNhanVienThuong(CongTy CT) {
		System.out.println("Nhập thông tin Nhân Viên Thường của công ty \n");
		NhanVien nv = new NhanVienThuong();
		nv.nhapThongTinNhanVien();
		CT.themNhanVien(nv);
	}

	// Hàm nhập trưởng phòng
	public static void nhapTruongPhong(CongTy CT) {
		System.out.println("Nhập thông tin Trưởng phòng của công ty \n");
		TruongPhong tp = new TruongPhong();
		tp.nhapThongTinNhanVien();
		CT.themNhanVien(tp);
	}

	// Hàm Nhập giám đốc
	public static void nhapGiamDoc(CongTy CT) {
		System.out.println("Nhập thông tin Giám đốc của công ty \n");
		GiamDoc gd = new GiamDoc();
		gd.nhapThongTinNhanVien();
		CT.themNhanVien(gd);
	}

}
