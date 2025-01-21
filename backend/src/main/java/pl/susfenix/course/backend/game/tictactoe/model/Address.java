package pl.susfenix.course.backend.game.tictactoe.model;

public class Address {

    private String street;
    private String houseNumber;
    private int flatNumber;
    private String postalCode;

    public Address(String street, String houseNumber, int flatNumber, String postalCode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", flatNumber=" + flatNumber +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
