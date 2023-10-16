package challenges;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CarOpsTest {

    @Test
    void sortedByYear() throws IOException {
        CarOps.sortedByYear().forEach(System.out::println);
    }

    @Test
    void sortedByPriceDesc() throws IOException {
        CarOps.sortedByPriceDesc().forEach(System.out::println);
    }

    @Test
    void highestPriced() throws IOException {
        System.out.println(CarOps.HighestPriced());
    }

    @Test
    void lowestPriced() throws IOException {
        System.out.println(CarOps.LowestPriced());
    }

    @Test
    void getGroupByMake() {
        System.out.println(CarOps.groupByMake);
    }
}