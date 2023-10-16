package challenges;

import data.FetchData;
import domain.Car;
import domain.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.*;

class CarOpsTest {
    private static List<Car> cars;

    @BeforeAll
    static void setUp() throws IOException {
        // Fetch data before all tests
        cars = FetchData.getCarList();
    }

    @Test
    void sortCarsByPriceDesc() {
        List<Car> sortedCars = CarOps.sortCarsByPriceDesc(cars);
        assertEquals(239045.51, sortedCars.get(0).getPrice());
        assertEquals(239035.69, sortedCars.get(1).getPrice());
        assertEquals(239030.37, sortedCars.get(2).getPrice());
    }

    @Test
    void carWithHighestPrice() {
        Optional<Car> carWithHighestPrice = CarOps.carWithHighestPrice(cars);
        assertTrue(carWithHighestPrice.isPresent());
        assertEquals(239045.51, carWithHighestPrice.get().getPrice());
    }

    @Test
    void carWithLowestPrice() {
        Optional<Car> carWithLowestPrice = CarOps.carWithLowestPrice(cars);
        assertTrue(carWithLowestPrice.isPresent());
        assertEquals(20055.27, carWithLowestPrice.get().getPrice());
    }

    @Test
    void carsByMake() {
        Map<String, List<Car>> carsByMake = CarOps.carsByMake(cars);

        // Assert the results
        assertEquals(30, carsByMake.get("Toyota").size());
        assertEquals(16, carsByMake.get("Mercury").size());
        assertEquals(38, carsByMake.get("Ford").size());
    }

    @Test
    void countCarsByMake() {
        Map<String, Long> countCarsByMake = CarOps.countCarsByMake(cars);

        // Assert the results
        assertEquals(30, countCarsByMake.get("Toyota"));
        assertEquals(38, countCarsByMake.get("Ford"));

    }

    @Test
    void averagePrice() {
        OptionalDouble average = CarOps.averagePrice(cars);

        // Assert the result
        assertEquals(129355.31270000001, average.orElse(0.0), 0.0001);
    }

    @Test
    void sumOfPrices() {
        Optional<Double> sumOfPrices = CarOps.sumOfPrices(cars);

        // Assert the result
        assertEquals(6.467765634999995E7, sumOfPrices.orElse(0.0), 0.0001);
    }

    @Test
    void isThereBlue() {
        boolean isThereBlue = CarOps.isThereBlue(cars);

        // Assert the result
        assertTrue(isThereBlue);
    }

    @Test
    void isAllCarsExpensive() {
        boolean isExpensive = CarOps.isAllCarsExpensive(cars);

        // Assert the result
        assertFalse(isExpensive);
    }

    @Test
    void noneMatchCondition() {
        assertTrue(CarOps.noneMatchCondition(cars));
    }

    @Test
    void skipFirstNCars() {
        List<Car> result = CarOps.skipFirstNCars(cars, 498);

        assertEquals(2, result.size());
        assertEquals("Jaguar", result.get(0).getMake());
        assertEquals("S-Type", result.get(0).getModel());
        assertEquals("Chevrolet", result.get(1).getMake());
        assertEquals("1500", result.get(1).getModel());
    }

    @Test
    void limitToNCars() {
        List<Car> result = CarOps.limitToNCars(cars, 9);

        assertEquals(9, result.size());
        assertEquals("Nissan", result.get(0).getMake());
        assertEquals("Rogue", result.get(0).getModel());
        assertEquals("Toyota", result.get(1).getMake());
        assertEquals("Land Cruiser", result.get(1).getModel());
    }

    @Test
    void distinctColors() {
        List<String> result = CarOps.distinctColors(cars);

        assertEquals(19, result.size());
        assertEquals("Green", result.get(0));
        assertEquals("Crimson", result.get(1));
        assertEquals("Aquamarine", result.get(2));
        assertEquals("Orange", result.get(3));
    }

    @Test
    void concatinateMakeandModel() {
        List<String> result = CarOps.concatinateMakeandModel(cars);

        assertEquals(500, result.size());
        assertEquals("Nissan Rogue", result.get(0));
        assertEquals("Toyota Land Cruiser", result.get(1));
        assertEquals("Volkswagen Golf", result.get(2));
        assertEquals("Suzuki Verona", result.get(3));
    }
}