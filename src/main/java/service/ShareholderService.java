package service;

import entity.Shareholder;
import repository.ShareholderRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ShareholderService {

    Scanner scanner = new Scanner(System.in);
    private final ShareholderRepository shareholderRepository = new ShareholderRepository();

    public ShareholderService() throws SQLException {
    }

    public void register(Shareholder shareholder) throws SQLException {
        int result = shareholderRepository.save(shareholder);
        if (result != 0)
            System.out.println(shareholder.getName() + " successfully added to database");
        else
            System.out.println("ERROR");
    }

    public void updateShareholder() throws SQLException {
        System.out.println("id: ");
        int id = scanner.nextInt();
        System.out.println("please enter your new name: ");
        String name = scanner.nextLine();
        System.out.println("please enter your new phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("please enter your new nationalCode: ");
        String nationalCode = scanner.nextLine();

        int result = shareholderRepository.update(name,phoneNumber,nationalCode,id);
        if (result != 0)
            System.out.println("successfully update to database");
        else
            System.out.println("ERROR");
    }

    public void delete() throws SQLException {
        System.out.println("id: ");
        int id = scanner.nextInt();
        int result = shareholderRepository.delete(id);
        if (result != 0)
            System.out.println("successfully deleted from database");
        else
            System.out.println("OOps!!");
    }
}
