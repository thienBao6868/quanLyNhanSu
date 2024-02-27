/**
 * 
 */
package quanLyNhanSu;

import java.util.Scanner;

/**
 * 
 */
public class GiamDoc extends NhanVien {
	protected static final KiemTraDieuKien kt = new KiemTraDieuKien();
	private float phanTramCoPhan;

	public float getPhanTramCoPhan() {
		return phanTramCoPhan;
	}

	public float setPhanTramCoPhan(float phanTramCoPhan) {
		return this.phanTramCoPhan = phanTramCoPhan;
	}

	@Override
	public void nhapThongTinNhanVien() {
		// TODO Auto-generated method stub
		super.nhapThongTinNhanVien();

		Scanner scan = new Scanner(System.in);
		nhapPhanTramCoPhan(scan);

	}
	
	@Override
	public void xuatThongTinNhanVien(int stt) {
		// TODO Auto-generated method stub
		super.xuatThongTinNhanVien(stt);
		System.out.print(this.phanTramCoPhan + " \t\t| \n");
		
	}

	private void nhapPhanTramCoPhan(Scanner scan) {
		System.out.println("Vui lòng nhập phần trăm cổ phần của giám đốc: ");
		float phanTram = Float.parseFloat(scan.nextLine());
		while (true)
			if (kt.KiemTraPhanTram(phanTram))
				break;
			else
				phanTram = Float.parseFloat(scan.nextLine());
		setPhanTramCoPhan(phanTram);
	}
	
	

}
