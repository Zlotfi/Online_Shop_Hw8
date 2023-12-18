package service;

import entity.Category;
import entity.User;
import repository.CategoryRepository;

import java.sql.SQLException;

public class CategoryService {

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
}
