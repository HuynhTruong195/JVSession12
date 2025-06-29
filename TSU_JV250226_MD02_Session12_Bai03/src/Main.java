
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderBusiness business = new OrderBusiness();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n*********************QUẢN LÝ ĐƠN HÀNG********************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Hiển thị danh sách đơn hàng");
            System.out.println("3. Cập nhật trạng thái đơn hàng");
            System.out.println("4. Xóa đơn hàng theo mã đơn hàng");
            System.out.println("5. Tìm kiếm đơn hàng theo tên khách hàng");
            System.out.println("6. Thống kê tổng số đơn hàng");
            System.out.println("7. Thống kê doanh thu (Delivered)");
            System.out.println("8. Thống kê số lượng đơn theo trạng thái");
            System.out.println("9. Tìm đơn hàng có giá trị lớn nhất");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> business.addOrder();
                case 2 -> business.displayOrders();
                case 3 -> business.updateStatus();
                case 4 -> business.deleteOrder();
                case 5 -> business.searchByCustomerName();
                case 6 -> business.totalOrders();
                case 7 -> business.totalRevenueDelivered();
                case 8 -> business.countByStatus();
                case 9 -> business.maxOrder();
                case 0 -> System.out.println(" Thoát chương trình.");
                default -> System.out.println(" Lựa chọn không hợp lệ.");
            }

        } while (choice != 0);
    }
}
