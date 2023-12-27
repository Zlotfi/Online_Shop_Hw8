package service;

import entity.Product;
import repository.ProductRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductService {

    Scanner scanner = new Scanner(System.in);
    private final ProductRepository productRepository = new ProductRepository();

    public ProductService() throws SQLException {
    }

    public void register(Product product) throws SQLException {
        int result = productRepository.save(product);
        if (result != 0)
            System.out.println(product.getName() + " successfully added to database");
        else
            System.out.println("ERROR");
    }

    public void updateProduct() throws SQLException {
        System.out.println("id: ");
        int id = scanner.nextInt();
        System.out.println("please enter your new name: ");
        String name = scanner.nextLine();
        System.out.println("please enter your new createDate: ");
        String createDate = scanner.nextLine();
        System.out.println("please enter your new category_id: ");
        int category_id = scanner.nextInt();
        System.out.println("please enter your new brand_id: ");
        int brand_id = scanner.nextInt();

        int result = productRepository.update(name,createDate,category_id,brand_id,id);
        if (result != 0)
            System.out.println("successfully update to database");
        else
            System.out.println("OOps!?");
    }

    public void delete(int id) throws SQLException {
        int result = productRepository.delete(id);
        if (result != 0)
            System.out.println("successfully deleted from database");
        else
            System.out.println("ERROR");
    }
}
