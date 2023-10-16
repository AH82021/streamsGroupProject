package challenges;

import domain.Car;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarOps {
    //   21. Filter by Make: Filter the list of cars to only include cars with a specific make.
    public static List<Car> filterCarsByMake(List<Car> cars, String make) {
        return cars.stream()
                .filter(car -> car.getMake().equalsIgnoreCase(make))
                .toList();
    }
//  22  Filter by Year: Filter the list of cars to only include cars from a specific year.

    public static List<Car> filterCarsByYear(List<Car> cars, int year) {
//        Integer targetYear = year;
        return cars.stream()
                .filter(car -> car.getYear()==year)
                .collect(Collectors.toList());
    }
// 23.Filter by Price: Filter the list of cars to only include cars within a price range.

    public static List<Car> filterCarByPrice(List<Car> cars, double price) {
        return cars.stream()
                .filter(car -> car.getPrice().equals(price))
                .collect(Collectors.toList());
    }

    //  24.Map to Model Names: Create a list of car model names from the list of cars.
    public static List<String> carModelName(List<Car> cars) {
        return cars.stream()
                .map(Car::getModel)
                .collect(Collectors.toList());

    }

    //  25.  Map to Upper Case Makes: Create a list of car makes in uppercase from the list of cars.
    public static List<String> carMakeToUppercase(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getMake().toUpperCase())
                .collect(Collectors.toList());
    }
//  26. Sort by Year: Sort the list of cars based on the year in ascending order.
    public static List<Car> sortCarsByYear(List<Car> carList) {
        return carList.stream()
                .sorted(Comparator.comparingInt(Car::getYear))
                .collect(Collectors.toList());
    }
// 27.Sort by Price (descending): Sort the list of cars based on the price in descending order

    //31. Count Cars by Make: Count the number of cars for each make.
    public static Map<String, Long> countCarsByMake(List<Car> cars) {
        return cars.stream()
                .collect(Collectors.groupingBy(Car::getMake, Collectors.counting()));
    }
// 32.Average Price: Calculate the average price of all cars.
    public static double averagePrice(List<Car> cars) {
        return cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0.0);

    }
// 33.Sum of Prices: Calculate the sum of all car prices.
    public static double totalPrice(List<Car> carList){
        return carList.stream()
                .mapToDouble(Car::getPrice)
                .sum();
    }
//34.Any Car with Blue Color: Check if there's any car with a blue color.
    public static boolean hasBlueCar(List<Car> carList) {
        boolean hasBlueCar = carList.stream()
                .anyMatch(car -> car.getColor().equalsIgnoreCase("Blue"));
        if (hasBlueCar) {
            System.out.println("There is a car with blue color.");
        } else {
            System.out.println("There is no car with blue color.");
        }
        return hasBlueCar;
    }
}
