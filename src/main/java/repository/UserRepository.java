package repository;

import connection.JdbcConnection;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private final Connection connection;

    public UserRepository(Connection connection){
        this.connection = connection;
    }

    public int save(User user) throws SQLException {
        String add = "INSERT INTO user2(name, userName, email, password) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUserName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public User login(String userName) throws SQLException {
        String loginQuery = "SELECT * FROM user2 WHERE userName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
        preparedStatement.setString(1,userName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            User user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("userName"),
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );
            return user;
        }
        else
            return null;
    }

    public int update(String name, String userName, String email, String password, int id) throws SQLException {
        String query = "UPDATE user2 SET name = ?, userName = ?, email = ?, password = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,userName);
        preparedStatement.setString(3,email);
        preparedStatement.setString(4,password);
        preparedStatement.setInt(5,id);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int delete(int id) throws SQLException {
        String query = "DELETE FROM user2 WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        int result = preparedStatement.executeUpdate();
        return result;
    }
}
