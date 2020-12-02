package HW135;

import java.util.function.Supplier;

public class Person {
   private String name;
   private double salary;
   private Gender gender;

   public Person(String name, double salary, Gender gender) {
      this.name = name;
      this.salary = salary;

      this.gender = gender;
   }

   public Person() {
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getSalary() {
      return salary;
   }

   public void setSalary(double salary) {
      this.salary = salary;
   }

   public Gender getGender() {
      return gender;
   }

   public void setGender(Gender gender) {
      this.gender = gender;
   }

   public enum Gender{
      MALE,FEMALE;

      Gender() {
      }
   }

   @Override
   public String toString() {
      return "Person{" +
              "name='" + name + '\'' +
              ", salary=" + salary +
              ", gender=" + gender +
              '}';
   }
}
