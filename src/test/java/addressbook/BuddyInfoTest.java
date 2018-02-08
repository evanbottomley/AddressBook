package addressbook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BuddyInfoTest {

    BuddyInfo homer;

    @Before
    public void setUp() throws Exception {
        homer = new BuddyInfo("Homer", "123 Springfield Drive", "613-888-7667");
    }

    @Test
    public void getBuddyName() throws Exception {
        Assert.assertEquals("Homer", homer.getBuddyName());
    }

    @Test
    public void setBuddyName() throws Exception {
        homer.setBuddyName("Sherlock");
        Assert.assertEquals("Sherlock", homer.getBuddyName());
    }

    @Test
    public void getBuddyAddress() throws Exception {
        Assert.assertEquals("123 Springfield Drive", homer.getBuddyAddress());
    }

    @Test
    public void setBuddyAddress() throws Exception {
        homer.setBuddyAddress("221B Baker Street");
        Assert.assertEquals("221B Baker Street", homer.getBuddyAddress());
    }

    @Test
    public void getPhoneNumber() throws Exception {
        Assert.assertEquals("613-888-7667", homer.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber() throws Exception {
        homer.setPhoneNumber("613-765-4321");
        Assert.assertEquals("613-765-4321", homer.getPhoneNumber());
    }

    @Test
    public void testBuddyEquals() throws Exception {
        BuddyInfo copy = new BuddyInfo("Homer", "123 Springfield Drive", "613-888-7667");
        Assert.assertEquals(homer, copy);
    }

}