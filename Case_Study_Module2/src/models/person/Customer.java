package models.person;

public class Customer extends Person implements Comparable<Customer> {
    private CustomerType customerType;

    public Customer(String fullName, String address, String birthDay,
                    String id, String phoneNumber, String email,
                    Gender gender, CustomerType customerType) {
        super(fullName, address, birthDay, id, phoneNumber, email, gender);
        this.customerType = customerType;
    }

    public Customer() {
        super();
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    private int getYear(String birthDay){
        return Integer.parseInt(birthDay.substring(6));
    }

    @Override
    public String toString() {
        return "Customer{ fullName= " + getFullName() + "; address= " + getAddress() +
                "; birthDay= " + getBirthDay() + "; id= " + getId() + "; phoneNumber= " + getPhoneNumber() +
                "; email= " + getEmail() + "; gender= " + getGender() + "; type= " + getCustomerType() + " }";

    }

    @Override
    public int compareTo(Customer o) {
        var compareByName = getFullName().compareTo(o.getFullName());
        var compareByYear = getYear(this.getBirthDay()) - getYear(o.getBirthDay());

        if( compareByName == 0)
            return compareByYear ;

        return compareByName;
    }

    public static void main(String[] args) {
        // parents - child
        // superclass - subclass
        // base - derived
    }
}
