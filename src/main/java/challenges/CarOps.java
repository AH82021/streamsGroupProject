package challenges;

import data.FetchData;
import domain.Car;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// create method for challenges related to the car here-> then-> test each method in test part.
public class CarOps {

    public CarOps() throws IOException {
    }

    //6. **Sort by Year:**
    // Sort the list of cars based on the year in ascending order.
public static List<Car> sortedByYear() throws IOException {
    return FetchData.getCarList()
        .stream()
        .sorted(Comparator.comparing(Car::getYear))
        .toList();
}

//7. **Sort by Price (descending):**
//   Sort the list of cars based on the price in descending order.
    public static List<Car> sortedByPriceDesc() throws IOException {
    return FetchData.getCarList()
            .stream()
            .sorted(Comparator.comparing(Car::getPrice).reversed())
            .toList();
    }

    //8. **Get the Highest Priced Car:**
    //   Find the car with the highest price.

    public static Optional<Car> HighestPriced() throws IOException {
    return FetchData.getCarList()
            .stream()
            .max(Comparator.comparingDouble(Car::getPrice));
    }

    //9. **Get the Lowest Priced Car:**
    //   Find the car with the lowest price.

    public static Optional<Car> LowestPriced() throws IOException {
    return FetchData.getCarList()
            .stream()
            .min(Comparator.comparingDouble(Car::getPrice));

    }

    //10. **Group by Make:**
    //    Group the cars by their make.
public static Map<String, List<Car> > groupByMake;

    static {
        try {
            groupByMake = FetchData.getCarList().stream()
                       .collect(Collectors.groupingBy(Car::getMake));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, List<Car>> getGroupByMake() {
        return groupByMake;
    }


}

