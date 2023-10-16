package challenges;

import domain.Car;
import org.checkerframework.checker.units.qual.C;

import java.util.*;
import java.util.stream.Collectors;

public class CarOps {


    public static List<Car> sortCarsByPriceDesc(List<Car> cars){
        return cars
                .stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .toList();
    }

    public static Optional<Car> carWithHighestPrice(List<Car> cars){
        return cars
                .stream()
                .max(Comparator.comparingDouble(Car::getPrice));
    }

    public static Optional<Car> carWithLowestPrice(List<Car> cars){
        return cars
                .stream()
                .min(Comparator.comparingDouble(Car::getPrice));
    }

    public static Map<String , List<Car>> carsByMake(List<Car> cars){
        return cars
                .stream()
                .collect(Collectors.groupingBy(Car::getMake));
    }
    public static Map<String, Long> countCarsByMake(List<Car> cars){
        return cars
                .stream()
                .collect(Collectors.groupingBy(Car::getMake, Collectors.counting()));
    }

    public static OptionalDouble averagePrice(List<Car> cars){
        return   cars
                .stream()
                .mapToDouble(Car::getPrice)
                .average();

    }

    public static Optional<Double> sumOfPrices(List<Car> cars){
        return cars
                .stream()
                .map(Car::getPrice)
                .reduce(Double::sum);
    }
    public static boolean isThereBlue(List<Car> cars){
        return cars
                .stream()
                .anyMatch(b -> b.getColor().equalsIgnoreCase("blue"));
    }
    public static boolean isAllCarsExpensive(List<Car> cars){
        return cars
                .stream()
                .allMatch(p -> p.getPrice()>50000);
    }
    public static boolean noneMatchCondition(List<Car> cars){
        return cars
                .stream()
                .noneMatch(p -> p.getColor().equalsIgnoreCase("rainbow"));
    }
    public static List<Car> skipFirstNCars(List<Car> cars, long n){
        return cars
                .stream()
                .skip(n)
                .toList();
    }
    public static List<Car> limitToNCars(List<Car> cars, long n){
        return cars
                .stream()
                .limit(n)
                .toList();
    }
    public static List<String> distinctColors(List<Car> cars){
        return cars
                .stream()
                .map(Car::getColor)
                .distinct()
                .toList();
    }
    public static List<String> concatinateMakeandModel(List<Car> cars){
        return cars
                .stream()
                .map(m -> m.getMake() + " " + m.getModel())
                .toList();
    }

}
