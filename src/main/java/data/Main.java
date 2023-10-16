package data;

import challenges.CarOps;
import domain.Car;
import domain.Student;

import static challenges.CarOps.*;
import static challenges.StudentOps.*;
import static data.FetchData.getStudentList;
import static  data.FetchData.getCarList;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;


//import static challenges.StudentOps.averageAge;

public class Main {
    private static final List<Car> carlist;
    static {
        try {
            carlist=FetchData.getCarList();
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
        System.out.println("____________________________");

        FetchData.getStudentList().stream()
                .sorted(Comparator.comparing(Student::getAge))
                .forEach(System.out::println);
        List<Car> cars =getCarList();

        List<Student> students = getStudentList();
       double average = averageAge(students);
        System.out.println("Average Age of Students: " + average);

        List<String> fullName = getFullName(students);
        System.out.println("Full name:" +fullName);

        Map<String, List<Student>> gender = studentByGender(students);
        System.out.println("Gender ++++++++++++++++++++++++++++++++ "+ gender);

        List<Student> sortedByAge = sortStudentsByAge(students);
        System.out.println("Sorted student by Age" +sortedByAge);


        Optional<Student> maxAge = studentWithHighestAge(students);
        System.out.println("Max age:" +maxAge);

        List<String> namesToUpper = uppercaseNames(students);
        namesToUpper.forEach(System.out::println);

        Optional<Student> studentOptional =getStudentById(students);
        studentOptional.ifPresent(student -> System.out.println("Student found: " + student.getFullName()));

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        Map<Integer, Long> distributedByAge = ageDistribution(students);
        distributedByAge.forEach((age, count) -> System.out.println("Age: " + age + ", Count: " + count));

        Map<Integer, List<Student>> groupedByAge =groupStudentsByAge(students);
        groupedByAge.forEach((age, studentList) -> {
            System.out.println("Age: " + age);
            studentList.forEach(student -> System.out.println("  " + student.getFullName()));
        });

        double standardDeviation =ageStandardDeviation(students);
        System.out.println("Standard Deviation of Ages: " + standardDeviation);

        System.out.println(CarOps.filterCarsByMake(carlist,"Toyota"));
        System.out.println("*****************************");
        System.out.println(CarOps.filterCarsByYear(carlist, 2010));
        System.out.println(CarOps.filterCarByPrice(carlist, 56310.79));

        String carModel = carModelName(cars).toString();
        System.out.println("Car model name:" +carModel );

        String carModelUpper = carMakeToUppercase(cars).toString();
        System.out.println("Car Model to Uppercase:" +carModelUpper);

        String sortByYear = sortCarsByYear(cars).toString();
        System.out.println("Sorted by Year:" + sortByYear);


        Map<String, Long> counts = countCarsByMake(cars);
        counts.forEach((make, count) -> System.out.println("Make: " + make + ", Count: " + count));

        double averageCarPrice = averagePrice(cars);
        System.out.println("Average Price of Cars: " + averageCarPrice);

        double sumOfCarPrice = totalPrice(carlist);
        System.out.println("Sum of Car Prices: " + sumOfCarPrice);

        boolean blueCars = hasBlueCar(carlist);
        System.out.println("Blue car" +blueCars);

    }

    }





