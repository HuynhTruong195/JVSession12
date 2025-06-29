
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppointmentBusiness business = new AppointmentBusiness();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("*********************QUẢN LÝ LỊCH HẸN********************");
            System.out.println("1. Thêm lịch hẹn");
            System.out.println("2. Hiển thị danh sách lịch hẹn");
            System.out.println("3. Tìm kiếm lịch hẹn theo tên bệnh nhân");
            System.out.println("4. Cập nhật lịch hẹn theo mã lịch hẹn");
            System.out.println("5. Xóa lịch hẹn theo mã lịch hẹn");
            System.out.println("6. Thống kê");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> business.addAppointment();
                case 2 -> business.displayAppointments();
                case 3 -> business.searchByPatientName();
                case 4 -> business.updateAppointment();
                case 5 -> business.deleteAppointment();
                case 6 -> business.statistic();
                case 0 -> System.out.println(" Thoát chương trình.");
                default -> System.out.println(" Lựa chọn không hợp lệ.");
            }

        } while (choice != 0);
    }
}
