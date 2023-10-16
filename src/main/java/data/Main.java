package data;

import challenges.CarOps;
import domain.Car;
import domain.Student;

import java.io.IOException;
import java.util.List;

public class Main {
private static final List<Car> carList;

    static {
        try {
            carList = FetchData.getCarList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws IOException {

        FetchData.getCarList().stream()
                .limit(5)
                .forEach(System.out::println);
        System.out.println("++++++++++++++++");
        FetchData.getStudentList().stream()
                .limit(5)
                .forEach(System.out::println);
        System.out.println("sorted cars by price descending order");
        System.out.println(CarOps.sortCarsByPriceDesc(carList));
        System.out.println("Car with highest price");
        System.out.println(CarOps.carWithHighestPrice(carList).toString());
        System.out.println("Car with lowest price");
        System.out.println(CarOps.carWithLowestPrice(carList).toString());
        System.out.println("Grouped cars by make");
        CarOps.carsByMake(carList).forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
        System.out.println("Count cars by make");
        CarOps.countCarsByMake(carList).forEach((key, value) -> System.out.println("key: " + key + ", Value: " + value));
        System.out.println("Average price of cars");
        System.out.println(CarOps.averagePrice(carList).getAsDouble());
        System.out.println("Sum of car prices");
        System.out.println(CarOps.sumOfPrices(carList));
        System.out.println("Is there a blue car in the list");
        System.out.println(CarOps.isThereBlue(carList));
        System.out.println("Is all cars expensive");
        System.out.println(CarOps.isAllCarsExpensive(carList));
        System.out.println("Is no rainbow color car");
        System.out.println(CarOps.noneMatchCondition(carList));
        System.out.println("Skip the first n cars");
        CarOps.skipFirstNCars(carList, 498).forEach(System.out::println);
        System.out.println("Limit the list to the first n cars");
        CarOps.limitToNCars(carList, 9).forEach(System.out::println);
        System.out.println("Distinct colors of cars in the list");
        CarOps.distinctColors(carList).forEach(System.out::println);
        System.out.println("Concatenate make and model of cars");
        CarOps.concatinateMakeandModel(carList).forEach(System.out::println);


    }

}
