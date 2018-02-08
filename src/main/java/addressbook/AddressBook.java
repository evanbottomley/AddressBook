package addressbook;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
public class AddressBook {



    @Id
    @GeneratedValue
    private Integer id = null;



    private String owner;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> friends;

    public AddressBook(String owner) {
        this.owner = owner;
        friends = new ArrayList<BuddyInfo>();
    }

    public AddressBook() {
        this("Default");
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public BuddyInfo getFriend(int index) {
        return friends.get(index);
    }
    public List<BuddyInfo> getFriends() { return friends; }
    public int getSize() { return friends.size(); }

    public void addBuddy(BuddyInfo b) {
        friends.add(b);
    }

    public void removeBuddy(BuddyInfo b) {
        friends.remove(b);
    }

    public void removeBuddyIndex(int index) { friends.remove(index); }

    public void printBook() {
        System.out.println("Address book contains " + friends.size() + " friend(s).");
        for (int i = 0; i < friends.size(); i++) {
            BuddyInfo buddy = friends.get(i);
            System.out.println(buddy.getBuddyName() + "  " + buddy.getBuddyAddress() + "  " + buddy.getPhoneNumber());
        }
    }

    @Override
    public String toString() {
        return String.format(
                "AddressBook[id=%i, owner='%s', size='%i']",
                id, owner, friends.size());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AddressBook)) return false;
        AddressBook ab = (AddressBook) o;
        if (friends.size() != ab.getSize()) return false;
        for (int i = 0; i < friends.size(); i++) {
            if (!friends.get(i).equals(ab.getFriend(i))) return false;
        }
        return true;
    }

    /*
    public static void main(String[] args) {
        BuddyInfo homer = new BuddyInfo("Homer", "123 Springfield Drive", "613-888-7667");
        BuddyInfo sherlock = new BuddyInfo("Sherlock", "221B Baker Street", "613-765-4321");
        AddressBook book = new AddressBook();
        book.addBuddy(homer);
        book.addBuddy(sherlock);
        book.printBook();
        System.out.println("Test Complete.");
    }
    */
}
