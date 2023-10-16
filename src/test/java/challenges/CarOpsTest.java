package challenges;

import data.FetchData;
import domain.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//import static data.Main.carlist;
import static org.junit.jupiter.api.Assertions.*;

class CarOpsTest {
    private static List<Car> cars;


    @BeforeEach
    void setUp() throws IOException {
            // Fetch data before all tests
            cars = FetchData.getCarList();

    }

    @Test
    void filterCarsByMake() {
        List<Car> filteredCars = CarOps.filterCarsByMake(cars, "Toyota");
        assertEquals(30, filteredCars.size());
        assertEquals("Toyota", filteredCars.get(1).getMake());

    }

    @Test
    void filterCarsByYear() {
        List<Car> filteredCars = CarOps.filterCarsByYear(cars, 2009);
        assertEquals(28, filteredCars.size());
        assertEquals("BMW", filteredCars.get(5).getMake());

    }

    @Test
    void filterCarByPrice() {
        List<Car> filteredCars = CarOps.filterCarByPrice(cars, 24420.02);

        // Assert the filtered cars
        assertEquals(1, filteredCars.size());
        assertEquals("Chrysler", filteredCars.get(0).getMake());

    }

    @Test
    void carModelName() {
        List<String> modelNames = CarOps.carModelName(cars);

        // Assert the model names
        assertEquals(500, modelNames.size());
        assertEquals("Rogue", modelNames.get(0));
        assertEquals("Land Cruiser", modelNames.get(1));
        assertEquals("Golf", modelNames.get(2));


    }

    @Test
    void carMakeToUppercase() {
        List<String> uppercaseMakes = CarOps.carMakeToUppercase(cars);

        // Assert the uppercase make names
        assertEquals(500, uppercaseMakes.size());
        assertEquals("NISSAN", uppercaseMakes.get(0));
        assertEquals("TOYOTA", uppercaseMakes.get(1));
        assertEquals("VOLKSWAGEN", uppercaseMakes.get(2));

    }
//    @Test
//    void sortCarsByYear() {
//        List<Car> sortedCars = CarOps.sortCarsByYear(cars);
//        List<Integer> sortedYears = sortedCars.stream()
//                .map(Car::getYear)
//                .collect(Collectors.toList());
//        assertEquals( 1968, sortedYears);
//    }

    @Test
    void countCarsByMake() {
        Map<String, Long> carCountByMake = CarOps.countCarsByMake(cars);

        // Assert the car counts by make
        assertEquals(53, carCountByMake.size()); // There are 3 unique makes: Toyota, Honda, Ford

        // Verify the counts for each make
        assertEquals(30, carCountByMake.get("Toyota"));
        assertEquals(10, carCountByMake.get("Honda"));
        assertEquals(38, carCountByMake.get("Ford"));

    }

    @Test
    void averagePrice() {
        double average = CarOps.averagePrice(cars);

        // Assert that the average price is 0.0 when the list is empty
        assertEquals(129355.31270000001, average);

    }

    @Test
    void totalPrice() {
        double total = CarOps.totalPrice(cars);
        assertEquals(6.467765635E7, total, 0.01);

    }

    @Test
    void hasBlueCar() {

        boolean hasBlueCar = CarOps.hasBlueCar(cars);
        assertTrue(hasBlueCar);
        String expectedOutput = "There is a car with blue color.\n";
        assertTrue(true);

    }


}