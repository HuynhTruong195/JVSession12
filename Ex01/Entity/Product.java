package Ex01.Entity;

import java.util.Scanner;

public class Product implements IApp {
    private String productId;
    private String productName;
    private double price;
    private int stock;

    public Product() {
    }

    public Product (String productId, String productName, double price, int stock) {
        this.price = price;
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập thông tin sách");
        System.out.print("Mã sản phẩm: ");
        productId = inputId(scanner);
        System.out.print("Tên sản phẩm: ");
        productName = inputName(scanner);
        System.out.print("Giá sản phẩm: ");
        price = inputPrice(scanner);
        System.out.print("Tồn kho: ");
        stock = inputStock(scanner);
    }

    @Override
    public String toString() {
        String out = String.format("%s ---|----- %s --- | ----- %.2f --- |-----%s\n", productId, productName, price, stock);
        return out;
    }

    //method check định dạng id
    public String inputId(Scanner scanner) {
        do {
            String id = scanner.nextLine();
            if (id.matches("P\\d{3}")) {
                return id;
            } else {
                System.out.println("Nhập Id đúng định dạng  PXXX, X từ 0-9");
            }
        } while (true);
    }

    //method check tên sản phẩm

    private String inputName(Scanner scanner) {
        do {
            String name = scanner.nextLine();
            if (name.matches("^.{5,50}$")) {
                return name;
            } else {
                System.out.println("Vui lòng nhập tên sản phẩm từ 5-50 ký tự");
            }
        } while (true);
    }

    //method check giá
    private double inputPrice(Scanner scanner) {
        do {
            double price = Double.parseDouble(scanner.nextLine());
            if (price >= 0) {
                return price;
            } else {
                System.out.println("Nhập giá lớn hơn hoặc bằng 0");
            }
        } while (true);
    }

    //method check tồn kho
    private int inputStock(Scanner scanner) {
        do {
            int stock = Integer.parseInt(scanner.nextLine());
            if (stock >= 0) {
                return stock;
            } else {
                System.out.println("Vui lòng nhập tồn kho lớn hơn 0");
            }
        } while (true);
    }

}
