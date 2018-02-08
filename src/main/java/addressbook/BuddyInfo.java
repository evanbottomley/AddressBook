package addressbook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private Integer id = null;
    private String buddyName;
    private String buddyAddress;
    private String phoneNumber;

    @ManyToOne
    private AddressBook book;

    public BuddyInfo() {
        this("Default", "Default", "000-0000");
    }

    public BuddyInfo(String bN, String bA, String pN) {
        buddyName = bN;
        buddyAddress = bA;
        phoneNumber = pN;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getBuddyName() {
        return buddyName;
    }

    public void setBuddyName(String buddyName) {
        this.buddyName = buddyName;
    }

    public String getBuddyAddress() {
        return buddyAddress;
    }

    public void setBuddyAddress(String buddyAddress) {
        this.buddyAddress = buddyAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressBook getBook() { return book; }

    public void setBook(AddressBook book) { this.book = book; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BuddyInfo)) return false;
        BuddyInfo b = (BuddyInfo) o;
        if (!buddyName.equals(b.getBuddyName())) return false;
        if (!buddyAddress.equals(b.getBuddyAddress())) return false;
        if (!phoneNumber.equals(b.getPhoneNumber())) return false;
        return true;
    }

    /*
    public static void main(String[] args) {
        BuddyInfo homer = new BuddyInfo();
        homer.setBuddyName("Homer");
        homer.setBuddyAddress("123 Springfield Drive");
        homer.setPhoneNumber("613-888-7667");
        System.out.println("Hello, " + homer.getBuddyName() + "!");
    }
    */
}
