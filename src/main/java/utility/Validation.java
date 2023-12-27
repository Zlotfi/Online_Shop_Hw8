package utility;

import java.util.regex.Pattern;

public class Validation {

    public static boolean isValidEmailWithRegex(String email){
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        return email.matches(pattern.pattern());
    }

    public static boolean isValidPasswordWithRegex(String password){
        Pattern pattern = Pattern.compile
                ("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$");
        return password.matches(pattern.pattern());
    }

    public static boolean isValidWebsiteWithRegex(String website){
        Pattern pattern = Pattern.compile("^(ftp|http|https):\\/\\/[^ \"]+$");
        return website.matches(pattern.pattern());
    }
}
