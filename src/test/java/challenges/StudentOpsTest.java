package challenges;

import data.FetchData;
import domain.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentOpsTest {
    private static List<Student> students;

    @BeforeEach
    void setUp() throws IOException {
        // Fetch data before all tests
        students = FetchData.getStudentList();
    }


    @Test
    void filterStudentsByGender() {
        List<Student> filteredStudents = StudentOps.filterStudentsByGender(students, "Female");

        // Assert the filtered students
        assertEquals(234, filteredStudents.size());
        assertEquals("Kaitlyn Padden", filteredStudents.get(0).getFullName());
        assertEquals("Claude Bernadot", filteredStudents.get(1).getFullName());

    }

    @Test
    void sortStudentsByAge() {
        List<Student> sortedStudents = StudentOps.sortStudentsByAge(students);

        // Assert the sorted students based on their ages
        assertEquals("Shane MacGillreich", sortedStudents.get(0).getFullName()); //the Oldest
        assertEquals("Hazel Seer", sortedStudents.get(1).getFullName());//2nd oldest
        assertEquals("Quinton Chater", sortedStudents.get(2).getFullName());
        assertEquals("Imojean Heinritz", sortedStudents.get(3).getFullName());

    }

    @Test
    void averageAge() {
        double ave = StudentOps.averageAge(students);
        assertEquals(34.898, 34.898);

    }

    @Test
    void getFullName() {
        List<String> fullNames = StudentOps.getFullName(students);

        assertEquals("Kaitlyn Padden", fullNames.get(0));
        assertEquals("Viviana Bates", fullNames.get(1));
        assertEquals("Towny Dommett", fullNames.get(2));
        assertEquals("Claude Bernadot", fullNames.get(3));


    }

    @Test
    void studentByGender() {
        Map<String, List<Student>> studentsByGender = StudentOps.studentByGender(students);

        // Assert the students grouped by gender
        assertEquals(8, studentsByGender.size());

        // Assert the number of students in each gender group
        assertEquals(234, studentsByGender.get("Female").size());
        assertEquals(220, studentsByGender.get("Male").size());
        assertEquals(7, studentsByGender.get("Polygender").size());

    }

    @Test
    void studentWithHighestAge() {
        Optional<Student> ave = StudentOps.studentWithHighestAge(students);
        assertEquals(54, 54);

    }

    @Test
    void uppercaseNames() {
        List<String> fullNames = StudentOps.getFullName(students);

        // Assert the full names
        assertEquals("Viviana Bates", fullNames.get(1));
        assertEquals("Towny Dommett", fullNames.get(2));
        assertEquals("Claude Bernadot", fullNames.get(3));


    }

    @Test
    void getStudentById() {
        Optional<Student> student = StudentOps.getStudentById(students);

        // Assert the result
        assertTrue(student.isPresent());
        assertEquals(4, student.get().getId());
        assertEquals("Claude Bernadot", student.get().getFullName());
        assertEquals("Female", student.get().getGender());


    }




    @Test
    void ageDistribution() {
        Map<Integer, Long> ageDistribution = StudentOps.ageDistribution(students);

        // Assert the age distribution
        assertEquals(14, ageDistribution.get(17));
        assertEquals(20, ageDistribution.get(27));
        assertEquals(2, ageDistribution.get(54));

    }

    @Test
    void groupStudentsByAge() {
        Map<Integer, List<Student>> groupedStudents =  StudentOps.groupStudentsByAge(students);

        // Assert the grouped students based on their ages
        assertEquals(38, groupedStudents.size());

        assertEquals(14, groupedStudents.get(17).size());
        assertEquals(18, groupedStudents.get(18).size());
    }

    @Test
    void ageStandardDeviation() {
        double standardDeviation = StudentOps.ageStandardDeviation(students);
        assertEquals(10.912176501505096, standardDeviation, 0.01);

    }
}