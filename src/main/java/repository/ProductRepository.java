package repository;

import connection.JdbcConnection;
import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductRepository {

    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public ProductRepository() throws SQLException {
    }

    public int save(Product product) throws SQLException {
        String add = "INSERT INTO product (name, createDate, category_id, brand_id) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getCreateDate());
        preparedStatement.setInt(3,product.getCategory_id());
        preparedStatement.setInt(4,product.getBrand_id());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int update(String name, String createDate, int category_id, int brand_id, int id) throws SQLException {
        String query = "UPDATE product SET name = ?, createDate = ?, category_id = ?, brand_id = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,createDate);
        preparedStatement.setInt(3,category_id);
        preparedStatement.setInt(4,brand_id);
        preparedStatement.setInt(5,id);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int delete(int id) throws SQLException {
        String query = "DELETE FROM product WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        int result = preparedStatement.executeUpdate();
        return result;
    }
}
