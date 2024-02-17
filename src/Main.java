import balance.Balance;
import balance.CustomerBalance;
import balance.GiftCardBalance;
import category.Category;
import discount.Discount;

import java.util.HashMap;
import java.util.Map;
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

        // Cart for every customer to use
        Cart cart = new Cart(customer);

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
                    switch (balanceAccountSelection) {
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
                    Map<Product, Integer> productCart = new HashMap<>();
                    // empty cart - write every product that was in the product cart added
                    cart.setProductMap(productCart);
                    while (true) { // do this while the product would not stop to add to the cart
                        System.out.println("What product would you like to add to the cart: For exit the product selection please type exit ");
                        // show the product selection
                        for (Product eachProduct : StaticConstants.PRODUCT_LIST) {
                            // try this and catch Exception
                            try {
                                System.out.println(" id: " + eachProduct.getId() +
                                        " price: $" + eachProduct.getPrice() +
                                        " Product category: " + eachProduct.getCategoryName() +
                                        " Stock: " + eachProduct.getStock() +
                                        " Remaining Stock: " + eachProduct.getRemainingStock() +
                                        " Product Delivery Date: " + eachProduct.getDeliveryDueDate());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        String productId = scanner.next();
                        try {
                            Product eachProduct = findProductById(productId);
                            // if the product is NOT available in stock?
                            if (!productInCartAvailableInStock(cart, eachProduct)) {
                                System.out.println("Stock is insufficient. Please try again");
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("Product did not found, Try again");
                            continue;
                        }
                        System.out.println("Do you want to add more product to the car? Type Y to continue. Type N to exit ?");
                        String decision = scanner.next();
                        if (!decision.equals("Y")) {
                            break;
                        }
                    }
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

    public static Product findProductById(String productId) throws Exception {
        for (Product eachProduct : StaticConstants.PRODUCT_LIST) {
            if (eachProduct.getId().toString().equals(productId)) {
                return eachProduct;
            }
        }
        throw new Exception("Product not found");

    }

    public static boolean productInCartAvailableInStock(Cart cart, Product product) {
        System.out.println("Please provide product count: ");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        // how many products are available in stock?
        Integer cartCount = cart.getProductMap().get(product);

        if (cartCount != null && product.getRemainingStock() > cartCount + count) {
            cart.getProductMap().put(product, cartCount + count);
            return true;
        } else if (product.getRemainingStock() > count) {
            cart.getProductMap().put(product, count);
            return true;
        }
        return false;
    }

}
