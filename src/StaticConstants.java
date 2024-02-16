import balance.Balance;
import category.Category;
import discount.Discount;

import java.util.ArrayList;
import java.util.List;

public class StaticConstants {
    // THIS IS A DATA BASE CLASS
    // PARENT Type Only
    // List of < CustomerParent has also List of <Address> >
    public static final List<Customer> CUSTOMER_LIST = new ArrayList<>();

    public static final List<Category> CATEGORY_LIST = new ArrayList<>();

    public static final List<Product> PRODUCT_LIST = new ArrayList<>();

    public static final List<Balance> CUSTOMER_BALANCE_LIST = new ArrayList<>();
    public static final List<Balance> GIFT_CARD_BALANCE_LIST = new ArrayList<>();

    // Discount
    public static final List<Discount> DISCOUNT_LIST = new ArrayList<>();


}
