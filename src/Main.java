import balance.Balance;
import balance.CustomerBalance;
import balance.GiftCardBalance;
import category.Category;
import discount.Discount;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        DataGenerator.createCustomer();
        DataGenerator.createCategory();
        DataGenerator.createProduct();
        DataGenerator.createBalance();
        DataGenerator.createDiscount();

        // Scanner for specific customer to give him a discount
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select customer: ");

        for (int i = 0; i < StaticConstants.CUSTOMER_LIST.size(); i++) {
            System.out.println("Type " + i + " for customer: " + StaticConstants.CUSTOMER_LIST.get(i).getUserName());
        }

        // bring the customer from the Database (StaticConstants)
        Customer customer = StaticConstants.CUSTOMER_LIST.get(scanner.nextInt());

        while (true) {
            System.out.println("What would you like to do ? Just type your id for selection ");

            for (int i = 0; i < prepareMenuOptions().length; i++) {
                System.out.println(i + "-" + prepareMenuOptions()[i]);
            }

            int menuSelection = scanner.nextInt();

            switch (menuSelection) {
                case 0: // list category class take from database class
                    for (Category category : StaticConstants.CATEGORY_LIST) {
                        System.out.println("Category Code: " + category.generateCategoryCode() + " Category name: " + category.getName());
                    }
                    break;
                case 1: // List Product
                    // exception
                    try {
                        for (Product product : StaticConstants.PRODUCT_LIST) {
                            System.out.println(" Product Name: " + product.getName() + " Product category name: " + product.getCategoryName());
                        }
                    } catch (Exception e) {
                        System.out.println("Product could not printed because category is not found for product name " + e.getMessage().split(",")[1]);
                    }

                    break;
                case 2: // Discount List
                    for (Discount discount : StaticConstants.DISCOUNT_LIST) {
                        System.out.println("Discount " + discount.getName() + " Discount Threshold Amount " + discount.getThresholdAmount());
                    }
                    break;
                case 3: // See Balance
                    CustomerBalance seeBalance = findCustomerBalance(customer.getId());
                    GiftCardBalance seeGiftCardBalance = findGiftCardBalance(customer.getId());

                    double totalBalance = seeBalance.getBalance() + seeGiftCardBalance.getBalance();
                    System.out.println("total Balance: " + totalBalance);
                    System.out.println("Balance: " + seeBalance.getBalance());
                    System.out.println("Gift Card Balance: " + seeGiftCardBalance.getBalance());
                    break;
                case 4: // "Add Balance",
                    System.out.println("Which account do you want to add? ");
                    CustomerBalance customBalance = findCustomerBalance(customer.getId());
                    GiftCardBalance giftBalanceCard = findGiftCardBalance(customer.getId());

                    System.out.println("Type 1 for customer balance " + customBalance.getBalance());
                    System.out.println("Type 2 for gift balance " + giftBalanceCard.getBalance());

                    int balanceAccountSelection = scanner.nextInt();
                    System.out.println("How much do like to add?");
                    double additionalAmount = scanner.nextInt();

                    switch (balanceAccountSelection){
                        case 1:
                            customBalance.addBalance(additionalAmount);
                            System.out.println("New customer balance" + customBalance.getBalance());
                            break;
                        case 2:
                            giftBalanceCard.addBalance(additionalAmount);
                            System.out.println("New gift card balance " + giftBalanceCard.getBalance());
                            break;
                    }
                    break;
                case 5:  // "Place an Order",
                    for (Customer customer1 : StaticConstants.CUSTOMER_LIST)
                        break;
                case 6: // "See Cart"

                    break;
                case 7: //  "See Order Details",

                    break;
                case 8: //  "See your address ", "Close App"
                    break;

            }

        }


    }

    // creating the array method in the Main can be private or pblick
    private static String[] prepareMenuOptions() {

        return new String[]{"List Categories", "List Product",
                "List Discount", "See Balance ",
                "Add Balance", "Place an Order",
                "See Cart", "See Order Details",
                "See your address ", "Close App"};
    }

    public static CustomerBalance findCustomerBalance(UUID customerId) {
        for (Balance balanceCustomer : StaticConstants.CUSTOMER_BALANCE_LIST) {
            if (balanceCustomer.getCustomerId().toString().equals(customerId.toString())) {
                return (CustomerBalance) balanceCustomer;
            }
        }
        CustomerBalance customerBalance = new CustomerBalance(customerId, 0d);
        StaticConstants.CUSTOMER_BALANCE_LIST.add(customerBalance);
        return customerBalance;
    }

    public static GiftCardBalance findGiftCardBalance(UUID customerId) {
        for (Balance balanceGiftCard : StaticConstants.GIFT_CARD_BALANCE_LIST) {
            if (balanceGiftCard.getCustomerId().toString().equals(customerId.toString())) {
                return (GiftCardBalance) balanceGiftCard;
            }
        }
        GiftCardBalance giftBalance = new GiftCardBalance(customerId, 0d);
        StaticConstants.GIFT_CARD_BALANCE_LIST.add(giftBalance);
        return giftBalance;
    }

}