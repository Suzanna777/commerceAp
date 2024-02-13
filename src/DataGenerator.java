import category.Category;
import category.Electronic;
import category.Furniture;
import category.SkinCare;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataGenerator {
    // List of < Address> + Customer with List of <Address> = ad to the DATA List of <Customer>
    // Data Base now has all customers with address, email, username
    public static void createCustomer() {
        Address addressCustomer1 =
                new Address("7660", "beverly blvd", "app 431", "90036", "CA");
        Address addressCustomer2 =
                new Address("82A", "Ormanova", "A", "0007", "KZ");
        Address addressCustomer3 =
                new Address("7661", "beverly str", "app 43", "90039", "CA");
        Address addressCustomer4 =
                new Address("82", "Lenina", "4", "0008", "KZ");


        // add to the Data classList of <Address> OLE .ADD to the Customer1 2, and 3
        List<Address> customer1AddressList = new ArrayList<>();
        customer1AddressList.add(addressCustomer1);
        customer1AddressList.add(addressCustomer2);
        customer1AddressList.add(addressCustomer3);
        customer1AddressList.add(addressCustomer4);

        // calling customer with List of <Address>
        Customer customer1 =
                new Customer(UUID.randomUUID(), "amina", "magic@gmail.com", customer1AddressList);
        Customer customer2 =
                new Customer(UUID.randomUUID(), "alina", "alina@gmail.com", customer1AddressList);
        Customer customer3 =
                new Customer(UUID.randomUUID(), "ruslan", "ruslan@gmail.com", customer1AddressList);
        Customer customer4 =
                new Customer(UUID.randomUUID(), "suzanna", "suzanna@gmail.com", customer1AddressList);

        // class name .method name .add(customer 1 with List of <Address>)
        StaticConstants.CUSTOMER_LIST.add(customer1);
        StaticConstants.CUSTOMER_LIST.add(customer2);
        StaticConstants.CUSTOMER_LIST.add(customer3);
        StaticConstants.CUSTOMER_LIST.add(customer4);
    }

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


    public static void createProduct(){
        Product product1 =
                new Product(UUID.randomUUID(), "PSP", 550.99, 200, 10, StaticConstants.CATEGORY_LIST.get(0).getId());
        Product product2 =
                new Product(UUID.randomUUID(), "MacBook", 1200.00, 20, 5, StaticConstants.CATEGORY_LIST.get(1).getId());

        Product product3 =
                new Product(UUID.randomUUID(), "Iphone 14", 1100.00, 30, 10, StaticConstants.CATEGORY_LIST.get(2).getId());

        // Data class methodName() .add(thisNewProductName)
        StaticConstants.PRODUCT_LIST.add(product1);
        StaticConstants.PRODUCT_LIST.add(product2);
        StaticConstants.PRODUCT_LIST.add(product3);







    }

}
/* Data generate and create for all new costumer
   1. static method() - can be call trow the class name .methodName()
   2. Calling class Address and providing parameters
   3. Calling class Customer and providing parameters
      3.1 Customer class has parameter of Collection Interface List of Type <Address>
      3.2 Calling the Collection interface List of <Address>
      3.3 Ad every address to the List of the <Address>


* */