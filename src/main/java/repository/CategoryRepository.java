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
        preparedStatement.setString(2,category.getDescription());.
        int result = preparedStatement.executeUpdate();
        return result;
    }
}
