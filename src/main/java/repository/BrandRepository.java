package repository;

import connection.JdbcConnection;
import entity.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BrandRepository {

    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public BrandRepository() throws SQLException {
    }

    public int save(Brand brand) throws SQLException {
        String add = "INSERT INTO brand (name, website, description) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setString(1,brand.getName());
        preparedStatement.setString(2,brand.getWebsite());
        preparedStatement.setString(3,brand.getDescription());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int update(String name, String website, String description, int id) throws SQLException {
        String query = "UPDATE brand SET name = ?, website = ?, description = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,website);
        preparedStatement.setString(3,description);
        preparedStatement.setInt(4,id);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int delete(int id) throws SQLException {
        String query = "DELETE FROM brand WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        int result = preparedStatement.executeUpdate();
        return result;
    }
}
