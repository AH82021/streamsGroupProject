package challenges;

import domain.Student;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class StudentOpsTest {

    @Test
    void filterStudentsByGender() {

    }

    @Test
    void maxAge() throws IOException {
        System.out.println(StudentOps.MaxAge());
    }

    @Test
    void studentByEmail() throws IOException {
        System.out.println(StudentOps.studentByEmail());
    }

    @Test
    void anyStudentAdult() throws IOException {
        System.out.println(StudentOps.AnyStudentAdult());
    }

    @Test
    void youngestStudent() throws IOException {
        System.out.println(StudentOps.youngestStudent());
    }

    @Test
    void joinFirstNames() throws IOException {
        System.out.println(StudentOps.joinFirstNames());
    }

    @Test
    void ifAllStudentAdult() throws IOException {
        System.out.println(StudentOps.ifAllStudentAdult());
    }

    @Test
    void oldestStudent() throws IOException {
        System.out.println(StudentOps.oldestStudent());
    }

}