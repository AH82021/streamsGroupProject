package data;

import challenges.StudentOps;
import domain.Car;
import domain.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        FetchData.getCarList().stream()
                .limit(5)
                .forEach(System.out::println);
        System.out.println("++++++++++++++++");
        FetchData.getStudentList().stream()
                .limit(5)
                .forEach(System.out::println);

        System.out.println("+++++++++++++++++++++");

        //Testing Challenge 6:
//FetchData.getCarList().stream()
       // .sorted(Comparator.comparing(Car::getYear))
       // .toList()
        //.forEach(System.out::println);


    }


}
