package day6;
import java.util.Scanner;
public class foreach_NhanVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Nhap so luong nhan vien");
		int total = scn.nextInt();
		String[] arr = new String[total];
		scn.nextLine();
		for (int i = 0; i<=total-1; i++) {
			System.out.println("Ten nhan vien thu"+(i+1));
			arr[i]=scn.nextLine();
		}
		System.out.println("Danh sach ten cac nhan vien");
		for (String n:arr) {
			System.out.println(n);
		}
		
	}
}
