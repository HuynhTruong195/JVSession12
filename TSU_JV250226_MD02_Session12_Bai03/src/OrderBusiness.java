

import java.util.*;
import java.util.stream.Collectors;

public class OrderBusiness {
    private final List<Order> orders = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addOrder() {
        Order order = new Order();
        order.inputData(scanner);
        orders.add(order);
        System.out.println(" Thêm đơn hàng thành công!");
    }

    public void displayOrders() {
        orders.stream()
                .sorted(Comparator.comparing(Order::getOrderAmount).reversed())
                .forEach(System.out::println);
    }

    public void updateStatus() {
        System.out.print("Nhập mã đơn hàng cần cập nhật trạng thái: ");
        int id = Integer.parseInt(scanner.nextLine());
        Optional<Order> optional = orders.stream()
                .filter(o -> o.getOrderId() == id).findFirst();

        optional.ifPresentOrElse(order -> {
            switch (order.getStatus()) {
                case Pending -> {
                    order.setStatus(Order.Status.Shipped);
                    System.out.println("Trạng thái đã cập nhật: Shipped");
                }
                case Shipped -> {
                    order.setStatus(Order.Status.Delivered);
                    System.out.println("Trạng thái đã cập nhật: Delivered");
                }
                case Delivered -> System.out.println(" Đơn hàng đã hoàn thành. Không thể cập nhật.");
            }
        },()  -> System.out.println(" Không tìm thấy đơn hàng."));
    }

    public void deleteOrder() {
        System.out.print("Nhập mã đơn hàng cần xoá: ");
        int id = Integer.parseInt(scanner.nextLine());
        Optional<Order> optional = orders.stream()
                .filter(o -> o.getOrderId() == id).findFirst();

        optional.ifPresentOrElse(order -> {
            if (order.getStatus() == Order.Status.Pending) {
                orders.remove(order);
                System.out.println(" Xoá thành công đơn hàng.");
            } else {
                System.out.println(" Chỉ được xoá đơn hàng có trạng thái Pending.");
            }
        }, () -> System.out.println(" Không tìm thấy đơn hàng."));
    }

    public void searchByCustomerName() {
        System.out.print("Nhập tên khách hàng cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();
        List<Order> result = orders.stream()
                .filter(o -> o.getCustomerName().toLowerCase().contains(keyword))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy đơn hàng nào.");
        } else {
            result.forEach(System.out::println);
        }
    }

    public void totalOrders() {
        System.out.println(" Tổng số đơn hàng: " + orders.size());
    }

    public void totalRevenueDelivered() {
        double revenue = orders.stream()
                .filter(o -> o.getStatus() == Order.Status.Delivered)
                .mapToDouble(Order::getOrderAmount)
                .sum();
        System.out.println(" Tổng doanh thu (Delivered): " + revenue);
    }

    public void countByStatus() {
        Map<Order.Status, Long> counts = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()));

        System.out.println(" Số lượng đơn hàng theo trạng thái:");
        for (Order.Status status : Order.Status.values()) {
            System.out.printf(" - %s: %d đơn\n", status, counts.getOrDefault(status, 0L));
        }
    }

    public void maxOrder() {
        Optional<Order> max = orders.stream()
                .max(Comparator.comparing(Order::getOrderAmount));

        max.ifPresentOrElse(
                o -> System.out.println(" Đơn hàng có giá trị lớn nhất:\n" + o),
                () -> System.out.println(" Không có đơn hàng.")
        );
    }
}
