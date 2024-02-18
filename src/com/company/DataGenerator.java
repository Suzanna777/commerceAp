package com.company;

import com.company.Address;
import com.company.Customer;
import com.company.balance.Balance;
import com.company.balance.CustomerBalance;
import com.company.balance.GiftCardBalance;
import com.company.category.Category;
import com.company.category.Electronic;
import com.company.category.Furniture;
import com.company.category.SkinCare;
import com.company.discount.AmountBasedDiscount;
import com.company.discount.Discount;
import com.company.discount.RateBasedDiscount;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataGenerator {
    // List of < com.company.Address> + com.company.Customer with List of <com.company.Address> = ad to the DATA List of <com.company.Customer>
    // Data Base now has all customers with address, email, username

    // com.company.Customer
    public static void createCustomer() {
        Address addressCustomer1 =
                new Address("7660", "beverly blvd", "app 431", "90036", "CA");
        Address addressCustomer2 =
                new Address("82A", "Ormanova", "A", "0007", "KZ");
        Address addressCustomer3 =
                new Address("7661", "beverly str", "app 43", "90039", "CA");
        Address addressCustomer4 =
                new Address("82", "Lenina", "4", "0008", "KZ");


        // add to the Data classList of <com.company.Address> OLE .ADD to the Customer1 2, and 3
        List<Address> customer1AddressList = new ArrayList<>();
        customer1AddressList.add(addressCustomer1);
        customer1AddressList.add(addressCustomer2);
        customer1AddressList.add(addressCustomer3);
        customer1AddressList.add(addressCustomer4);

        // calling customer with List of <com.company.Address>
        Customer customer1 =
                new Customer(UUID.randomUUID(), "amina", "magic@gmail.com", customer1AddressList);
        Customer customer2 =
                new Customer(UUID.randomUUID(), "alina", "alina@gmail.com", customer1AddressList);
        Customer customer3 =
                new Customer(UUID.randomUUID(), "ruslan", "ruslan@gmail.com", customer1AddressList);
        Customer customer4 =
                new Customer(UUID.randomUUID(), "suzanna", "suzanna@gmail.com", customer1AddressList);

        // class name .method name .add(customer 1 with List of <com.company.Address>)
        StaticConstants.CUSTOMER_LIST.add(customer1);
        StaticConstants.CUSTOMER_LIST.add(customer2);
        StaticConstants.CUSTOMER_LIST.add(customer3);
        StaticConstants.CUSTOMER_LIST.add(customer4);
    }

    // Category
    public static void createCategory() {
        // 1. Parent = new Child (all variable)
        Category category1 =
                new Electronic(UUID.randomUUID(), "Electronic");
        Category category2 =
                new Furniture(UUID.randomUUID(), "Furniture");
        Category category3 =
                new SkinCare(UUID.randomUUID(), "SkinCare");

        // 2. add to the Data class - were we keep all-Parents Type in the List of <Category> in the static method()
        StaticConstants.CATEGORY_LIST.add(category1); // calling the static method - by class name  .methodName() .addToList
        StaticConstants.CATEGORY_LIST.add(category2);
        StaticConstants.CATEGORY_LIST.add(category3);
    }

    // com.company.Product
    public static void createProduct(){
        Product product1 =
                new Product(UUID.randomUUID(), "PSP", 550.99, 200, 10, StaticConstants.CATEGORY_LIST.get(0).getId());
        Product product2 =
                new Product(UUID.randomUUID(), "MacBook", 1200.00, 20, 5, StaticConstants.CATEGORY_LIST.get(0).getId());

        Product product3 =
                new Product(UUID.randomUUID(), "Iphone 14", 1100.00, 30, 10, StaticConstants.CATEGORY_LIST.get(0).getId());

        Product product4 =
                new Product(UUID.randomUUID(), "Chanel cream", 100.00, 15, 10, StaticConstants.CATEGORY_LIST.get(1).getId());

        Product product5 =
                new Product(UUID.randomUUID(), "Ikea sofa", 700.00, 5, 10, StaticConstants.CATEGORY_LIST.get(2).getId());
        // Data class methodName() .add(thisNewProductName)
        StaticConstants.PRODUCT_LIST.add(product1);
        StaticConstants.PRODUCT_LIST.add(product2);
        StaticConstants.PRODUCT_LIST.add(product3);
        StaticConstants.PRODUCT_LIST.add(product4);
        StaticConstants.PRODUCT_LIST.add(product5);

    }

    // Balance
    public static void createBalance(){
        Balance customerBalance = new CustomerBalance(StaticConstants.CUSTOMER_LIST.get(0).getId(), 500.00);
        Balance giftCardBalance = new GiftCardBalance(StaticConstants.CUSTOMER_LIST.get(1).getId(), 200.00);


        StaticConstants.CUSTOMER_BALANCE_LIST.add(customerBalance);
        StaticConstants.GIFT_CARD_BALANCE_LIST.add(giftCardBalance);

    }


    // Discount
    public static void createDiscount(){
        Discount amountBasedDiscount = new AmountBasedDiscount(UUID.randomUUID(), "Buy $250 Free $50", 250.00, 50.00);
        Discount rateBasedDiscount = new RateBasedDiscount(UUID.randomUUID(), "Buy $500 Free 15%", 500.00, 15.00);

        StaticConstants.DISCOUNT_LIST.add(amountBasedDiscount);
        StaticConstants.DISCOUNT_LIST.add(rateBasedDiscount);


    }






}
/* Data generate and create for all new costumer
   1. static method() - can be call trow the class name .methodName()
   2. Calling class com.company.Address and providing parameters
   3. Calling class com.company.Customer and providing parameters
      3.1 com.company.Customer class has parameter of Collection Interface List of Type <com.company.Address>
      3.2 Calling the Collection interface List of <com.company.Address>
      3.3 Ad every address to the List of the <com.company.Address>


* */