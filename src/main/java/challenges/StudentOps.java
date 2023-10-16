package challenges;

import domain.Car;
import domain.Student;
import org.checkerframework.checker.units.qual.C;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class StudentOps {
//1. Filter Students by Gender: Write a method to filter a list of students by their gender.
    public static List<Student> filterStudentsByGender(List<Student> students, String gender) {
        return students.stream()
                .filter(student -> student.getGender().equalsIgnoreCase(gender))
                .toList();
    }
//2.Sort Students by Age: Sort the list of students by their age (based on date of birth).

 public static List<Student>  sortStudentsByAge(List<Student> students){
        LocalDate currentDate = LocalDate.now();
        students.forEach(student -> {
            LocalDate dob = student.getDob();
            Period period= Period.between(dob, currentDate);
            student.setAge(period.getYears());
        });
     return  students.stream()
             .sorted(Comparator.comparing(Student::getAge))
             .toList();
 }
// 3.Calculate Average Age: Calculate the average age of all students.
    public static double averageAge(List<Student> students) {
        LocalDate currentDate = LocalDate.now();
        students.forEach(student -> {
            LocalDate dob = student.getDob();
            Period period= Period.between(dob, currentDate);
            student.setAge(period.getYears());
        });

        OptionalDouble av = students.stream()
                .mapToInt(Student::getAge)
                .average();
        return av.orElse(0.0);
    }

    //  4.  Print Student Names: Print the full names of all students.
public static List<String> getFullName(List<Student> students) {
     return     students.stream()
            .map(student -> student.getFirst_name() + " "+ student.getLast_name())
             .collect(Collectors.toList());

}
//   5. Group Students by Gender: Group the students by gender.

public static Map<String, List<Student>> studentByGender(List<Student> students) {
     return students.stream()
            .collect(Collectors.groupingBy(Student::getGender));
}
//6.Find Maximum Age: Find the maximum age among all students.
public static  Optional <Student> studentWithHighestAge(List<Student> students) {
    LocalDate currentDate = LocalDate.now();
    students.forEach(student -> {
        LocalDate dob = student.getDob();
        Period period = Period.between(dob, currentDate);
        student.setAge(period.getYears());
    });
    return students.stream()
            .max(Comparator.comparingInt(Student::getAge));
//16.Convert to Uppercase: Convert all student first names to uppercase.

}
 public static List<String> uppercaseNames(List<Student> students) {
        return students.stream()
                .map(student -> student.getFullName().toUpperCase())
                .collect(Collectors.toList());
    }
//17.Find Student by ID: Find a student by their ID.
   public static Optional<Student> getStudentById(List<Student> students){
        int targetId = 4;
        return students.stream()
                .filter(student -> student.getId()==targetId)
                .findFirst();
    }

//18. Compute Age Distribution: Compute the distribution of ages (e.g., count of students for each age).
    public static  Map<Integer, Long> ageDistribution(List<Student> students){
        LocalDate currentDate = LocalDate.now();
        students.forEach(student -> {
            LocalDate dob = student.getDob();
            Period period = Period.between(dob, currentDate);
            student.setAge(period.getYears());
        });
        return  students.stream()
                .collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));


}
//19. Group Students by Age: Group the students by their age.

    public static Map<Integer, List<Student>> groupStudentsByAge(List<Student> students){
        LocalDate currentDate = LocalDate.now();
        students.forEach(student -> {
            LocalDate dob = student.getDob();
            Period period = Period.between(dob, currentDate);
            student.setAge(period.getYears());
        });
        return students.stream()
                .collect(Collectors.groupingBy(Student::getAge));
    }
//20.Calculate Age Standard Deviation: Calculate the standard deviation of ages for all students.
public static double ageStandardDeviation(List<Student> students) {
    LocalDate currentDate = LocalDate.now();
    students.forEach(student -> {
        LocalDate dob = student.getDob();
        Period period = Period.between(dob, currentDate);
        student.setAge(period.getYears());
    });
    double mean =students.stream()
            .mapToDouble(Student::getAge)
            .average()
            .orElse(0.0);
    double variance = students.stream()
            .mapToDouble(student ->Math.pow(student.getAge() - mean,2))
            .average()
            .orElse(0.0);
    double ageStandardDeviation = Math.sqrt(variance);


    return ageStandardDeviation;

}

}

