
import java.util.List;
import java.util.UUID;

public class Customer {
    /*Type name;
     primitive or non-primitive (obj class)
     more than one address - Collection Interface is preferable Polymorphism

     */

    private UUID id; // create the random id
    private String userName;
    private String email;
    private List<Address> address;

    // con 1 - overloading in the same class
    public Customer(UUID id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }
    // con 2
    public Customer(UUID id, String userName, String email, List<Address> address) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.address = address;
    }

    // get()
    public void setId(UUID id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
