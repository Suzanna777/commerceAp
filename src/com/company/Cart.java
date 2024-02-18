package com.company;

import java.util.Map;
import java.util.UUID;

public class Cart {
    private Customer customer;
    private UUID discountId;
   // com.company.Product - milk, 10
    private Map<Product, Integer> productMap;

    public Cart(Customer customer) {
        this.customer = customer;
    }

    public Cart(Customer customer, UUID discountId, Map<Product, Integer> productMap) {
        this.customer = customer;
        this.discountId = discountId;
        this.productMap = productMap;
    }


    public Double calculateCartTotalAmount(){
        double totalAmount = 0;
       // for each product from the ProductBox where a key and value in the Set - key com.company.Product milk, value int 10$
        for (Product eachProduct : productMap.keySet()){
            // each product finds the price $ * ( int quententy )
            totalAmount += eachProduct.getPrice() * productMap.get(eachProduct);
        }
        return totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public UUID getDiscountId() {
        return discountId;
    }

    public void setDiscountId(UUID discountId) {
        this.discountId = discountId;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }


}
