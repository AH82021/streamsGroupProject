package domain;
import data.FetchData;

import java.io.IOException;
import java.time.LocalDate;

import java.time.Period;
import java.util.List;

// student class with all things
public class Student {
    private final Integer id;
    private final String first_name;
    private final String last_name;
    private final String email;
    private final String gender;
    private final LocalDate dob;
    //private final Integer age;


    public Student(Integer id, String first_name, String last_name, String email, String gender, LocalDate dob) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
    }

// Method for getting age from DOB.
    public static Integer Age(LocalDate dob){

        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dob,currentDate).getYears();
        return age;
    }


    public static List<Student> getStudents() throws IOException {
       return FetchData.getStudentList();

    }

    // Created method for getting age from DOB


    //Create enum for Gender -> (Question 11)
   // public static enum Gender {
      //  MALE,

    //}
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


    //public static List<Student> students;
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



