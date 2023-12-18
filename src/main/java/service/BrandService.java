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

    public void updateBrand(int id) throws SQLException {
        System.out.println("please enter your new brand name: ");
        String name = scanner.nextLine();
        System.out.println("please enter your new brand website: ");
        String website = scanner.nextLine();
        System.out.println("please enter your new brand description: ");
        String description = scanner.nextLine();
        int result = brandRepository.update(name,website,description,id);
        if (result != 0)
            System.out.println("successfully update to database");
        else
            System.out.println("OOps:(");
    }

    public void delete(int id) throws SQLException {
        int result = brandRepository.delete(id);
        if (result != 0)
            System.out.println("successfully deleted from database");
        else
            System.out.println("ERROR");
    }
}
