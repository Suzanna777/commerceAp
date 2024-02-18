package com.company.checkout;

import com.company.Customer;
import com.company.balance.CustomerBalance;
import com.company.balance.GiftCardBalance;

import static com.company.Main.findCustomerBalance;
import static com.company.Main.findGiftCardBalance;

public class MixPaymentCheckoutService implements CheckoutService{

    @Override
    public boolean checkout(Customer customer, Double totalAmount) {
       try {
           GiftCardBalance giftCardBalance = findGiftCardBalance(customer.getId());
           final double giftBalance = giftCardBalance.getBalance() - totalAmount;
           if(giftBalance > 0){
               giftCardBalance.setBalance(giftBalance);
           }else {
               CustomerBalance customerBalance = findCustomerBalance(customer.getId());
               final double mixBalance = giftCardBalance.getBalance() + customerBalance.getBalance() - totalAmount;
               if(mixBalance > 0){
                   giftCardBalance.setBalance(0d);
                   customerBalance.setBalance(mixBalance);
                   return true;
               }
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
        return false;
    }
}
