package service;

import entity.Shareholder;
import repository.ShareholderRepository;

import java.sql.SQLException;

public class ShareholderService {

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
}
