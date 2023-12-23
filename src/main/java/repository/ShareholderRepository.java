package repository;

import connection.JdbcConnection;
import entity.Shareholder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShareholderRepository {

    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public ShareholderRepository() throws SQLException {
    }

    public int save(Shareholder shareholder) throws SQLException {
        String add = "INSERT INTO shareholder (name, phoneNumber, nationalCode) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setString(1,shareholder.getName());
        preparedStatement.setString(2,shareholder.getPhoneNumber());
        preparedStatement.setString(3,shareholder.getNationalCode());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int update(String name, String phoneNumber, String nationalCode, int id) throws SQLException {
        String query = "UPDATE shareholder SET name = ?, phoneNumber = ?, nationalCode = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,phoneNumber);
        preparedStatement.setString(3,nationalCode);
        preparedStatement.setInt(4,id);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int delete(int id) throws SQLException {
        String query = "DELETE FROM shareholder WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        int result = preparedStatement.executeUpdate();
        return result;
    }
}
