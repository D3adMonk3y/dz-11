
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ManTest {
    private static Man man = null;

    @BeforeTest
    private void createPerson() {
        man = new Man("John", "Doe", 30);
    }

    @Test
    public void testIsRetired() {
        Man man1 = new Man("John", "Doe", 70);
        assertTrue(man1.isRetired());

        Man man2 = new Man("Jane", "Smith", 40);
        assertFalse(man2.isRetired());

        man1.setAge(64);
        assertFalse(man1.isRetired());
        man1.setAge(65);
        assertFalse(man1.isRetired());
        man1.setAge(66);
        assertTrue(man1.isRetired());
    }

    @Test
    public void testRegisterPartnership() {
        Man man1 = new Man("John", "Doe", 30);
        Woman woman1 = new Woman("Jane", "Smith", 28);

        man1.registerPartnership(woman1);

        assertTrue(man1.isHasRegisteredPartnership());
        assertEquals(woman1, man1.getPartner());
        assertTrue(woman1.isHasRegisteredPartnership());
        assertEquals(man1, woman1.getPartner());
    }

    @Test
    public void testGetFirstName() {
        assertEquals(man.getFirstName(), "John");
    }

    @Test
    public void testSetFirstName() {
        String prevName = man.getFirstName();
        man.setFirstName("Adam");
        assertEquals(man.getFirstName(), "Adam");
        man.setFirstName(prevName);
    }

    @Test
    public void testGetLastName() {
        assertEquals(man.getLastName(), "Doe");
    }

    @Test
    public void testSetLastName() {
        String prevName = man.getLastName();
        man.setLastName("Smith");
        assertEquals(man.getLastName(), "Smith");
        man.setLastName(prevName);
    }

    @Test
    public void testGetAge() {
        assertEquals(man.getAge(), 30);
    }

    @Test
    public void testSetAge() {
        int previousAge = man.getAge();
        man.setAge(40);
        assertEquals(man.getAge(), 40);
        man.setAge(previousAge);
    }

    @Test
    public void testGetPartner() {
        Woman woman = new Woman("Jane", "Smith", 35);
        man.setPartner(woman);
        assertEquals(man.getPartner(), woman);
        man.setPartner(null);
    }

    @Test
    public void testSetPartner()  {
        Woman woman = new Woman("Jane", "Smith", 35);
        man.setPartner(woman);
        assertEquals(man.getPartner(), woman);
        man.setPartner(null);
    }

    @Test
    public void testIsHasRegisteredPartnership() {
        assertFalse(man.isHasRegisteredPartnership());
    }

    @Test
    public void testSetHasRegisteredPartnership() {
        man.setHasRegisteredPartnership(true);
        assertTrue(man.isHasRegisteredPartnership());
        man.setHasRegisteredPartnership(false);
    }

}

