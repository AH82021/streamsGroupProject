package domain;
import challenges.StudentOps;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Student {
//    public static enum Gender {
//        MALE, FEMALE
//    }

    private final Integer id;
    private final String first_name;
    private final String last_name;
    private final String email;
    private final String gender;
    private final LocalDate dob;
    private  int age;

    public Student(Integer id, String first_name, String last_name, String email, String gender, String dob, int age) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.dob = LocalDate.parse(dob);
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age =age;

    }
    public String getFullName() {
        return first_name + " " + last_name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                '}';
    }

}


