package _12DefiningClassesEX.CompanyRoster;

public class Employee {

    String name;
    double salary;
    String position;
    String department;
    String email;
    int age;

    public Employee(String name, double salary, String position, String department, String email, int age) {

        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public String getName() {  return this.name; }
    public double getSalary() {  return this.salary; }
    public String getDepartment() {  return this.department; }
    public String getEmail() {  return this.email; }
    public int getAge() { return this.age; }

}

