package Ex01.ProductsManagement;

import Ex01.Business.IProductBusiness;
import Ex01.Business.ProductBusinessImpl;

import java.util.Scanner;

public class Main {
    //khởi tạo óối tượng để gọi đc các method
    private static final IProductBusiness productBusines = new ProductBusinessImpl();

    public static void main(String[] args) {
        run();
    }

    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        while (true) {
            System.out.println("====== PRODUCT MENU ======");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Tìm sản phẩm theo ID");
            System.out.println("4. Thoát");
            System.out.printf("Nhập lựa chọn");

            int chose = Integer.parseInt(scanner.nextLine());
            switch (chose) {
                case 1:
                    productBusines.displayProduct();
                    break;
                case 2:
                    productBusines.addProduct(scanner);
                    break;
                case 3:
                    productBusines.findProductById(scanner);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1-4");
            }
        }
    }
}
