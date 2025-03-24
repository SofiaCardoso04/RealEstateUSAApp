package pt.ipp.isep.dei.esoft.project.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;

public class PropertyRepositoryTest {
    /*private PropertyRepository propertyRepo;

    @Before
    public void setUp() {
        propertyRepo = new PropertyRepository();
    }

    @Test
    public void testAddProperty() {
        Property p1 = new Property(200, 30, "https://www.example.com/index.html#date",
                new Address("Rua da Serra", "Gaia", "Porto", "12345"), 30000);
        boolean result1 = propertyRepo.addProperty(p1);
        assertTrue(result1);

        Property p2 = new Property(150, 10, "photo2.jpg",
                new Address("street name", "city name", "district", "54321"), 750000);
        boolean result2 = propertyRepo.addProperty(p2);
        assertTrue(result2);

        ArrayList<Property> properties = propertyRepo.getProperties();
        assertEquals(2, properties.size());
        assertTrue(properties.contains(p1));
        assertTrue(properties.contains(p2));
    }

    @Test
    public void testAddResidence() {
        Residence r1 = new Residence(200, 30, 30000,"https://www.example.com/index.html#date",
                new Address("Rua da Serra", "Gaia", "Porto", "12345"), 2, 2,2, new AvailableEquipment(1,1));
        boolean result1 = propertyRepo.addResidence(r1);
        assertTrue(result1);

        Residence r2 = new Residence(150, 10, 7500000, "photo2.jpg",
                new Address("street name", "city name", "district", "54321"), 4, 3, 3, new AvailableEquipment(2,2));
        boolean result2 = propertyRepo.addResidence(r2);
        assertTrue(result2);

        ArrayList<Residence> residences = propertyRepo.getResidences();
        assertEquals(2, residences.size());
        assertTrue(residences.contains(r1));
        assertTrue(residences.contains(r2));
    }

    @Test
    public void testAddHouse() {
        House h1 = new House(150, 10, 7500000, "photo2.jpg",
                new Address("street name", "city name", "district", "54321"), 4, 3,
                3, new AvailableEquipment(2,2), 1, 1, 1);
        boolean result1 = propertyRepo.addHouse(h1);
        assertTrue(result1);

        House h2 = new House(200, 30, 30000,"https://www.example.com/index.html#date",
                new Address("Rua da Serra", "Gaia", "Porto", "12345"), 2, 2,
                2, new AvailableEquipment(1,1), 1, 1,1);
        boolean result2 = propertyRepo.addHouse(h2);
        assertTrue(result2);

        ArrayList<House> houses = propertyRepo.getHouses();
        assertEquals(2, houses.size());
        assertTrue(houses.contains(h1));
        assertTrue(houses.contains(h2));
    }

    @Test
    public void testCreateProperty() {
        boolean result1 = propertyRepo.createProperty(200, 30, "https://www.example.com/index.html#date",
                new Address("Rua da Serra", "Gaia", "Porto", "12345"), 30000);
        assertTrue(result1);

        boolean result2 = propertyRepo.createProperty(150, 10, "photo2.jpg",
                new Address("street name", "city name", "district", "54321"), 750000);
        assertTrue(result2);

        ArrayList<Property> properties = propertyRepo.getProperties();
        assertEquals(2, properties.size());
        assertNotNull(properties.get(0));
        assertNotNull(properties.get(1));
    }

    @Test
    public void testCreateResidence() {
        boolean result1 = propertyRepo.createResidence(200, 30, 30000,"https://www.example.com/index.html#date",
                new Address("Rua da Serra", "Gaia", "Porto", "12345"), 2, 2,2, new AvailableEquipment(1,1));
        assertTrue(result1);

        boolean result2 = propertyRepo.createResidence(150, 10, 7500000, "photo2.jpg",
                new Address("street name", "city name", "district", "54321"), 4, 3, 3, new AvailableEquipment(2,2));
        assertTrue(result2);

        ArrayList<Residence> properties = propertyRepo.getResidences();
        assertEquals(2, properties.size());
        assertNotNull(properties.get(0));
        assertNotNull(properties.get(1));
    }

    @Test
    public void testCreateHouse() {
        boolean result1 = propertyRepo.createHouse(150, 10, 7500000, "photo2.jpg",
                new Address("street name", "city name", "district", "54321"), 4, 3,
                3, new AvailableEquipment(2,2), 1, 1, 1);
        assertTrue(result1);

        boolean result2 = propertyRepo.createHouse(200, 30, 30000,"https://www.example.com/index.html#date",
                new Address("Rua da Serra", "Gaia", "Porto", "12345"), 2, 2,
                2, new AvailableEquipment(1,1), 1, 1,1);
        assertTrue(result2);

        ArrayList<House> properties = propertyRepo.getHouses();
        assertEquals(2, properties.size());
        assertNotNull(properties.get(0));
        assertNotNull(properties.get(1));
    }*/

}
