package challenges;
// for each challenge-> create method-> then on test part-> test the method.
import data.FetchData;
import domain.Student;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StudentOps {
    public StudentOps() throws IOException {
    }

// Challenge#1:
    public static List<Student> filterStudentsByGender(List<Student> students, String gender) {
        return students.stream()
                .filter(student -> student.getGender().equalsIgnoreCase(gender))
                .toList();

    }

    //6. **Find Maximum Age:**
    //   Find the maximum age among all students.
    public static Optional<Student> MaxAge() throws IOException {
      return   FetchData.getStudentList()
                .stream()
                .min(Comparator.comparingInt(student -> student.getDob().getYear() - LocalDate.now().getYear()));
    }

    //7. **Transform to Map:**
    //   Convert the list of students into a map where the
    //   key is the student ID and the value is the student object.
    public Map<Integer , Student> studentMap = FetchData.getStudentList()
            .stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toMap(Student::getId, student -> {
                try {
                    return (Student) Student.getStudents();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }));

 //8. **Get Student Emails:**
    //   Retrieve a list of student emails.

    public static List<Student> studentByEmail() throws IOException {
        return FetchData.getStudentList().stream()
                .filter(student -> student.getEmail().equalsIgnoreCase("email"))
                .toList();
    }

    //9. **Check if Any Student is Adult:**
    //   Check if any student is an adult (age 18 or older).
    static boolean AnyStudentAdult() throws IOException {
        boolean isAdult = FetchData.getStudentList()
                .stream()
                .anyMatch(student -> student.getDob().getYear() - LocalDate.now().getYear()>18);
        return isAdult;
    }

    //10. **Count Students by Gender:**
     //Count the number of students for each gender.

    //11. **Find Youngest Female Student:**
    //    Find the youngest female student.
    public static Optional<Student> youngestStudent() throws IOException {
        return FetchData.getStudentList()
                .stream()
                .max(Comparator.comparingInt(student -> student.getDob().getYear() - LocalDate.now().getYear()));
    }

    //12. **Join Student Names:**
    //    Join the first names of all students into a single string.
    public static String joinFirstNames() throws IOException {
        return FetchData.getStudentList().stream()
                .map(Student::getFirst_name)
                .collect(Collectors.joining(","));

    }
    //13. **Calculate Age Sum:**
    //Calculate the sum of ages for all students.
    public static Integer AgeSum;

    static {
        try {
            AgeSum = FetchData.getStudentList().stream().mapToInt(student -> student.getDob().getYear() - LocalDate.now().getYear()).sum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //14. **Check if All Students are Adults:**
    //    Check if all students are adults (age 18 or older).
    static boolean ifAllStudentAdult() throws IOException {
        boolean areAllAdult = FetchData.getStudentList()
                .stream()
                .allMatch(student -> student.getDob().getYear() - LocalDate.now().getYear()>18);
        return  areAllAdult;
    }

    //15. **Find Oldest Student:**
    //    Find the oldest student.
    public static Optional<Student> oldestStudent() throws IOException {
        return FetchData.getStudentList()
                .stream()
                .min(Comparator.comparingInt(student -> student.getDob().getYear() - LocalDate.now().getYear()));
    }
}


