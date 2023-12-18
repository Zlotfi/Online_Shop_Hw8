package repository;

import connection.JdbcConnection;
import entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryRepository {

    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();
    public CategoryRepository() throws SQLException {
    }


    public int save(Category category) throws SQLException {
        String add = "INSERT INTO category (name, description) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setString(1,category.getName());
        preparedStatement.setString(2,category.getDescription());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int update(String name, String description, int id) throws SQLException {
        String query = "UPDATE category SET name = ?, description = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,description);
        preparedStatement.setInt(3,id);
        int result = preparedStatement.executeUpdate();
        return result;
    }
}
