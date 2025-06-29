
import java.util.Scanner;
import java.util.regex.Pattern;

public class Order {
    private static int autoId = 1;

    private int orderId;
    private String customerName;
    private String phoneNumber;
    private String address;
    private float orderAmount;
    private Status status;

    public enum Status {
        Pending, Shipped, Delivered
    }

    public Order() {
        this.orderId = autoId++;
        this.status = Status.Pending;
    }

    public Order(String customerName, String phoneNumber, String address, float orderAmount, Status status) {
        this.orderId = autoId++;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderAmount = orderAmount;
        this.status = status;
    }

    // Getters & Setters
    public int getOrderId() { return orderId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public float getOrderAmount() { return orderAmount; }
    public void setOrderAmount(float orderAmount) { this.orderAmount = orderAmount; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên khách hàng (6-100 ký tự): ");
        while (true) {
            String name = scanner.nextLine();
            if (name.length() >= 6 && name.length() <= 100) {
                this.customerName = name;
                break;
            } else {
                System.out.print("Tên không hợp lệ. Nhập lại: ");
            }
        }

        System.out.print("Nhập số điện thoại (Việt Nam - 10 số bắt đầu bằng 0): ");
        while (true) {
            String phone = scanner.nextLine();
            if (Pattern.matches("0\\d{9}", phone)) {
                this.phoneNumber = phone;
                break;
            } else {
                System.out.print("Số điện thoại không hợp lệ. Nhập lại: ");
            }
        }

        System.out.print("Nhập địa chỉ giao hàng: ");
        while (true) {
            String address = scanner.nextLine();
            if (!address.isEmpty()) {
                this.address = address;
                break;
            } else {
                System.out.print("Địa chỉ không được bỏ trống. Nhập lại: ");
            }
        }

        System.out.print("Nhập giá trị đơn hàng (>0): ");
        while (true) {
            try {
                float amount = Float.parseFloat(scanner.nextLine());
                if (amount > 0) {
                    this.orderAmount = amount;
                    break;
                } else {
                    System.out.print("Giá trị phải > 0. Nhập lại: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Sai định dạng. Nhập lại số thực: ");
            }
        }

        this.status = Status.Pending;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Khách: %s | SĐT: %s | Địa chỉ: %s | Giá trị: %.2f | Trạng thái: %s",
                orderId, customerName, phoneNumber, address, orderAmount, status);
    }
}
