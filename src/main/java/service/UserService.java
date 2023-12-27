package service;

import entity.User;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {

    Scanner scanner = new Scanner(System.in);

    private final UserRepository userRepository = new UserRepository();

    public UserService() throws SQLException {
    }

    public void register(User user) throws SQLException {
        int result = userRepository.save(user);
        if (result != 0)
            System.out.println(user.getName() + " successfully added to database");
        else
            System.out.println("!!!ERROR!!!");
    }

    public User login(String userName) throws SQLException {
        User user = userRepository.login(userName);
        return user;
    }

    public void updateUser() throws SQLException {
        System.out.println("id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("please enter your new name: ");
        String name = scanner.nextLine();
        System.out.println("please enter your new userName: ");
        String userName = scanner.nextLine();
        System.out.println("please enter your new email: ");
        String email = scanner.nextLine();
        System.out.println("please enter your new password: ");
        String password = scanner.nextLine();
        int result = userRepository.update(name, userName, email, password,id);
        if (result != 0)
            System.out.println("successfully update to database");
        else
            System.out.println("ERROR!");
    }

    public void delete() throws SQLException {
        System.out.println("id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        int result = userRepository.delete(id);
        if (result != 0)
            System.out.println("successfully deleted from database");
        else
            System.out.println("ERROR!!");
    }
}
