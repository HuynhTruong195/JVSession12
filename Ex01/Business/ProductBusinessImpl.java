package Ex01.Business;

import Ex01.Entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductBusinessImpl implements IProductBusiness {
    protected List<Product> productList;

    public ProductBusinessImpl() {
        this.productList = new ArrayList<>();
        productList.add(new Product("P001", "Laptop", 1500.00, 1));
        productList.add(new Product("P002", "Balo", 500, 13));
        productList.add(new Product("P003", "Book", 800, 2));
        productList.add(new Product("P004", "Smartphone", 5000, 5));
    }

    @Override
    public void addProduct(Scanner scanner) {
        System.out.println("Nhập số lượng sản phẩm muốn thêm");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            //tạo đối tượng
            Product product = new Product();
            product.inputData(scanner);
            //check id trùng khi thêm
            checkProductId(product, scanner);
            //lưu sản phẩm vào danh sách (tạo danh sách chưa sản phẩm List )
            productList.add(product);
        }
    }

    @Override
    public void displayProduct() {
        productList.forEach(System.out::println);
    }

    @Override
    public void findProductById(Scanner scanner) {
        System.out.println("Nhập ID sản phẩm cần tìm");
        String id = scanner.nextLine();
    Optional<Product> productOptional = productList.stream().filter(product -> product.getProductId()
                .equals(id)).findFirst();
        System.out.println("ID--------------Name--------------Price----------------Stock");
        if (productOptional.isPresent()) {
            System.out.println(productOptional.get());
        } else {
            System.out.println("Không tìm thấy sản phẩm với ID đã nhập.");
        }
    }

    //method kiểm tra trùng lạpw id

    private void checkProductId(Product product, Scanner scanner) {
        while (true) {
            boolean isDuplicate = productList.stream().anyMatch(id -> id.getProductId().equals(product.getProductId()));
            if (isDuplicate) {
                System.out.println("Mã Id bị trùng, vui lòng nhập Id khác");
                product.setProductId(product.inputId(scanner));
            } else {
                break;
            }
        }
    }


}
