public class Customer {
    private String fullName;
    private String birthDay;
    private String address;
    private String image;

    public Customer(String fullName, String birthDay, String address, String image) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.address = address;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getAddress() {
        return address;
    }
}
