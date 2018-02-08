package addressbook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {

    BuddyInfo homer;
    AddressBook book;

    @Before
    public void setUp() throws Exception {
        book = new AddressBook();
        homer = new BuddyInfo("Homer", "123 Springfield Drive", "613-888-7667");
    }

    @Test
    public void addBuddyTest() throws Exception {
        Assert.assertEquals(0, book.getSize());
        book.addBuddy(homer);
        Assert.assertEquals(1, book.getSize());
        Assert.assertEquals("Homer", book.getFriend(0).getBuddyName());
    }

    @Test
    public void removeBuddyTest() throws Exception {
        book.addBuddy(homer);
        Assert.assertEquals(1, book.getSize());
        book.removeBuddy(homer);
        Assert.assertEquals(0, book.getSize());
    }

}