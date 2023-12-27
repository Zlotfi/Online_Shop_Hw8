package menu;

import entity.*;
import service.*;
import utility.ApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService = ApplicationContext.getUserService();
    private final CategoryService categoryService = ApplicationContext.getCategoryService();
    private final BrandService brandService = new BrandService();
    private final ProductService productService = new ProductService();
    private final ShareholderService shareholderService = new ShareholderService();

    public Menu() throws SQLException {
    }

    public void publicMenu() throws SQLException {
        System.out.println("***Welcome***");
        System.out.println("1- Sign in");
        System.out.println("2- Sign up");
        System.out.println("3- Exit");
        System.out.println("enter your select: ");
        int select = scanner.nextInt();
        scanner.nextLine();
        switch (select) {
            case 1 -> enter();
            case 2 -> register();
            case 3 -> System.out.println("Exit");
            default -> System.out.println("error");
        }
    }

    public void register() throws SQLException {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your userName: ");
        String userName = scanner.nextLine();
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        User user = new User(null, name, userName, email, password);
        userService.register(user);
    }

    public void registerCategory() throws SQLException {
        System.out.println("Enter your category name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your category description: ");
        String description = scanner.nextLine();

        Category category = new Category(null, name, description);
        categoryService.register(category);
    }

    public void registerBrand() throws SQLException {
        System.out.println("Enter your brand name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your brand website: ");
        String website = scanner.nextLine();
        System.out.println("Enter your brand description: ");
        String description = scanner.nextLine();

        Brand brand = new Brand(null, name, website, description);
        brandService.register(brand);
    }

    public void registerProduct() throws SQLException {
        System.out.println("Enter your product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your createDate: ");
        String createDate = scanner.nextLine();
        System.out.println("Enter your category_id: ");
        int category_id = scanner.nextInt();
        System.out.println("Enter your brand_id: ");
        int brand_id = scanner.nextInt();

        Product product = new Product(null, name, createDate, category_id, brand_id);
        productService.register(product);
    }

    public void registerShareholder() throws SQLException {
        System.out.println("Enter your shareholder name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your shareholder phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter your nationalCode: ");
        String nationalCode = scanner.nextLine();

        Shareholder shareholder = new Shareholder(null, name, phoneNumber, nationalCode);
        shareholderService.register(shareholder);
    }

    public void enter() throws SQLException {
        System.out.println("Enter your userName: ");
        String userName = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        User user = userService.login(userName);
        if ((user == null) && !user.getPassword().equals(password))
            System.out.println("you enter a userName and password incorrect");
        else {
            boolean isTrue = true;
            while (isTrue) {

                System.out.println("=========================================");
                System.out.println("1- User");
                System.out.println("2- Category");
                System.out.println("3- Brand");
                System.out.println("4- Product");
                System.out.println("5- Shareholder");
                System.out.println("6- Exit");
                System.out.println("Enter your selectNumber: ");
                int selectNumber = scanner.nextInt();
                scanner.nextLine();
                switch (selectNumber) {
                    case 1 -> {
                        System.out.println("=======================================");
                        System.out.println("1- update User");
                        System.out.println("2- delete User");
                        System.out.println("3- Exit");
                        System.out.println("enter your number: ");
                        int number = scanner.nextInt();
                        scanner.nextLine();
                        switch (number) {
                            case 1 -> userService.updateUser();
                            case 2 -> userService.delete();
                            case 3 -> isTrue = false;
                            default -> System.out.println("ERROR");
                        }
                    }
                    case 2 -> {
                        System.out.println("=======================================");
                        System.out.println("1- add Category");
                        System.out.println("2- update Category");
                        System.out.println("3- delete Category");
                        System.out.println("4- Exit");
                        System.out.println("enter your numbers: ");
                        int numbers = scanner.nextInt();
                        scanner.nextLine();
                        switch (numbers) {
                            case 1 -> registerCategory();
                            case 2 -> categoryService.updateCategory();
                            case 3 -> categoryService.delete();
                            case 4 -> isTrue = false;
                            default -> System.out.println("ERROR");
                        }
                    }
                    case 3 -> {
                        System.out.println("=======================================");
                        System.out.println("1- add Brand");
                        System.out.println("2- update Brand");
                        System.out.println("3- delete Brand");
                        System.out.println("4- Exit");
                        System.out.println("Enter your num: ");
                        int num = scanner.nextInt();
                        scanner.nextLine();
                        switch (num) {
                            case 1 -> registerBrand();
                            case 2 -> brandService.updateBrand();
                            case 3 -> brandService.delete();
                            case 4 -> isTrue = false;
                            default -> System.out.println("ERROR");
                        }
                    }
                    case 4 -> {
                        System.out.println("=========================================");
                        System.out.println("1- add Product");
                        System.out.println("2- update Product");
                        System.out.println("3- delete Product");
                        System.out.println("4- Exit");
                        System.out.println("Enter your number: ");
                        int number1 = scanner.nextInt();
                        scanner.nextLine();
                        switch (number1) {
                            case 1 -> registerProduct();
                            case 2 -> productService.updateProduct();
                            case 3 -> productService.delete();
                            case 4 -> isTrue = false;
                            default -> System.out.println("ERROR");
                        }
                    }
                    case 5 -> {
                        System.out.println("============================================");
                        System.out.println("1- add Shareholder");
                        System.out.println("2- update Shareholder");
                        System.out.println("3- delete Shareholder");
                        System.out.println("4- Exit");
                        System.out.println("Enter your number");
                        int number2 = scanner.nextInt();
                        scanner.nextLine();
                        switch (number2) {
                            case 1 -> registerShareholder();
                            case 2 -> shareholderService.updateShareholder();
                            case 3 -> shareholderService.delete();
                            case 4 -> isTrue = false;
                            default -> System.out.println("ERROR");
                        }
                    }
                    case 6 -> isTrue = false;
                    default -> System.out.println("ERROR 404");
                }
            }
        }
    }
}
