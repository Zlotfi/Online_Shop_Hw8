package service;

import entity.Product;
import repository.ProductRepository;

import java.sql.SQLException;

public class ProductService {

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
}
