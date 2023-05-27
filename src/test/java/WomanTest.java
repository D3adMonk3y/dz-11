import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class WomanTest {
    private static Woman woman = null;

    @BeforeTest
    private void createPerson() {
        woman = new Woman("Jane", "Smith", 25);
    }

    @Test
    public void testIsRetired() {
        Woman woman1 = new Woman("Jane", "Smith", 65);
        assertTrue(woman1.isRetired());

        Woman woman2 = new Woman("Alice", "Johnson", 50);
        assertFalse(woman2.isRetired());

        woman1.setAge(59);
        assertFalse(woman1.isRetired());
        woman1.setAge(60);
        assertFalse(woman1.isRetired());
        woman1.setAge(61);
        assertTrue(woman1.isRetired());

    }

    @Test
    public void testRegisterPartnership() {
        Man man = new Man("John", "Doe", 30);
        Woman woman = new Woman("Jane", "Smith", 28);

        woman.registerPartnership(man);

        assertTrue(woman.isHasRegisteredPartnership());
        assertEquals(man, woman.getPartner());
        assertTrue(man.isHasRegisteredPartnership());
        assertEquals(woman, man.getPartner());
    }
    @Test
    public void testGetFirstName() {

        assertEquals(woman.getFirstName(), "Jane");
    }

    @Test
    public void testSetFirstName() {
        String oldName = woman.getFirstName();
        woman.setFirstName("Alice");
        assertEquals(woman.getFirstName(), "Alice");
        woman.setFirstName(oldName);
    }

    @Test
    public void testGetLastName() {
        assertEquals(woman.getLastName(), "Smith");
    }

    @Test
    public void testSetLastName() {
        String oldName = woman.getLastName();
        woman.setLastName("Johnson");
        assertEquals(woman.getLastName(), "Johnson");
        woman.setLastName(oldName);
    }

    @Test
    public void testGetAge() {
        assertEquals(woman.getAge(), 25);
    }

    @Test
    public void testSetAge() {
        int prevAge = woman.getAge();
        woman.setAge(30);
        assertEquals(woman.getAge(), 30);
        woman.setAge(prevAge);
    }

    @Test
    public void testGetPartner() {
        Woman woman2 = new Woman("Alice", "Johnson", 28);
        woman.setPartner(woman2);
        assertEquals(woman.getPartner(), woman2);
        woman.setPartner(null);
    }

    @Test
    public void testSetPartner() {
        Man man = new Man("John", "Johnson", 28);
        woman.setPartner(man);
        assertEquals(woman.getPartner(), man);
        woman.setPartner(null);
    }

    @Test
    public void testIsHasRegisteredPartnership() {
        assertFalse(woman.isHasRegisteredPartnership());
    }

    @Test
    public void testSetHasRegisteredPartnership() {
        woman.setHasRegisteredPartnership(true);
        assertTrue(woman.isHasRegisteredPartnership());
        woman.setHasRegisteredPartnership(false);
    }


}
