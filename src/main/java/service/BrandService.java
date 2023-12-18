package service;

import entity.Brand;
import repository.BrandRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class BrandService {

    Scanner scanner = new Scanner(System.in);
    private final BrandRepository brandRepository = new BrandRepository();

    public BrandService() throws SQLException {
    }

    public void register(Brand brand) throws SQLException {
        int result = brandRepository.save(brand);
        if (result != 0)
            System.out.println(brand.getName() + " successfully added to database");
        else
            System.out.println("ERROR");
    }
}
