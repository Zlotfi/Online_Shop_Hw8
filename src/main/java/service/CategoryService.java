package service;

import entity.Category;
import entity.User;
import repository.CategoryRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class CategoryService {

    Scanner scanner = new Scanner(System.in);

    private final CategoryRepository categoryRepository = new CategoryRepository();

    public CategoryService() throws SQLException {
    }

    public void register(Category category) throws SQLException {
        int result = categoryRepository.save(category);
        if (result != 0)
            System.out.println(category.getName() + " successfully added to database");
        else
            System.out.println("ERROR");
    }

    public void updateCategory() throws SQLException {
        System.out.println("id: ");
        int id = scanner.nextInt();
        System.out.println("please enter your new name category: ");
        String name = scanner.nextLine();
        System.out.println("please enter your new description category: ");
        String description = scanner.nextLine();
        int result = categoryRepository.update(name, description, id);
        if (result != 0)
            System.out.println("successfully update to database");
        else
            System.out.println("ERROR");
    }

    public void delete(int id) throws SQLException {
        int result = categoryRepository.delete(id);
        if (result != 0)
            System.out.println("successfully deleted from database");
        else
            System.out.println("ERROR");
    }
}
