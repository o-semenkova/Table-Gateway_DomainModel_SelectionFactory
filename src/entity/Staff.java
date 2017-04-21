package entity;

import java.util.Objects;

/**
 * Created by Admin on 4/21/2017.
 */
public class Staff {


    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private int proficiency;
    private String specialization;

    public Staff() {
    }

    public Staff(int id, String firstname, String lastname, int age, int proficiency, String specialization) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.proficiency = proficiency;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;
        Staff staff = (Staff) o;
        return age == staff.age &&
                proficiency == staff.proficiency &&
                Objects.equals(firstname, staff.firstname) &&
                Objects.equals(lastname, staff.lastname) &&
                Objects.equals(specialization, staff.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, age, proficiency, specialization);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", proficiency=" + proficiency +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
