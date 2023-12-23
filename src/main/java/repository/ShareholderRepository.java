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
}
